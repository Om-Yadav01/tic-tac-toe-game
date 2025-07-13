# Tic Tac Toe Game

A simple Tic Tac Toe game built with React frontend and Java Spring Boot backend.

## Project Structure

```
├── src/                    # React frontend
│   ├── App.js             # Main React component
│   ├── index.js           # React entry point
│   └── index.css          # Styling
├── public/                # Static files
│   └── index.html         # HTML template
├── backend/               # Java Spring Boot backend
│   ├── src/main/java/com/tictactoe/
│   │   ├── TicTacToeApplication.java
│   │   ├── controller/GameController.java
│   │   ├── service/GameService.java
│   │   └── model/GameState.java
│   ├── src/main/resources/application.properties
│   └── pom.xml
├── package.json           # React dependencies
└── README.md
```

## Features

- Clean and simple UI
- Real-time game state management
- Win detection for rows, columns, and diagonals
- Draw detection
- Game reset functionality
- Responsive design

## How to Run

### Prerequisites

- Node.js (for React frontend)
- Java 11+ and Maven (for Spring Boot backend)

### Running the Backend

1. Navigate to the backend directory:
   ```bash
   cd backend
   ```

2. Build and run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

   The backend will start on `http://localhost:8080`

### Running the Frontend

1. Install React dependencies:
   ```bash
   npm install
   ```

2. Start the React development server:
   ```bash
   npm start
   ```

   The frontend will start on `http://localhost:3000`

## API Endpoints

- `GET /api/game/state` - Get current game state
- `POST /api/game/move/{position}` - Make a move (position 0-8)
- `POST /api/game/reset` - Reset the game

## How to Play

1. Open your browser and go to `http://localhost:3000`
2. Players take turns clicking on empty squares
3. X goes first, followed by O
4. Get three in a row (horizontally, vertically, or diagonally) to win
5. If all squares are filled without a winner, it's a draw
6. Click "Reset Game" to start a new game

## Technologies Used

- **Frontend**: React 18, CSS3
- **Backend**: Java 11, Spring Boot 2.7.0
- **Build Tools**: Maven, npm 