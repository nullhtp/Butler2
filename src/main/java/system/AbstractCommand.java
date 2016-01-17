package system;

/**
 * Created by takito on 07.01.16.
 */
abstract public class AbstractCommand implements ICommand {
    final public String NAME;

    public AbstractCommand(String name) {
        this.NAME = name;
    }

    abstract public Answer doCommand();

}
