create database book_management;
use book_management;
-- drop database book_management;
create table authors (
authorId int not null auto_increment primary key,
firstName varchar(80) not null,
lastName varchar(80) not null,
country varchar(80) not null,
dateOfBirth date not null);
create table books (
bookId int not null auto_increment primary key,
title varchar(150) not null,
description varchar(225) not null,
authorId int not null,
isbn varchar(50) not null);
create table reviews (
reviewId int not null auto_increment primary key,
bookId int not null,
score double not null,
comment varchar (300) not null);
alter table books
add constraint fk_book_author
foreign key (authorId)
references authors (authorId);
alter table reviews
add constraint fk_reviews_book
foreign key (bookId)
references books (bookId);

-- drop table authors;
INSERT INTO authors 
(firstName,lastName, country,dateOfBirth)
VALUES
    -- ('J.D.','Salinger', 'USA','1919-01-27'),
    ('F. Scott.','Fitzgerald', 'USA','1896-09-24'),
    ('Jane','Austen', 'UK','1775-12-16'),
    ('Scott','Hanselman', 'USA','1973-01-22'),
    ('Jason N.','Gaylord', 'USA','1972-01-18');
    -- ('Pranav','Rastogi', 'India','1994-07-14'),
    -- ('Todd','Miranda', 'USA','1968-09-09'),
    -- ('Christian','Wenz', 'USA','1986-01-01')
;
select*from authors;
select*from books;
select*from reviews;
update reviews set comment='It is very hard to understand and keep up' where reviewId=6;
-- drop table book;
INSERT INTO Books
    (bookId,title,description,authorId,isbn)
VALUES
    -- (1, 'The Catcher in the Rye','The "brilliant, funny, meaningful novel"',1,'7543321726'),
    (1, 'Nine Stories','The "original, first-rate, serious, and beautiful" short fiction ',1,'0316769509'),
    (2, 'Franny and Zooey','Perhaps the best book by the foremost stylist of his generation',2,'9780316769495'),
    (3, 'The Great Gatsby','A true classic of twentieth-century literature',3,'9780743273565'),
    (4, 'Tender is the Night','A modern classic',4,'9780684801544');
    -- (6, 'Pride and Prejudice','Austens most popular novel',6,'9780141439518'),
    -- (7, 'Professional ASP.NET 4.5 in C# and VB','The all-new approach for experienced ASP.NET professionals!',7,'9781118311820')
;
insert into reviews(bookId,score,comment) values(1,9.99,'Its amazing how excellent much of it is.'),
(2,9.99,'Brilliant...What makes reading Salinger such a consistently bracing experience is our sense of always being in the presence of something that--whatever it is--isnt fishy.'),
(3,13.89,'James Dickey Now we have an American masterpiece in its final form: the original crystal has shaped itself into the true diamond.'),
(4,13.99,'Its amazing how excellent much of it is');
