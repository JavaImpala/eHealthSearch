package eHealthSearch.crawler.pubmed;

import java.io.InputStream;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import eHealthSearch.TimeTracker;
import eHealthSearch.crawler.pubmed.paper.PubmedArticleSet;

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
	
	public PubmedArticleSet get(long id) {
		

		try {
			System.out.println("====================");
			
	        // Make a URL to the web page
	        URL url = new URL("https://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&retmode=xml&id="+id+"&tool=ehelsesok&email=torbjorn.torsvik@ehealthresearch.no");
	        time.time("åpner stream");
	        InputStream input=url.openStream();
	        
	        //JAXB
	       
	        time.time("starterUnmarshal");
	        PubmedArticleSet pubResult = (PubmedArticleSet) um.unmarshal(input);
	        time.time("ferdigUnmarshal");
	        
	        System.out.println(pubResult);
	       
	        
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}
}
