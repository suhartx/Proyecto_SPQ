Proyecto_SPQ BGS006
===============================
[![Java CI](https://github.com/suhartx/Proyecto_SPQ/actions/workflows/main.yml/badge.svg)](https://github.com/suhartx/Proyecto_SPQ/actions/workflows/main.yml)   [![codecov](https://codecov.io/gh/suhartx/Proyecto_SPQ/branch/main/graph/badge.svg?token=MA8OLVZG8F)](https://codecov.io/gh/suhartx/Proyecto_SPQ)

**Proyecto de la asignatura de SPQ Para el grupo BGS006**
------------- 
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

```
mvn clean
mvn compile
mvn datanucleus:enhance
```

**Crear las tablas de la base de datos**

```
mvn datanucleus:schema-create
```
**Datos de prueba**
```
mvn -Pdatos exec:java
```

**Testear el proyecto**
```
mvn test
```

**Instalar el proyecto para ejecutar el jar**
```
//En la primera ocasion que se ejecute dará error
//A la segunda funcionará correctamente
mvn install
```


**Generar documentacion**
```
doxygen:report
```
**Generar latex**

en ProyectoSPQ\target\doxygen\latex
```
Make
```


*Lanzar server*
```
mvn -Pservidor exec:java
```
*si escribimos en la página web por ejemplo el siguiente enlace*
[http://localhost:8080/myapp/usuarios](http://localhost:8080/myapp/usuarios)

nos mostrará los usuarios

***Lanzar cliente***
```
mvn exec:java

```