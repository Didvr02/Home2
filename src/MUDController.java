import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class MUDController {
    private final Player player;
    private boolean running = true;
    private final Map<String, Consumer<String>> commandMap = new HashMap<>();

    public MUDController(Player player) {
        this.player = player;
        initializeCommands();
    }

    //**MudController (Skeleton):

    private void initializeCommands() {
        commandMap.put("look", arg -> lookAround());
        commandMap.put("move", this::move);
        commandMap.put("pick", this::pickUp);
        commandMap.put("inventory", arg -> checkInventory());
        commandMap.put("attack", this::attack);
        commandMap.put("help", arg -> showHelp());
        commandMap.put("quit", arg -> exitGame());
    }

    //**Main loop method that repeatedly reads input from the user
    //**and dispatches commands until the game ends.
    public void runGameLoop() {
        Scanner scanner = new Scanner(System.in);
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            handleInput(input);
        }
        scanner.close();
    }

    //**Handle input
    private void handleInput(String input) {
        if (input.isEmpty()) {
            System.out.println("Enter a command. Type 'help' for commands.");
            return;
        }
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();
        String argument = parts.length > 1 ? parts[1] : "";
        commandMap.getOrDefault(command, arg -> System.out.println("Unknown command.")).accept(argument);
    }

    //**Look around the current room: describe it and show items
    private void lookAround() {
        System.out.println(player.getCurrentRoom().describe());
    }

    //**Move the player in a given direction (north,west,south,east)
    private void move(String direction) {
        Room nextRoom = player.getCurrentRoom().getExit(direction.toLowerCase());
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println("You move " + direction + ".");
            lookAround();
        } else {
            System.out.println("You can't go that way!");
        }
    }
    
    //**Pick up an item
    private void pickUp(String argument) {
        if (!argument.startsWith("up ")) {
            System.out.println("Invalid command. Use: pick up <item>");
            return;
        }
        String itemName = argument.substring(3).trim();
        if (player.getCurrentRoom().hasItem(itemName)) {
            Item item = player.getCurrentRoom().removeItem(itemName);
            player.getInventory().addItem(item);
            System.out.println("You pick up the " + itemName + ".");
        } else {
            System.out.println("No item named " + itemName + " here!");
        }
    }

    //**Attacked NPC
    private void attack(String argument) {
        System.out.println("You swing your weapon wildly, but there's nothing to fight yet!");
    }
    //**Check the player's inventory.
    private void checkInventory() {
        System.out.println("You are carrying: " + player.getInventory().listItems());
    }

    //**Show help commands
    private void showHelp() {
        System.out.println("Available commands: look, move <direction>, pick up <item>, inventory, attack, help, quit");
    }

    //**Command for exiting game
    private void exitGame() {
        running = false;
        System.out.println("Goodbye!");
    }
}
