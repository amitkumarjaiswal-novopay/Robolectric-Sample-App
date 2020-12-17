package com.carlsberg_stack.robolectricsampletest

import java.util.regex.Pattern

object EmailValidator {

    /**
     * Email validation pattern.
     */
    // validating email id
    val EMAIL_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun isValidEmail(emailAddress: String?): Boolean {
        return false
//        return emailAddress != null && EMAIL_PATTERN.matcher(emailAddress).matches();
    }
}