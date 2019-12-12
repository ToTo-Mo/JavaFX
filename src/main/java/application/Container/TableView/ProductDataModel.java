package application.Container.TableView;

import javafx.beans.property.*;

public class ProductDataModel{
    private StringProperty name;
    private IntegerProperty price;
    private StringProperty description;

    public ProductDataModel(StringProperty name, IntegerProperty price, StringProperty description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public IntegerProperty getPriceProperty() {
        return price;
    }

    public StringProperty getDecriptionProperty() {
        return description;
    }

    

}