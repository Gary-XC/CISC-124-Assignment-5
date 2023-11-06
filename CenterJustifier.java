package a5;

/**
 * A {@code TextJustifier} that aligns text to a column having a specified width
 * measured in characters such that the text is centered in the column.
 */
public class CenterJustifier implements TextJustifier {

	/**
	 * Aligns the specified string to a column having the specified width such that
	 * the text is centered in the column. The returned string is padded with spaces
	 * at the front and end of the string so that the length of the string is equal
	 * to the column width.
	 * 
	 * <p>
	 * An equal number of padding spaces are used at the front and end of the string
	 * if possible. If this is not possible, then the end of the string contains
	 * one more space than the front of the string.
	 * 
	 * @param s     a string to align
	 * @param width a column width in characters
	 * @return a string aligned to a column of the specified width
	 * @throws IllegalArgumentException if the length of s is greater than width
	 */
	@Override
	public String justify(String s, int width) {
		if (s.length() > width) {
			throw new IllegalArgumentException("The length of the string is greater than the width");
		}
		
		int spacesAdded = width - s.length();
		String justifiedString = "";
		
		if(spacesAdded % 2 == 0) {
			int equalSpaces = spacesAdded / 2;
			
			for(int i = 0; i < equalSpaces; i++) {
				justifiedString += " ";
			}
			
			justifiedString += s;
			
			for(int i = 0; i < equalSpaces; i++) {
				justifiedString += " ";
			}
			
		}
		
		else {
			int spaces = Math.floorDiv(spacesAdded, 2);
			
			for(int i = 0; i < spaces; i++) {
				justifiedString += " ";
			}
			
			justifiedString += s;
			
			for(int i = 0; i < spaces + 1; i++) {
				justifiedString += " ";
			}
			
		}
		
		return justifiedString;
	}

}
