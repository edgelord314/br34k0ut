package de.edgelord.br34k0ut;

import de.edgelord.saltyengine.components.rendering.RectangleRender;
import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.gameobject.EmptyGameObject;
import de.edgelord.saltyengine.scene.SceneManager;
import de.edgelord.saltyengine.utils.ColorUtil;

public class Brick extends EmptyGameObject {

    private RectangleRender rectangleRender = new RectangleRender(this, "rect-render");

    public Brick(float xPos, float yPos) {
        super(xPos, yPos, 50, 15, "brick");

        rectangleRender.setColor(ColorUtil.randomColor());
        addComponent(rectangleRender);
    }

    @Override
    public void onCollision(CollisionEvent event) {
        removeFromCurrentScene();
        Game.getHost().setBackgroundColor(rectangleRender.getColor());

        if (SceneManager.getCurrentScene().getGameObjectCount() <= 5) {
            Game.getHost().setBackgroundColor(ColorUtil.DARK_GRAY);
            SceneManager.setCurrentScene(new WinningScene(Game.getHost().getScreenshot()));
        }
    }
}
