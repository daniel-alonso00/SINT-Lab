# 🚀 **Prácticas de "Servicios de Internet" (Curso 2024-2025)**

Este repositorio contiene las prácticas realizadas para la asignatura **"Servicios de Internet"** durante el curso **2024-2025**. A continuación, se describe cada práctica junto con sus detalles y tecnologías utilizadas. 

---

## 🎬 **P2: Servicio de Consulta de Películas**

### 🎯 **Objetivo**
Desarrollar un servicio de consulta de películas utilizando tecnologías web como **HTML**, **XML**, y **APIs REST**. El servicio permite a los usuarios consultar información sobre películas, actores e idiomas disponibles, con una estructura de navegación basada en fases.

### 🛠️ **Tecnologías utilizadas**
- **XML (MML):** Para almacenar la información de las películas.
- **HTML:** Para la interfaz de usuario.
- **API REST:** Para proporcionar acceso a los datos en formato **JSON**.
- **Java (Servlets, DOM, JAXP):** Para procesar las consultas y generar respuestas.
- **Apache Tomcat:** Como servidor de aplicaciones.

### 🗂️ **Estructura del proyecto**
- `DataModel.java`: Lógica para gestionar y buscar la información en el fichero **XML**.
- `FrontEnd.java`: Genera respuestas **HTML** y **JSON**.
- `SintP2.java`: Servlet principal que maneja solicitudes y respuestas.
```
├── apache-tomcat-10.0.26
├── public_html
│   ├── webapps
│   │   ├── p2
│   │   │   ├── styles.css
│   │   ├── WEB-INF
│   │   │   ├── classes
│   │   │   │   ├── p2
│   │   │   │   │   ├── DataModel.java
│   │   │   │   │   ├── FrontEnd.java
│   │   │   │   │   ├── SintP2.java
│   │   │   │   │   ├── Cast.java
│   │   │   │   │   ├── Movie.java
│   │   │   │   ├── p3
│   │   │   ├── web.xml
│   │   │   ├── lib
├── README.md
```

### 🌐 **API REST**

El servicio proporciona una **API REST** que devuelve datos en formato **JSON**. Los endpoints disponibles son:

  1. Obtener idiomas disponibles  
     `GET /sint/P2M/v1/langs`
  
  2. Obtener actores/actrices por idioma  
     `GET /sint/P2M/v1/cast?lang={lang}`  
     Parámetro: `lang` (código del idioma).
  
  3. Obtener películas de un actor/actriz
     `GET /sint/P2M/v1/cast/{id}/movies`  
     Parámetro: `id` (ID del actor/actriz).

### 🔧 **Instrucciones de ejecución**
1. Configura un servidor **Apache Tomcat** (versión 10).
2. Despliega el proyecto en el contexto `sint` e inicializa el servicio de **Apache Tomcat**.
3. Accede al servicio a través de la URL:  
   `http://localhost:6000/sint/P2M`

### 📜 **Scripts de compilación y despliegue**
- **Windows:** Ejecuta el script `compilar_p2.bat` para compilar y desplegar automáticamente los archivos.
- **Linux:** Ejecuta el script `compilar_p2.sh` para compilar y desplegar automáticamente los archivos.

---

Claro, aquí tienes la sección de la **P3** adaptada siguiendo el estilo y formato de la **P2**, sin incluir la parte de la API REST:

---

## 🔄 **P3: Reimplementación de la P2 usando MVC**

### 🎯 **Objetivo**  
Reimplementar la **P2** utilizando el patrón de arquitectura **Modelo-Vista-Controlador (MVC)**. La funcionalidad sigue siendo la misma, pero la implementación se organiza utilizando **Servlets**, **JavaBeans** y **JSP (JavaServer Pages)**.

### 🛠️ **Tecnologías utilizadas**
- **Servlets:** Para manejar solicitudes y controlar el flujo de la aplicación.
- **JavaBeans:** Para gestionar la lógica de negocio y la interacción con los datos.
- **JSP:** Para generar las vistas **HTML**.
- **JSTL (JavaServer Pages Standard Tag Library):** Para evitar la inclusión de código Java directamente en las páginas **JSP**.

### 🗂️ **Estructura del proyecto**
- **Servlet principal:** Identifica la operación solicitada y transfiere el control a la página **JSP** correspondiente.
- **JavaBeans:** Gestionan la información necesaria para cada fase de la consulta.
- **Páginas JSP:** Generan las respuestas **HTML** y contienen formularios para continuar con la consulta.
```
├── apache-tomcat-10.0.26
├── public_html
│   ├── webapps
│   │   ├── p3
│   │   │   ├── Fase0.jsp
│   │   │   ├── Fase1.jsp
│   │   │   ├── Fase2.jsp
│   │   │   ├── Fase3.jsp
│   │   │   ├── styles.css
│   │   ├── WEB-INF
│   │   │   ├── classes
│   │   │   │   ├── p3
│   │   │   │   │   ├── BeanFase0.java
│   │   │   │   │   ├── BeanFase1.java
│   │   │   │   │   ├── BeanFase2.java
│   │   │   │   │   ├── BeanFase3.java
│   │   │   │   │   ├── Movie.java
│   │   │   │   │   ├── Cast.java
│   │   │   │   │   ├── DataModel.java
│   │   │   │   │   ├── FrontEnd.java
│   │   │   │   │   ├── SintP3.java
│   │   │   │   ├── p2
│   │   │   ├── web.xml
│   │   │   ├── lib
├── README.md
```

### 🔧 **Instrucciones de ejecución**
1. Configura un servidor **Apache Tomcat** (versión 10).
2. Despliega el proyecto en el contexto `sint`.
3. Accede al servicio a través de la URL:  
   `http://localhost:6000/sint/P3M`

### 📜 **Scripts de compilación y despliegue**
- **Windows:** Ejecuta el script `compilar_p3.bat` para compilar y desplegar automáticamente los archivos.
- **Linux:** Ejecuta el script `compilar_p3.sh` para compilar y desplegar automáticamente los archivos.

---

De esta forma, la **P3** está estructurada de manera consistente con la **P2**, omitiendo la API REST, ya que no es parte de esta práctica.

---
🔒 **Este repositorio es parte de las prácticas de la asignatura "Servicios de Internet" y debe ser utilizado únicamente con fines académicos.**
