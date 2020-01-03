create table role (
		id serial primary key,
		name varchar(50)
);

create table rules (
		id serial primary key,
		rule varchar(100)
);

create table role_rules (
		id serial primary key,
		role_id integer references role(id),
		rules_id integer references rules(id)
);

create table users (
		id serial primary key,
		name varchar(100),
		surname varchar(100),
		role_id integer references role(id)
);

create table state (
		id serial primary key,
		name varchar(50)
);

create table category (
		id serial primary key,
		name varchar(50)
);

create table items (
		id serial primary key,
		name varchar(100),
		description text,
		user_id integer references users(id),
		category_id integer references category(id),
		state_id integer references state(id)
);

create table attaches (
		id serial primary key,
		name varchar(100),
		items_id integer references items(id)
);

create table comments (
		id serial primary key,
		description text,
		items_id integer references items(id)
);

insert into role (name) values ('администратор'), ('гость');
insert into rules (rule) values ('полный доступ'), ('частичный доступ');
insert into role_rules (role_id, rules_id) values (1, 1), (2, 2);
insert into category (name) values ('первая категория'), ('вторая категория');
insert into state (name) values ('выполнено'), ('в процессе');
insert into users (name, surname, role_id) values ('первый', 'пользователь', 1), ('второй', 'пользователь', 2);
insert into items (name, description, user_id, category_id, state_id) values ('заявка_1', 'не работает мышь', 1, 1, 2), ('заявка_2', 'установить программу', 2, 2, 1);
insert into comments (description, items_id) values ('комментарий 1', 1), ('комментарий 2', 2), ('комментарий 3', 2), ('комментарий 4', 1);
insert into attaches (name, items_id) values ('файл 1', 2), ('файл 2', 1), ('файл 3', 1), ('файл 4', 2);
