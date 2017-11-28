package de.kauffmann;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	BufferedReader keyboard=new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String s = keyboard.readLine();
			System.out.println(s.toUpperCase());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
