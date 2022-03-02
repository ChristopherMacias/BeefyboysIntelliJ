package christopher.macias.connect.model;

public class Player {
    private String Name;
    private TokenColor tokenColor;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public TokenColor getTokenColor() {
        return tokenColor;
    }

    public void setTokenColor(TokenColor tokenColor) {
        this.tokenColor = tokenColor;
    }

    @Override
    public String toString() {
        return "players name: " + this.getName();
    }
}
