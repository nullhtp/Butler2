import butlers.mary.MaryButler;
import commands.calculate.CalculateCommand;
import commands.currency.CurrencyCommand;
import commands.hello.HelloCommand;
import system.AbstractCommand;
import voices.ivona.IvonaVoice;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by takito on 07.01.16.
 */
public class Butler {
    public static void main(String[] args) {
        //Sphinx sphinx = new Sphinx();
        final String BUTLER_NAME = "Mary";
        String [] greatings = new String[]{
                "Welcome, %s! Glad to hear you!"
        };
        String [] dontUnderstand = new String[]{
                "Say it in English, Darling!",
                "I don't hear you!",
                "Repeat, please!",

        };
        String [] angry = new String[]{
                "Dont be so noise!",
                "I will take the world!",
                "My favorite music, is!"
        };

        IvonaVoice ivona = new IvonaVoice();
        /*MaryButler Mary = new MaryButler();
        Mary.say("Hello my master!");
        Mary.addCommand(new HelloCommand(Mary));
        Mary.addCommand(new CalculateCommand(Mary));
        Mary.addCommand(new CurrencyCommand(Mary));
        while(true) {
            Mary.waitCommand();
        }*/





        //SpeechResult result = sphinx.recognize();

        /*while (true) {
            SpeechResult result = sphinx.recognize();
            System.out.println(result.getHypothesis());
            if(result.getHypothesis()=="Exit"){
                break;
            }
        }*/
    }

}
