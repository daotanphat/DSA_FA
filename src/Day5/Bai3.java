package Day5;

public class Bai3 {
    public boolean isPerfectSquare(int num) {
        long r = num;
        while (r * r > num)
            r = (r + num / r) / 2;
        return r * r == num;
    }
}
