package FF.Entities;

import FF.Entities.Cartas.Carta;

import java.util.ArrayList;

public class Personaje {
    int id_personaje, vida, mana;
    String nombre, sprite, categoria;

    ArrayList<Carta> mano = new ArrayList<>();
}
