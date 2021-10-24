create table ocorrencia(
  id bigint not null,
  entrega_id bigint not null,
  descricao text not null,
  data_registro timestamp not null,

  primary key (id)
);

alter table ocorrencia add constraint fk_ocorrencia_entrega
foreign key (entrega_id) references entrega (id);

create sequence if not exists seq_ocorrencia start 1 increment 1 owned by ocorrencia.id;

alter table ocorrencia alter column id set default nextval('seq_ocorrencia'::regclass);