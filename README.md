# 🍳 Recetas API - Spring Boot

API REST completa para gestión de recetas de cocina con sistema de usuarios, favoritos, calificaciones y más.

---

## 📋 Tabla de Contenidos

- [Descripción del Proyecto](#-descripción-del-proyecto)
- [Tecnologías Utilizadas](#-tecnologías-utilizadas)
- [Modelo de Datos](#-modelo-de-datos)
- [Progreso del Proyecto](#-progreso-del-proyecto)
- [Configuración y Ejecución](#-configuración-y-ejecución)
- [Endpoints API](#-endpoints-api)
- [Roadmap](#-roadmap)

---

## 🎯 Descripción del Proyecto

Aplicación completa y profesional de recetas que incluye:
- ✅ Backend REST API con Spring Boot (Java 21)
- 🔄 Frontend PWA con Vue.js + TypeScript *(próximamente)*
- 🧪 Testing profesional *(próximamente)*
- 🐳 Docker + CI/CD
- ☁️ AWS S3 para almacenamiento de imágenes *(próximamente)*
- 🚀 Deploy en producción *(próximamente)*

**La aplicación será una PWA (Progressive Web App)**, funcionando en cualquier dispositivo: PC, tablet y móvil.

---

## 🛠️ Tecnologías Utilizadas

### Backend
- **Java 21** - Última versión LTS
- **Spring Boot 3.x** - Framework principal
- **Spring Data JPA** - ORM para persistencia
- **MySQL 8.0** - Base de datos relacional
- **Lombok** - Reducción de código boilerplate
- **Maven** - Gestión de dependencias
- **Docker** - Contenedorización

### Herramientas de Desarrollo
- **IntelliJ IDEA Ultimate**
- **Docker Desktop**
- **Postman** - Testing de API
- **Git + GitHub** - Control de versiones

### Próximas Tecnologías
- **Spring Security** + JWT - Autenticación y autorización
- **AWS S3** - Almacenamiento de imágenes
- **Vue.js 3** + TypeScript - Frontend
- **Flyway/Liquibase** - Migraciones de base de datos

---

## 🗂️ Modelo de Datos

### Entidades Implementadas

#### **Recipe** (Receta)
```java
- id (Long)
- name (String)
- description (String)
- preparationTime (Integer)
- cookingTime (Integer)
- servings (Integer)
- difficulty (Enum: EASY, MEDIUM, HARD)
- isPublic (Boolean)
- imageUrl (String) - Para AWS S3
- createdAt (LocalDateTime)
- updatedAt (LocalDateTime)
- author (User)
- ingredients (List<Ingredient>)
- steps (List<Step>)
- favorites (List<Favorite>)
- ratings (List<Rating>)
- recipeCategories (List<RecipeCategory>)
- recipeTags (List<RecipeTag>)
```

#### **User** (Usuario)
```java
- id (Long)
- username (String, unique)
- email (String, unique)
- password (String) - Encriptada
- firstName (String)
- lastName (String)
- role (Enum: USER, ADMIN)
- createdAt (LocalDateTime)
```

#### **Ingredient** (Ingrediente)
```java
- id (Long)
- name (String)
- quantity (String)
- recipe (Recipe)
```

#### **Step** (Paso de preparación)
```java
- id (Long)
- stepNumber (Integer)
- description (String)
- imageUrl (String)
- recipe (Recipe)
```

#### **Category** (Categoría)
```java
- id (Long)
- name (String, unique)
- description (String)
- slug (String, unique)
```

#### **Tag** (Etiqueta)
```java
- id (Long)
- name (String, unique)
```

#### **Favorite** (Favorito)
```java
- id (Long)
- user (User)
- recipe (Recipe)
- createdAt (LocalDateTime)
- Constraint: Un usuario solo puede marcar una receta como favorita una vez
```

#### **Rating** (Calificación)
```java
- id (Long)
- user (User)
- recipe (Recipe)
- stars (Integer: 1-5)
- comment (String)
- createdAt (LocalDateTime)
- Constraint: Un usuario solo puede calificar una receta una vez
```

#### **RecipeCategory** (Relación Recipe-Category)
```java
- id (Long)
- recipe (Recipe)
- category (Category)
```

#### **RecipeTag** (Relación Recipe-Tag)
```java
- id (Long)
- recipe (Recipe)
- tag (Tag)
```

### Diagrama de Relaciones
```
                    ┌─────────┐
                    │  User   │
                    └────┬────┘
                         │
              ┌──────────┴──────────┐
              │                     │
         (author)              (favoritos/ratings)
              │                     │
         ┌────▼─────┐          ┌───▼────┐
         │  Recipe  │◄─────────┤Favorite│
         └────┬─────┘          └────────┘
              │
    ┌─────────┼─────────┬─────────┬──────────┐
    │         │         │         │          │
┌───▼───┐ ┌──▼──┐  ┌──▼───┐ ┌───▼────┐ ┌──▼─────┐
│Ingred.│ │Step │  │Rating│ │RecipeCa│ │RecipeT │
└───────┘ └─────┘  └──────┘ │tegory  │ │ag      │
                             └───┬────┘ └───┬────┘
                                 │          │
                            ┌────▼───┐  ┌──▼──┐
                            │Category│  │ Tag │
                            └────────┘  └─────┘
```

---

## ✅ Progreso del Proyecto

### FASE 1: Modelo de Datos ✅ COMPLETADA
- [x] Diseño completo de entidades
- [x] 10 entidades creadas
- [x] 2 ENUMs (Difficulty, UserRole)
- [x] Relaciones OneToMany, ManyToOne, ManyToMany
- [x] Constraints de unicidad
- [x] Timestamps automáticos (CreationTimestamp, UpdateTimestamp)
- [x] Cascadas y orphan removal
- [x] Base de datos MySQL funcionando con Docker
- [x] Todas las tablas creadas correctamente

### FASE 2: Repositories y Services 🔄 EN PROGRESO
- [ ] UserRepository + UserService
- [ ] CategoryRepository + CategoryService
- [ ] TagRepository + TagService
- [ ] RecipeService actualizado (con nuevas relaciones)
- [ ] StepService
- [ ] FavoriteService
- [ ] RatingService

### FASE 3: Controllers y Endpoints 📋 PENDIENTE
- [ ] UserController
- [ ] CategoryController
- [ ] TagController
- [ ] RecipeController actualizado
- [ ] FavoriteController
- [ ] RatingController
- [ ] Validaciones con Bean Validation
- [ ] Manejo de errores global

### FASE 4: AWS S3 Integration ☁️ PENDIENTE
- [ ] Configurar cuenta AWS (free tier)
- [ ] Crear bucket S3
- [ ] AWS SDK para Java
- [ ] Servicio de upload de imágenes
- [ ] Endpoint para subir imágenes
- [ ] URLs firmadas (signed URLs)
- [ ] Validación de tipos y tamaños

### FASE 5: Spring Security + JWT 🔐 PENDIENTE
- [ ] Configuración de Spring Security
- [ ] Autenticación con JWT
- [ ] Endpoint de registro
- [ ] Endpoint de login
- [ ] Protección de endpoints
- [ ] Roles y permisos

### FASE 6: Testing 🧪 PENDIENTE
- [ ] Tests unitarios (JUnit 5)
- [ ] Tests de integración
- [ ] MockMvc para controllers
- [ ] Testcontainers para MySQL

### FASE 7: Frontend PWA 🎨 PENDIENTE
- [ ] Vue.js 3 + TypeScript
- [ ] Vite como build tool
- [ ] Configuración PWA
- [ ] Integración con backend

### FASE 8: Deploy 🚀 PENDIENTE
- [ ] Docker Compose para producción
- [ ] CI/CD con GitHub Actions
- [ ] Deploy en cloud (Railway/Render/AWS)

---

## ⚙️ Configuración y Ejecución

### Prerrequisitos
- **Java 21** instalado
- **Docker Desktop** instalado y corriendo
- **IntelliJ IDEA** (recomendado)
- **Maven** (incluido en IntelliJ)

### Pasos para ejecutar

1. **Clonar el repositorio**
```bash
git clone https://github.com/JODOSA/recetas-api.git
cd recetas-api
```

2. **Iniciar MySQL con Docker**
```bash
docker run -d \
  --name recetas-mysql \
  -e MYSQL_ROOT_PASSWORD=root123 \
  -e MYSQL_DATABASE=recetas_db \
  -p 3306:3306 \
  mysql:8.0
```

3. **Configurar application.properties**

El archivo ya está configurado en `src/main/resources/application.properties`:
```properties
spring.application.name=recetas-api
spring.datasource.url=jdbc:mysql://localhost:3306/recetas_db
spring.datasource.username=root
spring.datasource.password=root123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

4. **Ejecutar la aplicación**
```bash
mvn spring-boot:run
```

O desde IntelliJ: Click en el botón verde ▶️

5. **Verificar que funciona**
```
http://localhost:8080
```

---

## 📡 Endpoints API

### Estado actual: CRUD básico de Recipe + Ingredient

| Método | Endpoint | Descripción | Estado |
|--------|----------|-------------|--------|
| GET | `/api/recipes` | Obtener todas las recetas | ✅ |
| GET | `/api/recipes/{id}` | Obtener receta por ID | ✅ |
| POST | `/api/recipes` | Crear nueva receta con ingredientes | ✅ |
| PUT | `/api/recipes/{id}` | Actualizar receta | ✅ |
| DELETE | `/api/recipes/{id}` | Eliminar receta | ✅ |

### Próximos endpoints (Fase 3)

**Users:**
- POST `/api/auth/register` - Registro
- POST `/api/auth/login` - Login
- GET `/api/users/me` - Perfil del usuario

**Categories:**
- GET `/api/categories` - Listar categorías
- POST `/api/categories` - Crear categoría (ADMIN)

**Tags:**
- GET `/api/tags` - Listar tags
- POST `/api/tags` - Crear tag (ADMIN)

**Favorites:**
- GET `/api/users/me/favorites` - Mis favoritos
- POST `/api/recipes/{id}/favorite` - Marcar como favorito
- DELETE `/api/recipes/{id}/favorite` - Quitar de favoritos

**Ratings:**
- GET `/api/recipes/{id}/ratings` - Calificaciones de una receta
- POST `/api/recipes/{id}/ratings` - Calificar receta
- GET `/api/recipes/{id}/average-rating` - Promedio de calificaciones

---

## 🗺️ Roadmap

### Semana 1-2 ✅ COMPLETADA
- Setup inicial del proyecto
- Entidad Recipe + Ingredient
- CRUD básico funcionando
- MySQL con Docker
- Git + GitHub

### Semana 3-4 ✅ COMPLETADA
- Diseño completo del modelo de datos
- 10 entidades + 2 ENUMs
- Todas las relaciones implementadas
- Base de datos funcionando

### Semana 5-6 🔄 EN PROGRESO
- Repositories y Services
- Controllers y endpoints
- Validaciones

### Semana 7-8
- Spring Security + JWT
- Autenticación completa

### Semana 9-10
- AWS S3 Integration
- Upload de imágenes

### Semana 11-12
- Testing completo
- Frontend básico con Vue.js

### Semana 13-14
- PWA completa
- Deploy en producción

---

## 🏆 Buenas Prácticas Implementadas

- ✅ **Arquitectura en capas** (Entity → Repository → Service → Controller)
- ✅ **Principios SOLID**
- ✅ **Código limpio y legible**
- ✅ **Nomenclatura en inglés**
- ✅ **Separación de responsabilidades**
- ✅ **Inyección de dependencias**
- ✅ **Uso de DTOs** (próximamente)
- ✅ **Manejo de errores**
- ✅ **Commits semánticos** (Conventional Commits)
- ✅ **Git Flow** con ramas feature
- ✅ **Documentación actualizada**

---

## 📚 Recursos de Aprendizaje

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)
- [AWS S3 Java SDK](https://docs.aws.amazon.com/sdk-for-java/)
- [JWT Authentication](https://jwt.io/)

---

## 👤 Autor

**Joaquín Domínguez**
- GitHub: [@JODOSA](https://github.com/JODOSA)

---

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.

---

**⭐ Si te gusta este proyecto, dale una estrella en GitHub!**