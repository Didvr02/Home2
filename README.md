# *Homework 2*

## 1. Command Implementation ##
My MUDController already supports the following commands:

####  look – Describes the current room. ✅ 
####  move <direction> – Moves in the specified direction. ✅ 
#### pick up <item> – Picks up an item from the room into inventory. ✅
#### inventory – Displays the items the player is carrying. ✅
#### help – Shows a list of available commands. ✅
#### quit – Ends the game. ✅
#### attack – An extra command, but without battle logic yet. ✅
## 2. Movement Logic ##
My move function checks if an exit exists in the given direction and moves the player if possible. If there is no exit, it prints "You can't go that way!" This fully meets the assignment requirements. ✅

## 3. Interaction with Items ##
pickUp:

Checks if the item is in the room.

If found, removes it from the room and adds it to the inventory.

If not found, prints "No item named X here!"

checkInventory():

Iterates through the inventory and displays the list of items.


## 4. Error Handling
My code correctly handles errors:

Unknown command → "Unknown command."
Invalid direction → "You can't go that way!"
Missing item → "No item named X here!"


## 5. SOLID and Clean Code
My implementation adheres to SOLID principles:

SRP (Single Responsibility Principle) – Each class has a clear, distinct purpose:

Inventory handles item management.

Room manages room descriptions and exits.

Player tracks player state and inventory.

MUDController handles command processing.

OCP (Open/Closed Principle) – New commands can be added easily without modifying MUDController, thanks to the Map<String, Consumer<String>> structure.

LSP (Liskov Substitution Principle) – Weapon extends Item and can be used anywhere an Item is expected.

DIP (Dependency Inversion Principle) – Commands are stored as a Map of functions, reducing direct dependencies between MUDController and command implementations.


## 6. Missing Main Class

My Main class is responsible for setting up the game:

Creates rooms with descriptions and connections.

Adds items to different rooms, including weapons.

Places the player in the starting room.

Starts the game loop via MUDController.

## 7. Conclusion
My project successfully implements all required features with structured, clean, and maintainable code. 
