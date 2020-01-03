create table type (
		id serial primary key,
		name varchar(50) not null
);

create table product (
		id serial primary key,
		name varchar(50) not null,
		type_id integer references type(id) not null,
		expired_date date not null,
		price integer not null
);

insert into type (name, id) values ('сыр', 1), ('хлеб', 2), ('молоко', 3), ('колбаса', 4), ('мороженное', 5);
update type set name='мороженое' where id=5;
insert into type (name, id) values ('мясо', 6);

insert into product (name, type_id, expired_date, price) values ('российский', 1, '2020-03-10', 100);

insert into product (name, type_id, expired_date, price) values ('голландский', 1, '2020-04-10', 125),
('фета', 1, '2020-06-01', 235), ('костромской', 1, '2020-03-25', 150), ('адыгейский', 1, '2020-01-30', 195);

insert into product (name, type_id, expired_date, price) values ('бородинский', 2, '2020-01-10', 35),
('майский', 2, '2020-01-12', 30), ('юбилейный', 2, '2020-01-15', 40), ('эксклюзив', 2, '2020-01-09', 38),
('бездрожжевой', 2, '2020-01-11', 42), ('ржаной край', 2, '2020-01-10', 50), ('столовый', 2, '2020-01-07', 29),
('балтийский', 2, '2020-01-13', 35), ('таллинский', 2, '2020-01-14', 33), ('бельгийский', 2, '2020-01-17', 48),
('литовский', 2, '2020-01-07', 29), ('рижский', 2, '2020-01-10', 45);

insert into product (name, type_id, expired_date, price) values ('здравушка', 3, '2020-02-10', 70),
('простоквашино', 3, '2020-03-20', 90), ('бабушкина крынка', 3, '2020-04-01', 82), ('славита', 3, '2020-01-30', 60),
('славянские традиции', 3, '2020-02-28', 77), ('милкавита', 3, '2020-02-17', 70);

insert into product (name, type_id, expired_date, price) values ('сервелат таллинский', 4, '2020-10-10', 250),
('сервелат кремлевский', 4, '2020-09-15', 300), ('александрийская', 4, '2020-11-30', 450), ('палермо', 4, '2020-08-01', 275),
('сервелат с паприкой', 4, '2020-05-10', 135), ('салями Италия', 4, '2020-02-28', 165);

insert into product (name, type_id, expired_date, price) values ('наше детство', 5, '2021-01-10', 50),
('топ', 5, '2020-08-10', 57), ('пломбир', 5, '2020-06-25', 45), ('советская классика', 5, '2020-01-30', 60);

insert into product (name, type_id, expired_date, price) values ('свиное мороженное', 6, '2021-06-10', 250),
('говяжье мороженное', 6, '2020-11-17', 350), ('куриное мороженное', 6, '2020-09-23', 225);

--Написать запрос получение всех продуктов с типом "СЫР"
select p.name from product as p
inner join type as t on p.type_id = t.id
where t.name = 'сыр';

--Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select p.name from product as p where p.name like '%мороженное%';

--Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select p.name, p.expired_date, t.name from product as p
inner join type as t on p.type_id = t.id
where p.expired_date between '2020-02-01' and '2020-02-28';

--Написать запрос, который выводит самый дорогой продукт.
select p.name, t.name, p.price  from product as p
inner join type as t on p.type_id = t.id
where p.price = (select max(price) from product);

--Написать запрос, который выводит количество всех продуктов определенного типа.
select t.name, count(t.name) from product as p
inner join type as t on p.type_id = t.id
group by t.name;

--Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.name, t.name from product as p
inner join type as t on p.type_id = t.id
where t.name in ('сыр', 'молоко');

--Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
select t.name, count(t.name) from product as p
inner join type as t on p.type_id = t.id
group by t.name
having count(t.name) < 10;

--Вывести все продукты и их тип
select p.name, t.name from product as p
inner join type as t on p.type_id = t.id;