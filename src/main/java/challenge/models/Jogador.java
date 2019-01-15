package challenge.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Jogador {

	private Long id;
	private String name;
	private String fullName;
	private String club;
	private Integer age;
	private LocalDate birthDate;
	private String nationality;
	private BigDecimal eurWage;
	private BigDecimal eurReleaseClause;

	public Jogador(Long id, String name, String fullName, String club, Integer age, LocalDate birthDate, String nationality,
			BigDecimal eurWage, BigDecimal eurReleaseClause) {
		this.id = id;
		this.name = name;
		this.fullName = fullName;
		this.club = club;
		this.age = age;
		this.birthDate = birthDate;
		this.nationality = nationality;
		this.eurWage = eurWage;
		this.eurReleaseClause = eurReleaseClause;
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public String getClub() {
		return club;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", name=" + name + ", fullName=" + fullName + ", club=" + club + ", age=" + age
				+ ", birthDate=" + birthDate + ", nationality=" + nationality + ", eurReleaseClause=" + eurReleaseClause
				+ "]";
	}
	
}
