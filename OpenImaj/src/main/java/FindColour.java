import org.openimaj.image.MBFImage;

import java.awt.*;

public class FindColour
{
	
	private float threshold;
	private float ratio;
	
	public FindColour(float threshold, float ratio)
	{
		this.ratio = ratio;
		this.threshold = threshold;
	}
	
	public boolean find(Colour colourToFind, Point start, Point end, MBFImage image)
	{
		switch (colourToFind)
		{
			case RED:
				return findRed(start, end, image);
				
			case GREEN:
				return findGreen(start, end, image);
				
			case BLUE:
				return false;
		}
		
		return false;
	}
	
	/**
	 * Checks whether the pixel corresponds to red
	 * @param start
	 * @param end
	 * @param image
	 * @return
	 */
	private boolean findRed(Point start, Point end, MBFImage image)
	{
		// Find areal af kvadrant
		int area = (end.x - start.x) * (end.y - start.y);
		
		int redCount = 0;
		for (int y=start.y; y < end.y; y++)
		{
				for (int x=start.x; x < end.x; x++)
				{
					float[][] band0 = image.getBand(0).pixels;
					float[][] band1 = image.getBand(1).pixels;
					float[][] band2 = image.getBand(2).pixels;
					
					float accum = band0[y][x] + band1[y][x] + band2[y][x];
					
					if (accum/band0[y][x] < threshold)
						redCount++;
				}
		}
		float ratio = (float)redCount / (float)area;
		if (redCount > 0)
			System.out.println(String.format("area: %s\tredCount: %s\tRatio: %s\n", area, redCount, ratio));
		
		return ratio > this.ratio;
	}
	
	private boolean findGreen(Point start, Point end, MBFImage image)
	{
		return false;
	}
}
