package pl.karolcyprowski.simple.srs.taghandler;

import java.util.LinkedList;
import java.util.List;

public class SentenceImpl implements Sentence {
	
	private Sentence translation;
	private List<Word> listOfWords;
	
	public SentenceImpl(String sentenceAsString, Sentence translation)
	{
		this.listOfWords = divideStringIntoListOfWords(sentenceAsString);
		this.translation = translation;
	}

	public List<Word> getListOfWords() {
		return listOfWords;
	}

	public void setListOfWords(List<Word> listOfWords) {
		this.listOfWords = listOfWords;
	}

	public Sentence getTranslation() {
		return translation;
	}

	public void setTranslation(Sentence translation) {
		this.translation = translation;
	}
	
	private List<Word> divideStringIntoListOfWords(String string)
	{
		List<Word> listOfWords = new LinkedList<Word>();
		String[] strings = string.split(" ");
		if(strings != null)
		{
			for(int i = 0; i< strings.length; i++)
			{
				String wordAsString = strings[i];
				Word word = new WordImpl(wordAsString);
				listOfWords.add(word);
			}			
		}
		return listOfWords;
	}
	
	
}
