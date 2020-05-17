package c18310663;

import processing.core.*;

public class WaveForm
{
    MyVisual cv;
    float cy = 0;

    public WaveForm(MyVisual cv)
    {
        this.cv = cv;
        cy = this.cv.width / 2;
    }

    public void render()
    {
        cv.colorMode(PApplet.HSB);
        for(int i = 0 ; i < 50; i ++)
        {
            cv.stroke(
                PApplet.map(i, 0, 50, 0, 255)
                , 255
                , 255
            );
            cv.line(-25 + i , 0, -25 + i,  30 * cv.getAudioBuffer().get(i));
        }
    }
}