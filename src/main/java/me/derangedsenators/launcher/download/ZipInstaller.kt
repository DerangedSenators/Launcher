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

import java.io.IOException

import java.io.File

import java.util.zip.ZipEntry

import java.io.FileOutputStream

import java.io.InputStream

import java.util.Enumeration

import java.util.zip.ZipFile


/**
 * Installs Zip versions of the Game (Based on Github releases). UNTESTED
 * @author Hanzalah Ravat
 */
class ZipInstaller(protected val zipPath: String, protected val installPath: String) : Installer {


    @Throws(IOException::class)
    override fun install(): Boolean {
        return try {
            val zipFile = ZipFile(zipPath)
            val enumeration: Enumeration<*> = zipFile.entries()
            while (enumeration.hasMoreElements()) {
                val entry = enumeration.nextElement() as ZipEntry
                val name = entry.name
                val size = entry.size
                val compressedSize = entry.compressedSize
                val out = String.format(
                    "name: %-20s | size: %6d | compressed size: %6d\n",
                    name, size, compressedSize
                )
                val file = File(installPath + name)
                if (name.endsWith("/")) {
                    file.mkdirs()
                    continue
                }
                val parent = file.parentFile
                parent?.mkdirs()
                val inputStream = zipFile.getInputStream(entry)
                println(file.absolutePath)
                file.parentFile.mkdirs()
                file.createNewFile()
                val fileOutputStream = FileOutputStream(file, false)
                val bytes = ByteArray(1024)
                var length: Int
                while (inputStream.read(bytes).also { length = it } >= 0) {
                    fileOutputStream.write(bytes, 0, length)
                }
                inputStream.close()
                fileOutputStream.close()
            }
            zipFile.close()
            true
        } catch (exception: IOException) {
            exception.printStackTrace()
            false
        }
    }

    companion object {
        @Throws(IOException::class)
        fun newFile(destinationDir: File, zipEntry: ZipEntry): File {
            val destFile = File(destinationDir, zipEntry.name)
            val destDirPath = destinationDir.canonicalPath
            val destFilePath = destFile.canonicalPath
            if (!destFilePath.startsWith(destDirPath + File.separator)) {
                throw IOException("Entry is outside of the target dir: " + zipEntry.name)
            }
            return destFile
        }
    }
}
