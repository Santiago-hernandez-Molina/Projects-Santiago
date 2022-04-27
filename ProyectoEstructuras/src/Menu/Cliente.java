package Menu;
import grafo.Edge;

import java.util.*;

public class Cliente {
    private TreeMap<String,Edge> vuelos;
    private double millas;
    private String nombre;
    private Stack<Edge> tiquete;
    public Cliente() {
    }

    public Cliente(String nombre) {
        this.vuelos = new TreeMap<String,Edge>();
        this.millas = 0;
        this.nombre = nombre;
        tiquete = new Stack<Edge>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Stack<Edge> getTiquete() {
        return tiquete;
    }

    public void setTiquete(Stack<Edge> tiquete) {
        this.tiquete = tiquete;
    }

    public TreeMap<String, Edge> getVuelos() {
        return vuelos;
    }

    public void setVuelos(TreeMap<String, Edge> vuelos) {
        this.vuelos = vuelos;
    }

    public double getMillas() {
        return millas;
    }

    public void setMillas(double millas) {
        this.millas = millas;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "vuelos=" + vuelos +
                ", millas =" + millas +
                ", nombre='" + nombre + '\'' +
                ", tiquete='" + tiquete.peek().getDestino().getNombre() + '\'' +
                '}';
    }
    public void sumarMillas(double millas){
        this.millas+=millas;
    }


}

