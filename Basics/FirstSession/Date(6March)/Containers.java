import java.util.*;

class Obj
{
    int len=4;
}

class Containers
{
    public static void method(int [] arr)
    {
        System.out.println("Passed array");
        System.out.println(Arrays.toString(arr));
        arr[3] = 0;
    }

    public static void main(String [] args)
    {
        Random rand = new Random(47);
        //preemitive array
        System.out.println("Array declaration and initalization");
        int arr[] = new int[5];
        for(int i=0; i<5; i++)
        {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));

        //non-preemitive array
        System.out.println("\n----------------------------");
        System.out.println("Object Array");
        Obj objarr[] = {new Obj(), new Obj()};
        for(int i=0; i<objarr.length; i++)
        {
            System.out.println(objarr[i].len);
        }

        //ragged arrays
        int arr2[][] = new int[rand.nextInt(10)][];
        for(int i=0; i<arr2.length; i++)
        {
            arr2[i] = new int[rand.nextInt(10)];
            for(int j=0; j<arr2[i].length; j++)
            {
                arr2[i][j] = rand.nextInt(5);
            }
        }

        int numArray[] = new int[20];
        for(int i=0; i<numArray.length; i++)
        {
            numArray[i] = rand.nextInt(20);
        }

        int freq[] = new int[20];
        for(int i=0; i<numArray.length; i++)
        {
            freq[numArray[i]]++;
        }

        System.out.println(Arrays.toString(numArray));
        
        System.out.println("\n----------------------------");
        System.out.println("Frequency of every element");
        for(int i=0; i<freq.length; i++)
        {
            if(freq[i]>0)
            {
                System.out.println(i+" : "+freq[i]);
            }
        }
        
        System.out.println("\n----------------------------");
        System.out.println("Before sorting");
        System.out.println(Arrays.deepToString(arr2));

        for(int i=0; i<arr2.length; i++)
        {
            Arrays.sort(arr2[i]);
        }

        System.out.println("\n----------------------------");
        System.out.println("After sorting");
        System.out.println(Arrays.deepToString(arr2));

        System.out.println("\n----------------------------");
        System.out.println("After copying");
        int arr3[][] = Arrays.copyOf(arr2, arr2.length);
        System.out.println(Arrays.deepToString(arr3));

        System.out.println("\n----------------------------");
        int arr4[][] = new int[arr2.length][];
        System.out.println("partial copy");
        System.arraycopy(arr2, 1, arr4, 1, 4);
        System.out.println(Arrays.deepToString(arr4));

        System.out.println("\n----------------------------");
        method(arr);
        System.out.println("orginal after passing");
        System.out.println(Arrays.toString(arr));

        // String s1 = "Hello";
        // String s2 = "Hello";

        // System.out.println(s1==s2);
        // System.out.println(s1.equals(s2));

        // String s1 = "Hello";
        // String s2 = new String("Hello");
        // System.out.println(s1==s2);
        // System.out.println(s1.equals(s2));

        System.out.println("\n----------------------------");
        String s1 = new String("Basic");
        String s2 = new String("Method");
        String s3 = new String("bAsIc");

        System.out.println("Length of string s1 "+s1.length());

        System.out.println("Charecter at "+s1.charAt(3));

        System.out.println("Char Array"+Arrays.toString(s1.toCharArray()));

        System.out.println("equals() "+ s1.equals(s3));

        System.out.println("equalsIgnoreCase() "+ s1.equalsIgnoreCase(s3));

        System.out.println("CompareTo() "+s1.compareTo(s3));

        System.out.println("contains() "+s1.contains("si"));

        System.out.println("containsEquals() "+s1.contentEquals("si"));

        // System.out.println("Start with "+ s1.startstWith("Basi"));

        System.out.println("Index of "+ s1.indexOf("a"));

        System.out.println("substring() "+ s1.substring(2, 4));

        System.out.println("replace() "+ s1.replace('a', 'x'));

        System.out.println("uppercase() "+s1.toUpperCase());

        System.out.println("lowercase() "+s1.toLowerCase());

        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" world!");
        System.out.println(sb);

        StringBuffer ssb = new StringBuffer("Hello");
        ssb.append(" world!");
        System.out.println(ssb);


        String str1 = "Hello";
        String str2 = new String("Hello"); // creates new string object in heap
        System.out.println("are s1, s2 equal: "+(str1 == str2));

        long startTime, endTime;
        
        // StringBuffer Test
        StringBuffer sb1 = new StringBuffer("Hello");
        startTime = System.nanoTime();
        for(int i = 0; i < 10000; i++) {
            sb1.append(" World");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime));

        // StringBuilder Test
        StringBuilder sb2 = new StringBuilder("Hello");
        startTime = System.nanoTime();
        for(int i = 0; i < 10000; i++) {
            sb2.append(" World");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime));

    }
}