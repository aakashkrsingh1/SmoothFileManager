package com.akash.smoothfilemanager

import java.io.File

interface OnFileSelectedListener {
fun onFileClick(file:File)
fun onFileLongClick(file:File,position:Int)

}