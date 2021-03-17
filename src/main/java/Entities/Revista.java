package Entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Revista implements Serializable {
    private int id_revista;
    private String titol;
    private Date data_publicacio;

    private List<Article> articles = new ArrayList<Article> ();


    public Revista(int id_revista, String titol, Date data_publicacio ) {
        super();
        this.titol = titol;
        this.data_publicacio = data_publicacio;
        this.id_revista = id_revista;
    }
    public Revista() {
        super();
    }
    public String getTitol() {
        return titol;
    }
    public void setTitol(String titol) {
        this.titol = titol;
    }
    public Date getData_publicacio() {
        return data_publicacio;
    }
    public void setData_publicacio(Date data_publicacio) {
        this.data_publicacio = data_publicacio;
    }
    public int getId_revista() {
        return id_revista;
    }
    public void setId_revista(int id_revista) {
        this.id_revista = id_revista;
    }
    public void addArticle(Article art){
        articles.add(art);
    }
    public Article getArticle(int i){

        return articles.get(i);

    }
    public List<Article> getArticles() {
        return articles;
    }
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }


    @Override
    public String toString() {
        return "Revista [id_revista=" + id_revista +",titol=" + titol + ", data_publicacio="
                + data_publicacio.toString() + "]";
    }

}
