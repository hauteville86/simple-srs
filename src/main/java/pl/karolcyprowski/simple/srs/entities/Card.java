package pl.karolcyprowski.simple.srs.entities;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="card")
public class Card {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="deckid")
	private int deckId;
	
	@Column(name="srs_status")
	private int srsStatus;
	
	@Column(name="front")
	private String front;
	
	@Column(name="back")
	private String back;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="created", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	
	@Column(name="lastUpdated", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdated;
	
	@Column(name="nextRepeat", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date nextRepeat;
	
	public Card()
	{
		created = new Date();
		nextRepeat = new Date();
	}

	public Card(int deckId, int srsStatus, String front, String back, String comment, Date created, Date lastUpdated,
			Date nextRepeat) {
		super();
		this.deckId = deckId;
		this.srsStatus = srsStatus;
		this.front = front;
		this.back = back;
		this.comment = comment;
		this.created = created;
		this.lastUpdated = lastUpdated;
		this.nextRepeat = nextRepeat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeckId() {
		return deckId;
	}

	public void setDeckId(int deckId) {
		this.deckId = deckId;
	}

	public int getSrsStatus() {
		return srsStatus;
	}

	public void setSrsStatus(int srsStatus) {
		this.srsStatus = srsStatus;
	}

	public String getFront() {
		return front;
	}

	public void setFront(String front) {
		this.front = front;
	}

	public String getBack() {
		return back;
	}

	public void setBack(String back) {
		this.back = back;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Date getNextRepeat() {
		return nextRepeat;
	}

	public void setNextRepeat(Date nextRepeat) {
		this.nextRepeat = nextRepeat;
	}

	public void changeWithMap(Map<String, Object> valuesToUpdate) {
		if(valuesToUpdate.get("mode").equals("review"))
		{
			int newSrsStatus = (Integer)(valuesToUpdate.get("srsStatus"));
			this.setSrsStatus(newSrsStatus);
			Date newLastUpdate = (Date)valuesToUpdate.get("lastUpdate");
			this.setLastUpdated(newLastUpdate);
			Date newNextRepeat = (Date)valuesToUpdate.get("nextRepeat");
			this.setNextRepeat(newNextRepeat);
		}
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card [id=");
		builder.append(id);
		builder.append(", deckId=");
		builder.append(deckId);
		builder.append(", srsStatus=");
		builder.append(srsStatus);
		builder.append(", front=");
		builder.append(front);
		builder.append(", back=");
		builder.append(back);
		builder.append(", comment=");
		builder.append(comment);
		builder.append(", created=");
		builder.append(created);
		builder.append(", lastUpdated=");
		builder.append(lastUpdated);
		builder.append(", nextRepeat=");
		builder.append(nextRepeat);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
