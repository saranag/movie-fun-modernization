package org.superbiz.moviefun.moviesapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.superbiz.moviefun.albums.AlbumFixtures;
import org.superbiz.moviefun.albums.AlbumInfo;
import org.superbiz.moviefun.albums.AlbumsClient;


import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final MoviesClient moviesBean;
    private final AlbumsClient albumsBean;
    private final MovieFixtures movieFixtures;
    private final AlbumFixtures albumFixtures;

    public HomeController(MoviesClient moviesBean, AlbumsClient albumsBean, MovieFixtures movieFixtures, AlbumFixtures albumFixtures) {
        this.moviesBean = moviesBean;
        this.albumsBean = albumsBean;
        this.movieFixtures = movieFixtures;
        this.albumFixtures = albumFixtures;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (MovieInfo movie : movieFixtures.load()) {
            moviesBean.addMovie(movie);
        }

        for (AlbumInfo album : albumFixtures.load()) {
            albumsBean.addAlbum(album);
        }

        model.put("movies", moviesBean.getMovies());
        model.put("albums", albumsBean.getAlbums());

        logger.debug("End of setup Home controller");

        return "setup";
    }

  /*  @GetMapping("/albums")
    public List<AlbumInfo> albums(){
        return albumsBean.getAlbums();
    }*/

}
