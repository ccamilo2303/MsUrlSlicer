Para ejecutar el proyecto se debe:
1) Decargar las dependencias con MAVEN
2) En el archivo application.yml ajustar las credenciales y el nombre de las base de datos, se usa una db postgres
3) ejecutar el siguiente script:

create table url_slicer(
	id SERIAL primary key,
	original_url varchar(200),
	short_url varchar(200),
	date_creation timestamp
);

4) Esta es la URL para probar localmente:

POST => http://localhost:8082/msurlslicer/api/v1/url-slicer
BODY => {
    "longUrl": "https://excelcredit.atlassian.net/jira/software/projects/SAI/boards/90/backlog"
}

5) Esta es la URL para consultar la redirección:
GET => http://localhost:8082/msurlslicer/api/v1/url-slicer/HASH URL ACORTADA
Ejemplo:  http://localhost:8082/msurlslicer/api/v1/url-slicer/e04fbabc0f16136e6f187fff16ee65080