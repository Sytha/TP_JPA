package jpa;


import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="SPECTACLE")
public class Spectacle {	
	@Id
	@SequenceGenerator(name="spectacle_seq",sequenceName="spectacle_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="spectacle_seq")
	private Long id;
	
	@Column
	private String titre;
	
	@Column
	private String artiste;
	
	@Column(name="TYPE")
	@Enumerated(EnumType.STRING)
	private TypeSpectacle type;
	
	@OneToMany(mappedBy = "spectacle")
	private Set<Representation> representations ;
	
	public String getTitre(){
		return titre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArtiste() {
		return artiste;
	}

	public void setArtiste(String artiste) {
		this.artiste = artiste;
	}

	public TypeSpectacle getType() {
		return type;
	}

	public void setType(TypeSpectacle type) {
		this.type = type;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
}
