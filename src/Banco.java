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
        cajas = new ArrayList<>();
        clientes = new ArrayList<>();
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
            System.out.println("6. Buscar cliente por su identificador");
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
                    buscarClientePorIdentificador();
                    break;
                case 7:
                    despacharCliente();
                    break;
                case 8:
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
        //contador++;

        System.out.println("Ingrese el identificador de la caja: ");
        identificador = leer.nextLine();

        System.out.println("Ingrese el monto inicial de la caja: ");
        montoInicial = Integer.parseInt(leer.nextLine());

        System.out.println("Ingrese el tipo de transacción que va a atender la caja: ");
        tipoTransaccion = leer.nextLine();

        Caja nuevaCaja = new Caja(identificador,montoInicial, montoFinal,tipoTransaccion,totalClientesAtendidos,clientesPorAtender,totalTiempoEspera,totalTiempoAtencion);

        // Agregar la nueva caja a la lista
        cajas.add(nuevaCaja);

        System.out.println("Caja agregada correctamente.");

//        Caja caja1 = new Caja("1224",150.000, 0,"retiro",0,0,0,0);
//        cajas.add(caja1);
//
//        Caja caja2 = new Caja("5020",100.000, 0,"consignación",0,0,0,0);
//        cajas.add(caja2);
//
//        Caja caja3 = new Caja("4433",250.000, 0,"pago de servicios",0,0,0,0);
//        cajas.add(caja3);



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
                banco =(Caja) cajas.get(i);

                identificador = banco.getIdentificador();
                montoInicial = banco.getMontoInicial();
                montoFinal = banco.getMontoFinal();
                tipoTransaccion = banco.getTipoTransaccion();
                totalClientesAtendidos = banco.getTotalClientesAtendidos();
                clientesPorAtender = banco.getClientesPorAtender();
                totalTiempoEspera = banco.getTotalTiempoEspera();
                totalTiempoAtencion = banco.getTotalTiempoAtencion();

                writer.println(identificador);
                writer.println(montoInicial);
                writer.println(montoFinal);
                writer.println(tipoTransaccion);
                writer.println(totalClientesAtendidos);
                writer.println(clientesPorAtender);
                writer.println(totalTiempoEspera);
                writer.println(totalTiempoAtencion);

            }

            writer.close();
            System.out.println("Se agregó y guardó correctamente caja");
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
        int totalTiempoEspera;
        int totalTiempoAtencion;

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
                totalTiempoEspera = Integer.parseInt(bufer.readLine());
                totalTiempoAtencion = Integer.parseInt(bufer.readLine());

                banco = new Caja(identificador, montoInicial, montoFinal, tipoTransaccion, totalClientesAtendidos, clientesPorAtender, totalTiempoEspera, totalTiempoAtencion);
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
            System.out.println("Tiempo total de espera " + call.getTotalTiempoEspera());
            System.out.println("Tiempo total de atención: " + call.getTotalTiempoAtencion() + " segundos");

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

    }

    public void agregarCliente()
    {

    }

    public void buscarClientePorIdentificador()
    {

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
            writer.println("R E P O R T E  B A N C O -- P L A T A  O  P L O M O --");
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