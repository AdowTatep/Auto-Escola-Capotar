DROP DATABASE autoCapotar;

CREATE DATABASE autoCapotar;

USE autoCapotar;

CREATE TABLE config (
	preco_aula float(8,2),
    minutos_aula int(3),
    preco_simulado float(8,2)
);

INSERT INTO config VALUES
(30.0,50,80.0);

UPDATE config SET preco_aula = 30;

CREATE TABLE usuario (
	login VARCHAR(20) NOT NULL,veiculos
    senha VARCHAR(20) NOT NULL,
    nome VARCHAR(100),
    cpf char(11), 
    tipo VARCHAR(20) NOT NULL,
    primary key(login, cpf)
);

INSERT INTO usuario VALUES
('admin', 'admin', '', '', 'Atendente');

INSERT INTO usuario VALUES
('Prof', 'prof', 'Jõao Luiz', '66689545879', 'Professor');

INSERT INTO usuario VALUES
('aluno', 'aluno', 'Aluno', '12345678912', 'Aluno');

INSERT INTO veiculos VALUES
('GZV7642', 2004, 'L 1620');

CREATE TABLE aulas (
	id_aula int(10) primary key auto_increment not null,
    tipo char(7) not null,
    login_professor VARCHAR(20) not null,
    nome_professor varchar(30),
    hora_inicio char(5),
    hora_fim char(5),
    data_aula char(10)
);

CREATE TABLE aulas_aluno (
	id_aula int(10),
    login VARCHAR(20),
    faltou_aula tinyint(1) DEFAULT 0,
    CONSTRAINT fk_aula_aluno FOREIGN KEY (id_aula) REFERENCES aulas(id_aula)
);

CREATE TABLE aluno_matricula (
	login VARCHAR(20),
	numero_matricula int(10) primary key auto_increment,
	saldo float(8,2),
    CONSTRAINT fk_mat_aluno_login FOREIGN KEY (login) REFERENCES usuario(login)
);

CREATE TABLE aluno_simulados(
	id_simulado int(10) primary key auto_increment not null,
	login VARCHAR(20),
    data_simulado VARCHAR(20),
    nota_resultado int(3),
    preco_simulado float(8,2),
    CONSTRAINT fk_simula_aluno_login FOREIGN KEY (login) REFERENCES usuario(login)
);

CREATE TABLE professor(
	login VARCHAR(20),
    registro CHAR(5),    
    CONSTRAINT fk_prof_usu_login FOREIGN KEY (login) REFERENCES usuario(login)
);

CREATE TABLE veiculos(
	placa char(7),
    ano int(4),
    modelo varchar(25)
);