package jaudioplayertext_pk;

import java.io.File;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BackPlayer {

	private final JFXPanel jfxPanel = new JFXPanel();

	private Media audio = null;
	private MediaPlayer player = null;

	protected void load(File file) {

		this.audio = new Media(file.toURI().toString());
		this.player = new MediaPlayer(audio);

	}

	protected void playAudio() {

		if (player != null) {

			player.play();

		}

	}

	protected void pauseAudio() {

		if (player != null) {

			player.pause();

		}

	}

	protected void resumeAudio() {

		if (player != null) {

			if (player.getStatus() == player.getStatus().PAUSED) {

				player.play();

			}

		}

	}

	protected void stopAudio() {

		if (player != null) {

			player.stop();

		}

	}

	/*
	protected int getTimeAudio() {

		if (player != null) {
			
			int i = 0;
			
			while (audio. > player.getCurrentTime()) {
				
				return i++;
				
			}

		}

		return 100;

	}
    */

	protected String getStatusPlayer() {

		if (player != null) {

			return player.getStatus().toString();

		}

		return "EMPTY";

	}

}