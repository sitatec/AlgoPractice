package easy

fun caesarCipherEncryptor(string: String, key: Int): String {
    // Write your code here.
    val charArray = Array(string.length){' '}

    for(i in string.indices){
        charArray[i] = ((string[i].toAlphabeticalPosition() + key) % 26).toChar()
    }

    return charArray.joinToString()
}

fun Char.toAlphabeticalPosition(): Int {
    return code - 96
}