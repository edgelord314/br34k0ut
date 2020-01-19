package de.edgelord.br34k0ut;

import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.core.GameConfig;
import de.edgelord.saltyengine.core.GraphicsConfiguration;
import de.edgelord.saltyengine.displaymanager.display.SplashWindow;
import de.edgelord.saltyengine.displaymanager.stage.Stage;
import de.edgelord.saltyengine.scene.SceneManager;

public class Main extends Game {

    public static void main(String[] args) {
        init(GameConfig.config(960, 540, "Br34k0ut", 5));
        start(60, SplashWindow.Splash.NO_SPLASH);

        GraphicsConfiguration.renderingHints = Stage.lqRenderingHints;

        SceneManager.setCurrentScene(new GameScene());
    }
}
