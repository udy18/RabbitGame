Implementation of OOPs Framework

-UTHKARSH SRINIVASAN(Z124493)

1. Classes and Interfaces

Interfaces
- `Drawable.java`: Drawing behavior contract
- Main Methods: draw()

Abstract Classes
- `Entity.java`: Base game object
- `MovableEntity.java`: Base for moving objects

Concrete Classes
- `Player.java`: Player entity implementation
- `Monster.java`: Enemy entity implementation
- `Rabbit.java`: Target entity implementation
- `Wall.java`: Obstacle implementation
- `GameState.java`: Game state management
- `GameView.java`: Rendering management
- `GameController.java`: Game logic control

2. Encapsulation/Abstraction/Polymorphism

Encapsulation
- `GameState.java`: 
  - Private game data
  - Access methods for game state
  - Protected state modification methods

Abstraction
- `GameController.java`:
  - High-level game control methods
  - Abstract game flow management
  - Hidden implementation details

Polymorphism
- Through `Drawable` interface:
  - Different draw() implementations in Player, Monster, Rabbit, Wall
- Through `MovableEntity`:
  - Different move() implementations in Player, Monster, Rabbit

3. Collections/Generics

Collections
- `GameState.java`:
  - `List<Monster>`: Monster management
  - `List<Rabbit>`: Rabbit management
  - `List<Wall>`: Wall management

Generics
- `CollisionDetector.java`:
  - Generic collision detection methods
- `GameController.java`:
  - Generic entity management

4. Input/Output

Input
- `GameController.java`:
  - Keyboard input handling
  - Game control inputs

Output
- `GameView.java`:
  - Graphics rendering
  - Game state display
  - Score/level display

5. Threading
 Main Thread Management
- `GameThread.java`:
  - Game loop implementation
  - Update timing control
  - Frame rate management

Thread Synchronization
- `GameController.java`:
  - State synchronization
  - Input processing synchronization

6. Design Patterns

MVC Pattern
- Model: `GameState.java`
- View: `GameView.java`
- Controller: `GameController.java`

Observer Pattern
- Subject: `GameState.java`
- Observer: `GameView.java`

Strategy Pattern
- Movement strategies in `MovableEntity.java`
- Different implementations in Player/Monster/Rabbit

