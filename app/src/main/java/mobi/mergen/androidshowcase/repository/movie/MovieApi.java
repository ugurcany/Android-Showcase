package mobi.mergen.androidshowcase.repository.movie;

import io.reactivex.Observable;
import mobi.mergen.androidshowcase.data.MovieResults;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {

    @GET("/")
    Observable<MovieResults> search(@Query("apikey") String apiKey,
                                    @Query("s") String searchText);

}
