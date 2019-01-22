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

}
