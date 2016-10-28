package com.thlcly.zeus.enums;

/**
 * @author tonyhui
 * @since 16/10/28
 */
public enum FileTypeEnum {

    JAVA(0, ".java");

    private Integer code;
    private String value;

    FileTypeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public Integer getCode() {
        return this.code;
    }
}
