package butlers.mary;

import analizers.sphinx.SphinxAnalizer;
import edu.cmu.sphinx.result.WordResult;
import system.*;
import voices.mary.MaryVoice;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by takito on 08.01.16.
 */
public class MaryButler extends AbstractButler {

    private MaryButler(AbstractVoice voice,
                       AbstractAnalizer analizer,
                       List<AbstractCommand> commands,
                       String name)
    {
        super(voice, analizer, commands, name);
    }

    public MaryButler(List<AbstractCommand> commands) {
        this(new MaryVoice(),new SphinxAnalizer(),commands,"Mary");
    }

    public MaryButler() {
        this(new LinkedList<AbstractCommand>());
    }



    @Override
    public AbstractCommand waitCommand() {
        List<String> result = this.listen();
        for (String res: result) {
            for (AbstractCommand command: commands) {
                if(command.NAME.toLowerCase().contains(res.toLowerCase())){
                    Answer answer = doCommand(command);
                    say(answer.text);
                }
            }
        }
        return null;
    }

    @Override
    public List<String> listen() {
        List<String> result = ANALIZER.waitCommand();
        return result;
    }

}
