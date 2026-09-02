# Perfume Manager API 🧴

Una API RESTful desarrollada con **Java** y **Spring Boot** para gestionar una colección de perfumes y decants. Este proyecto proporciona endpoints para administrar el inventario, permitiendo realizar operaciones CRUD con un manejo eficiente de datos y persistencia en una base de datos relacional.

## 🚀 Tecnologías Utilizadas

* **Lenguaje:** Java 17+
* **Framework:** Spring Boot
* **Base de Datos:** PostgreSQL
* **Persistencia:** Spring Data JPA / Hibernate
* **Control de Versiones:** Git & GitHub
* **IDE:** IntelliJ IDEA

## ✨ Características de Arquitectura

* **Diseño por capas:** Separación estricta entre Controladores, Servicios y Repositorios.
* **Patrón DTO:** Transferencia segura de datos utilizando Mappers para no exponer las entidades de la base de datos.
* **Custom Queries:** Búsquedas relacionales y filtros avanzados (por Entorno y Marca) integrados con Spring Data JPA.
* **Integridad de Datos:** Control de validaciones y constraints delegados a PostgreSQL.

## 📡 Endpoints Principales

* `GET /api/perfumes` - Retorna el inventario completo.
* `GET /api/perfumes/entorno/{mode}` - Filtra las fragancias según su entorno de uso (ej. CITA, TRABAJO).
* `GET /api/perfumes/marca/{marcaId}` - Retorna todas las fragancias pertenecientes a una marca específica.

## 🛠️ Instalación y Configuración (Local)

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/AnderTy2106/perfume-manager-api.git
   cd perfume-manager-api
    ```
2. **Configurar la base de datos:**

   Crea una base de datos en tu servidor local de PostgreSQL. Luego, actualiza tus credenciales en el archivo src/main/resources/application.properties:
    ```properties 
   spring.datasource.url=jdbc:postgresql://localhost:5432/tu_base_de_datos
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
    ```
3. **Ejecutar la aplicación:**
   
    Inicia el proyecto desde IntelliJ IDEA. La API estará disponible en http://localhost:8080.

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - mira el archivo [LICENSE](LICENSE) para más detalles.
