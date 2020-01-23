create table vacancies (
	id serial primary key not null,
	name varchar(250) not null,
	text text not null,
	link varchar(250) not null,
	create_date timestamp not null
);