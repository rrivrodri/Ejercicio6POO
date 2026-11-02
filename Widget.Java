public abstract class Widget implements Renderizable, Comparable<Widget> {
    private String id;
    private String nombre;
    private int consumoMemoriaKB;

    public Widget(String id, String nombre, int consumoMemoriaKB) {
        this.id = id;
        this.nombre = nombre;
        this.consumoMemoriaKB = consumoMemoriaKB;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getConsumoMemoriaKB() {
        return consumoMemoriaKB;
    }

    public void setConsumoMemoriaKB(int consumoMemoriaKB) {
        this.consumoMemoriaKB = consumoMemoriaKB;
    }

    @Override
    public int compareTo(Widget otro) {
        // Orden ascendente por consumo de memoria (KB)
        return Integer.compare(this.consumoMemoriaKB, otro.consumoMemoriaKB);
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Memoria: " + consumoMemoriaKB + " KB";
    }
}