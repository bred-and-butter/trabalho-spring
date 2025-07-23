-- 1. Tabela: PESSOA
CREATE TABLE PESSOA (
    cpf VARCHAR(14) NOT NULL DEFAULT '',
    cnpj VARCHAR(18) NOT NULL DEFAULT '',
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    telefone VARCHAR(20),
    endereco VARCHAR(255),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(2),
    complemento VARCHAR(100),
    cep VARCHAR(10),
    PRIMARY KEY (cpf, cnpj),
    CHECK (
        (cpf <> '' AND cnpj = '') OR 
        (cpf = '' AND cnpj <> '')
    )
);

-- 2. Tabela: CLIENTE
CREATE TABLE CLIENTE (
    cpf_cliente VARCHAR(14) NOT NULL,
    cnpj_cliente VARCHAR(18) NOT NULL,
    data_cadastro DATE NOT NULL,
    PRIMARY KEY (cpf_cliente, cnpj_cliente),
    FOREIGN KEY (cpf_cliente, cnpj_cliente) REFERENCES PESSOA(cpf, cnpj)
);

-- 3. Tabela: FUNCIONARIO
CREATE TABLE FUNCIONARIO (
    cpf_funcionario VARCHAR(14) NOT NULL,
    cnpj_funcionario VARCHAR(18) NOT NULL,
    tipo_cargo VARCHAR(50) NOT NULL,
    area_atuacao VARCHAR(255),
    senha VARCHAR(255) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE NOT NULL,
    PRIMARY KEY (cpf_funcionario, cnpj_funcionario),
    FOREIGN KEY (cpf_funcionario, cnpj_funcionario) REFERENCES PESSOA(cpf, cnpj)
);

-- 4. Tabela: IMOVEL
CREATE TABLE IMOVEL (
    numero_matricula_imovel VARCHAR(255) PRIMARY KEY,
    endereco VARCHAR(255) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    cep VARCHAR(10),
    finalidade VARCHAR(50),
    area_total NUMERIC(10,2),
    valor NUMERIC(15,2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    data_cadastro DATE NOT NULL,
    data_atualizacao DATE,
    cpf_proprietario VARCHAR(14) NOT NULL,
    cnpj_proprietario VARCHAR(18) NOT NULL,
    FOREIGN KEY (cpf_proprietario, cnpj_proprietario) REFERENCES CLIENTE(cpf_cliente, cnpj_cliente)
);

-- 5. Tabela: TERRENO
CREATE TABLE TERRENO (
    numero_matricula_imovel VARCHAR(255) PRIMARY KEY,
    topografia VARCHAR(100),
    tipo_solo VARCHAR(100),
    FOREIGN KEY (numero_matricula_imovel) REFERENCES IMOVEL(numero_matricula_imovel)
);

-- 6. Tabela: UNIDADE_RESIDENCIAL
CREATE TABLE UNIDADE_RESIDENCIAL (
    numero_matricula_imovel VARCHAR(255) PRIMARY KEY,
    numero_quartos INT,
    numero_banheiros INT,
    numero_suites INT,
    area_construida NUMERIC(10,2),
    numero_vagas_garagem INT,
    descricao TEXT,
    FOREIGN KEY (numero_matricula_imovel) REFERENCES IMOVEL(numero_matricula_imovel)
);

-- 7. Tabela: CASA
CREATE TABLE CASA (
    numero_matricula_imovel VARCHAR(255) PRIMARY KEY,
    possui_quintal BOOLEAN,
    numero_pavimentos INT,
    FOREIGN KEY (numero_matricula_imovel) REFERENCES UNIDADE_RESIDENCIAL(numero_matricula_imovel)
);

-- 8. Tabela: APARTAMENTO
CREATE TABLE APARTAMENTO (
    numero_matricula_imovel VARCHAR(255) PRIMARY KEY,
    andar INT,
    numero_apartamento VARCHAR(20), 
    possui_elevador BOOLEAN,
    FOREIGN KEY (numero_matricula_imovel) REFERENCES UNIDADE_RESIDENCIAL(numero_matricula_imovel)
);

-- 9. Tabela: UNIDADE_COMERCIAL
CREATE TABLE UNIDADE_COMERCIAL (
    numero_matricula_imovel VARCHAR(255) PRIMARY KEY,
    area_util NUMERIC(10,2),
    descricao TEXT,
    FOREIGN KEY (numero_matricula_imovel) REFERENCES IMOVEL(numero_matricula_imovel)
);

-- 10. Tabela: PREDIO_COMERCIAL
CREATE TABLE PREDIO_COMERCIAL (
    numero_matricula_imovel VARCHAR(255) PRIMARY KEY,
    total_andares INT,
    numero_salas INT,
    possui_estacionamento BOOLEAN,
    FOREIGN KEY (numero_matricula_imovel) REFERENCES UNIDADE_COMERCIAL(numero_matricula_imovel)
);

-- 11. Tabela: SALA_COMERCIAL
CREATE TABLE SALA_COMERCIAL (
    numero_matricula_imovel VARCHAR(255) PRIMARY KEY,
    andar INT,
    numero_sala VARCHAR(20),
    FOREIGN KEY (numero_matricula_imovel) REFERENCES UNIDADE_COMERCIAL(numero_matricula_imovel)
);

-- 12. Tabela: VISITA
CREATE TABLE VISITA (
    cpf_cliente VARCHAR(14) NOT NULL,
    cnpj_cliente VARCHAR(18) NOT NULL,
    numero_matricula_imovel VARCHAR(255) NOT NULL,
    cpf_corretor VARCHAR(14) NOT NULL,
    cnpj_corretor VARCHAR(18) NOT NULL,
    data_hora TIMESTAMP NOT NULL,
    observacoes TEXT,
    PRIMARY KEY (cpf_cliente, cnpj_cliente, numero_matricula_imovel, cpf_corretor, cnpj_corretor, data_hora),
    FOREIGN KEY (cpf_cliente, cnpj_cliente) REFERENCES CLIENTE(cpf_cliente, cnpj_cliente),
    FOREIGN KEY (numero_matricula_imovel) REFERENCES IMOVEL(numero_matricula_imovel),
    FOREIGN KEY (cpf_corretor, cnpj_corretor) REFERENCES FUNCIONARIO(cpf_funcionario, cnpj_funcionario)
);

-- 13. Tabela: INTERESSE
CREATE TABLE INTERESSE (
    cpf_cliente VARCHAR(14) NOT NULL,
    cnpj_cliente VARCHAR(18) NOT NULL,
    numero_matricula_imovel VARCHAR(255) NOT NULL,
    cpf_corretor VARCHAR(14) NOT NULL,
    cnpj_corretor VARCHAR(18) NOT NULL,
    data_hora_visita TIMESTAMP NOT NULL,
    data_registro DATE NOT NULL,
    avaliacao_bairro INT CHECK (avaliacao_bairro BETWEEN 1 AND 5),
    avaliacao_cidade INT CHECK (avaliacao_cidade BETWEEN 1 AND 5),
    avaliacao_estado INT CHECK (avaliacao_estado BETWEEN 1 AND 5),
    avaliacao_area_total INT CHECK (avaliacao_area_total BETWEEN 1 AND 5),
    avaliacao_valor INT CHECK (avaliacao_valor BETWEEN 1 AND 5),
    avaliacao_topografia INT CHECK (avaliacao_topografia BETWEEN 1 AND 5),
    avaliacao_tipo_solo INT CHECK (avaliacao_tipo_solo BETWEEN 1 AND 5),
    avaliacao_quartos INT CHECK (avaliacao_quartos BETWEEN 1 AND 5),
    avaliacao_banheiros INT CHECK (avaliacao_banheiros BETWEEN 1 AND 5),
    avaliacao_suites INT CHECK (avaliacao_suites BETWEEN 1 AND 5),
    avaliacao_construida INT CHECK (avaliacao_construida BETWEEN 1 AND 5),
    avaliacao_garagem INT CHECK (avaliacao_garagem BETWEEN 1 AND 5),
    avaliacao_quintal INT CHECK (avaliacao_quintal BETWEEN 1 AND 5),
    avaliacao_numero_pavimentos INT CHECK (avaliacao_numero_pavimentos BETWEEN 1 AND 5),
    avaliacao_andar_apartamento INT CHECK (avaliacao_andar_apartamento BETWEEN 1 AND 5),
    avaliacao_elevador INT CHECK (avaliacao_elevador BETWEEN 1 AND 5),
    avaliacao_area_util INT CHECK (avaliacao_area_util BETWEEN 1 AND 5),
    avaliacao_total_andares INT CHECK (avaliacao_total_andares BETWEEN 1 AND 5),
    avaliacao_salas INT CHECK (avaliacao_salas BETWEEN 1 AND 5),
    avaliacao_estacionamento INT CHECK (avaliacao_estacionamento BETWEEN 1 AND 5),
    avaliacao_andar_sala INT CHECK (avaliacao_andar_sala BETWEEN 1 AND 5),
    avaliacao_sala INT CHECK (avaliacao_sala BETWEEN 1 AND 5),
    PRIMARY KEY (cpf_cliente, cnpj_cliente, numero_matricula_imovel, cpf_corretor, cnpj_corretor, data_hora_visita),
    FOREIGN KEY (cpf_cliente, cnpj_cliente, numero_matricula_imovel, cpf_corretor, cnpj_corretor, data_hora_visita)
        REFERENCES VISITA (cpf_cliente, cnpj_cliente, numero_matricula_imovel, cpf_corretor, cnpj_corretor, data_hora)
);

-- 14. Tabela: VENDA
CREATE TABLE VENDA (
    numero_matricula_imovel VARCHAR(255) NOT NULL,
    cpf_cliente_comprador VARCHAR(14) NOT NULL,
    cnpj_cliente_comprador VARCHAR(18) NOT NULL,
    cpf_proprietario_imovel VARCHAR(14) NOT NULL,
    cnpj_proprietario_imovel VARCHAR(18) NOT NULL,
    cpf_corretor VARCHAR(14) NOT NULL,
    cnpj_corretor VARCHAR(18) NOT NULL,
    data_venda TIMESTAMP NOT NULL,
    valor_final NUMERIC(15,2) NOT NULL,
    PRIMARY KEY (
        numero_matricula_imovel, cpf_cliente_comprador, cnpj_cliente_comprador,
        cpf_proprietario_imovel, cnpj_proprietario_imovel,
        cpf_corretor, cnpj_corretor, data_venda
    ),
    FOREIGN KEY (numero_matricula_imovel) REFERENCES IMOVEL(numero_matricula_imovel),
    FOREIGN KEY (cpf_cliente_comprador, cnpj_cliente_comprador) REFERENCES CLIENTE(cpf_cliente, cnpj_cliente),
    FOREIGN KEY (cpf_proprietario_imovel, cnpj_proprietario_imovel) REFERENCES CLIENTE(cpf_cliente, cnpj_cliente),
    FOREIGN KEY (cpf_corretor, cnpj_corretor) REFERENCES FUNCIONARIO(cpf_funcionario, cnpj_funcionario)
);