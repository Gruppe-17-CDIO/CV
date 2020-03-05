package BallDetection;

import org.openimaj.image.*;
import org.openimaj.image.colour.Transforms;
import org.openimaj.image.pixel.Pixel;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ObjectDetection {

    public static void main(String[] args) throws IOException {
        List<Pixel> ballPixel = new ArrayList<Pixel>();

final float tresholde = 0.5f;


        //SingleBandImage
    /*    FImage image = ImageUtilities.readF(new File("IMG_20200226_084141057.jpg"));
        DisplayUtilities.display(image);

        ResizeProcessor resize = new ResizeProcessor(640, 330);
        resize.processImage(image);
        DisplayUtilities.display(image);
*/





        //MultibandImage

        MBFImage multibandImage = ImageUtilities.readMBF(new File("IMG_20200226_084141057.jpg"));

        DisplayUtilities.display(multibandImage);
        DisplayUtilities.display(Transforms.RGB_TO_HSV(multibandImage));

        MBFImage clone = detectBall(multibandImage);

        DisplayUtilities.display(clone);



    }




    private static MBFImage detectBall(MBFImage image){

        Float[] null_float = new Float[3];
        null_float[0] =0.0f;
        null_float[1] =0.0f;
        null_float[2] =0.0f;
        for (int i = 0;i<image.getHeight();i++){
            for(int j=0;j<image.getWidth();j++){

                float average = calculateAverege(image.getPixel(j,i));
                if(average>0.9f) {
                    image.setPixel(j, i, setAverage(average, image.getPixel(j, i)));

                }else{
                    image.setPixel(j, i,null_float);
                }
            }
        }
        return image;
    }

    private static float calculateAverege(Float[] x){


            return (x[0]+x[1]+x[2])/3;
    }

    private static Float[] setAverage(float average, Float[] pixel){
            for(int i = 0; i<3;i++){
                pixel[i] = average;
            }

            return pixel;
    }

}
