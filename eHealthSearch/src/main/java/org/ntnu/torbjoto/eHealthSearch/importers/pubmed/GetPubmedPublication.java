package org.ntnu.torbjoto.eHealthSearch.importers.pubmed;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ntnu.torbjoto.eHealthSearch.EHealthCrawler;
import org.ntnu.torbjoto.eHealthSearch.TimeTracker;
import org.ntnu.torbjoto.eHealthSearch.importers.pubmed.db.PubMedConverter;
import org.ntnu.torbjoto.eHealthSearch.importers.pubmed.db.PubmedToDB;
import org.ntnu.torbjoto.eHealthSearch.importers.pubmed.paper.PubmedArticleSet;
import org.ntnu.torbjoto.eHealthSearch.importers.pubmed.paper.PubmedRootArticle;
import org.ntnu.torbjoto.eHealthSearch.importers.pubmed.query.PubmedQueryConverter;
import org.ntnu.torbjoto.eHealthSearch.importers.pubmed.search.Id;
import org.ntnu.torbjoto.eHealthSearch.importers.pubmed.search.PubMedIdSearch;
import org.ntnu.torbjoto.eHealthSearch.product.article.Publication;
import org.ntnu.torbjoto.eHealthSearch.query.GeneralQuery;

public class GetPubmedPublication {
	private JAXBContext context;
	private Unmarshaller um;
	private TimeTracker time=new TimeTracker();
	
	private static Logger log = LogManager.getLogger(GetPubmedPublication.class);
	
	public GetPubmedPublication() {
		try {
			
			this.context=JAXBContext.newInstance(PubmedArticleSet.class);
			log.info("åpner session");
			this.um= context.createUnmarshaller();
			log.info("lager unmarshaller");
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
			
			if(!currentList.isEmpty()) {
				subLists.add(currentList);
			}
			
			
			
			
			for(List<Long> subList:subLists) {
				
				
				log.info("behandler sublist med "+subList+" entries");
				
				String ids=subList.stream()
						.map(i->i.toString())
						.collect(Collectors.joining(","));
				
		        // Make a URL to the web page
		        URL url2 = new URL("https://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&retmode=xml&id="+ids+"&tool=ehelsesok&email=torbjorn.torsvik@ehealthresearch.no");
		        time.time("åpner stream");
		        InputStream input=url2.openStream();
		        
		        //JAXB
		        JAXBContext context2 = JAXBContext.newInstance(PubmedArticleSet.class);
		        Unmarshaller um2 = context2.createUnmarshaller();
		       
		        log.info("starterUnmarshal");
		        articles.addAll(((PubmedArticleSet) um2.unmarshal(input)).getPublications());
		        
		        log.info("ferdigUnmarshal");
			}
	        
		}catch(IOException  e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return PubMedConverter.convert(articles);
	}
}
