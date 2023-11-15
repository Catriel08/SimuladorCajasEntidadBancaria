import java.util.*;
import java.io.*;

public class Banco {
    private  ArrayList cajas;
    private ArrayList clientes;

    Scanner leer = new Scanner(System.in);
    File cargarCajas = new File("C:\\Users\\Brayan\\IdeaProjects\\SimuladorCajasEntidadBancaria\\Txt_Banco\\Cajas.txt");
    File cargarClientes = new File("C:\\Users\\Brayan\\IdeaProjects\\SimuladorCajasEntidadBancaria\\Txt_Banco\\Clientes.txt");
    File reporte = new File("C:\\Users\\Brayan\\IdeaProjects\\SimuladorCajasEntidadBancaria\\Txt_Banco\\ReporteCajasBanco.txt");

    public Banco() {
        this.cajas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        cargarCajasBancariasTxt();
        cargarClientesTxt();

        while (true)
        {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Imprimir cajas");
            System.out.println("2. Imprimir clientes");
            System.out.println("3. Agregar caja al banco");
            System.out.println("4. Eliminar caja por su identificador");
            System.out.println("5. Agregar cliente");
            System.out.println("6. Buscar cliente por su nombre");
            System.out.println("7. Despachar cliente");
            System.out.println("8. Imprimir reporte");
            System.out.println("9. Salir");
            System.out.println("\nIngrese una opción: ");

            switch (Integer.parseInt(leer.nextLine()))
            {
                case 1:
                    imprimirCajasBancarias();
                    break;
                case 2:
                    imprimirClientes();
                    break;
                case 3:
                    agregarCaja();
                    guardarCajasTxt();
                    break;
                case 4:
                    eliminarCajaPorIdentificador();
                    break;
                case 5:
                    agregarCliente();
                    break;
                case 6:
                    buscarClientePorNombre();
                    break;
                case 7:
                    despacharCliente();
                    break;
                case 8:
                    guardarCajasTxt();
                    imprimirReporteTxt();
                    break;
                case 9:
                    System.exit(0);
                    leer.close();
                    break;

            }
        }
    }

    public void agregarCaja()
    {

        String identificador;
        double montoInicial;
        double montoFinal;
        String tipoTransaccion;
        int totalClientesAtendidos;
        int clientesPorAtender;
        int totalTiempoEspera;
        int totalTiempoAtencion;

        System.out.println("Ingrese el identificador de la caja: ");
        identificador = leer.nextLine();

        System.out.println("Ingrese el monto inicial de la caja: ");
        montoInicial = Integer.parseInt(leer.nextLine());


        System.out.println("Ingrese el tipo de transacción que va a atender la caja: ");
        tipoTransaccion = leer.nextLine();


        Caja nuevaCaja = new Caja(identificador,montoInicial,montoFinal=montoInicial,tipoTransaccion,0,0);
        cajas.add(nuevaCaja);

        System.out.println("\nCaja agregada correctamente.");

    }

    public void cargarClientesTxt()
    {
        int cont;
        String identificador;
        String tipoTransaccionCliente;


        Cliente banco;
        String linea = " ";

        try {
            FileReader reader = new FileReader(cargarClientes);
            BufferedReader bufer = new BufferedReader(reader);

            linea = bufer.readLine();
            cont = Integer.parseInt(linea);

            for (int i = 0; i < cont; i++) {
                identificador = bufer.readLine();

                tipoTransaccionCliente = bufer.readLine();

                banco = new Cliente(identificador, tipoTransaccionCliente);
                clientes.add(banco);
            }

            bufer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado. Asegúrate de que el archivo esté en la ubicación correcta.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer información del archivo.");
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir datos numéricos. Verifica el formato del archivo.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error desconocido.");
        }
    }

    public void guardarCajasTxt()
    {
        int totalcajas;

        int cont;
        String identificador;
        double montoInicial;
        double montoFinal;
        String tipoTransaccion;
        int totalClientesAtendidos;
        int clientesPorAtender;
        int totalTiempoEspera;
        int totalTiempoAtencion;

        Caja banco;
        try
        {
            PrintWriter writer = new PrintWriter(cargarCajas);
            totalcajas = cajas.size();
            writer.println(totalcajas);
            for(int i = 0; i< cajas.size(); i++)
            {
                banco = (Caja) cajas.get(i);

                identificador = banco.getIdentificador();
                montoInicial = banco.getMontoInicial();
                montoFinal = banco.getMontoFinal();
                tipoTransaccion = banco.getTipoTransaccion();
                totalClientesAtendidos = banco.getTotalClientesAtendidos();
                clientesPorAtender = banco.getClientesPorAtender();

                writer.println(identificador);
                writer.println(montoInicial);
                writer.println(montoFinal);
                writer.println(tipoTransaccion);
                writer.println(totalClientesAtendidos);
                writer.println(clientesPorAtender);

            }

            writer.close();
            System.out.println("\nSe guardó correctamente el cambio");
        }
        catch(Exception e)
        {
            System.out.println("error al escribir en el archivo");
        }
    }

    public void cargarCajasBancariasTxt()
    {
        int cont;
        String identificador;
        double montoInicial;
        double montoFinal;
        String tipoTransaccion;
        int totalClientesAtendidos;
        int clientesPorAtender;

        Caja banco;
        String linea = " ";

        try {
            FileReader reader = new FileReader(cargarCajas);
            BufferedReader bufer = new BufferedReader(reader);

            linea = bufer.readLine();
            cont = Integer.parseInt(linea);

            for (int i = 0; i < cont; i++) {

                identificador = bufer.readLine();
                montoInicial = Double.parseDouble(bufer.readLine());
                montoFinal = Double.parseDouble(bufer.readLine());
                tipoTransaccion = bufer.readLine();
                totalClientesAtendidos = Integer.parseInt(bufer.readLine());
                clientesPorAtender = Integer.parseInt(bufer.readLine());

                banco = new Caja(identificador, montoInicial, montoFinal, tipoTransaccion, totalClientesAtendidos, clientesPorAtender);
                cajas.add(banco);
            }

            bufer.close();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Archivo no encontrado. Asegúrate de que el archivo esté en la ubicación correcta.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer información del archivo.");
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir datos numéricos. Verifica el formato del archivo.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error desconocido.");
        }
    }

    public void imprimirCajasBancarias()
    {
        Caja call;

        for (int i = 0; i < cajas.size(); i++) {
            call = (Caja) cajas.get(i);
            System.out.println("\nIdentificador: " + call.getIdentificador());
            System.out.println("Monto inicial: " + call.getMontoInicial());
            System.out.println("Monto final: " + call.getMontoFinal());
            System.out.println("Tipo de transacción: " + call.getTipoTransaccion());
            System.out.println("Total clientes atendidos: " + call.getTotalClientesAtendidos());
            System.out.println("Clientes por atender: " + call.getClientesPorAtender());

        }
    }

    public void imprimirClientes()
    {
        Cliente call;

        for (int i = 0; i < clientes.size(); i++){
            call = (Cliente) clientes.get(i);
            System.out.println("\nNombre: " + call.getNombre());
            System.out.println("Transacción cliente: " + call.getTipoTransaccionCliente());
        }
    }

    public void eliminarCajaPorIdentificador()
    {
        String identificador;
        Caja caja;
        String opcion;

        Caja banco;
        boolean cajaEncontrada = false;

        // Le pedimos al usuario el identificador para buscar la caja
        System.out.println("Ingrese el identificador de la caja que desea eliminar:");
        identificador = leer.nextLine();

        // Iteramos todas las cajas y encontramos la caja que el usuario está buscando con el "identificador"
        for (int i = 0; i < cajas.size(); i++) {
            banco = (Caja) cajas.get(i);

            // Utilizamos el objeto "banco" en lugar de la lista "cajas" en el if
            if (banco.getIdentificador().equals(identificador)) {
                System.out.println("¿Está seguro que desea eliminar la caja con el identificador " + identificador + "? (Y/N)");
                opcion = leer.nextLine();

                // Si la respuesta es "Y", entonces eliminará la caja
                if (opcion.equalsIgnoreCase("Y")) {
                    cajas.remove(i);
                    guardarCajasTxt();
                    System.out.println("\nLa caja con el identificador " + identificador + " ha sido eliminada correctamente");

                } else if (opcion.equalsIgnoreCase("N")) {
                    System.out.println("\nOperación cancelada, volviendo al menú principal...");
                } else {
                    System.out.println("\nOpción no válida. Operación cancelada, volviendo al menú principal...");
                }
                // Se encontró la caja, establecer la variable a true
                cajaEncontrada = true;
                // Terminamos el bucle después de encontrar y procesar la caja
                break;
            }
        }

        // Mensaje adicional si la caja no fue encontrada
        if (!cajaEncontrada) {
            System.out.println("\nLa caja con el identificador " + identificador + " no existe en el banco.");
        }

    }

    public void agregarCliente()
    {
        Caja banco;
        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = leer.nextLine();

        System.out.println("Ingrese el tipo de transacción que desea realizar (Retiro/Consignación/Pago de servicios):");
        String tipoTransaccionCliente = leer.nextLine();

        Cliente nuevoCliente = new Cliente(nombreCliente, tipoTransaccionCliente);

        // Encontrar la caja con el menor número de clientes en espera para el tipo de transacción del nuevo cliente
        Caja cajaSeleccionada = null;
        int minClientesEnEspera = Integer.MAX_VALUE;

        for (int i = 0; i < cajas.size(); i++) {
            banco = (Caja)  cajas.get(i);

            // Verificar si la caja atiende el tipo de transacción del nuevo cliente
            if (banco.getTipoTransaccion().equalsIgnoreCase(tipoTransaccionCliente)) {
                int clientesEnEspera = banco.getClientesPorAtender();

                // Verificar si la caja tiene menos clientes en espera que la mínima actual
                if (clientesEnEspera < minClientesEnEspera) {
                    minClientesEnEspera = clientesEnEspera;
                    cajaSeleccionada = banco;
                }
            }
        }

        // Asignar al nuevo cliente a la caja seleccionada
        if (cajaSeleccionada != null) {
            cajaSeleccionada.agregarClienteEnEspera(nuevoCliente);
            cajaSeleccionada.incrementarClientesPorAtender();  // Incrementar la cuenta de clientes por atender en la caja

            // Procesar la transacción según el tipo
            switch (tipoTransaccionCliente.toLowerCase()) {
                case "retiro":
                    System.out.println("Ingrese la cantidad de dinero a retirar:");
                    double cantidadRetirar = Double.parseDouble(leer.nextLine());
                    if (cantidadRetirar <= cajaSeleccionada.getMontoInicial()) {
                        System.out.println("Cliente " + nombreCliente + " asignado a la caja " + cajaSeleccionada.getIdentificador());
                        //cajaSeleccionada.setMontoInicial(cajaSeleccionada.getMontoInicial() - cantidadRetirar);
                        cajaSeleccionada.setMontoFinal(cajaSeleccionada.getMontoFinal() - cantidadRetirar);
                        System.out.println("Retiro exitoso. Nuevo monto en la caja: " + cajaSeleccionada.getMontoFinal());
                    } else {
                        System.out.println("Cliente " + nombreCliente + " asignado a la caja " + cajaSeleccionada.getIdentificador());
                        System.out.println("No hay suficiente dinero en la caja para el retiro solicitado.");
                    }
                    break;

                case "consignación":
                    System.out.println("Ingrese la cantidad a consignar:");
                    double cantidadConsignar = Double.parseDouble(leer.nextLine());
                    //cajaSeleccionada.setMontoInicial(cajaSeleccionada.getMontoInicial() + cantidadConsignar);
                    cajaSeleccionada.setMontoFinal(cajaSeleccionada.getMontoFinal() + cantidadConsignar);
                    System.out.println("Cliente " + nombreCliente + " asignado a la caja " + cajaSeleccionada.getIdentificador());
                    System.out.println("Consignación exitosa. Nuevo monto en la caja: " + cajaSeleccionada.getMontoFinal());
                    break;

                case "pago de servicios":
                    System.out.println("Ingrese la cantidad a pagar:");
                    double cantidadPagar = Double.parseDouble(leer.nextLine());
                    if (cantidadPagar <= cajaSeleccionada.getMontoInicial()) {
                        System.out.println("Cliente " + nombreCliente + " asignado a la caja " + cajaSeleccionada.getIdentificador());
                        //cajaSeleccionada.setMontoInicial(cajaSeleccionada.getMontoInicial() + cantidadPagar);
                        cajaSeleccionada.setMontoFinal(cajaSeleccionada.getMontoFinal() + cantidadPagar);
                        System.out.println("Pago de servicios exitoso. Nuevo monto en la caja: " + cajaSeleccionada.getMontoFinal());
                    } else {
                        System.out.println("Cliente " + nombreCliente + " asignado a la caja " + cajaSeleccionada.getIdentificador());
                        System.out.println("No hay suficiente dinero en la caja para el pago de servicios solicitado.");
                    }
                    break;

                default:
                    System.out.println("Tipo de transacción no reconocido.");
            }

            System.out.println("Cliente " + nombreCliente + " asignado a la caja " + cajaSeleccionada.getIdentificador());
        } else {
            System.out.println("No hay cajas disponibles para el tipo de transacción del cliente " + nombreCliente);
        }
    }


    public void buscarClientePorNombre()
    {
        String identificadorCliente;
        Cliente cliente = null;
        Cliente banco;
        boolean clienteEncontrado = false;

        // Le pedimos al usuario el identificador para buscar el cliente
        System.out.println("Ingrese el identificador del cliente que desea buscar:");
        identificadorCliente = leer.nextLine();

        // Iteramos todas los clientes y buscamos el cliente por identificador
        for (int i = 0; i < clientes.size(); i++) {
            banco = (Cliente) clientes.get(i);

            // Utilizamos el objeto "banco" en lugar de la lista "clientes" en el if
            if (banco.getNombre().equalsIgnoreCase(identificadorCliente)) {
                System.out.println("\nCliente encontrado:");
                System.out.println("Identificador: " + banco.getNombre());
                System.out.println("Tipo de Transacción: " + banco.getTipoTransaccionCliente());
                clienteEncontrado = true;
                break;
            }
        }

        // Mensaje adicional si el cliente no fue encontrado
        if (!clienteEncontrado) {
            System.out.println("Cliente con el identificador " + identificadorCliente + " no encontrado en el banco.");
        }
    }

    public void despacharCliente()
    {

    }

    public void imprimirReporteTxt()
    {
        int cont;
        String identificador;
        double montoInicial;
        double montoFinal;
        String tipoTransaccion;
        int totalClientesAtendidos;
        int clientesPorAtender;
        int totalTiempoEspera;
        int totalTiempoAtencion;

        Caja banco;
        try
        {
            PrintWriter writer = new PrintWriter(reporte);

            writer.println("==========================================================");
            writer.println("R E P O R T E  B A N C O ==== P L A T A  O  P L O M O ====");
            writer.println("==========================================================");

            for(int i = 0; i< cajas.size(); i++)
            {
                banco =(Caja) cajas.get(i);

                identificador = banco.getIdentificador();

                tipoTransaccion = banco.getTipoTransaccion();

                montoInicial = banco.getMontoInicial();

                montoFinal = banco.getMontoFinal();

                totalClientesAtendidos = banco.getTotalClientesAtendidos();

                clientesPorAtender = banco.getClientesPorAtender();


                writer.println("Caja: " + identificador);
                writer.println("Transacciones atendidas: " + tipoTransaccion);
                writer.println("Dinero inicial: " + montoInicial);
                writer.println("Dinero final: " + montoFinal);
                writer.println("Número de clientes atendidos: " + totalClientesAtendidos);
                writer.println("Clientes por atender: " + clientesPorAtender);
                writer.println("==========================================================");
            }
            writer.println("            F I N  D E L  R E P O R T E");
            writer.println("==========================================================");

            writer.close();

            System.out.println("\nSe hizo el reporte correctamente");
        }
        catch(Exception e)
        {
            System.out.println("error al escribir en el archivo");
        }
    }


    public static void main(String[] args) {
        Banco banco = new Banco();
    }
}