import java.util.HashMap;

public class SnakesLadders {
    private int jugador1 = 0;
    private int jugador2 = 0;
    private boolean turnoJugador1 = true;
    private boolean finished = false;
    private HashMap<Integer, Integer> diccionario_serpientes;
    private HashMap<Integer, Integer> diccionario_escaleras;

    public SnakesLadders() {
        diccionario_serpientes = new HashMap<>();
        diccionario_serpientes.put(99, 80);
        diccionario_serpientes.put(95, 75);
        diccionario_serpientes.put(92, 88);
        diccionario_serpientes.put(89, 68);
        diccionario_serpientes.put(74, 53);
        diccionario_serpientes.put(64, 60);
        diccionario_serpientes.put(62, 19);
        diccionario_serpientes.put(49, 11);
        diccionario_serpientes.put(46, 25);
        diccionario_serpientes.put(16, 6);
        
        diccionario_escaleras = new HashMap<>();
        diccionario_escaleras.put(2, 38);
        diccionario_escaleras.put(7, 14);
        diccionario_escaleras.put(8, 31);
        diccionario_escaleras.put(15, 26);
        diccionario_escaleras.put(21, 42);
        diccionario_escaleras.put(28, 84);
        diccionario_escaleras.put(36, 44);
        diccionario_escaleras.put(51, 67);
        diccionario_escaleras.put(71, 91);
        diccionario_escaleras.put(78, 98);
        diccionario_escaleras.put(87, 94);
    }

    public String play(int die1, int die2) {
        String message;
        int sum = die1 + die2;
      
        if (finished) {
            return "Game over!";
        }
        
        int currentPosition = turnoJugador1 ? jugador1 : jugador2;

        

        currentPosition += sum;

        if (currentPosition == 100) {
            finished = true;
            return turnoJugador1 ? "Player 1 Wins!" : "Player 2 Wins!";
        } else if (currentPosition > 100) {
            currentPosition = 200 - currentPosition; 
        }

        if (diccionario_serpientes.containsKey(currentPosition)) {
            currentPosition = diccionario_serpientes.get(currentPosition);
        }
      
        if (diccionario_escaleras.containsKey(currentPosition)) {
            currentPosition = diccionario_escaleras.get(currentPosition);
        }

        if (currentPosition == 100) {
            return turnoJugador1 ? "Player 1 Wins!" : "Player 2 Wins!";
        }
        
        if (turnoJugador1) {
            jugador1 = currentPosition;
        } else {
            jugador2 = currentPosition;
        }

        message = turnoJugador1 ? "Player 1 is on square " + jugador1 : "Player 2 is on square " + jugador2;

        if (die1 != die2) {
            turnoJugador1 = !turnoJugador1;
        }

        return message;
    }
}