import java.util.*;

class Iterations
{
    public static boolean test(int testval, int begin, int end)
    {
        if(testval>=begin && testval<=end)
        {
            return true;
        }else{
            return false;
        }
    }

    public static void main(String [] args)
    {
        // while
        int a = 10;
        while(a>0)
        {
            System.out.println("Value of a: " + a--);
        }

        //do-while
        int b = 10;
        do{
            System.out.println("Value of b: "+b);
        }while(b>10);

        //for loop
        for(int i=0; i<10; i++)
        {
            System.out.println("Value of i is: " + i);
        }

        for(char ch='a'; ch<=128; ch++)
        {
            System.out.println("Character: "+ ch);
        }

        prime:
        for(int i=0; i<100; i++)
        {
            if(i==0 || i==1)
            {
                continue;
            }
            for(int j=2; j<i; j++)
            {
                if(i%j==0)
                {
                    System.out.println(i+" Not a Prime");
                    continue prime;
                }
            }
            System.out.println(i+" is a Prime");
        }

        System.out.println(test(23,2, 50));

        // for(int i=0; i<100; i++)
        // {
        //     System.out.println("i "+i);
        //     if(i==10)
        //     {
        //         return;
        //     }
        // }
        
        int l = 0;
        outer: 
        for(; ;) {
            inner: 
            for(; l < 10; l++) { 
                System.out.println("l = " + l);

                if(l == 2) {
                    System.out.println("continue");
                    continue;
                }

                if(l == 3) {
                    System.out.println("break");
                    l++; 
                    break;
                }

                if(l == 7) {
                    l++; 
                    System.out.println("continue outer");
                    continue outer;
                }

                if(l == 8) {
                    System.out.println("break outer");
                    break outer;
                }

                for(int k = 0; k < 5; k++) {
                    System.out.println("k :"+k);
                    if(k == 3) {
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }

        System.out.println("End of program");

    }
}