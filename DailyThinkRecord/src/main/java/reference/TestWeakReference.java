package reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/7/31 8:32
 */
public class TestWeakReference<T> extends WeakReference<Object> {
    public TestWeakReference(Object referent) {
        super(referent);
    }

    public TestWeakReference(Object referent, ReferenceQueue<? super Object> q) {
        super(referent, q);
    }
}
