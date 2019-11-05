package com.jacken.nexusdemo.okhttp;

import okhttp3.*;

import java.io.IOException;

/**
 * 异步Get请求
 */
public class asyncGet {
    public static void main(String[] args) {
        String urlBaidu = "http://www.baidu.com/";
        OkHttpClient okHttpClient = new OkHttpClient(); // 创建OkHttpClient对象
        Request request = new Request.Builder().url(urlBaidu).build(); // 创建一个请求
        okHttpClient.newCall(request).enqueue(new Callback() { // 回调

            public void onResponse(Call call, Response response) throws IOException {
                // 请求成功调用，该回调在子线程
                System.out.println(response.body().string());
            }

            public void onFailure(Call call, IOException e) {
                // 请求失败调用
                System.out.println(e.getMessage());
            }
        });
    }
}
