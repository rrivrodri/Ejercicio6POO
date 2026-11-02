import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DashboardController controller = new DashboardController();
        boolean ejecutando = true; // Bucle controlado sin while(true)

        while (ejecutando) {
            System.out.println("\n=== DASHBOARD MODULAR EMPRESARIAL ===");
            System.out.println("1. Listar todos los widgets activos");
            System.out.println("2. Buscar widget por ID");
            System.out.println("3. Buscar widgets por coincidencia de nombre");
            System.out.println("4. Ordenar widgets por consumo de memoria (KB)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            String opcionStr = scanner.nextLine();

            switch (opcionStr) {
                case "1":
                    System.out.println("\n--- LISTA DE WIDGETS ACTIVOS ---");
                    List<Widget> todos = controller.obtenerTodosLosWidgets();
                    for (Widget w : todos) {
                        System.out.println(w.toString());
                        // Demostración de polimorfismo seguro con interfaces
                        if (w instanceof Interactivo) {
                            System.out.println("   -> [Estado: Soporta interacción en tiempo real]");
                        } else {
                            System.out.println("   -> [Estado: Elemento puramente estático/informativo]");
                        }
                    }
                    break;

                case "2":
                    System.out.print("Ingrese el ID exacto del widget (ej. W-01): ");
                    String idBuscado = scanner.nextLine();
                    Widget encontradoId = controller.buscarWidget(idBuscado);
                    if (encontradoId != null) {
                        System.out.println("Widget encontrado: " + encontradoId);
                    } else {
                        System.out.println("No se encontró ningún widget con el ID: " + idBuscado);
                    }
                    break;

                case "3":
                    System.out.print("Ingrese parte del nombre a buscar: ");
                    String nombreBuscado = scanner.nextLine();
                    List<Widget> encontradosNombre = controller.buscarWidget(nombreBuscado, true);
                    if (!encontradosNombre.isEmpty()) {
                        System.out.println("\n--- RESULTADOS DE BÚSQUEDA ---");
                        for (Widget w : encontradosNombre) {
                            System.out.println(w);
                        }
                    } else {
                        System.out.println("No se encontraron widgets con ese criterio.");
                    }
                    break;

                case "4":
                    controller.ordenarPorMemoria();
                    System.out.println("\n¡Widgets ordenados exitosamente por consumo de memoria (Ascendente)!");
                    List<Widget> ordenados = controller.obtenerTodosLosWidgets();
                    for (Widget w : ordenados) {
                        System.out.println(w);
                    }
                    break;

                case "5":
                    ejecutando = false;
                    System.out.println("Saliendo del sistema del Dashboard. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        }
        scanner.close();
    }
}