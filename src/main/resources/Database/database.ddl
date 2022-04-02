create sequence "Order_order_nr_seq";

alter sequence "Order_order_nr_seq" owner to postgres;

create sequence user_id_seq;

alter sequence user_id_seq owner to postgres;

create sequence role_id_seq;

alter sequence role_id_seq owner to postgres;

create sequence web_user_and_role_web_and_role_id_seq;

alter sequence web_user_and_role_web_and_role_id_seq owner to postgres;

create table product
(
    product_nr bigserial
        constraint product_pkey
            primary key,
    name text not null,
    description text,
    price numeric(5,2) not null,
    category text,
    image_path text not null
);

alter table product owner to postgres;

create table cart
(
    cart_nr bigserial
        constraint cart_pk
            primary key,
    amount_of_products integer not null,
    total_price double precision not null,
    ordered boolean not null,
    products bigint
);

alter table cart owner to postgres;

create unique index cart_cart_nr_uindex
    on cart (cart_nr);

create table order_
(
    order_nr bigint default nextval('"Order_order_nr_seq"'::regclass) not null,
    completed boolean not null,
    cart bigint
        constraint order_to_cart
            references cart
);

alter table order_ owner to postgres;

alter sequence "Order_order_nr_seq" owned by order_.order_nr;

create unique index order_order_nr_uindex
    on order_ (order_nr);

create table storage
(
    product bigint not null
        constraint storage_pk
            primary key
        constraint storage_product_product_nr_fk
            references product
            on delete cascade,
    amount integer not null,
    sold_out boolean not null
);

alter table storage owner to postgres;

create table cart_item
(
    id bigserial
        constraint cart_item_pkey
            primary key,
    amount integer not null,
    cart_cart_nr bigint,
    product_product_nr bigint
);

alter table cart_item owner to postgres;

create table cart_products
(
    cart_cart_nr bigint not null
        constraint fk718n6g5rjodq98pa1si29t88c
            references cart,
    products_id bigint not null
        constraint uk_3kg5kx19f8oy0lo76hdhc1uw1
            unique
        constraint fkl6gc2hlt3sp5gagbejnehi9nt
            references cart_item
);

alter table cart_products owner to postgres;

create table web_user
(
    id bigint default nextval('user_id_seq'::regclass) not null
        constraint user_pk
            primary key,
    name text,
    email text,
    passcode text,
    roles bigint
);

alter table web_user owner to postgres;

alter sequence user_id_seq owned by web_user.id;

create unique index user_id_uindex
    on web_user (id);

create table role_
(
    id bigint default nextval('role_id_seq'::regclass) not null
        constraint role_pk
            primary key,
    role text
);

alter table role_ owner to postgres;

alter sequence role_id_seq owned by role_.id;

create table web_user_roles
(
    web_and_role_id bigint default nextval('web_user_and_role_web_and_role_id_seq'::regclass) not null
        constraint web_user_and_role_pk
            primary key,
    roles_id bigint
        constraint web_user_roles_role__role_id_fk
            references role_,
    web_user_id bigint
        constraint web_user_roles_web_user_id_fk
            references web_user
);

alter table web_user_roles owner to postgres;

alter sequence web_user_and_role_web_and_role_id_seq owned by web_user_roles.web_and_role_id;

