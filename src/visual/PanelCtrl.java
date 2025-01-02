package visual;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import algs.OrdiBur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class PanelCtrl {

    private VBox panel;
    private Slider sliderVelocidad;
    private Button botonParar;
    private Button botonReset;
    private SequentialTransitionWrapper animacionWrapper; // Wrapper para manejar las animaciones
    
    public PanelCtrl(SequentialTransitionWrapper animacionWrapper) {
        // inicializo el panel de controles
        this.animacionWrapper = animacionWrapper;
        panel = new VBox(10);
        panel.setPadding(new Insets(10));

        // selector de algoritmo
        Label labelAlgoritmo = new Label("Selecciona un Algoritmo:");
        ComboBox<String> comboAlgoritmo = new ComboBox<>();
        comboAlgoritmo.getItems().addAll(
                "Ordenamiento - Burbuja"
        );
        comboAlgoritmo.getSelectionModel().selectFirst();

        // slider de velocidad
        Label labelVelocidad = new Label("Velocidad:");
        sliderVelocidad = new Slider(0.1, 2.0, 1.0); // velocidad base más rápida
        sliderVelocidad.setShowTickLabels(true);
        sliderVelocidad.setShowTickMarks(true);
        sliderVelocidad.setMajorTickUnit(0.5);
        sliderVelocidad.setMinorTickCount(4);
        sliderVelocidad.setBlockIncrement(0.1);

        // botones de control
        botonParar = new Button("parar");
        botonReset = new Button("resetear");

        // manejar eventos de botones
        botonParar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                animacionWrapper.stopAnimation();
            }
        });

        botonReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                animacionWrapper.resetAnimation();
            }
        });

        // botón de ejecutar
        Button botonEjecutar = new Button("ejecutar");
        botonEjecutar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String seleccion = comboAlgoritmo.getSelectionModel().getSelectedItem();
                ejecutarAlgoritmo(seleccion, sliderVelocidad.getValue());
            }
        });

        // añadir elementos al panel
        panel.getChildren().addAll(labelAlgoritmo, comboAlgoritmo, labelVelocidad, sliderVelocidad, botonEjecutar, botonParar, botonReset);
    }

    private void ejecutarAlgoritmo(String seleccion, double velocidad) {
        // resetear cualquier animación previa
        animacionWrapper.resetAnimation();

        // genero datos o grafos según el algoritmo seleccionado
        if (seleccion.startsWith("Ordenamiento")) {
            int[] datos = generarDatos();
                if (seleccion.contains("Burbuja")) {
                OrdiBur ordi = new OrdiBur(datos, animacionWrapper.getLienzo(), velocidad);
                animacionWrapper.setAnimacion(ordi.getAnimacion());
                ordi.ejecutar();
            }
        }
    }

    private int[] generarDatos() {
        // genero datos aleatorios
        int tam = 50;
        int[] datos = new int[tam];
        for (int i = 0; i < tam; i++) {
            datos[i] = (int) (Math.random() * 100) + 1;
        }
        return datos;
    }

    private int[][] generarGrafo() {
        // genero un grafo de ejemplo
        // nodo 0 conectado a 1 y 2
        // nodo 1 conectado a 3
        // nodo 2 conectado a 3 y 4
        // etc.
        int[][] grafo = {
                {0, 1, 2, 0, 0},
                {0, 0, 0, 3, 0},
                {0, 0, 0, 4, 5},
                {0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0}
        };
        return grafo;
    }

    public VBox getPanel() {
        return panel;
    }
}
