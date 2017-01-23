package pl.karolcyprowski.simple.srs.taghandler;

import java.util.List;

public interface Word {

	public Word getTranslation(String languageCode);
	
	public void addTranslation(Word translation, String languageCode);

	public String getLexicalForm();

	public void setLexicalForm(String lexicalForm);
	
	public List<Word> getSynonyms();

	public void setSynonyms(List<Word> synonyms);
	
	public boolean isLexicalForm();

	public String getInSentenceForm();

	public void setInSentenceForm(String inSentenceForm);
	
	public List<String> getExampleSentences();
	
	public boolean isNoun();
	
	public boolean isVerb();
	
	public boolean isAdjective();
}
