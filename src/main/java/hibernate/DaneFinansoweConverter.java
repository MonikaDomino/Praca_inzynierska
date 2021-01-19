package hibernate;

import javafx.util.StringConverter;

public class DaneFinansoweConverter extends StringConverter<DaneFinansowe> {
    @Override
    public String toString(DaneFinansowe danefinansowe) {
        return danefinansowe == null ? null : danefinansowe.getRokBilansowy().toString();

    }

    @Override
    public DaneFinansowe fromString(String s) {
        return null;
    }
}
