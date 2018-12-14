package eHealthSearch.crawler.pubmed;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import eHealthSearch.crawler.pubmed.paper.PubmedArticleSet;

public class GetPubmedPublication {
	private JAXBContext context;
	private Unmarshaller um;
	
	public GetPubmedPublication() {
		try {
			this.context=JAXBContext.newInstance(PubmedArticleSet.class);
			this.um= context.createUnmarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PubmedArticleSet get(long id) {
		

		try {
			System.out.println("====================");
			
	        // Make a URL to the web page
	        URL url = new URL("https://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&retmode=xml&id="+id+"&tool=ehelsesok&email=torbjorn.torsvik@ehealthresearch.no");
	  
	        //JAXB
	       
	        System.out.println("forsøker å finne publikasjon ");
	        
	        PubmedArticleSet pubResult = (PubmedArticleSet) um.unmarshal(url);
	       
	        System.out.println(pubResult);
	       
	        
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}
}
