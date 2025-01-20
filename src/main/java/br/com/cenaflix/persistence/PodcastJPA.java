package br.com.cenaflix.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PodcastJPA {

    public void cadastrarPodcast(Podcast p) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();

        }

    }

    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            Podcast p = em.find(Podcast.class, id);
            if (p != null) {
                em.getTransaction().begin();
                em.remove(p);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEtityManager();
        }
    }

    public List<Podcast> listarPodcast() {

        EntityManager em = JPAUtil.getEntityManager();
        List<Podcast> podcasts = null;
        try {
            Query consulta = em.createQuery("SELECT p FROM podcast p");
            podcasts = consulta.getResultList();
        } finally {
            JPAUtil.closeEtityManager();
        }
        return podcasts;

    }

    public List<Podcast> buscar(String filtroProdutor) {
    EntityManager em = JPAUtil.getEntityManager();
    List podcasts = null;
    try {
        String textoQuery = "SELECT p FROM podcast p WHERE (:produtor IS NULL OR p.produtor LIKE :produtor)";

        Query consulta = em.createQuery(textoQuery);

        consulta.setParameter("produtor", filtroProdutor.isEmpty() ? null : "%" + filtroProdutor + "%");

        podcasts = consulta.getResultList();
    } catch (Exception e) {
        System.out.println("Ocorreu um erro ao listar os dados");
        e.printStackTrace();
    } finally {
        JPAUtil.closeEtityManager();
    }
    return podcasts;
}


}
