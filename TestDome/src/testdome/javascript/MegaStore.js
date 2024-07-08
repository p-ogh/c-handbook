const DiscountType = {
  Standard: "Standard",
  Seasonal: "Seasonal",
  Weight: "Weight"
};

function getDiscountedPrice(cartWeight, totalPrice, discountType) {
let discount = 0;

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
        return totalPrice * (1-discount);}

console.log(getDiscountedPrice(12, 100, DiscountType.Weight));