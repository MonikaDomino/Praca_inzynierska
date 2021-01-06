package hibernate;

import javafx.util.StringConverter;

public class DanefinansoweConverter extends StringConverter<Danefinansowe> {
    @Override
    public String toString(Danefinansowe danefinansowe) {
        return danefinansowe == null ? null : danefinansowe.getRokBilansowy().toString();

    }

    @Override
    public Danefinansowe fromString(String s) {
        return null;
    }
}
