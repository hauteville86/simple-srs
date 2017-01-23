package pl.karolcyprowski.simple.srs.taghandler;

import java.util.List;

public interface Sentence {

	public List<Word> getListOfWords();

	public void setListOfWords(List<Word> listOfWords);
}
