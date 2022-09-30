package GenericLibraries;

import java.util.Random;

/**
 * This class contain generic methods to java
 * @author Monika
 *
 */
public class JavaLibrary {
	/**
	 * 
	 * @
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		return ran.nextInt(200);
	}

}
