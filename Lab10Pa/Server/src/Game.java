import java.util.Random;

public class Game {
    private String player;
    private int number;
    private int attempts;
    private int randomNumber;

    /**
     * Constructori
     * @param player
     * @param number
     */
    Game( String player , int number ) {
        this.player = player;
        this.number = number;
        attempts = 0;
        randomNumber = new Random().nextInt(number) + 1;
    }

    public String getPlayer() {
        return player;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getNumber() {
        return number;
    }

    public int getRandomNumber() {
        return randomNumber;
    }


    /**
     * Functia submit care trimite numarul la server
     * @param number
     * return String
     */
    String submit( int number ) {
        attempts++;
        if( number < this.randomNumber )
            return "Too small";
        else if ( number > this.randomNumber )
            return "Too big";
        else
            return "You got it!";
    }
}
