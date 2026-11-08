public class D6 implements Dice{
    private int maxValue = 6;

    public int getMaxValue() {
        return maxValue;
    }

    public void accept(Visitor visitor) {
        visitor.visitD6(this);
    }
}
