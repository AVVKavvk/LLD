package Strategy;

public class ShoppingCart {

    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount){
        if (paymentStrategy == null) {
            System.out.println("Checkout failed: Please select a payment method.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}
