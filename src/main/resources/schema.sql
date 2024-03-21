create table netology.CUSTOMERS
(
    id           serial primary key,
    name         varchar(70),
    surname      varchar(70),
    age          int,
    phone_number varchar(20)
);

create table netology.ORDERS
(
    id           serial primary key,
    date         date,
    customer_id  int references netology.customers (id),
    product_name varchar(100),
    amount       int
);


insert into netology.CUSTOMERS
values (default, 'maria', 'sockolova', 14, '8(999) 99-99-044');
insert into netology.CUSTOMERS
values (default, 'anna', 'petrova', 24, '8(999) 99-99-045');
insert into netology.CUSTOMERS
values (default, 'alexey', 'ivanov', 29, '8(999) 99-99-089');
insert into netology.CUSTOMERS
values (default, 'semen', 'lebedev', 69, '8(999) 99-99-079');
insert into netology.CUSTOMERS
values (default, 'igor', 'ivanov', 32, '8(999) 99-99-016');


insert into netology.ORDERS
values (default, '2022-06-16', 1, 'iphone 13', 1);
insert into netology.ORDERS
values (default, '2022-06-16', 2, 'sony headphone', 4);
insert into netology.ORDERS
values (default, '2022-06-17', 3, 'samsung monitor', 2);
insert into netology.ORDERS
values (default, '2022-06-18', 4, 'monsher microwave', 1);
insert into netology.ORDERS
values (default, '2022-06-18', 5, 'charger apple', 2);


