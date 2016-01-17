package analizers.sphinx.libs;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechAligner;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;

import java.io.IOException;
import java.net.URL;

/**
 * Created by takito on 07.01.16.
 */
public class Sphinx {
    Configuration configuration;
    LiveSpeechRecognizer recognizer;

    public Sphinx() {
        this.configuration = new Configuration();
        // Set path to acoustic model.
        configuration.setAcousticModelPath("resource:/models/en-us/en-us/");
        // Set path to dictionary.
        //configuration.setDictionaryPath("resource:/models/en-us/cmudict-en-us.dict");
        configuration.setDictionaryPath("resource:/models/en-us/my.dict");
        configuration.setGrammarPath("resource:/models/en-us/grammar.gm");
        // Set language model.
        //configuration.setSampleRate(8);
        //configuration.setUseGrammar(true);


        configuration.setLanguageModelPath("resource:/models/en-us/en-us.lm.bin");
        try {
            recognizer = new LiveSpeechRecognizer(configuration);
        } catch (IOException e) {
            e.printStackTrace();
        }
        recognizer.startRecognition(true);

    }

    public SpeechResult recognize() {

        // Start recognition process pruning previously cached data.

        SpeechResult result = recognizer.getResult();
        /*while ((result = recognizer.getResult()) != null) {
            //System.out.println(result.getHypothesis());
            // Get individual words and their times.
            for (String r : result.getNbest(2)) {
                System.out.println(r);
            }
        }*/
        //= recognizer.getResult();
        // Pause recognition process. It can be resumed then with startRecognition(false).

        //recognizer.stopRecognition();

        return result;
    }

    public void say(String text) {
        /*try {
            //SpeechAligner aligner = new SpeechAligner(configuration);

            //recognizer.align(new URL("101-42.wav"), "one oh one four two");
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
