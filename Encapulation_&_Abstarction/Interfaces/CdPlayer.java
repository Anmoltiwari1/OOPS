package Interfaces;

/*
 * CdPlayer class
 * --------------
 * Implements the Media interface for CD-based music playback.
 */
public class CdPlayer implements Media {

    @Override
    public void start() {
        System.out.println("Music start");
    }

    @Override
    public void stop() {
        System.out.println("Music stops");
    }
}
