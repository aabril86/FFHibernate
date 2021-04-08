package FF.Entities.Cartas;

public class Carta {
    int id_carta, coste_mana;
    String nombre, descripcion, imagen;

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
