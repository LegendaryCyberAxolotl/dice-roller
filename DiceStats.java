public class DiceStats {
    public void visitD4(D4 d4) {
        System.out.println("D4 max value: " + d4.getMaxValue());
        int middleValue = (int) d4.getMaxValue() / 2;
        System.out.println("D4 middle value: " + middleValue);
    }

    public void visitD6(D6 d6) {
        System.out.println("D6 max value: " + d6.getMaxValue());
        int middleValue = (int) d6.getMaxValue() / 2;
        System.out.println("D6 middle value: " + middleValue);
    }

    public void visitD20(D20 d20) {
        System.out.println("D20 max value: " + d20.getMaxValue());
        int middleValue = (int) d20.getMaxValue() / 2;
        System.out.println("D20 middle value: " + middleValue);
    }
}
