package Game;

import java.util.ArrayList;
import java.util.List;


public class Player implements Runnable {
    private String name;
    private Game game;
    private int points = 0;
    int ratio = -1;
    private boolean finished = false;
    List<Token> progression = new ArrayList<Token>();

    public Player(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (!this.finished) {
            synchronized (game.board) {
                if (game.isOver()) {
                    return;
                }
                boolean madeMove = false;
                for (Token token : game.board.tokens) {
                    if (!madeMove) {
                        if (!token.isUsed()) {
                            if (progression.size() < 2) {
                                if (token.getContent() < 0)
                                    continue;
                                progression.add(token);
                                points += 1;
                                token.setUsed(true);
                                System.out.println(name + ": added token " + token.getContent());
                                if (progression.size() == 2)
                                    ratio = progression.get(1).getContent() - progression.get(0).getContent();
                                if (game.board.getNumberOfAvailableTokens() == 0)
                                    game.setOver(true);
                                madeMove = true;
                                break;
                            } else {
                                if (token.getContent() == progression.get(progression.size() - 1).getContent() + ratio || token.getContent() < 0) {
                                    if (token.getContent() < 0)
                                        token.setContent(progression.get(progression.size() - 1).getContent() + ratio);
                                    progression.add(token);
                                    points += 1;
                                    token.setUsed(true);
                                    System.out.println(name + ":  " + token.getContent());
                                    if (game.board.getNumberOfAvailableTokens() == 0)
                                        game.setOver(true);
                                    madeMove = true;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (!madeMove) {
                    System.out.println(name + " can't choose anoter piece!");
                    finished = true;
                }
                if (progression.size() == game.maxProgression) {
                    game.maxProgEnd(this);
                    game.setOver(true);
                }
                if (game.allFinished())
                    game.setOver(true);
            }
            try {
                Thread.sleep(1050);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}