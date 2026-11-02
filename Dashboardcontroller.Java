import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DashboardController {
    private List<Widget> catalogoWidgets;

    public DashboardController() {
        this.catalogoWidgets = new ArrayList<>();
        inicializarCatalogo();
    }

    // Carga inicial con al menos 10 widgets diversos
    private void inicializarCatalogo() {
        catalogoWidgets.add(new VisorClima("W-01", "Clima Central", 450, "Guatemala"));
        catalogoWidgets.add(new VisorClima("W-02", "Clima Internacional", 520, "Miami"));
        catalogoWidgets.add(new ListaTareas("W-03", "Tareas Sprint 1", 300, 5));
        catalogoWidgets.add(new ListaTareas("W-04", "Tareas Personales", 250, 2));
        catalogoWidgets.add(new NotificacionAlerta("W-05", "Alerta de Servidor", 150, "Alta"));
        catalogoWidgets.add(new NotificacionAlerta("W-06", "Aviso de Mantenimiento", 180, "Media"));
        catalogoWidgets.add(new RelojDigital("W-07", "Reloj Local", 100, "UTC-6"));
        catalogoWidgets.add(new RelojDigital("W-08", "Reloj UTC", 110, "UTC+0"));
        catalogoWidgets.add(new VisorClima("W-09", "Clima Costero", 480, "Monterrico"));
        catalogoWidgets.add(new ListaTareas("W-10", "Backlog General", 340, 12));
    }

    public List<Widget> obtenerTodosLosWidgets() {
        return catalogoWidgets;
    }

    // --- OVERLOADING: Búsqueda por ID exacto ---
    public Widget buscarWidget(String id) {
        for (Widget w : catalogoWidgets) {
            if (w.getId().equalsIgnoreCase(id)) {
                return w;
            }
        }
        return null;
    }

    // --- OVERLOADING: Búsqueda parcial por Nombre ---
    public List<Widget> buscarWidget(String nombreBusqueda, boolean esPorNombre) {
        List<Widget> resultados = new ArrayList<>();
        if (esPorNombre) {
            for (Widget w : catalogoWidgets) {
                if (w.getNombre().toLowerCase().contains(nombreBusqueda.toLowerCase())) {
                    resultados.add(w);
                }
            }
        }
        return resultados;
    }

    // Ordenar widgets usando la interfaz Comparable
    public void ordenarPorMemoria() {
        Collections.sort(catalogoWidgets);
    }

    // Permite agregar nuevos widgets dinámicamente sin modificar el contenedor principal
    public void agregarWidget(Widget nuevoWidget) {
        catalogoWidgets.add(nuevoWidget);
    }
}