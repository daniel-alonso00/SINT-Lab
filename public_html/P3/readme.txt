sint2
Daniel Alonso Fernández

Los ficheros de fases JSP estan dentro de webapps en una carpeta p3, junto con el styles.css
El resto de los ficheros estan dentro de classes/p3, en la cual estan todos los .java incluyendo los beans de cada una de las fases

como compilar:
desde dentro de la carpeta de classes/p3

javac -classpath ~/apache-tomcat-10.0.26/lib/servlet-api.jar *.java
