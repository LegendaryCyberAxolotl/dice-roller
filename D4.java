public class D4 implements Dice {
    private int maxValue = 4;

    public int getMaxValue() {
        return maxValue;
    }

    public void accept(Visitor visitor) {
        visitor.visitD4(this);
    }
}
