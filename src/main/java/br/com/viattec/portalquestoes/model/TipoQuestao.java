package br.com.viattec.portalquestoes.model;

public enum TipoQuestao {
	
	OBJETIVA("Objetiva"),
	ASSERTIVA("Assertiva");
	
	private String descricao;
	
	private TipoQuestao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
