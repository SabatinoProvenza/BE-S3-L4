package sabatinoprovenza.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import sabatinoprovenza.entities.Concerto;
import sabatinoprovenza.entities.Evento;
import sabatinoprovenza.entities.Genere;
import sabatinoprovenza.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento newEvento) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newEvento);
        transaction.commit();

        System.out.println("L'evento " + newEvento.getTitolo() + " è stato salvato correttamente!");
    }

    public Evento getById(String eventoId) {
        Evento found = entityManager.find(Evento.class, UUID.fromString(eventoId));
        if (found == null) throw new NotFoundException(eventoId);
        return found;
    }

    // NUOVI

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> q = entityManager.createQuery(
                "SELECT c FROM Concerto c WHERE c.inStreaming = :streaming",
                Concerto.class
        );
        q.setParameter("streaming", inStreaming);
        return q.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Genere genere) {
        TypedQuery<Concerto> q = entityManager.createQuery(
                "SELECT c FROM Concerto c WHERE c.genere = :genere",
                Concerto.class
        );
        q.setParameter("genere", genere);
        return q.getResultList();
    }
}

