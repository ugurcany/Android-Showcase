package mobi.mergen.androidshowcase.repository.movie;

import io.reactivex.Observable;
import mobi.mergen.androidshowcase.data.MovieResults;

public interface IMovieRepository {

    Observable<MovieResults> search(String searchText);

}
