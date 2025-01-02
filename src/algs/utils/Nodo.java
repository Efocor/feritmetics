package algs.utils;

// clase nodo para representar cada nodo en un grafo
public class Nodo {
    private int id; // identificador del nodo
    private String nombre; // nombre del nodo

    public Nodo(int id, String nombre) {
        // constructor del nodo
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        // obtengo el id del nodo
        return id;
    }

    public String getNombre() {
        // obtengo el nombre del nodo
        return nombre;
    }

    public void setNombre(String nombre) {
        // actualizo el nombre del nodo
        this.nombre = nombre;
    }
}
