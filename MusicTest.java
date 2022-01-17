import processing.core.PApplet;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicTest extends PApplet
{
    public static void main(String[] args)
    {
        PApplet.main("MusicTest");
    }
    
    public void setup()
    {
        String filename = "TimeLeaper.wav";
        playMusic(filename);
    }
    
    public void playMusic(String s)
    {
        try
        {
            File musicPath = new File(s);
            if (musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                //System.out.println("Play");

                //Thread.sleep(5000);
                //System.out.println("Stop");
                clip.stop();

                Thread.sleep(1000);

                // reset to 0
                clip.setMicrosecondPosition(0);
                clip.start();
            }
            else
            {
                System.out.println("There appears to be an error.");
            }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
