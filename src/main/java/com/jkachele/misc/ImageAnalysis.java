package com.jkachele.misc;
//Author: Justin Kachele

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;

public class ImageAnalysis {
	public static void main(String[] args) throws Exception{
		final int Tolerance = 12;		//Color tolerance will count all pixels within 12 values of the color.
		
		//lists the file names used in the program
		final String[] Files = {"1996.jpg", "1997.jpg", "1998.jpg", "1999.jpg", "2000.jpg", "2001.jpg", "2002.jpg", "2003.jpg", "2004.jpg"};
		
		//3 arrays to define the colors to look for. 
		final int[] Red = 	{10, 90, 140, 95,  15,  0,   0,   0,   114, 0,   196, 255, 255, 206, 120, 55};
		final int[] Green = {0,  0,  0,   30,  35,  120, 191, 255, 255, 255, 234, 255, 156, 43,  20,  11};
		final int[] Blue = 	{9,  90, 140, 215, 255, 235, 194, 255, 50,  0,   13,  0,   0,   0,   20,  10};
		
		//loops through the images listed
		for(int i = 0; i < Files.length; i++) {
			//loads the image
			File file = new File("Pictures/".concat(Files[i]));
			BufferedImage image = ImageIO.read(file);
			int pixelCount = 0;
			int picture = 1996 + i;
			System.out.println("Picture: "+picture);
			
			//loops through the colors
			for(int j = 0; j < Red.length; j++) {
				int colorCount = 0;
				int width = image.getTileWidth();
				int height = image.getTileHeight();
				
				//two loops to cycle through every pixel in the image
				for(int h = 0; h < height; h ++) {
					for(int w = 0; w < width; w++) {
						
						//determines the color of the pixel
						int rgb = image.getRGB(w,h);
						Color color = new Color(rgb, true);
						int r = color.getRed();
						int g = color.getGreen();
						int b = color.getBlue();
						
						//checks if the pixel is within the tolerance of the defined color
						if(Math.abs(Red[j] - r) < Tolerance) {
							if(Math.abs(Green[j] - g) < Tolerance) {
								if(Math.abs(Blue[j] - b) < Tolerance) {
									colorCount++;
									pixelCount++;
								}
							}
						}
					}
				}
				//Prints the pixel count of the color and the total number of pixels counted
				System.out.println(colorCount);
			}
			System.out.println(pixelCount);
		}
		
	}
}