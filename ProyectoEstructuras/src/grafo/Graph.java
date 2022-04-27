package grafo;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nodes;
    Node current;

    public Graph() {
        nodes = new ArrayList<>();;
    }

    public void addNode(Node node) {

        nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void MostrarNodes() {
        current = nodes.get(0);
        while (current != null) {
            System.out.println(current);
            if (current.getEdges() != null) {
                current = current.getEdges().get(0).getDestino();
            } else {
                current = null;
            }
        }
    }

    public Node nodoMayor() {
        Node nodeMayor = new Node();
        nodeMayor.addEdge(new Edge(null, null, 0, 0));
        for (Node node : nodes) {
            if (nodeMayor.findEdge().getMillas() < node.findEdge().getMillas()) {
                nodeMayor = node;
            }
        }
        return nodeMayor;
    }

    public Node nodoPorNombre(String nombre) {
        Node nodoBuscado = new Node();
        for (Node node : nodes) {
            if (node.getNombre().equals(nombre)) {
                nodoBuscado = node;
                break;
            }
        }
        return nodoBuscado;
    }

    public void cambiarNodo(Node nodo, Edge edge) {
        int id = nodes.indexOf(nodo);
        nodes.get(id).addEdge(edge);
    }
    public void actualizarEdge(Node ciudad, Edge ruta,boolean estado){
        int idCiudad = nodes.indexOf(ciudad);
        int idRuta = nodes.get(idCiudad).getEdges().indexOf(ruta);
        nodes.get(idCiudad).getEdges().get(idRuta).setEstado(estado);
    }

    @Override
    public String toString() {
        return "Graph [nodes=" + nodes + "]";
    }

}
