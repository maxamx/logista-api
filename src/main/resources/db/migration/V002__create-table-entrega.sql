

create table if not exists entrega(
    id bigint not null,
    cliente_id bigint not null,
    taxa decimal(10,2) not null,
    status varchar(20) not null,
    data_pedido timestamp not null,
    data_finalizacao timestamp,

    destinatario_nome varchar(60) not null,
    destinatario_logradouro varchar(255) not null,
    destinatario_numero varchar(30) not null,
    destinatario_complemento varchar(60) not null,
    destinatario_bairro varchar(30) not null,

    primary key (id)
);

alter table entrega add constraint fk_entrega_cliente
    foreign key (cliente_id) references cliente (id);

create sequence  if not exists seq_entrega owned by entrega.id;

alter table entrega alter column id set default nextval('seq_entrega'::regclass);