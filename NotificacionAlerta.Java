public class NotificacionAlerta extends Widget {
    private String nivelUrgencia;

    public NotificacionAlerta(String id, String nombre, int consumoMemoriaKB, String nivelUrgencia) {
        super(id, nombre, consumoMemoriaKB);
        this.nivelUrgencia = nivelUrgencia;
    }

    @Override
    public void renderizar() {}

    public String getNivelUrgencia() {
        return nivelUrgencia;
    }
}