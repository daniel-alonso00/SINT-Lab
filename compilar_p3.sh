#!/bin/bash

echo "Compilando archivos de p3..."

# Definir classpath con rutas relativas desde la raíz del proyecto
CLASSPATH="apache-tomcat-10.0.26/lib/servlet-api.jar"

# Compilar los archivos .java y guardar los errores en un archivo temporal
javac -classpath "$CLASSPATH" -d public_html/webapps/WEB-INF/classes/ public_html/webapps/WEB-INF/classes/p3/*.java 2> errores.log

# Si hay errores, mostrarlos en pantalla
if [ $? -ne 0 ]; then
    echo "ERROR: Fallo la compilacion. Detalles:"
    cat errores.log
    exit 1
else
    echo "Compilacion exitosa."
    rm -f errores.log
fi
