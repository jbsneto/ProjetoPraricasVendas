create table endereco (

	id serial primary key,
	cidade varchar(50),
	bairro varchar(100),
	rua varchar(100),
	numeroCasa integer,
	cep varchar(10),
	idCliente integer,

	foreign key (idCliente ) references cliente(id) on delete cascade
)