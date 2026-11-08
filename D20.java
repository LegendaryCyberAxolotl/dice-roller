public class D20 implements Dice {
    private int maxValue = 20;

    public int getMaxValue() {
        return maxValue;
    }

    public void accept(Visitor visitor) {
        visitor.visitD20(this);
    }
}
