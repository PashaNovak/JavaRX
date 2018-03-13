package app.javarx.model;

import app.javarx.model.entity.EarthquakeData;
import rx.Observable;

public interface IEarthquakeApi {
    Observable<EarthquakeData> getEarthquakes();
}
