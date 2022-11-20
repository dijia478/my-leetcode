package cn.dijia478;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 1488.避免洪水泛滥
 * <p>
 * 你的国家有无数个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨前是空的，那么它就会装满水。如果第 n 个湖泊下雨前是 满的 ，这个湖泊会发生 洪水 。你的目标是避免任意一个湖泊发生洪水。
 * <p>
 * 给你一个整数数组 rains ，其中：
 * <p>
 * rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。
 * rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水。
 * 请返回一个数组 ans ，满足：
 * <p>
 * ans.length == rains.length
 * 如果 rains[i] > 0 ，那么ans[i] == -1 。
 * 如果 rains[i] == 0 ，ans[i] 是你第 i 天选择抽干的湖泊。
 * 如果有多种可行解，请返回它们中的 任意一个 。如果没办法阻止洪水，请返回一个 空的数组 。
 * <p>
 * 请注意，如果你选择抽干一个装满水的湖泊，它会变成一个空的湖泊。但如果你选择抽干一个空的湖泊，那么将无事发生。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：rains = [1,2,3,4]
 * 输出：[-1,-1,-1,-1]
 * 解释：第一天后，装满水的湖泊包括 [1]
 * 第二天后，装满水的湖泊包括 [1,2]
 * 第三天后，装满水的湖泊包括 [1,2,3]
 * 第四天后，装满水的湖泊包括 [1,2,3,4]
 * 没有哪一天你可以抽干任何湖泊的水，也没有湖泊会发生洪水。
 * 示例 2：
 * <p>
 * 输入：rains = [1,2,0,0,2,1]
 * 输出：[-1,-1,2,1,-1,-1]
 * 解释：第一天后，装满水的湖泊包括 [1]
 * 第二天后，装满水的湖泊包括 [1,2]
 * 第三天后，我们抽干湖泊 2 。所以剩下装满水的湖泊包括 [1]
 * 第四天后，我们抽干湖泊 1 。所以暂时没有装满水的湖泊了。
 * 第五天后，装满水的湖泊包括 [2]。
 * 第六天后，装满水的湖泊包括 [1,2]。
 * 可以看出，这个方案下不会有洪水发生。同时， [-1,-1,1,2,-1,-1] 也是另一个可行的没有洪水的方案。
 * 示例 3：
 * <p>
 * 输入：rains = [1,2,0,1,2]
 * 输出：[]
 * 解释：第二天后，装满水的湖泊包括 [1,2]。我们可以在第三天抽干一个湖泊的水。
 * 但第三天后，湖泊 1 和 2 都会再次下雨，所以不管我们第三天抽干哪个湖泊的水，另一个湖泊都会发生洪水。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= rains.length <= 105
 * 0 <= rains[i] <= 109
 *
 * @author dijia478
 * @date 2022/11/20
 */
public class Code1488 {

    public static void main(String[] args) {
        int[] rains = {1, 2, 3, 4};
        int[] ans = avoidFlood(rains);
        System.out.println(JSON.toJSONString(ans));
    }

    public static int[] avoidFlood(int[] rains) {
        int length = rains.length;
        int[] ans = new int[length];
        int[] invalid = new int[0];

        // key:某个湖，value:这个湖在哪天要下雨
        // 1:{0,5,8}  1号湖泊将在第0，5，8天下雨
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                // 第i天，rains[i]号湖泊要下雨
                if (!map.containsKey(rains[i])) {
                    map.put(rains[i], new LinkedList<>());
                }
                map.get(rains[i]).addLast(i);
            }
        }

        // 下雨湖满了就加进去，不下雨湖抽干了就移除
        Set<Integer> set = new HashSet<>();
        // 这个堆顶表示最先处理的湖是哪个
        PriorityQueue<Work> heap = new PriorityQueue<>();
        for (int i = 0; i < length; i++) {
            if (rains[i] != 0) { // 下雨天
                if (set.contains(rains[i])) {
                    // 必然有水灾，无能为力
                    return invalid;
                }
                // rains[i]号湖泊要下雨，放到set里
                set.add(rains[i]);
                map.get(rains[i]).pollFirst();
                if (!map.get(rains[i]).isEmpty()) {
                    heap.add(new Work(rains[i], map.get(rains[i]).peekFirst()));
                }
                ans[i] = -1;
            } else {
                if (heap.isEmpty()) {
                    ans[i] = 1; // 题目设定没活干，也要抽1号湖，不然过不了用例
                } else {
                    Work cur = heap.poll();
                    set.remove(cur.lake);
                    ans[i] = cur.lake;
                }
            }
        }
        return ans;
    }

    public static class Work implements Comparable<Work> {

        private int lake;
        private int nextRain;

        public Work(int lake, int nextRain) {
            this.lake = lake;
            this.nextRain = nextRain;
        }

        @Override
        public int compareTo(Work o) {
            return nextRain - o.nextRain;
        }

    }

}
