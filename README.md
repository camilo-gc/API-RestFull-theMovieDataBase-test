# RestFull-API-theMovieDataBase-test

Aplicacion sencilla que consume la API del proyecto The Movie DataBase para obtener, procesar y exponer la informacion mediante 
los endpoints descritos en el apartado de **_Uso_**.

## Requisitos
1. Java 8 o superior instalado
2. Maven 3 o superior instalado

## Instalación
**Clonar el repositorio:** git clone https://github.com/camilo-gc/RestFull-API-theMovieDataBase-test.git
**Navegar al directorio:** cd RestFull-API-theMovieDataBase-test
**Compilar la aplicación:** mvn clean package
**Ejecutar la aplicación:** java -jar target/RestFull-API-theMovieDataBase-test-1.0-SNAPSHOT.jar

## Uso
Tomando en cuenta que la aplicacion se instalo de manera local, se toma como url base https://localhost:8080 a continuacion se describen los endpoint disponibles y 
su funcionamiento:

1. [http://localhost:8080/api-test/movies/](http://localhost:8080/api-test/movies/) Este endpoint otorga las 20 primeras 
peliculas, si se quieren mas resultados, basta con especificar el numero de pagina que se desee ver como variable 
_**page**_ ejemplo: http://localhost:8080/api-test/movies/?page=2

## Contribuciones
Se agradecen y se aceptan contribuciones. Para contribuir a la aplicación, sigue estos pasos:

1. Haz un fork del repositorio
2. Crea una nueva rama: git checkout -b nombre-rama
3. Haz tus cambios y commitea: git commit -am 'Descripción de los cambios'
4. Push a la rama: git push origin nombre-rama
5. Crea un pull request

## Licencia
Este proyecto está licenciado bajo la Licencia MIT. Consulte el archivo LICENSE.md para obtener más detalles.

## Contacto
Si tienes alguna pregunta o comentario, por favor contacta a nombre-de-contacto.