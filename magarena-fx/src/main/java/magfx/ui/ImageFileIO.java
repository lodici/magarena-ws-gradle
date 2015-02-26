package magfx.ui;

import java.io.File;
import magic.utility.MagicFileSystem;
import magic.utility.MagicFileSystem.DataPath;

public class ImageFileIO {

    public static File getCustomBackgroundImageFile() {
        return MagicFileSystem.getDataPath(DataPath.MODS).resolve("background.image").toFile();
    }

}
