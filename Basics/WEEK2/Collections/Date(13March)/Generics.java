
class Box<T>{
    private T value;

    void setValue(T v)
    {
        this.value = v;
    }

    T getValue()
    {
        return this.value;
    }
}

public class Generics {
    public static void main(String[] args) {
        Box<Integer> b = new Box<>();

        b.setValue(2);

        int val = b.getValue();

        System.out.println(val);
    }
}
