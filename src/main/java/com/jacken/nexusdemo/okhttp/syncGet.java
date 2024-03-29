package com.jacken.nexusdemo.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 同步get请求
 */
public class syncGet {
    public static void main(String[] args) throws Exception {
        String urlBaidu = "http://www.baidu.com/";
        OkHttpClient okHttpClient = new OkHttpClient(); // 创建OkHttpClient对象
        Request request = new Request.Builder().url(urlBaidu).build(); // 创建一个请求
        Response response = okHttpClient.newCall(request).execute(); // 返回实体
        if (response.isSuccessful()) { // 判断是否成功
            /**获取返回的数据，可通过response.body().string()获取，默认返回的是utf-8格式；
             * string()适用于获取小数据信息，如果返回的数据超过1M，建议使用stream()获取返回的数据，
             * 因为string() 方法会将整个文档加载到内存中。*/
            System.out.println(response.body().string()); // 打印数据
        }else {
            System.out.println("失败"); // 链接失败
        }
    }
}
