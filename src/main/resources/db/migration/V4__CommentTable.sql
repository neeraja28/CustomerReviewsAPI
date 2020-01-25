-- write sql to create comment table

create table if not exists comment(
comment_id int not null AUTO_INCREMENT PRIMARY KEY,
comment varchar(100) not null,
review_id int not null,
constraint comment_review_fk foreign key(review_id) references review(review_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into comment(comment, review_id) values ('I agree with this review.', 1);
