package BigInt;
import java.math.*;

public class Big {

    public static BigInteger fact(int n)
    {
        BigInteger ans = BigInteger.valueOf(1);
        for(int i=1; i<=n; i++)
        {
            BigInteger temp = BigInteger.valueOf(i);
            ans = ans.multiply(temp);
        }
        return ans;
    }
    public static void main(String [] args)
    {
        int a = 100;
        int b = 34;

        // double a1 = 0.3;
        // double a2 = 0.4;
        // double ans = a1 - a2;
        // System.out.println(ans);

        BigInteger BB = new BigInteger("98437498327932847");
        BigInteger CC = BigInteger.valueOf(9393);

        BigInteger DD = BB.add(CC);
        System.out.println(DD);

        BigDecimal a1 = BigDecimal.valueOf(0.3);
        BigDecimal a2 = BigDecimal.valueOf(0.4);
        BigDecimal ans = a1.subtract(a2);
        System.out.println(ans);

        //System.out.println(fact(21332));
    }
}
