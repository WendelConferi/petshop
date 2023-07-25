CREATE TABLE USUARIOS (

des_cpf varchar(15) PRIMARY KEY,
des_nome varchar(100) NOT NULL,
des_senha varchar(255) NOT NULL,
ind_tipo integer default 0 NOT NULL
	);