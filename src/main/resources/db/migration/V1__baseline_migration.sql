create sequence  IF NOT EXISTS cliente_seq START with 1 INCREMENT BY 50;

create sequence  IF NOT EXISTS produto_seq START with 1 INCREMENT BY 50;

create TABLE cliente (
  id INTEGER NOT NULL,
   nome VARCHAR(255),
   email VARCHAR(255),
   aniversario date,
   nif VARCHAR(255),
   CONSTRAINT pk_cliente PRIMARY KEY (id)
);

create TABLE produto (
  id INTEGER NOT NULL,
   nome VARCHAR(255),
   preco DOUBLE PRECISION,
   quantidade INTEGER,
   categoria VARCHAR(255),
   CONSTRAINT pk_produto PRIMARY KEY (id)
);