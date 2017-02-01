package pl.karolcyprowski.simple.srs.scheduler.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="SchedulerAction")
public class SchedulerAction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="userid")
	private int userid;
	
	@Column(name="utilityid")
	private int utilityId;
	
	@Column(name="date", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name="action")
	private String action;
	
	@Column(name="time")
	private int time;
	
	public SchedulerAction()
	{
		
	}
	
	public SchedulerAction(int userId, int utilityId, Date date, String action, int time)
	{
		this.userid = userId;
		this.utilityId = utilityId;
		this.date = date;
		this.action = action;
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUtilityId() {
		return utilityId;
	}

	public void setUtilityId(int utilityId) {
		this.utilityId = utilityId;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SchedulerAction [id=");
		builder.append(id);
		builder.append(", userid=");
		builder.append(userid);
		builder.append(", utilityId=");
		builder.append(utilityId);
		builder.append(", date=");
		builder.append(date);
		builder.append(", action=");
		builder.append(action);
		builder.append(", time=");
		builder.append(time);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
