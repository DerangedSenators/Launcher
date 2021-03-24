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

import java.io.IOException

import java.io.ObjectOutputStream

import java.io.FileOutputStream

import java.io.Serializable


/**
 * Class to hold Github API Response for latest release.
 * @author Hanzalah Ravat
 */
class APIResponse : Serializable {
    var tag_name: String? = null
    var prerelease = false
    var published_at: String? = null
    var assets: List<Assets>? = null
    var body: String? = null

    inner class Assets(val name: String,val size: Int, val browser_download_url: String) : Serializable

    /**
     * Attempts to serialise the API response for later use
     * @param path The location to store the file along with filename
     * @param apiResponse The API response instance
     * @return True if write is completed successfully
     */
    fun writeToDisk(path: String?, apiResponse: APIResponse?): Boolean {
        try {
            val fileOut = FileOutputStream(path)
            val out = ObjectOutputStream(fileOut)
            out.writeObject(apiResponse)
            out.close()
            fileOut.close()
            return true
        } catch (i: IOException) {
            i.printStackTrace()
        }
        return false
    }
}