INSERT INTO books(book_id, title, author, pages, date_of_publication) VALUES
(1, 'Advanced C++', 'Gazihan Alankus, Olena Lizina, Et al', 762, '2019-10-31'),
(2, 'Mastering C++ Programming', 'Jeganathan Swaminathan', 384, '2017-08-31'),
(3, 'C++ Data Structures and Algorithms', 'Wisnu Anggoro', 322, '2018-04-23'),
(4, 'Learn Java 12 Programming', 'Nick Samoylov', 690, '2019-04-30'),
(5, 'Java Fundamentals', 'Gazihan Alankus, Rogério Theodoro de Brito, Et al', 408, '2019-03-15'),
(6, 'Beginning Java Data Structures and Algorithms', 'James Cutajar', 202, '2018-07-29'),
(7, 'Web Development with Angular and Bootstrap - Third Edition', 'Sridhar Rao Chivukula, Aki Iskandar', 492, '2019-08-30'),
(8, 'Angular Design Patterns', 'Mathieu Nayrolles', 178, '2018-07-29'),
(9, 'Angular Projects', 'Zama Khan Mohammed', 350, '2019-09-13');

INSERT INTO comments(comment_id, author, content, book_id) VALUES
(1, 'Peter', 'Great', 1),
(2, 'Jan', 'Nothing to complain about', 1),
(3, 'Agnes.', 'Nice!', 2),
(4, 'Filip', 'Surprised me again!', 3),
(5, 'David', 'Well done', 4),
(6, 'Emily', 'I like it.', 5),
(7, 'Patrick', '5+', 5),
(8, 'George', 'Excellent work.', 6),
(9, 'Elizabeth', 'Good job!', 6),
(10, 'Elena', 'Another great book!', 6),
(11, 'Elena', 'Another great book!', 6),
(12, 'Michael', 'Arguments are clearly explained', 7),
(13, 'Alex', 'Excellent', 8),
(14, 'John', 'Perfection!!! Just what I expected', 9),
(15, 'Antonio', 'This book is easy to read and understand!', 9),
(16, 'Tommy', 'What a wonderful book.', 9);