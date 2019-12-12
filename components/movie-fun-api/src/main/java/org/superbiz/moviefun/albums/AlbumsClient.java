package org.superbiz.moviefun.albums;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;
import org.superbiz.moviefun.moviesapi.MovieInfo;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

//@Component
public class AlbumsClient {

    private String albumsUrl;
    private RestOperations restOperations;

    private static ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };
    public AlbumsClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }

    public void addAlbum(AlbumInfo album) {
        restOperations.postForEntity(albumsUrl, album, AlbumInfo.class);
    }

    public AlbumInfo find(long id) {


        return restOperations.exchange(albumsUrl+"/"+id, GET, null, AlbumInfo.class).getBody();

    }

    public List<AlbumInfo> getAlbums() {
      /*  UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(albumsUrl)
                .queryParam("start", 1)
                .queryParam("pageSize", 10);*/

        return restOperations.exchange(albumsUrl, GET, null, albumListType).getBody();
    }


    public void deleteAlbum(AlbumInfo album) {
        restOperations.delete(albumsUrl + "/" + album.getId());
    }


    public void updateAlbum(AlbumInfo album) {

//        entityManager.merge(album);
        restOperations.put(albumsUrl + "/" + album.getId() + "/cover", album, AlbumInfo.class);
    }
}
