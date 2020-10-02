package de.edgelord.br34k0ut;

import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.core.SceneManager;
import de.edgelord.saltyengine.input.Input;
import de.edgelord.saltyengine.scene.Scene;
import de.edgelord.saltyengine.utils.ColorUtil;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class GameScene extends Scene {

    private static boolean firstRun = true;
    public static Ball ball;

    private static Color startColor = Game.getHost().getBackgroundColor();
    private static Color targetColor = Game.getHost().getBackgroundColor();
    private static double blendRatio = 0.0;
    private static double blendSteps = 0.0085;

    @Override
    public void initialize() {

        Main.audioPlayer.stop("menu-theme");
        Main.audioPlayer.loop("br34k0ut-theme");

        ball = new Ball(12f);
        addGameObject(new Player(100, 15));
        addGameObject(ball);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                addGameObject(new Brick(150 + i * (16 + 50), 100 + j * 16));
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

        if (Input.getKeyboardInput().isEscape()) {
            SceneManager.setCurrentScene(new MenuScene());
        }

        blendRatio += blendSteps;

        if (blendRatio >= 1.0d) {
            blendRatio = 1.0d;
        }
        Game.getHost().setBackgroundColor(ColorUtil.blend(startColor, targetColor, (float) blendRatio));
    }

    public static void startColorBlend(final Color end) {
        startColor = Game.getHost().getBackgroundColor();
        targetColor = end;
        blendRatio = 0.0f;
    }
}
