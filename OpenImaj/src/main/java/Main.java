import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		final float THRESHOLD = 2.6f;
		final int SCALE = 12;
		
		MBFImage image = ImageUtilities.readMBF(new File("resources/BaneMedBolde0.jpg"));
		MBFImage clone = image.clone();
		MBFImage raw = new MBFImage(image.getWidth()/SCALE, image.getHeight()/SCALE);
		
		for (int height=0; height < raw.getHeight(); height++)
		{
			for (int width=0; width < raw.getWidth(); width++)
			{
				FindColour finder 	= new FindColour(THRESHOLD, 0.2f);
				Point start 		= new Point(SCALE*width, SCALE*height);
				Point end 			= new Point(SCALE*width+(SCALE-1), SCALE*height+(SCALE-1));
				
				if (finder.find(Colour.RED, start, end, image))
					raw.getBand(0).pixels[height][width] = 1f;
				else if (finder.find(Colour.GREEN, start, end, image))
					raw.getBand(1).pixels[height][width] = 1f;
				else if (finder.find(Colour.BLUE, start, end, image))
					raw.getBand(2).pixels[height][width] = 1f;
			}
		}
		
		DisplayUtilities.display(raw).setSize(2400, 1440);
	}
	
	public static float redRatio(final int width, final int height, MBFImage image)
	{
		float[][] band0 = image.getBand(0).pixels;
		float[][] band1 = image.getBand(1).pixels;
		float[][] band2 = image.getBand(2).pixels;
		
		float accum = band0[height][width] + band1[height][width] + band2[height][width];
		
		return accum/band0[height][width];
	}
}
