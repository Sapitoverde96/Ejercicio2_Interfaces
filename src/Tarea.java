public class Tarea {
    public String descripcion;
    public boolean estado;
    public int id;
    public int prioridad;
    private static int contador = 1;

    public int getPrioridad() {
        return prioridad;
    }

    public Tarea(String descripcion, int prioridad) {
        this.id = contador++;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.estado = false;
    }

    public String toString() {
        return "ID: " + id + ", Descripción: " + descripcion + ", Prioridad: " + prioridad + ", Estado: " + estado;
    }
}
