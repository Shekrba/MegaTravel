package com.megatravel.admin.dto;

public class KomentarDTO {

    private String username;
    private String smestaj;
    private String text;
    private Long id;
    private boolean publish;

    public KomentarDTO() {}

    public KomentarDTO(String username, String smestaj, String text, Long id, boolean publish) {
        this.id = id;
        this.smestaj = smestaj;
        this.publish = publish;
        this.text = text;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSmestaj() {
        return smestaj;
    }

    public void setSmestaj(String smestaj) {
        this.smestaj = smestaj;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }
}
