package org.bklab.wot.warmonger;

import org.bklab.wot.warmonger.entity.ModEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("unused")
public class UpdateMods {
    private static Set<ModEntity> modEntitySet;

    public static UpdateMods create() {
        return new UpdateMods();
    }

    public static void main(String[] args) {
        UpdateMods.create().start();
    }

    private void start() {
        downloadUpdateIndex();
        String baseDir = Config.BASE_DIRECTORY + Config.WARMONGER_MODS + "_" + Config.WARMONGER_MODS_VERSION;
        new FileLocationManager().moving(baseDir);
        new CompressedFolders().doCompress(baseDir, Config.ABSOLUTE_BASE + Config.WARMONGER_MODS + "_" + Config.WARMONGER_MODS_VERSION + ".zip");
        new ReplaceUpdateTime().doReplace();
    }

    public void parseUpdateIndex(String singleLine) {
        if (singleLine.indexOf("res_wbp") <= 0) {
            String id = singleLine.substring(singleLine.indexOf("-") + 1, singleLine.indexOf(",")) + "-DW";
            String date = singleLine.substring(singleLine.lastIndexOf(",") + 1);
            Iterator var3 = modEntitySet.iterator();

            while (var3.hasNext()) {
                ModEntity wotMod = (ModEntity) var3.next();
                ModEntity mods = parseIdInModSets(id, date, wotMod);
                if (mods != null) {
                    UrlDownloader.forceUpdate = true;
                    UrlDownloader.create().downloadFile(mods.getFileNames(), Config.BASE_DIRECTORY, mods.getName() + ".wbp", "");
                }
            }

        }
    }

    private ModEntity parseIdInModSets(String id, String date, ModEntity wotMod) {
        if (wotMod.getId().equals(id) && Integer.parseInt((new SimpleDateFormat("MMdd")).format(new Date((new File(String.format(Config.BASE_DIRECTORY + "wbp" + File.separator + "%s.wbp", wotMod.getName()))).lastModified()))) - 1 < Integer.parseInt(date)) {
            System.out.printf("%s.wbp%n", wotMod.getName().trim());
            return wotMod;
        } else {
            return null;
        }
    }

    public File downloadUpdateIndex() {
        File newMods = UrlDownloader.create().downloadFile("", Config.BASE_DIRECTORY, "new.lst", Config.NEWJS);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(newMods), StandardCharsets.UTF_8));
            String s;
            while ((s = reader.readLine()) != null) parseUpdateIndex(s);
        } catch (IOException ignore) {
        }

        return newMods;
    }

    static {
        modEntitySet = new ReadFileUtils().readFiles(Config.DWLIST);
    }
}
