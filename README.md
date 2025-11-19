# persona-hexagonal

Este proyecto usa **Quarkus**, el framework Java supersónico y subatómico.

Más información sobre Quarkus: https://quarkus.io/

**Ejemplo 100 % correcto y limpio de Arquitectura Hexagonal (Ports & Adapters) con Quarkus 3.x**  
Dominio puro • Inversión total de dependencias • Adaptadores bien separados • Cambio de base de datos sin tocar el núcleo
```
## Estructura del proyecto (Hexagonal real)
src/main/java/org/edwin/
├── aplicacion/               ← Casos de uso / Servicios de aplicación
│   └── PersonaService.java
├── dominio/
│   ├── modelo/               ← Entidades de dominio puro (sin JPA, sin Quarkus)
│   │   └── Persona.java
│   └── repositorio/          ← PUERTOS (interfaces del dominio)
│       └── PersonaRepository.java
└── infraestructura/
├── adaptador/
│   ├── entrada/web/      ← Adaptador de entrada (REST)
│   │   ├── dto/
│   │   ├── mapper/
│   │   └── PersonaResource.java
│   └── salida/persistence/ ← Adaptador de salida (JPA + Panache)
│       ├── entity/
│       └── JpaPersonaRepository.java
```


### ¿Qué aporta esta arquitectura?

- Dominio independiente de frameworks  
- Casos de uso testables sin servidor  
- Sustituir JPA por MongoDB, DynamoDB o archivos sin tocar el dominio  
- REST es un adaptador, no parte del núcleo  
- Todo desacoplado por interfaces (PUERTOS)

---

## 🛠 Tecnologías Utilizadas

### Core
- **Java 21**
- **Quarkus 3.27.x**
- **Maven**

### Persistencia
- Hibernate ORM + Panache  
- Base de datos H2 (modo desarrollo)

### REST & Serialización
- Quarkus RESTEasy Reactive  
- JSON-B  
- Bean Validation  

### Utilidades
- MapStruct  
- Lombok  

### Documentación
- OpenAPI 3  
- Swagger UI  

### Testing
- JUnit 5  
- RestAssured  

---

## 🚀 Ejecutar en modo desarrollo

```shell script
./mvnw quarkus:dev
```

Accesos disponibles:
```
| Recurso    | URL                                                                  |
| ---------- | -------------------------------------------------------------------- |
| API        | [http://localhost:8080](http://localhost:8080)                       |
| Dev UI     | [http://localhost:8080/q/dev](http://localhost:8080/q/dev)           |
| Swagger UI | [http://localhost:8080/swagger-ui](http://localhost:8080/swagger-ui) |
```

## Empaquetar y ejecutar la aplicación
```shell script
./mvnw package
```
```
Endpoints disponibles

Método      URL                         Descripción
GET         /personas                   Lista todas las personas
GET         /personas/{id}              Busca por ID
POST        /personas                   Crea nueva persona
PUT         /personas/{id}              Actualiza persona
DELETE      /personas/{id}              Elimina persona
GET         /personas/sexo/{sexo}       Filtra por sexo (M/F)
```
## Guías relacionadas

REST con Hibernate ORM Panache → https://quarkus.io/guides/rest-data-panache
JSON-B → https://quarkus.io/guides/rest#json-serialisation
JDBC H2 → https://quarkus.io/guides/datasource
Validación → https://quarkus.io/guides/validation
OpenAPI + Swagger UI → https://quarkus.io/guides/openapi-swaggerui

## 📝 Configuración principal

src/main/resources/application.properties
```
quarkus.datasource.db-kind=h2
quarkus.datasource.jdbc.url=jdbc:h2:mem:personadb
quarkus.hibernate-orm.database.generation=drop-and-create
quarkus.hibernate-orm.sql-load-script=import.sql

quarkus.swagger-ui.always-include=true
quarkus.swagger-ui.path=/swagger-ui
```

## 📚 Documentación API
```
| Recurso      | URL                                                                                        |
| ------------ | ------------------------------------------------------------------------------------------ |
| Swagger UI   | [http://localhost:8080/swagger-ui](http://localhost:8080/swagger-ui)                       |
| OpenAPI JSON | [http://localhost:8080/q/openapi](http://localhost:8080/q/openapi)                         |
| OpenAPI YAML | [http://localhost:8080/q/openapi?format=yaml](http://localhost:8080/q/openapi?format=yaml) |
```


Hecho con mucho cariño en El Salvador – Noviembre 2025
¡Uno de los pocos proyectos en español que realmente cumple Arquitectura Hexagonal como debe ser!