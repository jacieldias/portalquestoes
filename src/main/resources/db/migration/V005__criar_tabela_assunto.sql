CREATE SEQUENCE assunto_seq;

CREATE TABLE assunto(
	id BIGINT NOT NULL,
	descricao VARCHAR NOT NULL,
	disciplina BIGINT NOT NULL,
	CONSTRAINT pk_assunto PRIMARY KEY (id),
	CONSTRAINT fk_assunto_disciplina FOREIGN KEY (disciplina) REFERENCES disciplina(id)
);