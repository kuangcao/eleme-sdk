package com.jiabangou.eleme.pcsdk.exception;

/**
 * Created by freeway on 2016/12/4.
 */
public class ElemePCLoginServiceException extends ElemePCServiceException {
    private String captchaImageB64;
    private boolean showCaptcha;
    private boolean weakPassword;

    public ElemePCLoginServiceException(String message) {
        super(message);
    }

    public String getCaptchaImageB64() {
        return captchaImageB64;
    }

    public ElemePCLoginServiceException setCaptchaImageB64(String captchaImageB64) {
        this.captchaImageB64 = captchaImageB64;
        return this;
    }

    public boolean isShowCaptcha() {
        return showCaptcha;
    }

    public ElemePCLoginServiceException setShowCaptcha(boolean showCaptcha) {
        this.showCaptcha = showCaptcha;
        return this;
    }

    public boolean isWeakPassword() {
        return weakPassword;
    }

    public ElemePCLoginServiceException setWeakPassword(boolean weakPassword) {
        this.weakPassword = weakPassword;
        return this;
    }


}
