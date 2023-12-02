create table pedidos(
id bigint not null auto_increment,
cliente varchar (100) not null,
tamanho varchar (100) not null,
quantidade_milheiro decimal (6,1) not null,
densidade_enum varchar (100) not null,
data varchar (100) not null,
estado_enum varchar (100) not null,

primary key (id)
);