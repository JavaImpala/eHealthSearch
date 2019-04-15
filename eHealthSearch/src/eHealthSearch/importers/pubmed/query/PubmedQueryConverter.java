package eHealthSearch.importers.pubmed.query;

import java.time.format.DateTimeFormatter;

import eHealthSearch.query.GeneralQuery;
import eHealthSearch.query.TimeConstraints;

public class PubmedQueryConverter {
	public static String convert(GeneralQuery query) {
		String string="https://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=pubmed&term=Norway[AD]&retmax=1000&usehistory=y";
		
		if(query.getTime().isPresent()) {
			TimeConstraints t = query.getTime().get();			
			string=string+"&mindate="+t.getStart().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))+"&maxdate="+t.getStop().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))+"&datetype=pdat";
		}
		
		return string;
	}
}
