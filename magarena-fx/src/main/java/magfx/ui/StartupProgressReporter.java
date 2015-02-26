package magfx.ui;

import magic.utility.ProgressReporter;

public class StartupProgressReporter extends ProgressReporter {

    @Override
    public void setMessage(String message) {
        ScreenController.showStartupMessage(message);
    }

}
