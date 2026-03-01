package utils;

import java.awt.Font;

public class AppFont {

	private static Font base;
	
	static {
		try {
			base = Font.createFont(
					Font.TRUETYPE_FONT,
					AppFont.class.getResourceAsStream("/fonts/Inter_18pt-Regular.ttf"));
		} catch (Exception e) {
			base = new Font("Times New Roman", Font.PLAIN, 14);
		}
	}
	
	public static Font normal() {
		return base.deriveFont(14f);
	}
	
}
