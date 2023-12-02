create table estoque(
id bigint not null auto_increment,
tamanho varchar (100) not null,
densidade_enum varchar (100) not null,
quantidade_milheiro decimal (6,1) not null,
peso_milheiro decimal (5,3) not null,
peso_total decimal,

primary key (id)
);