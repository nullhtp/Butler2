package system;

/**
 * Created by takito on 07.01.16.
 */
public class Answer {
    public final AnswerState state;
    public final String text;

    public Answer(AnswerState state, String text) {
        this.state = state;
        this.text = text;
    }
}

