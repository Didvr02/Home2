class Player {
    private Room currentRoom;
    private final Inventory inventory = new Inventory();

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Inventory getInventory() {
        return inventory;
    }
}