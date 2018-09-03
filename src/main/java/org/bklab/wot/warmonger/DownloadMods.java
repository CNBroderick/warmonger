package org.bklab.wot.warmonger;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public class DownloadMods {
    public static DownloadMods create() {
        return new DownloadMods();
    }

    public static void main(String[] args) {
        DownloadMods.create().start();
    }

    public void start() {
        ReadFileUtils.updateModsList();
        ReadFileUtils utils = new ReadFileUtils();
        utils.readFiles(Config.DWLIST);
//        utils.readFiles(Config.LIST);
        utils.modsDownload();
        String baseDir = Config.BASE_DIRECTORY + Config.WARMONGER_MODS + "_" + Config.WARMONGER_MODS_VERSION;
        System.out.println("baseDir: " + baseDir);
        new FileLocationManager().moving(baseDir);
        new CompressedFolders().doCompress(baseDir, Config.ABSOLUTE_BASE + Config.WARMONGER_MODS + "_" + Config.WARMONGER_MODS_VERSION + ".zip");
        new ReplaceUpdateTime().doReplace();
//        Deprecated
//        UploadToBeijingServer.create().setBase(Config.ABSOLUTE_BASE + Config.WARMONGER_MODS + "_" + Config.WARMONGER_MODS_VERSION).start();

        try {
            FileUtils.deleteDirectory(new File(Config.ABSOLUTE_BASE + File.separator + Config.WARMONGER_MODS));
            FileUtils.deleteDirectory(new File(Config.ABSOLUTE_BASE + File.separator + "gbox"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
