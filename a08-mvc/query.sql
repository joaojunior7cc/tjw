DROP TABLE IF EXISTS tjw.clientes;
CREATE TABLE IF NOT EXISTS tjw.clientes(
	id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(60) NOT NULL,
	endereco VARCHAR(80) NOT NULL,
    telefone VARCHAR(60) NOT NULL
);