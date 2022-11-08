package com.jkachele.personal;


import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import java.awt.Color;

public class ImageAnalysis2 {
	public static void main(String[] args) throws Exception{
		final int Tolerance = 12;
		final String[] files = {"1996.jpg", "1997.jpg", "1998.jpg", "1999.jpg", "2000.jpg", "2001.jpg", "2002.jpg", "2003.jpg", "2004.jpg"};
		final int[][] rgbValues = {{10, 0, 9}, {90, 0, 90}, {140, 000, 140}, {95, 30, 215}, {15, 35, 255}, {0, 120, 235}, {0, 191, 194}, 
				{0, 255, 255}, {114, 255, 50}, {0, 255, 0}, {196, 234, 13}, {255, 255, 0}, {255, 156, 0}, {206, 43, 0}, {120, 20, 20}, {55, 11, 10}};
		
		for(int i = 0; i < files.length; i++) {
			File file = new File("1996.jpg");
			BufferedImage image = ImageIO.read(file);
			for(int j = 0; j < rgbValues.length; j++) {
				int colorCount = 0;
				int width = image.getTileWidth();
				int height = image.getTileHeight();
				
				for(int h = 0; h < height; h ++) {
					for(int w = 0; w < width; w++) {
						   
						int rgb = image.getRGB(w,h);
						//System.out.println(Integer.toHexString(rgb));
						Color color = new Color(rgb, true);
						int r = color.getRed();
						
						if(Math.abs(rgbValues[j][0] - r) < Tolerance) {
							if(Math.abs(rgbValues[j][1] - r) < Tolerance) {
								if(Math.abs(rgbValues[j][2] - r) < Tolerance) {
									colorCount++;
								}
							}
						}
					}
				}
				int picture = 1996 + i;
				System.out.println("Picture: "+picture);
				//System.out.println("\tColor "+j+": "+Integer.toHexString(refRGB));
				System.out.println("\tColor "+j+" Count: "+colorCount);
			}
			//System.out.println("\tPixel Count: "+pixelCount);
		}
		
	}
}