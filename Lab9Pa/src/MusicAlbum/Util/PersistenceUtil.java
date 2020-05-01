package MusicAlbum.Util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    EntityManagerFactory entityManagerFactory;

    /**
     * Functia de creare al artistului
     * @return EntityManagerFactory
     */
    //class must contain a method for creating/returning an EntityManagerFactory object
    public static EntityManagerFactory create(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PersistenceUtil");
        return entityManagerFactory;
    }

    //Implement the Singleton desing pattern...
    //...
}
