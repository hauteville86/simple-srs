package pl.karolcyprowski.simple.srs.dictionary.service;

import java.io.File;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.karolcyprowski.simple.srs.dictionary.dao.DictionaryItemDAO;
import pl.karolcyprowski.simple.srs.dictionary.dao.LangcodeDAO;
import pl.karolcyprowski.simple.srs.dictionary.entities.DictionaryItem;
import pl.karolcyprowski.simple.srs.dictionary.entities.Langcode;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	private File sourceFile;
	
	private List<Langcode> langcodes;
	
	@Autowired
	private DictionaryItemDAO dictionaryItemDAO;
	
	@Autowired
	private LangcodeDAO langcodeDAO;

	@Transactional
	public List<DictionaryItem> getItems(String langcode)
	{
		return dictionaryItemDAO.getItems(langcode);
	}
	
	@Transactional
	public List<DictionaryItem> getAllItems()
	{
		return dictionaryItemDAO.getAllItems();
	}
	
	@Transactional
	public DictionaryItem getItem(int id, String langcode)
	{
		return dictionaryItemDAO.getItem(id, langcode);
	}
	
	@Transactional
	public List<DictionaryItem> getItems(int id)
	{
		return dictionaryItemDAO.getItems(id);
	}
	
	@Transactional
	public List<Langcode> getLangcodes()
	{
		if(langcodes == null)
		{
			langcodes = langcodeDAO.getLangcodes();
		}
		return langcodes;		
	}
	
	@Transactional
	public void addItem(DictionaryItem item)
	{
		dictionaryItemDAO.addItem(item);
	}

	public File getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}
	
	
}
