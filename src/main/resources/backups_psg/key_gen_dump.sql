--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

-- Started on 2022-04-04 22:53:17

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
-- TOC entry 3009 (class 1262 OID 19277)
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

--
-- TOC entry 200 (class 1259 OID 19293)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 19314)
-- Name: license_keys; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.license_keys (
    id integer NOT NULL,
    customer character varying,
    license_type character varying,
    host character varying,
    port integer,
    os character varying,
    lic_key character varying,
    usr_id bigint
);


ALTER TABLE public.license_keys OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 19322)
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
-- TOC entry 3010 (class 0 OID 0)
-- Dependencies: 204
-- Name: license_keys_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.license_keys_id_seq OWNED BY public.license_keys.id;


--
-- TOC entry 201 (class 1259 OID 19295)
-- Name: user_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_role (
    user_id bigint NOT NULL,
    roles character varying(255)
);


ALTER TABLE public.user_role OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 19298)
-- Name: usr; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usr (
    id bigint NOT NULL,
    active boolean NOT NULL,
    password character varying(255),
    username character varying(255)
);


ALTER TABLE public.usr OWNER TO postgres;

--
-- TOC entry 2862 (class 2604 OID 19324)
-- Name: license_keys id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.license_keys ALTER COLUMN id SET DEFAULT nextval('public.license_keys_id_seq'::regclass);


--
-- TOC entry 3002 (class 0 OID 19314)
-- Dependencies: 203
-- Data for Name: license_keys; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.license_keys (id, customer, license_type, host, port, os, lic_key, usr_id) VALUES (49, 'Nikolay', 'DEV', 'local', 1111, NULL, 'e2N1c3RvbWVyPSdOaWtvbGF5JywgbGljZW5zZVR5cGU9J0RFVicsIGhvc3Q9J2xvY2FsJywgcG9ydD0xMTExLCBvcGVyU3lzdGVtPSdudWxsJ30={customer=''Nikolay'', licenseType=''DEV'', host=''local'', port=1111, operSystem=''null''}', 1);
INSERT INTO public.license_keys (id, customer, license_type, host, port, os, lic_key, usr_id) VALUES (53, 'Nail', 'PERM', '192.127.1.1.', 1111, NULL, 'e2N1c3RvbWVyPSdOYWlsJywgbGljZW5zZVR5cGU9J1BFUk0nLCBob3N0PScxOTIuMTI3LjEuMS4nLCBwb3J0PTExMTEsIG9wZXJTeXN0ZW09J251bGwnfQ=={customer=''Nail'', licenseType=''PERM'', host=''192.127.1.1.'', port=1111, operSystem=''null''}', 1);
INSERT INTO public.license_keys (id, customer, license_type, host, port, os, lic_key, usr_id) VALUES (54, 'roma', 'TRIAL', 'localhost', 1234, NULL, 'e2N1c3RvbWVyPSdyb21hJywgbGljZW5zZVR5cGU9J1RSSUFMJywgaG9zdD0nbG9jYWxob3N0JywgcG9ydD0xMjM0LCBvcGVyU3lzdGVtPSdudWxsJ30={customer=''roma'', licenseType=''TRIAL'', host=''localhost'', port=1234, operSystem=''null''}', 1);
INSERT INTO public.license_keys (id, customer, license_type, host, port, os, lic_key, usr_id) VALUES (55, 'StroiInvest', 'DEV', '123.44.55.66', 2222, NULL, 'e2N1c3RvbWVyPSdTdHJvaUludmVzdCcsIGxpY2Vuc2VUeXBlPSdERVYnLCBob3N0PScxMjMuNDQuNTUuNjYnLCBwb3J0PTIyMjIsIG9wZXJTeXN0ZW09J251bGwnfQ=={customer=''StroiInvest'', licenseType=''DEV'', host=''123.44.55.66'', port=2222, operSystem=''null''}', 23);
INSERT INTO public.license_keys (id, customer, license_type, host, port, os, lic_key, usr_id) VALUES (56, 'GoodBank', 'TRIAL', '233.14.15.01', 8084, NULL, 'e2N1c3RvbWVyPSdHb29kQmFuaycsIGxpY2Vuc2VUeXBlPSdUUklBTCcsIGhvc3Q9JzIzMy4xNC4xNS4wMScsIHBvcnQ9ODA4NCwgb3BlclN5c3RlbT0nbnVsbCd9{customer=''GoodBank'', licenseType=''TRIAL'', host=''233.14.15.01'', port=8084, operSystem=''null''}', 23);
INSERT INTO public.license_keys (id, customer, license_type, host, port, os, lic_key, usr_id) VALUES (57, 'ComCredit', 'PERM', '111.222.333.444', 1212, NULL, 'e2N1c3RvbWVyPSdDb21DcmVkaXQnLCBsaWNlbnNlVHlwZT0nUEVSTScsIGhvc3Q9JzExMS4yMjIuMzMzLjQ0NCcsIHBvcnQ9MTIxMiwgb3BlclN5c3RlbT0nbnVsbCd9{customer=''ComCredit'', licenseType=''PERM'', host=''111.222.333.444'', port=1212, operSystem=''null''}', 23);
INSERT INTO public.license_keys (id, customer, license_type, host, port, os, lic_key, usr_id) VALUES (58, 'Incor', 'TEMP', '168.33.11.23', 3301, NULL, 'e2N1c3RvbWVyPSdJbmNvcicsIGxpY2Vuc2VUeXBlPSdURU1QJywgaG9zdD0nMTY4LjMzLjExLjIzJywgcG9ydD0zMzAxLCBvcGVyU3lzdGVtPSdudWxsJ30={customer=''Incor'', licenseType=''TEMP'', host=''168.33.11.23'', port=3301, operSystem=''null''}', 23);
INSERT INTO public.license_keys (id, customer, license_type, host, port, os, lic_key, usr_id) VALUES (59, 'ARMOR_DEVS', 'DEV', 'localhost', 1921, NULL, 'e2N1c3RvbWVyPSdBUk1PUl9ERVZTJywgbGljZW5zZVR5cGU9J0RFVicsIGhvc3Q9J2xvY2FsaG9zdCcsIHBvcnQ9MTkyMSwgb3BlclN5c3RlbT0nbnVsbCd9{customer=''ARMOR_DEVS'', licenseType=''DEV'', host=''localhost'', port=1921, operSystem=''null''}', 23);
INSERT INTO public.license_keys (id, customer, license_type, host, port, os, lic_key, usr_id) VALUES (60, 'KGEU', 'TEMP', '188.33.21.12', 3345, NULL, 'e2N1c3RvbWVyPSdLR0VVJywgbGljZW5zZVR5cGU9J1RFTVAnLCBob3N0PScxODguMzMuMjEuMTInLCBwb3J0PTMzNDUsIG9wZXJTeXN0ZW09J251bGwnfQ=={customer=''KGEU'', licenseType=''TEMP'', host=''188.33.21.12'', port=3345, operSystem=''null''}', 23);
INSERT INTO public.license_keys (id, customer, license_type, host, port, os, lic_key, usr_id) VALUES (61, 'TANDEM', 'PERM', '111.33.123.11', 6678, NULL, 'e2N1c3RvbWVyPSdUQU5ERU0nLCBsaWNlbnNlVHlwZT0nUEVSTScsIGhvc3Q9JzExMS4zMy4xMjMuMTEnLCBwb3J0PTY2NzgsIG9wZXJTeXN0ZW09J251bGwnfQ=={customer=''TANDEM'', licenseType=''PERM'', host=''111.33.123.11'', port=6678, operSystem=''null''}', 23);


--
-- TOC entry 3000 (class 0 OID 19295)
-- Dependencies: 201
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.user_role (user_id, roles) VALUES (1, 'ADMIN');
INSERT INTO public.user_role (user_id, roles) VALUES (23, 'USER');


--
-- TOC entry 3001 (class 0 OID 19298)
-- Dependencies: 202
-- Data for Name: usr; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usr (id, active, password, username) VALUES (23, true, 'admin', 'admin');
INSERT INTO public.usr (id, active, password, username) VALUES (1, true, 'user', 'user');


--
-- TOC entry 3011 (class 0 OID 0)
-- Dependencies: 200
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hibernate_sequence', 61, true);


--
-- TOC entry 3012 (class 0 OID 0)
-- Dependencies: 204
-- Name: license_keys_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.license_keys_id_seq', 2, true);


--
-- TOC entry 2866 (class 2606 OID 19321)
-- Name: license_keys license_keys_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.license_keys
    ADD CONSTRAINT license_keys_pk PRIMARY KEY (id);


--
-- TOC entry 2864 (class 2606 OID 19305)
-- Name: usr usr_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usr
    ADD CONSTRAINT usr_pkey PRIMARY KEY (id);


--
-- TOC entry 2868 (class 2606 OID 19325)
-- Name: license_keys fk9eimpuvhq6pkukhd3je5b8us0; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.license_keys
    ADD CONSTRAINT fk9eimpuvhq6pkukhd3je5b8us0 FOREIGN KEY (usr_id) REFERENCES public.usr(id);


--
-- TOC entry 2867 (class 2606 OID 19306)
-- Name: user_role fkfpm8swft53ulq2hl11yplpr5; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_role
    ADD CONSTRAINT fkfpm8swft53ulq2hl11yplpr5 FOREIGN KEY (user_id) REFERENCES public.usr(id);


-- Completed on 2022-04-04 22:53:18

--
-- PostgreSQL database dump complete
--

