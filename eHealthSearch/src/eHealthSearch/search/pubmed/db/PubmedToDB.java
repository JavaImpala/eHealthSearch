package eHealthSearch.search.pubmed.db;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import eHealthSearch.product.affiliation.Affiliation;
import eHealthSearch.product.article.Abstract;
import eHealthSearch.product.article.Publication;
import eHealthSearch.product.author.Author;
import eHealthSearch.search.pubmed.paper.PubmedArticleSet;
import eHealthSearch.search.pubmed.paper.PubmedMedlineCitation;
import eHealthSearch.search.pubmed.paper.PubmedRootArticle;
import eHealthSearch.search.pubmed.paper.article.PubmedAuthor;

public class PubmedToDB {
	private SessionFactory factory; 
	
	public PubmedToDB() {
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
	
	public void addResultSetToDB(PubmedArticleSet pubmedArticles) {
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		for(PubmedRootArticle article:pubmedArticles.getPublications()) {
			
			Publication pub=new Publication();
			
			//article
			PubmedMedlineCitation cit = article.getMedlineCitation();
			
			if(cit!=null) {
				if(cit.getArticle()!=null) {
					if(cit.getArticle().getPaperAbstract()!=null) {
						Abstract abs=new Abstract();
						abs.setText(cit.getArticle().getPaperAbstract().getText());
						
						pub.setAbs(abs);
					}
					
					if(cit.getArticle().getAuthors()!=null) {
						
						List<Author> authors=new ArrayList<>();
						
						for(PubmedAuthor author:cit.getArticle().getAuthors()) {
							Author auth=new Author();
							
							auth.setFirstName(author.getForeName());
							auth.setFamilyName(author.getLastName());
							
							authors.add(auth);
							
							if(author.getAffiliations()!=null && author.getAffiliations().getAffiliation()!=null) {
								List<Affiliation> affs=new ArrayList<>(); 
								
								throw new IllegalStateException("kommer vi hit?");
								/*
								for(String aff:author.getAffiliations().getAffiliation()) {
									
									System.out.println("======================================>"+aff);
									System.out.println("======================================>"+aff);
									System.out.println("======================================>"+aff);
									System.out.println("======================================>"+aff);
									
									Affiliation a=new Affiliation();
									a.setName(aff);
									affs.add(a);
								}
								
								auth.setAffiliations(affs);	
								*/
							}
						}
						
						pub.setAuthors(authors);
					}
				}
			}
			
			try {
				System.out.println("==========>save");
				session.save(pub);
			}catch(Exception ex) {
				System.out.println("var  det her? "+ex);
			}
		}
		
		session.getTransaction().commit();
		session.close();
	}
}
