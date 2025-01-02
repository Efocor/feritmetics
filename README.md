# Feritmetics (Simulador y Visualizador de Algoritmos en Java>)

## Descripción

Este proyecto es un simulador y visualizador de diversos algoritmos de ordenamiento, búsqueda y grafos, desarrollado en Java utilizando JavaFX para la interfaz gráfica. Está diseñado para ser una herramienta educativa que permite a los usuarios visualizar el funcionamiento interno de los algoritmos de manera interactiva.

## Requisitos

- **Java Development Kit (JDK) 11 o superior**: Asegúrate de tener instalado el JDK. Puedes descargarlo desde [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) o utilizar distribuciones alternativas como [Adoptium](https://adoptium.net/).

- **JavaFX SDK**: Necesario para la interfaz gráfica. Descárgalo desde [OpenJFX](https://openjfx.io/).

- **Visual Studio Code**: Editor recomendado para trabajar con este proyecto. Descárgalo desde [Visual Studio Code](https://code.visualstudio.com/).

## Configuración del Entorno en Windows

1. **Instalar Java JDK**

   - Descarga e instala el JDK desde [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) o [Adoptium](https://adoptium.net/).
   - Configura la variable de entorno `JAVA_HOME` apuntando al directorio de instalación del JDK.
   - Añade `%JAVA_HOME%\bin` a la variable de entorno `PATH`.

2. **Instalar JavaFX SDK**

   - Descarga el SDK desde [OpenJFX](https://openjfx.io/).
   - Extrae el contenido en una carpeta, por ejemplo, `C:\javafx-sdk-17`.

3. **Configurar Visual Studio Code**

   - **Instalar Extensiones Necesarias**:
     - *Java Extension Pack* de Microsoft.
     - *JavaFX Support* si está disponible.
   
   - **Configurar Variables de Entorno en VS Code**:
     - Abre el proyecto en VS Code.
     - Crea un archivo `launch.json` en `.vscode/` con la siguiente configuración para ejecutar aplicaciones JavaFX:

       ```json
       {
           "version": "0.2.0",
           "configurations": [
               {
                   "type": "java",
                   "name": "Launch MainApp",
                   "request": "launch",
                   "mainClass": "visual.MainApp",
                   "vmArgs": "--module-path C:\\javafx-sdk-17\\lib --add-modules javafx.controls,javafx.fxml"
               }
           ]
       }
       ```

       *(Asegúrate de reemplazar `C:\\javafx-sdk-17\\lib` con la ruta correcta hacia tu carpeta `lib` de JavaFX.)*

## Compilación y Ejecución desde la Línea de Comandos

1. **Navegar a la Carpeta del Proyecto**

   Abre una terminal de comandos y navega hasta la carpeta raíz del proyecto:

   ```bash
   cd ruta\al\proyecto\feritmetics
