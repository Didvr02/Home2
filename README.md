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
My code is already clean and logical, but I can improve it further by:

Splitting handleInput() into smaller methods using switch-case for readability.

Adding comments to initializeCommands() and runGameLoop() to clarify their purpose.


## 6. Missing Main Class

I added a Main class that:

Creates rooms.

Adds items.

Places the player in the starting room.

Starts the MUDController.
