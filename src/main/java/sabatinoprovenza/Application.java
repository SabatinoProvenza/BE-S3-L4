package sabatinoprovenza;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BE-S3-L4pu");

    public static void main(String[] args) {

        System.out.println("Hello World!");
    }
}
