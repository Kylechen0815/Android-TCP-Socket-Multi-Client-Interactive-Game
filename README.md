# Android TCP Socket Multi-Client Interactive Game

A distributed, client-server Android application demonstrating low-level network programming via TCP Sockets. The project is implemented in Kotlin and leverages Kotlin Coroutines for asynchronous, non-blocking network I/O, enabling real-time bidirectional communication between a game host, relay server, and multiple player clients.

---

## Architecture Overview

The system is organized into a modular client-server topology:

1. **Central Relay Server (`myapplicationserverpart` / `server.kt`)**:
   - Binds to a dedicated port (default: 54000) via `ServerSocket`.
   - Listens for incoming socket connections and acts as a central message broker.
   - Forwards drawing events emitted by the Host client to all actively connected Player clients without UI thread blocking.

2. **Host Client (`host_part.kt`)**:
   - Acts as the game organizer.
   - Transmits selected winning numbers sequentially through an output stream across the established TCP connection.

3. **Player Client (`join_part.kt` & `resultrace.kt`)**:
   - Allows participants to pick 6 initial target numbers.
   - Connects to the host/server IP and port.
   - Reads incoming data streams in real time, compares received numbers against the local selection, and triggers dynamic UI state transitions.

---

## Gameplay and Logic Flow

1. **Initial Selection**:
   - The player selects 6 distinct numbers on an interactive grid and taps Start to enter the waiting state.
2. **Draw Broadcasting**:
   - The game host selects and publishes drawn numbers one by one.
   - The server instantly broadcasts each drawn number to all connected players over TCP.
3. **Dynamic State Reflection**:
   - When a drawn number matches a player's picked number, that grid button updates immediately to green (`Color.GREEN`).
   - If the drawn number was not selected, it is highlighted in pink (`#FFC0CB`).
4. **Victory Condition**:
   - Once a player matches 4 numbers, the system evaluates the state and triggers the victory screen (`resultrace.kt`).

---

## User Interface and Screenshots

### Client Setup and Connection
<img width="2000" height="2828" alt="Client Connection Interface" src="https://github.com/user-attachments/assets/6d6cfc3f-932b-4afa-b572-b25abfab0468" />
<img width="2000" height="2828" alt="Host Control Panel" src="https://github.com/user-attachments/assets/9f7031cc-58a6-4951-90bf-a87af318038f" />

### Real-Time Gameplay and Dynamic Feedback
<img width="2000" height="2828" alt="Game Number Grid State" src="https://github.com/user-attachments/assets/710edd57-5075-4864-bd32-69ca26d938e5" />
<img width="2000" height="2828" alt="Victory Evaluation" src="https://github.com/user-attachments/assets/85a89357-deba-4b2e-8052-80f13770fd0d" />

---

## Technical Implementation Details

- **Concurrency & Non-blocking I/O**:
  Network socket operations (`Socket`, `ServerSocket`, `InputStreamReader`, `BufferedReader`, `PrintWriter`) are strictly isolated from the main thread using `CoroutineScope(Dispatchers.IO)`. UI mutations are dispatched back to the main thread via `Dispatchers.Main`.
- **State Management**:
  Dynamic button tinting and state verification utilize `ColorStateList` and Android View bindings, updating UI components asynchronously as TCP packets arrive.
- **Protocol Payload**:
  Lightweight text-based payload transmission ensuring minimal latency and zero overhead across local network interfaces.

---

## Tech Stack

- **Platform**: Android OS
- **Language**: Kotlin
- **Build System**: Gradle (Kotlin DSL - `.gradle.kts`)
- **Core Frameworks & APIs**:
  - `java.net.Socket`, `java.net.ServerSocket` (Network Communication)
  - `kotlinx.coroutines` (Asynchronous Thread Management)
  - Android Jetpack (`AppCompatActivity`, `ViewCompat`, `WindowInsetsCompat`)
  - Material Design Components

---

## Project Structure

```text
android_studio_TCP_project/
├── app/                              # Android Client Application
│   └── src/main/java/com/example/homeweork1/
│       ├── MainActivity.kt           # Role selection entry point (Host / Player)
│       ├── host_part.kt              # Host game controls and broadcast sender
│       ├── join_part.kt              # Player client logic, grid selection, and receiver
│       ├── resultrace.kt             # Game outcome evaluation
│       └── server.kt                 # In-app server runner
├── myapplicationserverpart/          # Dedicated Standalone Server Module
│   └── src/main/java/com/example/myapplicationserverpart/
│       └── socketserver.kt           # TCP server listening and packet routing
├── build.gradle.kts
└── settings.gradle.kts
