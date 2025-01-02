package visual;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

public class Ventana {

    private AreaLienzo lienzo;
    private SequentialTransitionWrapper animacionWrapper;

    public void mostrar(Stage esc) {
        // inicializo los componentes visuales
        lienzo = new AreaLienzo();
        animacionWrapper = new SequentialTransitionWrapper(lienzo);

        PanelCtrl panelCtrl = new PanelCtrl(animacionWrapper);

        BorderPane root = new BorderPane();
        root.setCenter(lienzo.getLienzo()); // lienzo
        root.setLeft(panelCtrl.getPanel());

        Scene escena = new Scene(root, 1000, 800);
        escena.getStylesheets().add(getClass().getResource("/estilos/estilo.css").toExternalForm());

        esc.setTitle("FERITMICS @ 2024");
        esc.setScene(escena);
        esc.show();
    }
}

