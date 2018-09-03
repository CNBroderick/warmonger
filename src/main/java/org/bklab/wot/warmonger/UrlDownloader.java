package org.bklab.wot.warmonger;

import org.bklab.wot.warmonger.tools.FileSizeUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("unused")
public class UrlDownloader {
    public static boolean forceUpdate = false;
    static int index = 0;
    private String urlPath;
    private String downloadDir;
    private String fileFullName;
    private static File file;

    public UrlDownloader() {
    }

    public static UrlDownloader create() {
        return new UrlDownloader();
    }

    public File downloadFile(String fileNames, String downloadDir, String fileFullName, String urlPath) {
        File file = null;
        if (downloadDir == null || downloadDir.equals("")) {
            downloadDir = Config.BASE_DIRECTORY;
        }

        if (fileNames.endsWith("gif")) {
            urlPath = "http://list.guazihe.com/0tkmod/pack/" + fileNames;
            downloadDir = downloadDir + File.separator + "gbox";
        }

        if (fileNames.endsWith("jpg")) {
            urlPath = "http://list.guazihe.com/0tkbox/image/" + fileNames;
            downloadDir = downloadDir + File.separator + "gbox";
        }

        if (fileNames.endsWith("wbp")) {
            urlPath = "http://wbp.guazihe.com/0tkbox/pack/" + fileNames;
            downloadDir = downloadDir + File.separator + "wbp";
            if (fileNames.indexOf("涂装") > 0) {
                downloadDir = "/data/wwwroot/default/wot/p/";
            }
        }

        this.urlPath = urlPath;
        this.downloadDir = downloadDir;
        this.fileFullName = fileFullName;
        return startDownload();
    }

    public File startDownload() {
        try {
            URL url = new URL(urlPath);
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.connect();
            int fileLength = httpURLConnection.getContentLength();
            String filePathUrl = httpURLConnection.getURL().getFile();
            System.out.println("file length---->" + FileSizeUtils.fileSize(fileLength));
            URLConnection con = url.openConnection();
            BufferedInputStream bin = new BufferedInputStream(httpURLConnection.getInputStream());
            String path = downloadDir + File.separatorChar + fileFullName;
            file = new File(path);
            if (file.exists() && file.lastModified() > System.currentTimeMillis() - (new SimpleDateFormat("yyyy-MM-dd")).parse((new SimpleDateFormat("yyyy-MM-dd")).format(new Date())).getTime() && !forceUpdate) {
                System.out.println("由于文件已存在被跳过");
                File var19 = file;
                return file;
            }

            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }

            OutputStream out = new FileOutputStream(file);
            int len = 0;
            byte[] buf = new byte[8192];

            int size;
            while ((size = bin.read(buf)) != -1) {
                len += size;
                out.write(buf, 0, size);
            }

            bin.close();
            out.close();
            System.out.println("No." + ++index + " 下载完毕：" + path);
            return file;
        } catch (MalformedURLException var16) {
            var16.printStackTrace();
        } catch (IOException var17) {
            System.out.println("下载失败：" + fileFullName + " [" + urlPath + "] " + var17.getLocalizedMessage());
            return file;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return file;
    }
}
