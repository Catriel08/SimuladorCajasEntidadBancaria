public class Cliente {

    private String identificadorCliente;
    private String nombre;
    private String tipoTransaccionCliente;
    private double saldoCuentaCliente;

    public Cliente(String identificadorCliente,String nombre, String tipoTransaccionCliente,double saldoCuentaCliente) {
        this.identificadorCliente = identificadorCliente;
        this.nombre = nombre;
        this.tipoTransaccionCliente = tipoTransaccionCliente;
        this.saldoCuentaCliente = saldoCuentaCliente;
    }

    public Cliente() {
        this.nombre = "";
        this.tipoTransaccionCliente = "";
    }

    public String getIdentificadorCliente() {
        return identificadorCliente;
    }

    public void setIdentificadorCliente(String identificadorCliente) {
        this.identificadorCliente = identificadorCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoTransaccionCliente() {
        return tipoTransaccionCliente;
    }

    public void setTipoTransaccionCliente(String tipoTransaccionCliente) {
        this.tipoTransaccionCliente = tipoTransaccionCliente;
    }

    public double getSaldoCuentaCliente() {
        return saldoCuentaCliente;
    }

    public void setSaldoCuentaCliente(double saldoCuentaCliente) {
        this.saldoCuentaCliente = saldoCuentaCliente;
    }

    @Override
    public String toString() {
        return "\nCliente: "+
                " Nombre: " + nombre +
                " TipoTransaccion cliente: " + tipoTransaccionCliente;
    }

}
