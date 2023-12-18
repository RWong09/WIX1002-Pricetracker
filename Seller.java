import java.util.ArrayList;
import java.util.List;

class Seller {
    private String premiseCode;
    private String premiseName;
    private List<Item> inventory;

    public Seller(String premiseCode, String premiseName) {
        this.premiseCode = premiseCode;
        this.premiseName = premiseName;
        this.inventory = new ArrayList<>();
    }

    public String getPremiseCode() {
        return premiseCode;
    }

    public String getPremiseName() {
        return premiseName;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }
}