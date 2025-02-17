import java.util.*;

class Room {
    private final String description;
    private final Map<String, Room> exits = new HashMap<>();
    private final List<Item> items = new ArrayList<>();

    public Room(String description) {
        this.description = description;
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public boolean hasItem(String itemName) {
        return items.stream().anyMatch(item -> item.getName().equalsIgnoreCase(itemName));
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

    public String describe() {
        return description + "\nItems here: " + (items.isEmpty() ? "None" : items.stream().map(Item::getName).toList());
    }
}