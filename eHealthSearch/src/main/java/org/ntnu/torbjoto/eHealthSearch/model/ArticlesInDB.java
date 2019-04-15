package org.ntnu.torbjoto.eHealthSearch.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.hibernate.Session;
import org.ntnu.torbjoto.eHealthSearch.product.article.ArticleId;
import org.ntnu.torbjoto.eHealthSearch.product.article.Publication;

public class ArticlesInDB {
	
	public Map<ArticleId,Publication> articleToPublication=new HashMap<>();
	
	public ArticlesInDB(Session session) {
		for(Publication pub:session.createQuery("SELECT p FROM Publication p",Publication.class).getResultList()) {	
			for(ArticleId i:pub.getArticleIds()) {
				articleToPublication.put(i,pub);
			}	
		}
	}
	
	public Optional<Publication> match(Publication pub) {
		for(ArticleId i:pub.getArticleIds()) {
			if(articleToPublication.containsKey(i)) {
				return Optional.of(articleToPublication.get(i));
			}
		}
		
		return Optional.empty();
	}
}