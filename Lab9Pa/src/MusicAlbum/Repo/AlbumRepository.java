package MusicAlbum.Repo;
import java.util.List;
import MusicAlbum.Entity.Album;

public interface AlbumRepository  {
    @Query(value = "select id from albums", nativeQuery = true)
    List<String> findAlbumById(String id);
    @Query(value = "select name from albums", nativeQuery = true)
    List<String> findAlbumByName(String name);
    @Query(value = "select list from artists a where a.artists = ?1", nativeQuery = true)
    List<String> findByArtist(String country);
}