public class Cliente {

    private String identificador;
    private String nombre;
    private String tipoTransaccion;

    public Cliente(String identificador, String nombre, String tipoTransaccion) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.tipoTransaccion = tipoTransaccion;
    }

    public Cliente() {
        this.identificador = "";
        this.nombre = "";
        this.tipoTransaccion = "";
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    @Override
    public String toString() {
        return "\nCliente: " +
                " Identificador: " + identificador +
                " Nombre: " + nombre +
                " TipoTransaccion: " + tipoTransaccion;
    }
}
