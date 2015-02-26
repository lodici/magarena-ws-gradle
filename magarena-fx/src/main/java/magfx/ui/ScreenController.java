package magfx.ui;

import com.sun.javafx.css.StyleManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import jfxtras.scene.menu.CirclePopupMenu;
import magfx.data.MagarenaConstants;
import magfx.utility.MagicResources;
import magic.utility.MagicSystem;

public final class ScreenController {

    private static Stage stage;
    private static ScreensStackPane screensStackPane;

    public static void showCardsExplorerScreen() {
        showScreen(new CardsExplorerView());
    }

    public static void showMainMenuScreen() {
        showScreen(new MainMenuView());
    }

    private static void showScreen(final Node screenNode) {
        createCircularMenu(screenNode);
        screensStackPane.showScreen(screenNode);
    }

    public static void setStage(final Stage newStage) {

        stage = newStage;
        screensStackPane = new ScreensStackPane();

        Application.setUserAgentStylesheet(null);
        StyleManager.getInstance().addUserAgentStylesheet(MagicResources.getCssFileUrl("default.css").toExternalForm());

        // suppresses the "Press ESC to exit full-screen mode" message. (Java 8 Only!)
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        stage.setTitle(getStageTitle());
        stage.setScene(new Scene(screensStackPane, Color.BLACK));
        stage.setMinHeight(600);
        stage.setMinWidth(1024);
        stage.setFullScreen(!Boolean.getBoolean("startWindowed"));
        stage.show();

    }

    private static void createCircularMenu(final Node node) {
        final CirclePopupMenu cMenu = new CirclePopupMenu(node, MouseButton.SECONDARY);
        for (int i = 0; i < 6; i++) {
            final MenuItem menuItem1 = registerAction(new MenuItem("Menu" + i,
                new ImageView(MagicResources.getIconImage("log.png"))));
            cMenu.getItems().add(menuItem1);
        }
    }

    private static MenuItem registerAction(final MenuItem menuItem) {
        menuItem.setOnAction((ActionEvent event) -> {
            ScreenController.showInfoMessage("You clicked the " + menuItem.getText() + " icon");
        });
        return menuItem;
    }

    private static String getStageTitle() {
        return "Magarena "
                .concat(MagarenaConstants.VERSION)
                .concat(MagicSystem.isDevMode() ? " [DEV MODE]" : "")
                .concat("  [F11 : full screen]");
    }

    public static void showInfoMessage(final String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showWarningMessage(final String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Information");
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void showExceptionDialog(final String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("An unexpected problem has occurred:");
        alert.setContentText(message);
        alert.setResizable(true);
        alert.showAndWait();
    }

    static void toggleFullScreenMode() {
        stage.setFullScreen(!stage.isFullScreen());
    }

    public static void showStartupMessage(String message) {
        Platform.runLater(() -> {
            screensStackPane.showStartupProgress(message);
        });
        
    }

}
