public class Caja {

    private String identificador;
    private double montoInicial;
    private double montoFinal;
    private String tipoTransaccion;
    private int totalClientesAtendidos;
    private int totalTiempoEspera;
    private int totalTiempoAtencion;


    public Caja(String identificador, double montoInicial, double montoFinal, String tipoTransaccion, int totalClientesAtendidos, int totalTiempoEspera, int totalTiempoAtencion) {
        this.identificador = identificador;
        this.montoInicial = montoInicial;
        this.montoFinal = montoFinal;
        this.tipoTransaccion = tipoTransaccion;
        this.totalClientesAtendidos = totalClientesAtendidos;
        this.totalTiempoEspera = totalTiempoEspera;
        this.totalTiempoAtencion = totalTiempoAtencion;
    }

    public Caja() {
        this.identificador = "";
        this.montoInicial = 0;
        this.montoFinal = 0;
        this.tipoTransaccion = "";
        this.totalClientesAtendidos = 0;
        this.totalTiempoEspera = 0;
        this.totalTiempoAtencion = 0;
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

    public int getTotalTiempoEspera() {
        return totalTiempoEspera;
    }

    public void setTotalTiempoEspera(int totalTiempoEspera) {
        this.totalTiempoEspera = totalTiempoEspera;
    }

    public int getTotalTiempoAtencion() {
        return totalTiempoAtencion;
    }

    public void setTotalTiempoAtencion(int totalTiempoAtencion) {
        this.totalTiempoAtencion = totalTiempoAtencion;
    }

    @Override
    public String toString() {
        return "Caja{" +
                "identificador='" + identificador + '\'' +
                ", montoInicial=" + montoInicial +
                ", montoFinal=" + montoFinal +
                ", tipoTransaccion='" + tipoTransaccion + '\'' +
                ", totalClientesAtendidos=" + totalClientesAtendidos +
                ", totalTiempoEspera=" + totalTiempoEspera +
                ", totalTiempoAtencion=" + totalTiempoAtencion +
                '}';
    }
}
