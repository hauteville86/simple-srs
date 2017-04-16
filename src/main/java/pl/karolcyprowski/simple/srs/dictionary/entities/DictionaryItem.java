package pl.karolcyprowski.simple.srs.dictionary.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dictionary")
public class DictionaryItem implements Serializable{
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="word")
	private String word;
	
	@Id
	@Column(name="langcode")
	private String langcode;
	
	public DictionaryItem(){
		
	}

	public DictionaryItem(int id, String word, String langcode) {
		super();
		this.id = id;
		this.word = word;
		this.langcode = langcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getLangcode() {
		return langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}
}
