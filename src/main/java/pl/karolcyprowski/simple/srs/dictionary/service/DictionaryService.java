package pl.karolcyprowski.simple.srs.dictionary.service;

import java.io.File;
import java.util.List;

import pl.karolcyprowski.simple.srs.dictionary.entities.DictionaryItem;
import pl.karolcyprowski.simple.srs.dictionary.entities.Langcode;

public interface DictionaryService {
	
	/**
	 * Set source .csv file for dictionary setup if database is empty.
	 */
	public void setSourceFile(File file);
	
	/**
	 * Get source .csv file for dictionary setup if database is empty.
	 */
	public File getSourceFile();

	public List<DictionaryItem> getItems(String langcode);
	
	public List<DictionaryItem> getAllItems();
	
	public DictionaryItem getItem(int id, String langcode);
	
	public List<DictionaryItem> getItems(int id);
	
	public void addItem(DictionaryItem item);
	
	public List<Langcode> getLangcodes();
}
