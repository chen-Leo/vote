package com.example.demo.util;

import org.apache.commons.lang.StringUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通过学号获取学院信息
 *
 * @author Administrator
 */
public class HtmlRequest {

    private static Pattern NUMBER_PATTERN = Pattern.compile("\"yxm\":\"\\S+?\",");

    public static String collegeFind(String studentId) throws Exception {

        URL url =  new URL("http://jwzx.cquptx.cn/data/json_StudentSearch.php?searchKey=" + studentId);
//      URL url = new URL("http://jwzx.cqupt.edu.cn/data/json_StudentSearch.php?searchKey=" + studentId);
//      String urlSource = getURLSource(url);
        String urlSource = HtmlUtils.getByString(String.valueOf(url));
        String str = unicode2String(urlSource);
        Matcher m = NUMBER_PATTERN.matcher(str);

        if (m.find()) {
            String college = m.group().substring(m.group().indexOf(':') + 2, m.group().indexOf(',') - 1);
            return college;
        } else {
            return null;
        }
    }

//    /**
//     * 读取网页源代码
//     */
//    private static String getURLSource(URL url) throws Exception {
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        conn.setRequestMethod("GET");
//        conn.setConnectTimeout(5 * 1000);
//        InputStream inStream = conn.getInputStream();
//        byte[] data = readInputStream(inStream);
//        String htmlSource = new String(data);
//        return htmlSource;
//    }


   private static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1204];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();

    }

    private static String unicode2String(String unicode) {
        if (StringUtils.isBlank(unicode)) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;

        while ((i = unicode.indexOf("\\u", pos)) != -1) {
            sb.append(unicode.substring(pos, i));
            if (i + 5 < unicode.length()) {
                pos = i + 6;
                sb.append((char) Integer.parseInt(unicode.substring(i + 2, i + 6), 16));
            }
        }

        sb.append(unicode.substring(pos));
        return sb.toString();
    }




}

