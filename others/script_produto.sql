create table produto (
    id serial primary key,
    nome varchar(50) not null,
    marca varchar(20),
    ncm integer not null,
    unidade varchar(2),
    codBarras varchar(20),
    estoque integer,
    precoVenda numeric,
    precoUnitario numeric
)