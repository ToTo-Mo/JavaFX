package application.Container.TableView;

public class Product{
    String name;
    int price;
    String description;

    @Override
    public String toString() {
        return "Product [description=" + description + ", name=" + name + ", price=" + price + "]";
    }

    public Product(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}