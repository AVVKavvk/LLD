package Facade;

public class CheckoutFacade {

    public CheckoutFacade(){}

    public void placeOrder(){
        System.out.println("Calling Inventory");
        System.out.println("Calling Payment");
        System.out.println("Calling Shipping");
    }
}
