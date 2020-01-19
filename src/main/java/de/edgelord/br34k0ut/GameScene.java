package de.edgelord.br34k0ut;

import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.scene.Scene;

import java.util.Timer;
import java.util.TimerTask;

public class GameScene extends Scene {

    private static boolean firstRun = true;

    public GameScene() {

        addGameObject(new Player(100, 15));
        addGameObject(new Ball(12f));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                addGameObject(new Brick(150 + i * (16 + 50), 150 + j * 16));
            }
        }

        addBorders();

        Game.setPaused(true);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Game.setPaused(false);
            }
        }, firstRun ? 1000 : 500);

        firstRun = false;
    }

    private void addBorders() {
        addGameObject(new Border(-10, 0, 10, 540));
        //addGameObject(new Border(0, 540, 960, 10));
        addGameObject(new Border(960, 0, 10, 540));
        addGameObject(new Border(0, -10, 960, 10));
    }

    @Override
    public void onFixedTick() {
        super.onFixedTick();
    }
}
