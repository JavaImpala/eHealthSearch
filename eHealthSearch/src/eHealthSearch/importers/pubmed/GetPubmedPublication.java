package eHealthSearch.importers.pubmed;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import eHealthSearch.TimeTracker;
import eHealthSearch.importers.pubmed.db.PubMedConverter;
import eHealthSearch.importers.pubmed.db.PubmedToDB;
import eHealthSearch.importers.pubmed.paper.PubmedArticleSet;
import eHealthSearch.importers.pubmed.paper.PubmedRootArticle;
import eHealthSearch.importers.pubmed.query.PubmedQueryConverter;
import eHealthSearch.importers.pubmed.search.Id;
import eHealthSearch.importers.pubmed.search.PubMedIdSearch;
import eHealthSearch.product.article.Publication;
import eHealthSearch.query.GeneralQuery;

public class GetPubmedPublication {
	private JAXBContext context;
	private Unmarshaller um;
	private TimeTracker time=new TimeTracker();
	
	public GetPubmedPublication() {
		try {
			time.time("start");
			this.context=JAXBContext.newInstance(PubmedArticleSet.class);
			time.time("lagetContext");
			this.um= context.createUnmarshaller();
			time.time("lagetUnmarshaller");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Publication> get(GeneralQuery query) {
		
		List<PubmedRootArticle> articles=new ArrayList<>();
		
		try {
	        URL url = new URL(PubmedQueryConverter.convert(query));
	        
	        JAXBContext context = JAXBContext.newInstance(PubMedIdSearch.class);
	        Unmarshaller um = context.createUnmarshaller();
	        PubMedIdSearch pubSearch = (PubMedIdSearch) um.unmarshal(url);
	       
	        List<Id> list = pubSearch.getIds();
	        
	        GetPubmedPublication getter=new GetPubmedPublication();

	        List<Long> idCollection=list.stream().map(i->i.getId()).collect(Collectors.toList());
			
			List<List<Long>> subLists=new ArrayList<>();
			int subListSize=400;
			
			List<Long> currentList=new ArrayList<>();
			int count=1;
			
			for(long id:idCollection) {
				
				currentList.add(id);
				
				if(count%subListSize==0) {
					subLists.add(currentList);
					currentList=new ArrayList<>();
					
				}
				
				count++;
			}
			
			subLists.add(currentList);
			
			
			
			for(List<Long> subList:subLists) {
				
				
				System.out.println("===================="+subList);
				
				String ids=subList.stream()
						.map(i->i.toString())
						.collect(Collectors.joining(","));
				
		        // Make a URL to the web page
		        URL url2 = new URL("https://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&retmode=xml&id="+ids+"&tool=ehelsesok&email=torbjorn.torsvik@ehealthresearch.no");
		        time.time("�pner stream");
		        InputStream input=url2.openStream();
		        
		        //JAXB
		        JAXBContext context2 = JAXBContext.newInstance(PubmedArticleSet.class);
		        Unmarshaller um2 = context2.createUnmarshaller();
		       
		        time.time("starterUnmarshal");
		        articles.addAll(((PubmedArticleSet) um2.unmarshal(input)).getPublications());
		        
		        time.time("ferdigUnmarshal");
			}
			
			PubmedToDB db = new PubmedToDB();
			db.addResultSetToDB(articles);
			
	        
		}catch(IOException  e) {
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return PubMedConverter.convert(articles);
	}
}