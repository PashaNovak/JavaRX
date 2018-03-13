package app.javarx.model.impl;

import app.javarx.model.IEarthquakeApi;
import app.javarx.model.IEarthquakeService;
import app.javarx.model.entity.EarthquakeData;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class EarthquakeApi implements IEarthquakeApi {

    //@Override
    public Observable<EarthquakeData> getEarthquakes() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://earthquake.usgs.gov/fdsnws/event/1/")
                .build();

        IEarthquakeService weatherService = retrofit.create(IEarthquakeService.class);

        return weatherService.getEarthquakeData();
    }
}
