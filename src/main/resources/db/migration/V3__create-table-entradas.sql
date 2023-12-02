create table entradas(
id bigint not null auto_increment,
tipo_enum varchar (100) not null,
densidade_enum varchar (100) not null,
modelo varchar (100) not null,
quantidade_peso decimal (6,1) not null,
peso_resina decimal (6,1) not null,
data varchar (100) not null,

primary key (id)
);