CREATE CACHED TABLE CLIENTES(
	ID INTEGER IDENTITY,
	NOME VARCHAR(60) NOT NULL,
	ATIVO BOOLEAN NOT NULL,
	DATA DATE NOT NULL,
	FANTASIA VARCHAR(60) NULL,
	CPF VARCHAR(14),
	RG VARCHAR(10),
	ENDERECO VARCHAR(80),
	BAIRRO VARCHAR(20),
	NUMERO VARCHAR(7),
	CIDADE VARCHAR(20),
	ESTADO VARCHAR(2),
	CEP VARCHAR(10),
	TELEFONE VARCHAR(13),
	TELEFONE2 VARCHAR(13),
	EMAIL VARCHAR(45),
UNIQUE(NOME));
INSERT INTO CLIENTES VALUES(1,'Fabiana Magalhães de Carvalho', true,'2006-10-8','',02316502563,94356552,'Rua Sérgio Gil', 'Balneário',204,'Florianópolis','SC', '88075340','48 3248 3659','', 'fabi@bol.com.br');
INSERT INTO CLIENTES VALUES(2,'Milena Sobreira Benevides', true,'2006-10-8','',86121499591,93847563,'Rua Açores', 'Pantano do Sul',2400,'Florianópolis','SC', '88067000','48 3235 3758','', 'milena.benevides@yahoo.com.br');
INSERT INTO CLIENTES VALUES(3,'Osmar Numa Lucas Barbosa Lino', true,'2006-10-8','',01907331504,28473859,'Rua São João', 'Ns Rosário',164,'Florianópolis','SC', '88110606','48 3246 2343','', 'osmarlucas@hotmail.com');
INSERT INTO CLIENTES VALUES(4,'Jose de Oliveira Souza Neto', true,'2006-10-8','',01562987593,73849283,'Rua Chile', 'Santos Dummond',133,'São José','SC', '88117235','48 3240 8145','', 'joseneto@gmail.com');
INSERT INTO CLIENTES VALUES(5,'Alessandra Pena da Cruz', true,'2006-10-8','',01598361560,02938495,'Rua Domicilio Luz', 'Bela Vista',544,'São José','SC', '88110214','48 3246 9849','', 'alessandracruz@zipmaill.com.br');
INSERT INTO CLIENTES VALUES(6,'Clodoaldo Nunes Silva', true,'2006-10-8','',92125829553,19384950,'Rua Fulvio Adducci', 'Estreito',483,'Florianópolis','SC', '88076000','48 3248 5155','', 'clodoaldo@brturbo.com.br');
INSERT INTO CLIENTES VALUES(7,'Emerson Santos de Almeida', true,'2006-10-8','',01509333550,48529309,'Rua Prof. Orlando Brasil ', 'Capoeiras',131,'Florianópolis','SC', '88070410','48 3248 2342','', 'almeidasantos@ig.com.br');
INSERT INTO CLIENTES VALUES(8,'Sonia Castro de Oliveira', true,'2006-10-8','',00460045567,56039495,'Rua Sereias', 'Canasvieiras',87,'Florianópolis','SC', '88054360','48 3266 1242','', 'soniacastro@ufpr.br');
INSERT INTO CLIENTES VALUES(9,'Wilson Mota Moura', true,'2006-10-8','',00890578565,34520596,'Rua Nelson Conrado da Silva', 'Centro',289,'Florianópolis','SC', '88020095','48 3223 5689','', 'wilsonmm@globo.com');
INSERT INTO CLIENTES VALUES(10,'Israel da Silva Souza', true,'2006-10-8','',99183323489,65078930,'Rua Domingos Filomeno', 'Praia Comprida',874,'São José','SC', '88103430','48 3246 5815','', 'israel@uol.com.br');


CREATE CACHED TABLE FORNECEDORES(
	ID INTEGER IDENTITY,
	NOME VARCHAR(60) NOT NULL,
	ATIVO BOOLEAN NOT NULL,
	DATA DATE NOT NULL,
	FANTASIA VARCHAR(60) NULL,
	CNPJ VARCHAR(14),
	INSCEST VARCHAR(10),
	ENDERECO VARCHAR(80),
	BAIRRO VARCHAR(20),
	NUMERO VARCHAR(7),
	CIDADE VARCHAR(20),
	ESTADO VARCHAR(2),
	CEP VARCHAR(10),
	TELEFONE VARCHAR(13),
	TELEFONE2 VARCHAR(13),
	EMAIL VARCHAR(45),
UNIQUE(NOME));
INSERT INTO FORNECEDORES VALUES(1,'Helios Carbexx S.A.', true,'2006-10-8','',60890837000185,80272384,'Av. Henrique Gonçalves Batista bl. 2', '',2246,'Barueri','SP', '88734970','11 3232 5861','', 'atendimento@helios-carbex.com.br');
INSERT INTO FORNECEDORES VALUES(2,'COMPUSOFT COMÉRCIO IMPORTAÇÃO EXPORTAÇÃO ', true,'2006-10-8','',41703760000142,62992965,'AV. GETÚLIO VARGAS', 'CENTRO',1883,'BELO HORIZONTE','MG', '30120060','31 3272 5510','', 'fabiane@compusoft-shop.com');
INSERT INTO FORNECEDORES VALUES(3,'LORENZ S. A.', true,'2006-10-8','',82639543000380,116282190118,'Rua Armando Martino', 'Parque São Domingos',299,'São Paulo','SP', '05127000','11 390303650','11 39030138', 'lorenzsp@terra.com.br');
INSERT INTO FORNECEDORES VALUES(4,'TechCD Informática LTDA', true,'2006-10-8','',03520018000102,09675643,'Av. Pompéia', 'Vila Pompéia',2433,'São Paulo','SP', '05127970','11 36776655','', 'techcd@techcd.com.br');
CREATE CACHED TABLE USUARIOS(
	ID INTEGER IDENTITY,
	DATA DATE NOT NULL,
	NOME VARCHAR(50),
	USUARIO VARCHAR(30) NOT NULL,
	CARGO VARCHAR(20) ,
	SENHA VARCHAR(32) NOT NULL,
	UNIQUE(USUARIO));
INSERT INTO USUARIOS VALUES (null,'2006-7-8','Administrador do Sistema','admin','Administrador do Sistema','21232f297a57a5a743894a0e4a801fc3');
CREATE CACHED TABLE PRODUTOS(
	ID INTEGER IDENTITY,
	DESCRICAO VARCHAR(60) NOT NULL,
	ATIVO BOOLEAN NOT NULL,
	DATA DATE NOT NULL,
	FABRICANTE VARCHAR(60) NULL,
	GRUPO VARCHAR(14),
	CUSTO DOUBLE,
        VENDA DOUBLE,
	ESTOQUEATUAL DOUBLE,
	ESTOQUEMIN DOUBLE);
INSERT INTO PRODUTOS VALUES(1,'Impressora HP 3535', true,'2006-7-8','HP','Periféricos',200.00,289.00,6,3);
INSERT INTO PRODUTOS VALUES(2,'Teclado Satellite', true,'2006-7-8','Satellite','Periféricos',12.00,25.90,12,2);
INSERT INTO PRODUTOS VALUES(3,'Mouse Optico Satellite', true,'2006-7-8','Satellite','Periféricos',15.00,28.90,4,1);
INSERT INTO PRODUTOS VALUES(4,'Processador P4 3.6Ghz', true,'2006-7-8','Intel','Processadores',300.00,457.00,2,1);
INSERT INTO PRODUTOS VALUES(5,'Notebook Sony VGN 1.7Ghz 1024MB 80GB', true,'2006-7-8','Sony','Periféricos',3200.00,4350.00,2,1);
INSERT INTO PRODUTOS VALUES(6,'Fax Modem 56k TrendNet', true,'2006-7-8','TrendNet','Periféricos',19.80,39.50,4,1);

CREATE table pedido(
	id integer identity,
	idcliente integer not null,
	data date not null,
	qtdade integer,
	formapag VARCHAR(60),
	vlTotal DOUBLE,
	desc DOUBLE);
CREATE TABLE itempedido (
	idpedido INTEGER,
	idproduto INTEGER,
	qtdade DOUBLE,
	vlUnit DOUBLE,
	desc DOUBLE);
CREATE table pedidoentrada(
	id integer identity,
	idfornecedor integer not null,
	data date not null,
	qtdade integer,
	formapag VARCHAR(60),
	vlTotal DOUBLE,
	desc DOUBLE);
CREATE TABLE itempedidoentrada (
	idpedido INTEGER,
	idproduto INTEGER,
	qtdade DOUBLE,
	vlUnit DOUBLE,
	desc DOUBLE);
	