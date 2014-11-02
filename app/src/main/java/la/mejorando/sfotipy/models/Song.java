package la.mejorando.sfotipy.models;

/**
 * Created by thespianartist on 25/09/14.
 */
public class Song {

    private String songName;
    private String songArtist;
    private float    stars;

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }
}
