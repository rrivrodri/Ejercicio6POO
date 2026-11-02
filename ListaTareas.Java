public class ListaTareas extends Widget implements Interactivo {
    private int totalTareasPendientes;

    public ListaTareas(String id, String nombre, int consumoMemoriaKB, int totalTareasPendientes) {
        super(id, nombre, consumoMemoriaKB);
        this.totalTareasPendientes = totalTareasPendientes;
    }

    @Override
    public void renderizar() {}

    @Override
    public void interactuar() {}

    public int getTotalTareasPendientes() {
        return totalTareasPendientes;
    }
}