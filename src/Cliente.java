public class Cliente {

    private String nombre;
    private String tipoTransaccionCliente;

    public Cliente(String nombre, String tipoTransaccionCliente) {
        this.nombre = nombre;
        this.tipoTransaccionCliente = tipoTransaccionCliente;
    }

    public Cliente() {
        this.nombre = "";
        this.tipoTransaccionCliente = "";
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

    @Override
    public String toString() {
        return "\nCliente: "+
                " Nombre: " + nombre +
                " TipoTransaccion cliente: " + tipoTransaccionCliente;
    }
}
