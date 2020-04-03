package Game;

public class Token {
    private boolean used;
    private int content;

    public Token(int content) {
        this.content = content;
        this.used = false;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isUsed() {
        return used;
    }


    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }
}