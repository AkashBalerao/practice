import java.io.*;

class dog implements Serializable{
	String name = "honey";
	transient String password = "cookies";
	
//	private void writeObject(ObjectOutputStream oos)throws Exception
//	{
//		oos.defaultWriteObject();
//		String enpass = "123" + password;
//		oos.writeObject(enpass);
//	}
//	
//	private void readObject(ObjectInputStream ois)throws Exception
//	{
//		ois.defaultReadObject();
//		String enpass=(String)ois.readObject();
//		password = enpass.substring(3);
//	}
}

//class cat implements Serializable{
//	rat r = new rat();
//}
//
//class rat implements Serializable{
//	String p = "Rat";
//}

public class Serialization {
    public static void main(String [] args) throws Exception
    {
        dog d =new dog();
        
        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d);

        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        dog d2 = (dog)ois.readObject();
        
        System.out.println(d2.name);
        System.out.println(d2.password);

    }
    
};