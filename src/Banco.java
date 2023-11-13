import java.util.ArrayList;
import java.util.Iterator;

public class Banco {
    private  ArrayList cajas;

    public Banco() {
        this.cajas = new ArrayList<>();
    }

    public void agregarCaja(String identificador, double montoInicial, double montoActual, String tipoTransaccion) {
        Caja caja = new Caja(identificador, montoInicial, montoActual, tipoTransaccion);
        cajas.add(caja);
    }

    public void atenderCliente(Cliente cliente)
    {
        System.out.println("Atendiendo al cliente " + cliente.getIdentificador() +
                " en la caja " + this.getIdentificador() +
                " con transacción " + this.getTipoTransaccion());

        // Actualizar montoActual y agregar cliente a la lista de clientes atendidos
        montoActual += 100;  // Supongamos que se añade un monto fijo por cada transacción
        clientesAtendidos.add(cliente);
    }

    public void eliminarCaja(String identificador)
    {
        Iterator<Caja> iter = cajas.iterator();
        while (iter.hasNext()) {
            Caja caja = iter.next();
            if (caja.getIdentificador().equals(identificador)) {
                // Verificar si la caja tiene clientes por atender
                if (caja.getClientesAtendidos().isEmpty()) {
                    iter.remove();
                    System.out.println("Caja eliminada: " + identificador);
                } else {
                    System.out.println("No se puede eliminar la caja " + identificador + " porque tiene clientes por atender.");
                }
                return;
            }
        }
        System.out.println("No se encontró la caja con identificador " + identificador);
    }

    public void agregarCliente(String identificador, String nombre, String tipoTransaccion) {
        Cliente cliente = new Cliente(identificador, nombre, tipoTransaccion);

        System.out.println(cliente);
    }


    public static void main(String[] args) {

        Banco banco = new Banco();
        banco.agregarCaja("4040", 150.000, 150.000, "Consignación");
        banco.agregarCaja("2312", 100.000, 100.000, "retiro");
        banco.agregarCaja("5020", 120.000, 120.000, "pago de servicios");

        banco.agregarCliente("11", "Brayan", "consignacion");
        banco.agregarCliente("22", "Dylan", "retiro");
        banco.agregarCliente("33", "Juan Carlos", "pago de servicios");

    }
}