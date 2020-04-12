package com.shiningcity.common.enums;

public enum CodeTypeEnum {
    // 枚举
    CODE_TYPE_CHINESE("chinese"),
    CODE_TYPE_NUMLETTER("numLetter"),
    CODE_TYPE_NUM("num"),
    CODE_TYPE_LETTER("letter");
    // 属性
    private final String code;
    // 构造函数
    private CodeTypeEnum(String code) {
        this.code = code;
    }
    // 通过枚举获取值（get方法）
    public String getCode() {
        return code;
    }
    // 通过值获取枚举
    public static CodeTypeEnum getByCode(String code) {
        for (CodeTypeEnum codeType : CodeTypeEnum.values()) {
            if (codeType.getCode().equals(code)) {
                return codeType;
            }
        }
        return null;
    }
}
