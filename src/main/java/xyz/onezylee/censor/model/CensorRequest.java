package xyz.onezylee.censor.model;

import jakarta.validation.constraints.NotBlank;

public class CensorRequest {

    @NotBlank(message = "text must not be blank")
    private String text;

    public CensorRequest() {
    }

    public CensorRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

