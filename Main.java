import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        List<Dice> diceList = new ArrayList<>();

        diceList.add(new D4());
        diceList.add(new D6());
        diceList.add(new D20());

        DiceRoller roller = new DiceRoller();
        DiceStats stats = new DiceStats();
        SumValues sum = new SumValues();

        for (Dice dice : diceList) {
            dice.accept(roller);
            System.out.println("");
        }

        for (Dice dice : diceList) {
            dice.accept(stats);
            System.out.println("");
        }

        for (Dice dice : diceList) {
            dice.accept(sum);
            System.out.println("");
        }
    }
}
