package app.javarx.model;
import app.javarx.model.entity.EarthquakeData;
import retrofit2.http.GET;
import rx.Observable;


public interface IEarthquakeService {
    //For simplification of this example, I use query parameters like this. Instead of query map.
    @GET("query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10")
    Observable<EarthquakeData> getEarthquakeData();
}
