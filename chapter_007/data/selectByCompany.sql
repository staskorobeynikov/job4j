CREATE TABLE company
(
id integer NOT NULL,
name character varying,
CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
id integer NOT NULL,
name character varying,
company_id integer,
CONSTRAINT person_pkey PRIMARY KEY (id),
CONSTRAINT company_id_fkey foreign key (company_id) references company(id)
);

insert into company (name, id) values ('microsoft', 1), ('amazon', 2), ('google', 3), ('oracle', 4), 
('tesla', 5), ('apple', 6);

select * from company;

insert into person (id, name, company_id) values (1, 'Pavel', 1), (2, 'Petr', 1), (3, 'Stas', 1), (4, 'Sergey', 2),
(5, 'Igor', 2), (6, 'Vladislav', 3), (7, 'Ilya', 3), (8, 'Anton', 3), (9, 'Ruslan', 4), (10, 'Michael', 5), 
(11, 'Maksim', 5), (12, 'Timofey', 5), (13, 'Alexey', 5), (14, 'Alex', 6), (15, 'Oleg', 6), (16, 'Kirill', 6),
(17, 'Ivan', 6), (18, 'Fedor', 6), (19, 'Timur', 6), (20, 'Stepan', 6);

select * from person;

select p.name, c.name, c.id from person as p
inner join company as c on p.company_id = c.id
where c.id != 5;

select c.name, count_person from company as c
inner join (select company_id, count(name) as count_person from person
group by company_id) as count on count.company_id = c.id
where count_person = (select max(count_person) from (select company_id, count(name) as count_person from person
group by company_id) as count);