package app.javarx.view;

import java.util.List;

import app.javarx.model.entity.Feature;

public interface IMainView {
    void setEarthquakesListViewData(List<Feature> earthquakes);
    void updateEarthquakesListView(List<Feature> earthquakes);
    void setEmptyResponseText(String text);
    void hideLoadingIndicator();
    void showNoConnectionMessage();
}
