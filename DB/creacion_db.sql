BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "tematicas" (
	"id_tematica"	INTEGER NOT NULL,
	"nombre"	VARCHAR(45),
	PRIMARY KEY("id_tematica" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "tipo_promociones" (
	"id_tipo_promocion"	INTEGER NOT NULL,
	"nombre"	VARCHAR(45),
	PRIMARY KEY("id_tipo_promocion" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "atracciones" (
	"id_atraccion"	INTEGER NOT NULL,
	"nombre"	VARCHAR(45),
	"cupos"	INT NOT NULL,
	"tiempo"	DOUBLE,
	"costo"	INT,
	"id_tematica"	INT NOT NULL,
	PRIMARY KEY("id_atraccion" AUTOINCREMENT),
	CONSTRAINT "fk_atracciones_tematicas1" FOREIGN KEY("id_tematica") REFERENCES "tematicas"("id_tematica") ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE IF NOT EXISTS "usuarios" (
	"id_usuario"	INTEGER NOT NULL UNIQUE,
	"nombre"	VARCHAR(45) NOT NULL,
	"tiempo"	DOUBLE NOT NULL,
	"monedas"	INT NOT NULL,
	"id_tematica"	INT NOT NULL,
	PRIMARY KEY("id_usuario" AUTOINCREMENT),
	UNIQUE("id_usuario"),
	CONSTRAINT "fk_usuarios_tematicas1" FOREIGN KEY("id_tematica") REFERENCES "tematicas"("id_tematica") ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE IF NOT EXISTS "tickets" (
	"id_ticket"	INTEGER NOT NULL,
	"id_usuario"	INT NOT NULL,
	"tiempo_gastado"	DOUBLE NOT NULL,
	"monedas_gastadas"	INT NOT NULL,
	PRIMARY KEY("id_ticket" AUTOINCREMENT),
	CONSTRAINT "fk_tickets_usuarios1" FOREIGN KEY("id_usuario") REFERENCES "usuarios"("id_usuario")
);
CREATE TABLE IF NOT EXISTS "promociones" (
	"id_promocion"	INTEGER NOT NULL,
	"nombre"	VARCHAR(45),
	"costo"	INT,
	"id_tipo_promocion"	INT NOT NULL,
	PRIMARY KEY("id_promocion" AUTOINCREMENT),
	CONSTRAINT "fk_promociones_tipo_promociones1" FOREIGN KEY("id_tipo_promocion") REFERENCES "tipo_promociones"("id_tipo_promocion") ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE IF NOT EXISTS "promo_atracciones" (
	"id_promocion"	INT NOT NULL,
	"id_atraccion"	INT NOT NULL,
	"gratis"	INTEGER DEFAULT 0
);
CREATE TABLE IF NOT EXISTS "promo_descuento" (
	"id_promocion"	INTEGER NOT NULL,
	"descuento"	REAL
);
CREATE TABLE IF NOT EXISTS "tickets_atracciones" (
	"id_ticket"	INT NOT NULL,
	"id_atraccion"	INT NOT NULL
);
CREATE TABLE IF NOT EXISTS "tickets_promociones" (
	"id_ticket"	INT NOT NULL,
	"id_promocion"	INT NOT NULL
);
INSERT INTO "tematicas" VALUES (1,'Aventura');
INSERT INTO "tematicas" VALUES (2,'Paisaje');
INSERT INTO "tematicas" VALUES (3,'Degustacion');
INSERT INTO "tematicas" VALUES (4,'Extremo');
INSERT INTO "tematicas" VALUES (5,'Entretenimiento');
INSERT INTO "tematicas" VALUES (6,'Carrera');
INSERT INTO "tipo_promociones" VALUES (1,'Absoluta');
INSERT INTO "tipo_promociones" VALUES (2,'AxB');
INSERT INTO "tipo_promociones" VALUES (3,'Porcentual');
INSERT INTO "atracciones" VALUES (1,'Moria',6,2.0,10,1);
INSERT INTO "atracciones" VALUES (2,'Mordor',4,3.0,25,1);
INSERT INTO "atracciones" VALUES (3,'Bosque Negro',12,4.0,3,1);
INSERT INTO "atracciones" VALUES (4,'Visitando Aguas Turbias',10,2.0,30,1);
INSERT INTO "atracciones" VALUES (5,'La Comarca',150,6.5,3,3);
INSERT INTO "atracciones" VALUES (6,'Lothlorien',30,1.0,35,3);
INSERT INTO "atracciones" VALUES (7,'Alto Guiso',25,2.0,20,3);
INSERT INTO "atracciones" VALUES (8,'Los Elixires Del Senior Olaf',30,1.5,15,3);
INSERT INTO "atracciones" VALUES (9,'Minas Tirith',25,2.5,5,2);
INSERT INTO "atracciones" VALUES (10,'Abismo de Helm',15,2.0,5,2);
INSERT INTO "atracciones" VALUES (11,'Erebor',32,3.0,12,2);
INSERT INTO "atracciones" VALUES (12,'El Vacio',15,1.0,10,2);
INSERT INTO "atracciones" VALUES (13,'Danza De Los Dragones',2,3.0,500,5);
INSERT INTO "atracciones" VALUES (14,'Festival De Fuegos Artificiales',200,0.5,20,5);
INSERT INTO "atracciones" VALUES (15,'Festival De Aves',30,1.0,10,5);
INSERT INTO "atracciones" VALUES (16,'Magia Aldeana',100,8.0,200,5);
INSERT INTO "atracciones" VALUES (17,'Caballos Super Veloces',8,5.0,100,6);
INSERT INTO "atracciones" VALUES (18,'Trayectoria Acuatica',12,4.0,50,6);
INSERT INTO "atracciones" VALUES (19,'Cubetas De Agua',5,4.0,40,6);
INSERT INTO "atracciones" VALUES (20,'El Desencadenamiento',10,5.0,150,6);
INSERT INTO "atracciones" VALUES (21,'Ventisca Invernal',50,0.2,30,4);
INSERT INTO "atracciones" VALUES (22,'Espadachines',2,2.0,100,4);
INSERT INTO "atracciones" VALUES (23,'Duelo A Muerte Con Cuchillos',2,3.0,1000,4);
INSERT INTO "atracciones" VALUES (24,'Las Flechas De Orlando Bloom',20,2.5,200,4);
INSERT INTO "usuarios" VALUES (1,'Eowyn',8.0,10,1);
INSERT INTO "usuarios" VALUES (2,'Gandalf',5.0,100,2);
INSERT INTO "usuarios" VALUES (3,'Sam',8.0,36,3);
INSERT INTO "usuarios" VALUES (4,'Galadriel',3.0,120,2);
INSERT INTO "usuarios" VALUES (5,'Ignacio',3.0,150,2);
INSERT INTO "usuarios" VALUES (6,'Joaquin',5.0,80,3);
INSERT INTO "usuarios" VALUES (7,'Juani',2.0,100,4);
INSERT INTO "usuarios" VALUES (8,'Camila',2.0,50,3);
INSERT INTO "usuarios" VALUES (9,'Lucas',8.0,2000,4);
INSERT INTO "usuarios" VALUES (10,'Dark Knight',10.0,170,2);
INSERT INTO "usuarios" VALUES (11,'Laureana',14.0,8500,5);
INSERT INTO "usuarios" VALUES (12,'Profe Leo',10.0,2000,1);
INSERT INTO "usuarios" VALUES (13,'Profe Lucas',8.0,2000,2);
INSERT INTO "usuarios" VALUES (14,'Profe Fede',6.0,2000,5);
INSERT INTO "usuarios" VALUES (15,'Puflito',9.0,99999,4);
INSERT INTO "usuarios" VALUES (16,'Chiruzi',4.0,65,3);
INSERT INTO "promociones" VALUES (1,'Zonas De La Oscuridad',23,3);
INSERT INTO "promociones" VALUES (2,'Astucia',38,1);
INSERT INTO "promociones" VALUES (3,'NiomNiom',36,1);
INSERT INTO "promociones" VALUES (4,'Salis En Carreta',35,2);
INSERT INTO "promociones" VALUES (5,'Contemplad La Profundidad',10,2);
INSERT INTO "promociones" VALUES (6,'Wachen El Paisaje Homies',20,1);
INSERT INTO "promociones" VALUES (7,'Espectaculo De Fuegos Fatuos',132,3);
INSERT INTO "promociones" VALUES (8,'Vuelo Igneo',600,1);
INSERT INTO "promociones" VALUES (9,'Prohibido Ahogarse',63,3);
INSERT INTO "promociones" VALUES (10,'Velozmente Fuerte',100,3);
INSERT INTO "promociones" VALUES (11,'Filo Sangriento',999,1);
INSERT INTO "promociones" VALUES (12,'Medio Doble De Riesgo',300,2);
INSERT INTO "promo_atracciones" VALUES (1,3,0);
INSERT INTO "promo_atracciones" VALUES (1,2,0);
INSERT INTO "promo_atracciones" VALUES (2,1,0);
INSERT INTO "promo_atracciones" VALUES (2,4,0);
INSERT INTO "promo_atracciones" VALUES (3,6,0);
INSERT INTO "promo_atracciones" VALUES (3,5,0);
INSERT INTO "promo_atracciones" VALUES (4,7,0);
INSERT INTO "promo_atracciones" VALUES (4,8,0);
INSERT INTO "promo_atracciones" VALUES (4,5,1);
INSERT INTO "promo_atracciones" VALUES (5,9,0);
INSERT INTO "promo_atracciones" VALUES (5,10,0);
INSERT INTO "promo_atracciones" VALUES (5,11,1);
INSERT INTO "promo_atracciones" VALUES (6,11,0);
INSERT INTO "promo_atracciones" VALUES (6,12,0);
INSERT INTO "promo_atracciones" VALUES (7,14,0);
INSERT INTO "promo_atracciones" VALUES (7,16,0);
INSERT INTO "promo_atracciones" VALUES (8,13,0);
INSERT INTO "promo_atracciones" VALUES (8,16,0);
INSERT INTO "promo_atracciones" VALUES (9,18,0);
INSERT INTO "promo_atracciones" VALUES (9,19,0);
INSERT INTO "promo_atracciones" VALUES (10,17,0);
INSERT INTO "promo_atracciones" VALUES (10,20,0);
INSERT INTO "promo_atracciones" VALUES (11,22,0);
INSERT INTO "promo_atracciones" VALUES (11,23,0);
INSERT INTO "promo_atracciones" VALUES (12,22,0);
INSERT INTO "promo_atracciones" VALUES (12,24,0);
INSERT INTO "promo_atracciones" VALUES (12,23,1);
INSERT INTO "promo_descuento" VALUES (1,0.2);
INSERT INTO "promo_descuento" VALUES (7,0.4);
INSERT INTO "promo_descuento" VALUES (9,0.3);
INSERT INTO "promo_descuento" VALUES (10,0.6);
COMMIT;
