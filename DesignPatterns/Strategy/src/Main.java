import Strategy.CreditCardPayment;
import Strategy.PayPalPayment;
import Strategy.ShoppingCart;

void main() {
    ShoppingCart cart = new ShoppingCart();
    int totalAmount = 150;

    // User chooses to pay with Credit Card
    cart.setPaymentStrategy(new CreditCardPayment("Vipin Kumawat", "1234-5678-9012-3456"));
    cart.checkout(totalAmount);

    // User decides to change to PayPal instead
    cart.setPaymentStrategy(new PayPalPayment("v@vipinkumawat.xyz"));
    cart.checkout(totalAmount);
}