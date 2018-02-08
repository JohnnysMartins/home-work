create database loja;

select * from categoria;

create table categoria(
	id serial PRIMARY KEY,
	nome varchar(100) not null
);

--drop table if exists product;
select * from produto;

CREATE SEQUENCE hibernate_sequence START 1;

create table produto(
	id bigserial PRIMARY KEY,
	nome varchar(100) not null,
    descricao varchar(255),
	categoria_id serial REFERENCES categoria(id)
);

insert into categoria values(1, 'Eletrônicos');
insert into categoria values(2, '');

insert into produto values(1, 'notebook', 'dell, intel i5, 8gb ram ddr4, 1tb de HD ', 1);
insert into produto values(2, 'IPhone 6s', 'Apple, 6s', 1);
