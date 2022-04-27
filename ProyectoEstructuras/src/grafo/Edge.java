package grafo;

public class Edge {
    private Node origen;
    private Node destino;
    private double millas;
    private double tiempoVuelo;
    private boolean estado;

    public Edge() {
    }

    public Edge(Node origen, Node destino, double millas, double tiempoVuelo) {
        this.origen = origen;
        this.destino = destino;
        this.millas = millas;
        this.tiempoVuelo = tiempoVuelo;
    }

    public Node getOrigen() {
        return origen;
    }

    public void setOrigen(Node origen) {
        this.origen = origen;
    }

    public Node getDestino() {
        return destino;
    }

    public void setDestino(Node destino) {
        this.destino = destino;
    }

    public double getMillas() {
        return millas;
    }

    public void setMillas(double millas) {
        this.millas = millas;
    }

    public double getTiempoVuelo() {
        return tiempoVuelo;
    }

    public void setTiempoVuelo(double tiempoVuelo) {
        this.tiempoVuelo = tiempoVuelo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "origen=" + origen.getNombre() +
                ", destino=" + destino.getNombre() +
                ", millas=" + millas +
                ", estado=" + estado +
                '}';
    }
}
