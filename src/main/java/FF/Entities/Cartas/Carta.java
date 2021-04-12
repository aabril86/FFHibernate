package FF.Entities.Cartas;

import FF.Entities.Personaje;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table( name = "Carta" )
public class Carta implements Serializable {
    @Id
    @Column(name = "id_carta")
    int id_carta;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "descripcion")
    String descripcion;
    @Column(name = "imagen")
    String imagen;
    @Column(name = "coste_mana")
    int coste_mana;
    @ManyToOne
    @JoinColumn(name = "id_personaje")
    private Personaje personaje;

    public Carta() {
    }

    @Override
    public String toString() {
        return "Carta{" +
                "id_carta=" + id_carta +
                ", coste_mana=" + coste_mana +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                '}';
    }

    public Carta(int id_carta, String nombre, String descripcion, String imagen, int coste_mana) {
        this.id_carta = id_carta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.coste_mana = coste_mana;
    }

    public int getId_carta() {
        return id_carta;
    }

    public void setId_carta(int id_carta) {
        this.id_carta = id_carta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCoste_mana() {
        return coste_mana;
    }

    public void setCoste_mana(int coste_mana) {
        this.coste_mana = coste_mana;
    }

}
