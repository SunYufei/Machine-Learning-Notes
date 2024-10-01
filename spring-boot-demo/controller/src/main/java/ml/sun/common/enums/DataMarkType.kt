package ml.sun.common.enums

enum class DataMarkType(val func: (String, Int, Int) -> String) {
    LICENSE({ text, _, _ -> "${text.substring(0, 2)}*****" }),
    MOBILE({ mobile, _, _ -> "${mobile.substring(0, 3)}****${mobile.substring(7, 11)}" }),
    ID_CARD({ card, _, _ -> "${card.substring(0, 6)}************" }),
    BANK_CARD({ card, _, _ -> "${card.substring(0, 6)}*************" }),
    CHINESE_NAME({ name, _, _ -> "${name.substring(0, 1)}${"*".repeat(name.length - 1)}" }),
    DEFAULT({ text, _, _ -> text })
}