package c18310663;

import ie.tudublin.Visual;

public class CubeVisual extends Visual
{
    WaveForm wf;

    public void settings()
    {
        size(800, 600, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        //fullScreen(P3D, SPAN);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            
        }
    }

    public void setup()
    {
        colorMode(HSB);
        noCursor();
        
        setFrameSize(256);

        startMinim();
        loadAudio("mi.mp3");
        wf = new WaveForm(this);
        
    }

    float smoothedBoxSize = 0;

    public void draw()
    {
        calculateAverageAmplitude();
        background(0);
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, 0, 100, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -250);
        
        rect(-25,-60,50,100);
        line(-300, -220, -25, -60);
        line(-300, 220, -25, 40);
        line(300, -220, 25, -60);
        line(300, 220, 25, 40);

        float boxSize = 30 + (getSmoothedAmplitude() * 200);
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.4f);        
        pushMatrix();
        translate(-170, 120, 0);
        rotateY(angle);
        rotateX(angle);
        box(smoothedBoxSize);
        strokeWeight(3);
        popMatrix();
        pushMatrix();
        translate(170, -120, 0);
        rotateY(angle);
        rotateX(angle);
        strokeWeight(3); 
        box(smoothedBoxSize);
        popMatrix();
        pushMatrix();
        translate(-170, -120, 0);
        rotateY(angle1);
        rotateX(angle1);
        strokeWeight(3); 
        box(smoothedBoxSize);
        popMatrix();
        pushMatrix();
        translate(170, 120, 0);
        rotateY(angle1);
        rotateX(angle1);
        strokeWeight(3); 
        box(smoothedBoxSize);
        popMatrix();
        angle += 0.01f;
        angle1 -= 0.01f;

        wf.render();
    }
    float angle = 0;
    float angle1 = 0;
} 