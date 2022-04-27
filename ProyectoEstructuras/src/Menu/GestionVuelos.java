package Menu;

import grafo.Edge;
import grafo.Graph;
import grafo.Node;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GestionVuelos {

    HashMap<Integer, Cliente> clientes;
    HashMap<Integer, Trabajador> trabajadores;
    Graph rutas;


    public GestionVuelos() {
        clientes = new HashMap<Integer, Cliente>();
        trabajadores = new HashMap<Integer, Trabajador>();
        rutas = new Graph();
    }

    public HashMap<Integer, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<Integer, Cliente> clientes) {
        this.clientes = clientes;
    }

    public Graph getRutas() {
        return rutas;
    }

    public void setRutas(Graph rutas) {
        this.rutas = rutas;
    }

    public void añadirClientes(Integer cedula, Cliente cliente) {
        clientes.put(cedula, cliente);
    }

    public void añadirCiudades(Node ciudad) {
        if (rutas.nodoPorNombre(ciudad.getNombre()).getNombre()==null) {
            rutas.addNode(ciudad);
        }else{
            System.err.println("La ciudad ya esta añadida");
        }
    }

    public void añadirRutas(String ciudadOrigen, String ciudadDestino, double millas,double tiempoVuelo) {
        Node nodoACambiar = rutas.nodoPorNombre(ciudadOrigen);
        Node nodoCiudadDestino = rutas.nodoPorNombre(ciudadDestino);
        if (nodoACambiar.getNombre() != null &&nodoCiudadDestino.getNombre()!=null) {
            rutas.cambiarNodo(nodoACambiar, new Edge(nodoACambiar,nodoCiudadDestino,millas,tiempoVuelo));
        } else {
            System.out.println("la ciudad no es cubierta por la aerolinea");
        }
    }

    public void actualizarEstado(boolean estado, String ciudadOrigen, String ciudadDestino) {
        Node nodoAActualizar = rutas.nodoPorNombre(ciudadOrigen);
        if (nodoAActualizar.getNombre() != null) {
            Edge rutaAActualizar = nodoAActualizar.buscarEdgePorNombre(ciudadDestino);

            if (rutaAActualizar.getDestino() != null) {
                rutas.actualizarEdge(nodoAActualizar, rutaAActualizar, estado);

            } else {
                System.err.println("no se encontro la ciudad de destino");
            }

        } else {
            System.err.println("no se encontro la ciudad de origen");
        }
    }

    public void añadirTrabajador(int id, Trabajador trabajador) {
        trabajadores.put(id, trabajador);
    }

    public boolean verificarTrabajador(int id) {
        return trabajadores.containsKey(id);
    }

    public void cobrarTiquete(int idCliente, String fechaVuelo) {
        if (clientes.containsKey(idCliente)) {
            clientes.get(idCliente).getVuelos().put(fechaVuelo, clientes.get(idCliente).getTiquete().pop());
        } else {
            System.err.println("El cliente no existe");
        }
    }

    public void comprarTiquete(int idCliente, String ciudadOrigen, String ciudadDestino) {
        try {
            Node nodoCiudadOrigen = rutas.nodoPorNombre(ciudadOrigen);
            if (nodoCiudadOrigen.getNombre() != null && clientes.containsKey(idCliente)) {
                Edge obtenerRuta = nodoCiudadOrigen.buscarEdgePorNombre(ciudadDestino);

                if (obtenerRuta.getDestino() != null) {
                    clientes.get(idCliente).getTiquete().add(obtenerRuta);
                    clientes.get(idCliente).sumarMillas(obtenerRuta.getMillas());

                } else {
                    System.err.println("no se encontro la ciudad de destino");
                }

            } else {
                System.err.println("no se encontro la ciudad de origen o el cliente");
            }
        }catch (NullPointerException e){
            System.err.println("La ruta especificada no existe");
        }
    }

    public void mostrarVuelos(int idCliente) {
        if (clientes.containsKey(idCliente)) {
            Set set = clientes.get(idCliente).getVuelos().entrySet();

            // Get an iterator
            Iterator it = set.iterator();

            // Display elements
            while (it.hasNext()) {
                Map.Entry me = (Map.Entry) it.next();
                System.out.println("fecha: " + me.getKey() + " ruta: " + me.getValue());
            }
        } else {
            System.out.println("El cliente no existe");
        }
    }

    public void mostrarMillas(int idCliente) {
        if (clientes.containsKey(idCliente)) {
            System.out.println(clientes.get(idCliente).getMillas());
        } else {
            System.out.println("El cliente no existe");
        }
    }


}
