package jaudioplayertext;

import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioPlayer {

    private final JFXPanel fxPanel = new JFXPanel();

    private String url = null;
    protected Media audio = null;
    protected MediaPlayer player = null;

    protected void load(String url) {

        this.url = new File(url).toURI().toString();
        this.audio = new Media(this.url);
        this.player = new MediaPlayer(audio);

    }

    protected void playAudio() {

        if (player != null){
            
            player.play();
            
        }

    }

    protected void pauseAudio() {

        if (player != null){
            
            player.pause();
            
        }

    }
    
    protected void resumeAudio(){
        
        if (player != null){
            
            if (player.getStatus() == player.getStatus().PAUSED){
                
                player.play();
                
            }
            
        }
        
    }

    protected void stopAudio() {

        if (player != null){
            
            player.stop();
            
        }

    }
    
}
