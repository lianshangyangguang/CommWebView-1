# CommWebView
通用webview
- 解决API < 17 下的漏洞
- 加载错误时出现默认页面
- 点击默认页面可重新加载（刷新）

## 导入
app/gradle中加入依赖

```java
compile 'com.jwkj:commwebview:v1.0.5'
````

## 用法

### 初始化并加载页面

```java
wv_main = (CommWebView) findViewById(R.id.wv_main);
        wv_main.setCurWebUrl("https://www.baidu.com1")
                .addJavascriptInterface(new JSCallJava(), "NativeObj")
                .startCallback(new WebViewCallback() {
                    @Override
                    public void onStart() {
                        ELog.e("开始调用了");
                        mProgressDialog.show();
                    }

                    @Override
                    public void onProgress(int curProgress) {
                        ELog.e(curProgress);
                        if (curProgress > 80) {//加载完成80%以上就可以隐藏了，防止部分网页不能
                            mProgressDialog.dismiss();
                            tvTitle.setText(wv_main.getWebTitle());
                        }
                    }

                    @Override
                    public void onError(int errorCode, String description, String failingUrl) {
                        super.onError(errorCode, description, failingUrl);
                        ELog.e(errorCode + " \t" + description + "\t" + failingUrl);
                    }
                });
```

## 销毁
在avtivity销毁的时候需要将webview销毁

```java
 @Override
    protected void onDestroy() {
        wv_main.onDestroy();
        super.onDestroy();
    }
```
