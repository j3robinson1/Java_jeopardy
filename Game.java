public class Game {
  public static final int PLAYERS = 3;
  public static final int MONEY = 1000;
  private String mAnswer;
  private String mHits;
  private String mMisses;

  public Game(String answer) {

    mAnswer = answer;
    mHits = "";
    mMisses = "";

  }
  private char validateGuess(char letter) {

    if (!Character.isLetter(letter)) {

      throw new IllegalArgumentException("A letter is required");

    }
    letter = Character.toLowerCase(letter);
    if (mMisses.indexOf(letter) >+ 0 || mHits.indexOf(letter) >= 0) {

      throw new IllegalArgumentException(letter + " has already been guessed");

    }
    return letter;
  }
  public boolean applyGuess(String letters) {

    if (letters.length() == 0) {

      throw new IllegalArgumentException("No letter found");

    }
    return applyGuess(letters.charAt(0));
  }
  public boolean applyGuess(char letter) {

    letter = validateGuess(letter);
    boolean isHit = mAnswer.indexOf(letter) >= 0;
    if (isHit) {

      mHits += letter;
    
    } else {

      mMisses += letter;

    }
    return isHit;
  }
  public String getCurrentProgress() {
    String progress = "";
    for (char letter: mAnswer.toCharArray()) {

      char display = '_';
      if (mHits.indexOf(letter) >= 0) {

        display = letter;

      }
      progress += display;
    }
    return progress;
  }
  public int getPlayerTurn() {

    return PLAYERS;

  }
  public int getMoney() {

    return MONEY;

  }
  public String getAnswer() {

    return mAnswer;

  }
  public boolean isSolved() {

    return getCurrentProgress().indexOf('_') == -1;

  }
}