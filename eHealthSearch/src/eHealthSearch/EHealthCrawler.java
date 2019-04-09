package eHealthSearch;

import eHealthSearch.importers.scopus.GetScopusPublication;

public class EHealthCrawler {
	
	public static void main(String[] args)  {
		
		try {
			System.setProperty("javax.xml.accessExternalDTD", "all"); 
			
	        // Make a URL to the web page
	       
			new GetScopusPublication().get("dumy");
	        
	      
		}catch(Exception e) {
			System.out.println(e);
		}
		
    }
}
