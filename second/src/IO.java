import java.io.*;
import java.util.*;

public class IO {
    public static void main(String[] args) throws IOException {
    	
    	FileWriter fw = new FileWriter("abc.txt");
    	
    	fw.write(100);
    	fw.write("\n");
    	fw.write("this is a sentence");
    	
    	fw.close();
        
        FileReader fr = new FileReader("abc.txt");

        int words=0,chars=0,lines=1;
        int l = 0;
        while((l=fr.read())!=-1)
        {
            if((char)l==' ')
            {
                words++;
            }
            chars++;
            if((char)l=='\n')
            {
                lines++;
                words++;
            }
        }
        words++;
        
        System.out.println("Words: "+words);
        System.out.println("chars: "+chars);
        System.out.println("lines: "+lines);

    }
}
