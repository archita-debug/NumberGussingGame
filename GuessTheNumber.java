package task2;
import javax.swing.*;
import java.util.Random;

public class GuessTheNumber {

    public static void main(String[] args) {
        int totalScore = 0;
        int totalRounds = 0;

        String roundsInput = JOptionPane.showInputDialog(null, "How many rounds do you want to play?", "Rounds", JOptionPane.QUESTION_MESSAGE);
        int maxRounds;

        try {
            maxRounds = Integer.parseInt(roundsInput);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Defaulting to 3 rounds.");
            maxRounds = 3;
        }

        while (totalRounds < maxRounds) {
            totalRounds++;
            int randomNumber = new Random().nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                String guessInput = JOptionPane.showInputDialog(null,
                        "Round " + totalRounds + " - Attempt " + (attempts + 1) +
                        "\nGuess a number between 1 and 100:", "Guess the Number",
                        JOptionPane.QUESTION_MESSAGE);

                int guess;
                try {
                    guess = Integer.parseInt(guessInput);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number!");
                    continue;
                }

                attempts++;

                if (guess == randomNumber) {
                    guessedCorrectly = true;
                    int scoreThisRound = 11 - attempts;
                    totalScore += scoreThisRound;
                    JOptionPane.showMessageDialog(null, "Correct! You guessed it in " + attempts +
                            " attempts.\nYou earned " + scoreThisRound + " points.");
                    break;
                } else if (guess > randomNumber) {
                    JOptionPane.showMessageDialog(null, "Too high! Try again.");
                } else {
                    JOptionPane.showMessageDialog(null, "Too low! Try again.");
                }
            }

            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(null, "Sorry! You've used all attempts. The number was " + randomNumber + ".");
            }
        }

        JOptionPane.showMessageDialog(null, "🎮 Game Over!\nRounds played: " + totalRounds + "\nTotal Score: " + totalScore);

        int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
        if (playAgain == JOptionPane.YES_OPTION) {
            main(null); // Restart the game
        } else {
            JOptionPane.showMessageDialog(null, "Thanks for playing! 👋");
            System.exit(0);
        }
    }
}