package org.ntnu.torbjoto.eHealthSearch.importers.scopus;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.ntnu.torbjoto.eHealthSearch.TimeTracker;
import org.ntnu.torbjoto.eHealthSearch.importers.pubmed.paper.PubmedArticleSet;
import org.ntnu.torbjoto.eHealthSearch.importers.scopus.paper.ScopusEntry;
import org.ntnu.torbjoto.eHealthSearch.importers.scopus.paper.ScopusSearchResults;

public class GetScopusPublication {
	private JAXBContext context;
	private Unmarshaller um;
	private TimeTracker time=new TimeTracker();
	
	public GetScopusPublication() {
		try {
			time.time("start");
			this.context=JAXBContext.newInstance(ScopusSearchResults.class);
			time.time("lagetContext");
			this.um= context.createUnmarshaller();
			time.time("lagetUnmarshaller");
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PubmedArticleSet get(String searchString) {
		
		try {

			
				
				System.out.println("====================");
				List<ScopusEntry> articles=new ArrayList<>();
				
		        // Make a URL to the web page
				File initialFile = new File("src/scopus_full.xml");
				InputStream input = new FileInputStream(initialFile);
		        
		        //JAXB
		       
		        time.time("starterUnmarshal");
		        articles.addAll(((ScopusSearchResults) um.unmarshal(input)).getPublications());
		        
		        time.time("ferdigUnmarshal");
		        
		        
		        for(ScopusEntry article:articles) {
		        	System.out.println(article);
		        }
			
			
			//PubmedToDB db = new PubmedToDB();
			//db.addResultSetToDB(articles);
			
	        
		}catch(IOException  e) {
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
}
