package com.jwkj;

/**
 * webview回调
 * Created by HDL on 2017/6/23.
 */

public abstract class WebViewCallback {
    /**
     * 开始加载的时候调用
     */
    public void onStart() {
    }

    /**
     * 加载进度回调
     *
     * @param curProgress 当前进度值[0,100]
     */
    public void onProgress(int curProgress) {
    }

    public void onError( int errorCode, String description, String failingUrl) {

    }
}
