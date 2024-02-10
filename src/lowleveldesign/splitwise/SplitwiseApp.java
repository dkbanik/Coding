package lowleveldesign.splitwise;

import lowleveldesign.splitwise.service.SplitwiseService;

public class SplitwiseApp {
    public static void main(String[] args) {
        SplitwiseService splitwiseApp = new SplitwiseService();
        splitwiseApp.createServices();
        splitwiseApp.showGroupBalance();
        splitwiseApp.userService.displayBalanceSheet(1);
        splitwiseApp.userService.displayBalanceSheet(2);
        splitwiseApp.userService.displayBalanceSheet(3);
        //splitwiseApp.showGroupBalance();

        splitwiseApp.showSimplifyExpense();
    }
}
