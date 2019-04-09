package eHealthSearch;

import java.util.List;

import eHealthSearch.importers.pubmed.GetPubmedPublication;
import eHealthSearch.importers.pubmed.paper.PubmedRootArticle;

public class EHealthCrawler {
	
	public static void main(String[] args)  {
		
		try {
			
			
			System.setProperty("javax.xml.accessExternalDTD", "all"); 
			
	        // Make a URL to the web page
	       
			List<PubmedRootArticle> pubmedArticles = new GetPubmedPublication().get();
	        
	      
		}catch(Exception e) {
			System.out.println(e);
		}
		
    }
}
