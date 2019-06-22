package jaudioplayertext;

import java.util.Scanner;

public class FrontendAPT {

    private final Scanner sc = new Scanner(System.in);
    private final AudioPlayer back = new AudioPlayer();

    private String path = null;
    private String op = null;

    public FrontendAPT() {

        opening();

    }

    private void input() {

        System.out.print(" + ");
        path = String.valueOf(sc.nextLine());

        if (path.equals("exit")) {

            commands();

        } else {

            back.load(path);
            commands();

        }

    }

    private void commands() {

        System.out.print(" > ");
        op = String.valueOf(sc.nextLine());

        if ((op.equals("new")) || (op.equals("play")) || (op.equals("pause")) || (op.equals("resume")) || (op.equals("stop")) || (op.equals("help")) || (op.equals("exit"))) {

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

                    confirmed();
                    break;

            }

        } else {

            commands();

        }

    }

    private void confirmed() {

        System.out.println(" > close? (s/n)");
        System.out.print(" > ");
        op = String.valueOf(sc.nextLine());

        if ((op.equals("s")) || op.equals("n")) {

            if (op.equals("s")) {

                closing();

            } else if (op.equals("n")) {

                commands();

            }

        } else {

            confirmed();

        }

    }

    private void opening() {

        System.out.println("==================================================");
        System.out.println("       *** Welcome to jAudioPlayerText ****       ");
        System.out.println("==================================================");
        commands();

    }

    private void closing() {

        System.out.println("==================================================");
        System.out.println("  *** Thank you for using jAudioPlayerText ****   ");
        System.out.println("==================================================");
        System.exit(0);

    }

    private void help() {

        System.out.println("==================================================");
        System.out.println("               COMMANDS | FUNCTIONS               ");
        System.out.println("==================================================");
        System.out.println("                   new  | To Load New Audio       ");
        System.out.println("                   play | To Play Audio           ");
        System.out.println("                  pause | To Pause Audio          ");
        System.out.println("                 resume | To Resume Audio          ");
        System.out.println("                   stop | To Stop Audio           ");
        System.out.println("                   help | To Instructions         ");
        System.out.println("                   exit | To Exit or Back         ");
        System.out.println("==================================================");
        System.out.println("                SYMBOLS | MEANINGS                ");
        System.out.println("==================================================");
        System.out.println("                      + | New URL to Audio        ");
        System.out.println("                      > | Commands                ");
        System.out.println("==================================================");
        commands();

    }

}
