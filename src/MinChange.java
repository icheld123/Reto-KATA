import java.util.Arrays;

public class MinChange {
    public static int getMinimumChange(int[] coins) {
        int minChange = 1;

        for (int coin : coins) {
            if (coin > minChange) {
                break;
            }
            minChange += coin;
        }

        return minChange;
    }
}
