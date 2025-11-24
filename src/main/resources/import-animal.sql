-- Contenido de src/main/resources/import-animal.sql

-- Script de inicialización de datos para la tabla animales
INSERT INTO animales (id, nombre, especie, edad) VALUES (1, 'Fido', 'Perro', 5);
INSERT INTO animales (id, nombre, especie, edad) VALUES (2, 'Mimi', 'Gato', 3);
INSERT INTO animales (id, nombre, especie, edad) VALUES (3, 'Lolo', 'Loro', 10);
ALTER TABLE animales ALTER COLUMN id RESTART WITH 4;