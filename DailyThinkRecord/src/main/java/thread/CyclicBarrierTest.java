package thread;

import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Nannf
 * @date 2021/6/30 11:12
 * @description
 */
public class CyclicBarrierTest {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    CyclicBarrier cyclicBarrier = new CyclicBarrier(2,()-> {
        postDeal();
    });

    private void postDeal() {
        // 查找出表一和表二的差异
        List<String> diff = findDiffInfo(tableOneData,tableTwoData);
        // 把差异的内容写进表三
        saveData(diff);
    }

    List<String> tableOneData;
    List<String> tableTwoData;
    public void process() throws InterruptedException {
        executorService.submit(() -> {
            tableOneData = queryTableOne();
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        });
        executorService.submit(() -> {
            tableTwoData = queryTableTwo();
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        } );

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
