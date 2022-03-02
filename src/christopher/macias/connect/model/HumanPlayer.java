package christopher.macias.connect.model;

public class HumanPlayer extends Player {
    //user input column selections

    String name;

    public HumanPlayer() {
        super.getName();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
