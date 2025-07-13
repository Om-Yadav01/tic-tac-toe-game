import React, { useState } from 'react';

function Square({ value, onClick, isWinning }) {
  return (
    <button 
      className={`square ${isWinning ? 'winning' : ''}`} 
      onClick={onClick}
    >
      {value}
    </button>
  );
}

function Board({ squares, onClick, winningLine }) {
  return (
    <div className="board">
      {squares.map((value, index) => (
        <Square 
          key={index} 
          value={value} 
          onClick={() => onClick(index)}
          isWinning={winningLine && winningLine.includes(index)}
        />
      ))}
    </div>
  );
}

function App() {
  const [squares, setSquares] = useState(Array(9).fill(null));
  const [xIsNext, setXIsNext] = useState(true);

  function calculateWinner(squares) {
    const lines = [
      [0, 1, 2],
      [3, 4, 5],
      [6, 7, 8],
      [0, 3, 6],
      [1, 4, 7],
      [2, 5, 8],
      [0, 4, 8],
      [2, 4, 6],
    ];

    for (let i = 0; i < lines.length; i++) {
      const [a, b, c] = lines[i];
      if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
        return { winner: squares[a], line: lines[i] };
      }
    }
    return null;
  }

  function handleClick(i) {
    const winnerInfo = calculateWinner(squares);
    if (winnerInfo || squares[i]) {
      return;
    }

    const nextSquares = squares.slice();
    nextSquares[i] = xIsNext ? 'X' : 'O';
    setSquares(nextSquares);
    setXIsNext(!xIsNext);
  }

  function resetGame() {
    setSquares(Array(9).fill(null));
    setXIsNext(true);
  }

  const winnerInfo = calculateWinner(squares);
  const isDraw = !winnerInfo && squares.every(square => square !== null);
  
  let status;
  let statusClass = '';
  
  if (winnerInfo) {
    status = `Winner: ${winnerInfo.winner}`;
    statusClass = 'winner';
  } else if (isDraw) {
    status = "It's a draw!";
    statusClass = 'draw';
  } else {
    status = `Next player: ${xIsNext ? 'X' : 'O'}`;
  }

  return (
    <div className="game">
      <h1>Tic Tac Toe</h1>
      <div className={`status ${statusClass}`}>{status}</div>
      <Board 
        squares={squares} 
        onClick={handleClick} 
        winningLine={winnerInfo ? winnerInfo.line : null}
      />
      <button className="reset-button" onClick={resetGame}>
        Reset Game
      </button>
    </div>
  );
}

export default App; 