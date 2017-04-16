package pl.karolcyprowski.simple.srs.dictionary.dao;

import java.util.List;

import pl.karolcyprowski.simple.srs.dictionary.entities.DictionaryItem;

public interface DictionaryItemDAO {
	
	public List<DictionaryItem> getItems(String langcode);
	
	public List<DictionaryItem> getAllItems();
	
	public DictionaryItem getItem(int id, String langcode);
	
	public List<DictionaryItem> getItems(int id);

	public void addItem(DictionaryItem item);

}
