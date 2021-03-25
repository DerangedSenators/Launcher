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
package me.derangedsenators.launcher.download.githubapi

import com.google.gson.Gson
import me.derangedsenators.launcher.ApplicationManifest
import me.derangedsenators.launcher.download.DownloadCompleteListener
import me.derangedsenators.launcher.download.Downloader
import me.derangedsenators.launcher.download.FileDownloader
import me.derangedsenators.launcher.utils.OSDetect
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.net.URLConnection

/**
 * Downloader that works by getting latest release for your OS using the GitHub API
 * @author Hanzalah Ravat
 */
class GithubReleaseDownloader (listener: DownloadCompleteListener, destination: String): Downloader(listener,destination){
    var apiResponse: APIResponse
    private var mIndex = -1
    init{
        val url = "https://api.${ApplicationManifest.REMOTE}/repos/${ApplicationManifest.OWNER}/${ApplicationManifest.PROJECT}/releases/latest"
        val apiURL = URL(url)
        val connection: URLConnection = apiURL.openConnection()
        val inputReader = BufferedReader(
            InputStreamReader(
                connection.getInputStream()
            )
        )
        var apiOut: String
        var JSON = ""
        while (inputReader.readLine().also { apiOut = it } != null) JSON += apiOut
        inputReader.close()
        val gson = Gson()
        apiResponse = gson.fromJson(JSON, APIResponse::class.java)
        val os = OSDetect.OSDetection()
        for((index,value) in apiResponse.assets?.withIndex()!!) {
            if (value.name.contains(os)) {
                mIndex = index
            }
        }
    }

    override fun download() {
        if(mIndex != -1){
            val downloader = FileDownloader(listener,destination,apiResponse.assets!![mIndex].browser_download_url)
        } else{
            listener.onError(null) //TODO create an exception here.s
        }
    }



    override fun threadName(): String {
        return TAG
    }

    companion object{
        private const val TAG = "GITHUB_RELEASE_DOWNLOADER"
    }
}