import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.io.*;

public class Banco {
    private  ArrayList cajas;
    private ArrayList clientes;
    NumberFormat nf = NumberFormat.getCurrencyInstance();
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
            System.out.println("8. Salir y guardar reporte");
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
                    guardarClientesTxt();
                    break;
                case 6:
                    buscarClientePorNombre();
                    break;
                case 7:
                    despacharCliente();
                    break;
                case 8:
                    guardarClientesTxt();
                    guardarCajasTxt();
                    imprimirReporteTxt();
                    System.out.println("\nLa transaccion fue exitosa");
                    System.out.println("Vuelva pronto");
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
        double montoActual;
        double montoFinal;
        String tipoTransaccion;
        int totalClientesAtendidos;
        int clientesPorAtender;
        int totalTiempoEspera;
        int totalTiempoAtencion;

        System.out.println("Ingrese el identificador de la caja: ");
        identificador = leer.nextLine();

        System.out.println("Ingrese el monto inicial de la caja: ");
        montoInicial = Double.parseDouble(leer.nextLine());


        System.out.println("Ingrese el tipo de transacción que va a atender la caja: ");
        tipoTransaccion = leer.nextLine();


        Caja nuevaCaja = new Caja(identificador,montoInicial,montoActual=montoInicial, montoFinal=montoInicial,tipoTransaccion,0,0);
        cajas.add(nuevaCaja);

        System.out.println("\nCaja agregada correctamente.");

    }

    public void cargarClientesTxt()
    {
        int cont;
        String identificador;
        String nombre;
        String tipoTransaccionCliente;
        double saldoCuentaCliente;


        Cliente banco;
        String linea = " ";

        try {
            FileReader reader = new FileReader(cargarClientes);
            BufferedReader bufer = new BufferedReader(reader);

            linea = bufer.readLine();
            cont = Integer.parseInt(linea);

            for (int i = 0; i < cont; i++) {

                identificador = bufer.readLine();

                nombre = bufer.readLine();

                tipoTransaccionCliente = bufer.readLine();

                saldoCuentaCliente = Double.parseDouble(bufer.readLine());

                banco = new Cliente(identificador,nombre, tipoTransaccionCliente,saldoCuentaCliente);
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
        double montoActual;
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
                montoActual = banco.getMontoActual();
                montoFinal = banco.getMontoFinal();
                tipoTransaccion = banco.getTipoTransaccion();
                totalClientesAtendidos = banco.getTotalClientesAtendidos();
                clientesPorAtender = banco.getClientesPorAtender();

                writer.println(identificador);
                writer.println(montoInicial);
                writer.println(montoActual);
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

    public void guardarClientesTxt()
    {
        int totalClientes;

        String identificadorCliente;
        String nombre;
        String tipoTransaccionCliente;
        double saldoCuentaCliente;

        Cliente banco;
        try
        {
            PrintWriter writer = new PrintWriter(cargarClientes);
            totalClientes = clientes.size();
            writer.println(totalClientes);
            for(int i = 0; i< clientes.size(); i++)
            {
                banco = (Cliente) clientes.get(i);

                identificadorCliente = banco.getIdentificadorCliente();
                nombre = banco.getNombre();
                tipoTransaccionCliente = banco.getTipoTransaccionCliente();
                saldoCuentaCliente = banco.getSaldoCuentaCliente();

                writer.println(identificadorCliente);
                writer.println(nombre);
                writer.println(tipoTransaccionCliente);
                writer.println(saldoCuentaCliente);

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
        double montoActual;
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
                montoActual = Double.parseDouble(bufer.readLine());
                montoFinal = Double.parseDouble(bufer.readLine());
                tipoTransaccion = bufer.readLine();
                totalClientesAtendidos = Integer.parseInt(bufer.readLine());
                clientesPorAtender = Integer.parseInt(bufer.readLine());

                banco = new Caja(identificador, montoInicial, montoActual, montoFinal, tipoTransaccion, totalClientesAtendidos, clientesPorAtender);
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
            System.out.println("Monto inicial: " + nf.format(call.getMontoInicial()));
            System.out.println("Monto Actual: " + nf.format(call.getMontoActual()));
            System.out.println("Monto final: " + nf.format(call.getMontoActual()));
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
            System.out.println("\nIdentificador: " + call.getIdentificadorCliente());
            System.out.println("Nombre: " + call.getNombre());
            System.out.println("Transacción cliente: " + call.getTipoTransaccionCliente());
            System.out.println("Saldo en cuenta del cliente: " + nf.format(call.getSaldoCuentaCliente()));
        }
    }

    public void eliminarCajaPorIdentificador()
    {
        String identificador;
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
                // Verificar si la caja tiene 0 clientes por atender
                if (banco.getClientesPorAtender() == 0) {
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
                } else {
                    System.out.println("\nNo se puede eliminar la caja con el identificador " + identificador + " porque tiene clientes por atender.");
                    cajaEncontrada = true;  // Evitar mensaje adicional al final
                    break;
                }
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

        System.out.println("Ingrese el identificador del cliente: ");
        String identificadorCliente = leer.nextLine();

        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = leer.nextLine();

        System.out.println("Ingrese el tipo de transacción que desea realizar (Retiro/Consignacion/Pago de servicios):");
        String tipoTransaccionCliente = leer.nextLine();

        System.out.println("Ingrese el saldo en la cuenta del cliente: ");
        double saldoCuentaCliente = Double.parseDouble(leer.nextLine());

        Cliente nuevoCliente = new Cliente(identificadorCliente,nombreCliente,tipoTransaccionCliente,saldoCuentaCliente);

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

            cajaSeleccionada.incrementarClientesPorAtender();  // Incrementar la cuenta de clientes por atender en la caja

            // Procesar la transacción según el tipo
            switch (tipoTransaccionCliente.toLowerCase()) {
                case "retiro":
                    System.out.println("Ingrese la cantidad de dinero a retirar:");
                    double cantidadRetirar = Double.parseDouble(leer.nextLine());
                    if (cantidadRetirar <= cajaSeleccionada.getMontoInicial() && nuevoCliente.getSaldoCuentaCliente() >= cantidadRetirar) {
                        nuevoCliente.setSaldoCuentaCliente(nuevoCliente.getSaldoCuentaCliente() - cantidadRetirar);
                        cajaSeleccionada.setMontoActual(cajaSeleccionada.getMontoActual() - cantidadRetirar);
                        cajaSeleccionada.setMontoFinal(cajaSeleccionada.getMontoFinal() - cantidadRetirar);
                        System.out.println("\nRetiro exitoso. Nuevo monto en la caja: " + cajaSeleccionada.getMontoFinal());
                    } else {
                        System.out.println("No tiene suficiente dinero en la cuenta para retirar o no hay suficiente dinero en la caja para el retiro solicitado");
                        System.out.println("Cliente " + nombreCliente + " fue asignado a la caja " + cajaSeleccionada.getIdentificador());
                        //System.out.println("No hay suficiente dinero en la caja para el retiro solicitado.");
                    }
                    break;

                case "consignacion":
                    System.out.println("Ingrese la cantidad a consignar:");
                    double cantidadConsignar = Double.parseDouble(leer.nextLine());
                    if (nuevoCliente.getSaldoCuentaCliente() >= cantidadConsignar) {
                        nuevoCliente.setSaldoCuentaCliente(nuevoCliente.getSaldoCuentaCliente() - cantidadConsignar);
                        cajaSeleccionada.setMontoActual(cajaSeleccionada.getMontoActual() + cantidadConsignar);
                        cajaSeleccionada.setMontoFinal(cajaSeleccionada.getMontoFinal() + cantidadConsignar);
                        System.out.println("\nCliente " + nombreCliente + " fue asignado a la caja " + cajaSeleccionada.getIdentificador());
                        System.out.println("Consignación exitosa. Nuevo monto en la caja: " + cajaSeleccionada.getMontoFinal());
                    }else {
                        System.out.println("No tiene suficiente dinero en la cuenta para consignar");
                    }
                    break;

                case "pago de servicios":
                    System.out.println("Ingrese la cantidad a pagar:");
                    double cantidadPagar = Double.parseDouble(leer.nextLine());
                    if (nuevoCliente.getSaldoCuentaCliente() >= cantidadPagar) {
                        System.out.println("Cliente " + nombreCliente + " fue asignado a la caja " + cajaSeleccionada.getIdentificador());
                        nuevoCliente.setSaldoCuentaCliente(nuevoCliente.getSaldoCuentaCliente() - cantidadPagar);
                        cajaSeleccionada.setMontoActual(cajaSeleccionada.getMontoActual() + cantidadPagar);
                        cajaSeleccionada.setMontoFinal(cajaSeleccionada.getMontoFinal() + cantidadPagar);
                        System.out.println("\nPago de servicios exitoso. Nuevo monto en la caja: " + cajaSeleccionada.getMontoFinal());
                    }else {
                        System.out.println("No tiene suficiente dinero en la cuenta para pagar los servicios");
                    }
                    break;

                default:
                    System.out.println("Tipo de transacción no reconocido.");
            }

            System.out.println("Cliente " + nombreCliente + " fue asignado a la caja " + cajaSeleccionada.getIdentificador());
            clientes.add(nuevoCliente);
            System.out.println("Cliente " + nombreCliente + " fue agregado a la lista de clientes.");
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
        // Preguntar por el identificador de la caja
        Caja banco;
        System.out.println("Ingrese el identificador de la caja para despachar al cliente:");
        String identificadorCaja = leer.nextLine();

        // Buscar la caja con el identificador proporcionado
        Caja cajaSeleccionada = null;

        for (int i = 0; i < cajas.size(); i++) {
            banco = (Caja) cajas.get(i);

            if (banco.getIdentificador().equalsIgnoreCase(identificadorCaja)) {
                cajaSeleccionada = banco;
                break;
            }
        }

        // Verificar si se encontró la caja
        if (cajaSeleccionada != null) {
            // Verificar si hay clientes por atender en la caja
            if (cajaSeleccionada.getClientesPorAtender() > 0) {
                // Despachar al cliente
                cajaSeleccionada.incrementarTotalClientesAtendidos();
                cajaSeleccionada.decrementarClientesPorAtender();

                // Imprimir mensaje
                System.out.println("Cliente despachado de la caja " + cajaSeleccionada.getIdentificador());
                System.out.println("Total de clientes atendidos en la caja: " + cajaSeleccionada.getTotalClientesAtendidos());
                System.out.println("Clientes por atender en la caja: " + cajaSeleccionada.getClientesPorAtender());
            } else {
                System.out.println("La caja no tiene clientes por atender en este momento.");
            }
        } else {
            System.out.println("No se encontró una caja con el identificador proporcionado.");
        }
    }

    public void imprimirReporteTxt()
    {
        int cont;
        String identificador;
        double montoInicial;
        double montoActual;
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

            writer.println("===========================================================");
            writer.println("R E P O R T E  B A N C O ==== S E R E N E T Y  B A N K ====");
            writer.println("===========================================================");

            for(int i = 0; i< cajas.size(); i++)
            {
                banco =(Caja) cajas.get(i);

                identificador = banco.getIdentificador();

                tipoTransaccion = banco.getTipoTransaccion();

                montoInicial = banco.getMontoInicial();

                montoActual = banco.getMontoActual();

                montoFinal = banco.getMontoFinal();

                totalClientesAtendidos = banco.getTotalClientesAtendidos();

                clientesPorAtender = banco.getClientesPorAtender();


                writer.println("Caja: " + identificador);
                writer.println("Transacciones atendidas: " + tipoTransaccion);
                writer.println("Dinero inicial: " + nf.format(montoInicial));
                writer.println("Dinero actual: " + nf.format(montoActual));
                writer.println("Dinero final: " + nf.format(montoFinal));
                writer.println("Número de clientes atendidos: " + totalClientesAtendidos);
                writer.println("Clientes por atender: " + clientesPorAtender);
                writer.println("===========================================================");
            }
            writer.println("            F I N  D E L  R E P O R T E");
            writer.println("===========================================================");

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