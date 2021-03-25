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

import java.io.IOException
import java.lang.Exception

/**
 * Installer Abstract Class
 * @author Hanzalah Ravat
 */
abstract class Installer(protected val listener: InstallerListener) {

    @Throws(IOException::class)
    abstract fun onStart()

    private val thread = Thread{
        onStart()
    }

    /**
     * Begins the download process
     */
    fun install(){
        thread.start()
    }
    /**
     * Interface that must be implemented to subscribe to installer notifications
     */
    interface InstallerListener{
        /**
         * Method to be invoked once installation completes successfully
         */
        fun onSuccess()

        /**
         * Method to be invoked should there be any exception thrown during the process
         */
        fun onException(exception: Exception)
    }
}