drop table if exists hoteles;
drop table if exists poblaciones;

create table poblaciones(
id_poblacion int unsigned auto_increment,
nombre varchar(200) not null,
ubi_lat double,
ubi_long double,
primary key (id_poblacion));

insert into poblaciones (nombre, ubi_lat, ubi_long) values
('Tarragona', 41.11667, 1.25),
('Barcelona', 41.38879, 2.15899),
('Sevilla', 37.38283, -5.97317),
('Madrid', 40.4165, -3.70256),
('Zaragoza', 41.65606, -0.87734);

create table hoteles(
id_hotel int unsigned auto_increment,
nombre varchar(200) not null,
categoria enum('1', '2', '3', '4', '5') not null,
ubi_lat double,
ubi_long double,
precio_noche float,
valoracion enum('basico', 'bien', 'muybien', 'excelente'),
imagen text,
telefono varchar(9) not null,
id_poblacion int unsigned,
primary key (id_hotel),
foreign key (id_poblacion) references poblaciones(id_poblacion) on delete restrict on update cascade);

insert into hoteles (nombre, categoria, ubi_lat, ubi_long, precio_noche, valoracion, imagen, telefono, id_poblacion) values
('Sevilla Ayre Hotel', 4, 37.389538, -5.974852, 67, muybien, 'url de la imagen', '954919797', 3),
('H10', 4, 41.115248, 1.256901, 80, excelente, 'url de la imagen', '900400466', 1);