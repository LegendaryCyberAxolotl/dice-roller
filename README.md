# Meaningful names distinguishing Element vs. Visitor responsibilities

`Dice` - represents element interface

`D4`, `D6`, `D20` - represent concrete elements

`Visitor` - represents the idea and show that classes that implemetn this interface are visitors

`DoceRoller`, `DiceStats` - represent what operations these visitors do

# No instanceof/type-checking chains anywhere (double dispatch fully replaces them)

> Main.java
```java
for (Dice dice : diceList) {
    dice.accept(roller);
    System.out.println("");
}
```

> D20.java
```java
public void accept(Visitor visitor) {
    visitor.visitD20(this);
}
```

> DiceRoller.java
```java
public void visitD20(D20 d20) {
    int roll = generator.nextInt(d20.getMaxValue()) + 1;
    System.out.println("Rolled a D20");
    System.out.println("Result: " + roll);
}
```

No type-checking, client calls a method of the dice that calls visitor's method that implements operation for this exact dice.

# Single Responsibility: each Concrete Visitor implements exactly one operation across all element types

> DiceRoller.java
```java
@Override
public void visitD20(D20 d20) {
    System.out.println("D20 max value: " + d20.getMaxValue());
    int middleValue = (int) d20.getMaxValue() / 2;
    System.out.println("D20 middle value: " + middleValue);
}
```

> DiceStats.java
```java
@Override
public void visitD20(D20 d20) {
    System.out.println("D20 max value: " + d20.getMaxValue());
    int middleValue = (int) d20.getMaxValue() / 2;
    System.out.println("D20 middle value: " + middleValue);
}
```

Each visitor does its own job and implements only one operation for each element type.

# Minimal, well-justified encapsulation trade-offs (note where a Visitor needs access to element internals, and how you handled it)

- Each elements' field is private

- To get needed information about an element for visitors, there are getter methods for each field

- visitors don't interract with or modifie elements' fields directly, they interract with elements through special methods.

> DiceRoller.java
```java
@Override
public void visitD20(D20 d20) {
    System.out.println("D20 max value: " + d20.getMaxValue());
    int middleValue = (int) d20.getMaxValue() / 2;
    System.out.println("D20 middle value: " + middleValue);
}
```

> DiceStats.java
```java
@Override
public void visitD20(D20 d20) {
    System.out.println("D20 max value: " + d20.getMaxValue());
    int middleValue = (int) d20.getMaxValue() / 2;
    System.out.println("D20 middle value: " + middleValue);
}
```

> D20.java
```java
public int getMaxValue() {
    return maxValue;
}
```

In visitor pattern, visitors need elements' information to implement operations. Instead of making elements' fields public, visitors use getter method.

# Demonstrated extensibility: adding a third visitor requires no change

Adding new visitors doesn't require any changes to existing classes or interfaces. For example let's create new visitor.

> SumValues.java
```java
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
```

Add new triverse in client:

```java
SumValues sum = new SumValues();

for (Dice dice : diceList) {
    dice.accept(sum);
    System.out.println("");
}
```

> Output in terminal:
```terminal
Sum of values for D4: 10

Sum of values for D6: 21

Sum of values for D20: 210
```

Everything works without changing anything in the code.