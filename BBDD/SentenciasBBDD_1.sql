create database prueba1team4;

use prueba1team4;

create table poblaciones(
id_poblacion int auto_increment,
nombre varchar(200) not null,
ubicacion point,
primary key (id_poblacion));

insert into poblaciones (nombre, ubicacion) values
('Tarragona', point(41.11667, 1.25)),
('Barcelona', point(41.38879, 2.15899)),
('Sevilla', point(37.38283, -5.97317));

use prueba1team4;

create table hoteles(
id_hotel int auto_increment,
nombre varchar(200) not null,
categoria enum('1', '2,', '3', '4', '5'),
ubicacion point,
precio_noche float,
valoracion enum('basico', 'bien', 'muy bien', 'excelente'),
imagen text,
id_poblacion int,
primary key (id_hotel),
foreign key (id_poblacion) references poblaciones(id_poblacion) on delete restrict on update cascade);

insert into hoteles (nombre, categoria, ubicacion, precio_noche, valoracion, imagen, id_poblacion)  values 
('Hotel Catalonia Giralda', '4', point(37.390219, -5.984787), 110.00, 'muy bien', 'url de la imagen', 3);

select * from poblaciones;
select * from hoteles;