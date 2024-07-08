package testdome.java;

import java.util.ArrayList;
import java.util.List;

//correct
public class IceCreamMachine {
    public String[] ingredients;
    public String[] toppings;

    public static class IceCream {
        public String ingredient;
        public String topping;

        public IceCream(String ingredient, String topping) {
            this.ingredient = ingredient;
            this.topping = topping;
        }
    }

    public IceCreamMachine(String[] ingredients, String[] toppings) {
        this.ingredients = ingredients;
        this.toppings = toppings;
    }

    //implement scoop method
    public List<IceCream> scoops() {
        List<IceCream> iceCreams = new ArrayList<>();
        for(String ingredient : ingredients){
            for(String topping : toppings){
                IceCream iceCream = new IceCream(ingredient, topping);
                iceCreams.add(iceCream);
            }
        }
        return iceCreams;
    }

    public static void main(String[] args) {
        IceCreamMachine machine = new IceCreamMachine(new String[]{
                "vanilla", "chocolate"
        }, new String[]{
                "chocolate sauce"
        });
        List<IceCream> scoops = machine.scoops();

        /*
         * Should print:
         * vanilla, chocolate sauce
         * chocolate, chocolate sauce
         */
        for (IceCream iceCream : scoops) {
            System.out.println(iceCream.ingredient + ", " + iceCream.topping);
        }
    }
}
