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
package me.derangedsenators.launcher.launcher.download.githubapi

import com.google.gson.Gson
import me.derangedsenators.launcher.launcher.download.FileDownloader

import java.io.File

import java.nio.channels.ReadableByteChannel

import java.io.FileOutputStream

import java.io.BufferedReader

import me.derangedsenators.launcher.ApplicationManifest

import me.derangedsenators.launcher.launcher.download.Downloader
import me.derangedsenators.launcher.launcher.download.FileDownloader.TaskCompleteListener
import java.io.InputStreamReader
import java.lang.Exception
import java.net.URL
import java.net.URLConnection
import java.nio.channels.Channels


/**
 * Downloads release artifacts off github using Github API
 */
class GithubRelease : Downloader(), TaskCompleteListener {
    private val primitiveResponse: String
    var downloadZipPath: String? = null
        private set
    lateinit var apiResponse: APIResponse
    override var isComplete = false
        set
    private val status = false
    private var downloader: FileDownloader? = null

    /**
     * Downloads the latest release
     */
    override fun download() {
        isComplete = false
    }

    fun runTask() {
        try {
            val file = URL(apiResponse.assets!![0].browser_download_url)
            var workingDir = File.createTempFile("a32n", "")
            var workingPath = workingDir.canonicalPath
            var index: Int
            val fos: FileOutputStream
            if (workingPath.lastIndexOf('/').also { index = it } > 0) {
                workingPath = workingPath.substring(0, index) + "/"
                workingDir = File("$workingPath/Flybywiresim/")
                workingPath = workingDir.canonicalPath
                fos = FileOutputStream(workingPath + "/" + apiResponse.tag_name + ".zip")
            } else if (workingPath.lastIndexOf('\\').also { index = it } > 0) {
                workingPath = workingPath.substring(0, index) + "\\"
                workingDir = File("$workingPath\\Flybywiresim\\")
                workingPath = workingDir.canonicalPath
                downloadZipPath = workingPath + "\\" + apiResponse.tag_name + ".zip"
                workingDir.mkdirs()
                fos = FileOutputStream(workingPath + "\\" + apiResponse.tag_name + ".zip")
            } else {
                fos = FileOutputStream(apiResponse.tag_name + ".zip")
            }
            val rbc: ReadableByteChannel = Channels.newChannel(file.openStream())
            fos.channel.transferFrom(rbc, 0, Long.MAX_VALUE)
            isComplete = true
        } catch (e: Exception) {
            e.printStackTrace()
            isComplete = true
        }
    }

    @Throws(Exception::class)
    fun download2() {
        val URL = apiResponse.assets!![0].browser_download_url
        var workingDir = File.createTempFile("a32n", "")
        var workingPath = workingDir.canonicalPath
        var index: Int
        if (workingPath.lastIndexOf('/').also { index = it } > 0) {
            workingPath = workingPath.substring(0, index) + "/"
            workingDir = File("$workingPath/Flybywiresim/")
            workingPath = workingDir.canonicalPath
        } else if (workingPath.lastIndexOf('\\').also { index = it } > 0) {
            workingPath = workingPath.substring(0, index) + "\\"
            workingDir = File("$workingPath\\Flybywiresim\\")
            workingPath = workingDir.canonicalPath
            downloadZipPath = workingPath + "\\" + apiResponse.tag_name + ".zip"
            workingDir.mkdirs()
        }
        downloader = FileDownloader(downloadZipPath!!, URL)
        downloader!!.addListener(this)
        downloader!!.runWithThread()
    }

    override fun taskComplete() {
        isComplete = true
        println("Broadcast Received... isComplete set to True")
    }

    init {
        val url = java.lang.String.format(
            "https://api.%s/repos/%s/%s/releases/latest",
            ApplicationManifest.REMOTE,
            ApplicationManifest.OWNER,
            ApplicationManifest.PROJECT
        )
        println(url)
        val api = URL(url)
        val connection: URLConnection = api.openConnection()
        val `in` = BufferedReader(
            InputStreamReader(
                connection.getInputStream()
            )
        )
        var apiOutput: String
        var JSON = ""
        while (`in`.readLine().also { apiOutput = it } != null) JSON = JSON + apiOutput
        `in`.close()
        primitiveResponse = JSON
        val gson = Gson()
        apiResponse = gson.fromJson(primitiveResponse, APIResponse::class.java)
    }
}