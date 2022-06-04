package company.A4A.matcher;

public enum Category {
    EXACT(3),
    PARTIAL(2),
    ONLY(1);

    private int value;
    Category(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
