# 🧾 Plataforma de Eventos - Backend

## 📌 Descripción
Este proyecto es un backend en Spring Boot que permite gestionar eventos, usuarios y reservas en una plataforma de eventos.

Cuenta con funcionalidades para:
- Registrar eventos con imágenes en Base64.
- Reservar cupos a eventos por parte de los usuarios.
- Cancelar eventos de forma lógica.
- Visualizar eventos por usuario.

---

## 📁 Estructura del Proyecto

```
└── backend/
    ├── controller/          # Controladores REST
    ├── dto/                 # Objetos de transferencia (DTOs)
    ├── model/               # Entidades JPA
    ├── repository/          # Interfaces de persistencia
    ├── service/             # Lógica de negocio
    ├── security/            # Seguridad con JWT
    └── ...
```

---

## 🚀 Endpoints

### 🎟️ Eventos

#### ➕ Crear Evento
`POST /api/events`
```json
{
  "name": "Coldplay Live",
  "description": "El evento del año",
  "date": "2025-10-10",
  "capacity": 500,
  "imageBase64": "data:image/jpeg;base64,/9j/4AAQ..."
}
```
📎 **Respuesta:** `201 Created`

---

#### 📄 Listar Eventos (Solo activos)
`GET /api/events`
📎 **Respuesta:** Array de eventos con status = ACTIVO

---

#### 🔍 Obtener Evento por ID
`GET /api/events/{id}`
📎 **Respuesta:** Evento con campos completos

---

#### ✏️ Editar Evento
`PUT /api/events/{id}`
```json
{
  "name": "Nombre actualizado",
  "description": "Nueva descripción",
  "date": "2025-11-01",
  "capacity": 200,
  "imageBase64": "...opcional..."
}
```
📎 **Respuesta:** Evento actualizado

---

#### ❌ Cancelar Evento (delete lógico)
`DELETE /api/events/{id}`
📎 Cambia su `status` a `CANCELADO`

---

#### ✅ Reactivar Evento
`PATCH /api/events/{id}/activate`
📎 Cambia su `status` a `ACTIVO`

---

### 👥 Reservas

#### ➕ Crear Reserva
`POST /api/reservations`
```json
{
  "eventId": 1,
  "userEmail": "usuario@example.com",
  "eventStatus": "ACTIVO"
}
```
📎 **Respuesta:**
```json
{
  "id": 3,
  "userEmail": "usuario@example.com",
  "eventName": "Coldplay Live"
}
```

---

#### 📄 Listar Reservas por Usuario
`GET /api/reservations/user/{email}`
📎 Muestra nombre del evento, correo, y si está cancelado

---

## 🗄️ Base de Datos

Puedes importar el archivo `init_db.sql` (exportado desde pgAdmin) para tener los eventos, usuarios y reservas precargadas.

1. Abre pgAdmin.
2. Crea una base llamada `event_platform`.
3. Haz clic derecho en la base → Query Tool.
4. Carga y ejecuta `init_db.sql`.

---

## 🔐 Seguridad
- Implementado JWT.
- Autenticación por token al consumir los endpoints protegidos.

---

## ⚙️ Tecnologías
- Spring Boot 3
- PostgreSQL
- JPA (Hibernate)
- JWT
- Maven

---

## 📦 Ejecución Local
```bash
./mvnw spring-boot:run
```

> Asegúrate de tener PostgreSQL corriendo y las credenciales configuradas en `application.properties`.

---

## ✅ Estado
✅ Funcionalidad completa
🎯 Próximos pasos: unit tests, validaciones adicionales, frontend deploy

---

¿Dudas o sugerencias? ¡Contribuye o crea un issue en el repo! 🚀
