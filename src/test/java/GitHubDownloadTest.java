import me.derangedsenators.launcher.download.DownloadCompleteListener;
import me.derangedsenators.launcher.download.githubapi.GithubReleaseDownloader;
import me.derangedsenators.launcher.utils.OSDetect;
import org.jetbrains.annotations.Nullable;
import org.junit.Test;

import java.io.File;

public class GitHubDownloadTest {
    // Will Try and Download for My Platform

    @Test
    public void DownloadRelease(){

        String destination = "";
        switch (OSDetect.OSDetection()){
            case "linux":
            case "mac-os":
                destination = "downloadTest.tar.xz";
                break;
            case "windows":
                destination = "download.zip";
        }
        String finalDestination = destination;
        GithubReleaseDownloader downloader = new GithubReleaseDownloader(new DownloadCompleteListener() {
            @Override
            public void onDownloadSuccess() {
                File file = new File(finalDestination);
                if(file.exists()){
                    System.out.println(file.getAbsolutePath());
                    assert(true);
                } else{
                    assert(false);
                }
            }

            @Override
            public void onError(@Nullable Exception exception) {
                assert(false);
            }
        },destination);
        downloader.download();
    }
}
