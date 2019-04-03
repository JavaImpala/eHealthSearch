package eHealthSearch.search.pubmed.db;

import java.util.ArrayList;
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

import eHealthSearch.product.affiliation.Affiliation;
import eHealthSearch.product.article.Abstract;
import eHealthSearch.product.article.ArticleId;
import eHealthSearch.product.article.Publication;
import eHealthSearch.product.author.Author;
import eHealthSearch.product.author.PublicationAuthorAffiliation;
import eHealthSearch.product.keyword.Keyword;
import eHealthSearch.product.mesh.MeshElement;
import eHealthSearch.product.mesh.Term;
import eHealthSearch.search.pubmed.paper.PubmedMedlineCitation;
import eHealthSearch.search.pubmed.paper.PubmedRootArticle;
import eHealthSearch.search.pubmed.paper.article.PubmedAuthor;
import eHealthSearch.search.pubmed.paper.article.keyword.PubmedKeyword;
import eHealthSearch.search.pubmed.paper.article.mesh.PubmedMesh;
import eHealthSearch.search.pubmed.paper.article.mesh.PubmedMeshQualifier;
import eHealthSearch.search.pubmed.paper.meta.PubmedData;
import eHealthSearch.search.pubmed.paper.meta.PubmedIdentity;

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
	
	public void addResultSetToDB(List<PubmedRootArticle> pubmedArticles) {
		
		Session session=factory.openSession();
		session.beginTransaction();
		
		int count=0;
		
		Map<String,Affiliation> allAffiliations=new HashMap<>(); 
		Map<String,Author> allAuthors=new HashMap<>();
		
		Map<Term,Term> allTerms=new HashMap<>();
		Map<String,MeshElement> allMeshElements=new HashMap<>();
		
		List<Publication> publications=new ArrayList<>();
		
		for(PubmedRootArticle article:pubmedArticles) {
			
			Publication pub=new Publication();
			
			article.getMedlineCitation().getArticle().getPublicationType();
			
			//article
			PubmedMedlineCitation cit = article.getMedlineCitation();
			
			pub.setTitle(cit.getArticle().getTitle());
			
			
			if(cit!=null) {
				if(cit.getKeyWords()!=null) {
					
					Collection<Keyword> keyWords=new ArrayList<>();
					
					for(PubmedKeyword k:cit.getKeyWords()) {
						Keyword keyword = new Keyword();
						
						keyword.setText(k.getText());
						keyword.setMajorTopic(k.getTopic().equals("Y"));
						keyword.setArticle(pub);
						
						keyWords.add(keyword);
					}
					
					pub.setKeywords(keyWords);
				}
				
				if(cit.getArticle()!=null) {
					if(cit.getArticle().getPaperAbstract()!=null) {
						
						
						Abstract abs=new Abstract();
						
						StringBuilder text=new StringBuilder();
						
						for(String t:cit.getArticle().getPaperAbstract().getText()){
							text.append(t);
							System.out.println(t);
						}
						
						abs.setText(text.toString());
						
						pub.setAbs(abs);
					}
					
					if(cit.getArticle().getAuthors()!=null) {
						
						/*
						 * AUTHORS
						 */
						Set<Author> authors=new HashSet<>();
						
						for(PubmedAuthor author:cit.getArticle().getAuthors()) {
							Author auth=new Author();
							
							auth.setFirstName(author.getForeName());
							auth.setFamilyName(author.getLastName());
							
							if(allAuthors.containsKey(auth.getFullName())) {
								auth=allAuthors.get(auth.getFullName());
							}else {
								allAuthors.put(auth.getFullName(),auth);
							}
						
							if(author.getAffiliations() !=null) {
								List<PublicationAuthorAffiliation> publicationAffiliations=new ArrayList<>(); 
								
								for(String aff:author.getAffiliations()) {
									Affiliation a=new Affiliation();
									
									if(!allAffiliations.containsKey(a.getName())) {
										a.setName(aff);
										allAffiliations.put(aff,a);
									}else {
										a=allAffiliations.get(aff);
									}
									
									PublicationAuthorAffiliation pubAffiliation=new PublicationAuthorAffiliation();
									
									pubAffiliation.setAffiliation(a);
									pubAffiliation.setAuthor(auth);
									pubAffiliation.setPublication(pub);
									
									publicationAffiliations.add(pubAffiliation);
								}
								
								auth.addPublicationAffiliations(publicationAffiliations);	
								
							}
							
							authors.add(auth);
							
						}
						//System.out.println("antall forfattere:"+authors.size());
						pub.setAuthors(authors);
					}

					/*
					 * MESH
					 */
					
					if(cit.getMeshTerms()!=null) {
						Set<Term> terms=new HashSet<>();
						
						for(PubmedMesh m:cit.getMeshTerms()) {
							
							Term term=new Term();
							
							MeshElement descriptor=new MeshElement();
							
							descriptor.setValue(m.getDescriptorVal().getValue());
							descriptor.setUi(m.getDescriptorVal().getUi());
							
							if(allMeshElements.containsKey(descriptor.getUi())) {
								descriptor=allMeshElements.get(descriptor.getUi());
							}else {
								allMeshElements.put(descriptor.getUi(),descriptor);
							}
							
							term.setDescriptor(descriptor);
							
							if(m.getQualifierVal()!=null) {
								List<MeshElement> qualifiers=new ArrayList<>();
								
								for(PubmedMeshQualifier q:m.getQualifierVal()) {
									MeshElement qualifier=new MeshElement();
									qualifier.setValue(q.getValue());
									qualifier.setUi(q.getUi());
									
									if(allMeshElements.containsKey(qualifier.getUi())) {
										qualifier=allMeshElements.get(qualifier.getUi());
									}else {
										allMeshElements.put(qualifier.getUi(),qualifier);
									}
									
									qualifiers.add(qualifier);
								}
								
								term.setQualifiers(qualifiers);	
							}
							
							if(allTerms.containsKey(term)) {
								//System.out.println("duplicate term "+term);
								term=allTerms.get(term);
							}
							
							terms.add(term);
						}
						
						pub.setTerms(terms);
					}//end mesh
					
					
					
				}
			}//end article present
			
			if(article.getMeta()!=null) {
				PubmedData meta = article.getMeta();
				
				if(meta.getIds()!=null) {
					ArrayList<ArticleId> ids=new ArrayList<>();
					
					for(PubmedIdentity i:meta.getIds()) {
						//System.out.println(i);
						ArticleId id=new ArticleId();
						id.setId(i.getId());
						id.setIdType(i.getIdType());
						id.setArticle(pub);
						
						ids.add(id);
					}
					
					//pub.setCitIds(ids);
				}
			}
			
			publications.add(pub);
			
		}
		
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
