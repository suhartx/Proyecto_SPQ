# Proyecto_SPQ BGS006
**Proyecto de la asignatura de SPQ Para el grupo BGS006**

**Crear la base de datos y darle permisos a un usuario**
````
CREATE DATABASE EStoreDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON EStoreDB.* TO 'spq'@'localhost';
````
**Compilar el proyecto**
````
"mvn clean"
"mvn compile"
"mvn datanucleus:enhance"
````

