package a5;

import java.util.List;

/**
 * A class that wraps a string by breaking the string into lines
 * of length equal to or less than the desired wrapped line length.
 * The breaking occurs at spaces in the string where possible. If
 * a wrapped line contains no strings before the desired wrapped
 * line length, then the line is broken at the desired wrapped
 * line length.
 *
 */
public class SpacesWrapper extends AbstractStringWrapper {

	/**
	 * Initializes this wrapper with the string to wrap and the
	 * desired maximum wrapped line width.
	 * 
	 * @param toWrap the string to wrap
	 * @param targetWidth the desired maximum wrapped line width
	 */
	public SpacesWrapper(String toWrap, int targetWidth) {
		super(toWrap, targetWidth);
	}

	/**
	 * Wraps the string into separate lines of text.
	 */
	public void wrap() {
		lines.clear();
	
		int i = 0;
		
		while (maxWidth + i <= toWrap.length()) {
			if (toWrap.charAt(i) == ' ') {
				i += 1;
			}
			else {
				String tempSubString = toWrap.substring(i, maxWidth + i);
				
				if (!tempSubString.contains(" ")) {
					lines.add(tempSubString);
					i += maxWidth;
				}
				
				else if ((maxWidth + i) >= toWrap.length() || toWrap.charAt(maxWidth + i) == ' ') {
					lines.add(tempSubString);
					i += maxWidth;
				}
				
				else {
					int lastSpace = tempSubString.lastIndexOf(' ');
					
					String addedString = tempSubString.substring(0, lastSpace);
					lines.add(addedString);
					i = i + lastSpace + 1;
				}
			}
		}
		
		if (i < toWrap.length()) {
			lines.add(toWrap.substring(i).trim());
		}
		
	}

	public static void main(String[] args) {
		int width = 30;
		AbstractStringWrapper w = new SpacesWrapper("ABC DEFGH I JKLMNOPQ RSTUVWXYZ", width);
		w.wrap();
		List<String> wrapped = w.getLines();
		String out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");
		
		width = 20;
		w.width(width);
		w.wrap();
		wrapped = w.getLines();
		out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");
		
		width = 5;
		w.width(width);
		w.wrap();
		wrapped = w.getLines();
		out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");
		
		width = 1;
		w.width(width);
		w.wrap();
		wrapped = w.getLines();
		out = String.format("width:%2d, lines:%2d, lines = %s", width, wrapped.size(), wrapped);
		System.out.println(out + "\n");


	}
}
