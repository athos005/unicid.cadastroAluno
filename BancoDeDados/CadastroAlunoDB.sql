CREATE TABLE ENDERECO(
COD_ENDERECO INT AUTO_INCREMENT,
CEP CHAR(8),
ENDERECO VARCHAR(30),
BAIRRO VARCHAR(20),
NUMERO VARCHAR(6),
COMPLEMENTO VARCHAR(20),
CIDADE VARCHAR(20),
UF CHAR(2),
CONSTRAINT PK_ENDERECO PRIMARY KEY (COD_ENDERECO, CEP)
);

CREATE TABLE PESSOA(
COD_PESSOA INT AUTO_INCREMENT,
NOME VARCHAR(45),
CPF CHAR(11),
NASCIMENTO CHAR(9),
GENERO CHAR(1),
EMAIL VARCHAR(40),
CELULAR VARCHAR(11),
TELEFONE VARCHAR(10),
COD_ENDERECO INT,
CONSTRAINT PK_PESSOA PRIMARY KEY(COD_PESSOA),
CONSTRAINT FK_ENDERECO FOREIGN KEY (COD_ENDERECO) REFERENCES ENDERECO(COD_ENDERECO)
);

CREATE TABLE CURSO(
COD_CURSO INT AUTO_INCREMENT,
NOME_CURSO VARCHAR(30),
CONSTRAINT PK_CURSO PRIMARY KEY (COD_CURSO)
);

CREATE TABLE DISCIPLINA(
COD_DISCIPLINA INT AUTO_INCREMENT,
NOME_DISCIPLINA VARCHAR(30),
COD_CURSO INT,
CONSTRAINT PK_DISCIPLINA PRIMARY KEY (COD_DISCIPLINA),
CONSTRAINT FK_CURSO FOREIGN KEY (COD_CURSO) REFERENCES CURSO(COD_CURSO)
); 

CREATE TABLE ALUNO(
COD_ALUNO INT AUTO_INCREMENT,
RGM INT,
PERIODO VARCHAR(10),
CAMPUS VARCHAR(9),
COD_PESSOA INT,
COD_CURSO INT,
CONSTRAINT PK_ALUNO PRIMARY KEY(COD_ALUNO, RGM),
CONSTRAINT FK_PESSOA FOREIGN KEY (COD_PESSOA) REFERENCES PESSOA(COD_PESSOA),
CONSTRAINT FK_CURSO_ALUNO FOREIGN KEY (COD_CURSO) REFERENCES CURSO(COD_CURSO)
);

CREATE TABLE DISCIPLINA_ALUNO(
COD_DISCIPLINA_ALUNO INT AUTO_INCREMENT,
RGM INT,
FALTAS INT DEFAULT(0),
NOTA FLOAT DEFAULT(0),
SEMESTRE CHAR(9) DEFAULT(0),
COD_DISCIPLINA INT,
CONSTRAINT PK_DISCIPLINA PRIMARY KEY(COD_DISCIPLINA_ALUNO),
CONSTRAINT FK_DISCIPLINA FOREIGN KEY(COD_DISCIPLINA) REFERENCES DISCIPLINA(COD_DISCIPLINA)
);

CREATE TABLE UF(
COD_UF INT AUTO_INCREMENT,
SIGLA CHAR(2),
CONSTRAINT PK_UF PRIMARY KEY (COD_UF)
);
INSERT INTO UF(SIGLA) VALUES ("AC"),("AL"),("AP"),("AM"),("BA"),("CE"),("DF"),("ES"),("GO"),("MA"),("MT"),("MS"),("MG"),("PA"),("PB"),("PR"),("PE"),("PI"),("RJ"),("RN"),("RS"),("RO"),("RR"),("SC"),("SP"),("SE"),("TO");

INSERT INTO CURSO(NOME_CURSO) VALUES ("Análise de Sistemas"), ("Odontologia"), ("Arquitetura");

INSERT INTO DISCIPLINA(NOME_DISCIPLINA, COD_CURSO) VALUES("Técnicas de Programação", 1), ("Banco de Dados", 1), ("Java Orientado a Objetos", 1), ("HTML e CSS", 1), ("PHP", 1);
