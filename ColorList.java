package project1;

import java.util.ArrayList;

/**
 * This class represents an ArrayList that stores all the Color objects 
 * (whose hexadecimal value and name will provided in the input file.)
 * This class inherits from ArrayList<Color> class 
 * and contain no data field with the type of ArrayList<Color>
 * 
 * @author Gayeon_Park
 *
 */
public class ColorList extends ArrayList<Color>{

	//Default Constructor
	public ColorList(){

	}

	/**
	 * Passes the name of a hexadecimal value into its parameter.
	 * The name of a hexadecimal value should be case insensitive. 
	 * 
	 * @param colorName name of a potential hexadecimal value to be checked  
	 * 
	 * @return the Color object in the list whose color name 
	 *  matches the colorName specified by the parameter. 
	 *  If the method is called with a non-existent color name, 
	 *  returns null.
	 */
	public Color getColorByName (String colorName){
		for (int i = 0; i < size(); i ++){
			if (get(i).getName().equalsIgnoreCase(colorName)){
				return get(i);
			} 
		}
		return null;
	}

	/**
	 * Passes a hexadecimal value into its parameter.
	 * The name of a hexadecimal value should be case insensitive.
	 * 
	 * @param colorHexValue a potential hexadecimal value to be checked
	 * 
	 * @return the Color object in the list whose hexadecimal value 
	 * matches the colorHexValue specified by the parameter.  
	 * If the method is called with a non-existent 
	 * hexadeciamal value, returns null.
	 */
	public Color getColorByHexValue (String colorHexValue){
		for (int i = 0; i < size(); i ++){
			if (get(i).getHexValue().equalsIgnoreCase(colorHexValue)){
				return get(i);
			} 
		}
		return null;
	}
}
