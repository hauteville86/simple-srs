package pl.karolcyprowski.simple.srs.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sentence")
public class Sentence {

	@Id
	private int id;
}
