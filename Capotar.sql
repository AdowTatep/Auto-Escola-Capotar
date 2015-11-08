DROP DATABASE autoCapotar;

CREATE DATABASE autoCapotar;

USE autoCapotar;

CREATE TABLE usuario (
	login VARCHAR(20) PRIMARY KEY NOT NULL,
    senha VARCHAR(20) NOT NULL,
    nome VARCHAR(100),
    tipo VARCHAR(20) NOT NULL
);

INSERT INTO usuario VALUES
('admin', 'admin', '', 'atendente');

CREATE TABLE aula (
	id_aula int(10) primary key auto_increment not null,
    tipo char(7) not null,
    id_professor int(10) not null
);

CREATE TABLE aluno_aula (
	login varchar(20),
    id_aula int(10),
    faltas int(2),
    CONSTRAINT fk_alunoaula_id FOREIGN KEY (id_aula) REFERENCES aula(id_aula)
);