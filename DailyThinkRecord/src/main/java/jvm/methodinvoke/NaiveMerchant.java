package jvm.methodinvoke;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/11 22:28
 */
public class NaiveMerchant extends Merchant {
    @Override
    public Double actionPrice(double price, Customer customer) {
        if (customer.isVip()) {
            return price * 1.8;
        }
        return price;
    }
}
