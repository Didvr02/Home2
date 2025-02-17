public class Main {
    public static void main(String[] args) {
        // Create rooms
        Room startRoom = new Room("You are in a small stone chamber. There is a passage to the north.");
        Room hallway = new Room("You are in a dark hallway. There are passages to the south and east.");
        Room armory = new Room("You are in an ancient armory. Weapons are scattered around.");

        // Set room connections
        startRoom.setExit("north", hallway);
        hallway.setExit("south", startRoom);
        hallway.setExit("east", armory);
        armory.setExit("west", hallway);

        // Add items to rooms
        startRoom.addItem(new Item("torch"));
        hallway.addItem(new Weapon("rusty sword", 5));
        armory.addItem(new Weapon("battle axe", 10));
        armory.addItem(new Weapon("dagger", 3));

        // Create player and game controller
        Player player = new Player(startRoom);
        MUDController controller = new MUDController(player);

        // Start the game loop
        controller.runGameLoop();
    }
}
