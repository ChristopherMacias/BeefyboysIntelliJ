package christopher.macias.connect.model;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;


public class Music {
    public static ArrayList<File> songs = new ArrayList<>();
    public static ArrayList<String> songNames = new ArrayList<>();
    public static int currentSong = 0;
    static AudioInputStream audioStream;
    static Clip clip;





        public static void addSongs() {
            //Makes playlist
            songs.clear();
            songNames.clear();
            songs.add(new File("src/BeffyTunes/ESongs/Black Mambo (Stripped).wav"));
            songNames.add("Black Mambo -  : Elijah");

            songs.add(new File("src/BeffyTunes/JSongs/Anamanaguchi & Flux Pavilion - Dreams [Monstercat Release].wav"));
            songNames.add("Anamanaguchi & Flux Pavilion - Dreams : James");
            /*songs.add(new File("src/V/o/ABlackjack/Songs/Chris/El Komander - Soy De Rancho.wav"));
            songNames.add("Soy De Rancho - El Komander : Chris");*/
            songs.add(new File("src/BeffyTunes/QSongs/Amber Mark - FOMO (Visualiser).wav"));
            songNames.add("Amber Mark - FOMO : Quincy");




            songs.add(new File("src/BeffyTunes/JSongs/Anamanaguchi - Water Resistant (feat. 8485) [Monstercat Release].wav"));
            songNames.add("Anamanaguchi - Water Resistant (feat. 8485) : James");
            songs.add(new File("src/BeffyTunes/JSongs/Death Parade Opening Lyrics - Flyers with Romaji+English.wav"));
            songNames.add("Death Parade Opening Lyrics - Flyers with : James");
            songs.add(new File("src/BeffyTunes/JSongs/Lil Wayne - How to Love (Audio).wav"));
            songNames.add("Lil Wayne - How to Love : James");
            songs.add(new File("src/BeffyTunes/JSongs/Spongebob singing Goofy Goober Rock.wav"));
            songNames.add("Spongebob singing Goofy Goober Rock : James");

            songs.add(new File("src/BeffyTunes/QSongs/Bruno Mars, Anderson .Paak, Silk Sonic - Smokin Out The Window [Official Music Video].wav"));
            songNames.add("Djadja - Aya Nakamura : Quincy");
            songs.add(new File("src/BeffyTunes/QSongs/Do I Do.wav"));
            songNames.add("Vein - Tora-i : Quincy");
            songs.add(new File("src/BeffyTunes/QSongs/Eastside.wav"));
            songNames.add("Invisible - Yuna : Quincy");
            songs.add(new File("src/BeffyTunes/QSongs/MESS U MADE.wav"));
            songNames.add("Serial - Tora-i : Quincy");


            /*songs.add(new File("src/V/o/ABlackjack/Songs/Chris/Avantasia - Lost in Space.wav"));
            songNames.add("Lost in Space - Avantasia : Chris");
            songs.add(new File("src/V/o/ABlackjack/Songs/Chris/Chalino Sanchez - Alma enamorada.wav"));
            songNames.add("Alma enamarado - Chalino Sanchez : Chris");
            songs.add(new File("src/V/o/ABlackjack/Songs/Chris/Vicente Fernandez - Mujeres divinas.wav"));
            songNames.add("Mujeres divinas - Vicente Fernandez : Chris");
            songs.add(new File("src/V/o/ABlackjack/Songs/Chris/Vicente Fernández - Por Tu Maldito Amor.wav"));
            songNames.add("Por Tu Maldito Amor - Vicente Fernandez : Chris");*/

            songs.add(new File("src/BeffyTunes/ESongs/Luidji - Gisèle - Part 4 (Piano session).wav"));
            songNames.add("Luidji - Gisèle - Part 4 (Piano session): Elijah");
            songs.add(new File("src/BeffyTunes/ESongs/mint chocolate chip.wav"));
            songNames.add("mint chocolate chip : Elijah");
            songs.add(new File("src/BeffyTunes/ESongs/Ousama Ranking OP_Opening 2 Full『Hadaka no Yuusha』by Vaundy.wav"));
            songNames.add("Ousama Ranking OP_Opening 2 Full『Hadaka no Yuusha』by Vaundy : Elijah");
            songs.add(new File("src/BeffyTunes/ESongs/Skate.wav"));
            songNames.add("Skate : Elijah");

            //Collections.shuffle(Songs);


            try {
                //Plays music through filepath array
                audioStream = AudioSystem.getAudioInputStream(songs.get(0));
                clip = AudioSystem.getClip();
                clip.stop();
                clip.close();
                clip.open(audioStream);
                clip.loop(15);
            } catch (Exception e) {
                System.out.println(e.toString());
                System.out.println("Beefy Bois doesn't know how to code. Sorry.");
            }
        }

        public static void stopSong(){
            clip.stop();
            clip.close();
        }

        public static void nextSong() {
            if (currentSong == 15) {
                currentSong = 0;
            } else {
                currentSong += 1;
            }
            changeSong();
        }

        public static void prevSong() {

            if (currentSong == 0) {
                currentSong = 15;
            } else {
                currentSong -= 1;
            }
            changeSong();
        }

        private static void changeSong() {
            try {
                clip.stop();
                clip.close();
                audioStream = AudioSystem.getAudioInputStream(songs.get(currentSong));
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.loop(15);
                System.out.println("Now playing: " + songNames.get(currentSong));
            } catch (Exception e) {
                System.out.println("Elijah still doesn't know how to code. sorry");
            }
        }

    public static void currentSongs(){
    System.out.println("Now playing: " + songNames.get(currentSong));
    }
}



