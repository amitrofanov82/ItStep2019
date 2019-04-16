drop table results;
drop table answers;
drop table questions;
drop table students;

create table students (s_id int NOT NULL AUTO_INCREMENT, s_name VARCHAR(100), s_pass VARCHAR(100), lvl CHAR(1),PRIMARY KEY (s_id)); 
create table questions (q_id int NOT NULL AUTO_INCREMENT, q_text VARCHAR(100), PRIMARY KEY (q_id));
create table answers (a_id int NOT NULL AUTO_INCREMENT, q_id int, a_text VARCHAR(100), is_true BOOLEAN, PRIMARY KEY (a_id),FOREIGN KEY  (q_id)REFERENCES questions(q_id));
create table results(r_id int NOT NULL AUTO_INCREMENT, s_id int, cor_ans int, lvl CHAR(1), PRIMARY KEY (r_id),  FOREIGN KEY  (s_id )REFERENCES students(s_id));


INSERT INTO students ( s_name, s_pass, lvl) VALUES ('Alex', '$2a$10$McGXjrn...KK0wHwEKM4cOiKmeVVclWC7meAySB6pcXtEL3lDh0TG', 'A');
INSERT INTO students ( s_name, s_pass, lvl) VALUES ('Alex1', '$2a$10$McGXjrn...KK0wHwEKM4cOiKmeVVclWC7meAySB6pcXtEL3lDh0TG', 'A');
INSERT INTO students ( s_name, s_pass, lvl) VALUES ('Alex2', '$2a$10$McGXjrn...KK0wHwEKM4cOiKmeVVclWC7meAySB6pcXtEL3lDh0TG', 'A');
INSERT INTO students ( s_name, s_pass, lvl) VALUES ('Alex3', '$2a$10$McGXjrn...KK0wHwEKM4cOiKmeVVclWC7meAySB6pcXtEL3lDh0TG', 'A');
INSERT INTO students ( s_name, s_pass, lvl) VALUES ('Mixa', '$2a$10$McGXjrn...KK0wHwEKM4cOiKmeVVclWC7meAySB6pcXtEL3lDh0TG', 'N');
INSERT INTO students ( s_name, s_pass, lvl) VALUES ('Mixa1', '$2a$10$McGXjrn...KK0wHwEKM4cOiKmeVVclWC7meAySB6pcXtEL3lDh0TG', 'N');
INSERT INTO students ( s_name, s_pass, lvl) VALUES ('Mixa2', '$2a$10$McGXjrn...KK0wHwEKM4cOiKmeVVclWC7meAySB6pcXtEL3lDh0TG', 'N');
INSERT INTO students ( s_name, s_pass, lvl) VALUES ('Mixa3', '$2a$10$McGXjrn...KK0wHwEKM4cOiKmeVVclWC7meAySB6pcXtEL3lDh0TG', 'N');


INSERT INTO results ( s_id, cor_ans, lvl) VALUES (1, 9, 'A');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES ( 2, 10, 'A');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES ( 3, 10, 'A');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES ( 4, 8, 'A');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES (5, 3, 'N');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES (6, 2, 'N');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES (7, 1, 'N');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES (8, 4, 'N');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES (1, 7, 'A');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES ( 2, 8, 'A');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES ( 3, 9, 'A');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES ( 4, 8, 'A');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES (5, 3, 'N');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES (6, 2, 'N');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES (7, 1, 'N');
INSERT INTO results ( s_id, cor_ans, lvl) VALUES (8, 4, 'N');




INSERT INTO questions (q_text) VALUES ( 'What is flash?');
INSERT INTO questions (q_text) VALUES ( 'Which blinds exist?');
INSERT INTO questions (q_text) VALUES ( 'How much cards possible in flop?');
INSERT INTO questions (q_text) VALUES ( 'What is full-house?');
INSERT INTO questions (q_text) VALUES ( 'How much cards on hands in texas holdem?');
INSERT INTO questions (q_text) VALUES ( 'What do you need if you playing as diller and your opponents are checked?');
INSERT INTO questions (q_text) VALUES ( 'What is turn?');
INSERT INTO questions (q_text) VALUES ( 'What is river?');
INSERT INTO questions (q_text) VALUES ( 'What is street-flash?');
INSERT INTO questions (q_text) VALUES ( 'What is yellow boy?');


INSERT INTO answers ( q_id, a_text, is_true) VALUES (1, 'Five cards', true);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (1, 'Position', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (1, 'Three cards situation', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (1, 'Five cards one by one', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (2, 'Strong and weak', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (2, 'Krivoi i khramoi', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (2, 'Big and small', true);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (2, 'Black and red', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (3, '5', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (3, '4', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (3, '3', true);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (3, '2', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (4, 'Five cards one by one', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (4, 'Five cards with one mast', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (4, 'Five cards with one mast one by one', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (4, 'Three plus two', true);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (5, '5', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (5, '4', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (5, '3', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (5, '2', true);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (6, 'Raise', true);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (6, 'Bet', true);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (6, 'Check', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (6, 'Fold', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (7, '4 card on the table', true);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (7, 'Five one by one', true);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (7, 'Five', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (7, 'Three plus two', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (8, '4 cards on the tablse', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (8, 'five one by one', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (8, 'five cards', true);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (8, 'Three plus two', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (9, '4 cards on the table', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (9, 'five cards', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (9, 'five cards one by one', true);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (9, 'Three plus two', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (10, '4 cards on the table', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (10, '5 cards one by one', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (10, '5 cards one by one with one mast', false);
INSERT INTO answers ( q_id, a_text, is_true) VALUES (10, 'Anything else', true);





--априорная вероятность отнесения к классу а и b
select a.c/b.c as p1, c.c/b.c as p2 from
(select count(*) as c  from results) b,
(select count(*) as c from results where lvl = 'A') a, 
(select count(*) as c from results where lvl = 'N') c;

--условная вероятность
select a.c/d.c  as p1, c.c/b.c as p2 from
(select count(*) as c  from results where lvl = 'N') b,
(select count(*) as c  from results where lvl = 'A') d,
(select count(*) as c from results where cor_ans < 5 and lvl = 'A') a, 
(select count(*) as c from results where cor_ans < 5 and lvl = 'N') c;

--готовый скрипт апостериорной вероятности(вместо 8 можно передавать параметр и смотреть как изменяются результаты классификации)

select 
case when
cond.p1 * a.p1 / (cond.p1 * a.p1 + cond.p2 * a.p2) > cond.p2 * a.p2/ (cond.p1 * a.p1 + cond.p2 * a.p2) 
then 'A' else 'N' end from
(select a.c/b.c as p1, c.c/b.c as p2 from
(select count(*) as c  from results) b,
(select count(*) as c from results where lvl = 'A') a, 
(select count(*) as c from results where lvl = 'N') c) a, 
(select a.c/d.c  as p1, c.c/b.c as p2 from
(select count(*) as c  from results where lvl = 'N') b,
(select count(*) as c  from results where lvl = 'A') d,
(select count(*) as c from results where cor_ans <= 10 and lvl = 'A') a, 
(select count(*) as c from results where cor_ans <= 10 and lvl = 'N') c) cond
;
