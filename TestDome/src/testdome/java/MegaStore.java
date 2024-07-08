package testdome.java;

public class MegaStore {

    public enum DiscountType {
        Standard,//discount 6%, weight any
        Seasonal,// discount 12%, weight any
        Weight;//discount 6%, weight <= 10, discount 18%, weight >10
    }

    public static double getDiscountedPrice(double cartWeight,
                                            double totalPrice,
                                            DiscountType discountType) {
double discount = 0;

        switch(discountType)
        {
        case DiscountType.Standard:
            discount = 0.06;
            break;
        case DiscountType.Seasonal:
            discount = 0.12;
            break;
        case DiscountType.Weight:
            if(cartWeight <= 10){
                discount = 0.06;
            }else{
                discount = 0.18;
            }
            break;
    }
        return totalPrice * (1-discount);
}

    public static void main(String[] args) {
        System.out.println(getDiscountedPrice(12, 100, DiscountType.Weight));
    }
}
