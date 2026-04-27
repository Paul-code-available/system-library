package utils;

import java.awt.Font;

public class AppFont {

	private static Font title;
	private static Font subtitle;
	private static Font base;
	
	static {
		try {
			title = Font.createFont(
					Font.TRUETYPE_FONT,
					AppFont.class.getResourceAsStream("/fonts/Merriweather-VariableFont_opsz,wdth,wght.ttf"));
			
			base = Font.createFont(
					Font.TRUETYPE_FONT,
					AppFont.class.getResourceAsStream("/fonts/Inter_18pt-Regular.ttf"));
			
			subtitle = Font.createFont(
					Font.TRUETYPE_FONT,
					AppFont.class.getResourceAsStream("/fonts/Roboto-Medium.ttf"));
		} catch (Exception e) {
			title = new Font("Times New Roman", Font.PLAIN, 14);
			base = new Font("Arial", Font.PLAIN, 14);
			subtitle = new Font("Arial", Font.PLAIN, 14);
		}
	}
	
	public static Font title() {
		return title.deriveFont(36f);
	}
	
	public static Font subtitle() {
		return subtitle.deriveFont(18f);
	}
	
	public static Font large() {
		return base.deriveFont(18f);
	}
	
	public static Font medium() {
		return base.deriveFont(14f);
	}
	
	public static Font small() {
		return base.deriveFont(12f);
	}
	
}
