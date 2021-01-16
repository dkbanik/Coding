package problems;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

    public static Map<String,Integer> currencyMapper = new HashMap<>();

    public static void main(String[] args) {

        // currency node takes name and cost as two params
        CurrencyNode baseCurrency = new CurrencyNode("C1", 1);
        baseCurrency.setParent(baseCurrency);

        baseCurrency.addChild(new CurrencyNode("C2",2));
        baseCurrency.addChild(new CurrencyNode("C4", 3));
        baseCurrency.addChild(new CurrencyNode("C3",1));

        baseCurrency.getChildren().get(0).addChild(new CurrencyNode("C5",5));
        baseCurrency.getChildren().get(0).addChild(new CurrencyNode("C6",2));

        baseCurrency.getChildren().get(2).addChild(new CurrencyNode("C7",4));

        updateCurrencyCost(baseCurrency);

        System.out.println("Answer: "+String.format("%.3f",currencyConvert("C5","C4")));

    }

    private static void printCurrencyTreeWithCost(CurrencyNode baseCurrency) {
        if(baseCurrency == null)return;
        System.out.println(baseCurrency.getName()+"--->"+baseCurrency.getCost());
        for(CurrencyNode child : baseCurrency.getChildren()){
            printCurrencyTreeWithCost(child);
        }
    }

    private static void updateCurrencyCost(CurrencyNode baseCurrency) {
        if(baseCurrency == null)return;
        baseCurrency.setCost(baseCurrency.getParent().getCost()*baseCurrency.getCost());
        currencyMapper.put(baseCurrency.getName(), baseCurrency.getCost());
        for(CurrencyNode child : baseCurrency.getChildren()){
            updateCurrencyCost(child);
        }
    }


    private static double currencyConvert(String c1, String c2) {
        return new Double(currencyMapper.get(c2))/new Double(currencyMapper.get(c1));
    }


}
