import java.io.*;
import java.util.*;

public class IO {
    public static void main(String[] args) throws IOException {
        
        FileReader fr = new FileReader("abc.txt");

        int words=0,chars=0,lines=0;
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
            }
        }
        
        System.out.println("Words: "+words);
        System.out.println("chars: "+chars);
        System.out.println("lines: "+lines);

    }
}
