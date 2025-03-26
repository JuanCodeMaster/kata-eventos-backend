# 📚 README - Plataforma de Eventos (Backend)

## ✨ Descripción General

Este es el **backend** de la plataforma de eventos que permite a los usuarios:
- Ver eventos disponibles
- Reservar cupos
- Cancelar eventos (borrado lógico)
- Consultar sus reservas
- Administrar eventos con imágenes en base64

La aplicación está desarrollada con:
- **Java 17**
- **Spring Boot 3**
- **PostgreSQL**
- **Maven**
- **JWT** para autenticación

---

## 🔧 Tecnologías Usadas

- Spring Boot 3
- Spring Security
- Spring Data JPA
- PostgreSQL
- JWT (Json Web Token)
- Maven
- Lombok

---

## 🌐 Endpoints Principales

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET    | `/api/events` | Listar todos los eventos activos |
| GET    | `/api/events/{id}` | Obtener detalle de un evento por ID |
| POST   | `/api/events` | Crear un nuevo evento |
| PUT    | `/api/events/{id}` | Actualizar un evento |
| DELETE | `/api/events/{id}` | Cancelar un evento (borrado lógico) |
| POST   | `/api/reservations` | Realizar una reserva |
| GET    | `/api/reservations/user/{email}` | Listar reservas de un usuario |

---

## 📝 Requisitos Previos

- Java 17 o superior
- Maven 3.8+
- PostgreSQL

---

## 📁 Estructura del Proyecto

```bash
/backend-eventos
│
├── src/
│   ├── main/java/com/davivienda/kata/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── model/
│   │   ├── repository/
│   │   └── service/
│   │       └── impl/
│   └── resources/
│       └── application.properties
│
├── db/init_db.sql    # Script para poblar la base de datos
└── pom.xml
```

---

## 👁️ Seguridad y Autenticación

- Se utiliza JWT (Json Web Token)
- Los endpoints están protegidos con Spring Security
- Para consumir endpoints, debes pasar el token en el header:
```http
Authorization: Bearer <token>
```

---

## 📆 Lógica de Cancelación de Eventos

- Al realizar un `DELETE /api/events/{id}` no se elimina el evento de la base de datos.
- En su lugar, el campo `status` se actualiza a `CANCELADO`.
- En el frontend:
  - Los eventos `ACTIVOS` se muestran en el feed principal.
  - Los eventos `CANCELADOS` aparecen en la sección de reservas con un badge indicando su estado.

---

## 📊 Poblar la Base de Datos

La base de datos incluye eventos, usuarios y reservas de prueba.

### ✅ Cargar Base de Datos desde el archivo SQL

1. Abrir **pgAdmin** o cualquier cliente de PostgreSQL.
2. Crear una base de datos vacía llamada `event_platform`.
3. Importar el archivo `init_db.sql` desde:
```bash
/db/init_db.sql
```

### Usando consola con `psql`:
```bash
psql -U postgres -d event_platform -f db/init_db.sql
```

---

## 🎓 Ejecutar la Aplicación

1. Clonar el repositorio:
```bash
git clone https://github.com/TU_USUARIO/backend-eventos.git
cd backend-eventos
```

2. Compilar el proyecto:
```bash
mvn clean install
```

3. Ejecutar la aplicación:
```bash
mvn spring-boot:run
```

La API estará disponible en:
```
http://localhost:8082
```

---

## 🚀 Docker (Próximamente)

- Se planea agregar soporte para Docker y Docker Compose
- En el futuro podrás levantar PostgreSQL + backend con un solo comando

---

## 🛠️ Mantenimiento y Colaboración

- Pull requests son bienvenidas
- Issues pueden ser creadas para errores, sugerencias o mejoras

---

## 📥 Autor

**Juan José Vélez Álvarez**  
_Solution Architect & Fullstack Dev_

> Proyecto para la Kata FullStack de Eventos (Davivienda)

---

❤️ Gracias por visitar este proyecto. ¡Contribuciones y estrellas son bienvenidas!

