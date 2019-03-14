package eHealthSearch.search.scopus;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import eHealthSearch.TimeTracker;
import eHealthSearch.search.pubmed.paper.PubmedArticleSet;
import eHealthSearch.search.scopus.paper.ScopusEntry;
import eHealthSearch.search.scopus.paper.ScopusSearchResults;

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
		        URL url = new URL("https://api.elsevier.com/content/search/scopus?query=all(gene)&apiKey=7f59af901d2d86f78a1fd60c1bf9426a&view=complete&httpAccept=application/xml");
		        time.time("åpner stream");
		        InputStream input=url.openStream();
		        
		        //JAXB
		       
		        time.time("starterUnmarshal");
		        articles.addAll(((ScopusSearchResults) um.unmarshal(input)).getPublications());
		        
		        time.time("ferdigUnmarshal");
			
			
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
