package grafo;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String nombre;
    private String pais;
    private double altura;
    private String clima;

    private List<Edge> edges;

    public Node(String nombre, String pais, double altura, String clima) {
        this.nombre = nombre;
        this.pais = pais;
        this.altura = altura;
        this.clima = clima;
    }

    public Node() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        if (edges == null) {
            edges = new ArrayList<>();
        }
        edges.add(edge);
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    @Override
    public String toString() {
        return "\n \tNode [nombre=" + nombre + ", edges=" + edges + "]";
    }

    public Edge  findEdge(){
        Edge edgeMayor=new Edge(null,null,0,0);
        if (edges!=null) {
            for (Edge edge : edges) {
                if (edgeMayor.getMillas() < edge.getMillas()) {
                    edgeMayor = edge;
                }
            }
        }
        return edgeMayor;
    }
    public Edge buscarEdgePorNombre(String name){
        Edge edgeBuscado = new Edge();
        for (Edge edge :edges) {
            if (edge.getDestino().getNombre().equals(name)) {
                edgeBuscado = edge;
                break;
            }
        }
        return edgeBuscado;
    }

}
