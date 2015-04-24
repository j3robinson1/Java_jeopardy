import java.io.Console;

public class Prompter {

  private Game mGame;

  public Prompter(Game game) {

    mGame = game;

  }
  public void play() {

    while (!mGame.isSolved()) {

      displayProgress();
      promptForGuess();

    }
    if (mGame.isSolved()) {

      System.out.printf("Congratulations you won with $%d", mGame.getMoney());

    } else {

      System.out.printf("You lost $%d", mGame.getMoney());

    }
  }
  public boolean promptForGuess() {

    Console console = System.console();
    boolean isHit = false;
    boolean isValidGuess = false;
    while (!isValidGuess) {

      String guessAsString = console.readLine("Enter a letter:  ");
      try {

        isHit = mGame.applyGuess(guessAsString);
        isValidGuess = true;

      } catch (IllegalArgumentException iae) {

        console.printf("%s. please try again.\n", iae.getMessage());

      }

    }
    return isHit;
  } 
  public void displayProgress() {

    System.out.printf("You have $%d. To solve: %s\n", mGame.getMoney(), mGame.getCurrentProgress());

  }
}