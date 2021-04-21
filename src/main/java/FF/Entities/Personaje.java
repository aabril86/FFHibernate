package FF.Entities;

import FF.Entities.Cartas.Carta;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table( name = "personaje" )
public class Personaje implements Serializable {

    @Id
    @Column(name = "id_personaje")
    private  int id_personaje;
    @Column(name = "nombre")
    private  String nombre;
    @Column(name = "vida")
    private int vida;
    @Column(name = "mana")
    private int mana;
    @Column(name = "sprite")
    private  String sprite;
    @Column(name = "categoria")
    private  String categoria;
    @OneToMany(mappedBy = "personaje", fetch=FetchType.LAZY)
            @JoinColumn(name = "id_carta")
    private ArrayList<Carta> mano;

    public Personaje(int id_personaje, int vida, int mana, String nombre, String sprite, String categoria, ArrayList<Carta> mano) {
        this.id_personaje = id_personaje;
        this.vida = vida;
        this.mana = mana;
        this.nombre = nombre;
        this.sprite = sprite;
        this.categoria = categoria;
        this.mano = mano;
    }

    public Personaje() {
    }

    public int getId_personaje() {
        return id_personaje;
    }

    public void setId_personaje(int id_personaje) {
        this.id_personaje = id_personaje;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Carta> getMano() {
        return mano;
    }

    public void setMano(ArrayList<Carta> mano) {
        this.mano = mano;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id_personaje=" + id_personaje +
                ", vida=" + vida +
                ", mana=" + mana +
                ", nombre='" + nombre + '\'' +
                ", sprite='" + sprite + '\'' +
                ", categoria='" + categoria + '\'' +
                ", mano=" + mano +
                '}';
    }
}
