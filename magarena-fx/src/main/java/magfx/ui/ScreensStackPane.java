package magfx.ui;

import java.net.URI;
import javafx.animation.FadeTransitionBuilder;
import javafx.animation.ParallelTransitionBuilder;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import magic.data.GeneralConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreensStackPane extends StackPane {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScreensStackPane.class);
    
    private final StartupView startupView;

    public ScreensStackPane() {
        startupView = new StartupView();
        setBackground(Background.EMPTY);
    }

    private static URI getBackgroundImageUri() {
        LOGGER.debug("{}", ImageFileIO.getCustomBackgroundImageFile().toURI());
        if (GeneralConfig.getInstance().isCustomBackground()) {
            return ImageFileIO.getCustomBackgroundImageFile().toURI();
        } else {
//          TODO:  return MagicStyle.getTheme().getTexture(Theme.TEXTURE_BACKGROUND);
            return ImageFileIO.getCustomBackgroundImageFile().toURI();
        }
    }

    private void setBackgroundImage() {
        LOGGER.debug("setBackgroundImage()");
        setStyle(
                "-fx-background-image: url('" + getBackgroundImageUri() + "'); "
                + "-fx-background-position: center center; "
                + "-fx-background-repeat: no-repeat; "
                + "-fx-background-size: cover; "
                + "-fx-border-color: red; -fx-border-style: dashed; "
        );
    }

    @SuppressWarnings("deprecation")
    public void showScreen(final Node newNode) {
        if (getBackground().isEmpty()) {
            setBackgroundImage();
        }
        getChildren().add(newNode);
        if (getChildren().size() > 1) {
            doFadeTransition(newNode);
        } else {
            FadeTransitionBuilder.create()
            .node(newNode)
            .fromValue(0.0)
            .toValue(1.0)
            .duration(Duration.millis(500.0))
            .build()
            .play();
        }
    }

    @SuppressWarnings("deprecation")
    private void doFadeTransition(final Node newNode) {

        ParallelTransitionBuilder.create()
                .children(
                        // fade out current screen.
                        FadeTransitionBuilder.create()
                        .node(getChildren().get(0))
                        .fromValue(1.0)
                        .toValue(0.0)
                        .duration(Duration.millis(500.0))
                        .onFinished(e -> {
                            getChildren().remove(0);
                        })
                        .build(),
                        // fade in new screen.
                        FadeTransitionBuilder.create()
                        .node(newNode)
                        .fromValue(0.0)
                        .toValue(1.0)
                        .duration(Duration.millis(500.0))
                        .build()
                )
                .build()
                .play();

    }

    @SuppressWarnings("deprecation")
    public void showStartupProgress(String message) {
        assert Platform.isFxApplicationThread();
        startupView.setText(message);
        if (!getChildren().contains(startupView)) {
            getChildren().add(startupView);
        }
    }

}
