import java.io.*;

class dog{
    int i= 10;
    int j = 20;
}

public class Serializaion {
    public static void main(String [] args) throws Exception
    {
        dog d =new dog();

        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d);

        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        dog d2 = (dog)ois.readObject();

        System.out.println(d2.i+" "+d2.j);
    }
    
}