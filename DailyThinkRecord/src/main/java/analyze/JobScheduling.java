package analyze;

/**
 * @author Nannf
 * @version v1.0
 * @Description 工作调度问题
 * @date 2021/8/21 20:33
 */
public class JobScheduling {

    // 对每一个节点而言，我们都可以选择选取或者不选取
    // 首先我们定义递归函数的含义，我们给定一个表示工作耗时的二维数组，我们需要计算出这个二维数组最长的一个
    // 数量，我们的终止条件是什么样的呢，base case 是啥
    // 如果这个数组只有一个job，那么最大就是1
    public static int process(int[][] a, int m, int n) {


        return -1;
    }


    public static void main(String[] args) {
        int[][] jobs = {{0, 1}, {0, 2}, {1, 3}, {2, 5}, {3, 7}, {4, 6}, {7, 9}, {8, 10}, {9, 10}};
        System.out.println(process(jobs, jobs.length, jobs[0].length));
    }
}
