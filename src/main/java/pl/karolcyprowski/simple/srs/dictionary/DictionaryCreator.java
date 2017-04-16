package pl.karolcyprowski.simple.srs.dictionary;

import java.io.File;

public interface DictionaryCreator {
	
	public boolean isDictionaryEmpty();
	
	public void createDictionaryFromCSV(File file);
}
