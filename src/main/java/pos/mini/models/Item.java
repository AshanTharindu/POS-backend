package pos.mini.models;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

public class Item {

    @Id
    private static int id;

    @NotBlank
    private String name;

    @NotBlank
    private double price;


    public Item(String name, double price) {
        this.name = name;
        this.price = price;
        id++;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Item.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
