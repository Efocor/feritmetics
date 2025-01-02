package visual;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage esc) {
        // inicio la ventana principal
        Ventana ven = new Ventana();
        ven.mostrar(esc);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

//javac --module-path "C:\javafx-sdk\lib" --add-modules javafx.controls,javafx.fxml -d bin -sourcepath src src/visual/MainApp.java src/algs/*.java src/algs/utils/*.java
//java --module-path C:\javafx-sdk\lib --add-modules javafx.controls,javafx.fxml -cp bin visual.MainApp
//xcopy src\estilos bin\estilos /E /I /Y

//java --module-path C:\javafx-sdk\lib --add-modules javafx.controls,javafx.fxml -cp bin visual.MainApp