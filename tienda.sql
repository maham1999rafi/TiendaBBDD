create database tienda;
use tienda;
create table empleado(e_codigo int primary key, e_nombre varchar(255) not null, e_apellido varchar(255), e_password varchar(255) not null);
create table producto(p_codigo int(10) primary key, p_nombre varchar(255) not null, p_descripcion varchar(255), p_precio decimal(6,2));

	INSERT INTO producto VALUES (222, 'Gigabyte B450M DS3H', 'Placa base GIGABYTE serie 400 con tecnología AMD StoreMI', '65.99');
	INSERT INTO producto VALUES (223, 'Kingston A400 SSD 240GB', 'Disco duro A400 de estado sólido de Kingston', '32.95');
	INSERT INTO producto VALUES (224, 'Lenovo Ideapad 530S', 'Ordenador portátil con Intel Core i5, 8GB RAM, 256GB SSD', '599');

	INSERT INTO empleado VALUES (111,'Mario', 'Blue', '1234');
	INSERT INTO empleado VALUES (112,'Sara', 'Brown', '5678');
	INSERT INTO empleado VALUES (113,'Jhon', 'Travis', '9012');
