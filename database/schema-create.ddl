create table vagas (
    id bigint generated by default as identity (start with 1),
	inicio timestamp,
	fim timestamp,
	quantidade integer,
	primary key (id)
);

create table solicitante (
    id bigint generated by default as identity (start with 1),
	nome varchar(255) not null,
	primary key (id)
);

create table agendamento (
    id bigint generated by default as identity (start with 1),
	data timestamp,
	numero varchar(20),
	motivo varchar(255),
    solicitante_id bigint not null,
	primary key (id)
);

alter table agendamento 
   add constraint FK_chamado_solicitante
   foreign key (solicitante_id) 
   references solicitante;
