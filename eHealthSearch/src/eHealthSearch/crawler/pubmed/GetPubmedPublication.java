package eHealthSearch.crawler.pubmed;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.stream.Collectors;

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
	
	public PubmedArticleSet get(Collection<Long> idCollection) {
		

		try {
			System.out.println("====================");
			
			String ids=idCollection.stream()
					.map(i->i.toString())
					.collect(Collectors.joining(","));
			
	        // Make a URL to the web page
	        URL url = new URL("https://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi?db=pubmed&retmode=xml&id="+ids+"&tool=ehelsesok&email=torbjorn.torsvik@ehealthresearch.no");
	        time.time("åpner stream");
	        InputStream input=url.openStream();
	        
	        //JAXB
	       
	        time.time("starterUnmarshal");
	        PubmedArticleSet pubResult = (PubmedArticleSet) um.unmarshal(input);
	        time.time("ferdigUnmarshal");
	        
		}catch(IOException  e) {
			e.printStackTrace();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return null;
	}
}
