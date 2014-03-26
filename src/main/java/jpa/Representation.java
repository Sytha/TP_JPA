package jpa;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="REPRESENTATION")
public class Representation {	
	@Id
	@SequenceGenerator(name="representation_seq",sequenceName="representation_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="representation_seq")
	private Long id;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_representation;
	
	@Column
	private String artiste;
	
	@ManyToOne
	@JoinColumn(name = "ID")
	private Spectacle spectacle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate_representation() {
		return date_representation;
	}

	public void setDate_representation(Date date_representation) {
		this.date_representation = date_representation;
	}

	public String getArtiste() {
		return artiste;
	}

	public void setArtiste(String artiste) {
		this.artiste = artiste;
	}

	public Spectacle getSpectacle() {
		return spectacle;
	}

	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}
	
	
	
}