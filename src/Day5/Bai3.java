package Day5;

public class Bai3 {
    static public boolean isPerfectSquare(int num) {
        long r = num;
        while (r * r > num)
            r = (r + num / r) / 2;
        return r * r == num;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(100));
    }
}
