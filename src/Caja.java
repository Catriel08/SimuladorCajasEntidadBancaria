import java.util.ArrayList;
import java.util.List;

public class Caja {

    private String identificador;
    private double montoInicial;
    private double montoActual;
    private String tipoTransaccion;
    public List<Cliente> clientesAtendidos;

    public Caja(String identificador, double montoInicial, double montoActual, String tipoTransaccion) {
        this.identificador = identificador;
        this.montoInicial = montoInicial;
        this.montoActual = montoActual;
        this.tipoTransaccion = tipoTransaccion;
        this.clientesAtendidos = new ArrayList<>();
    }

    public Caja() {
        this.identificador = "";
        this.montoInicial = 0;
        this.montoActual = 0;
        this.tipoTransaccion = "";
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

    public double getMontoActual() {
        return montoActual;
    }

    public void setMontoActual(double montoActual) {
        this.montoActual = montoActual;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public List<Cliente> getClientesAtendidos() {
        return clientesAtendidos;
    }

    public void setClientesAtendidos(List<Cliente> clientesAtendidos) {
        this.clientesAtendidos = clientesAtendidos;
    }

    @Override
    public String toString() {
        return "Caja{" +
                "identificador='" + identificador + '\'' +
                ", montoInicial=" + montoInicial +
                ", montoActual=" + montoActual +
                ", tipoTransaccion='" + tipoTransaccion + '\'' +
                '}';
    }

}
