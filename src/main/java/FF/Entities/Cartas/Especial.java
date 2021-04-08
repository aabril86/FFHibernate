package FF.Entities.Cartas;

public class Especial extends Carta{

    int valor_especial;

    public Especial(int id_carta, String nombre, String descripcion, String imagen, int coste_mana, int valor_especial) {
        super(id_carta, nombre, descripcion, imagen, coste_mana);
        this.valor_especial = valor_especial;
    }
}
