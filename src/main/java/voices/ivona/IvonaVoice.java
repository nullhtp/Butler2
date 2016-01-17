package voices.ivona;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.ivona.services.tts.IvonaSpeechCloudClient;
import com.ivona.services.tts.model.CreateSpeechRequest;
import com.ivona.services.tts.model.CreateSpeechResult;
import com.ivona.services.tts.model.Input;
import com.ivona.services.tts.model.Voice;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by takito on 10.01.16.
 */
public class IvonaVoice extends system.AbstractVoice {
    private static IvonaSpeechCloudClient speechCloud;
    AudioStream audioStream;

    public IvonaVoice() {
        init();

        CreateSpeechRequest createSpeechRequest = new CreateSpeechRequest();
        Input input = new Input();
        Voice voice = new Voice();

        voice.setName("Salli");
        input.setData("This is a sample text to be synthesized.");

        createSpeechRequest.setInput(input);
        createSpeechRequest.setVoice(voice);
        InputStream in = null;

        try {

            CreateSpeechResult createSpeechResult = speechCloud.createSpeech(createSpeechRequest);

            System.out.println("\nSuccess sending request:");
            System.out.println(" content type:\t" + createSpeechResult.getContentType());
            System.out.println(" request id:\t" + createSpeechResult.getTtsRequestId());
            System.out.println(" request chars:\t" + createSpeechResult.getTtsRequestCharacters());
            System.out.println(" request units:\t" + createSpeechResult.getTtsRequestUnits());

            System.out.println("\nStarting to retrieve audio stream:");

            in = createSpeechResult.getBody();
            audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);

            /*byte[] buffer = new byte[2 * 1024];
            int readBytes;

            while ((readBytes = in.read(buffer)) > 0) {
                // In the example we are only printing the bytes counter,
                // In real-life scenario we would operate on the buffer
                System.out.println(" received bytes: " + readBytes);
                outputStream.write(buffer, 0, readBytes);
            }

            System.out.println("\nFile saved: " + outputFileName);*/

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void init() {
        speechCloud = new IvonaSpeechCloudClient(
                new ClasspathPropertiesFileCredentialsProvider("/res/ivona/IvonaCredentials.properties"));
        speechCloud.setEndpoint("https://tts.eu-west-1.ivonacloud.com");
    }

    @Override
    public void say(String text) {

    }
}
