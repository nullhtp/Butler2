package commands.hello;

import system.AbstractButler;
import system.AbstractCommand;
import system.Answer;
import system.AnswerState;

import java.util.Random;

/**
 * Created by takito on 08.01.16.
 */
public class HelloCommand extends AbstractCommand {
    AbstractButler butler;
    String [] name ;
    String [] greeting;

    public HelloCommand(AbstractButler butler) {
        super("Hello");
        this.butler = butler;
        this.name= new String[] {"Anton","my master", "creator", "darling"};
        this.greeting= new String[] {"Hello","Greetings","Glad to see you"};
    }

    @Override
    public Answer doCommand() {
        Random rand = new Random();
        return new Answer(AnswerState.Done,String.format("%s, %s!",
                greeting[Math.abs(rand.nextInt()%greeting.length)],
                name[Math.abs(rand.nextInt()%greeting.length)]
                ));
    }
}
