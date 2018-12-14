package eHealthSearch;

import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import eHealthSearch.crawler.pubmed.GetPubmedPublication;
import eHealthSearch.crawler.pubmed.search.Id;
import eHealthSearch.crawler.pubmed.search.PubMedIdSearch;

public class EHealthCrawler {
	
	public static void main(String[] args)  {
		
		try {
			System.setProperty("javax.xml.accessExternalDTD", "all"); 
			
	        // Make a URL to the web page
	        URL url = new URL("https://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=pmc&term=eye");
	        JAXBContext context = JAXBContext.newInstance(PubMedIdSearch.class);
	        Unmarshaller um = context.createUnmarshaller();
	       
	        PubMedIdSearch pubSearch = (PubMedIdSearch) um.unmarshal(url);
	       
	        List<Id> list = pubSearch.getIds();
	        
	        System.out.println(list.size()+" resultater");
	        
	        GetPubmedPublication getter=new GetPubmedPublication();
	        
	        for (Id id : list) {
	        	getter.get(id.getId());
	        }
		}catch(Exception e) {
			System.out.println(e);
		}
		
    }
}
