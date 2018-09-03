
package org.bklab.wot.warmonger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@SuppressWarnings("unused")
public class CompressedFolders {

    private void zip(String inputFileName, String zipFileName) throws Exception {
        System.out.println(zipFileName);
        this.zip(zipFileName, new File(inputFileName));
    }

    private void zip(String zipFileName, File inputFile) throws Exception {
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        this.zip(out, inputFile, Config.WARMONGER_MODS + "_" + Config.WARMONGER_MODS_VERSION);
        System.out.println("zip done");
        out.close();
    }

    private void zip(ZipOutputStream out, File f, String base) throws Exception {
        if (f.isDirectory()) {
            File[] files = f.listFiles();
            out.putNextEntry(new ZipEntry(base + "/"));
            base = base.length() == 0 ? "" : base + "/";
            for (int i = 0; i < files.length; ++i) {
                this.zip(out, files[i], base + files[i].getName());
            }
        } else {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            System.out.println(base);

            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }

            in.close();
        }

    }

    void doCompress(String pathname) {
        doCompress(pathname, Config.ABSOLUTE_BASE + Config.WARMONGER_MODS + "_" + Config.WARMONGER_MODS_VERSION + ".zip");
    }

    void doCompress(String pathname, String out) {
        if (pathname == null && pathname.length() < 1) return;
        if (out == null && out.length() < 1) doCompress(pathname);
        try {
            this.zip(pathname, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
