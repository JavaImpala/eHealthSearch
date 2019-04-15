package org.ntnu.torbjoto.eHealthSearch.importers.scopus.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ntnu.torbjoto.eHealthSearch.importers.pubmed.paper.meta.PubmedData;
import org.ntnu.torbjoto.eHealthSearch.importers.pubmed.paper.meta.PubmedIdentity;
import org.ntnu.torbjoto.eHealthSearch.importers.scopus.paper.ScopusAuthor;
import org.ntnu.torbjoto.eHealthSearch.importers.scopus.paper.ScopusEntry;
import org.ntnu.torbjoto.eHealthSearch.product.affiliation.Affiliation;
import org.ntnu.torbjoto.eHealthSearch.product.article.Abstract;
import org.ntnu.torbjoto.eHealthSearch.product.article.ArticleId;
import org.ntnu.torbjoto.eHealthSearch.product.article.Publication;
import org.ntnu.torbjoto.eHealthSearch.product.author.Author;
import org.ntnu.torbjoto.eHealthSearch.product.author.PublicationAuthorAffiliation;
import org.ntnu.torbjoto.eHealthSearch.product.keyword.Keyword;
import org.ntnu.torbjoto.eHealthSearch.product.mesh.MeshElement;
import org.ntnu.torbjoto.eHealthSearch.product.mesh.Term;

public class ScopusToDB{
	private SessionFactory factory; 
	
	public ScopusToDB() {
		try {
	         factory = new Configuration().configure().buildSessionFactory();
		  }catch(HibernateException exception){
			  System.out.println("Problem creating session factory");  
			  exception.printStackTrace();
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	}
	
	public void addResultSetToDB(List<ScopusEntry> pubmedArticles) {
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		int count=0;
		
		Map<String,Affiliation> allAffiliations=new HashMap<>(); 
		Map<String,Author> allAuthors=new HashMap<>();
		
		Map<Term,Term> allTerms=new HashMap<>();
		Map<String,MeshElement> allMeshElements=new HashMap<>();
		
		List<Publication> publications=new ArrayList<>();
		
		for(ScopusEntry article:pubmedArticles) {
			
			Publication pub=new Publication();
			
			//article
			
			pub.setTitle(article.getTitle());
			
			
			
			if(article.getKeywords()!=null) {
				
				Collection<Keyword> keyWords=new ArrayList<>();
				
				for(String k:article.getKeywords()) {
					Keyword keyword = new Keyword();
					
					keyword.setText(k);
					keyword.setMajorTopic(false);
					keyword.setArticle(pub);
					
					keyWords.add(keyword);
				}
				
				pub.setKeywords(keyWords);
			}
				
				
			if(article.getDescription()!=null && article.getDescription()!="") {
				Abstract abs=new Abstract();
				abs.setText(article.getDescription());
				pub.setAbs(abs);
			}
					
			if(article.getAuthors()!=null && !article.getAuthors().isEmpty()) {
				
				/*
				 * AUTHORS
				 */
				Set<Author> authors=new HashSet<>();
				
				for(ScopusAuthor author:article.getAuthors()) {
					Author auth=new Author();
					
					auth.setFirstName(author.getSurname());
					auth.setFamilyName(author.getGivenName());
					
					if(allAuthors.containsKey(auth.getFullName())) {
						auth=allAuthors.get(auth.getFullName());
					}else {
						allAuthors.put(auth.getFullName(),auth);
					}
				
					authors.add(auth);
					
				}
				//System.out.println("antall forfattere:"+authors.size());
				pub.setAuthors(authors);
			}
				
			if(article.getDoi()!=null) {
				ArticleId id=new ArticleId();
				id.setArticle(pub);
				id.setIdType("doi");
				id.setId(article.getDoi());
				
				pub.setArticleIds(Arrays.asList(id));
			}
			
			publications.add(pub);
			
		}//end article present
		
		try {
			System.out.println("==========>save "+(count++)+" "+allAuthors.size());
			
			
			for(Publication p:publications) {
				session.save(p);
			}
			
			
			//System.out.println(pub);
			
		}catch(Exception ex) {
			
		}
		
		System.out.println("try to commit");
		session.getTransaction().commit();
		session.close();
		System.out.println("close session");
	}
}
