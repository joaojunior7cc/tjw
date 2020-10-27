DROP DATABASE IF EXISTS tjwtrab;
CREATE DATABASE IF NOT EXISTS tjwtrab 
CHARACTER SET utf8 
COLLATE utf8_unicode_ci;

DROP TABLE IF EXISTS tjwtrab.tb_status; 
CREATE TABLE IF NOT EXISTS tjwtrab.tb_status(
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	status VARCHAR(25) NOT NULL
);

INSERT INTO tjwtrab.tb_status(status)
VALUES  ('pendente'),
        ('realizado');

DROP TABLE IF EXISTS tjwtrab.tb_tarefas; 
CREATE TABLE IF NOT EXISTS tjwtrab.tb_tarefas(
	id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	id_status INT NOT NULL DEFAULT 1,
	FOREIGN KEY(id_status) REFERENCES tjwtrab.tb_status(id),
	descricao TEXT NOT NULL,
	data_cad DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO tjwtrab.tb_tarefas(descricao)
VALUES  ('Lavar Roupa'),
        ('Tirar o lixo'),
        ('Lavar o carro');