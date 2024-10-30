package com.example.myapplication

import android.content.Context
import android.telephony.SmsManager
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters

class SmsWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val phoneNumber = inputData.getString("PHONE_NUMBER") ?: return Result.failure()
        val message = "Please Handover the Key"
        // Send the SMS
        try {
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNumber, null, message, null, null)
            return Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            return Result.failure()
        }
    }
}
