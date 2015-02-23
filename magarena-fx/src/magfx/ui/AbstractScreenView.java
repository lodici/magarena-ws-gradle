package magfx.ui;

import javafx.scene.control.LabelBuilder;
import javafx.scene.effect.DropShadowBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public abstract class AbstractScreenView extends BorderPane {

//        setStyle(
//                "-fx-border-color: green; -fx-border-style: dashed; " +
//                "-fx-background-color: rgba(255, 255, 255, 0);"
//        );

    protected void setScreenTitle(final String title) {
        setTop(LabelBuilder.create()
                .text(title)
                .textFill(Color.WHITE)
                .styleClass("screenCaption")
                .effect(DropShadowBuilder.create()
                        .offsetY(4.0)
                        .offsetX(4.0)
                        .color(Color.CORAL)
                        .build()
                )
                .build()
        );
    }

}
