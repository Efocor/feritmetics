package visual;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AreaLienzo {

    private Pane lienzoPane;
    private Canvas lienzo;
    private GraphicsContext gc;
    private int[] vec; // referencia al arreglo a dibujar

    public AreaLienzo() {
        // inicializo el área de dibujo
        lienzoPane = new Pane();
        lienzo = new Canvas(900, 800);
        gc = lienzo.getGraphicsContext2D();
        lienzoPane.getChildren().add(lienzo);
        limpiar();
    }

    public Pane getLienzo() {
        return lienzoPane;
    }

    public GraphicsContext getGC() {
        return gc;
    }

    /**
     * limpia el lienzo estableciendo un fondo blanco.
     */
    public void limpiar() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
    }

    /**
     * eestablece el arreglo que se va a visualizar.
     *
     * @param vec Arreglo de enteros a dibujar.
     */
    public void setVector(int[] vec) {
        this.vec = vec;
    }

    /**
     * dibuja el arreglo de enteros en el lienzo, resaltando elementos específicos.
     *
     * @param comparando     Índice del elemento que está siendo comparado.
     * @param pivote         Índice del pivote actual.
     * @param intercambiando Índice del elemento que está siendo intercambiado.
     */
    public void dibujarArray(int comparando, int pivote, int intercambiando) {
        limpiar();
        if (vec == null || vec.length == 0) return;

        double anchoBarra = lienzo.getWidth() / vec.length;
        double alturaMax = lienzo.getHeight() - 20;
        int maxValor = getMaxValue();

        for (int i = 0; i < vec.length; i++) {
            // establecemos color según el estado del elemento
            if (i == pivote) {
                gc.setFill(Color.RED); // Pivote
            } else if (i == comparando) {
                gc.setFill(Color.YELLOW); // Elemento comparando
            } else if (i == intercambiando) {
                gc.setFill(Color.ORANGE); // Elemento intercambiando
            } else {
                gc.setFill(Color.BLUE); // Elementos normales
            }

            // calcula dimensiones de la barra
            double altura = ((double) vec[i] / maxValor) * alturaMax;
            double x = i * anchoBarra;
            double y = lienzo.getHeight() - altura;

            // dibuja la barra
            gc.fillRect(x, y, anchoBarra - 2, altura);

            // dibuja el valor encima de la barra
            gc.setFill(Color.BLACK);
            gc.fillText(String.valueOf(vec[i]), x + (anchoBarra / 2) - 5, y - 5);
        }
    }

    /**
     * obtiene el valor máximo en el arreglo para escalar las barras.
     *
     * @return el valor máximo en el arreglo.
     */
    private int getMaxValue() {
        int max = vec[0];
        for (int valor : vec) {
            if (valor > max) {
                max = valor;
            }
        }
        return max;
    }
}
