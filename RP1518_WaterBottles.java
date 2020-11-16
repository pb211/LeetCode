package Lecode.Greedy;

public class RP1518_WaterBottles {
    public static void main(String[] args) {
        int numBottles = 9;
        int numExchange = 3;
        int res = numWaterBottles(numBottles,numExchange);
        System.out.println(res);
    }

    public static int numWaterBottles(int numBottles, int numExchange) {

        return numBottles(numBottles,numBottles,numExchange);
    }

    private static int numBottles(int sum,int numBottles, int numExchange) {
        if (numBottles<numExchange){
            return sum;
        }
        int num = (int) Math.floor(numBottles/numExchange);
        sum=sum+num;
        numBottles = numBottles%numExchange+num;
        return numBottles(sum,numBottles,numExchange);
    }

}
