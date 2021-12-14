import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

/**
 * This class will create a background music.
 */
public class Audio {
    static Clip clip;
    float currentVolume = -12;
    FloatControl fc;
   

    /**
     * Get url of the sound file.
     * @param url
     */
    public void setFile(URL url) {
        try {
            AudioInputStream sound = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(sound);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        } catch (Exception e) {

        }
    }

    /**
     * play music
     */
    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    /**
     * Set loop for playing music
     */
    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Stop music
     */
    public void stop() {
        clip.stop();
    }
}






