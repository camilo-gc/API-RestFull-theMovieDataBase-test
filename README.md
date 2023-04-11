# RestFull-API-theMovieDataBase-test

Aplicación sencilla que consume la API del proyecto The Movie DataBase para obtener, procesar y exponer la informacion
mediante los endpoints descritos en el apartado de **_Uso_**.

## Requisitos
1. Java 8 o superior instalado
2. Maven 3 o superior instalado

## Instalación
1. **Clonar el repositorio:** git clone https://github.com/camilo-gc/RestFull-API-theMovieDataBase-test.git
2. **Navegar al directorio:** cd RestFull-API-theMovieDataBase-test
3. **Compilar la aplicación:** mvn clean package
4. **Ejecutar la aplicación:** java -jar target/RestFull-API-theMovieDataBase-test-1.0-SNAPSHOT.jar

## Uso
Tomando en cuenta que la aplicación se instaló de manera local, se toma como url base **_http://localhost:8080/api-test_**
a continuación se describen los endpoint disponibles y su funcionamiento:

1. Todas las respuestas están estandarizadas mediante un JSON el cual contiene el código del estado, una descripción y
   el contenido de la respuesta: `{"status_code":"", "description":"", "content":[]}`
2. [**/movies/**]() Como resultado se obtienen un listado de 20 películas en el contenido del JSON, Para obtener otra 
lista diferente, se debe especificar el número de página enviando la variable _**page**_ Ejemplo: **_/movies/?page=2_**
3. [**/movies/{id}**]() Se obtienen los detalles de una película en el contenido del JSON. Se debe enviar el **_id_** en 
la url de la siguiente manera. Ejemplo: **_/movies/2_**
4. [**/auth/guest/new**]() Se solicita una sesión de invitado, obteniendo el id de la sesión y su expiración en el 
contenido del JSON.
5. [**/movies/rated/{id}?guest_session_id=xxx**]() Se realiza la valoración de una película enviando el **_id_** en la 
url. Para ello primero debe haber solicitado una sesión y enviar el id como variable **_guest_session_id_**. Ejemplo: 
**_/movies/rated/2?guest_session_id=57fbc9e3eaf08cc424137e35a6909a3f_** y enviar la puntuación en el cuerpo de la 
solicitud. Ejemplo: `{"value": 10}` el valor debe estar entre 1 y 10.
6. [**/movies/ratings?guest_session_id=xxx**]() Se obtienen las películas valoradas con la sesión activa en el contenido 
del JSON. Se debe enviar el id de la sesión activa en la variable **_guest_session_id_** Ejemplo: 
**_/movies/ratings?guest_session_id=57fbc9e3eaf08cc424137e35a6909a3f_**
7. [**/movies/rated/{id}?guest_session_id=xxx**]() Se elimina la valoración de una película, se debe enviar el **_id_** 
en la url y el id de la sesión activa como variable **_guest_session_id_** Ejemplo: 
**_/movies/rated/2?guest_session_id=57fbc9e3eaf08cc424137e35a6909a3f_**
8. **_/swagger-ui/_** Para visualizar la documentacion.

## Contribuciones
Se agradecen y se aceptan contribuciones. Para contribuir a la aplicación, sigue estos pasos:

1. Haz un fork del repositorio
2. Crea una nueva rama: git checkout -b nombre-rama
3. Haz tus cambios y commitea: git commit -am 'Descripción de los cambios'
4. Push a la rama: git push origin nombre-rama
5. Crea un pull request

## Licencia
Este proyecto está regido por la Licencia y restricciones de la API TMDB. Si desea leer más sobre esto, ingrese [aquí](https://www.themoviedb.org/documentation/api/terms-of-use).

## Contacto
Si tienes alguna pregunta o comentario, por favor contactarme al email **_camilogarcia.dev@gmail.com_**
