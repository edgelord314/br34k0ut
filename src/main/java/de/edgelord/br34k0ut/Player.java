package de.edgelord.br34k0ut;

import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.gameobject.GameObject;
import de.edgelord.saltyengine.input.Input;
import de.edgelord.saltyengine.input.MouseInputAdapter;
import de.edgelord.saltyengine.utils.Directions;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Player extends GameObject {

    private static final float SPEED = 3.5f;

    public static boolean autoMove = false;

    public Player(float width, float height) {
        super(Game.getHost().getHorizontalCentrePosition(width), 500, width, height, "player");

        Input.addMouseInputHandler(new MouseInputAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                setX(e.getX() - getWidth() / 2f);
            }
        });
    }

    @Override
    public void initialize() {

    }

    @Override
    public void onCollision(CollisionEvent collisionEvent) {
    }

    @Override
    public void onFixedTick() {

        if (autoMove) {
            if (GameScene.ball != null) {
                setX(GameScene.ball.getTransform().getCentre().getX() - getWidth() / 2f);
            }
        } else {
            if (Input.isInputLeft()) {
                move(SPEED, Directions.Direction.LEFT);
            } else if (Input.isInputRight()) {
                move(SPEED, Directions.Direction.RIGHT);
            }
        }
    }

    @Override
    public void draw(SaltyGraphics saltyGraphics) {
        saltyGraphics.setColor(Color.BLACK);
        saltyGraphics.drawRect(this);
    }
}
