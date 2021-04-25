package challenge;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "scripts")
@AllArgsConstructor
@NoArgsConstructor
public class Quote {

	@Id
	private Integer id;

	private Integer episode;

	private String episodeName;

	private String segment;

	private String type;

	private String actor;

	private String character;

	private String detail;

	private Timestamp recordDate;

	private String series;

	private Timestamp transmissionDate;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActor() {
		return this.actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getQuote() {
		return this.detail;
	}

	public void setQuote(String quote) {
		this.detail = quote;
	}

}
