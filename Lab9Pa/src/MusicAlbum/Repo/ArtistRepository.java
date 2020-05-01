package MusicAlbum.Repo;
import java.util.List;
import MusicAlbum.Entity.Artist;

public interface ArtistRepository  {
    @Query(value = "select id from artists", nativeQuery = true)
    List<String> findArtistById(String id);
    @Query(value = "select name from artists", nativeQuery = true)
    List<String> findArtistByName(String name);
}