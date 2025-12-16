package xyz.onezylee.censor.model;

public class CensorResponse {
    private boolean hasKeyword;
    private String maskedText;

    public CensorResponse() {
    }

    public CensorResponse(boolean hasKeyword, String maskedText) {
        this.hasKeyword = hasKeyword;
        this.maskedText = maskedText;
    }

    public boolean isHasKeyword() {
        return hasKeyword;
    }

    public void setHasKeyword(boolean hasKeyword) {
        this.hasKeyword = hasKeyword;
    }

    public String getMaskedText() {
        return maskedText;
    }

    public void setMaskedText(String maskedText) {
        this.maskedText = maskedText;
    }
}

