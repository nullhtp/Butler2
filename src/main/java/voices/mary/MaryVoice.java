package voices.mary;

import system.AbstractVoice;
import voices.mary.libs.MarryTTS;

/**
 * Created by takito on 08.01.16.
 */
public class MaryVoice extends AbstractVoice {
    MarryTTS mary;

    public MaryVoice(){
        this.mary = new MarryTTS();
    }

    @Override
    public void say(String text) {
        mary.say(text);
    }
}
