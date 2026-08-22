interface Camera {
    void takePhoto();
}

interface MusicPlayer {
    void playMusic();
}

class Mobile implements Camera, MusicPlayer {

    public void takePhoto()
    {
        System.out.println("Taking photo");
    }
    public void playMusic()
    {
        System.out.println("Playing music");
    }
    public static void main(String[] args) {
        Mobile m = new Mobile();
        m.playMusic();
        m.takePhoto();
    }
}