package eHealthSearch.search;

import java.util.List;

public interface PaperAbstract {
	public String getTitle();
	public String getContent();
	
	public List<String> authors();
	
	public List<String> tags();
}
