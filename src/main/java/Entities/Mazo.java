package Entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mazo implements Serializable {
    private int id_mazo;

    private List<Carta> cartas = new ArrayList<Carta> ();


    public Mazo(int id_mazo) {
        super();
        this.id_mazo = id_mazo;
    }
    public Mazo() {
        super();
    }
    public int getId_mazo() {
        return id_mazo;
    }
    public void setId_mazo(int id_mazo) {
        this.id_mazo = id_mazo;
    }
    public void addCarta(Carta art){
        cartas.add(art);
    }

    public Carta getCarta(int i){
        return cartas.get(i);
    }

    public List<Carta> getCartas() {
        return cartas;
    }
    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }

    @Override
    public String toString() {
        return "Mazo{" +
                "id_mazo=" + id_mazo +
                ", cartas=" + cartas +
                '}';
    }
}
