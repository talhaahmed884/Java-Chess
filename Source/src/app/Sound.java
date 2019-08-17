package app1;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound implements Runnable
{
    private boolean running = false;
    //private Thread thread;
    private boolean playSong = false;
    private AudioInputStream inputStream;
    private String url;
    private Clip clip;

    public Sound()
    {
        this.start();
    }

    public void start()
    {
        if(running)
        {
            return;        	
        }
        //this.thread = new Thread(this);
        this.running = true;
        //this.thread.start();
    }
    public void run()
    {
        while(running)
        {
            if(inputStream == null && playSong)
            {
                this.playSong = false;
                try
                {
                	this.clip = AudioSystem.getClip();
                	this.inputStream = AudioSystem.getAudioInputStream(new File(url).getAbsoluteFile());
                    this.clip.open(inputStream);
                    clip.start();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public void playBackGround(String string) // call to play .wav files only
    {
        if(this.clip != null)
        {
            this.clip.stop();
            this.clip.close();
        }
        this.playSong = true;
        this.inputStream = null;
        url=string;
    }

    public void disposeSound()			//to stop the sound
    {
        if(this.clip != null)
        {
            this.clip.stop();
            this.clip.close();
        }
        this.clip = null;
        this.playSong = false;
        this.inputStream = null;
    }
}