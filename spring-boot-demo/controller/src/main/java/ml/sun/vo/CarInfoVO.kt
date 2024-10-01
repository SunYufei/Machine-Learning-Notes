package ml.sun.vo

import ml.sun.common.annotation.DataMark
import ml.sun.common.enums.DataMarkType

data class CarInfoVO(
    @DataMark(DataMarkType.LICENSE) val license: String,
    @DataMark(DataMarkType.MOBILE) val mobile: String,
    @DataMark(DataMarkType.ID_CARD) val idCard: String,
    @DataMark(DataMarkType.BANK_CARD) val bankCard: String,
    @DataMark(DataMarkType.CHINESE_NAME) val owner: String
)