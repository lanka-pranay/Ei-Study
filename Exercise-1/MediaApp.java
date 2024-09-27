//structural design pattern
//Example 2

//Use Case: A media player that supports both MP3 and VLC formats through an adapter.
interface MediaPlayer {
    void play(String audioType, String filename);
}

class AudioPlayer implements MediaPlayer {
    @Override
    public void play(String audioType, String filename) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3: " + filename);
        } else if (audioType.equalsIgnoreCase("vlc")) {
            MediaAdapter mediaAdapter = new MediaAdapter();
            mediaAdapter.play(audioType, filename);
        } else {
            System.out.println("Invalid media type: " + audioType);
        }
    }
}

class MediaAdapter implements MediaPlayer {
    @Override
    public void play(String audioType, String filename) {
        if (audioType.equalsIgnoreCase("vlc")) {
            System.out.println("Playing VLC: " + filename);
        } else {
            System.out.println("Unsupported format: " + audioType);
        }
    }
}

// Example usage
public class MediaApp {
    public static void main(String[] args) {
        MediaPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");
        player.play("vlc", "movie.vlc");
        player.play("wav", "sound.wav");
    }
}