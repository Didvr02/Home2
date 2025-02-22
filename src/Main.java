public class Main {
    public static void main(String[] args) {
        
        Room startRoom = new Room("You are in a small stone chamber. There is a passage to the north.");
        Room hallway = new Room("You are in a dark hallway. There are passages to the south and east.");
        Room armory = new Room("You are in an ancient armory. Weapons are scattered around.");

        
        startRoom.setExit("north", hallway);
        hallway.setExit("south", startRoom);
        hallway.setExit("east", armory);
        armory.setExit("west", hallway);

        
        startRoom.addItem(new Item("torch"));
        hallway.addItem(new Weapon("rusty sword", 5));
        armory.addItem(new Weapon("battle axe", 10));
        armory.addItem(new Weapon("dagger", 3));

        
        Player player = new Player(startRoom);
        MUDController controller = new MUDController(player);

        
        controller.runGameLoop();
    }
}
