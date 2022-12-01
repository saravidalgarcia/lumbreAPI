# Lumbre API

## Introducción
### Lumbre: Lado servidor de la aplicación para usuarios
Este proyecto es un servicio web RESTful en Java con el framework Spring. Constituye el lado servidor de la aplicación para usuarios de LUMBRE.

## Tecnologías
* Java 11
* Apache Maven 3.6.3
* Tomcat9 y tomcat9-admin

## Estructura
El proyecto se ha desarrollado a partir de la estructura básica de un proyecto Java con el framework Spring empleando el generador https://start.spring.io/. La estructura del proyecto es la siguiente:
```bash
.
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── daw
    │   │           └── proyecto
    │   │               ├── controller
    │   │               │   ├── CampanhaController.java
    │   │               │   ├── MyErrorController.java
    │   │               │   ├── PersonajeController.java
    │   │               │   ├── RazaController.java
    │   │               │   ├── SesionController.java
    │   │               │   └── UsuarioController.java
    │   │               ├── dao
    │   │               │   ├── CampanhaDAOImp.java
    │   │               │   ├── CampanhaDAO.java
    │   │               │   ├── PersonajeDAOImp.java
    │   │               │   ├── PersonajeDAO.java
    │   │               │   ├── RazaDAOImp.java
    │   │               │   ├── RazaDAO.java
    │   │               │   ├── SesionDAOImp.java
    │   │               │   ├── SesionDAO.java
    │   │               │   ├── UsuarioDAOImp.java
    │   │               │   └── UsuarioDAO.java
    │   │               ├── dto
    │   │               │   ├── CampanhaDTO.java
    │   │               │   ├── PersonajeDTO.java
    │   │               │   ├── RazaDTO.java
    │   │               │   ├── SesionDTO.java
    │   │               │   └── UsuarioDTO.java
    │   │               ├── entity
    │   │               │   ├── Campanha.java
    │   │               │   ├── Personaje.java
    │   │               │   ├── Raza.java
    │   │               │   ├── Sesion.java
    │   │               │   └── Usuario.java
    │   │               ├── ProyectoApplication.java
    │   │               ├── service
    │   │               │   ├── CampanhaServiceImp.java
    │   │               │   ├── CampanhaService.java
    │   │               │   ├── PersonajeServiceImp.java
    │   │               │   ├── PersonajeService.java
    │   │               │   ├── RazaServiceImp.java
    │   │               │   ├── RazaService.java
    │   │               │   ├── SesionServiceImp.java
    │   │               │   ├── SesionService.java
    │   │               │   ├── UsuarioServiceImp.java
    │   │               │   └── UsuarioService.java
    │   │               ├── ServletInitializer.java
    │   │               └── utils
    │   │                   ├── EntityToDTO.java
    │   │                   └── JWTUtil.java
    │   ├── resources
    │   │   ├── application.properties
    │   │   ├── BD.sql
    │   │   └── static
    │   │       ├── assets
    │   │       │   ├── css
    │   │       │   │   └── style.css
    │   │       │   ├── img
    │   │       │   │   ├── favicon.png
    │   │       │   │   ├── logo1.png
    │   │       │   │   ├── logo2.png
    │   │       │   │   ├── logo3.png
    │   │       │   │   └── logo4.png
    │   │       │   └── js
    │   │       │       └── script.js
    │   │       └── index.html
    │   └── webapp
    └── test
        └── java
            └── com
                └── daw
                    └── proyecto
                        └── ProyectoApplicationTests.java

```

## Ejecución del proyecto (Ubuntu)
### Requisitos mínimos
* Tomcat9 y tomcat-admin
* mvn

### Generación de archivo .war
Para generar el .war de este proyecto, en el directorio raíz se ejecuta:
```
$ mvn clean install
```
El .war generado se encuentra ubicado en el directorio "target" bajo el nombre de "lumbre.war".

### Despliegue con Web Manager
Una vez generado el .war del proyecto, para desplegarlo haciendo uso de Web Manager hay que acceder a http://localhost:8080/manager/html y cargar el archivo "lumbre.war" en el apartado "Archivo WAR a desplegar".

### Acceso
Una vez realizados los pasos anteriores, el proyecto es accesible desde http://localhost:8080/lumbre , donde es posible consultar todos los endpoints de LumbreAPI.
