create table tb_medico (
    nome varchar2(30),
    cpf varchar2(14),
    crm varchar2(10),
    especialidade varchar2(10),
    endereco varchar2(50),
    telefone varchar2(15)
);

create table tb_paciente (
    nome varchar2(30),
    cpf varchar2(14),
    endereco varchar2(50),
    telefone varchar2(15),
    dataNascimento date;
    altura decimal(5,2),
    peso decimal(5,2) 
);

create table tb_consulta (
    codigo NUMBER,
    cons_data date,
    valor decimal(6,2),
    med_cpf varchar2(14)
);

create table tb_medicacao (
    nome varchar2(10),
    dosagem varchar2(10),
    qtdDias number,
    cons_codigo number
);

create table tb_exame (
    codigo number,
    descricao varchar2(30),
    exa_data varchar2(20),
    exa_hora varchar2(5),
    valor decimal(6,2)
);

--constraints (PKs)--

alter table tb_medico
add constraint pk_med_cpf primary key(cpf);

alter table tb_paciente 
add CONSTRAINT pk_pac_cpf primary key(cpf);

alter table tb_medicacao
add constraint pk_nome primary key (nome);

alter table tb_exame
add constraint pk_exa_codigo primary key(codigo);

alter table tb_consulta
add constraint pk_cons_codigo primary key(codigo);

--constraints (FKs)--

alter table tb_consulta
add constraint fk_medico_consulta foreign key (med_cpf) 
references tb_medico (cpf);

alter table tb_consulta
add constraint fk_paciente_consulta foreign key (pac_cpf)
references tb_paciente (cpf);

alter table tb_medicacao 
add constraint fk_medicacao_consulta foreign key (cons_codigo)
references tb_consulta(codigo);

--procedure busca nome medico por nome da medicacao0
--TODO: CRIAR PROCEDURE
select m.nome 
from tb_medico m 
inner join tb_consulta c
on c.med_cpf = m.cpf
inner join TB_MEDICACAO md
on md.cons_codigo = c.CODIGO
where md.nome = 'dipirona';