package app.javarx.presenter.impl;

import java.util.ArrayList;
import java.util.List;

import app.javarx.model.entity.EarthquakeData;
import app.javarx.model.entity.Feature;
import app.javarx.model.impl.EarthquakeApi;
import app.javarx.presenter.IMainPresenter;
import app.javarx.view.IMainView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenter implements IMainPresenter {
    private final EarthquakeApi _earthquakeApi;
    private final IMainView _view;

    public MainPresenter(IMainView view) {
        _earthquakeApi = new EarthquakeApi();
        _view = view;
    }

    @Override
    public void getEarthquakesData(boolean isUpdate) {
        Observable<EarthquakeData> dataObservable = _earthquakeApi.getEarthquakes();

        dataObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(onError -> System.out.println(onError.getMessage()))
                .subscribe(earthquakeData ->
                {
                    List<Feature> earthquakes = new ArrayList<>();
                    earthquakes.addAll(earthquakeData.getFeatures());

                    _view.hideLoadingIndicator();

                    if (earthquakes.isEmpty()) _view.setEmptyResponseText("There is no earthquakes");
                    else if (isUpdate) _view.updateEarthquakesListView(earthquakes);
                    else _view.setEarthquakesListViewData(earthquakes);
                });
    }
}