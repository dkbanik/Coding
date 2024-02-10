package lowleveldesign.splitwise.model;

public class SplitwiseUser {
    public final int id;
    public final String name;
    public UserBalanceSheet balanceSheet;

    public SplitwiseUser(int id, String name) {
        this.id = id;
        this.name = name;
        this.balanceSheet = new UserBalanceSheet();
    }

    @Override
    public String toString() {
        return "SplitwiseUser{" +
                "name='" + name + '\'' +
                '}';
    }
}
