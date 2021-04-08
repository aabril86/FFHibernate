package FF.Entities.Cartas;

public class Defensa extends Carta{

    int valor_defensa;

    public Defensa(int id_carta, String nombre, String descripcion, String imagen, int coste_mana, int valor_defensa) {
        super(id_carta, nombre, descripcion, imagen, coste_mana);
        this.valor_defensa = valor_defensa;
    }
}
