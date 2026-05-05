# 🟡 Pac-Man in Java

> A fully functional classic Pac-Man arcade game built from scratch using **Java Swing** — no game engine, just pure Java.

Navigate Pac-Man through a tile-based maze, eat all the food dots, dodge four unique ghosts, and see how high you can score before your lives run out!

---

## 🎮 Demo / Screenshots

> Run the project locally to see it in action. Arrow keys to move — eat all the dots to advance to the next round!

---

## ✨ Features

- 🗺️ Classic **21×19 tile-based maze** with a fully customizable map layout
- 👻 **4 ghost types** — Red (Blinky), Pink (Pinky), Blue (Inky), and Orange (Clyde) — each with randomized AI movement
- 🟡 **Directional Pac-Man sprites** that update based on movement direction (up, down, left, right)
- 🍬 **Food dot collection** with real-time score tracking
- ❤️ **3-life system** — positions reset after each ghost collision
- ⏸️ **Pause and resume** support via keyboard
- 🔄 **Auto-restart** on game over via any arrow key
- 🔁 **Next round** — the map fully reloads when all food dots are consumed
- 🎯 **Collision detection** for walls, ghosts, and food using AABB (Axis-Aligned Bounding Box)
- 🧠 **Ghost boundary logic** — ghosts reverse direction upon hitting walls or screen edges

---

## 🕹️ Controls

| Key | Action |
|-----|--------|
| `↑` Arrow | Move Up |
| `↓` Arrow | Move Down |
| `←` Arrow | Move Left |
| `→` Arrow | Move Right |
| `P` | Pause Game |
| `R` | Resume Game |
| Any Arrow *(on Game Over)* | Restart Game |

---

## 📁 Project Structure

```
PacMan/
│
├── App.java              # Entry point — initializes the JFrame window and launches the game
├── PacMan.java           # Core game engine — rendering, physics, input, ghost AI, collision
│
└── assets/               # All sprite image files (must be in the same directory as .class files)
    ├── wall.png
    ├── pacmanUp.png
    ├── pacmanDown.png
    ├── pacmanLeft.png
    ├── pacmanRight.png
    ├── redGhost.png
    ├── blueGhost.png
    ├── pinkGhost.png
    ├── orangeGhost.png
    ├── scaredGhost.png
    ├── powerFood.png
    ├── cherry.png
    └── cherry2.png
```

---

## 🚀 Getting Started

### ✅ Prerequisites

- **Java JDK 8** or higher installed
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code with Java extension) **or** a terminal

### ▶️ Running the Game

**Option 1 — Terminal:**

```bash
# 1. Clone the repository
git clone https://github.com/ShahriarXProxima/pacman-java.git
cd pacman-java

# 2. Compile both source files
javac App.java PacMan.java

# 3. Run the game
java App
```

**Option 2 — IDE:**

1. Open the project folder in your preferred Java IDE
2. Make sure all `.png` asset files are in the **same directory** as the compiled `.class` files
3. Run `App.java` as the main entry point

> ⚠️ **Important:** All image assets must be placed alongside the compiled `.class` files on the classpath. If assets are missing, the game will throw a `NullPointerException` on image load.

---

## 🗺️ Map Customization

The maze is fully defined as a `String[]` tile map inside `PacMan.java`. You can design your own level by editing the `tileMap` array — just follow the character key below:

| Character | Meaning |
|-----------|---------|
| `X` | Wall tile |
| ` ` *(space)* | Food dot (walkable path with food) |
| `O` | Open path (walkable, no food) |
| `P` | Pac-Man starting position |
| `r` | Red Ghost spawn point |
| `b` | Blue Ghost spawn point |
| `p` | Pink Ghost spawn point |
| `o` | Orange Ghost spawn point |

**Default map layout (21 rows × 19 columns):**

```
XXXXXXXXXXXXXXXXXXX
X        X        X
X XX XXX X XXX XX X
X                 X
X XX X XXXXX X XX X
X    X       X    X
XXXX XXXX XXXX XXXX
OOOX X       X XOOO
XXXX X XXrXX X XXXX
O       bpo       O
XXXX X XXXXX X XXXX
OOOX X       X XOOO
XXXX X XXXXX X XXXX
X        X        X
X XX XXX X XXX XX X
X  X     P     X  X
XX X X XXXXX X X XX
X    X   X   X    X
X XXXXXX X XXXXXX X
X                 X
XXXXXXXXXXXXXXXXXXX
```

---

## ⚙️ How It Works

### Game Loop
The game is powered by a `javax.swing.Timer` firing every **50ms (~20 FPS)**. Each tick calls `move()` to update positions and `repaint()` to re-render the board.

### Block System
Every entity — walls, food, ghosts, and Pac-Man — is an instance of the inner `Block` class. Each block stores its position, size, image, movement direction, and velocity.

### Ghost AI
Ghosts move at the same speed as Pac-Man (`tileSize / 4` pixels per tick). When a ghost collides with a wall or reaches the screen edge, it picks a new random direction from `{'U', 'R', 'D', 'L'}`. Ghosts are also forced upward when they reach row 9 (the ghost house exit row) to prevent them from getting stuck.

### Collision Detection
Collisions use standard **AABB (Axis-Aligned Bounding Box)** detection:
```java
return a.x < b.x + b.width && a.x + a.width > b.x &&
       a.y < b.y + b.height && a.y + a.height > b.y;
```

### Scoring & Lives
- Each food dot eaten = **+1 point**
- Touching any ghost = **-1 life** + position reset
- Reaching **0 lives** = Game Over screen
- Eating **all food dots** = map reloads (next round begins)

---

## 🛠️ Built With

| Technology | Purpose |
|-----------|---------|
| **Java** | Core programming language |
| **Java Swing** (`JPanel`, `JFrame`) | Window creation and game rendering |
| **AWT** (`Graphics`, `KeyListener`, `Timer`) | Drawing, keyboard input, and game loop |
| **HashSet** | Efficient storage and iteration of walls, food, and ghosts |

---

## 📌 Known Limitations

- Ghost AI is fully **randomized** — no pathfinding or chase behavior toward Pac-Man
- `scaredGhost.png`, `powerFood.png`, `cherry.png`, and `cherry2.png` assets are included but **power-up mechanics are not yet implemented**
- No **high score persistence** between game sessions
- No **audio or sound effects**

---

## 🔮 Planned Improvements

- [ ] Power pellet mechanic — ghosts enter scared mode and become vulnerable
- [ ] Cherry and bonus item pickups for extra points
- [ ] Smarter ghost AI using BFS/A* pathfinding
- [ ] High score saving to a local file
- [ ] Sound effects using `javax.sound`
- [ ] Multiple levels with increasing difficulty and speed
- [ ] Animated Pac-Man mouth open/close sprite cycling

---

## 👤 Author

**Shahriar Tahmid**
Software Engineering Student | Backend Developer | Problem Solver
📍 Dhaka, Bangladesh

🏆 **Ranked 8th** — DIU Code Tarp Spring 2025 Programming Contest

[![GitHub](https://img.shields.io/badge/GitHub-ShahriarXProxima-181717?style=flat&logo=github)](https://github.com/ShahriarXProxima)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-Shahriar%20Tahmid-0A66C2?style=flat&logo=linkedin)](https://www.linkedin.com/in/shahriar-tahmid-a489bb3b0/)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

> *"First, solve the problem. Then, write the code."* — John Johnson
