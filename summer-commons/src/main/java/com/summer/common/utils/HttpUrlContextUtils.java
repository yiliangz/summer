package com.summer.common.utils;

import com.summer.common.constant.RequestType;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HttpUrlContextUtils {

    private static String zhPattern = "[\\u4e00-\\u9fa5]+";

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String result = HttpUrlContextUtils.getResponseText("http://nba.sports.sina.com.cn/star/John-Lucas III.shtml", null, "gb2312");
        System.out.println(result);
    }

    /**
     * 获取地址
     * @param params
     * @param encoding
     * @return
     * @throws Exception
     */
    public static String getResponseText(String path,String params, String encoding) {
        return HttpUrlContextUtils.getResponse(path, RequestType.GET, params, encoding);
    }

    public static String postResponseText(String path,String params, String encoding) {
        return HttpUrlContextUtils.getResponse(path, RequestType.POST, params, encoding);
    }


    /**
     * 从url获取结果
     * @param is
     * @param encoding
     * @return
     */
    public static String readTextContext(InputStream is, String encoding) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,encoding));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = reader.readLine())!= null) {
            buffer.append(line);
        }
        reader.close();
        return buffer.toString();
    }

    public static String getResponse(String path,RequestType requestType,String params,String encoding) {
        HttpURLConnection connection = null;
        try {
            connection = setConnection(path, connection, requestType, params,encoding);
            return readTextContext(connection.getInputStream(), encoding);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            connection.disconnect();  // 关闭连接
        }
        return null;
    }

    public static byte[] getResponseBytes(String path,String encoding) throws Exception {
        return getResponseBytes(path, null,encoding);
    }

    public static byte[] getResponseBytes(String path,String params,String encoding) throws Exception {
        HttpURLConnection connection = null;
        try {
            connection = setConnection(path, connection, RequestType.GET, params,encoding);
            return IOStreamUtils.readInputStreamToBytes(connection.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            connection.disconnect();  // 关闭连接
        }
        return null;
    }

    public static HttpURLConnection setConnection(String path,
                                                  HttpURLConnection connection,
                                                  RequestType requestType,
                                                  String params,
                                                  String encoding) throws IOException {
        URL url = new URL(encode(path,encoding));

        connection = (HttpURLConnection)url.openConnection();
        connection.setConnectTimeout(15000); // 设置连接超时时间，单位毫秒
        connection.setReadTimeout(15000);    // 设置读取数据超时时间，单位毫秒
        connection.setDoInput(true);        // 是否打开输出 true|false
        connection.setDoOutput(true);       // 是否打开输入流true|false
        connection.setRequestMethod(requestType.toString());// 提交方法POST|GET
        connection.setUseCaches(false);     // 是否缓存true|false
        connection.connect();               // 打开连接端口
        if (requestType.equals(RequestType.POST)) {
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            if (!StringUtils.isEmpty(params)){
                out.writeBytes(params);
            }
            out.flush();
            out.close();
        }
        return connection;
    }

    public static String encode(String str, String encoding)
            throws UnsupportedEncodingException {
        str = str.replaceAll(" ", "+");// 对空字符串进行处理
        Pattern p = Pattern.compile(zhPattern);
        Matcher m = p.matcher(str);
        StringBuffer buffer = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(buffer, URLEncoder.encode(m.group(0), encoding));
        }
        m.appendTail(buffer);
        return buffer.toString();
    }

    /**
     * 字符转码
     * @param theString
     * @return
     */
    public static String decodeUnicode(String theString){
        char aChar;
        int len = theString.length();
        StringBuffer buffer = new StringBuffer(len);
        for (int i = 0; i < len;) {
            aChar = theString.charAt(i++);
            if(aChar == '\\'){
                aChar = theString.charAt(i++);
                if(aChar == 'u'){
                    int val = 0;
                    for(int j = 0; j < 4; j++){
                        aChar = theString.charAt(i++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                val = (val << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                val = (val << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                val = (val << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException("Malformed encoding.");
                        }
                    }
                    buffer.append((char) val);
                }else{
                    if(aChar == 't'){
                        aChar = '\t';
                    }
                    if(aChar == 'r'){
                        aChar = '\r';
                    }
                    if(aChar == 'n'){
                        aChar = '\n';
                    }
                    if(aChar == 'f'){
                        aChar = '\f';
                    }
                    buffer.append(aChar);
                }
            }else{
                buffer.append(aChar);
            }
        }
        return buffer.toString();
    }
}
