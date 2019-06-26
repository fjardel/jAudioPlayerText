package jaudioplayertext_pk;

import java.util.Scanner;

public class FrontPlayer {

	private final Scanner sc = new Scanner(System.in);
	private final BackPlayer back = new BackPlayer();
	private final InputAnalyzer inputAnalyzer = new InputAnalyzer();

	private String path = null;
	private String op = null;

	public FrontPlayer() {

		opening();

	}

	private void input() {

		System.out.print(" + ");
		path = String.valueOf(sc.nextLine());

		if (path.equals("exit")) {

			commands();

		} else {

			if (inputAnalyzer.pathValidator(path) == false) {

				System.out.println(" + this path is not valid! Try again");
				input();

			} else if (inputAnalyzer.pathValidator(path) == true) {

				if (inputAnalyzer.isDirectory(path) == true) {

					System.out.println(" + this is a directory! Try again");
					input();

				} else if (inputAnalyzer.isDirectory(path) == false) {

					if (inputAnalyzer.isValidFile(path) == false) {

						System.out.println(" + this file is incompatible or corrupted! Try again");
						input();

					} else if (inputAnalyzer.isValidFile(path) == true) {

						back.load(inputAnalyzer.createFile(path));
						System.out.println(" + " + inputAnalyzer.getName() + " | LOADED");
						commands();

					}

				}

			}

		}

	}

	private void commands() {

		System.out.print(" > ");
		op = String.valueOf(sc.nextLine());

		if ((op.equals("new")) || (op.equals("play")) || (op.equals("pause")) || (op.equals("resume"))
				|| (op.equals("stop")) || (op.equals("help")) || (op.equals("exit")) || (op.equals("status")) || (op.equals("time"))) {

			switch (op) {

			case "new":

				back.stopAudio();
				input();
				break;

			case "play":

				back.playAudio();
				commands();
				break;

			case "pause":

				back.pauseAudio();
				commands();
				break;

			case "resume":

				back.resumeAudio();
				commands();
				break;

			case "stop":

				back.stopAudio();
				input();
				break;

			case "help":

				help();
				break;

			case "exit":

				confirmedOut();
				break;

			case "status":

				status();
				break;
				
			case "time":

				//time(); falta finalizar
				commands();
				break;

			}

		} else {

			commands();

		}

	}

	private void confirmedOut() {

		System.out.println(" > CLOSER? (s/n)");
		System.out.print(" > ");
		op = String.valueOf(sc.nextLine());

		if ((op.equals("s")) || op.equals("n")) {

			if (op.equals("s")) {

				closing();

			} else if (op.equals("n")) {

				commands();

			}

		} else {

			confirmedOut();

		}

	}

	private void status() {

		System.out.println(" > " + back.getStatusPlayer());
		commands();

	}
	
	/*
	private void time() {

		System.out.println(" > " + back.getTimeAudio());
		commands();

	}
    */
	
	private void opening() {

		System.out.println(" > -----------------------------------------------");
		System.out.println(" >       ### Welcome to jAudioPlayerText ###      ");
		System.out.println(" > -----------------------------------------------");
		commands();

	}

	private void closing() {

		System.out.println(" > -----------------------------------------------");
		System.out.println(" >   ### Thank you for using jAudioPlayerText ### ");
		System.out.println(" > -----------------------------------------------");
		System.exit(0);

	}

	private void help() {

		System.out.println(" > -----------------------------------------------");
		System.out.println(" >              COMMANDS | FUNCTIONS              ");
		System.out.println(" > -----------------------------------------------");
		System.out.println(" >                  new  | To add new audio path  ");
		System.out.println(" >                  play | To play audio          ");
		System.out.println(" >                 pause | To pause audio         ");
		System.out.println(" >                resume | To resume audio        ");
		System.out.println(" >                  stop | To stop audio          ");
		System.out.println(" >                  help | To instructions        ");
		System.out.println(" >                  exit | To exit or back        ");
		System.out.println(" > -----------------------------------------------");
		System.out.println(" >               SYMBOLS | MEANINGS               ");
		System.out.println(" > -----------------------------------------------");
		System.out.println(" >                     + | New audio path         ");
		System.out.println(" >                     > | New command            ");
		System.out.println(" > -----------------------------------------------");
		commands();

	}

}