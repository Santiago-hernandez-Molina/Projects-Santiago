import Menu.Cliente;
import Menu.GestionVuelos;
import Menu.Trabajador;
import grafo.Node;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] Args) {
        GestionVuelos gv = new GestionVuelos();
        registroDeEmpleados(gv);
        registroCiudades(gv);
        rutasRegistradas(gv);
        clientesregistrados(gv);
        menu(gv);

    }

    public static void registroDeEmpleados(GestionVuelos gv) {
        gv.añadirTrabajador(10923380, new Trabajador("Juan", "3128744981"));
    }

    public static void registroCiudades(GestionVuelos gv) {
        gv.añadirCiudades(new Node("Cali", "Colombia", 1018, "Calido"));
        gv.añadirCiudades(new Node("Bogota", "Colombia", 2630, "Frio"));
        gv.añadirCiudades(new Node("Barranquilla", "Colombia", 18, "Calido"));
        gv.añadirCiudades(new Node("Cartagena", "Colombia", 2, "Calido"));

    }

    public static void rutasRegistradas(GestionVuelos gv) {
        gv.añadirRutas("Cali", "Bogota", 3000, 6);
        gv.añadirRutas("Cali", "Barranquilla", 5000, 18);
    }

    public static void clientesregistrados(GestionVuelos gv) {
        gv.añadirClientes(1243543, new Cliente("Juan"));
        gv.comprarTiquete(1243543, "Cali", "Barranquilla");
        gv.cobrarTiquete(1243543, "2021-07-10");
        gv.añadirClientes(3451234, new Cliente("Pepas"));
        gv.comprarTiquete(3451234, "Cali", "Bogota");
    }


    public static void menu(GestionVuelos gv) {
        Main main = new Main();
        int opt = 0;
        do {
            try {

                Scanner keyboard = new Scanner(System.in);
                System.out.println("Bienvenido a pagina de SantotoAirport");
                System.out.println("Que desea hacer: ");
                System.out.println("(0) Para salir");
                System.out.println("(1) ingresar como trabajador");
                System.out.println("(2) ingresar como cliente");

                opt = keyboard.nextInt();
                switch (opt) {
                    case 1 -> {
                        System.out.println("ingrese su id de empleado");
                        int id = keyboard.nextInt();
                        if (gv.verificarTrabajador(id)) {
                            main.menuTrabajador(gv);
                        } else {
                            System.err.println("El trabajador no existe");
                        }
                    }
                    case 2 -> {
                        main.menuCliente(gv);
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println("Seleccione la opcion que se le indica");
                opt = -1;
            }
        } while (opt != 0);
    }

    public void menuTrabajador(GestionVuelos gv) {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("(1) agregar ciudad ");
            System.out.println("(2) Para añadir una nueva ruta");
            System.out.println("(3) Para buscar la rutas de una ciudad");
            System.out.println("(4) Para actualizar el estado de una ruta");
            System.out.println("(5) Para cobrar tiquete");
            System.out.println("(6) ver ciudades que cubre la aerolinea");
            int opt = keyboard.nextInt();
            switch (opt) {
                case 1 -> {
                    datosAñadirCiudad(gv);
                }
                case 2 -> {
                    pedirDatosRuta(gv);
                }
                case 3 -> {
                    System.out.println("Ingrese el nombre de la ciudad:");
                    System.out.println(gv.getRutas().nodoPorNombre(keyboard.next()));
                }
                case 4 -> {
                    datosParaActualizarEstado(gv);
                }
                case 5 -> {
                    System.out.println("Ingrese la fecha: ");
                    String fecha = keyboard.next();
                    System.out.println("Ingrese el id del cliente");
                    int id = keyboard.nextInt();
                    gv.cobrarTiquete(id, fecha);
                }
                case 6 -> {
                    System.out.println(gv.getRutas().getNodes());
                }
            }
        } catch (InputMismatchException e) {
            System.err.println("Por favor ingrese el valor que se le pide");
        }

    }

    public void menuCliente(GestionVuelos gv) {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("(1) Para comprar tiquete");
            System.out.println("(2) Ver millas");
            System.out.println("(3) Ver historial de vuelos.");
            System.out.println("(4) Registrarse");

            int opt = keyboard.nextInt();
            switch (opt) {
                case 1 -> {
                    datosParaComprarTiquete(gv);
                }
                case 2 -> {
                    System.out.println("ingrese el id del cliente");
                    gv.mostrarMillas(keyboard.nextInt());
                }
                case 3 -> {
                    System.out.println("ingrese el id del cliente: ");
                    gv.mostrarVuelos(keyboard.nextInt());
                }
                case 4 -> {
                    pedirDatosCliente(gv);
                }

            }
        } catch (InputMismatchException e) {
            System.err.println("ingrese el valor que se le pide");
        }
    }

    public void pedirDatosRuta(GestionVuelos gv) {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Ingrese la ciudad de origen");
            String ciudadOrigen = keyboard.next();
            System.out.println("Ingrese la ciudad de destino");
            String ciudadDestino = keyboard.next();
            System.out.println("Ingrese las millas");
            double millas = keyboard.nextDouble();
            System.out.println("Ingrese el tiempo de vuelo(horas)");
            double tiempoDeVuelo = keyboard.nextDouble();
            gv.añadirRutas(ciudadOrigen, ciudadDestino, millas, tiempoDeVuelo);
        } catch (InputMismatchException e) {
            System.err.println("Ingrese el tipo de dato que se le pide");
        }

    }

    public void datosParaActualizarEstado(GestionVuelos gestionVuelos) {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Ingrese la ciudad de origen");
            String ciudadOrigen = keyboard.next();
            System.out.println("Ingrese la ciudad de destino");
            String ciudadDestino = keyboard.next();
            System.out.println("Ingrese el estado de la ruta");
            boolean estado = keyboard.nextBoolean();
            gestionVuelos.actualizarEstado(estado, ciudadOrigen, ciudadDestino);
        } catch (InputMismatchException e) {
            System.err.println("Ingrese el tipo de valor que se le pide");
        }
    }

    public void pedirDatosCliente(GestionVuelos gv) {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Ingrese la cedula del cliente: ");
            int cedula = keyboard.nextInt();
            System.out.println("Ingrese el nombre del cliente");
            String nombre = keyboard.next();
            gv.añadirClientes(cedula, new Cliente(nombre));
        } catch (InputMismatchException e) {
            System.err.println("Ingrese el tipo de valor que se le pide");
        }
    }

    public void datosParaComprarTiquete(GestionVuelos gv) {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("ingrese el id del cliente: ");
            int idCliente = keyboard.nextInt();
            System.out.println("ingrese la ciudad de origen de su viaje: ");
            String ciudadOrigen = keyboard.next();
            System.out.println("ingrese la ciudad de destino");
            String ciudadDestino = keyboard.next();
            gv.comprarTiquete(idCliente, ciudadOrigen, ciudadDestino);
        } catch (InputMismatchException e) {
            System.err.println("ingrese el tipo de valor que se le pide");
        }
    }

    public void datosAñadirCiudad(GestionVuelos gv) {
        try {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("ingrese el nombre de la ciudad: ");
            String ciudadOrigen = keyboard.next();
            System.out.println("ingrese el pais de la ciudad ");
            String pais = keyboard.next();
            System.out.println("ingrese la altura");
            int altura = keyboard.nextInt();
            System.out.println("ingrese el clima: ");
            String clima = keyboard.next();
            gv.añadirCiudades(new Node(ciudadOrigen, pais, altura, clima));
        } catch (InputMismatchException e) {
            System.err.println("ingrese el tipo de valor que se le pide");
        }
    }


}
