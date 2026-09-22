public class tarea {
    public String descripcion;
    public boolean estado;
    public int id;
    private static int contador = 1;

    public tarea(String descripcion) {
        this.id = contador++;
        this.descripcion = descripcion;
        this.estado = false;
    }
}
