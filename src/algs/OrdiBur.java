package algs;

import javafx.animation.*;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import visual.AreaLienzo;
import javafx.animation.SequentialTransition;

public class OrdiBur {

    private int[] datos;
    private AreaLienzo lienzo;
    private double vel;
    private SequentialTransition animacion;

    public OrdiBur(int[] datos, AreaLienzo lienzo, double vel) {
        // inicializo variables
        this.datos = datos;
        this.lienzo = lienzo;
        this.vel = vel;
        this.animacion = new SequentialTransition();
    }

    public void ejecutar() {
        // inicio el algoritmo con animación
        bubbleSort();
        animacion.play();
    }

    public SequentialTransition getAnimacion() {
        return animacion;
    }

    private void bubbleSort() {
        int n = datos.length;
        boolean intercambiado;

        for (int i = 0; i < n - 1; i++) {
            intercambiado = false;

            for (int j = 0; j < n - i - 1; j++) {
                final int currentJ = j;
                final int currentJPlus1 = j + 1;

                PauseTransition pausaComparacion = new PauseTransition(Duration.seconds(0.05 / vel));
                pausaComparacion.setOnFinished(e -> {
                    // Resaltamos los elementos comparados
                    dibujarArray(currentJ, currentJPlus1, false);

                    if (datos[currentJ] > datos[currentJPlus1]) {
                        intercambiar(currentJ, currentJPlus1);
                        dibujarArray(currentJ, currentJPlus1, true);
                    }
                });
                animacion.getChildren().add(pausaComparacion);
            }

            // Optimización: si no hubo intercambios, el array ya está ordenado
            PauseTransition pausaIntercambio = new PauseTransition(Duration.seconds(0.05 / vel));
            pausaIntercambio.setOnFinished(e -> {
                // No se requiere acción adicional aquí, pero mantiene la sincronización
            });
            animacion.getChildren().add(pausaIntercambio);
        }
    }

    private void intercambiar(int index1, int index2) {
        int temp = datos[index1];
        datos[index1] = datos[index2];
        datos[index2] = temp;
    }

    private void dibujarArray(int idx1, int idx2, boolean intercambio) {
        // Dibujo las barras en el lienzo
        lienzo.limpiar();
        double anchoBarra = lienzo.getLienzo().getWidth() / datos.length;
        double alturaMax = lienzo.getLienzo().getHeight();
        int maxValor = obtenerMaximo();

        for (int i = 0; i < datos.length; i++) {
            if (i == idx1 || i == idx2) {
                lienzo.getGC().setFill(Color.YELLOW); // elementos comparados
            } else {
                lienzo.getGC().setFill(Color.BLUE);
            }
            double altura = ((double) datos[i] / maxValor) * alturaMax;
            lienzo.getGC().fillRect(i * anchoBarra, alturaMax - altura, anchoBarra - 2, altura);

            if (intercambio && (i == idx1 || i == idx2)) {
                // Resaltamos el intercambio con color rojo temporalmente
                lienzo.getGC().setFill(Color.RED);
                lienzo.getGC().fillRect(i * anchoBarra, alturaMax - altura, anchoBarra - 2, altura);
            }
        }
    }

    private int obtenerMaximo() {
        // obtengo el valor máximo del array
        int max = datos[0];
        for (int val : datos) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }
}
