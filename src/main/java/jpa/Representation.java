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
	
	@Column(name = "DATE_REPRESENTATION")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRepresentation;
	
	
	@ManyToOne
	@JoinColumn(name = "ID_SPECTACLE")
	private Spectacle spectacle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate_representation() {
		return dateRepresentation;
	}

	public void setDate_representation(Date dateRepresentation) {
		this.dateRepresentation = dateRepresentation;
	}



	public Spectacle getSpectacle() {
		return spectacle;
	}

	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}
	
	
	
}