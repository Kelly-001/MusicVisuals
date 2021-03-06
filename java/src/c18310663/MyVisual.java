package c18310663;

import ie.tudublin.Visual;

public class MyVisual extends Visual
{
    WaveForm wf;
    boolean moveup = false;
    boolean movedown = false;
    boolean turn = false;
    boolean camout = false;
    boolean camin = false;
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
        if( key == '1'){
            moveup = ! moveup;
        }
        if( key == '2'){
            turn = ! turn;
        }
        if( key == '3'){
            camout = ! camout;
        }
        if( key =='4'){
            camin = ! camin;
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
        camera(0, 0, loc, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -250);
        
        rect(-25,-60,50,100);
        line(-300, -220, -25, -60);
        line(-300, 220, -25, 40);
        line(300, -220, 25, -60);
        line(300, 220, 25, 40);

        float boxSize = cubes + (getSmoothedAmplitude() * 200);
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.8f);        
        pushMatrix();
        translate(aa, 120, cube);
        rotateX(angle);
        rotateY(angle);
        box(smoothedBoxSize);
        strokeWeight(3);
        popMatrix();
        pushMatrix();
        translate(cc, -120, cube);
        strokeWeight(3);
        rotateX(angle);
        rotateY(angle); 
        box(smoothedBoxSize);
        popMatrix();
        pushMatrix();
        translate(aa, -120, cube);
        strokeWeight(3);
        rotateX(angle1);
        rotateY(angle1); 
        box(smoothedBoxSize);
        popMatrix();
        pushMatrix();
        translate(cc, 120, cube);
        strokeWeight(3); 
        rotateX(angle1);
        rotateY(angle1);
        box(smoothedBoxSize);
        popMatrix();
       

        if(moveup){
            movedown = false;
            cube -= 2;
            cubes += .5;
            if(cube < -400) 
            {
                movedown = true;
            }
        }

        if(movedown){
            moveup = false;
            cube += 2;
            cubes -= .5;
            if(cube > 200){
                moveup = true;
            }
        }

        if(turn){
            angle += 0.02f;
            angle1 -= 0.02f;
            aa += 1;
            cc -= 1;
            if(aa == 170){
                aa = -170;
                cc = 170;
            }
        }

        if(camout){
            if(loc > -500){
                loc -= .2;
            }
        }
        if(camin){
            cube = 200;
            cubes = 0;
            if(loc < -315){
                loc += .2;
            }
        }
        wf.render();
    }
    float cube = 200;
    float angle = 0;
    float angle1 = 0;
    float cubes = 0;
    float loc = -315;
    float aa = -150;
    float cc = 150;
} 