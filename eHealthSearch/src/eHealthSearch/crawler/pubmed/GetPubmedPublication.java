package eHealthSearch.crawler.pubmed;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import eHealthSearch.crawler.pubmed.paper.PubmedArticleSet;

public class GetPubmedPublication {
	public static PubmedArticleSet get(long id) {
		

		try {
			System.out.println("====================");
			System.setProperty("javax.xml.accessExternalDTD", "all"); 
	        // Make a URL to the web page
	        URL url = new URL("https://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&retmode=xml&id="+id+"&tool=ehelsesok&email=torbjorn.torsvik@ehealthresearch.no");
	        
	        //leser
	        // create a urlconnection object
	        URLConnection urlConnection = url.openConnection();

	        // wrap the urlconnection in a bufferedreader
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

	        String line;

	        // read from the urlconnection via the bufferedreader
	        while ((line = bufferedReader.readLine()) != null)
	        {
	        	System.out.println(line);
	        }
	        bufferedReader.close();
	        
	        //JAXB
	        JAXBContext context = JAXBContext.newInstance(PubmedArticleSet.class);
	        Unmarshaller um = context.createUnmarshaller();
	       
	        System.out.println("forsøker å finne publikasjon ");
	        
	        PubmedArticleSet pubResult = (PubmedArticleSet) um.unmarshal(url);
	       
	        System.out.println(pubResult);
	       
	        
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}
}
