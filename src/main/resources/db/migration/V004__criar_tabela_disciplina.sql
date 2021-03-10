CREATE SEQUENCE disciplina_seq;

CREATE TABLE disciplina(
	id BIGINT NOT NULL,
	nome VARCHAR NOT NULL,
	CONSTRAINT pk_disciplina PRIMARY KEY (id)
);