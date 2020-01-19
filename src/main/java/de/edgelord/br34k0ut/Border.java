package de.edgelord.br34k0ut;

import de.edgelord.saltyengine.core.event.CollisionEvent;
import de.edgelord.saltyengine.gameobject.EmptyGameObject;
import de.edgelord.saltyengine.utils.Directions;

public class Border extends EmptyGameObject {
    public Border(float xPos, float yPos, float width, float height) {
        super(xPos, yPos, width, height, "border");
    }

    @Override
    public void onCollision(CollisionEvent event) {
    }
}
