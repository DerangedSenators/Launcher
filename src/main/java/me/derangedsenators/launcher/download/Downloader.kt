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
package me.derangedsenators.launcher.download

import java.io.File

/**
 * Abstract Download class
 * @author Hanzalah Ravat
 */
abstract class Downloader(protected val listener: DownloadCompleteListener, protected val destination: String) {
    /**
     * Method that downloads the specified file
     */
    protected abstract fun onStartDownload()

    abstract fun threadName(): String

    /**
     * Thread which handles the download
     */
    private val thread = Thread{
        onStartDownload();
    }

    /**
     * Begins the download process
     */
    fun download(){
        thread.start()
    }
}