package de.edgelord.br34k0ut;

import de.edgelord.saltyengine.components.FixedRate;
import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.scene.SceneManager;
import de.edgelord.saltyengine.transform.Transform;
import de.edgelord.saltyengine.utils.GeneralUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ball extends GameObject {

    private static final float SPEED = 1.5f;

    private FixedRate onionGhostCreator = new FixedRate(this, "onion-ghost-creator", 7);
    private List<Transform> pastPositions = new ArrayList<>();

    public Ball(float diameter) {
        super(Game.getHost().getHorizontalCentrePosition(diameter), 350, diameter, diameter, "ball");

        setRotationDegrees(GeneralUtil.randomInt(181, 359));
        addComponent(onionGhostCreator);
    }

    @Override
    public void initialize() {
        getPhysics().addTagToIgnore("player");
        getPhysics().addTagToIgnore("brick");
    }

    @Override
    public void onCollision(CollisionEvent collisionEvent) {
        switch (collisionEvent.getCollisionDirection()) {
            case RIGHT:
            case LEFT:
                setRotationDegrees(180 - getRotationDegrees());
                break;
            case UP:
            case DOWN:
                setRotationDegrees(360 - getRotationDegrees());
                break;
            case EMPTY:
                break;
        }

        moveToFacedDirection(SPEED * 2f);
    }

    @Override
    public void onFixedTick() {
        moveToFacedDirection(SPEED);

        if (!getTransform().isVisible()) {
            System.out.println("you lost!");
            try {
                SceneManager.reloadCurrentScene();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        if (onionGhostCreator.now()) {
            pastPositions.add((Transform) getTransform().clone());

            if (pastPositions.size() >= 15) {
                pastPositions.remove(0);
            }
        }
    }

    @Override
    public void draw(SaltyGraphics saltyGraphics) {

        saltyGraphics.setColor(Color.RED);
        saltyGraphics.drawOval(this);


        saltyGraphics.resetObjectRotation(this);
        for (Transform transform : pastPositions) {
            saltyGraphics.drawOval(transform);
            transform.setWidth(transform.getWidth() - .2f);
            transform.setHeight(transform.getHeight() - .2f);
            transform.setX(transform.getX() + .1f);
            transform.setY(transform.getY() + .1f);
        }
    }
}
