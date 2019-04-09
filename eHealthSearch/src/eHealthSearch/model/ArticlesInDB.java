package eHealthSearch.model;

import java.util.HashMap;
import java.util.Map;

import eHealthSearch.product.article.ArticleId;
import eHealthSearch.product.article.Publication;

public class ArticlesInDB {
	
	public Map<ArticleId,Publication> articleToPublication=new HashMap<>();
	
	public ArticlesInDB() {
		
	}
	
	
}
