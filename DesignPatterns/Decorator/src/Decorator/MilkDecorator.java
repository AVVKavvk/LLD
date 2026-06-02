package Decorator;

public class MilkDecorator implements Coffee{
    private Coffee coffee;

    public MilkDecorator(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return this.coffee.getDescription() + ", Milk";
    }

    @Override
    public int getCost() {
        return this.coffee.getCost() + 2;
    }
}
