CREATE SEQUENCE banca_organizadora_seq;

CREATE TABLE banca_organizadora(
	id BIGINT NOT NULL,
	nome VARCHAR NOT NULL,
	nome_usual VARCHAR NOT NULL,
	ativo boolean,
	CONSTRAINT pk_banca_organizadora PRIMARY KEY (id)
);