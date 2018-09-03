package org.bklab.wot.warmonger;

import org.bklab.wot.warmonger.entity.ModEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("unused")
class ReadFileUtils {
    private Set<ModEntity> modEntitySet = new HashSet();

    ReadFileUtils() {
    }

    static void updateModsList() {
        UrlDownloader.create().downloadFile("", Config.GBOX_PATH, "Dwlist.lst", Config.DWLIST_URL);
        UrlDownloader.create().downloadFile("", Config.GBOX_PATH, "list.lst", Config.LIST_URL);
    }

    Set<ModEntity> readFiles(String path) {
        new File(path);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

            while (true) {
                String str = reader.readLine();
                if (str == null) {
                    reader.close();
                    break;
                }

                ModEntity mods = this.parseFileLists(str);
                if (mods != null) {
                    this.modEntitySet.add(mods);
                }
            }
        } catch (FileNotFoundException var6) {
            var6.printStackTrace();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        return this.modEntitySet;
    }

    private ModEntity parseFileLists(String alist) {
        if (alist.indexOf("[[") > 0) {
            alist = alist.substring(2);
        }

        alist = alist.substring(1, alist.length() - 2);
        String[] aMods = alist.split(",");

        for (int i = 0; i < aMods.length; ++i) {
            if (aMods[i].startsWith("\"") && aMods[i].endsWith("\"")) {
                aMods[i] = aMods[i].substring(1, aMods[i].length() - 1);
            }
        }

        return new ModEntity(aMods[0], aMods[1], aMods[2], aMods[3], aMods[4], aMods[5], aMods[6], aMods[7], aMods[8]);
    }

    boolean modsDownload() {
        int current = 0;
        int sum = this.modEntitySet.size();
        Iterator var3 = this.modEntitySet.iterator();

        while (var3.hasNext()) {
            ModEntity mods = (ModEntity) var3.next();
            PrintStream var10000 = System.out;
            StringBuilder var10001 = (new StringBuilder()).append("正在下载第 ");
            ++current;
            var10000.println(var10001.append(current).append("/").append(sum).append(" 个文件：").append(mods.getName()).toString());
            if (mods.getFileNames().endsWith("gif")) {
                UrlDownloader.create().downloadFile(mods.getFileNames(), null, mods.getName() + ".zip", "");
                UrlDownloader.create().downloadFile(mods.getPictureNames(), null, mods.getName() + ".jpg", "");
            }

            if (mods.getFileNames().endsWith("wbp")) {
                System.out.println(mods.getFileNames());
                UrlDownloader.create().downloadFile(mods.getFileNames(), null, mods.getName() + ".wbp", "");
            }
        }

        return true;
    }
}
