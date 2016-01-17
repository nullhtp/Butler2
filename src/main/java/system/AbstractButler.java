package system;

import java.util.List;

/**
 * Created by takito on 07.01.16.
 */
abstract public class AbstractButler {
    public final String NAME;
    protected final AbstractVoice VOICE;
    protected final AbstractAnalizer ANALIZER;
    protected List<AbstractCommand> commands;

    protected AbstractButler(AbstractVoice voice,
                             AbstractAnalizer analizer,
                             List<AbstractCommand> commands,
                             String name) {
        this.VOICE = voice;
        this.ANALIZER = analizer;
        this.commands = commands;
        this.NAME = name;
    }

    public abstract AbstractCommand waitCommand();

    public Answer doCommand(AbstractCommand command) {
        Answer answer = command.doCommand();
        return answer;
    }

    public void say(String text) {
        VOICE.say(text);
    }

    public void addCommand(AbstractCommand command){
        commands.add(command);
    }

    public abstract List<String> listen();
}
