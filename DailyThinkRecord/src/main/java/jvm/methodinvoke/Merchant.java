package jvm.methodinvoke;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/11 22:27
 */
public class Merchant {
    public Number actionPrice(double price, Customer customer) {
        if(customer.isVip()) {
            return price * 0.8;
        }
        return price;
    }
}
