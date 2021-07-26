package thread.concurrency;

/**
 * @author Akmd Nannf
 * @version v1.0
 * @Description
 * @date 2021/7/24 21:13
 */
public class Holder {
    private int n;
    public Holder(int n) {
        this.n = n;
    }
    public void assertSanity() {
        if (n != n)
            throw new AssertionError("This statement is false.");
    }
}

