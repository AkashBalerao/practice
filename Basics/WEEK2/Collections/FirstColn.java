package WEEK2.Collections;
import java.util.*;

class CustomComparator implements Comparator<Object> {
    public int compare(Object o1, Object o2) {
        return o1.toString().compareTo(o2.toString());
    }
}

public class FirstColn{
    public static void main(String [] args){
        ArrayList<String> names = new ArrayList<String>();

        names.add("Akash");
        names.add("Durgesh");
        names.add("Sitara");
        names.add("Sachin");

        System.out.println(names.get(3));
        System.out.println("size: "+names.size());
        System.out.println(names.contains("Sitara"));
        
        //for each
        System.out.println("\nForEach loop");
        System.out.println("----------------------");
        for(String e: names)
        {
            System.out.println(e+" "+e.length());
        }

        //Iterator
        System.out.println("\nIterator class");
        System.out.println("----------------------");
        Iterator it = names.iterator();
        
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        
        //backword traversal
        System.out.println("\nList Iterator");
        System.out.println("----------------------");
        ListIterator<String> lit = names.listIterator(names.size());
        while(lit.hasPrevious())
        {
            System.out.println(lit.previous());
        }
        
        //forEach method
        System.out.println("\nforEach method");
        System.out.println("----------------------");
        names.forEach(e->{
            System.out.println(e);
        });

        Vector<Integer> vec = new Vector<>();
        vec.add(2);
        vec.add(5);
        vec.add(8);
        vec.add(3);
        vec.add(4);

        //Enumeration
        System.out.println("\nEnumeration");
        System.out.println("----------------------");
        Enumeration<Integer> enu = vec.elements();
        while (enu.hasMoreElements()) {
            System.out.println(enu.nextElement());
        }
        
        //TreeSet
        System.out.println("\nTreeSet custom comparator");
        System.out.println("----------------------");
        TreeSet<Object> set = new TreeSet<>(new CustomComparator());
        set.add(123);
        set.add(new String("akash"));
        set.add(534.53);
        set.add(true);
        
        Iterator sit = set.iterator();
        while(sit.hasNext())
        {
            System.out.println(sit.next());
        }

        //comparator
        System.out.println("\ncomparator using lambda");
        System.out.println("----------------------");
        List<String> s = new ArrayList<>();
        s.add("Akash");
        s.add("Durgesh");
        s.add("Sitara");
        s.add("Sachin");
        for(String ep: s)
        {
            System.out.println(ep+" "+ep.length());
        }
        Comparator<String> cmp = new Comparator<String>(){
            public int compare(String s1, String s2)
            {
                if(s1.length()>s2.length())
                {
                    return -1;
                }
                return 1;
            }
        };
        Collections.sort(s, cmp);
        System.out.println(s);
    }
}