import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public Item removeItem(String itemName) {
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getName().equalsIgnoreCase(itemName)) {
                iterator.remove();
                return item;
            }
        }
        return null;
    }

    public boolean hasItem(String itemName) {
        return items.stream().anyMatch(item -> item.getName().equalsIgnoreCase(itemName));
    }

    public String listItems() {
        return items.isEmpty() ? "Nothing" : String.join(", ", items.stream().map(Item::getName).toList());
    }
}