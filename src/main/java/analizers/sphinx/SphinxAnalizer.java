package analizers.sphinx;

import analizers.sphinx.libs.Sphinx;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;
import system.AbstractAnalizer;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by takito on 08.01.16.
 */
public class SphinxAnalizer extends AbstractAnalizer {
    Sphinx sphinx;

    public SphinxAnalizer() {
        this.sphinx = new Sphinx();
    }

    @Override
    public List <String> waitCommand() {
        SpeechResult result = sphinx.recognize();
        //List<WordResult> words = result.getWords();
        List<String> res = new LinkedList<String>();
        //for (WordResult word :
        //        words) {
        //    res.add(word.getWord().toString());
        //    System.out.println(res);

//        }
        res.add(result.getHypothesis());
        System.out.println(res);
        return res;
    }
}
