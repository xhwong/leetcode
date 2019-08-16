package code2019;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author xhowng
 * @date 2019/7/26
 */

public class day0708 {

    public static void main(String[] args) {
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int[][] times2 = { { 1, 2, 1 }, { 2, 3, 7 }, { 1, 3, 4 }, { 2, 1, 2 } };
        System.out.println(networkDelayTime(times, 4, 2));
        System.out.println(networkDelayTime(times2, 4, 1));
    }

    public static int networkDelayTime(int[][] times, int N, int K) {
        // 这道题中 N 个节点下标都是连续的，其实放在一个数组中效率更好。考虑通用性我还是使用 map 了
        HashMap<Integer, NetNode> map = new HashMap<>();
        // 这个优先队列保存剩余节点，并按照 distance 从小到大排序
        PriorityQueue<NetNode> queue = new PriorityQueue<>(N, (o1, o2) -> o1.distance - o2.distance);
        // Step 1: init
        for (int i = 1; i <= N; i++) {
            NetNode node = new NetNode(i);
            if (i == K) {
                node.distance = 0;
            }
            map.put(i, node);
            queue.offer(node);
        }
        // Step 2: update neighbor node
        for (int i = 0; i < times.length; i++) {
            NetNode node = map.get(times[i][0]);
            node.neighbors.put(times[i][1], times[i][2]);
        }
        // Step 3: dijkstra
        while (!queue.isEmpty()) {
            // extract min
            NetNode min = queue.poll(); // 优先队列的队首就是 distance 最小的节点
            if (min.distance == Integer.MAX_VALUE) {
                return -1; // 无法到达的点，后面步骤都可以不做了，直接 return
            }
            // Step 4: relax
            // 所谓 relax，即是取出 min 节点后，更新其可以到达的节点的 distance
            for (int v : min.neighbors.keySet()) {
                NetNode curr = map.get(v);
                int distance = min.distance + min.neighbors.get(v);
                if (distance < curr.distance) {
                    curr.distance = distance;
                    // Step 5: update queue
                    // 更新节点在队列中的位置，由于没有直接的更新方法，只好先取出来再放进去
                    queue.remove(curr);
                    queue.add(curr);
                }
            }
        }
        // Step 6: find max
        int max = 0;
        for (Map.Entry<Integer, NetNode> entry : map.entrySet()) {
            if (entry.getValue().distance > max) {
                max = entry.getValue().distance;
            }
        }
        return max;
    }

    public static class NetNode {
        int u;
        HashMap<Integer, Integer> neighbors = new HashMap<>();
        int distance = Integer.MAX_VALUE;

        public NetNode(int u) {
            this.u = u;
        }
    }
}
