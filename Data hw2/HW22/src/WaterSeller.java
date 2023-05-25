

public class WaterSeller {
    private static class Node {
        int price;
        int day;
        Node next;

        Node(int price, int day) {
            this.price = price;
            this.day = day;
            this.next = null;
        }
    }

    public static void findProfit(int[] prices) {
        if (prices.length < 2) {
            System.out.println("No trading");
            System.out.println("Profit = 0");
            return;
        }

        Node head = new Node(prices[0], 0);
        Node current = head;
        int buyDay = 0;
        int sellDay = 0;
        int maxProfit = 0;

        for (int day = 1; day < prices.length; day++) {
            int price = prices[day];
            current.next = new Node(price, day);
            current = current.next;

            if (price < head.price) {
                head = current;
                buyDay = day;
            } else if (price > head.price && (price - head.price) > maxProfit) {
                maxProfit = price - head.price;
                sellDay = day;
            }
        }

        if (sellDay == 0) {
            System.out.println("No trading");
            System.out.println("Profit = 0");
            return;
        }

        System.out.println("Buy Day " + buyDay + ", Sell Day " + sellDay);
        System.out.println("Profit = " + maxProfit);
    }

    public static void main(String[] args) {
        int[] waterPrices1 = {4, 5, 5, 2, 4, 6, 1};
        findProfit(waterPrices1);

        
        int[] waterPrices2 = {6, 5, 4, 3, 2, 1, 1};
        findProfit(waterPrices2);

        
        
    }
}
