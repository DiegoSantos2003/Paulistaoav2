create database db_paulistao
use db_paulistao
go

create table Times(
	CodigoTime int not null,
	NomeTime varchar(100) not null,
	Cidade varchar(100) not null,
	Estadio varchar (200) not null,
	primary key(CodigoTime)
)
create table Grupos(
		Grupo varchar (2) not null,
		CodigoTime int not null,
		Jogos int not null,
		foreign key (CodigoTime) references Times(CodigoTime)
)
create table Jogos(
	CodigoTimeA INT not null,
	CodigoTimeB int not null,
	GolsTimeA int,
	GolsTimeB int,
	Data date not null
)