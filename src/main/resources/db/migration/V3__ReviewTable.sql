-- write sql to create review table

create table if not exists review(
review_id int not null AUTO_INCREMENT PRIMARY KEY,
review varchar(100) not null,
product_id int not null,
constraint review_product_fk foreign key(product_id) references product(product_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into review(review, product_id) values ('This book is very good. And I recommend this book for Java lovers.', 1);

