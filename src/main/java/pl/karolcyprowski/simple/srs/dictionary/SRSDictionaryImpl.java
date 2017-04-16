package pl.karolcyprowski.simple.srs.dictionary;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pl.karolcyprowski.simple.srs.dictionary.entities.Langcode;
import pl.karolcyprowski.simple.srs.dictionary.service.DictionaryService;

public class SRSDictionaryImpl implements SRSDictionary {
	
	@Autowired
	private DictionaryService dictionaryService;
	
	private List<Langcode> langcodes;
	private String languageOne;
	private String languageTwo;
	
	public SRSDictionaryImpl()
	{
		
	}

	public String getLanguageOne() {
		return languageOne;
	}

	public void setLanguageOne(String languageOne) {
		this.languageOne = languageOne;
	}

	public String getLanguageTwo() {
		return languageTwo;
	}

	public void setLanguageTwo(String languageTwo) {
		this.languageTwo = languageTwo;
	}

	public List<Langcode> getLangcodes() {
		if(langcodes == null)
		{
			langcodes = dictionaryService.getLangcodes();
		}
		return langcodes;
	}

	public void setLangcodes(List<Langcode> langcodes) {
		this.langcodes = langcodes;
	}
	
	
}
