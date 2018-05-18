package bsuir;
public class Test {
    public static void main(String[] args) {

        int x = 2;
        int y = 1;
        int z = 3;

        double res1 = z/3;
        System.out.println("res1 = " + res1);
        double res2 = Math.tan(res1);
        System.out.println("res2 = " + res2);
        double res3 = Math.pow(res2, 2.0);
        System.out.println("res3 = " + res3);
        double res4 = 1 + res3;
        System.out.println("res4 = " + res4);
        double res5 = Math.abs(y);
        System.out.println("res5 = " + res5);
        double res6 = res5 + 7;
        System.out.println("res6 = " + res6);
        double res7 = Math.sqrt(res6);
        System.out.println("res7 = " + res7);
        double res8 = Math.pow(res4, res7);
        System.out.println("res8 = " + res8);
        double res9 = Math.pow(x, 3.0);
        System.out.println("res9 = " + res9);
        double res10 = res9/y;
        System.out.println("res10 = " + res10);
        double res11 = y + res10;
        System.out.println("res11 = " + res11);
        double res12 = Math.pow(x, 2.0);
        System.out.println("res12 = " + res12);
        double res13 = res12/res11;
        System.out.println("res13 = " + res13);
        double res14 = y + res13;
        System.out.println("res14 = " + res14);
        double res15 = x-y;
        System.out.println("res15 = " + res15);
        double res16 = Math.exp(res15);
        System.out.println("res16 = " + res16);
        double res17 = res16/res14;
        System.out.println("res17 = " + res17);
        double res18 = res17 * res8;
        System.out.println("res18 = " + res18);
        double res19 = y + res18;

        System.out.println(res19);

    }
}
