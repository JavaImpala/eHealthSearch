package eHealthSearch.importers.pubmed.db;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import eHealthSearch.importers.pubmed.paper.PubmedMedlineCitation;
import eHealthSearch.importers.pubmed.paper.PubmedRootArticle;
import eHealthSearch.importers.pubmed.paper.article.PubmedAuthor;
import eHealthSearch.importers.pubmed.paper.article.keyword.PubmedKeyword;
import eHealthSearch.importers.pubmed.paper.article.mesh.PubmedMesh;
import eHealthSearch.importers.pubmed.paper.article.mesh.PubmedMeshQualifier;
import eHealthSearch.importers.pubmed.paper.meta.PubmedData;
import eHealthSearch.importers.pubmed.paper.meta.PubmedIdentity;
import eHealthSearch.product.affiliation.Affiliation;
import eHealthSearch.product.article.Abstract;
import eHealthSearch.product.article.ArticleId;
import eHealthSearch.product.article.Publication;
import eHealthSearch.product.author.Author;
import eHealthSearch.product.author.PublicationAuthorAffiliation;
import eHealthSearch.product.keyword.Keyword;
import eHealthSearch.product.mesh.MeshElement;
import eHealthSearch.product.mesh.Term;

public class PubMedConverter {
	
	
	public static List<Publication> convert(List<PubmedRootArticle> pubmedArticles) {
	
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
						ArticleId id=new ArticleId();
						id.setId(i.getId());
						id.setIdType(i.getIdType());
						id.setArticle(pub);
						
						ids.add(id);
					}
					
					pub.setArticleIds(ids);
				}
			}
			
			publications.add(pub);
			
		}
		
		return publications;
	}
}