# Proyecto_SPQ BGS006
**Proyecto de la asignatura de SPQ Para el grupo BGS006**

**Crear la base de datos y darle permisos a un usuario**

    /* DELETE 'messagesDB' database*/
    DROP SCHEMA IF EXISTS deustoSneakerDB;
    /* DELETE USER 'spq' AT LOCAL SERVER*/
    DROP USER IF EXISTS 'spq'@'localhost';
    
    /* CREATE 'messagesDB' DATABASE */
    CREATE SCHEMA deustoSneakerDB;
    /* CREATE THE USER 'spq' AT LOCAL SERVER WITH PASSWORD 'spq' */
    CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
    
    GRANT ALL ON deustoSneakerDB.* TO 'spq'@'localhost';

**Compilar el proyecto**

    mvn clean
    mvn compile
    mvn datanucleus:enhance


**Crear las tablas de la base de datos**

```
mvn datanucleus:schema-create
```


**Testear el proyecto**
```
//En la primera ocasion que se ejecute dará error
//A la segunda funcionará correctamente
mvn test
```

**Datos de prueba**
```
mvn -Pdatos exec:java
```

*Lanzar server*
```
mvn exec:java
```
*Lanzar cliente*
```
mvn javafx:run

```