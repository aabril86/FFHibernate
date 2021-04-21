package FF.Entities;

import FF.Entities.Cartas.Carta;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mano")
public class Mano implements Serializable {
    @Id
    @Column
    private int id_mano;
    @OneToOne(mappedBy = "mano")
    @JoinColumn(name = "id_personaje")
    private Personaje personaje;
    @OneToMany(mappedBy = "mano")
    @JoinColumn(name = "id_carta")
    private List<Carta> cartas = new ArrayList<Carta>();
    Carta carta;

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    @Override
    public String toString() {
        return "Mano{" +
                "personaje=" + personaje +
                ", carta=" + carta +
                '}';
    }

    public int getId_mano() {
        return id_mano;
    }

    public void setId_mano(int id_mano) {
        this.id_mano = id_mano;
    }
}
