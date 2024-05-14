package wrap.javadesignpatterns.decorator2;

public class CheeseToppings extends ToppingsDecorator{
    Pizza pizza;

    public CheeseToppings(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    int calculatePrice() {
        return this.pizza.calculatePrice()+50;
    }
}
