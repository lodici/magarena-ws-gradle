package magfx.ui;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBoxBuilder;

public class MainMenuView extends AbstractMenuView {

    public MainMenuView() {
        setScreenTitle("Main menu");
        setCenter(getScreenContent());
    }

    @SuppressWarnings("deprecation")
    private Node getScreenContent() {
        return VBoxBuilder.create()
                .alignment(Pos.CENTER)
                .spacing(8)
                .children(
                        getMenuButton("Cards Explorer", e -> {
                            ScreenController.showCardsExplorerScreen();
                        }),
                        getMenuButton("Toggle full screen", e -> {
                            ScreenController.toggleFullScreenMode();
                        }),
                        getMenuButton("Generate exception", e -> {
                            throw new RuntimeException("I DID THIS!");
                        }),
                        getMenuButton("Quit to desktop", e -> {
                            Platform.exit();
                        })
                )
                .build();
    }
    
}
