package com.s4ltf1sh.bookstore.common.extensions

import java.util.Locale

// Validations
fun String.isEmailValid(): Boolean {
    val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return this.matches(emailRegex.toRegex())
}

fun String.isPasswordValid(): Boolean {
    val passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
    return this.matches(passwordRegex.toRegex())
}

fun String.isPhoneNumberValid(): Boolean {
    val phoneRegex = "^[+]?[0-9]{10,13}$"
    return this.matches(phoneRegex.toRegex())
}

fun String.isNameValid(): Boolean {
    val nameRegex = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$"
    return this.matches(nameRegex.toRegex())
}


// String manipulations
fun String?.isNotNullOrEmpty(): Boolean {
    return this.isNullOrEmpty().not()
}

fun String?.isNotNullOrBlank(): Boolean {
    return this.isNullOrBlank().not()
}

fun String.toCamelCase(): String {
    return this.split(" ").joinToString("") { string ->
        string.replaceFirstChar { firstChar ->
            if (firstChar.isLowerCase()) firstChar.titlecase(
                Locale.ROOT
            ) else firstChar.toString()
        }
    }
}