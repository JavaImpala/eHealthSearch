package org.ntnu.torbjoto.eHealthSearch;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ntnu.torbjoto.eHealthSearch.importers.pubmed.GetPubmedPublication;
import org.ntnu.torbjoto.eHealthSearch.model.ArticlesInDB;
import org.ntnu.torbjoto.eHealthSearch.product.article.Publication;
import org.ntnu.torbjoto.eHealthSearch.query.GeneralQuery;
import org.ntnu.torbjoto.eHealthSearch.query.TimeConstraints;

public class EHealthCrawler {
	private static Logger log = LogManager.getLogger(EHealthCrawler.class);
	
	public static void main(String[] args)  {
		
		
		try {
			System.setProperty("javax.xml.accessExternalDTD", "all"); 
			
			/*
			 * Åpner hibernate session
			 */
			log.info("lager sessionFactory ");
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			
			log.info("åpner session");
			Session session=factory.openSession();
			session.beginTransaction();
			
			ArticlesInDB model=new ArticlesInDB(session);
			
	        /*
	         * importerer
	         */
	       
			GeneralQuery query=GeneralQuery.get(TimeConstraints.get());
			log.info("query pubmed");
			
			List<Publication> publications = new GetPubmedPublication().get(query);
			
			/*
			 * Åpner hibernate for å legge inn i database 
			 */
			
			
			for(Publication p:publications) {
				System.out.println(p);
				
				
				if(model.match(p).isPresent()) {
					System.out.println("ingen add! "+model.match(p).get());
				}else {
					//session.save(p);
				}
				
				
				//session.save(p);
			}
			
			session.getTransaction().commit();
			session.close();
	        
	      
		}catch(Exception e) {
			System.out.println(e);
		}
		
    }
}
