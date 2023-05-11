drop database if exists orange_event_2B_23 ;
create database orange_event_2B_23; 
use orange_event_2B_23; 

create table client (
	idclient int(3) not null auto_increment, 
	nom varchar(30), 
	prenom varchar(30),
	adresse varchar(30),
	email varchar(30),
	primary key(idclient)
);
create table technicien (
	idtechnicien int(3) not null auto_increment, 
	nom varchar(30), 
	prenom varchar(30),
	qualification varchar(30),
	email varchar(30),
	mdp varchar(30), 
	primary key(idtechnicien)
);
create table intervention (
	idinter int(3) not null auto_increment, 
	materiel varchar(30), 
	panne varchar(30),
	dateinter date,
	prix float,
	idclient int(3) not null,
	idtechnicien int(3) not null,
	primary key(idinter), 
	foreign key(idclient) references client(idclient), 
	foreign key(idtechnicien) references technicien (idtechnicien)
);


