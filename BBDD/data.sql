create database pruebaMVC_1;
use pruebaMVC_1;

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
('Zaragoza', 41.65606, -0.87734),
('Girona', 41.98311, 2.82493);

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
direccion varchar(255),
id_poblacion int unsigned,
primary key (id_hotel),
foreign key (id_poblacion) references poblaciones(id_poblacion) on delete restrict on update cascade);

insert into hoteles (nombre, categoria, ubi_lat, ubi_long, precio_noche, valoracion, imagen, telefono, direccion, id_poblacion) values
('Sevilla Ayre Hotel', '4', 37.389538, -5.974852, 67, 'muybien', 'url de la imagen', '954919797', 'Av. Kansas City, 7, 41018 Sevilla', 3),
('H10', '4', 41.115248, 1.256901, 80, 'excelente', 'url de la imagen', '900400466', 'Rambla Vella, 2, 43003 Tarragona', 1),
('Astari', '3', 41.117412, 1.265011, 80, 'muybien', 'imagen del hotel', '977236900', 'Vía Augusta, 95, 43003 Tarragona', 1),
('Hotel W Barcelona', '5', 41.368341, 2.190043, 317, 'muybien', 'url de la imagen', '932952800', 'Plaça Rosa dels Vents 1, Final, Passeig de Joan de Borbó, 08039 Barcelona', 2),
('Hotel Gran Ultonia', '4', 41.985255, 2.821277, 61, 'muybien', 'url de la imagen', '972203850', 'Gran Via Jaume I, 22, 17001 Girona', 7),
('Ibis Girona', '2', 41.998179, 2.817517, 57, 'bien', 'url de la imagen', '972391538', 'C/ Fransesc Ferrer, 18, 17006 Girona', 7),
('Hotel Granvia', '3', 41.390006, 2.169551, 105, 'excelente', 'url de la imagen', '933181900', 'Gran Via de les Corts Catalanes, 642, 08007 Barcelona', 2),
('Hotel Palacio de Villapanés', '5', 37.391493, -5.986297, 102, 'excelente', 'url de la imagen', '954502063', 'C/ Santiago, 31, 41003 Sevilla', 3),
('Mercure Madrid Centro', '4', 40.414067, -3.694522, 84, 'muybien', 'url de la imagen', '913600011', 'C/ de Lope de Vega, 49, 28014 Madrid', 4),
('Hotel Villa Real', '5', 40.415497, -3.69703, 102, 'muybien', 'url de la imagen', '914203767', 'Pl. de las Cortes, 10, 28014 Madrid', 4),
('Hotel Río Arga', '2', 41.654807, -0.880873, 48, 'muybien', 'url de la imagen', '976399065', 'C/ Contamina, 20, 50003 Zaragoza', 5),
('Hotel Zentral Ave', '4', 41.66113, -0.906702, 57, 'muybien', 'url de la imagen', '976287950', 'Av. Francia, s/n, 50003 Zaragoza', 5),
('Hotel Lauria', '3', 41.114057, 1.255213, 63, 'bien', 'url de la imagen', '977236712', 'Rambla Nova 20, 43004 Tarragona', 1),
('SB Ciutat de Tarragona', '4', 41.118714, 1.244620, 73, 'bien', 'url de la imagen', '977250999', 'Pl. Imperial Tarraco, 5, 43005 Tarragona', 1),
('Hotel Núria', '3', 41.121224, 1.274704, 56, 'muybien', 'url de la imagen', '977235011', 'Vía Augusta, 145, 43007 Tarragona', 1),
('Hostal Noria', '2', 41.116593, 1.255879, 40, 'bien', 'url de la imagen', '977238717', 'Plaça de la Font, 53, 43003 Tarragona', 1),
('Hostal 977', '1', 41.117511, 1.256366, 66, 'excelente', 'url de la imagen', '977216651', 'C/ dels Cavallers, 4Bis, 43003 Tarragona', 1);

select * from poblaciones;
select * from hoteles;