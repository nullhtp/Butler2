package commands.calculate;

import system.AbstractButler;
import system.AbstractCommand;
import system.Answer;
import system.AnswerState;

import java.util.List;

import static commands.calculate.CalculateCommand.Operation.MULTIPLY;

/**
 * Created by takito on 08.01.16.
 */
public class CalculateCommand extends AbstractCommand {

    final AbstractButler butler;
    public CalculateCommand(AbstractButler butler) {
        super("calculate");
        this.butler = butler;
    }

    @Override
    public Answer doCommand() {
        int first = getDigit();
        if (first == -1) return new Answer(AnswerState.Warning,"You canceled calculation!");
        Operation operation = getOperation();
        if (operation == Operation.EXIT) return new Answer(AnswerState.Warning,"You canceled calculation!");
        int second = getDigit();
        if (second == -1) return new Answer(AnswerState.Warning,"You canceled calculation!");

        switch (operation){
            case MULTIPLY: return new Answer(AnswerState.Done,String.format("%d multiply %d equals %d",first,second,first*second));
            case MINUS: return new Answer(AnswerState.Done,String.format("%d minus %d equals %d",first,second,first-second));
            case PLUS: return new Answer(AnswerState.Done,String.format("%d plus %d equals %d",first,second,first+second));
            case DIVIDE: return new Answer(AnswerState.Done,String.format("%d divide %d equals %.3f",first,second,((float)first/second)));
        }

        return null;
    }

    private int getDigit(){
        butler.say("Say digit!");
        while(true){
            List<String> words = butler.listen();
            for (String word :
                    words) {
                switch (word.toLowerCase()) {
                    case "one": butler.say("one"); return 1;
                    case "two": butler.say("two"); return 2;
                    case "three": butler.say("three"); return 3;
                    case "four": butler.say("four"); return 4;
                    case "five": butler.say("five"); return 5;
                    case "six": butler.say("six"); return 6;
                    case "seven": butler.say("seven"); return 7;
                    case "eight": butler.say("eight"); return 8;
                    case "nine": butler.say("nine"); return 9;
                    case "zero": butler.say("zero"); return 0;
                    case "cancel": butler.say("I get it"); return -1;
                }
            }
        }
    }

    private Operation getOperation(){
        butler.say("Say operation!");

        while(true){
            List<String> words = butler.listen();
            for (String word :
                    words) {
                switch (word.toLowerCase()) {
                    case "minus": butler.say("minus"); return Operation.MINUS;
                    case "plus": butler.say("plus"); return Operation.PLUS;
                    case "multiply": butler.say("multiply"); return MULTIPLY;
                    case "divide": butler.say("divide"); return Operation.DIVIDE;
                    case "cancel": butler.say("I get it"); return Operation.EXIT;
                }
            }
        }
    }
    enum Operation{
        PLUS,MINUS,MULTIPLY,DIVIDE,EXIT
    }
}
