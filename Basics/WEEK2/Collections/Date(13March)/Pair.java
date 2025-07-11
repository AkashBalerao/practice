

class NewPair<N extends Number, V>{
    
    private N key;
    private V value;

    void setKey(N k)
    {
        this.key = k;
    }

    void setValue(V v)
    {
        this.value = v;
    }

    N getKey()
    {
        return this.key;
    }

    V getValue()
    {
        return this.value;
    }
}

public class Pair {

    public static void main(String[] args) {
        NewPair<Integer, String> a = new NewPair<>();

        a.setKey(23);
        a.setValue("Akash");

        int age = a.getKey();
        String name = a.getValue();

        System.out.println(name+" "+age);
    }
    
}
