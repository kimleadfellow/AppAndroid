package com.example.leadfellow

import java.io.UnsupportedEncodingException
import java.nio.charset.Charset
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.util.*
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException
import javax.crypto.spec.SecretKeySpec


/**
 * This program demonstrates how to encrypt/decrypt
 * input using the Blowfish
 * Cipher with the Java Cryptography.
 */
class BlowfishDemo {
    @Throws(
        NoSuchAlgorithmException::class,
        NoSuchPaddingException::class,
        InvalidKeyException::class,
        IllegalBlockSizeException::class,
        BadPaddingException::class,
        UnsupportedEncodingException::class
    )
    fun encrypt(password: String, key: String): String {
        val KeyData = key.toByteArray()
        val KS = SecretKeySpec(KeyData, "Blowfish")
        val cipher = Cipher.getInstance("Blowfish")
        cipher.init(Cipher.ENCRYPT_MODE, KS)
        val encrypted = cipher.doFinal(password.toByteArray())

        return String(encrypted)
    }

    @Throws(
        NoSuchAlgorithmException::class,
        NoSuchPaddingException::class,
        InvalidKeyException::class,
        IllegalBlockSizeException::class,
        BadPaddingException::class
    )
    fun decrypt(encryptedtext: String?, key: String): String {
        val KeyData = key.toByteArray()
        val KS = SecretKeySpec(KeyData, "Blowfish")
        val ecryptedtexttobytes =
            Base64.getDecoder().decode(encryptedtext)
        val cipher = Cipher.getInstance("Blowfish")
        cipher.init(Cipher.DECRYPT_MODE, KS)
        val decrypted = cipher.doFinal(ecryptedtexttobytes)
        return String(decrypted, Charset.forName("UTF-8"))
    }

    companion object {
        @Throws(Exception::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val password = "admin"
            val key = "abc"
            println("Password: $password")
            val obj = BlowfishDemo()
            val enc_output = obj.encrypt(password, key)
            println("Encrypted text: $enc_output")
            val dec_output = obj.decrypt(enc_output, key)
            println("Decrypted text: $dec_output")
        }
    }
}