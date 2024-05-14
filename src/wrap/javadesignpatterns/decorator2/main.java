package wrap.javadesignpatterns.decorator2;

public class main {
    public static void main(String[] args) {
        Pizza pizza = new Margarita();
        Pizza addCheese = new CheeseToppings(pizza);
        System.out.println(addCheese.calculatePrice());
    }
}
