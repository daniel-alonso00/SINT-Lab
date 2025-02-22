@echo off
echo Compilando archivos de p3...

REM Definir classpath con rutas relativas desde la raíz del proyecto
set CLASSPATH=apache-tomcat-10.0.26/lib/servlet-api.jar

REM Compilar los archivos .java y guardar la salida (errores incluidos) en un archivo temporal
javac -classpath "%CLASSPATH%" -d public_html/webapps/WEB-INF/classes/ public_html/webapps/WEB-INF/classes/p3/*.java 2> errores.log

REM Si hay errores, mostrarlos en pantalla
IF %ERRORLEVEL% NEQ 0 (
    echo ERROR: Fallo la compilacion. Detalles:
    type errores.log
    exit /b %ERRORLEVEL%
) ELSE (
    echo Compilacion exitosa.
    del errores.log 2>nul
)
