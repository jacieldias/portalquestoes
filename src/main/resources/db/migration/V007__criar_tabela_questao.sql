CREATE SEQUENCE questao_seq;

CREATE TABLE questao(
	id BIGINT NOT NULL,
	disciplina BIGINT,
	assunto BIGINT,
	bancaorganizadora BIGINT,
	instituicao BIGINT,
	cargo BIGINT,
	nivel BIGINT,
	tipoquestao VARCHAR,
	ano INTEGER,
	enunciado TEXT,
	CONSTRAINT pk_questao PRIMARY KEY (id),
	CONSTRAINT fk_questao_disciplina FOREIGN KEY (disciplina) REFERENCES disciplina(id),
	CONSTRAINT fk_questao_assunto FOREIGN KEY (assunto) REFERENCES assunto(id),
	CONSTRAINT fk_questao_bancaorganizadora FOREIGN KEY (bancaorganizadora) REFERENCES banca_organizadora(id),
	CONSTRAINT fk_questao_instituicao FOREIGN KEY (instituicao) REFERENCES instituicao(id),
	CONSTRAINT fk_questao_cargo FOREIGN KEY (cargo) REFERENCES cargo(id),
	CONSTRAINT fk_questao_nivel FOREIGN KEY (nivel) REFERENCES nivel_dificuldade(id)
);