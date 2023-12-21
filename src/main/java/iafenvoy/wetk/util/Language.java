package iafenvoy.wetk.util;

public enum Language {
    Chinese("zh_cn"),
    English("en_us");

    public static Language CURRENT= Language.Chinese;
    private final String shortName;

    Language(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}
