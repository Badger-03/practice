class MyFirstClass {
    public static void main(String[] args) {
        MySecondClass o = new MySecondClass(0, 0);

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                o.setFirstValue(i);
                o.setSecondValue(j);
                System.out.print(o.bitwiseXOR());
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}

class MySecondClass {
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
