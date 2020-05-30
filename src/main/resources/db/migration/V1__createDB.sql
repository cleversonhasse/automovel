CREATE TABLE automovel (
    id_automovel Long auto_increment NOT NULL,
    nome VARCHAR(100) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    data_fabricacao timestamp without time zone NOT NULL,
    consumo_medio_cidade decimal NOT NULL,
    consumo_medio_rodovia decimal NOT NULL,
    CONSTRAINT automovel_pk PRIMARY KEY (id_automovel)
);
