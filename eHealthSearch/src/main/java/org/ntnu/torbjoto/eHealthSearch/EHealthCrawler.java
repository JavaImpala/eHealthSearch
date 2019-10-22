package org.ntnu.torbjoto.eHealthSearch;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
			
			log.info("ferdig query, legger inn publications size:"+publications.size());
			
			System.out.println("==================");
			
			
			Set<Publication> savedPublications=new HashSet<>();
			
			for(Publication p:publications) {
				
				
				if(model.match(p).isPresent()) {
					log.info("ingen add! "+model.match(p).get());
				}else {
					log.info("save:"+p);
					
					
					session.save(p);
					savedPublications.add(p);
				}
				
				
				//session.save(p);
			}
			
			log.info("before commit");
			
			session.getTransaction().commit();
			session.close();
			System.out.println("avslutter");
	      
		}catch(Exception e) {
			System.out.println(e);
		}
		
    }
}
