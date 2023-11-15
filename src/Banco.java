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
            System.out.println("1. Agregar caja al banco");
            System.out.println("2. Eliminar caja por su identificador");
            System.out.println("3. Agregar cliente");
            System.out.println("4. Buscar cliente por su identificador");
            System.out.println("5. Despachar cliente");
            System.out.println("6. Imprimir reporte");
            System.out.println("7. Salir");
            System.out.println("\nIngrese una opción: ");

            switch (Integer.parseInt(leer.nextLine()))
            {
                case 1:
                    //agregarCaja();
                    //imprimirCajasBancarias();
                    imprimirClientes();
                    break;
                case 2:
                    eliminarCajaPorIdentificador();
                    break;
                case 3:
                    agregarCliente();
                    break;
                case 4:
                    buscarClientePorIdentificador();
                    break;
                case 5:
                    despacharCliente();
                    break;
                case 6:
                    imprimirReporteTxt();
                    break;
                case 7:
                    System.exit(0);
                    leer.close();
                    break;

            }
        }
    }

//    public void agregarCaja()
//    {
//        Caja caja1 = new Caja("1224",150.000, 0,"retiro");
//        cajas.add(caja1);
//
//        Caja caja2 = new Caja("5020",100.000, 0,"consignación");
//        cajas.add(caja2);
//
//        Caja caja3 = new Caja("4433",250.000, 0,"pago de servicios");
//        cajas.add(caja3);
//
//        for (int i=0; i<cajas.size();i++)
//        {
//            System.out.println(cajas.toString());
//        }
//
//    }

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

    public void cargarCajasBancariasTxt()
    {
        int cont;
        String identificador;
        double montoInicial;
        double montoFinal;
        String tipoTransaccion;
        int totalClientesAtendidos;
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
                totalTiempoEspera = Integer.parseInt(bufer.readLine());
                totalTiempoAtencion = Integer.parseInt(bufer.readLine());

                banco = new Caja(identificador, montoInicial, montoFinal, tipoTransaccion, totalClientesAtendidos, totalTiempoEspera, totalTiempoAtencion);
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

    }



    public static void main(String[] args) {
        Banco banco = new Banco();
    }
}