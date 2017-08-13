package com.aiijie.mybasemodule.bean;

/**
 * Created by klx on 2017/8/13.
 */

public class ShortUrlBean {

    /**
     * url_short : http://t.cn/R9BJRd7
     * url_long : https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx8f94b1f1bab669bf&redirect_uri=
     * type : 0
     */

    private String url_short;
    private String url_long;
    private int type;

    public String getUrl_short() {
        return url_short;
    }

    public void setUrl_short(String url_short) {
        this.url_short = url_short;
    }

    public String getUrl_long() {
        return url_long;
    }

    public void setUrl_long(String url_long) {
        this.url_long = url_long;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ShortUrlBean{" +
                "url_short='" + url_short + '\'' +
                ", url_long='" + url_long + '\'' +
                ", type=" + type +
                '}';
    }
}
