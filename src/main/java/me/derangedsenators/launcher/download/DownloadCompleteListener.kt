package me.derangedsenators.launcher.download

import java.io.File
import java.lang.Exception

/**
 * Interface to monitor complete downloads
 * @author Hanzalah Ravat
 */
interface DownloadCompleteListener {
    /**
     * Method to be called when a download is completed successfully.
     */
    fun onDownloadSuccess()

    /**
     * Method that is invoked when a download fails
     * @param exception Any Exception that is thrown during the download process. Can be null if no exception is found
     */
    fun onError(exception: Exception?)
}