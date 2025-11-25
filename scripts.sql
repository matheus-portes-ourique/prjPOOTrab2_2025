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
    valor decimal(6,2)
);

create table tb_medicacao (
    nome varchar2(10),
    dosagem varchar2(10),
    qtdDias number
);

create table tb_exame (
    codigo number,
    descricao varchar2(30),
    exa_data varchar2(20),
    exa_gora varchar2(5),
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

