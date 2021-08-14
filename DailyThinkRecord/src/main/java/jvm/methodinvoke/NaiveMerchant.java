package jvm.methodinvoke;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/11 22:28
 */
public class NaiveMerchant extends Merchant {
    // javap -v 这个类的class 会生成一个ACC_BRIDGE的桥接方法
    @Override
    public Double actionPrice(double price, Customer customer) {
        if (customer.isVip()) {
            return price * 1.8;
        }
        return price;
    }
}
