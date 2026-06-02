import Decorator.Coffee;
import Decorator.MilkDecorator;
import Decorator.SimpleCoffee;

void main() {
    Coffee myCoffee = new SimpleCoffee();
    myCoffee = new MilkDecorator(myCoffee);
    System.out.println(myCoffee.getDescription() + " $" + myCoffee.getCost());
}