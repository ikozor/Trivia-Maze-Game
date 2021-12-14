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
            e.printStackTrace();
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
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
        return url;
    }

    public boolean load(String audioFile) {
        try {
            setFilename(audioFile);
            audioInput = AudioSystem.getAudioInputStream(getURL(filename));
            clip.open(audioInput);
            return true;
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
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



