package com.akash.smoothfilemanager

import android.content.Context
import android.content.Intent
import androidx.core.content.FileProvider
import java.io.File
import java.util.*

object FileOpener {

    fun openFile(context: Context, file: File) {
        val uri = FileProvider.getUriForFile(
            context,
            context.applicationContext.packageName + ".provider",
            file
        )
        val intent = Intent(Intent.ACTION_VIEW)
        val uriString: String = uri.toString().lowercase(Locale.getDefault())

        if (uriString.contains(".pdf") ||
            uriString.contains(".txt")
        ) {
            intent.setDataAndType(uri, "text/plain")
        } else if (uriString.contains(".mp3") ||
            uriString.contains(".wav")
        ) {
            intent.setDataAndType(uri, "audio/x-wav")
        } else if (uriString.contains(".png") ||
            uriString.contains(".jpg") ||
            uriString.contains(".jpeg") ||
            uriString.contains(".gif")
        ) {
            intent.setDataAndType(uri, "image/jpeg")
        }
        else if(uriString.contains(".mp4"))
            intent.setDataAndType(uri,"video/*")
        else
            intent.setDataAndType(uri,"*/*")


        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        context.startActivity(intent)
    }
}
