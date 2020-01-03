create table car_body(
	id serial primary key,
	name varchar(50) not null
);

create table engine(
	id serial primary key,
	name varchar(50) not null
);

create table transmission(
	id serial primary key,
	name varchar(50) not null
);

create table car(
	id serial primary key,
	name varchar(50) not null,
	car_body_id integer references car_body(id),
	engine_id integer references engine(id),
	transmission_id integer references transmission(id)
);

insert into car_body(name) values
	('car_body1'),
	('car_body2'),
	('car_body3'),
	('car_body4'),
	('car_body5'),
	('car_body6'),
	('car_body7');
	
insert into engine(name) values
	('engine1'),
	('engine2'),
	('engine3'),
	('engine4'),
	('engine5'),
	('engine6');

insert into transmission(name) values
	('transmission1'),
	('transmission2'),
	('transmission3'),
	('transmission4'),
	('transmission5');
	
insert into car(name, car_body_id, engine_id, transmission_id) values
	('car1', 1, 6, 2),
	('car2', 4, 2, 3),
	('car3', 7, 3, 1),
	('car4', 6, 4, 5);

--Вывести список всех машин и все привязанные к ним детали.
select c.name, cb.name, e.name, t.name from car as c
inner join car_body as cb on c.car_body_id = cb.id
inner join engine as e on c.engine_id = e.id
inner join transmission as t on c.transmission_id = t.id;

--Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
select cb.name from car_body as cb
left outer join car as c on c.car_body_id = cb.id
where c.id is null;

select e.name from engine as e
left outer join car as c on e.id = c.engine_id
where c.id is null;

select t.name from transmission as t
left outer join car as c on t.id = c.transmission_id
where c.id is null;
