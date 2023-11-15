import java.util.ArrayList;
import java.util.List;

public class Caja {

    private String identificador;
    private double montoInicial;
    private double montoFinal;
    private String tipoTransaccion;
    private int totalClientesAtendidos;
    private int clientesPorAtender;
    private List<Cliente> clientesEnEspera;

    public Caja(String identificador, double montoInicial, double montoFinal, String tipoTransaccion, int totalClientesAtendidos, int clientesPorAtender) {
        this.identificador = identificador;
        this.montoInicial = montoInicial;
        this.montoFinal = montoFinal;
        this.tipoTransaccion = tipoTransaccion;
        this.totalClientesAtendidos = totalClientesAtendidos;
        this.clientesPorAtender = clientesPorAtender;
        this.clientesEnEspera = new ArrayList<>();
    }

    public Caja() {
        this.identificador = "";
        this.montoInicial = 0;
        this.montoFinal = 0;
        this.tipoTransaccion = "";
        this.totalClientesAtendidos = 0;
        this.clientesPorAtender = 0;
    }

    public void agregarClienteEnEspera(Cliente cliente) {
        clientesEnEspera.add(cliente);
    }

    public void incrementarClientesPorAtender() {
        // Incrementar el contador de clientes por atender
        clientesPorAtender++;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public double getMontoInicial() {
        return montoInicial;
    }

    public void setMontoInicial(double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public int getTotalClientesAtendidos() {
        return totalClientesAtendidos;
    }

    public void setTotalClientesAtendidos(int totalClientesAtendidos) {
        this.totalClientesAtendidos = totalClientesAtendidos;
    }

    public int getClientesPorAtender() {
        return clientesPorAtender;
    }

    public void setClientesPorAtender(int clientesPorAtender) {
        this.clientesPorAtender = clientesPorAtender;
    }


    @Override
    public String toString() {
        return "Caja{" +
                "identificador='" + identificador + '\'' +
                ", montoInicial=" + montoInicial +
                ", montoFinal=" + montoFinal +
                ", tipoTransaccion='" + tipoTransaccion + '\'' +
                ", totalClientesAtendidos=" + totalClientesAtendidos +
                '}';
    }

}