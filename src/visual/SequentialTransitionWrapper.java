package visual;

import javafx.animation.SequentialTransition;

public class SequentialTransitionWrapper {
    private SequentialTransition animacion;
    private AreaLienzo lienzo;

    public SequentialTransitionWrapper(AreaLienzo lienzo) {
        this.lienzo = lienzo;
    }

    public void setAnimacion(SequentialTransition animacion) {
        this.animacion = animacion;
    }

    public SequentialTransition getAnimacion() {
        return animacion;
    }

    public AreaLienzo getLienzo() {
        return lienzo;
    }

    public void stopAnimation() {
        if (animacion != null) {
            animacion.stop();
        }
    }

    public void resetAnimation() {
        stopAnimation();
        lienzo.limpiar();
    }
}
