import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class gen {

	public static Weapon nextMeleeWeapon(String rarity) {
		Random rand = new Random();
		String file = "J:/Zorak/Zoraka/src/ItemLibrary/Melee Weapons";
		String file1 = "J:/Zorak/Zoraka/src/ItemLibrary/Colors";
		String ra = null;
		

		
		try {

		    BufferedReader nameReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		    BufferedReader colorReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		    String line;
		    String line1;
		    String stringcomp = rarity;
		    // Uncomment the line below if you want to skip the fist line (e.g if headers)
		    // line = br.readLine();

		    while ((line = nameReader.readLine()) != null && ra != line.substring(1,2)) {
				int ran = rand.nextInt(8);
				ra = ran + "";
		    	String bob = line.substring(0, 1);
		    	if (bob.equals(stringcomp)) {
		    		System.out.println(line.substring(1));
				}
		    }
		    nameReader.close();


		} catch (IOException e) {
		    System.out.println("ERROR: unable to read file " + file);
		    e.printStackTrace();   
		}
		return null;

	


		
	}
}
