DROP DATABASE autoCapotar;

CREATE DATABASE autoCapotar;

USE autoCapotar;

CREATE TABLE usuario (
	login VARCHAR(20) NOT NULL,
    senha VARCHAR(20) NOT NULL,
    nome VARCHAR(100),
    cpf char(11), 
    tipo VARCHAR(20) NOT NULL,
    primary key(login, cpf)
);

INSERT INTO usuario VALUES
('admin', 'admin', '', '', 'Atendente');

INSERT INTO usuario VALUES
('aluno', 'aluno', 'Aluno', '12345678912', 'Aluno');

CREATE TABLE aulas (
	id_aula int(10) primary key auto_increment not null,
    tipo char(7) not null,
    login_professor int(10) not null,
    nome_professor varchar(30),
    hora_inicio char(5),
    hora_fim char(5),
    valor_aula float(5,2)
);

CREATE TABLE aulas_aluno (
	id_aula int(10),
    login VARCHAR(20),
    CONSTRAINT fk_aula_aluno FOREIGN KEY (id_aula) REFERENCES aulas(id_aula)
);

CREATE TABLE aluno_matricula (
	login VARCHAR(20),
	numero_matricula int(10) primary key auto_increment,
	saldo float(8,2),
    CONSTRAINT fk_mat_aluno_login FOREIGN KEY (login) REFERENCES usuario(login)
);

CREATE TABLE aluno_simulados(
	login VARCHAR(20),
    data_simulado VARCHAR(20),
    nota_resultado int(3),
    CONSTRAINT fk_simula_aluno_login FOREIGN KEY (login) REFERENCES usuario(login)
);