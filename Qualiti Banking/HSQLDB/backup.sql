--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.4
-- Dumped by pg_dump version 9.3.4
-- Started on 2014-11-01 17:32:57

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE "QUALITI_BANKING";
--
-- TOC entry 1970 (class 1262 OID 32790)
-- Name: QUALITI_BANKING; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "QUALITI_BANKING" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE "QUALITI_BANKING" OWNER TO postgres;

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 5 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 1971 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 176 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1973 (class 0 OID 0)
-- Dependencies: 176
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 170 (class 1259 OID 32791)
-- Name: tb_cliente; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tb_cliente (
    cpf character(11) NOT NULL,
    nome character varying(100) NOT NULL
);


ALTER TABLE public.tb_cliente OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 32824)
-- Name: tb_conta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tb_conta (
    tb_cliente_cpf character(11) NOT NULL,
    numero character varying(10) NOT NULL,
    saldo numeric(16,4) NOT NULL,
    tipo integer NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.tb_conta OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 32834)
-- Name: tb_conta_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tb_conta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tb_conta_id_seq OWNER TO postgres;

--
-- TOC entry 1974 (class 0 OID 0)
-- Dependencies: 175
-- Name: tb_conta_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tb_conta_id_seq OWNED BY tb_conta.id;


--
-- TOC entry 172 (class 1259 OID 32811)
-- Name: tb_contato; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tb_contato (
    nome character varying(100) NOT NULL,
    sobrenome character varying(100) NOT NULL,
    cpf character(11) NOT NULL,
    email character varying(100) NOT NULL,
    telefone character varying(100) NOT NULL,
    celular character varying(100) NOT NULL,
    logradouro character varying(100) NOT NULL,
    numero character varying(10) NOT NULL,
    bairro character varying(50) NOT NULL,
    cidade character varying(50) NOT NULL,
    estado character(2) NOT NULL,
    cep character(8) NOT NULL,
    complemento character varying(500) NOT NULL
);


ALTER TABLE public.tb_contato OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 32796)
-- Name: tb_endereco; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tb_endereco (
    tb_cliente_cpf character(11) NOT NULL,
    cep character(8),
    numero character(5),
    complemento character(100)
);


ALTER TABLE public.tb_endereco OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 32819)
-- Name: tb_gerente; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tb_gerente (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    fone character(12) NOT NULL,
    celular character(12) NOT NULL,
    email character(50) NOT NULL
);


ALTER TABLE public.tb_gerente OWNER TO postgres;

--
-- TOC entry 1840 (class 2604 OID 32836)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_conta ALTER COLUMN id SET DEFAULT nextval('tb_conta_id_seq'::regclass);


--
-- TOC entry 1960 (class 0 OID 32791)
-- Dependencies: 170
-- Data for Name: tb_cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_cliente (cpf, nome) VALUES ('00000000000', 'Catapóbio da Silva');
INSERT INTO tb_cliente (cpf, nome) VALUES ('11111111111', 'Saponácio José');
INSERT INTO tb_cliente (cpf, nome) VALUES ('22222222222', 'Zuquim ambim');
INSERT INTO tb_cliente (cpf, nome) VALUES ('33333333333', 'Claustrífico tongo');
INSERT INTO tb_cliente (cpf, nome) VALUES ('44444444444', 'Astrogilda Tambaemba');
INSERT INTO tb_cliente (cpf, nome) VALUES ('55555555555', 'Austin Contrófico');
INSERT INTO tb_cliente (cpf, nome) VALUES ('66666666666', 'Oniqua Carbenha');
INSERT INTO tb_cliente (cpf, nome) VALUES ('77777777777', 'Pablo Carlo');
INSERT INTO tb_cliente (cpf, nome) VALUES ('88888888888', 'Tayrone Bascles');
INSERT INTO tb_cliente (cpf, nome) VALUES ('99999999999', 'Coniglio Cenoura');
INSERT INTO tb_cliente (cpf, nome) VALUES ('69325878173', 'OROMAR');
INSERT INTO tb_cliente (cpf, nome) VALUES ('12345678909', 'TESTE INCLUSÃO OROMAR DANTAS');
INSERT INTO tb_cliente (cpf, nome) VALUES ('09836478299', 'TESTE DE NOVO');
INSERT INTO tb_cliente (cpf, nome) VALUES ('04848717493', 'OROMAR LAMOUNIER DANTAS MELO');


--
-- TOC entry 1964 (class 0 OID 32824)
-- Dependencies: 174
-- Data for Name: tb_conta; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_conta (tb_cliente_cpf, numero, saldo, tipo, id) VALUES ('00000000000', '0000-0', 2500.0000, 0, 1);
INSERT INTO tb_conta (tb_cliente_cpf, numero, saldo, tipo, id) VALUES ('00000000000', '0000-1', 100.0000, 1, 2);
INSERT INTO tb_conta (tb_cliente_cpf, numero, saldo, tipo, id) VALUES ('00000000000', '0000-2', 100.0000, 2, 3);
INSERT INTO tb_conta (tb_cliente_cpf, numero, saldo, tipo, id) VALUES ('11111111111', '1111-0', 800.0000, 0, 4);
INSERT INTO tb_conta (tb_cliente_cpf, numero, saldo, tipo, id) VALUES ('22222222222', '2222-0', 900.0000, 0, 5);
INSERT INTO tb_conta (tb_cliente_cpf, numero, saldo, tipo, id) VALUES ('33333333333', '3333-0', 70.0000, 0, 6);
INSERT INTO tb_conta (tb_cliente_cpf, numero, saldo, tipo, id) VALUES ('44444444444', '4444-0', 90.0000, 0, 7);
INSERT INTO tb_conta (tb_cliente_cpf, numero, saldo, tipo, id) VALUES ('55555555555', '5555-0', 3800.0000, 0, 8);
INSERT INTO tb_conta (tb_cliente_cpf, numero, saldo, tipo, id) VALUES ('66666666666', '6666-0', 4000.0000, 0, 9);
INSERT INTO tb_conta (tb_cliente_cpf, numero, saldo, tipo, id) VALUES ('77777777777', '7777-0', 50000.0000, 0, 10);
INSERT INTO tb_conta (tb_cliente_cpf, numero, saldo, tipo, id) VALUES ('88888888888', '8888-0', 170.0000, 0, 11);
INSERT INTO tb_conta (tb_cliente_cpf, numero, saldo, tipo, id) VALUES ('99999999999', '9999-0', 657.0000, 0, 12);


--
-- TOC entry 1975 (class 0 OID 0)
-- Dependencies: 175
-- Name: tb_conta_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('tb_conta_id_seq', 12, true);


--
-- TOC entry 1962 (class 0 OID 32811)
-- Dependencies: 172
-- Data for Name: tb_contato; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1961 (class 0 OID 32796)
-- Dependencies: 171
-- Data for Name: tb_endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO tb_endereco (tb_cliente_cpf, cep, numero, complemento) VALUES ('00000000000', '52060000', '0    ', 'Apto 0                                                                                              ');
INSERT INTO tb_endereco (tb_cliente_cpf, cep, numero, complemento) VALUES ('11111111111', '52060111', '1    ', 'Apto 1                                                                                              ');
INSERT INTO tb_endereco (tb_cliente_cpf, cep, numero, complemento) VALUES ('22222222222', '52060222', '2    ', 'Apto 2                                                                                              ');
INSERT INTO tb_endereco (tb_cliente_cpf, cep, numero, complemento) VALUES ('33333333333', '52060333', '3    ', 'Apto 3                                                                                              ');
INSERT INTO tb_endereco (tb_cliente_cpf, cep, numero, complemento) VALUES ('44444444444', '52060444', '4    ', 'Apto 4                                                                                              ');
INSERT INTO tb_endereco (tb_cliente_cpf, cep, numero, complemento) VALUES ('55555555555', '52060555', '5    ', 'Apto 5                                                                                              ');
INSERT INTO tb_endereco (tb_cliente_cpf, cep, numero, complemento) VALUES ('66666666666', '52060666', '6    ', 'Apto 6                                                                                              ');
INSERT INTO tb_endereco (tb_cliente_cpf, cep, numero, complemento) VALUES ('77777777777', '52060777', '7    ', 'Apto 7                                                                                              ');
INSERT INTO tb_endereco (tb_cliente_cpf, cep, numero, complemento) VALUES ('88888888888', '52060888', '8    ', 'Apto 8                                                                                              ');
INSERT INTO tb_endereco (tb_cliente_cpf, cep, numero, complemento) VALUES ('99999999999', '52060999', '9    ', 'Apto 9                                                                                              ');


--
-- TOC entry 1963 (class 0 OID 32819)
-- Dependencies: 173
-- Data for Name: tb_gerente; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 1842 (class 2606 OID 32795)
-- Name: tb_cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tb_cliente
    ADD CONSTRAINT tb_cliente_pkey PRIMARY KEY (cpf);


--
-- TOC entry 1850 (class 2606 OID 32841)
-- Name: tb_conta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tb_conta
    ADD CONSTRAINT tb_conta_pkey PRIMARY KEY (id);


--
-- TOC entry 1846 (class 2606 OID 32818)
-- Name: tb_contato_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tb_contato
    ADD CONSTRAINT tb_contato_pkey PRIMARY KEY (cpf);


--
-- TOC entry 1844 (class 2606 OID 32800)
-- Name: tb_endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tb_endereco
    ADD CONSTRAINT tb_endereco_pkey PRIMARY KEY (tb_cliente_cpf);


--
-- TOC entry 1848 (class 2606 OID 32823)
-- Name: tb_gerente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tb_gerente
    ADD CONSTRAINT tb_gerente_pkey PRIMARY KEY (id);


--
-- TOC entry 1852 (class 2606 OID 32829)
-- Name: tb_conta_tb_cliente_cpf_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_conta
    ADD CONSTRAINT tb_conta_tb_cliente_cpf_fkey FOREIGN KEY (tb_cliente_cpf) REFERENCES tb_cliente(cpf);


--
-- TOC entry 1851 (class 2606 OID 32801)
-- Name: tb_endereco_tb_cliente_cpf_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_endereco
    ADD CONSTRAINT tb_endereco_tb_cliente_cpf_fkey FOREIGN KEY (tb_cliente_cpf) REFERENCES tb_cliente(cpf) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1972 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2014-11-01 17:32:58

--
-- PostgreSQL database dump complete
--

