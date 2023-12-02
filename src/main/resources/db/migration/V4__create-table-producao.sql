create table producao(
id bigint not null auto_increment,
tamanho varchar (100) not null,
densidade_enum varchar (100) not null,
quantidade_milheiro decimal (6,1) not null,
peso_milheiro decimal (6,1) not null,
peso_total decimal,
apara decimal (6,1) not null,
nome_operador varchar (100) not null,
maquina varchar (100) not null,
data varchar (100) not null,

primary key (id)
);