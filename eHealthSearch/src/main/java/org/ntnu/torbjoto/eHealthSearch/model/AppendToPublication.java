package org.ntnu.torbjoto.eHealthSearch.model;

import org.ntnu.torbjoto.eHealthSearch.product.article.ArticleId;
import org.ntnu.torbjoto.eHealthSearch.product.article.Publication;
import org.ntnu.torbjoto.eHealthSearch.product.author.Author;

public class AppendToPublication {
	
	public static void appendToPublication(Publication original,Publication current) {
		
		for(Author a:original.getAuthors()) {
			
		}
		
		for(ArticleId i:original.getArticleIds()) {
			
		}
		
		original.getKeywords();
		
		original.getTerms();
		
		
	}
}
