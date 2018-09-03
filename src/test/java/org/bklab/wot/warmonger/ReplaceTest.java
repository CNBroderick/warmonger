package org.bklab.wot.warmonger;

import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
public class ReplaceTest {

    @Test
    public void test1() {
        String s = "啊啊啊啊啊啊啊<span id=server-status></span>啊啊啊啊啊啊啊";
        String regex = "<span id=server-status>.*</span>";
        String result = s.replaceAll(regex, "<span id=server-status>无需更新，下一次检测时间：2018年8月27日 13点21分</span>");
        System.out.println(result);
    }
//    @Test
//    public void test2() {
//        Connection connection = new Connection("xn--fx1at73c.com", 22);
//        File pem = new File(Config.BeijingServerPem);
//        try {
//            connection.connect();
//            boolean isAuthenticated = connection.authenticateWithPublicKey("root", pem, "");
//            System.out.println(isAuthenticated);
//            SFTPv3Client client = new SFTPv3Client(connection);
//            Vector files = client.ls("/");
//            Iterator<SFTPv3DirectoryEntry> iterator = files.listIterator();
//            while (iterator.hasNext()) {
//                SFTPv3DirectoryEntry entry = iterator.next();
//                System.out.println(entry.filename);
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }
}
