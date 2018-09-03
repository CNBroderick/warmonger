package org.bklab.wot.warmonger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@SuppressWarnings("unused")
public class FileModifyListener {

    private String md5, cachedMd5;
    private File newJsMd5 = new File(Config.ABSOLUTE_BASE + "newJs.md5");

    public static FileModifyListener create() {
        return new FileModifyListener();
    }

    public boolean checkModifying() {
        if (newJsMd5.exists() && newJsMd5.length() > 0) readMd5FromFile();
        else {
            cachedMd5 = getPageMd5().md5;
            writeMd5toFile();
        }

        getPageMd5();

        if (cachedMd5.equals(md5)) {
            return false;
        } else {
            writeMd5toFile();
            return true;
        }

    }

    private FileModifyListener readMd5FromFile() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(newJsMd5));
            StringBuilder md5Builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) md5Builder.append(line);
            reader.close();
            this.cachedMd5 = md5Builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

    private FileModifyListener writeMd5toFile() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(newJsMd5));
            writer.write(md5);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return this;
    }

    private FileModifyListener getPageMd5() {
        try {
            URL url = new URL(Config.NEWJS);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            reader.close();
            in.close();
            connection.disconnect();

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(builder.toString().getBytes(StandardCharsets.UTF_8));
            byte[] encryption = md5.digest();

            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < encryption.length; i++) {
                if (Integer.toHexString(0xff & encryption[i]).length() == 1) {
                    buffer.append("0").append(Integer.toHexString(0xff & encryption[i]));
                } else {
                    buffer.append(Integer.toHexString(0xff & encryption[i]));
                }
            }

            this.md5 = buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this;
    }

}
