CREATE SEQUENCE nivel_dificuldade_seq;

CREATE TABLE nivel_dificuldade(
	id BIGINT NOT NULL,
	descricao VARCHAR NOT NULL,
	CONSTRAINT pk_nivel_dificuldade PRIMARY KEY (id)
);