package voices.mary.libs;

import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.AudioPlayer;

import javax.sound.sampled.AudioInputStream;
import java.util.Set;

/**
 * Created by takito on 08.01.16.
 */
public class MarryTTS {

    public MarryTTS() {
    }

    public void say(String text) {
        MaryInterface marytts = null;
        AudioInputStream audio = null;
        try {
            marytts = new LocalMaryInterface();
            marytts.setAudioEffects("Stadium");
            Set<String> voices = marytts.getAvailableVoices();
            marytts.setVoice(voices.iterator().next());
            audio = marytts.generateAudio(text);
            AudioPlayer player = new AudioPlayer(audio);
            player.start();
            player.join();
        } catch (MaryConfigurationException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SynthesisException e) {
            e.printStackTrace();
        }
    }
}
