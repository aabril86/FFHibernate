package FF.Entities.Cartas;

public class Ataque extends Carta {

    int valor_ataque;

    public Ataque(int id_carta, String nombre, String descripcion, String imagen, int coste_mana, int valor_ataque) {
        super(id_carta, nombre, descripcion, imagen, coste_mana);
        this.valor_ataque = valor_ataque;
    }
}
