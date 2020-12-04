package org.ntnu.torbjoto.eHealthSearch;

import java.util.Iterator;
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
	private static Logger log = LogManager.getRootLogger();
	
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
			
			System.out.println("ferdig query, legger inn publications size:"+publications.size());
			
			//System.out.println("==================");
			
			Iterator<Publication> iterator=publications.iterator();
			
			int count=0;
			
			outer:
			while(true) {		
				for(int i=0;i<1000;i++) {
					
					if(iterator.hasNext()) {
						Publication p = iterator.next();
						
						if(model.match(p).isPresent()) {
							log.info("ingen add! "+model.match(p).get());
						}else {
							System.out.println("save:"+count+" "+p);
							
							session.save(p);
						}
						
						iterator.remove();
						
						count++;
					}else {
						
						break outer;
					}
					
					
				}
				
				//session.flush();
				//session.clear();
			}
			
			
			
			System.out.println("before commit");
			
			session.getTransaction().commit();
			session.close();
			System.out.println("avslutter");
	      
		}catch(Exception e) {
			System.out.println(e);
		}
		
    }
}
