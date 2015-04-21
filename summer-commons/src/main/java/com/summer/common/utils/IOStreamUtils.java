package com.summer.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URL;

/**
 * Created by Allen on 2015/4/15.
 */
public class IOStreamUtils {

    public static byte[] readInputStreamToBytes(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        //每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        //使用一个输入流从buffer里把数据读取出来
        while( (len=inStream.read(buffer)) != -1 ){
            //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        //关闭输入流
        inStream.close();
        //把outStream里的数据写入内存
        return outStream.toByteArray();
    }

    public static void saveByteFile(byte[] bytes,String filePath) throws IOException {
        FileOutputStream outStream = new FileOutputStream(filePath);
        outStream.write(bytes);
        outStream.close();
    }

    public static void saveFile(String urlPath,String filePath) throws Exception {
        saveByteFile(HttpUrlContextUtils.getResponseBytes(urlPath),filePath);
    }

    public static String readTxtFile(String filePath,String encoding) {
        InputStreamReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            if (StringUtils.isEmpty(encoding)) {
                encoding = "utf-8";
            }
            File file = new File(filePath);
            if (file.isFile() && file.exists()) {              //判断文件是否存在
                reader = new InputStreamReader(
                        new FileInputStream(file), encoding);  //考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(reader);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    lineTxt.replaceAll("\\\"", "\"");
                    System.out.println(lineTxt);System.out.println();
                    sb.append(lineTxt);
                }
                reader.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static String getClassPath() {
        return IOStreamUtils.class.getResource("/").getFile();
    }

    public static String readTxtFile(String filePath) {
        return readTxtFile(filePath,null);
    }

    public static String readClassPathTxtFile(String filePath) {
        return readTxtFile(getClassPath() + filePath);
    }

}
