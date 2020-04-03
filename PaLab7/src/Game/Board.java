package Game;

import java.util.ArrayList;
import java.util.List;


public class Board {
    int n, m;
    List<Token> tokens = new ArrayList<Token>();

    public int getNumberOfAvailableTokens() {
        int result = 0;
        for (Token token : tokens)
            if (!token.isUsed())
                result++;
        return result;
    }

    public Board(int n) {
        this.n = n;
        this.m = n;
        for (int i = 1; i <= n; i++) {
            Token token = new Token(i);
            tokens.add(token);
        }
    }

    public Board(List<Integer> vals) {
        for (Integer i : vals) {
            Token token = new Token(i);
            tokens.add(token);
        }
    }

}