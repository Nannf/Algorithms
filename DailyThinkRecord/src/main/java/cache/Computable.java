package cache;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/8/5 21:59
 */
public interface Computable<A, V> {

    V compute(A args) throws InterruptedException;
}
