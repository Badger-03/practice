package myfirstpackage;

public class MySecondClass {
    private int firstValue;
    private int secondValue;

    public MySecondClass(int firstValue, int secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public void setFirstValue(int value) {
        this.firstValue = value;
    }

    public void setSecondValue(int value) {
        this.secondValue = value;
    }

    public int bitwiseXOR() {
        return this.firstValue ^ this.secondValue;
    }
}