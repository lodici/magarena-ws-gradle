package magfx.ui;

import javafx.animation.FadeTransitionBuilder;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.effect.DropShadowBuilder;
import javafx.scene.effect.ReflectionBuilder;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import magfx.utility.MagicResources;

public class StartupView extends BorderPane {

    final Label messageLabel;

    @SuppressWarnings("deprecation")
    public StartupView() {

        messageLabel = LabelBuilder.create()
                .textFill(Color.WHITE)
                .styleClass("screenCaption")
                .effect(
                        DropShadowBuilder.create()
                        .offsetY(4.0)
                        .offsetX(4.0)
                        .color(Color.CORAL)
                        .build()
                )
                .alignment(Pos.TOP_CENTER)
                .prefWidth(Double.MAX_VALUE)
                .prefHeight(100.0)
                .build();

        final Node logoNode = ImageViewBuilder.create()
                .image(MagicResources.getTextureImage("splash.png"))
                .effect(
                        ReflectionBuilder.create()
                        .bottomOpacity(0.0)
                        .topOpacity(0.2)
                        .build())
                .opacity(0.0)
                .build();


        setCenter(logoNode);
        setBottom(messageLabel);

        FadeTransitionBuilder.create()
                .node(logoNode)
                .fromValue(0.0)
                .toValue(1.0)
                .duration(Duration.seconds(3))
                .build()
                .play();

    }

    public void setText(String text) {
        messageLabel.setText(text);
    }

}
  
