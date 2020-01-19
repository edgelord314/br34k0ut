package de.edgelord.br34k0ut;

import de.edgelord.saltyengine.core.Game;
import de.edgelord.saltyengine.core.graphics.SaltyGraphics;
import de.edgelord.saltyengine.gameobject.DrawingRoutine;
import de.edgelord.saltyengine.scene.Scene;
import de.edgelord.saltyengine.scene.SceneManager;
import de.edgelord.saltyengine.ui.elements.Button;
import de.edgelord.saltyengine.utils.ColorUtil;

import java.awt.*;
import java.awt.event.MouseEvent;

public class MenuScene extends Scene {

    public MenuScene() {

        Main.audioPlayer.loop("menu-theme");

        Game.getHost().setBackgroundColor(ColorUtil.GOLD);

        addDrawingRoutine(new DrawingRoutine(DrawingRoutine.DrawingPosition.BEFORE_GAMEOBJECTS) {
            @Override
            public void draw(SaltyGraphics saltyGraphics) {
                saltyGraphics.setFont(saltyGraphics.getFont().deriveFont(Font.BOLD, 50f));
                saltyGraphics.setColor(ColorUtil.YELLOW_GREEN);
                saltyGraphics.drawText("Welcome to Br34k0ut!", Game.getGameWidth() / 2f, Game.getGameHeight() / 2f - 100, SaltyGraphics.TextAnchor.CENTRE);
            }
        });

        Button restartButton = new Button("Start", Game.getHost().getHorizontalCentrePosition(150), 310, 150, 50) {
            @Override
            public void onClick(MouseEvent mouseEvent) {
                SceneManager.setCurrentScene(new GameScene());
            }
        };
        restartButton.setBackgroundColor(ColorUtil.ACTIVE_GREEN);
        restartButton.setForegroundColor(ColorUtil.NAVY_BLUE_COLOR);
        restartButton.setFont(restartButton.getFont().deriveFont(Font.BOLD, 20f));

        Button exitButton = new Button("Exit", Game.getHost().getHorizontalCentrePosition(125), 370, 125, 50) {
            @Override
            public void onClick(MouseEvent mouseEvent) {
                System.exit(0);
            }
        };
        exitButton.setBackgroundColor(ColorUtil.HEART_RED);
        exitButton.setForegroundColor(ColorUtil.NAVY_BLUE_COLOR);
        exitButton.setFont(restartButton.getFont().deriveFont(Font.BOLD, 20f));

        getUI().addElement(restartButton);
        getUI().addElement(exitButton);
    }
}
