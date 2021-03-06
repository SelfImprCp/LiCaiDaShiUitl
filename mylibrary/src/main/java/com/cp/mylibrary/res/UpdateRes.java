package com.cp.mylibrary.res;

/**
 * @author Administrator
 */
public class UpdateRes extends Response {

    private String error;
    private String errorMsg;
    private String version;
    private String url;
    private String desc;
    // 0非强制更新，1强制更新
    private int forceupdate;

    private String versionCode;

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getForceupdate() {
        return forceupdate;
    }

    public void setForceupdate(int forceupdate) {
        this.forceupdate = forceupdate;
    }
}
