package ml.sun.switcher

import ml.sun.common.annotation.ServiceSwitch
import ml.sun.common.enums.ServiceSwitchKey
import ml.sun.common.result.BaseResult
import ml.sun.common.result.ResultCode
import org.springframework.stereotype.Service

@Service
class LoginService {
    @ServiceSwitch(key = ServiceSwitchKey.LOGIN_SWITCH, code = ResultCode.LATER)
    fun doLogin() = BaseResult.success(null)
}
