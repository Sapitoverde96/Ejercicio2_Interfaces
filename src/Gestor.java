import java.util.ArrayList;
import java.util.Scanner;

void main() {
    Scanner sc = new Scanner(System.in);
    int opcion;

    ArrayList<Tarea> Tareas = new ArrayList<>();

    do {
        System.out.println("""
                1. Añadir una tarea
                2. Ver Tareas
                3. Marcar Tareas como completadas
                4. Filtrar tareas por prioridad
                5. Eliminar una tarea
                6. Guardar tareas en un archivo
                7. Salir
                """);
        System.out.print("Que operación desea realizar: ");
        opcion = sc.nextInt();

        // Opción 1: Añadir una tarea
        if (opcion == 1) {
            sc.nextLine();
            System.out.print("Asigna una descripción a la tarea: ");
            String descripcion = sc.nextLine();
            System.out.print("Asigna una prioridad a la tarea: ");
            int prioridad = sc.nextInt();
            Tarea tarea = new Tarea(descripcion, prioridad);
            Tareas.add(tarea);
            System.out.println("[INFO] Tarea añadida correctamente.\n");

        // Opción 2: Mostrar tareas
        } else if (opcion == 2) {
            if (Tareas.isEmpty()) {
                System.out.println("[ERROR] No hay Tareas.\n");
            } else
                for (Tarea tarea : Tareas) {
                    System.out.println("Nº Tarea: " + tarea.id);
                    System.out.println("Descripción: " + tarea.descripcion);
                    switch (tarea.getPrioridad()) {
                        case 1:
                            System.out.println("Prioridad: Alta");
                            break;
                        case 2:
                            System.out.println("Prioridad: Media");
                            break;
                        case 3:
                            System.out.println("Prioridad: Baja");
                            break;
                    }
                    if (tarea.estado) {
                        System.out.println("Estado: Hecho\n");
                    } else {
                        System.out.println("Estado: Sin hacer\n");
                    }
                }
        // Opción 3: Marcar tarea como completada
        } else if (opcion == 3) {
            System.out.print("Selecciona una tarea por ID: ");
            int idBuscar = sc.nextInt();
            for (Tarea tarea : Tareas) {
                if (tarea.id == idBuscar) {
                    tarea.estado = true;
                    System.out.println("[INFO] Tarea marcada como completada.\n");
                }
            }
        // Opción 4: Mostrar tareas por prioridad
        } else if (opcion == 4) {
            System.out.print("Selecciona una prioridad para mostrar: ");
            int prioridad = sc.nextInt();
            for (Tarea tarea : Tareas) {
                if (tarea.prioridad == prioridad) {
                    System.out.println("Nº Tarea: " + tarea.id);
                    System.out.println("Descripción: " + tarea.descripcion);
                    if (tarea.estado) {
                        System.out.println("Estado: Hecho\n");
                    } else {
                        System.out.println("Estado: Sin hacer\n");
                    }
                }
            }
        // Opción 5: Eliminar tarea por ID
        } else if (opcion == 5) {
            System.out.print("Selecciona una tarea por ID: ");
            int idBuscar = sc.nextInt();
            for (int indice = 0; indice < Tareas.size(); indice++) {
                if (Tareas.get(indice).id == idBuscar) {
                    Tareas.remove(indice);
                    System.out.println("[INFO] Tarea eliminada.\n");
                    break;
                }
            }
        // Opción 6: Guardar tareas en archivo
        } else if (opcion == 6) {
            if (Tareas.isEmpty()) {
                return;
            }
            try (FileWriter escritorArchivos = new FileWriter("tareas.txt", true)) {
                for (Tarea tarea : Tareas) {
                    escritorArchivos.write("ID Tarea: " + tarea.id + "\n");
                    escritorArchivos.write("Descripción: " + tarea.descripcion + "\n");
                    escritorArchivos.write("Prioridad: " + tarea.prioridad + "\n");
                    escritorArchivos.write("Estado: " + tarea.estado + "\n");
                }

            } catch (IOException e) {
                System.out.println("[ERROR] No se pudo guardar el archivo.\n");
            }
            System.out.println("[INFO] Se han guardado las tareas.\n");
        } else {
            System.out.println("[ERROR] Opción inválida.\n");
        }
    } while (opcion != 7);
}