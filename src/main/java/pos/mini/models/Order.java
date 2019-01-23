package pos.mini.models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Order {

    @Id
    private int id;

    private static int idState = 0;

    private int userId;
    private double total;
    private boolean open;
    private List<ItemTracker> itemList;

    public Order(){};
    public Order(int userId) {
        this.userId = userId;
        idState++;
        id = idState;
        itemList = new ArrayList<>();
    }

    public  int getId() {
        return id;
    }

    public  void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUser(int userId) {
        this.userId = userId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public List<ItemTracker> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemTracker> itemList) {
        this.itemList = itemList;
    }
}
