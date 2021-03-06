drop table if exists db_to_key;

drop table if exists db_types;

drop table if exists feature_to_key;

drop table if exists features;

drop table if exists os_to_key;

drop table if exists license_keys;

drop table if exists customers;

drop table if exists license_types;

drop table if exists os_types;

drop table if exists user_role;

drop table if exists usr;

drop sequence if exists  hibernate_sequence;


create sequence hibernate_sequence start 2 increment 1;

create table customers
(
    id           int4 primary key not null,
    company_name varchar(2048),
    cust_email   varchar(2048),
    cust_name    varchar(2048),
    cust_phone   varchar(2048),
    сust_website varchar(2048)
);

create table db_to_key
(
    key_id  int4 not null,
    db_type int4 not null,
    primary key (db_type, key_id)
);

create table db_types
(
    id       int4  primary key not null,
    db_title text not null
   
);

create table feature_to_key
(
    key_id     int4 not null,
    feature_id int4 not null,
    primary key (feature_id, key_id)
);

create table features
(
    id int4 primary key not null ,
    feature_title text not null
);

create table license_keys
(
    id           int4 primary key not null,
    lic_comment  varchar(2048),
    end_date     timestamp,
    host         varchar(2048),
    lic_key      text,
    port         int4,
    start_date   timestamp,
    usr_id       int8,
    customer     int4,
    license_type int4
);

create table license_types
(
    id         int4 primary key not null ,
    type_title text not null
);

create table os_to_key
(
    os_id  int4 not null,
    key_id int4 not null,
    primary key (key_id, os_id)
);

create table os_types
(
    id       int4 primary key not null,
    os_title text not null
);

create table user_role
(
    user_id int8 primary key not null,
    roles   varchar(2048)
);

create table usr
(
    id              int8  primary key not null,
    activation_code varchar(2048),
    active          boolean not null,
    email           varchar(2048),
    file_name       varchar(2048),
    password        varchar(2048),
    phone_number    varchar(2048),
    username        varchar(2048)
    
);

alter table if exists db_types 
    add constraint db_types_db_title_uindex unique (db_title);

alter table if exists features 
    add constraint features_feature_title_uindex unique (feature_title);

alter table if exists license_types 
    add constraint license_types_type_title_uindex unique (type_title);

alter table if exists os_types 
    add constraint os_types_os_title_uindex unique (os_title);

alter table if exists db_to_key
    add constraint db_to_key_db_types
    foreign key (db_type) references db_types;

alter table if exists db_to_key 
    add constraint db_to_key_license_keys
    foreign key (key_id) references license_keys;

alter table if exists feature_to_key 
    add constraint feature_to_key_features_fk
    foreign key (feature_id) references features;

alter table if exists feature_to_key 
    add constraint feature_to_key_license_keys_fk
    foreign key (key_id) references license_keys;

alter table if exists license_keys 
    add constraint license_keys_usr
    foreign key (usr_id) references usr;

alter table if exists license_keys 
    add constraint license_keys_customers_fk
    foreign key (customer) references customers;

alter table if exists license_keys 
    add constraint license_keys_license_types
    foreign key (license_type) references license_types;

alter table if exists os_to_key 
    add constraint os_to_key_license_keys_fk
    foreign key (key_id) references license_keys;

alter table if exists os_to_key
    add constraint os_to_key_os_types_fk
    foreign key (os_id) references os_types;

alter table if exists user_role 
    add constraint user_role_user_fk 
    foreign key (user_id) references usr;