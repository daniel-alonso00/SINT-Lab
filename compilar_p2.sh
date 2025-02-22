#!/bin/bash

echo "Compilando archivos de p2..."

# Definir classpath con rutas relativas desde la raíz del proyecto
CLASSPATH="apache-tomcat-10.0.26/lib/servlet-api.jar:public_html/webapps/WEB-INF/lib/json-20231013.jar"

# Compilar los archivos .java y guardar los errores en un archivo temporal
javac -classpath "$CLASSPATH" -d public_html/webapps/WEB-INF/classes/ public_html/webapps/WEB-INF/classes/p2/*.java 2> errores.log

# Si hay errores, mostrarlos en pantalla
if [ $? -ne 0 ]; then
    echo "ERROR: Falló la compilación. Detalles:"
    cat errores.log
    exit 1
else
    echo "Compilación exitosa."
    rm -f errores.log
fi
