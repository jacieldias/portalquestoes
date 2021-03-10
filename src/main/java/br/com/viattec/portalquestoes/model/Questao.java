package br.com.viattec.portalquestoes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="questao")
public class Questao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questao_id")
	@SequenceGenerator(name = "questao_id", sequenceName = "questao_seq", allocationSize = 1)
	private Long id;
	
	@NotBlank
	@Column(unique=true)
	@Size(min = 3, message = "O enunciado da questão deve ter no mínimo 3 caracteres")
	private String enunciado;
	
	@ManyToOne
	@JoinColumn(name="disciplina")
	private Disciplina disciplina;
	
	@ManyToOne
	@JoinColumn(name="assunto")
	private Assunto assunto;
	
	@ManyToOne
	@JoinColumn(name="bancaorganizadora")
	private BancaOrganizadora bancaOrganizadora;
	
	@ManyToOne
	@JoinColumn(name="instituicao")
	private Instituicao instituicao;
	
	
	@ManyToOne
	@JoinColumn(name="cargo")
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name="nivel")
	private NivelDeDificuldade nivelDeDificuldade;
	
	private int ano;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipoquestao")
	private TipoQuestao tipoQuestao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public BancaOrganizadora getBancaOrganizadora() {
		return bancaOrganizadora;
	}

	public void setBancaOrganizadora(BancaOrganizadora bancaOrganizadora) {
		this.bancaOrganizadora = bancaOrganizadora;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public NivelDeDificuldade getNivelDeDificuldade() {
		return nivelDeDificuldade;
	}

	public void setNivelDeDificuldade(NivelDeDificuldade nivelDeDificuldade) {
		this.nivelDeDificuldade = nivelDeDificuldade;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public TipoQuestao getTipoQuestao() {
		return tipoQuestao;
	}

	public void setTipoQuestao(TipoQuestao tipoQuestao) {
		this.tipoQuestao = tipoQuestao;
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
		Questao other = (Questao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
