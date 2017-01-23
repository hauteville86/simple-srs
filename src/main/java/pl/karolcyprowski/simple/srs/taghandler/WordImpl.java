package pl.karolcyprowski.simple.srs.taghandler;

import java.util.List;
import java.util.Map;

public class WordImpl implements Word {
	
	private String lexicalForm;
	private String inSentenceForm;
	private List<Word> synonyms;
	private Map<String, Word> translations;
	private List<String> exampleSentences;
	
	public WordImpl(String base)
	{
		this.inSentenceForm = base;
	}
	
	public Word getTranslation(String languageCode)
	{
		return translations.get(languageCode);
	}
	
	
	public void addTranslation(Word translation, String languageCode) {
		translations.put(languageCode, translation);
	}

	public String getLexicalForm() {
		return lexicalForm;
	}

	public void setLexicalForm(String lexicalForm) {
		this.lexicalForm = lexicalForm;
	}

	public List<Word> getSynonyms() {
		return synonyms;
	}

	public void setSynonyms(List<Word> synonyms) {
		this.synonyms = synonyms;
	}
	
	public boolean isLexicalForm()
	{
		return inSentenceForm.equals(lexicalForm);
	}

	public String getInSentenceForm() {
		return inSentenceForm;
	}

	public void setInSentenceForm(String inSentenceForm) {
		this.inSentenceForm = inSentenceForm;
	}

	public List<String> getExampleSentences() {
		return exampleSentences;
	}
	
	public boolean isNoun()
	{
		return this instanceof Noun;
	}
	
	public boolean isVerb()
	{
		return this instanceof Verb;
	}
	
	public boolean isAdjective()
	{
		return this instanceof Adjective;
	}
}
