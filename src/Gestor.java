import java.util.ArrayList;
import java.util.Scanner;

void main() {
    Scanner sc = new Scanner(System.in);
    int opcion;

    ArrayList<tarea> tareas = new ArrayList<>();

    do {
        System.out.println("""
                1. Añadir una tarea
                2. Ver tareas
                3. Marcar tareas como completadas
                4. Eliminar una tarea
                5. Salir
                """);
        System.out.print("Que operación desea realizar: ");
        opcion = sc.nextInt();

        if (opcion == 1) {
            sc.nextLine();
            System.out.print("Asigna una descripción a la tarea: ");
            String descripcion = sc.nextLine();
            tarea t = new tarea(descripcion);
            tareas.add(t);
            System.out.println("[INFO] Tarea añadida correctamente.\n");

        } else if (opcion == 2) {
            if (tareas.isEmpty()) {
                System.out.println("[ERROR] No hay tareas.\n");
            } else
                for (tarea t : tareas) {
                    System.out.println("Nº Tarea: " + t.id);
                    System.out.println("Descripción: " + t.descripcion);
                    if (t.estado) {
                        System.out.println("Estado: Hecho\n");
                    } else {
                        System.out.println("Estado: Sin hacer\n");
                    }
                }
        } else if (opcion == 3) {
            System.out.print("Selecciona una tarea por ID: ");
            int idBuscar = sc.nextInt();
            for (tarea t : tareas) {
                if (t.id == idBuscar) {
                    t.estado = true;
                    System.out.println("[INFO] Tarea marcada como completada.\n");
                }
            }
        } else if (opcion == 4) {
            System.out.print("Selecciona una tarea por ID: ");
            int idBuscar = sc.nextInt();
            for (int i = 0; i < tareas.size(); i++) {
                if (tareas.get(i).id == idBuscar) {
                    tareas.remove(i);
                    System.out.println("[INFO] Tarea eliminada.\n");
                    break;
                }
            }
        } else {
            System.out.println("[ERROR] Opción inválida.\n");
        }
    } while (opcion != 5);
}