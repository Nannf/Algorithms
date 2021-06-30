package thread;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Nannf
 * @date 2021/6/30 9:16
 * @description
 */
public class CountDownLatchTest {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    CountDownLatch downLatch = new CountDownLatch(2);
    List<String> tableOneData;
    List<String> tableTwoData;
    public void process() throws InterruptedException {
        executorService.submit(() -> {
            tableOneData = queryTableOne();
            downLatch.countDown();
        });
        executorService.submit(() -> {
            tableTwoData = queryTableTwo();
            downLatch.countDown();
        } );

        downLatch.await();
        // 查找出表一和表二的差异
        List<String> diff = findDiffInfo(tableOneData,tableTwoData);
        // 把差异的内容写进表三
        saveData(diff);
    }

    private void saveData(List<String> diff) {
    }

    private List<String> findDiffInfo(List<String> tableOneData, List<String> tableTwoData) {
        return null;
    }

    private List<String> queryTableTwo() {
        return null;
    }

    private List<String> queryTableOne() {
        return null;
    }
}
