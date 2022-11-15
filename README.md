# Lumbre API

## Introducción
### Lumbre: Lado servidor de la aplicación para usuarios
Este proyecto es un servicio web RESTful en Java con el framework Spring. Constituye el lado servidor de la aplicación para usuarios de LUMBRE.

## Prerrequisitos
* Java 11
* Apache Maven 3.6.3
* Tomcat9 y tomcat9-admin

## Ejecución
Para ejecutar este proyecto, en el directorio raíz se ejecuta:
```
$ mvn clean install
```

## Despliegue con Web Manager
Una vez ejecutado el proyecto, se genera automáticamente un archivo "lumbre.war" que está ubicado en el directorio target.
Para desplegarlo haciendo uso de Web Manager, hay que acceder a http://localhost:8080/manager/html y cargar el archivo "lumbre.war" en el apartado "Archivo WAR a desplegar".

## Acceso
Una vez desplegado, el proyecto es accesible desde http://localhost:8080/lumbre , donde es posible consultar todos los endpoints de LumbreAPI.
