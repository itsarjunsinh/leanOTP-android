package xyz.arjunsinh.leanotpsms

import android.telephony.SmsManager

object SendOTP {
    internal fun send(number: String, otp: String) {
        val smsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(number, null, "Your OTP code is $otp.", null, null)
    }
}