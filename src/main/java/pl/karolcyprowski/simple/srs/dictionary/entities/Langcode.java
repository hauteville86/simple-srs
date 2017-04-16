package pl.karolcyprowski.simple.srs.dictionary.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="langcode")
public class Langcode {

	@Id
	@Column(name="langcode")
	private String langcode;
	
	@Column(name="langname")
	private String langname;
	
	public Langcode(){
		
	}

	public Langcode(String langcode, String langname) {
		super();
		this.langcode = langcode;
		this.langname = langname;
	}

	public String getLangcode() {
		return langcode;
	}

	public void setLangcode(String langcode) {
		this.langcode = langcode;
	}

	public String getLangname() {
		return langname;
	}

	public void setLangname(String langname) {
		this.langname = langname;
	}
	
	
}
