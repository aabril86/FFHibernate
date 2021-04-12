package FF.Entities;

import FF.Entities.Cartas.Carta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;

//HAY QUE CAMBIAR EL NOMBRE DE LA TABLA
@Entity
@Table( name = "autors" )
public class Personaje implements Serializable {

    //ESTO HAY QUE MODIFICARLO
    @Id
    @Column(name = "id_autor")
    private  int id_autor;
    @Column(name = "nom")
    private  String nom;
    @Column(name = "nacionalitat")
    private  String nacionalitat;
    @Column(name = "any_naixement")
    private  String any_naixement;
    @Column(name = "actiu")
    private  boolean actiu;

    int id_personaje, vida, mana;
    String nombre, sprite, categoria;

    ArrayList<Carta> mano = new ArrayList<Carta>();

    public Personaje(int id_personaje, int vida, int mana, String nombre, String sprite, String categoria, ArrayList<Carta> mano) {
        this.id_personaje = id_personaje;
        this.vida = vida;
        this.mana = mana;
        this.nombre = nombre;
        this.sprite = sprite;
        this.categoria = categoria;
        this.mano = mano;
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
