public class SumValues implements Visitor {

    @Override 
    public void visitD4(D4 d4) {
        int sum = 0;
        for (int i = 1; i <= d4.getMaxValue(); i++) {
            sum += i;
        }

        System.out.println("Sum of values for D4: " + sum);
    }

    @Override 
    public void visitD6(D6 d6) {
        int sum = 0;
        for (int i = 1; i <= d6.getMaxValue(); i++) {
            sum += i;
        }

        System.out.println("Sum of values for D6: " + sum);
    }

    @Override 
    public void visitD20(D20 d20) {
        int sum = 0;
        for (int i = 1; i <= d20.getMaxValue(); i++) {
            sum += i;
        }

        System.out.println("Sum of values for D20: " + sum);
    }
}
