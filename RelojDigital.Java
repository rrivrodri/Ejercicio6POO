public class RelojDigital extends Widget {
    private String zonaHoraria;

    public RelojDigital(String id, String nombre, int consumoMemoriaKB, String zonaHoraria) {
        super(id, nombre, consumoMemoriaKB);
        this.zonaHoraria = zonaHoraria;
    }

    @Override
    public void renderizar() {}

    public String getZonaHoraria() {
        return zonaHoraria;
    }
}