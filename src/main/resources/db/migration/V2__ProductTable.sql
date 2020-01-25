-- write sql to create product table

create table if not exists product (
product_id int not null AUTO_INCREMENT PRIMARY KEY,
product_name varchar(20) not null
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

insert into product(product_name) values ('books');







