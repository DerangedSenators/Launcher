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
package me.derangedsenators.launcher;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.security.*;

/**
 *
 * @author Elliot Willis
 */
public class LauncherMain {
                                                                                                //NEEDS DIRECT DOWNLOAD LINK

    static Path installPath, tempFolder;
    static Boolean verified;
    static String operatingSystem;
    
    public static void main(String[] args){     
        GuiFrame gui = new GuiFrame();
        gui.loadGui();
        operatingSystem = OSDetection();
        verified = true;
        if(checkForUpdates()) {
            Install(operatingSystem);
        }
    }
    
    private static String OSDetection() {
        String os = System.getProperty("os.name").toUpperCase();
        if (os.contains("MAC")) {
            installPath = Paths.get("C:/Users/ellio/Documents/DerangedSenators");               //MAC INSTALL & TEMP PATH?
            tempFolder = Paths.get("C:/Users/ellio/Documents/temp");
            return "mac-os";
        }
        else if (os.contains("WIN")) {
            installPath = Paths.get("C:/Users/ellio/Desktop/DerangedSenators");
            tempFolder = Paths.get("C:/Users/ellio/Desktop/temp");                              //WINDOWS INSTALL & TEMP PATH?
            return "windows";
        }
        else {
            installPath = Paths.get("C:/Users/ellio/Documents/DerangedSenators");               //LINUX INSTALL & TEMP PATH?
            tempFolder = Paths.get("C:/Users/ellio/Documents/temp");
            return "linux";
        }
    }
    
    public static void play() {
        if(!checkForUpdates()) {
            GuiFrame.progressBarText.setText("Launching");
            File program = new File(installPath.toString() + "Cops and Robbers.exe");
            try {
                Process run = Runtime.getRuntime().exec(program.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
    }
    
    private static void Install(String operatingSystem){
        try {
            GuiFrame.progressBarText.setText("Downloading files");
            InputStream in = new URL("https://copsandrobbers.co.uk/download/thankyou-for-downloading/?type=standalone&platform=" + operatingSystem).openStream();
            Path tempZip = Paths.get(tempFolder.toString() + "/DerangedSenators.zip");
            Files.copy(in, tempZip, StandardCopyOption.REPLACE_EXISTING);    
            verified = verify(tempZip.toFile());

            if(verified) {
                GuiFrame.progressBarText.setText("Replacing files");
                unzip(tempZip, Paths.get(tempFolder.toString() + "/DerangedSenators"));
                Files.delete(installPath);
                Files.copy(Paths.get(tempFolder.toString() + "/DerangedSenators"), installPath);
                Files.delete(Paths.get(tempFolder.toString() + "/DerangedSenators"));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static Boolean checkForUpdates() {
        return true;
    }

    private static String getFileChecksum(MessageDigest digest, File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        byte[] byteArray = new byte[1024];
        int bytesCount = 0; 
        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        };
        fis.close();
        byte[] bytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
       return sb.toString();
    }
        
    private static Boolean verify(File path) {
        
        String correctChecksum = "";                                                            //HOW TO GET CORRECT CHECKSUM?
        
        
        MessageDigest zipDigest;
        String zipChecksum;
        GuiFrame.progressBarText.setText("Generating checksum");
        try {
            zipDigest = MessageDigest.getInstance("SHA-256");
            zipChecksum = getFileChecksum(zipDigest, path);
        } catch (NoSuchAlgorithmException | IOException ex) {
            GuiFrame.progressBarText.setText("Verification error");
            return false;
        }
        if (correctChecksum.equals(zipChecksum)) {
            GuiFrame.progressBarText.setText("Checksum verified");
            return true;
        }
        else {
            GuiFrame.progressBarText.setText("Verification failed");
            return false;
        }
    }
    
    private static void unzip(Path zippedPath, Path unzippedPath) {
                                                                                                //UNZIP FILES
    }
}
