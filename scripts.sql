----tabelas------------
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
    cons_data varchar2(10),
    valor decimal(6,2),
    med_cpf varchar2(14),
    pac_cpf varchar2(14)
);

CREATE TABLE tb_medicacao (
    nome VARCHAR2(50),
    dosagem VARCHAR2(20),
    qtdDias NUMBER,
    consulta_codigo NUMBER NOT NULL,
);

CREATE TABLE tb_exame (
    codigo NUMBER(5) NOT NULL,
    descricao VARCHAR2(50),
    exa_data VARCHAR2(10),       
    exa_hora VARCHAR2(5),        
    valor NUMBER(8,2),
    consulta_codigo NUMBER(5) NOT NULL, 
);

-----constraints (PKs)-----------

alter table tb_medico
add constraint pk_med_cpf primary key(cpf);

alter table tb_paciente 
add CONSTRAINT pk_pac_cpf primary key(cpf);

alter table tb_medicacao
add constraint pk_medicacao primary key (nome, consulta_codigo);

alter table tb_exame
add constraint pk_exa_codigo primary key(codigo);

alter table tb_consulta
add constraint pk_cons_codigo primary key(codigo);

------constraints (FKs)-----------

alter table tb_consulta
add constraint fk_medico_consulta foreign key (med_cpf) 
references tb_medico (cpf);

alter table tb_consulta
add constraint fk_paciente_consulta foreign key (pac_cpf)
references tb_paciente (cpf);

alter table tb_exame
add CONSTRAINT fk_exame_consulta FOREIGN KEY (consulta_codigo) 
REFERENCES tb_consulta(codigo)

alter table tb_medicacao
add CONSTRAINT fk_med_cons FOREIGN KEY (consulta_codigo) 
REFERENCES tb_consulta(codigo)
