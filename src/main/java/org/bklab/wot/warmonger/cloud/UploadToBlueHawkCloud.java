package org.bklab.wot.warmonger.cloud;

import org.aarboard.nextcloud.api.NextcloudConnector;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class UploadToBlueHawkCloud {

    private NextcloudConnector lanyingCloud = getConnection();
    private static final String base = "warmongers";
    private String s = initString();

    public static UploadToBlueHawkCloud create() {
        return new UploadToBlueHawkCloud();
    }

    public NextcloudConnector getConnection() {
        return new NextcloudConnector(
                "xn--9kq.xn--fx1at73c.com",
                true,
                443,
                "Broderick",
                "lanying.cloud");
    }

    public UploadToBlueHawkCloud doUpload() {

        File upLoadDir = new File("E:\\Broderick Resources\\mods\\");
        List<File> modsList = Arrays.asList(upLoadDir.listFiles());
        System.out.println("start upload");

        InputStream stream = new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));
        lanyingCloud.uploadFile(stream, base + "/a.txt");

        modsList.forEach(file -> {
            if (file.getName().endsWith(".wbp") || file.getName().endsWith(".txt")) {
                try {
                    System.out.println("uploading " + file.getName());
                    FileInputStream stream1 = new FileInputStream(file);

                    String remotePath = base + "/" + getEncodeUrl(file.getName());
                    lanyingCloud.uploadFile(stream1, remotePath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        return this;
    }

    private UploadToBlueHawkCloud upload2() {


        return this;
    }

    private String getEncodeUrl(String s) {
        try {
            return URLEncoder.encode(s, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        new UploadToBlueHawkCloud().doUpload();
    }

    private String initString() {
        return "\n" +
                "<!DOCTYPE html>\n" +
                "<html class=\"ng-csp\" data-placeholder-focus=\"false\" lang=\"zh-CN\" data-locale=\"zh_Hans_CN\" >\n" +
                "\t<head data-user=\"Broderick\" data-user-displayname=\"Broderick Johansson\" data-requesttoken=\"jlmtG95FrlqO3l6V5uQav7WDdObkhEmabMIU1mPrjGE=:x3bgKoR2y226pjP5lYFCzvfMOoWOsnnyBIkghTuJ4hc=\">\n" +
                "\t\t<meta charset=\"utf-8\">\n" +
                "\t\t<title>\n" +
                "\t\t\t文件 - 蓝鹰云\t\t</title>\n" +
                "\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "\t\t<meta name=\"referrer\" content=\"no-referrer\">\n" +
                "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0\">\n" +
                "\t\t<meta name=\"apple-itunes-app\" content=\"app-id=1125420102\">\n" +
                "\t\t<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\n" +
                "\t\t<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\n" +
                "\t\t<meta name=\"apple-mobile-web-app-title\" content=\"蓝鹰云\">\n" +
                "\t\t<meta name=\"mobile-web-app-capable\" content=\"yes\">\n" +
                "\t\t<meta name=\"theme-color\" content=\"#7E4AFF\">\n" +
                "\t\t\n" +
                "<!-- Start: injected by Adguard -->\n" +
                "<script type=\"text/javascript\" src=\"https://gc.kis.v2.scr.kaspersky-labs.com/F349F725-DEE4-1E44-8AC1-10734D03087F/main.js\" charset=\"UTF-8\"></script><link rel=\"stylesheet\" crossorigin=\"anonymous\" href=\"https://gc.kis.v2.scr.kaspersky-labs.com/E97B6DAB-F70A-0740-8C6B-00B7D3E45849/abn/main.css\"/><script src=\"//local.adguard.com/adguard-ajax-api/injections/content-script.js?ts=63671127178650&amp;domain=xn--9kq.xn--fx1at73c.com&amp;mask=111\" nonce=\"94fa49cbf05e48dabe7829f94dd63165\" type=\"text/javascript\"></script>\n" +
                "<script src=\"//local.adguard.com/adguard-ajax-api/injections/userscripts.js?ts=63671126744548&name=Adguard%20Assistant%20Beta&name=AdGuard%20Popup%20Blocker%20(Beta)&name=Web%20of%20Trust%20Beta\" nonce=\"94fa49cbf05e48dabe7829f94dd63165\" type=\"text/javascript\"></script>\n" +
                "\n" +
                "<!-- End: injected by Adguard -->\n" +
                "<link rel=\"icon\" href=\"/core/img/favicon.ico\">\n" +
                "\t\t<link rel=\"apple-touch-icon-precomposed\" href=\"/core/img/favicon-touch.png\">\n" +
                "\t\t<link rel=\"mask-icon\" sizes=\"any\" href=\"/core/img/favicon-mask.svg\" color=\"#7E4AFF\">\n" +
                "\t\t<link rel=\"manifest\" href=\"/index.php/apps/theming/manifest?v=16\">\n" +
                "\t\t<link rel=\"stylesheet\" href=\"/core/vendor/select2/select2.css?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/core/vendor/jquery-ui/themes/base/jquery-ui.css?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/core/81c9-0911-jquery-ui-fixes.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/core/81c9-0911-server.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/core/81c9-0911-css-variables.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/apps/files_versions/css/versions.css?v=91a57076-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/apps/files_pdfviewer/css/style.css?v=38dfe638-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/apps/files_videoplayer/css/style.css?v=198068b3-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/firstrunwizard/70e2-0911-firstrunwizard.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/notifications/2c83-0911-styles.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/apps/sociallogin/css/style.css?v=e8edd0fd-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/core/81c9-0911-jquery.ocdialog.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/core/81c9-0911-results.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/files/d16b-0911-merged.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/apps/files_external/css/external.css?v=35c36e89-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/files_trashbin/1e6d-0911-trash.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/apps/activity/css/style.css?v=b1d71238-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/apps/audioplayer/css/3rdparty/fontello/css/fontello.css?v=c2ee74b6-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/comments/1bf6-0911-autocomplete.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/comments/1bf6-0911-comments.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/files_sharing/861d-0911-mergedAdditionalStyles.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/apps/files_markdown/css/../build/styles.css?v=9904a304-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/apps/files_markdown/css/preview.css?v=9904a304-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/files_texteditor/783c-0911-merged.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/apps/gallery/css/slideshow.css?v=f4d918f6-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/apps/gallery/css/gallerybutton.css?v=f4d918f6-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/apps/gallery/css/share.css?v=f4d918f6-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/apps/ownpad/css/ownpad.css?v=616702b3-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/core/81c9-0911-systemtags.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "<link rel=\"stylesheet\" href=\"/index.php/css/systemtags/1bf6-0911-systemtagsfilelist.css?v=cfc904b70d8dd37c2fdd363f39108749?v=3dd8c422-16\">\n" +
                "\t\t<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/core/vendor/core.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/index.php/js/core/merged-template-prepend.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/core/search/js/search.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/core/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/core/js/backgroundjobs.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/encryption/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/encryption/js/encryption.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/index.php/js/core/merged-share-backend.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_pdfviewer/js/previewplugin.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_videoplayer/js/viewer.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/firstrunwizard/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/firstrunwizard/js/jquery.colorbox.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/firstrunwizard/js/firstrunwizard.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/gallery/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/notifications/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/notifications/js/notifications.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/core/search/js/searchprovider.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/core/js/jquery-ui-fixes.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/core/js/files/fileinfo.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/core/js/files/client.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/core/js/contactsmenu.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/index.php/js/files/merged-index.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_sharing/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_sharing/js/app.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_sharing/js/sharedfilelist.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_external/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_external/js/statusmanager.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_external/js/rollingqueue.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_external/js/app.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_external/js/mountsfilelist.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_trashbin/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_trashbin/js/app.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_trashbin/js/filelist.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/activity/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/index.php/js/activity/activity-sidebar.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/audioplayer/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/audioplayer/js/soundmanager2-nodebug-jsmin.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/audioplayer/js/viewer/viewer.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/core/js/oc-backbone-webdav.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/comments/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/index.php/js/comments/merged.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/index.php/js/files_sharing/additionalScripts.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_versions/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/index.php/js/files_versions/merged.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/federatedfilesharing/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/federatedfilesharing/js/external.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_markdown/js/../build/editor.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/files_texteditor/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/index.php/js/files_texteditor/merged.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/index.php/js/gallery/scripts-for-file-app.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/ownpad/js/ownpad.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/index.php/js/core/merged.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/apps/systemtags/l10n/zh_CN.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\" defer src=\"/index.php/js/systemtags/merged.js?v=3dd8c422-16\"></script>\n" +
                "<script nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\">\n" +
                "var oc_debug=false;\n" +
                "var oc_isadmin=true;\n" +
                "var backendAllowsPasswordConfirmation=true;\n" +
                "var oc_dataURL=false;\n" +
                "var oc_webroot=\"\";\n" +
                "var oc_appswebroots={\"accessibility\":\"/apps/accessibility\",\"activity\":\"/apps/activity\",\"admin_audit\":\"/apps/admin_audit\",\"audioplayer\":\"/apps/audioplayer\",\"camerarawpreviews\":\"/apps/camerarawpreviews\",\"cloud_federation_api\":\"/apps/cloud_federation_api\",\"comments\":\"/apps/comments\",\"dav\":\"/apps/dav\",\"encryption\":\"/apps/encryption\",\"federatedfilesharing\":\"/apps/federatedfilesharing\",\"federation\":\"/apps/federation\",\"files\":\"/apps/files\",\"files_antivirus\":\"/apps/files_antivirus\",\"files_external\":\"/apps/files_external\",\"files_frommail\":\"/apps/files_frommail\",\"files_markdown\":\"/apps/files_markdown\",\"files_pdfviewer\":\"/apps/files_pdfviewer\",\"files_sharing\":\"/apps/files_sharing\",\"files_texteditor\":\"/apps/files_texteditor\",\"files_trashbin\":\"/apps/files_trashbin\",\"files_versions\":\"/apps/files_versions\",\"files_videoplayer\":\"/apps/files_videoplayer\",\"firstrunwizard\":\"/apps/firstrunwizard\",\"fulltextsearch\":\"/apps/fulltextsearch\",\"gallery\":\"/apps/gallery\",\"logreader\":\"/apps/logreader\",\"lookup_server_connector\":\"/apps/lookup_server_connector\",\"mail\":\"/apps/mail\",\"mindmaps\":\"/apps/mindmaps\",\"nextcloud_announcements\":\"/apps/nextcloud_announcements\",\"notifications\":\"/apps/notifications\",\"oauth2\":\"/apps/oauth2\",\"ownpad\":\"/apps/ownpad\",\"password_policy\":\"/apps/password_policy\",\"provisioning_api\":\"/apps/provisioning_api\",\"registration\":\"/apps/registration\",\"serverinfo\":\"/apps/serverinfo\",\"sharebymail\":\"/apps/sharebymail\",\"sociallogin\":\"/apps/sociallogin\",\"support\":\"/apps/support\",\"survey_client\":\"/apps/survey_client\",\"systemtags\":\"/apps/systemtags\",\"theming\":\"/apps/theming\",\"twofactor_backupcodes\":false,\"twofactor_gateway\":false,\"updatenotification\":\"/apps/updatenotification\",\"user_external\":\"/apps/user_external\",\"workflowengine\":\"/apps/workflowengine\"};\n" +
                "var datepickerFormatDate=\"yy\\/M\\/d\";\n" +
                "var nc_lastLogin=1535504444;\n" +
                "var nc_pageLoad=1535505884;\n" +
                "var dayNames=[\"\\u661f\\u671f\\u65e5\",\"\\u661f\\u671f\\u4e00\",\"\\u661f\\u671f\\u4e8c\",\"\\u661f\\u671f\\u4e09\",\"\\u661f\\u671f\\u56db\",\"\\u661f\\u671f\\u4e94\",\"\\u661f\\u671f\\u516d\"];\n" +
                "var dayNamesShort=[\"\\u5468\\u65e5\",\"\\u5468\\u4e00\",\"\\u5468\\u4e8c\",\"\\u5468\\u4e09\",\"\\u5468\\u56db\",\"\\u5468\\u4e94\",\"\\u5468\\u516d\"];\n" +
                "var dayNamesMin=[\"\\u65e5\",\"\\u4e00\",\"\\u4e8c\",\"\\u4e09\",\"\\u56db\",\"\\u4e94\",\"\\u516d\"];\n" +
                "var monthNames=[\"\\u4e00\\u6708\",\"\\u4e8c\\u6708\",\"\\u4e09\\u6708\",\"\\u56db\\u6708\",\"\\u4e94\\u6708\",\"\\u516d\\u6708\",\"\\u4e03\\u6708\",\"\\u516b\\u6708\",\"\\u4e5d\\u6708\",\"\\u5341\\u6708\",\"\\u5341\\u4e00\\u6708\",\"\\u5341\\u4e8c\\u6708\"];\n" +
                "var monthNamesShort=[\"\\u4e00\\u6708\",\"\\u4e8c\\u6708\",\"\\u4e09\\u6708\",\"\\u56db\\u6708\",\"\\u4e94\\u6708\",\"\\u516d\\u6708\",\"\\u4e03\\u6708\",\"\\u516b\\u6708\",\"\\u4e5d\\u6708\",\"\\u5341\\u6708\",\"\\u5341\\u4e00\\u6708\",\"\\u5341\\u4e8c\\u6708\"];\n" +
                "var firstDay=0;\n" +
                "var oc_config={\"session_lifetime\":1440,\"session_keepalive\":true,\"version\":\"14.0.0.16\",\"versionstring\":\"14.0.0 Beta 4\",\"enable_avatars\":true,\"lost_password_link\":null,\"modRewriteWorking\":false,\"sharing.maxAutocompleteResults\":0,\"sharing.minSearchStringLength\":0,\"blacklist_files_regex\":\"\\\\.(part|filepart)$\"};\n" +
                "var oc_appconfig={\"core\":{\"defaultExpireDateEnabled\":true,\"defaultExpireDate\":7,\"defaultExpireDateEnforced\":false,\"enforcePasswordForPublicLink\":false,\"enableLinkPasswordByDefault\":false,\"sharingDisabledForUser\":false,\"resharingAllowed\":true,\"remoteShareAllowed\":true,\"federatedCloudShareDoc\":\"https:\\/\\/docs.nextcloud.com\\/server\\/14\\/go.php?to=user-sharing-federated\",\"allowGroupSharing\":true},\"files\":{\"max_chunk_size\":10485760},\"comments\":{\"maxAutoCompleteResults\":10},\"shareByMailEnabled\":true,\"shareByMail\":{\"enforcePasswordProtection\":false}};\n" +
                "var oc_defaults={\"entity\":\"\\u84dd\\u9e70\\u4e91\",\"name\":\"\\u84dd\\u9e70\\u4e91\",\"title\":\"\\u84dd\\u9e70\\u4e91\",\"baseUrl\":\"https:\\/\\/xn--9kq.xn--fx1at73c.com\",\"syncClientUrl\":\"https:\\/\\/nextcloud.com\\/install\\/#install-clients\",\"docBaseUrl\":\"https:\\/\\/docs.nextcloud.com\",\"docPlaceholderUrl\":\"https:\\/\\/docs.nextcloud.com\\/server\\/14\\/go.php?to=PLACEHOLDER\",\"slogan\":\"\\u7ed9\\u60a8\\u6240\\u6709\\u7684\\u6570\\u636e\\u4e00\\u4e2a\\u5b89\\u5168\\u7684\\u5bb6 --\\u5e03\\u514b\\u7ea6\\u68ee\\u5b9e\\u9a8c\\u5ba4 --Broderick Labs\",\"logoClaim\":\"\",\"shortFooter\":\"<a href=\\\"https:\\/\\/xn--9kq.xn--fx1at73c.com\\\" target=\\\"_blank\\\" rel=\\\"noreferrer noopener\\\">\\u84dd\\u9e70\\u4e91<\\/a> \\u2013 \\u7ed9\\u60a8\\u6240\\u6709\\u7684\\u6570\\u636e\\u4e00\\u4e2a\\u5b89\\u5168\\u7684\\u5bb6 --\\u5e03\\u514b\\u7ea6\\u68ee\\u5b9e\\u9a8c\\u5ba4 --Broderick Labs<br\\/><a href=\\\"https:\\/\\/xn--fx1at73c.com\\\" class=\\\"legal\\\" target=\\\"_blank\\\" rel=\\\"noreferrer noopener\\\">Legal notice<\\/a> \\u00b7 <a href=\\\"https:\\/\\/broderick.cn\\\" class=\\\"legal\\\" target=\\\"_blank\\\" rel=\\\"noreferrer noopener\\\">Privacy policy<\\/a>\",\"longFooter\":\"<a href=\\\"https:\\/\\/xn--9kq.xn--fx1at73c.com\\\" target=\\\"_blank\\\" rel=\\\"noreferrer noopener\\\">\\u84dd\\u9e70\\u4e91<\\/a> \\u2013 \\u7ed9\\u60a8\\u6240\\u6709\\u7684\\u6570\\u636e\\u4e00\\u4e2a\\u5b89\\u5168\\u7684\\u5bb6 --\\u5e03\\u514b\\u7ea6\\u68ee\\u5b9e\\u9a8c\\u5ba4 --Broderick Labs<br\\/><a href=\\\"https:\\/\\/xn--fx1at73c.com\\\" class=\\\"legal\\\" target=\\\"_blank\\\" rel=\\\"noreferrer noopener\\\">Legal notice<\\/a> \\u00b7 <a href=\\\"https:\\/\\/broderick.cn\\\" class=\\\"legal\\\" target=\\\"_blank\\\" rel=\\\"noreferrer noopener\\\">Privacy policy<\\/a>\",\"folder\":\"\"};\n" +
                "var oc_capabilities={\"core\":{\"pollinterval\":60,\"webdav-root\":\"remote.php\\/webdav\"},\"bruteforce\":{\"delay\":0},\"activity\":{\"apiv2\":[\"filters\",\"filters-api\",\"previews\",\"rich-strings\"]},\"ocm\":{\"enabled\":true,\"apiVersion\":\"1.0-proposal1\",\"endPoint\":\"https:\\/\\/xn--9kq.xn--fx1at73c.com\\/index.php\\/ocm\",\"shareTypes\":[{\"name\":\"file\",\"protocols\":{\"webdav\":\"\\/public.php\\/webdav\\/\"}}]},\"dav\":{\"chunking\":\"1.0\"},\"files_sharing\":{\"api_enabled\":true,\"public\":{\"enabled\":true,\"password\":{\"enforced\":false},\"expire_date\":{\"enabled\":true,\"days\":\"7\",\"enforced\":false},\"send_mail\":false,\"upload\":true,\"upload_files_drop\":true},\"resharing\":true,\"user\":{\"send_mail\":false,\"expire_date\":{\"enabled\":true}},\"group_sharing\":true,\"group\":{\"enabled\":true,\"expire_date\":{\"enabled\":true}},\"default_permissions\":31,\"federation\":{\"outgoing\":true,\"incoming\":true,\"expire_date\":{\"enabled\":true}},\"sharebymail\":{\"enabled\":true,\"upload_files_drop\":{\"enabled\":true},\"password\":{\"enabled\":true},\"expire_date\":{\"enabled\":true}}},\"fulltextsearch\":{\"remote\":true,\"providers\":[]},\"files\":{\"bigfilechunking\":true,\"blacklisted_files\":[\".htaccess\"],\"undelete\":true,\"versioning\":true},\"notifications\":{\"ocs-endpoints\":[\"list\",\"get\",\"delete\",\"delete-all\",\"icons\",\"rich-strings\"],\"push\":[\"devices\",\"object-data\"],\"admin-notifications\":[\"ocs\",\"cli\"]},\"password_policy\":{\"minLength\":8,\"enforceNonCommonPassword\":true,\"enforceNumericCharacters\":false,\"enforceSpecialCharacters\":false,\"enforceUpperLowerCase\":false},\"registration\":{\"enabled\":true,\"apiRoot\":\"\\/ocs\\/v2.php\\/apps\\/registration\\/api\\/v1\\/\",\"apiLevel\":\"v1\"},\"theming\":{\"name\":\"\\u84dd\\u9e70\\u4e91\",\"url\":\"https:\\/\\/xn--9kq.xn--fx1at73c.com\",\"slogan\":\"\\u7ed9\\u60a8\\u6240\\u6709\\u7684\\u6570\\u636e\\u4e00\\u4e2a\\u5b89\\u5168\\u7684\\u5bb6 --\\u5e03\\u514b\\u7ea6\\u68ee\\u5b9e\\u9a8c\\u5ba4 --Broderick Labs\",\"color\":\"#7E4AFF\",\"color-text\":\"#ffffff\",\"color-element\":\"#7E4AFF\",\"logo\":\"https:\\/\\/xn--9kq.xn--fx1at73c.com\\/index.php\\/apps\\/theming\\/image\\/logo?useSvg=1&v=16\",\"background\":\"https:\\/\\/xn--9kq.xn--fx1at73c.com\\/index.php\\/apps\\/theming\\/image\\/background?v=16\",\"background-plain\":false,\"background-default\":false}};\n" +
                "var oc_userconfig={\"avatar\":{\"version\":2,\"generated\":false}};\n" +
                "\n" +
                "</script>\n" +
                "\t\t<link rel=\"stylesheet\" href=\"/index.php/apps/theming/styles?v=16\"/><script defer src=\"/index.php/apps/theming/js/theming?v=16\" nonce=\"amxtdEc5NUZybHFPM2w2VjV1UWF2N1dEZE9ia2hFbWFiTUlVMW1QcmpHRT06eDNiZ0tvUjJ5MjI2cGpQNWxZRkN6dmZNT29XT3NubnlCSWtnaFR1SjRoYz0=\"></script>\t</head>\n" +
                "\t<body id=\"body-user\">\n" +
                "\t<noscript>\n" +
                "\t<div id=\"nojavascript\">\n" +
                "\t\t<div>\n" +
                "\t\t\t对于正确的操作, 该应用需要使用 JavaScript. 请 <a href=\"https://www.enable-javascript.com/\" target=\"_blank\" rel=\"noreferrer noopener\">启用 JavaScript</a>, 并重新加载页面.\t\t</div>\n" +
                "\t</div>\n" +
                "</noscript>\n" +
                "\n" +
                "\t\t<a href=\"#app-content\" class=\"button primary skip-navigation skip-content\">Skip to main content</a>\n" +
                "\t\t<a href=\"#app-navigation\" class=\"button primary skip-navigation\">Skip to navigation of app</a>\n" +
                "\n" +
                "\t\t<div id=\"notification-container\">\n" +
                "\t\t\t<div id=\"notification\"></div>\n" +
                "\t\t</div>\n" +
                "\t\t<header role=\"banner\" id=\"header\">\n" +
                "\t\t\t<div class=\"header-left\">\n" +
                "\t\t\t\t<a href=\"/index.php\"\n" +
                "\t\t\t\t\tid=\"nextcloud\">\n" +
                "\t\t\t\t\t<div class=\"logo logo-icon\">\n" +
                "\t\t\t\t\t\t<h1 class=\"hidden-visually\">\n" +
                "\t\t\t\t\t\t\t蓝鹰云 文件\t\t\t\t\t\t</h1>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</a>\n" +
                "\n" +
                "\t\t\t\t<ul id=\"appmenu\" >\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"files\" class=\"hidden\">\n" +
                "\t\t\t\t\t\t\t<a href=\"/index.php/apps/files/\"\n" +
                "\t\t\t\t\t\t\t\t class=\"active\"\t\t\t\t\t\t\t\taria-label=\"文件\">\n" +
                "\t\t\t\t\t\t\t\t\t<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" alt=\"\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<image x=\"0\" y=\"0\" width=\"20\" height=\"20\" preserveAspectRatio=\"xMinYMin meet\" xlink:href=\"/apps/files/img/app.svg?v=3dd8c422\"  class=\"app-icon\" />\n" +
                "\t\t\t\t\t\t\t\t\t</svg>\n" +
                "\t\t\t\t\t\t\t\t<div class=\"icon-loading-small-dark\"\n" +
                "\t\t\t\t\t\t\t\t\t style=\"display:none;\"></div>\n" +
                "\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t<span>\n" +
                "\t\t\t\t\t\t\t\t文件\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"activity\" class=\"hidden\">\n" +
                "\t\t\t\t\t\t\t<a href=\"/index.php/apps/activity/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\taria-label=\"动态\">\n" +
                "\t\t\t\t\t\t\t\t\t<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" alt=\"\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<image x=\"0\" y=\"0\" width=\"20\" height=\"20\" preserveAspectRatio=\"xMinYMin meet\" xlink:href=\"/apps/activity/img/activity.svg?v=3dd8c422\"  class=\"app-icon\" />\n" +
                "\t\t\t\t\t\t\t\t\t</svg>\n" +
                "\t\t\t\t\t\t\t\t<div class=\"icon-loading-small-dark\"\n" +
                "\t\t\t\t\t\t\t\t\t style=\"display:none;\"></div>\n" +
                "\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t<span>\n" +
                "\t\t\t\t\t\t\t\t动态\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"gallery\" class=\"hidden\">\n" +
                "\t\t\t\t\t\t\t<a href=\"/index.php/apps/gallery/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\taria-label=\"相册\">\n" +
                "\t\t\t\t\t\t\t\t\t<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" alt=\"\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<image x=\"0\" y=\"0\" width=\"20\" height=\"20\" preserveAspectRatio=\"xMinYMin meet\" xlink:href=\"/apps/gallery/img/app.svg?v=3dd8c422\"  class=\"app-icon\" />\n" +
                "\t\t\t\t\t\t\t\t\t</svg>\n" +
                "\t\t\t\t\t\t\t\t<div class=\"icon-loading-small-dark\"\n" +
                "\t\t\t\t\t\t\t\t\t style=\"display:none;\"></div>\n" +
                "\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t<span>\n" +
                "\t\t\t\t\t\t\t\t相册\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"mail\" class=\"hidden\">\n" +
                "\t\t\t\t\t\t\t<a href=\"/index.php/apps/mail/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\taria-label=\"邮件\">\n" +
                "\t\t\t\t\t\t\t\t\t<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" alt=\"\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<image x=\"0\" y=\"0\" width=\"20\" height=\"20\" preserveAspectRatio=\"xMinYMin meet\" xlink:href=\"/apps/mail/img/mail.svg?v=3dd8c422\"  class=\"app-icon\" />\n" +
                "\t\t\t\t\t\t\t\t\t</svg>\n" +
                "\t\t\t\t\t\t\t\t<div class=\"icon-loading-small-dark\"\n" +
                "\t\t\t\t\t\t\t\t\t style=\"display:none;\"></div>\n" +
                "\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t<span>\n" +
                "\t\t\t\t\t\t\t\t邮件\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"audioplayer\" class=\"hidden\">\n" +
                "\t\t\t\t\t\t\t<a href=\"/index.php/apps/audioplayer/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\taria-label=\"音频播放\">\n" +
                "\t\t\t\t\t\t\t\t\t<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" alt=\"\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<image x=\"0\" y=\"0\" width=\"20\" height=\"20\" preserveAspectRatio=\"xMinYMin meet\" xlink:href=\"/apps/audioplayer/img/app.svg?v=3dd8c422\"  class=\"app-icon\" />\n" +
                "\t\t\t\t\t\t\t\t\t</svg>\n" +
                "\t\t\t\t\t\t\t\t<div class=\"icon-loading-small-dark\"\n" +
                "\t\t\t\t\t\t\t\t\t style=\"display:none;\"></div>\n" +
                "\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t<span>\n" +
                "\t\t\t\t\t\t\t\t音频播放\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"mindmaps\" class=\"hidden\">\n" +
                "\t\t\t\t\t\t\t<a href=\"/index.php/apps/mindmaps/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\taria-label=\"Mindmaps\">\n" +
                "\t\t\t\t\t\t\t\t\t<svg width=\"20\" height=\"20\" viewBox=\"0 0 20 20\" alt=\"\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<image x=\"0\" y=\"0\" width=\"20\" height=\"20\" preserveAspectRatio=\"xMinYMin meet\" xlink:href=\"/apps/mindmaps/img/app.svg?v=3dd8c422\"  class=\"app-icon\" />\n" +
                "\t\t\t\t\t\t\t\t\t</svg>\n" +
                "\t\t\t\t\t\t\t\t<div class=\"icon-loading-small-dark\"\n" +
                "\t\t\t\t\t\t\t\t\t style=\"display:none;\"></div>\n" +
                "\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t<span>\n" +
                "\t\t\t\t\t\t\t\tMindmaps\t\t\t\t\t\t\t</span>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t<li id=\"more-apps\" class=\"menutoggle\"\n" +
                "\t\t\t\t\t\taria-haspopup=\"true\" aria-controls=\"navigation\" aria-expanded=\"false\">\n" +
                "\t\t\t\t\t\t<a href=\"#\" aria-label=\"更多的应用程序\">\n" +
                "\t\t\t\t\t\t\t<div class=\"icon-more-white\"></div>\n" +
                "\t\t\t\t\t\t\t<span>更多的应用程序</span>\n" +
                "\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t</li>\n" +
                "\t\t\t\t</ul>\n" +
                "\n" +
                "\t\t\t\t<nav role=\"navigation\">\n" +
                "\t\t\t\t\t<div id=\"navigation\" style=\"display: none;\"  aria-label=\"更多的应用菜单\">\n" +
                "\t\t\t\t\t\t<div id=\"apps\">\n" +
                "\t\t\t\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"files\">\n" +
                "\t\t\t\t\t\t\t\t\t<a href=\"/index.php/apps/files/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t class=\"active\"\t\t\t\t\t\t\t\t\t\taria-label=\"文件\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<svg width=\"16\" height=\"16\" viewBox=\"0 0 16 16\" alt=\"\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<defs><filter id=\"invertMenuMore-files\"><feColorMatrix in=\"SourceGraphic\" type=\"matrix\" values=\"-1 0 0 0 1 0 -1 0 0 1 0 0 -1 0 1 0 0 0 1 0\"></feColorMatrix></filter></defs>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<image x=\"0\" y=\"0\" width=\"16\" height=\"16\" preserveAspectRatio=\"xMinYMin meet\" filter=\"url(#invertMenuMore-files)\" xlink:href=\"/apps/files/img/app.svg?v=3dd8c422\"  class=\"app-icon\"></image>\n" +
                "\t\t\t\t\t\t\t\t\t\t</svg>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"icon-loading-small\" style=\"display:none;\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<span>文件</span>\n" +
                "\t\t\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"activity\">\n" +
                "\t\t\t\t\t\t\t\t\t<a href=\"/index.php/apps/activity/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\taria-label=\"动态\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<svg width=\"16\" height=\"16\" viewBox=\"0 0 16 16\" alt=\"\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<defs><filter id=\"invertMenuMore-activity\"><feColorMatrix in=\"SourceGraphic\" type=\"matrix\" values=\"-1 0 0 0 1 0 -1 0 0 1 0 0 -1 0 1 0 0 0 1 0\"></feColorMatrix></filter></defs>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<image x=\"0\" y=\"0\" width=\"16\" height=\"16\" preserveAspectRatio=\"xMinYMin meet\" filter=\"url(#invertMenuMore-activity)\" xlink:href=\"/apps/activity/img/activity.svg?v=3dd8c422\"  class=\"app-icon\"></image>\n" +
                "\t\t\t\t\t\t\t\t\t\t</svg>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"icon-loading-small\" style=\"display:none;\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<span>动态</span>\n" +
                "\t\t\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"gallery\">\n" +
                "\t\t\t\t\t\t\t\t\t<a href=\"/index.php/apps/gallery/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\taria-label=\"相册\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<svg width=\"16\" height=\"16\" viewBox=\"0 0 16 16\" alt=\"\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<defs><filter id=\"invertMenuMore-gallery\"><feColorMatrix in=\"SourceGraphic\" type=\"matrix\" values=\"-1 0 0 0 1 0 -1 0 0 1 0 0 -1 0 1 0 0 0 1 0\"></feColorMatrix></filter></defs>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<image x=\"0\" y=\"0\" width=\"16\" height=\"16\" preserveAspectRatio=\"xMinYMin meet\" filter=\"url(#invertMenuMore-gallery)\" xlink:href=\"/apps/gallery/img/app.svg?v=3dd8c422\"  class=\"app-icon\"></image>\n" +
                "\t\t\t\t\t\t\t\t\t\t</svg>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"icon-loading-small\" style=\"display:none;\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<span>相册</span>\n" +
                "\t\t\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"mail\">\n" +
                "\t\t\t\t\t\t\t\t\t<a href=\"/index.php/apps/mail/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\taria-label=\"邮件\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<svg width=\"16\" height=\"16\" viewBox=\"0 0 16 16\" alt=\"\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<defs><filter id=\"invertMenuMore-mail\"><feColorMatrix in=\"SourceGraphic\" type=\"matrix\" values=\"-1 0 0 0 1 0 -1 0 0 1 0 0 -1 0 1 0 0 0 1 0\"></feColorMatrix></filter></defs>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<image x=\"0\" y=\"0\" width=\"16\" height=\"16\" preserveAspectRatio=\"xMinYMin meet\" filter=\"url(#invertMenuMore-mail)\" xlink:href=\"/apps/mail/img/mail.svg?v=3dd8c422\"  class=\"app-icon\"></image>\n" +
                "\t\t\t\t\t\t\t\t\t\t</svg>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"icon-loading-small\" style=\"display:none;\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<span>邮件</span>\n" +
                "\t\t\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"audioplayer\">\n" +
                "\t\t\t\t\t\t\t\t\t<a href=\"/index.php/apps/audioplayer/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\taria-label=\"音频播放\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<svg width=\"16\" height=\"16\" viewBox=\"0 0 16 16\" alt=\"\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<defs><filter id=\"invertMenuMore-audioplayer\"><feColorMatrix in=\"SourceGraphic\" type=\"matrix\" values=\"-1 0 0 0 1 0 -1 0 0 1 0 0 -1 0 1 0 0 0 1 0\"></feColorMatrix></filter></defs>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<image x=\"0\" y=\"0\" width=\"16\" height=\"16\" preserveAspectRatio=\"xMinYMin meet\" filter=\"url(#invertMenuMore-audioplayer)\" xlink:href=\"/apps/audioplayer/img/app.svg?v=3dd8c422\"  class=\"app-icon\"></image>\n" +
                "\t\t\t\t\t\t\t\t\t\t</svg>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"icon-loading-small\" style=\"display:none;\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<span>音频播放</span>\n" +
                "\t\t\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"mindmaps\">\n" +
                "\t\t\t\t\t\t\t\t\t<a href=\"/index.php/apps/mindmaps/\"\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\taria-label=\"Mindmaps\">\n" +
                "\t\t\t\t\t\t\t\t\t\t<svg width=\"16\" height=\"16\" viewBox=\"0 0 16 16\" alt=\"\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<defs><filter id=\"invertMenuMore-mindmaps\"><feColorMatrix in=\"SourceGraphic\" type=\"matrix\" values=\"-1 0 0 0 1 0 -1 0 0 1 0 0 -1 0 1 0 0 0 1 0\"></feColorMatrix></filter></defs>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<image x=\"0\" y=\"0\" width=\"16\" height=\"16\" preserveAspectRatio=\"xMinYMin meet\" filter=\"url(#invertMenuMore-mindmaps)\" xlink:href=\"/apps/mindmaps/img/app.svg?v=3dd8c422\"  class=\"app-icon\"></image>\n" +
                "\t\t\t\t\t\t\t\t\t\t</svg>\n" +
                "\t\t\t\t\t\t\t\t\t\t<div class=\"icon-loading-small\" style=\"display:none;\"></div>\n" +
                "\t\t\t\t\t\t\t\t\t\t<span>Mindmaps</span>\n" +
                "\t\t\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</nav>\n" +
                "\n" +
                "\t\t\t</div>\n" +
                "\n" +
                "\t\t\t<div class=\"header-right\">\n" +
                "\t\t\t\t<form class=\"searchbox\" action=\"#\" method=\"post\" role=\"search\" novalidate>\n" +
                "\t\t\t\t\t<label for=\"searchbox\" class=\"hidden-visually\">\n" +
                "\t\t\t\t\t\t搜索\t\t\t\t\t</label>\n" +
                "\t\t\t\t\t<input id=\"searchbox\" type=\"search\" name=\"query\"\n" +
                "\t\t\t\t\t\tvalue=\"\" required class=\"hidden icon-search-white\"\n" +
                "\t\t\t\t\t\tautocomplete=\"off\">\n" +
                "\t\t\t\t\t<button class=\"icon-close-white\" type=\"reset\"><span class=\"hidden-visually\">重置搜索</span></button>\n" +
                "\t\t\t\t</form>\n" +
                "\t\t\t\t<div id=\"contactsmenu\">\n" +
                "\t\t\t\t\t<div class=\"icon-contacts menutoggle\" tabindex=\"0\" role=\"button\"\n" +
                "\t\t\t\t\taria-haspopup=\"true\" aria-controls=\"contactsmenu-menu\" aria-expanded=\"false\">\n" +
                "\t\t\t\t\t\t<span class=\"hidden-visually\">联系人\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<div id=\"contactsmenu-menu\" class=\"menu\"\n" +
                "\t\t\t\t\t\taria-label=\"联系人菜单\"></div>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<div id=\"settings\">\n" +
                "\t\t\t\t\t<div id=\"expand\" tabindex=\"0\" role=\"button\" class=\"menutoggle\"\n" +
                "\t\t\t\t\t\taria-label=\"设置\"\n" +
                "\t\t\t\t\t\taria-haspopup=\"true\" aria-controls=\"expanddiv\" aria-expanded=\"false\">\n" +
                "\t\t\t\t\t\t<div class=\"avatardiv avatardiv-shown\">\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img alt=\"\" width=\"32\" height=\"32\"\n" +
                "\t\t\t\t\t\t\t\tsrc=\"/index.php/avatar/Broderick/32?v=2\"\n" +
                "\t\t\t\t\t\t\t\tsrcset=\"/index.php/avatar/Broderick/64?v=2 2x, /index.php/avatar/Broderick/128?v=2 4x\"\n" +
                "\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t\t<div id=\"expandDisplayName\" class=\"icon-settings-white\"></div>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t\t<nav id=\"expanddiv\" style=\"display:none;\"\n" +
                "\t\t\t\t\t\taria-label=\"设置菜单\">\n" +
                "\t\t\t\t\t<ul>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"settings\">\n" +
                "\t\t\t\t\t\t\t<a href=\"/index.php/settings/user\"\n" +
                "\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t<img alt=\"\" src=\"/settings/img/admin.svg?v=3dd8c422\">\n" +
                "\t\t\t\t\t\t\t\t设置\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"core_apps\">\n" +
                "\t\t\t\t\t\t\t<a href=\"/index.php/settings/apps\"\n" +
                "\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t<img alt=\"\" src=\"/settings/img/apps.svg?v=3dd8c422\">\n" +
                "\t\t\t\t\t\t\t\t应用\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"core_users\">\n" +
                "\t\t\t\t\t\t\t<a href=\"/index.php/settings/users\"\n" +
                "\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t<img alt=\"\" src=\"/settings/img/users.svg?v=3dd8c422\">\n" +
                "\t\t\t\t\t\t\t\t用户\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"firstrunwizard-about\">\n" +
                "\t\t\t\t\t\t\t<a href=\"\"\n" +
                "\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t<img alt=\"\" src=\"/apps/firstrunwizard/img/info.svg?v=3dd8c422\">\n" +
                "\t\t\t\t\t\t\t\t关于\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"help\">\n" +
                "\t\t\t\t\t\t\t<a href=\"/index.php/settings/help\"\n" +
                "\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t<img alt=\"\" src=\"/settings/img/help.svg?v=3dd8c422\">\n" +
                "\t\t\t\t\t\t\t\t帮助\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t\t<li data-id=\"logout\">\n" +
                "\t\t\t\t\t\t\t<a href=\"https://xn--9kq.xn--fx1at73c.com/index.php/logout?requesttoken=jlmtG95FrlqO3l6V5uQav7WDdObkhEmabMIU1mPrjGE%3D%3Ax3bgKoR2y226pjP5lYFCzvfMOoWOsnnyBIkghTuJ4hc%3D\"\n" +
                "\t\t\t\t\t\t\t\t>\n" +
                "\t\t\t\t\t\t\t\t<img alt=\"\" src=\"/core/img/actions/logout.svg?v=3dd8c422\">\n" +
                "\t\t\t\t\t\t\t\t注销\t\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t\t</li>\n" +
                "\t\t\t\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t\t\t</nav>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div></header>\n" +
                "\n" +
                "\t\t<div id=\"sudo-login-background\" class=\"hidden\"></div>\n" +
                "\t\t<form id=\"sudo-login-form\" class=\"hidden\">\n" +
                "\t\t\t<label>\n" +
                "\t\t\t\t请您确认您的密码<br/>\n" +
                "\t\t\t\t<input type=\"password\" class=\"question\" autocomplete=\"new-password\" name=\"question\" value=\" \"\n" +
                "\t\t\t\tplaceholder=\"确认您的密码\" />\n" +
                "\t\t\t</label>\n" +
                "\t\t\t<input class=\"confirm\" value=\"确认\" type=\"submit\">\n" +
                "\t\t</form>\n" +
                "\n" +
                "\t\t<div id=\"content\" class=\"app-files\" role=\"main\">\n" +
                "\t\t\t<div id=\"app-navigation\">\n" +
                "\t<ul class=\"with-icon\">\n" +
                "\n" +
                "\t\t\t<li\n" +
                "\t\tdata-id=\"files\"\n" +
                "\t\t\t\t\t\t\t\tclass=\"nav-files\t\t\t\t\t\t\"\n" +
                "\t\t>\n" +
                "\n" +
                "\t\t<a href=\"#\"\n" +
                "\t\t   class=\"nav-icon-files svg\">全部文件</a>\n" +
                "\n" +
                "\n" +
                "\t\t\t</li>\n" +
                "\n" +
                "\n" +
                "\t\t<li\n" +
                "\t\tdata-id=\"recent\"\n" +
                "\t\t\t\t\t\t\t\tclass=\"nav-recent\t\t\t\t\t\t\"\n" +
                "\t\t>\n" +
                "\n" +
                "\t\t<a href=\"#\"\n" +
                "\t\t   class=\"nav-icon-recent svg\">最近</a>\n" +
                "\n" +
                "\n" +
                "\t\t\t</li>\n" +
                "\n" +
                "\n" +
                "\t\t<li\n" +
                "\t\tdata-id=\"favorites\"\n" +
                "\t\t\t\t\t\t data-expandedstate=\"show_Quick_Access\" \t\tclass=\"nav-favorites\t\t\t\t\t\t\"\n" +
                "\t\t>\n" +
                "\n" +
                "\t\t<a href=\"#\"\n" +
                "\t\t   class=\"nav-icon-favorites svg\">收藏</a>\n" +
                "\n" +
                "\n" +
                "\t\t\t\t\t<button class=\"collapse app-navigation-noclose\"  style=\"display: none\" ></button>\n" +
                "\t\t\t<ul id=\"sublist-favorites\">\n" +
                "\t\t\t\t\t\t\t</ul>\n" +
                "\t\t\t</li>\n" +
                "\n" +
                "\n" +
                "\t\t<li\n" +
                "\t\tdata-id=\"shareoverview\"\n" +
                "\t\t\t\t\t\t data-expandedstate=\"show_sharing_menu\" \t\tclass=\"nav-shareoverview\t\tcollapsible\t\t\t\t\"\n" +
                "\t\t>\n" +
                "\n" +
                "\t\t<a href=\"#\"\n" +
                "\t\t   class=\"nav-icon-shareoverview svg\">Shares</a>\n" +
                "\n" +
                "\n" +
                "\t\t\t\t\t<button class=\"collapse app-navigation-noclose\" ></button>\n" +
                "\t\t\t<ul id=\"sublist-shareoverview\">\n" +
                "\t\t\t\t\t<li\n" +
                "\t\tdata-id=\"sharingout\"\n" +
                "\t\t\t\t\t\t\t\tclass=\"nav-sharingout\t\t\t\t\t\t\"\n" +
                "\t\t>\n" +
                "\n" +
                "\t\t<a href=\"#\"\n" +
                "\t\t   class=\"nav-icon-sharingout svg\">您分享的文件</a>\n" +
                "\n" +
                "\n" +
                "\t\t\t</li>\n" +
                "\n" +
                "\n" +
                "\t\t<li\n" +
                "\t\tdata-id=\"sharingin\"\n" +
                "\t\t\t\t\t\t\t\tclass=\"nav-sharingin\t\t\t\t\t\t\"\n" +
                "\t\t>\n" +
                "\n" +
                "\t\t<a href=\"#\"\n" +
                "\t\t   class=\"nav-icon-sharingin svg\">收到分享</a>\n" +
                "\n" +
                "\n" +
                "\t\t\t</li>\n" +
                "\n" +
                "\n" +
                "\t\t<li\n" +
                "\t\tdata-id=\"sharinglinks\"\n" +
                "\t\t\t\t\t\t\t\tclass=\"nav-sharinglinks\t\t\t\t\t\t\"\n" +
                "\t\t>\n" +
                "\n" +
                "\t\t<a href=\"#\"\n" +
                "\t\t   class=\"nav-icon-sharinglinks svg\">分享链接的文件</a>\n" +
                "\n" +
                "\n" +
                "\t\t\t</li>\n" +
                "\n" +
                "\n" +
                "\t\t<li\n" +
                "\t\tdata-id=\"deletedshares\"\n" +
                "\t\t\t\t\t\t\t\tclass=\"nav-deletedshares\t\t\t\t\t\t\"\n" +
                "\t\t>\n" +
                "\n" +
                "\t\t<a href=\"#\"\n" +
                "\t\t   class=\"nav-icon-deletedshares svg\">Deleted shares</a>\n" +
                "\n" +
                "\n" +
                "\t\t\t</li>\n" +
                "\n" +
                "\n" +
                "\t\t\t\t</ul>\n" +
                "\t\t\t</li>\n" +
                "\n" +
                "\n" +
                "\t\t<li\n" +
                "\t\tdata-id=\"systemtagsfilter\"\n" +
                "\t\t\t\t\t\t\t\tclass=\"nav-systemtagsfilter\t\t\t\t\t\t\"\n" +
                "\t\t>\n" +
                "\n" +
                "\t\t<a href=\"#\"\n" +
                "\t\t   class=\"nav-icon-systemtagsfilter svg\">标签</a>\n" +
                "\n" +
                "\n" +
                "\t\t\t</li>\n" +
                "\n" +
                "\n" +
                "\t\t<li\n" +
                "\t\tdata-id=\"extstoragemounts\"\n" +
                "\t\t\t\t\t\t\t\tclass=\"nav-extstoragemounts\t\t\t\t\t\t\"\n" +
                "\t\t>\n" +
                "\n" +
                "\t\t<a href=\"#\"\n" +
                "\t\t   class=\"nav-icon-extstoragemounts svg\">外部存储</a>\n" +
                "\n" +
                "\n" +
                "\t\t\t</li>\n" +
                "\n" +
                "\n" +
                "\t\t<li\n" +
                "\t\tdata-id=\"trashbin\"\n" +
                "\t\t\t\t\t\t\t\tclass=\"nav-trashbin\t\tpinned\t\tfirst-pinned\t\t\"\n" +
                "\t\t>\n" +
                "\n" +
                "\t\t<a href=\"#\"\n" +
                "\t\t   class=\"nav-icon-trashbin svg\">已删除文件</a>\n" +
                "\n" +
                "\n" +
                "\t\t\t</li>\n" +
                "\n" +
                "\n" +
                "\t\n" +
                "\t\t<li id=\"quota\"\n" +
                "\t\t\tclass=\"pinned \">\n" +
                "\t\t\t<a href=\"#\" class=\"icon-quota svg\">\n" +
                "\t\t\t\t<p id=\"quotatext\">510.3 MB 已使用</p>\n" +
                "\t\t\t\t<div class=\"quota-container\">\n" +
                "\t\t\t\t\t<progress value=\"1.3\"\n" +
                "\t\t\t\t\t\t\t  max=\"100\"\n" +
                "\t\t\t\t\t\t></progress>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</a>\n" +
                "\t\t</li>\n" +
                "\t</ul>\n" +
                "\t<div id=\"app-settings\">\n" +
                "\t\t<div id=\"app-settings-header\">\n" +
                "\t\t\t<button class=\"settings-button\"\n" +
                "\t\t\t\t\tdata-apps-slide-toggle=\"#app-settings-content\">\n" +
                "\t\t\t\t设置\t\t\t</button>\n" +
                "\t\t</div>\n" +
                "\t\t<div id=\"app-settings-content\">\n" +
                "\t\t\t<div id=\"files-setting-showhidden\">\n" +
                "\t\t\t\t<input class=\"checkbox\" id=\"showhiddenfilesToggle\"\n" +
                "\t\t\t\t\t   checked=\"checked\" type=\"checkbox\">\n" +
                "\t\t\t\t<label for=\"showhiddenfilesToggle\">显示隐藏文件</label>\n" +
                "\t\t\t</div>\n" +
                "\t\t\t<label for=\"webdavurl\">WebDAV</label>\n" +
                "\t\t\t<input id=\"webdavurl\" type=\"text\" readonly=\"readonly\"\n" +
                "\t\t\t\t   value=\"https://xn--9kq.xn--fx1at73c.com/remote.php/webdav/\"/>\n" +
                "\t\t\t<em>使用这个地址 <a href=\"https://docs.nextcloud.com/server/14/go.php?to=user-webdav\" target=\"_blank\" rel=\"noreferrer noopener\">通过 WebDAV 访问您的文件</a></em>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<div id=\"app-content\">\n" +
                "\t\t<div id=\"app-content-files\" class=\"hidden viewcontainer\">\n" +
                "\t<div id=\"controls\">\n" +
                "\t\t<div class=\"actions creatable hidden\">\n" +
                "\t\t\t<div id=\"uploadprogresswrapper\">\n" +
                "\t\t\t\t<div id=\"uploadprogressbar\">\n" +
                "\t\t\t\t\t<em class=\"label outer\" style=\"display:none\"><span class=\"desktop\">上传中…</span><span class=\"mobile\">…</span></em>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t\t<button class=\"stop icon-close\" style=\"display:none\">\n" +
                "\t\t\t\t\t<span class=\"hidden-visually\">取消上传</span>\n" +
                "\t\t\t\t</button>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>\n" +
                "\t\t<div id=\"file_action_panel\"></div>\n" +
                "\t\t<div class=\"notCreatable notPublic hidden\">\n" +
                "\t\t\t您没有权限在此上传或创建文件\t\t</div>\n" +
                "\t\t<input type=\"hidden\" name=\"permissions\" value=\"\" id=\"permissions\">\n" +
                "\t<input type=\"hidden\" id=\"free_space\" value=\"\">\n" +
                "\t\t<input type=\"hidden\" class=\"max_human_file_size\"\n" +
                "\t\t   value=\"(max )\">\n" +
                "</div>\n" +
                "\n" +
                "<div id=\"emptycontent\" class=\"hidden\">\n" +
                "\t<div class=\"icon-folder\"></div>\n" +
                "\t<h2>无文件</h2>\n" +
                "\t<p class=\"uploadmessage hidden\">上传或从您的设备中同步!</p>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"nofilterresults emptycontent hidden\">\n" +
                "\t<div class=\"icon-search\"></div>\n" +
                "\t<h2>文件夹中无项目</h2>\n" +
                "\t<p></p>\n" +
                "</div>\n" +
                "\n" +
                "<table id=\"filestable\" data-allow-public-upload=\"yes\" data-preview-x=\"32\" data-preview-y=\"32\">\n" +
                "\t<thead>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th id=\"headerSelection\" class=\"hidden column-selection\">\n" +
                "\t\t\t\t<input type=\"checkbox\" id=\"select_all_files\" class=\"select-all checkbox\"/>\n" +
                "\t\t\t\t<label for=\"select_all_files\">\n" +
                "\t\t\t\t\t<span class=\"hidden-visually\">全部选择</span>\n" +
                "\t\t\t\t</label>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id='headerName' class=\"hidden column-name\">\n" +
                "\t\t\t\t<div id=\"headerName-container\">\n" +
                "\t\t\t\t\t<a class=\"name sort columntitle\" data-sort=\"name\">\n" +
                "                        <span>名称</span>\n" +
                "                        <span class=\"sort-indicator\"></span>\n" +
                "\n" +
                "                    </a>\n" +
                "                    <span id=\"selectedActionsList\" class=\"selectedActions\">\n" +
                "                        <a href=\"\" class=\"actions-selected\">\n" +
                "                            <span class=\"icon icon-more\"></span>\n" +
                "                            <span>操作</span>\n" +
                "                        </a>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id=\"headerSize\" class=\"hidden column-size\">\n" +
                "\t\t\t\t<a class=\"size sort columntitle\" data-sort=\"size\"><span>大小</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id=\"headerDate\" class=\"hidden column-mtime\">\n" +
                "\t\t\t\t<a id=\"modified\" class=\"columntitle\" data-sort=\"mtime\"><span>修改日期</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t</tr>\n" +
                "\t</thead>\n" +
                "\t<tbody id=\"fileList\">\n" +
                "\t</tbody>\n" +
                "\t<tfoot>\n" +
                "\t</tfoot>\n" +
                "</table>\n" +
                "<input type=\"hidden\" name=\"dir\" id=\"dir\" value=\"\" />\n" +
                "<div class=\"hiddenuploadfield\">\n" +
                "\t<input type=\"file\" id=\"file_upload_start\" class=\"hiddenuploadfield\" name=\"files[]\" />\n" +
                "</div>\n" +
                "<div id=\"editor\"></div><!-- FIXME Do not use this div in your app! It is deprecated and will be removed in the future! -->\n" +
                "<div id=\"uploadsize-message\" title=\"上传文件过大\">\n" +
                "\t<p>\n" +
                "\t正在上传的文件超过了此服务器允许上传的最大容量限制\t</p>\n" +
                "</div>\n" +
                "\t</div>\n" +
                "\t\t<div id=\"app-content-recent\" class=\"hidden viewcontainer\">\n" +
                "\t<div id='notification'></div>\n" +
                "\n" +
                "<div id=\"emptycontent\" class=\"hidden\"></div>\n" +
                "\n" +
                "<input type=\"hidden\" name=\"dir\" value=\"\" id=\"dir\">\n" +
                "\n" +
                "<div class=\"nofilterresults hidden\">\n" +
                "\t<div class=\"icon-search\"></div>\n" +
                "\t<h2>文件夹中无项目</h2>\n" +
                "\t<p></p>\n" +
                "</div>\n" +
                "\n" +
                "<table id=\"filestable\">\n" +
                "\t<thead>\n" +
                "\t<tr>\n" +
                "\t\t<th id='headerName' class=\"hidden column-name\">\n" +
                "\t\t\t<div id=\"headerName-container\">\n" +
                "\t\t\t\t<a class=\"name sort columntitle\"\n" +
                "\t\t\t\t   data-sort=\"name\"><span>名称</span></a>\n" +
                "\t\t\t</div>\n" +
                "\t\t</th>\n" +
                "\t\t<th id=\"headerSize\" class=\"hidden column-size\">\n" +
                "\t\t\t<a class=\"size sort columntitle\"\n" +
                "\t\t\t   data-sort=\"size\"><span>大小</span></a>\n" +
                "\t\t</th>\n" +
                "\t\t<th id=\"headerDate\" class=\"hidden column-mtime\">\n" +
                "\t\t\t<a id=\"modified\" class=\"columntitle\"\n" +
                "\t\t\t   data-sort=\"mtime\"><span>修改日期</span><span\n" +
                "\t\t\t\t\tclass=\"sort-indicator\"></span></a>\n" +
                "\t\t\t<span class=\"selectedActions\">\n" +
                "\t\t\t\t<a href=\"\" class=\"delete-selected\">\n" +
                "\t\t\t\t\t<span class=\"icon icon-delete\"></span>\n" +
                "\t\t\t\t\t<span>删除</span>\n" +
                "\t\t\t\t</a>\n" +
                "\t\t\t</span>\n" +
                "\t\t</th>\n" +
                "\t</tr>\n" +
                "\t</thead>\n" +
                "\t<tbody id=\"fileList\">\n" +
                "\t</tbody>\n" +
                "\t<tfoot>\n" +
                "\t</tfoot>\n" +
                "</table>\n" +
                "\t</div>\n" +
                "\t\t<div id=\"app-content-favorites\" class=\"hidden viewcontainer\">\n" +
                "\t<div id='notification'></div>\n" +
                "\n" +
                "<div id=\"emptycontent\" class=\"hidden\">\n" +
                "\t<div class=\"icon-starred\"></div>\n" +
                "\t<h2>还没有“我喜欢的”</h2>\n" +
                "\t<p>收藏的文件和文件夹会在这里显示</p>\n" +
                "</div>\n" +
                "\n" +
                "<input type=\"hidden\" name=\"dir\" value=\"\" id=\"dir\">\n" +
                "\n" +
                "<div class=\"nofilterresults hidden\">\n" +
                "\t<div class=\"icon-search\"></div>\n" +
                "\t<h2>文件夹中无项目</h2>\n" +
                "\t<p></p>\n" +
                "</div>\n" +
                "<table id=\"filestable\">\n" +
                "\t<thead>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th id='headerName' class=\"hidden column-name\">\n" +
                "\t\t\t\t<div id=\"headerName-container\">\n" +
                "\t\t\t\t\t<a class=\"name sort columntitle\" data-sort=\"name\"><span>名称</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id=\"headerSize\" class=\"hidden column-size\">\n" +
                "\t\t\t\t<a class=\"size sort columntitle\" data-sort=\"size\"><span>大小</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id=\"headerDate\" class=\"hidden column-mtime\">\n" +
                "\t\t\t\t<a id=\"modified\" class=\"columntitle\" data-sort=\"mtime\"><span>修改日期</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t\t<span class=\"selectedActions\">\n" +
                "\t\t\t\t    <a href=\"\" class=\"delete-selected\">\n" +
                "\t\t\t\t\t<img class=\"svg\" alt=\"\"\n" +
                "\t\t\t\t\t     src=\"/core/img/actions/delete.svg\" />\n" +
                "\t\t\t\t\t删除\t\t\t\t    </a>\n" +
                "\t\t\t\t</span>\n" +
                "\t\t\t</th>\n" +
                "\t\t</tr>\n" +
                "\t</thead>\n" +
                "\t<tbody id=\"fileList\">\n" +
                "\t</tbody>\n" +
                "\t<tfoot>\n" +
                "\t</tfoot>\n" +
                "</table>\n" +
                "\t</div>\n" +
                "\t\t<div id=\"app-content-sharingout\" class=\"hidden viewcontainer\">\n" +
                "\t<div id='notification'></div>\n" +
                "\n" +
                "<div id=\"emptycontent\" class=\"hidden\"></div>\n" +
                "\n" +
                "<input type=\"hidden\" name=\"dir\" value=\"\" id=\"dir\">\n" +
                "\n" +
                "<div class=\"nofilterresults hidden\">\n" +
                "\t<div class=\"icon-search\"></div>\n" +
                "\t<h2>此文件夹中无项目</h2>\n" +
                "</div>\n" +
                "\n" +
                "<table id=\"filestable\">\n" +
                "\t<thead>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th id='headerName' class=\"hidden column-name\">\n" +
                "\t\t\t\t<div id=\"headerName-container\">\n" +
                "\t\t\t\t\t<a class=\"name sort columntitle\" data-sort=\"name\"><span>名称</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id=\"headerDate\" class=\"hidden column-mtime\">\n" +
                "\t\t\t\t<a id=\"modified\" class=\"columntitle\" data-sort=\"mtime\"><span>分享时间</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th class=\"hidden column-expiration\">\n" +
                "\t\t\t\t<a class=\"columntitle\"><span>到期日期 </span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t</tr>\n" +
                "\t</thead>\n" +
                "\t<tbody id=\"fileList\">\n" +
                "\t</tbody>\n" +
                "\t<tfoot>\n" +
                "\t</tfoot>\n" +
                "</table>\n" +
                "\t</div>\n" +
                "\t\t<div id=\"app-content-sharingin\" class=\"hidden viewcontainer\">\n" +
                "\t<div id='notification'></div>\n" +
                "\n" +
                "<div id=\"emptycontent\" class=\"hidden\"></div>\n" +
                "\n" +
                "<input type=\"hidden\" name=\"dir\" value=\"\" id=\"dir\">\n" +
                "\n" +
                "<div class=\"nofilterresults hidden\">\n" +
                "\t<div class=\"icon-search\"></div>\n" +
                "\t<h2>此文件夹中无项目</h2>\n" +
                "</div>\n" +
                "\n" +
                "<table id=\"filestable\">\n" +
                "\t<thead>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th id='headerName' class=\"hidden column-name\">\n" +
                "\t\t\t\t<div id=\"headerName-container\">\n" +
                "\t\t\t\t\t<a class=\"name sort columntitle\" data-sort=\"name\"><span>名称</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id=\"headerDate\" class=\"hidden column-mtime\">\n" +
                "\t\t\t\t<a id=\"modified\" class=\"columntitle\" data-sort=\"mtime\"><span>分享时间</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th class=\"hidden column-expiration\">\n" +
                "\t\t\t\t<a class=\"columntitle\"><span>到期日期 </span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t</tr>\n" +
                "\t</thead>\n" +
                "\t<tbody id=\"fileList\">\n" +
                "\t</tbody>\n" +
                "\t<tfoot>\n" +
                "\t</tfoot>\n" +
                "</table>\n" +
                "\t</div>\n" +
                "\t\t<div id=\"app-content-sharinglinks\" class=\"hidden viewcontainer\">\n" +
                "\t<div id='notification'></div>\n" +
                "\n" +
                "<div id=\"emptycontent\" class=\"hidden\"></div>\n" +
                "\n" +
                "<input type=\"hidden\" name=\"dir\" value=\"\" id=\"dir\">\n" +
                "\n" +
                "<div class=\"nofilterresults hidden\">\n" +
                "\t<div class=\"icon-search\"></div>\n" +
                "\t<h2>此文件夹中无项目</h2>\n" +
                "</div>\n" +
                "\n" +
                "<table id=\"filestable\">\n" +
                "\t<thead>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th id='headerName' class=\"hidden column-name\">\n" +
                "\t\t\t\t<div id=\"headerName-container\">\n" +
                "\t\t\t\t\t<a class=\"name sort columntitle\" data-sort=\"name\"><span>名称</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id=\"headerDate\" class=\"hidden column-mtime\">\n" +
                "\t\t\t\t<a id=\"modified\" class=\"columntitle\" data-sort=\"mtime\"><span>分享时间</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th class=\"hidden column-expiration\">\n" +
                "\t\t\t\t<a class=\"columntitle\"><span>到期日期 </span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t</tr>\n" +
                "\t</thead>\n" +
                "\t<tbody id=\"fileList\">\n" +
                "\t</tbody>\n" +
                "\t<tfoot>\n" +
                "\t</tfoot>\n" +
                "</table>\n" +
                "\t</div>\n" +
                "\t\t<div id=\"app-content-deletedshares\" class=\"hidden viewcontainer\">\n" +
                "\t<div id='notification'></div>\n" +
                "\n" +
                "<div id=\"emptycontent\" class=\"hidden\"></div>\n" +
                "\n" +
                "<input type=\"hidden\" name=\"dir\" value=\"\" id=\"dir\">\n" +
                "\n" +
                "<div class=\"nofilterresults hidden\">\n" +
                "\t<div class=\"icon-search\"></div>\n" +
                "\t<h2>此文件夹中无项目</h2>\n" +
                "</div>\n" +
                "\n" +
                "<table id=\"filestable\">\n" +
                "\t<thead>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th id='headerName' class=\"hidden column-name\">\n" +
                "\t\t\t\t<div id=\"headerName-container\">\n" +
                "\t\t\t\t\t<a class=\"name sort columntitle\" data-sort=\"name\"><span>名称</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id=\"headerDate\" class=\"hidden column-mtime\">\n" +
                "\t\t\t\t<a id=\"modified\" class=\"columntitle\" data-sort=\"mtime\"><span>分享时间</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th class=\"hidden column-expiration\">\n" +
                "\t\t\t\t<a class=\"columntitle\"><span>到期日期 </span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t</tr>\n" +
                "\t</thead>\n" +
                "\t<tbody id=\"fileList\">\n" +
                "\t</tbody>\n" +
                "\t<tfoot>\n" +
                "\t</tfoot>\n" +
                "</table>\n" +
                "\t</div>\n" +
                "\t\t<div id=\"app-content-shareoverview\" class=\"hidden viewcontainer\">\n" +
                "\t<div id='notification'></div>\n" +
                "\n" +
                "<div id=\"emptycontent\" class=\"hidden\"></div>\n" +
                "\n" +
                "<input type=\"hidden\" name=\"dir\" value=\"\" id=\"dir\">\n" +
                "\n" +
                "<div class=\"nofilterresults hidden\">\n" +
                "\t<div class=\"icon-search\"></div>\n" +
                "\t<h2>此文件夹中无项目</h2>\n" +
                "</div>\n" +
                "\n" +
                "<table id=\"filestable\">\n" +
                "\t<thead>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th id='headerName' class=\"hidden column-name\">\n" +
                "\t\t\t\t<div id=\"headerName-container\">\n" +
                "\t\t\t\t\t<a class=\"name sort columntitle\" data-sort=\"name\"><span>名称</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id=\"headerDate\" class=\"hidden column-mtime\">\n" +
                "\t\t\t\t<a id=\"modified\" class=\"columntitle\" data-sort=\"mtime\"><span>分享时间</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th class=\"hidden column-expiration\">\n" +
                "\t\t\t\t<a class=\"columntitle\"><span>到期日期 </span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t</tr>\n" +
                "\t</thead>\n" +
                "\t<tbody id=\"fileList\">\n" +
                "\t</tbody>\n" +
                "\t<tfoot>\n" +
                "\t</tfoot>\n" +
                "</table>\n" +
                "\t</div>\n" +
                "\t\t<div id=\"app-content-systemtagsfilter\" class=\"hidden viewcontainer\">\n" +
                "\t<div id=\"controls\">\n" +
                "</div>\n" +
                "\n" +
                "<div id=\"emptycontent\" class=\"hidden\">\n" +
                "\t<div class=\"icon-folder\"></div>\n" +
                "\t<h2>无文件</h2>\n" +
                "\t<p class=\"uploadmessage hidden\"></p>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"nofilterresults emptycontent hidden\">\n" +
                "\t<div class=\"icon-search\"></div>\n" +
                "\t<h2>此文件夹中无项目</h2>\n" +
                "\t<p></p>\n" +
                "</div>\n" +
                "\n" +
                "<table id=\"filestable\" data-preview-x=\"32\" data-preview-y=\"32\">\n" +
                "\t<thead>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th id='headerName' class=\"hidden column-name\">\n" +
                "\t\t\t\t<div id=\"headerName-container\">\n" +
                "\t\t\t\t\t<a class=\"name sort columntitle\" data-sort=\"name\"><span>名称</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id=\"headerSize\" class=\"hidden column-size\">\n" +
                "\t\t\t\t<a class=\"size sort columntitle\" data-sort=\"size\"><span>大小</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id=\"headerDate\" class=\"hidden column-mtime\">\n" +
                "\t\t\t\t<a id=\"modified\" class=\"columntitle\" data-sort=\"mtime\"><span>修改日期</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t</tr>\n" +
                "\t</thead>\n" +
                "\t<tbody id=\"fileList\">\n" +
                "\t</tbody>\n" +
                "\t<tfoot>\n" +
                "\t</tfoot>\n" +
                "</table>\n" +
                "<input type=\"hidden\" name=\"dir\" id=\"dir\" value=\"\" />\n" +
                "\n" +
                "\t</div>\n" +
                "\t\t<div id=\"app-content-extstoragemounts\" class=\"hidden viewcontainer\">\n" +
                "\t<div id=\"controls\">\n" +
                "\t<div id=\"file_action_panel\"></div>\n" +
                "</div>\n" +
                "<div id='notification'></div>\n" +
                "\n" +
                "<div id=\"emptycontent\" class=\"hidden\">\n" +
                "\t<div class=\"icon-external\"></div>\n" +
                "\t<h2>未设置外部存储或者没有权限</h2>\n" +
                "</div>\n" +
                "\n" +
                "<input type=\"hidden\" name=\"dir\" value=\"\" id=\"dir\">\n" +
                "\n" +
                "<table id=\"filestable\">\n" +
                "\t<thead>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th id='headerName' class=\"hidden column-name\">\n" +
                "\t\t\t\t<div id=\"headerName-container\">\n" +
                "\t\t\t\t\t<a class=\"name sort columntitle\" data-sort=\"name\"><span>名称</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id=\"headerBackend\" class=\"hidden column-backend\">\n" +
                "\t\t\t\t<a class=\"backend sort columntitle\" data-sort=\"backend\"><span>存储类型</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id=\"headerScope\" class=\"hidden column-scope column-last\">\n" +
                "\t\t\t\t<a class=\"scope sort columntitle\" data-sort=\"scope\"><span>适用范围</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t</tr>\n" +
                "\t</thead>\n" +
                "\t<tbody id=\"fileList\">\n" +
                "\t</tbody>\n" +
                "\t<tfoot>\n" +
                "\t</tfoot>\n" +
                "</table>\n" +
                "\t</div>\n" +
                "\t\t<div id=\"app-content-trashbin\" class=\"hidden viewcontainer\">\n" +
                "\t<div id=\"controls\">\n" +
                "\t<div id=\"file_action_panel\"></div>\n" +
                "</div>\n" +
                "<div id='notification'></div>\n" +
                "\n" +
                "<div id=\"emptycontent\" class=\"hidden\">\n" +
                "\t<div class=\"icon-delete\"></div>\n" +
                "\t<h2>无已删除文件</h2>\n" +
                "\t<p>你可以在此处恢复已删除的文件</p>\n" +
                "</div>\n" +
                "\n" +
                "<input type=\"hidden\" name=\"dir\" value=\"\" id=\"dir\">\n" +
                "\n" +
                "<div class=\"nofilterresults hidden\">\n" +
                "\t<div class=\"icon-search\"></div>\n" +
                "\t<h2>此文件夹中无项目</h2>\n" +
                "\t<p></p>\n" +
                "</div>\n" +
                "\n" +
                "<table id=\"filestable\">\n" +
                "\t<thead>\n" +
                "\t\t<tr>\n" +
                "\t\t\t<th id=\"headerSelection\" class=\"hidden column-selection\">\n" +
                "\t\t\t\t<input type=\"checkbox\" id=\"select_all_trash\" class=\"select-all checkbox\"/>\n" +
                "\t\t\t\t<label for=\"select_all_trash\">\n" +
                "\t\t\t\t\t<span class=\"hidden-visually\">全部选择</span>\n" +
                "\t\t\t\t</label>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id='headerName' class=\"hidden column-name\">\n" +
                "\t\t\t\t<div id=\"headerName-container\">\n" +
                "\t\t\t\t\t<a class=\"name sort columntitle\" data-sort=\"name\"><span>名称</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t\t\t<span id=\"selectedActionsList\" class='selectedActions'>\n" +
                "\t\t\t\t\t\t<a href=\"\" class=\"actions-selected\">\n" +
                "\t\t\t\t\t\t\t<span class=\"icon icon-more\"></span>\n" +
                "\t\t\t\t\t\t\t<span>Actions</span>\n" +
                "\t\t\t\t\t\t</a>\n" +
                "\t\t\t\t\t</span>\n" +
                "\t\t\t\t</div>\n" +
                "\t\t\t</th>\n" +
                "\t\t\t<th id=\"headerDate\" class=\"hidden column-mtime\">\n" +
                "\t\t\t\t<a id=\"modified\" class=\"columntitle\" data-sort=\"mtime\"><span>已删除</span><span class=\"sort-indicator\"></span></a>\n" +
                "\t\t\t</th>\n" +
                "\t\t</tr>\n" +
                "\t</thead>\n" +
                "\t<tbody id=\"fileList\">\n" +
                "\t</tbody>\n" +
                "\t<tfoot>\n" +
                "\t</tfoot>\n" +
                "</table>\n" +
                "\t</div>\n" +
                "\t\t<div id=\"searchresults\" class=\"hidden\"></div>\n" +
                "</div><!-- closing app-content -->\n" +
                "\n" +
                "<!-- config hints for javascript -->\n" +
                "<input type=\"hidden\" name=\"filesApp\" id=\"filesApp\" value=\"1\" />\n" +
                "<input type=\"hidden\" name=\"usedSpacePercent\" id=\"usedSpacePercent\" value=\"1\" />\n" +
                "<input type=\"hidden\" name=\"owner\" id=\"owner\" value=\"Broderick\" />\n" +
                "<input type=\"hidden\" name=\"ownerDisplayName\" id=\"ownerDisplayName\" value=\"Broderick Johansson\" />\n" +
                "<input type=\"hidden\" name=\"fileNotFound\" id=\"fileNotFound\" value=\"0\" />\n" +
                "<input type=\"hidden\" name=\"allowShareWithLink\" id=\"allowShareWithLink\" value=\"yes\" />\n" +
                "<input type=\"hidden\" name=\"defaultFileSorting\" id=\"defaultFileSorting\" value=\"name\" />\n" +
                "<input type=\"hidden\" name=\"defaultFileSortingDirection\" id=\"defaultFileSortingDirection\" value=\"asc\" />\n" +
                "<input type=\"hidden\" name=\"showHiddenFiles\" id=\"showHiddenFiles\" value=\"0\" />\n" +
                "\t\t</div>\n" +
                "\n" +
                "\t</body>\n" +
                "</html>\n";
    }

}
