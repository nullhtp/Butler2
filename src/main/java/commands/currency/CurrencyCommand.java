package commands.currency;

import commands.currency.lib.SiteBankiRu;
import system.AbstractButler;
import system.AbstractCommand;
import system.Answer;
import system.AnswerState;

import java.util.List;

/**
 * Created by takito on 09.01.16.
 */
public class CurrencyCommand extends AbstractCommand {

    final AbstractButler butler;

    public CurrencyCommand(AbstractButler butler) {
        super("currency");
        this.butler = butler;
    }

    @Override
    public Answer doCommand() {
        butler.say("What currency your want?");
        while (true){
            List<String> words = butler.listen();
            for (String word :
                    words) {
                switch (word) {
                    case "dollar": return new Answer(AnswerState.Done,
                            String.format("Dollar, today,  %s", SiteBankiRu.getCurrencyValue("USD")));
                    case "euro": return new Answer(AnswerState.Done,
                            String.format("Euro, today,  %s",SiteBankiRu.getCurrencyValue("EUR")));
                    case "yuan": return new Answer(AnswerState.Done,
                            String.format("Yuan, today,  %s",SiteBankiRu.getCurrencyValue("CNY")));
                    case "cancel": return new Answer(AnswerState.Warning, "You canceled currency!");
                }
            }
        }
    }

}
