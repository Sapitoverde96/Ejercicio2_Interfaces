import java.util.ArrayList;
import java.util.Scanner;

void main() {
    Scanner sc = new Scanner(System.in);
    int opcion;

    ArrayList<tarea> tareas = new ArrayList<>();

    do {
        System.out.println("1. Añadir Tarea | 2. Ver Tarea | 3. Marcar tareas como completadas | 4. Eliminar tarea | 5. Salir.");
        System.out.print("Elige la opción:");
        opcion = sc.nextInt();

        if (opcion == 1) {
            sc.nextLine();
            System.out.println("Dime la descripción de la tarea que desees");
            String descripcion = sc.nextLine();
            tarea t = new tarea(descripcion);
            tareas.add(t);
            System.out.println("Tarea añadida correctamente");

        } else if (opcion == 2) {
            if (tareas.isEmpty()) {
                System.out.println("No hay tareas");
            } else
                for (tarea t : tareas) {
                    System.out.println("Id: " + t.id);
                    System.out.println("Descripción: " + t.descripcion);
                    if (t.estado) {
                        System.out.println("Estado : completado");
                    } else {
                        System.out.println("Estado : no completado");
                    }
                }
        } else if (opcion == 3) {
            System.out.println("Dime que tarea seleccionar: ");
            int idBuscar = sc.nextInt();

            for (tarea t : tareas) {

                if (t.id == idBuscar) {
                    t.estado = true;
                    System.out.println("tarea completada");
                }
            }
        } else if (opcion == 4) {
            System.out.println("Dime que id quieres eliminar: ");
            int idBuscar = sc.nextInt();

            for (int i = 0; i < tareas.size(); i++) {

                if (tareas.get(i).id == idBuscar) {
                    tareas.remove(i);
                    System.out.println("Tarea eliminada");
                    break;
                }
            }
        }
    } while (opcion != 5);
}