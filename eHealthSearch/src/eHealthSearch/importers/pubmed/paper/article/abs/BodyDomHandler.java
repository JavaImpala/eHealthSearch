package eHealthSearch.importers.pubmed.paper.article.abs;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.annotation.DomHandler;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class BodyDomHandler implements DomHandler<String, StreamResult> {

    private StringWriter xmlWriter = new StringWriter();

    public StreamResult createUnmarshaller(ValidationEventHandler errorHandler) {
    	xmlWriter.getBuffer().setLength(0);
        return new StreamResult(xmlWriter);
    }

    public String getElement(StreamResult rt) {
    	
    	
    	
        String xml = rt.getWriter().toString();
        
        if(xml.contains("<CopyrightInformation>")){
	   		return "";
	   	}else {
	   		return xml.replaceAll("<[^>]+>", "");
	   	} 
    }

    public Source marshal(String n, ValidationEventHandler errorHandler) {
    	
        try {
        	
        	return new StreamSource(new StringReader(n));
        	
           
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}