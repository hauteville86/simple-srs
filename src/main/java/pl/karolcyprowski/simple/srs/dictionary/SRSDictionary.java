package pl.karolcyprowski.simple.srs.dictionary;

import java.util.List;

import pl.karolcyprowski.simple.srs.dictionary.entities.Langcode;

public interface SRSDictionary {

	public String getLanguageOne();

	public void setLanguageOne(String languageOne);

	public String getLanguageTwo();

	public void setLanguageTwo(String languageTwo);
	
	public List<Langcode> getLangcodes();

	public void setLangcodes(List<Langcode> langcodes);
	
}
