package br.com.cenaflix.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "podcast")
public class Podcast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String produtor;
    private String nome_do_episodio;
    private int n_episodio;
    private String url;
    private String duracao;

    public Podcast() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public String getNome_do_episodio() {
        return nome_do_episodio;
    }

    public void setNome_do_episodio(String nome_do_episodio) {
        this.nome_do_episodio = nome_do_episodio;
    }

    public int getN_episodio() {
        return n_episodio;
    }

    public void setN_episodio(int n_episodio) {
        this.n_episodio = n_episodio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

  
    

}
