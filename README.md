# Music Visualiser Project

Name: Kelly Luu

Student Number: C18310663

# Description of the assignment

This assignment has objects in the program react to the music that is playing. I chose the song Mi Gente by J Balvin and Willy William because I believe it is the type of song that would show an audio visualiser's potential

# How it works

- Press space to start the music
- Press 1 to move cubes forwards and backwards
- Press 2 to rotate cubes and make them cross each other, press it again for them to stop moving
- Press 3 to move the camera out, once it stops moving press it again to stop the function
- Press 4 to move the camera back in and bring the cubes back to their original location, once it stops moving press it again to stop 	the function 

# What I am most proud of in the assignment

One of the things I am proud of was changing the waveform code so that it would fit into the small window instead of taking up the whole screen. While the concept is easy enough, some computational thinking was required for me to figure out how to get it to do exactly what I want. At first the colours was not all the colours but only a few. After some trial and error, it worked.

```Java
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
```


Link to the assignment on Youtube:

[![YouTube](https://i9.ytimg.com/vi/NSr5VLHf8wo/mqdefault.jpg?time=1589738216469&sqp=CPT0hfYF&rs=AOn4CLDZ0CfDG6DaxGZh7CbjQrWT0QmCAw)](https://youtu.be/NSr5VLHf8wo)


