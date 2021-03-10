CREATE SEQUENCE instituicao_seq;

CREATE TABLE instituicao(
	id BIGINT NOT NULL,
	nome VARCHAR NOT NULL,
	nome_usual VARCHAR NOT NULL,
	ativo boolean,
	CONSTRAINT pk_instituicao PRIMARY KEY (id)
);