/*
 * Copyright (C) 2021 Deranged Senators
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.derangedsenators.launcher.launcher.download

import java.io.FileOutputStream
import java.lang.Exception
import java.net.URL
import java.nio.channels.Channels
import java.nio.channels.FileChannel
import java.nio.channels.ReadableByteChannel

import java.util.*


/**
 * Downloads a file from a  source using Background Worker threaded tasks.
 */
class FileDownloader(private val destination: String, private val URL: String) : Runnable {
    private val mThread: Thread = Thread(this, TAG)
    private var isComplete = false
    private val listenerList: MutableList<TaskCompleteListener>
    override fun run() {
        print("Download Starting...")
        try {
            val mURL = URL(URL)
            val readableByteChannel = Channels.newChannel(mURL.openStream())
            println(destination)
            val fileOutputStream = FileOutputStream(destination)
            val fileChannel = fileOutputStream.channel
            fileOutputStream.channel
                .transferFrom(readableByteChannel, 0, Long.MAX_VALUE)
            print("done \n")
        } catch (e: Exception) {
            e.printStackTrace()
            print("Error: Exception Caught \n")
        }
        isComplete = true
        println("Broadcasting to Listeners")
        for (listener in listenerList) {
            listener.taskComplete()
        }
    }

    /**
     * Runs the downloader using another thread
     */
    fun runWithThread() {
        mThread.start()
    }

    fun addListener(listener: TaskCompleteListener) {
        listenerList.add(listener)
    }

    interface TaskCompleteListener {
        fun taskComplete()
    }

    companion object {
        private const val TAG = "FILE_DOWNLOADER"
    }

    init {
        listenerList = LinkedList()
    }
}
