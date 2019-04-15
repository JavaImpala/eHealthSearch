package eHealthSearch;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import eHealthSearch.importers.pubmed.GetPubmedPublication;
import eHealthSearch.model.ArticlesInDB;
import eHealthSearch.product.article.Publication;
import eHealthSearch.query.GeneralQuery;
import eHealthSearch.query.TimeConstraints;

public class EHealthCrawler {
	
	public static void main(String[] args)  {
		
		try {
			
			
			System.setProperty("javax.xml.accessExternalDTD", "all"); 
			
			/*
			 * Åpner hibernate session
			 */
			
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			
			Session session=factory.openSession();
			session.beginTransaction();
			
			ArticlesInDB model=new ArticlesInDB(session);
			
	        /*
	         * importerer
	         */
	       
			GeneralQuery query=GeneralQuery.get(TimeConstraints.get());
			
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
