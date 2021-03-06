package de.edgelord.br34k0ut;

import de.edgelord.saltyengine.audio.AudioPlayer;
import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.core.GameConfig;
import de.edgelord.saltyengine.core.SceneManager;
import de.edgelord.saltyengine.factory.AudioFactory;
import de.edgelord.saltyengine.utils.SaltySystem;

public class Main extends Game {

    public static AudioPlayer audioPlayer = new AudioPlayer(new AudioFactory(SaltySystem.defaultResource));

    public static void main(String[] args) {
        init(GameConfig.config(960, 540, "Br34k0ut", 5));
        start(60);

        Game.setDrawFPS(false);
        loadAudio();

        SceneManager.setCurrentScene(new MenuScene());
    }

    private static void loadAudio() {
        audioPlayer.loadNewAudio("br34k0ut-theme", "Br34k0ut Theme.wav");
        audioPlayer.setClipVolume("br34k0ut-theme", .85f);

        audioPlayer.loadNewAudio("menu-theme", "Br34k0ut Menu.wav");
        audioPlayer.setClipVolume("menu-theme", .85f);
    }
}
