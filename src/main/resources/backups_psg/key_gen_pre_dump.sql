--
-- PostgreSQL database dump
--

-- Dumped from database version 13.6
-- Dumped by pg_dump version 13.6

-- Started on 2022-04-05 23:11:00

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3012 (class 1262 OID 16394)
-- Name: key_gen; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE key_gen WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Russian_Russia.1251';


ALTER DATABASE key_gen OWNER TO postgres;

\connect key_gen

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 206 (class 1259 OID 24588)
-- Name: customers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customers (
    id integer NOT NULL,
    cust_name character varying,
    cust_email character varying,
    cust_phone character varying,
    "сust_website" character varying
);


ALTER TABLE public.customers OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 24586)
-- Name: customers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.customers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customers_id_seq OWNER TO postgres;

--
-- TOC entry 3013 (class 0 OID 0)
-- Dependencies: 205
-- Name: customers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.customers_id_seq OWNED BY public.customers.id;


--
-- TOC entry 217 (class 1259 OID 24759)
-- Name: db_to_key; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.db_to_key (
    db_type integer NOT NULL,
    key_id integer NOT NULL
);


ALTER TABLE public.db_to_key OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 24749)
-- Name: db_types; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.db_types (
    id integer NOT NULL,
    db_title character varying NOT NULL
);


ALTER TABLE public.db_types OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 24747)
-- Name: db_types_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.db_types_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.db_types_id_seq OWNER TO postgres;

--
-- TOC entry 3014 (class 0 OID 0)
-- Dependencies: 215
-- Name: db_types_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.db_types_id_seq OWNED BY public.db_types.id;


--
-- TOC entry 214 (class 1259 OID 24731)
-- Name: feature_to_key; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.feature_to_key (
    feature_id integer NOT NULL,
    key_id integer NOT NULL
);


ALTER TABLE public.feature_to_key OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 24695)
-- Name: features; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.features (
    id integer NOT NULL,
    feature_title character varying NOT NULL
);


ALTER TABLE public.features OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 24693)
-- Name: features_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.features_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.features_id_seq OWNER TO postgres;

--
-- TOC entry 3015 (class 0 OID 0)
-- Dependencies: 211
-- Name: features_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.features_id_seq OWNED BY public.features.id;


--
-- TOC entry 200 (class 1259 OID 16395)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16397)
-- Name: license_keys; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.license_keys (
    id integer NOT NULL,
    customer integer,
    host character varying,
    port integer,
    lic_key character varying,
    usr_id bigint,
    lic_comment character varying,
    product_name character varying,
    start_date date,
    end_date date
);


ALTER TABLE public.license_keys OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 16403)
-- Name: license_keys_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.license_keys_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.license_keys_id_seq OWNER TO postgres;

--
-- TOC entry 3016 (class 0 OID 0)
-- Dependencies: 202
-- Name: license_keys_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.license_keys_id_seq OWNED BY public.license_keys.id;


--
-- TOC entry 208 (class 1259 OID 24623)
-- Name: license_types; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.license_types (
    id integer NOT NULL,
    type_title character varying NOT NULL
);


ALTER TABLE public.license_types OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 24621)
-- Name: license_types_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.license_types_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.license_types_id_seq OWNER TO postgres;

--
-- TOC entry 3017 (class 0 OID 0)
-- Dependencies: 207
-- Name: license_types_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.license_types_id_seq OWNED BY public.license_types.id;


--
-- TOC entry 213 (class 1259 OID 24716)
-- Name: os_to_key; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.os_to_key (
    os_id integer NOT NULL,
    key_id integer NOT NULL
);


ALTER TABLE public.os_to_key OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 24647)
-- Name: os_types; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.os_types (
    id integer NOT NULL,
    os_title character varying NOT NULL
);


ALTER TABLE public.os_types OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 24645)
-- Name: os_types_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.os_types_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.os_types_id_seq OWNER TO postgres;

--
-- TOC entry 3018 (class 0 OID 0)
-- Dependencies: 209
-- Name: os_types_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.os_types_id_seq OWNED BY public.os_types.id;


--
-- TOC entry 203 (class 1259 OID 16405)
-- Name: user_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_role (
    user_id bigint NOT NULL,
    roles character varying(255)
);


ALTER TABLE public.user_role OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16408)
-- Name: usr; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usr (
    id bigint NOT NULL,
    active boolean NOT NULL,
    password character varying(255),
    username character varying(255),
    usr_email character varying,
    usr_phone_number character varying,
    usr_name character varying
);


ALTER TABLE public.usr OWNER TO postgres;

--
-- TOC entry 2821 (class 2604 OID 24591)
-- Name: customers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers ALTER COLUMN id SET DEFAULT nextval('public.customers_id_seq'::regclass);


--
-- TOC entry 2825 (class 2604 OID 24752)
-- Name: db_types id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.db_types ALTER COLUMN id SET DEFAULT nextval('public.db_types_id_seq'::regclass);


--
-- TOC entry 2824 (class 2604 OID 24698)
-- Name: features id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.features ALTER COLUMN id SET DEFAULT nextval('public.features_id_seq'::regclass);


--
-- TOC entry 2820 (class 2604 OID 16414)
-- Name: license_keys id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.license_keys ALTER COLUMN id SET DEFAULT nextval('public.license_keys_id_seq'::regclass);


--
-- TOC entry 2822 (class 2604 OID 24626)
-- Name: license_types id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.license_types ALTER COLUMN id SET DEFAULT nextval('public.license_types_id_seq'::regclass);


--
-- TOC entry 2823 (class 2604 OID 24650)
-- Name: os_types id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.os_types ALTER COLUMN id SET DEFAULT nextval('public.os_types_id_seq'::regclass);


--
-- TOC entry 2995 (class 0 OID 24588)
-- Dependencies: 206
-- Data for Name: customers; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.customers (id, cust_name, cust_email, cust_phone, "сust_website") VALUES (1, 'kgeu', 'kgeu@kgeu.ru', '(843)519-42-20', 'https://kgeu.ru/');


--
-- TOC entry 3006 (class 0 OID 24759)
-- Dependencies: 217
-- Data for Name: db_to_key; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.db_to_key (db_type, key_id) VALUES (1, 53);


--
-- TOC entry 3005 (class 0 OID 24749)
-- Dependencies: 216
-- Data for Name: db_types; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.db_types (id, db_title) VALUES (1, 'Any');
INSERT INTO public.db_types (id, db_title) VALUES (2, 'Aurora');
INSERT INTO public.db_types (id, db_title) VALUES (3, 'AuroraPgSQL');
INSERT INTO public.db_types (id, db_title) VALUES (4, 'DB2');
INSERT INTO public.db_types (id, db_title) VALUES (5, 'Greenplum');
INSERT INTO public.db_types (id, db_title) VALUES (6, 'Hive');
INSERT INTO public.db_types (id, db_title) VALUES (7, 'MariaDB');
INSERT INTO public.db_types (id, db_title) VALUES (8, 'MSSQL');
INSERT INTO public.db_types (id, db_title) VALUES (9, 'MySQL');
INSERT INTO public.db_types (id, db_title) VALUES (10, 'Netezza');
INSERT INTO public.db_types (id, db_title) VALUES (11, 'Oracle');
INSERT INTO public.db_types (id, db_title) VALUES (12, 'PostgreSQL');
INSERT INTO public.db_types (id, db_title) VALUES (13, 'Redshift');
INSERT INTO public.db_types (id, db_title) VALUES (14, 'SAP HANA');
INSERT INTO public.db_types (id, db_title) VALUES (15, 'Teradata');
INSERT INTO public.db_types (id, db_title) VALUES (16, 'Vertica');
INSERT INTO public.db_types (id, db_title) VALUES (17, 'MongoDB');
INSERT INTO public.db_types (id, db_title) VALUES (18, 'Cassandra');
INSERT INTO public.db_types (id, db_title) VALUES (19, 'Impala');
INSERT INTO public.db_types (id, db_title) VALUES (20, 'Informix');
INSERT INTO public.db_types (id, db_title) VALUES (21, 'Redis');
INSERT INTO public.db_types (id, db_title) VALUES (22, 'Athena');
INSERT INTO public.db_types (id, db_title) VALUES (23, 'S3');


--
-- TOC entry 3003 (class 0 OID 24731)
-- Dependencies: 214
-- Data for Name: feature_to_key; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.feature_to_key (feature_id, key_id) VALUES (1, 53);


--
-- TOC entry 3001 (class 0 OID 24695)
-- Dependencies: 212
-- Data for Name: features; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.features (id, feature_title) VALUES (1, 'Security');
INSERT INTO public.features (id, feature_title) VALUES (2, 'Audit');
INSERT INTO public.features (id, feature_title) VALUES (3, 'Dynamic Masking');
INSERT INTO public.features (id, feature_title) VALUES (4, 'Static Masking');
INSERT INTO public.features (id, feature_title) VALUES (5, 'Search Data');
INSERT INTO public.features (id, feature_title) VALUES (6, 'Performance Monitor');


--
-- TOC entry 2990 (class 0 OID 16397)
-- Dependencies: 201
-- Data for Name: license_keys; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.license_keys (id, customer, host, port, lic_key, usr_id, lic_comment, company_name, start_date, end_date) VALUES (56, 1, '233.14.15.01', 8084, 'e2N1c3RvbWVyPSdHb29kQmFuaycsIGxpY2Vuc2VUeXBlPSdUUklBTCcsIGhvc3Q9JzIzMy4xNC4xNS4wMScsIHBvcnQ9ODA4NCwgb3BlclN5c3RlbT0nbnVsbCd9{customer=''GoodBank'', licenseType=''TRIAL'', host=''233.14.15.01'', port=8084, operSystem=''null''}', 23, NULL, NULL, NULL, NULL);
INSERT INTO public.license_keys (id, customer, host, port, lic_key, usr_id, lic_comment, company_name, start_date, end_date) VALUES (58, 1, '168.33.11.23', 3301, 'e2N1c3RvbWVyPSdJbmNvcicsIGxpY2Vuc2VUeXBlPSdURU1QJywgaG9zdD0nMTY4LjMzLjExLjIzJywgcG9ydD0zMzAxLCBvcGVyU3lzdGVtPSdudWxsJ30={customer=''Incor'', licenseType=''TEMP'', host=''168.33.11.23'', port=3301, operSystem=''null''}', 23, NULL, NULL, NULL, NULL);
INSERT INTO public.license_keys (id, customer, host, port, lic_key, usr_id, lic_comment, company_name, start_date, end_date) VALUES (49, 1, 'local', 1111, 'e2N1c3RvbWVyPSdOaWtvbGF5JywgbGljZW5zZVR5cGU9J0RFVicsIGhvc3Q9J2xvY2FsJywgcG9ydD0xMTExLCBvcGVyU3lzdGVtPSdudWxsJ30={customer=''Nikolay'', licenseType=''DEV'', host=''local'', port=1111, operSystem=''null''}', 1, NULL, NULL, NULL, NULL);
INSERT INTO public.license_keys (id, customer, host, port, lic_key, usr_id, lic_comment, company_name, start_date, end_date) VALUES (55, 1, '123.44.55.66', 2222, 'e2N1c3RvbWVyPSdTdHJvaUludmVzdCcsIGxpY2Vuc2VUeXBlPSdERVYnLCBob3N0PScxMjMuNDQuNTUuNjYnLCBwb3J0PTIyMjIsIG9wZXJTeXN0ZW09J251bGwnfQ=={customer=''StroiInvest'', licenseType=''DEV'', host=''123.44.55.66'', port=2222, operSystem=''null''}', 23, NULL, NULL, NULL, NULL);
INSERT INTO public.license_keys (id, customer, host, port, lic_key, usr_id, lic_comment, company_name, start_date, end_date) VALUES (61, 1, '111.33.123.11', 6678, 'e2N1c3RvbWVyPSdUQU5ERU0nLCBsaWNlbnNlVHlwZT0nUEVSTScsIGhvc3Q9JzExMS4zMy4xMjMuMTEnLCBwb3J0PTY2NzgsIG9wZXJTeXN0ZW09J251bGwnfQ=={customer=''TANDEM'', licenseType=''PERM'', host=''111.33.123.11'', port=6678, operSystem=''null''}', 23, NULL, NULL, NULL, NULL);
INSERT INTO public.license_keys (id, customer, host, port, lic_key, usr_id, lic_comment, company_name, start_date, end_date) VALUES (60, 1, '188.33.21.12', 3345, 'e2N1c3RvbWVyPSdLR0VVJywgbGljZW5zZVR5cGU9J1RFTVAnLCBob3N0PScxODguMzMuMjEuMTInLCBwb3J0PTMzNDUsIG9wZXJTeXN0ZW09J251bGwnfQ=={customer=''KGEU'', licenseType=''TEMP'', host=''188.33.21.12'', port=3345, operSystem=''null''}', 23, NULL, NULL, NULL, NULL);
INSERT INTO public.license_keys (id, customer, host, port, lic_key, usr_id, lic_comment, company_name, start_date, end_date) VALUES (54, 1, 'localhost', 1234, 'e2N1c3RvbWVyPSdyb21hJywgbGljZW5zZVR5cGU9J1RSSUFMJywgaG9zdD0nbG9jYWxob3N0JywgcG9ydD0xMjM0LCBvcGVyU3lzdGVtPSdudWxsJ30={customer=''roma'', licenseType=''TRIAL'', host=''localhost'', port=1234, operSystem=''null''}', 1, NULL, NULL, NULL, NULL);
INSERT INTO public.license_keys (id, customer, host, port, lic_key, usr_id, lic_comment, company_name, start_date, end_date) VALUES (59, 1, 'localhost', 1921, 'e2N1c3RvbWVyPSdBUk1PUl9ERVZTJywgbGljZW5zZVR5cGU9J0RFVicsIGhvc3Q9J2xvY2FsaG9zdCcsIHBvcnQ9MTkyMSwgb3BlclN5c3RlbT0nbnVsbCd9{customer=''ARMOR_DEVS'', licenseType=''DEV'', host=''localhost'', port=1921, operSystem=''null''}', 23, NULL, NULL, NULL, NULL);
INSERT INTO public.license_keys (id, customer, host, port, lic_key, usr_id, lic_comment, company_name, start_date, end_date) VALUES (57, 1, '111.222.333.444', 1212, 'e2N1c3RvbWVyPSdDb21DcmVkaXQnLCBsaWNlbnNlVHlwZT0nUEVSTScsIGhvc3Q9JzExMS4yMjIuMzMzLjQ0NCcsIHBvcnQ9MTIxMiwgb3BlclN5c3RlbT0nbnVsbCd9{customer=''ComCredit'', licenseType=''PERM'', host=''111.222.333.444'', port=1212, operSystem=''null''}', 23, NULL, NULL, NULL, NULL);
INSERT INTO public.license_keys (id, customer, host, port, lic_key, usr_id, lic_comment, company_name, start_date, end_date) VALUES (53, 1, '192.127.1.1.', 1111, 'e2N1c3RvbWVyPSdOYWlsJywgbGljZW5zZVR5cGU9J1BFUk0nLCBob3N0PScxOTIuMTI3LjEuMS4nLCBwb3J0PTExMTEsIG9wZXJTeXN0ZW09J251bGwnfQ=={customer=''Nail'', licenseType=''PERM'', host=''192.127.1.1.'', port=1111, operSystem=''null''}', 1, NULL, NULL, NULL, NULL);


--
-- TOC entry 2997 (class 0 OID 24623)
-- Dependencies: 208
-- Data for Name: license_types; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.license_types (id, type_title) VALUES (1, 'Perpetual');
INSERT INTO public.license_types (id, type_title) VALUES (2, 'Trial');
INSERT INTO public.license_types (id, type_title) VALUES (3, 'Term');
INSERT INTO public.license_types (id, type_title) VALUES (4, 'Metered');


--
-- TOC entry 3002 (class 0 OID 24716)
-- Dependencies: 213
-- Data for Name: os_to_key; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.os_to_key (os_id, key_id) VALUES (1, 53);


--
-- TOC entry 2999 (class 0 OID 24647)
-- Dependencies: 210
-- Data for Name: os_types; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.os_types (id, os_title) VALUES (1, 'Windows');
INSERT INTO public.os_types (id, os_title) VALUES (2, 'Solaris');
INSERT INTO public.os_types (id, os_title) VALUES (3, 'FreeBSD');
INSERT INTO public.os_types (id, os_title) VALUES (4, 'Linux');


--
-- TOC entry 2992 (class 0 OID 16405)
-- Dependencies: 203
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_role (user_id, roles) VALUES (1, 'ADMIN');
INSERT INTO public.user_role (user_id, roles) VALUES (23, 'USER');


--
-- TOC entry 2993 (class 0 OID 16408)
-- Dependencies: 204
-- Data for Name: usr; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usr (id, active, password, username, usr_email, usr_phone_number, usr_name) VALUES (23, true, 'admin', 'admin', NULL, NULL, NULL);
INSERT INTO public.usr (id, active, password, username, usr_email, usr_phone_number, usr_name) VALUES (1, true, 'user', 'user', NULL, NULL, NULL);


--
-- TOC entry 3019 (class 0 OID 0)
-- Dependencies: 205
-- Name: customers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.customers_id_seq', 1, true);


--
-- TOC entry 3020 (class 0 OID 0)
-- Dependencies: 215
-- Name: db_types_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.db_types_id_seq', 23, true);


--
-- TOC entry 3021 (class 0 OID 0)
-- Dependencies: 211
-- Name: features_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.features_id_seq', 6, true);


--
-- TOC entry 3022 (class 0 OID 0)
-- Dependencies: 200
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 61, true);


--
-- TOC entry 3023 (class 0 OID 0)
-- Dependencies: 202
-- Name: license_keys_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.license_keys_id_seq', 2, true);


--
-- TOC entry 3024 (class 0 OID 0)
-- Dependencies: 207
-- Name: license_types_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.license_types_id_seq', 1, false);


--
-- TOC entry 3025 (class 0 OID 0)
-- Dependencies: 209
-- Name: os_types_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.os_types_id_seq', 1, false);


--
-- TOC entry 2831 (class 2606 OID 24596)
-- Name: customers customers_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pk PRIMARY KEY (id);


--
-- TOC entry 2849 (class 2606 OID 24763)
-- Name: db_to_key db_to_key_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.db_to_key
    ADD CONSTRAINT db_to_key_pkey PRIMARY KEY (db_type, key_id);


--
-- TOC entry 2847 (class 2606 OID 24757)
-- Name: db_types db_types_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.db_types
    ADD CONSTRAINT db_types_pk PRIMARY KEY (id);


--
-- TOC entry 2844 (class 2606 OID 24735)
-- Name: feature_to_key feature_to_key_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.feature_to_key
    ADD CONSTRAINT feature_to_key_pkey PRIMARY KEY (feature_id, key_id);


--
-- TOC entry 2840 (class 2606 OID 24700)
-- Name: features features_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.features
    ADD CONSTRAINT features_pk PRIMARY KEY (id);


--
-- TOC entry 2827 (class 2606 OID 16416)
-- Name: license_keys license_keys_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.license_keys
    ADD CONSTRAINT license_keys_pk PRIMARY KEY (id);


--
-- TOC entry 2833 (class 2606 OID 24631)
-- Name: license_types license_types_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.license_types
    ADD CONSTRAINT license_types_pk PRIMARY KEY (id);


--
-- TOC entry 2842 (class 2606 OID 24720)
-- Name: os_to_key os_to_key_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.os_to_key
    ADD CONSTRAINT os_to_key_pkey PRIMARY KEY (os_id, key_id);


--
-- TOC entry 2837 (class 2606 OID 24655)
-- Name: os_types os_types_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.os_types
    ADD CONSTRAINT os_types_pk PRIMARY KEY (id);


--
-- TOC entry 2829 (class 2606 OID 16418)
-- Name: usr usr_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usr
    ADD CONSTRAINT usr_pkey PRIMARY KEY (id);


--
-- TOC entry 2845 (class 1259 OID 24758)
-- Name: db_types_db_title_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX db_types_db_title_uindex ON public.db_types USING btree (db_title);


--
-- TOC entry 2838 (class 1259 OID 24702)
-- Name: features_feature_title_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX features_feature_title_uindex ON public.features USING btree (feature_title);


--
-- TOC entry 2834 (class 1259 OID 24632)
-- Name: license_types_type_title_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX license_types_type_title_uindex ON public.license_types USING btree (type_title);


--
-- TOC entry 2835 (class 1259 OID 24656)
-- Name: os_types_os_title_uindex; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX os_types_os_title_uindex ON public.os_types USING btree (os_title);


--
-- TOC entry 2857 (class 2606 OID 24764)
-- Name: db_to_key db_type_key_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.db_to_key
    ADD CONSTRAINT db_type_key_ibfk_1 FOREIGN KEY (db_type) REFERENCES public.db_types(id);


--
-- TOC entry 2858 (class 2606 OID 24769)
-- Name: db_to_key db_type_key_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.db_to_key
    ADD CONSTRAINT db_type_key_ibfk_2 FOREIGN KEY (key_id) REFERENCES public.license_keys(id);


--
-- TOC entry 2855 (class 2606 OID 24736)
-- Name: feature_to_key employee_project_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.feature_to_key
    ADD CONSTRAINT employee_project_ibfk_1 FOREIGN KEY (feature_id) REFERENCES public.features(id);


--
-- TOC entry 2856 (class 2606 OID 24741)
-- Name: feature_to_key employee_project_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.feature_to_key
    ADD CONSTRAINT employee_project_ibfk_2 FOREIGN KEY (key_id) REFERENCES public.license_keys(id);


--
-- TOC entry 2850 (class 2606 OID 16419)
-- Name: license_keys fk9eimpuvhq6pkukhd3je5b8us0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.license_keys
    ADD CONSTRAINT fk9eimpuvhq6pkukhd3je5b8us0 FOREIGN KEY (usr_id) REFERENCES public.usr(id);


--
-- TOC entry 2852 (class 2606 OID 16424)
-- Name: user_role fkfpm8swft53ulq2hl11yplpr5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fkfpm8swft53ulq2hl11yplpr5 FOREIGN KEY (user_id) REFERENCES public.usr(id);


--
-- TOC entry 2851 (class 2606 OID 24616)
-- Name: license_keys license_keys_customers_id_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.license_keys
    ADD CONSTRAINT license_keys_customers_id_fk FOREIGN KEY (customer) REFERENCES public.customers(id);


--
-- TOC entry 2853 (class 2606 OID 24721)
-- Name: os_to_key os_key_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.os_to_key
    ADD CONSTRAINT os_key_ibfk_1 FOREIGN KEY (os_id) REFERENCES public.os_types(id);


--
-- TOC entry 2854 (class 2606 OID 24726)
-- Name: os_to_key os_key_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.os_to_key
    ADD CONSTRAINT os_key_ibfk_2 FOREIGN KEY (key_id) REFERENCES public.license_keys(id);


-- Completed on 2022-04-05 23:11:00

--
-- PostgreSQL database dump complete
--

