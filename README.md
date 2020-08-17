# ProyectoFinal
 GRADE SYSTEM
Grade System es una página web que nos permite llevar un buen control y registro de notas. 

RESULTADO FINAL
En la página de inicio se encuentran los datos de nuestra Escuela(direccion, telefono, email), tambien cuenta con una pequeña 
descripción y nuestros objetivos.
Aqui tambien hay 3 botones:
Home, que nos redirecciona a la pagina principal.
Estudiante, con el cual los alumnos tienen acceso a ver sus notas solo si ingresan el código correspondiente.
Administrador, este boton nos redirecciona a un login de administrador, en este caso el unico usuario y contraseña que existe
es "admin".
El estudiante, al ingresar su código le muestra sus datos personales, y las notas que tiene en el respectivo curso, además de 
su promedio general, adicional a esto tiene una opcion para imprimir tus notas.
El administrador tiene acceso a la lista de los alumnos existentes en la carrera, además de las notas correspondientes. Este 
tambien puede ingresar nuevos datos(estudiantes,notas);modificar datos(estudiantes,notas) y eliminar datos(estudiantes,notas).

¿QUE SE NECESITA PARA CORRER O ELABORAR EL PPROYECTO?
Para poder realizar el proyecto se necesita tener instalado Java 8, descargar Eclipse Neon y configurarlo con Apache Tomcat.
Tambien debes de tener instalado MySQL con algún entorno para poder administrarlos bien sea phpMyadmin o MySQL Workbench. 

HOJA DE RUTA PARA ELABORAR EL PROYECTO
Crear la base de datos con la tabla student y result.
Crear el proyecto Web.
Convertir el proyecto Web a Maven y configurar el archivo pom.xml.
Definir la conexión a la base de datos usando el archivo web.xml
Crear el modelo para la tabla student y la tabla result.
Crear la clase CRUD y Controlador tanto para estudiante como para nota.
Crear las Vistas de la pagina web (usando boostrap e imagenes de google).

¿COMO CORRER EL PROYECTO?
1. Primero necesita clonar este repositorio.
2. Despues de debe de crear una base de datos llamada project1
3. A continuación, lo único que se necesita hacer es copiar el código que se encuentra en database.sql
4. Seguidamente debera copiar el proyecto en su Workspace de Eclipse
5. Solo debera correr el proyecto haciendo anticlick en la carpeta principal, luego seleccionar Run As, seguido de Run on Server. 
