package sabatinoprovenza;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sabatinoprovenza.dao.EventoDAO;
import sabatinoprovenza.entities.Concerto;
import sabatinoprovenza.entities.Genere;

import java.util.List;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BE-S3-L4pu");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);

//        //  CREO E SALVO 1 LOCATION
//        em.getTransaction().begin();
//        Location loc = new Location("Forum", "Milano");
//        em.persist(loc);
//        em.getTransaction().commit();
//
//        //  CREO 2 CONCERTI
//        Concerto c1 = new Concerto(
//                "Rock Night",
//                LocalDate.now(),
//                "Concerto rock in streaming",
//                TipoEvento.PUBBLICO,
//                5000,
//                loc,
//                Genere.ROCK,
//                true
//        );
//
//        Concerto c2 = new Concerto(
//                "Pupo in concerto",
//                LocalDate.now().plusDays(10),
//                "Concerto di Pupo, ma non in streaming",
//                TipoEvento.PRIVATO,
//                300,
//                loc,
//                Genere.CLASSICO,
//                false
//        );
//
//        // SALVO EVENTI
//        eventoDAO.save(c1);
//        eventoDAO.save(c2);

        //  Query: concerti in streaming
        List<Concerto> streaming = eventoDAO.getConcertiInStreaming(true);
        System.out.println("--- Concerti in streaming  ---");
        streaming.forEach(c ->
                System.out.println(c)
        );

        //  Query: concerti per genere
        List<Concerto> classico = eventoDAO.getConcertiPerGenere(Genere.CLASSICO);
        System.out.println("--- Concerti CLASSICI ---");
        classico.forEach(c ->
                System.out.println(c));


        em.close();
        emf.close();
    }
}
