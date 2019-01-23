package pos.mini.models;

public class ItemTracker {

    private int itemId;
    private int count;
    private double price;
    private double subTotal;

    public ItemTracker(int itemId) {

        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemName(int itemId) {
        this.itemId = itemId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        setSubTotal(count, this.price);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int count, double price) {
        this.subTotal = price * count;
    }
}
