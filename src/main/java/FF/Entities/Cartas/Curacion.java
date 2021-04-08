package FF.Entities.Cartas;

public class Curacion extends Carta {

    int valor_curacion;

    public Curacion(int id_carta, String nombre, String descripcion, String imagen, int coste_mana, int valor_curacion) {
        super(id_carta, nombre, descripcion, imagen, coste_mana);
        this.valor_curacion = valor_curacion;
    }
}
