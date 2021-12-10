import javax.imageio.IIOException;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.net.*;

import static java.lang.System.load;

public class Audio {
    private AudioInputStream audioInput;
    private Clip clip;

    public Clip getClip() {
        return clip;
    }

    private boolean looping = false;

    public void setLooping(boolean _looping) {
        looping = _looping;
    }

    public boolean getLooping() {
        return looping;
    }

    private int repeat = 0;

    public void setRepeat(int _repeat) {
        repeat = _repeat;
    }

    public int getRepeat() {
        return repeat;
    }


    private String filename = "";

    public void setFilename(String _filename) {
        filename = _filename;
    }

    public String getFilename() {
        return filename;
    }

    public boolean isLoad() {
        return audioInput != null;
    }


    /**
     * Constructor
     */
    public Audio() {
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
        }
    }

    public Audio(String audioFile) {
        this();
        load(audioFile);
    }

    private URL getURL(String filename) {
        URL url = null;
        try {
            url = this.getClass().getResource(filename);
        } catch (Exception e) {
        }
        return url;
    }

    public boolean load(String audioFile) {
        try {
            setFilename(audioFile);
            audioInput = AudioSystem.getAudioInputStream(getURL(filename));
            clip.open(audioInput);
            return true;
        } catch (IOException e) {
            return false;
        } catch (UnsupportedAudioFileException e) {
            return false;
        } catch (LineUnavailableException e) {
            return false;
        }
    }

    public void play() {
        if (!isLoad()) return;
        clip.setFramePosition(0);
        if (looping)
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        else
            clip.loop(repeat);
    }

    public void stop() {
        clip.stop();
    }
}
    /**
     * This method play music background
     *//*
    public void playMusic(String filepath) {
        Scanner scanner = new Scanner(System.in);
        try {
            File audioPath = new File(filepath);
            if(audioPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                String response = scanner.next();
            } else {
                System.out.println("File does not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

   public static void stopMusic() {

   }*/


