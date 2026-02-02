# 🍽️ Recetas API

API REST profesional para gestión de recetas de cocina, construida con Spring Boot siguiendo las mejores prácticas de desarrollo.

## 🎯 Objetivo del proyecto

Crear una aplicación completa y profesional de recetas que incluya:
- ✅ Backend REST API con Spring Boot (Java)
- 🔄 Frontend PWA con Vue.js + TypeScript (pendiente)
- 🧪 Testing profesional (pendiente)
- 🐳 Docker + CI/CD (pendiente)
- 🚀 Deploy en producción (pendiente)

**La aplicación será una PWA (Progressive Web App)**, funcionando en cualquier dispositivo: PC, tablet y móvil.

## 🛠️ Tecnologías utilizadas

### Backend (Actual)
- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA** (ORM)
- **MySQL 8.0** (Base de datos)
- **Lombok** (Reducción de boilerplate)
- **Maven** (Gestión de dependencias)

### Frontend (Próximamente)
- **Vue.js 3** (Composition API)
- **TypeScript**
- **Vite** (Build tool)
- **PWA** (Instalable en todos los dispositivos)

### Herramientas de desarrollo
- **IntelliJ IDEA Ultimate**
- **Docker** (MySQL containerizado)
- **Postman** (Testing de API)
- **Git + GitHub**

## ⚡ Buenas prácticas implementadas

- ✅ **Arquitectura en capas** (Controller → Service → Repository → Entity)
- ✅ **Principios SOLID**
- ✅ **Código limpio** y legible
- ✅ **Nomenclatura en inglés** (variables, métodos, clases)
- ✅ **Separación de responsabilidades**
- ✅ **Inyección de dependencias**
- ✅ **Uso de DTOs** (preparado para implementar)
- ✅ **Manejo de errores** con ResponseEntity
- ✅ **Commits semánticos** (conventional commits)

## 📋 Funcionalidades actuales

### Endpoints implementados:

| Método | Endpoint | Descripción | Status |
|--------|----------|-------------|--------|
| GET | `/api/recipes` | Obtener todas las recetas | 200 OK |
| GET | `/api/recipes/{id}` | Obtener receta por ID | 200 OK / 404 |
| POST | `/api/recipes` | Crear nueva receta | 201 Created |
| PUT | `/api/recipes/{id}` | Actualizar receta | 200 OK |
| DELETE | `/api/recipes/{id}` | Eliminar receta | 204 No Content |

### Modelo de datos:
```json
{
  "id": 1,
  "name": "Paella Valenciana",
  "description": "Auténtica paella valenciana con pollo y conejo",
  "preparationTime": 30,
  "cookingTime": 45,
  "servings": 6
}
```

## 🚀 Cómo ejecutar el proyecto

### Prerrequisitos:
- Java 21 o superior
- Docker Desktop
- Maven (incluido en IntelliJ)

### Paso 1: Levantar MySQL con Docker
```bash
docker run --name recetas-mysql \
  -e MYSQL_ROOT_PASSWORD=root123 \
  -e MYSQL_DATABASE=recetas_db \
  -p 3306:3306 \
  -d mysql:8.0
```

### Paso 2: Clonar el repositorio
```bash
git clone https://github.com/JODOSA/recetas-api.git
cd recetas-api
```

### Paso 3: Configurar `application.properties`

El archivo ya está configurado para MySQL local:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/recetas_db
spring.datasource.username=root
spring.datasource.password=root123
```

### Paso 4: Ejecutar la aplicación

**Opción A: Desde IntelliJ**
- Abrir el proyecto
- Run `RecetasApiApplication.java`

**Opción B: Desde terminal**
```bash
./mvnw spring-boot:run
```

La API estará disponible en: `http://localhost:8080`

## 🧪 Probar la API

### Crear una receta:
```bash
POST http://localhost:8080/api/recipes
Content-Type: application/json

{
  "name": "Gazpacho Andaluz",
  "description": "Sopa fría de tomate perfecta para el verano",
  "preparationTime": 15,
  "cookingTime": 0,
  "servings": 4
}
```

### Obtener todas las recetas:
```bash
GET http://localhost:8080/api/recipes
```

## 📁 Estructura del proyecto
```
src/main/java/com/recetas/recetasapi/
├── entity/
│   └── Recipe.java           # Entidad JPA (modelo de datos)
├── repository/
│   └── RecipeRepository.java # Capa de acceso a datos
├── service/
│   └── RecipeService.java    # Lógica de negocio
├── controller/
│   └── RecipeController.java # Endpoints REST
└── RecetasApiApplication.java # Clase principal
```

### Arquitectura implementada:
```
HTTP Request
    ↓
Controller (Recibe request, valida, devuelve response)
    ↓
Service (Lógica de negocio, validaciones, transformaciones)
    ↓
Repository (Acceso a base de datos)
    ↓
MySQL Database
```

## 🔜 Próximos pasos

### Backend:
- [ ] Añadir entidad Ingredient (relación OneToMany)
- [ ] Añadir entidad Category (relación ManyToMany)
- [ ] Sistema de usuarios (User entity)
- [ ] Autenticación y autorización (Spring Security + JWT)
- [ ] Búsqueda avanzada y filtros
- [ ] Upload de imágenes de recetas
- [ ] Validaciones con Bean Validation (@Valid)
- [ ] DTOs para separar modelo de presentación
- [ ] Manejo global de excepciones (@ControllerAdvice)
- [ ] Testing unitario e integración (JUnit + Mockito)

### Frontend:
- [ ] Setup Vue.js 3 + TypeScript + Vite
- [ ] Diseño responsive (mobile-first)
- [ ] Consumo de API REST (Axios)
- [ ] State management (Pinia)
- [ ] Routing (Vue Router)
- [ ] Convertir en PWA (instalable)
- [ ] Service Workers (funcionalidad offline)

### DevOps:
- [ ] Dockerfile para backend
- [ ] Docker Compose (app + MySQL)
- [ ] Testing automatizado
- [ ] CI/CD con GitHub Actions
- [ ] Deploy backend en Railway/Render
- [ ] Deploy frontend en Vercel/Netlify

## 👨‍💻 Autor

**Joaquín Domínguez**
- GitHub: [@JODOSA](https://github.com/JODOSA)

## 📝 Licencia

Este proyecto es de código abierto y está disponible para aprendizaje.

---

**Estado del proyecto:** 🟢 En desarrollo activo  
**Última actualización:** Febrero 2026  
**Versión actual:** v0.1.0 (Backend CRUD básico)