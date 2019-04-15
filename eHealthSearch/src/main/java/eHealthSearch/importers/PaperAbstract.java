package eHealthSearch.importers;

import java.util.List;

public interface PaperAbstract {
	public String getTitle();
	public String getContent();
	
	public List<String> authors();
	
	public List<String> tags();
}
