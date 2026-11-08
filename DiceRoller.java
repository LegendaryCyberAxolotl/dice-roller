import java.util.Random;

public class DiceRoller implements Visitor {
    private Random generator;

    public DiceRoller() {
        generator = new Random();
    }

    @Override 
    public void visitD4(D4 d4) {
        int roll = generator.nextInt(d4.getMaxValue()) + 1;
        System.out.println("Rolled a D4");
        System.out.println("Result: " + roll);
    }
    
    @Override
    public void visitD6(D6 d6) {
        int roll = generator.nextInt(d6.getMaxValue()) + 1;
        System.out.println("Rolled a D6");
        System.out.println("Result: " + roll);
    }

    @Override
    public void visitD20(D20 d20) {
        int roll = generator.nextInt(d20.getMaxValue()) + 1;
        System.out.println("Rolled a D20");
        System.out.println("Result: " + roll);
    }
}
