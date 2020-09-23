/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demo.poolservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.stereotype.Component;

/**
 *
 * @author Juneau
 */
@Component("temperatureReader")
public class TemperatureReader {
    
    private String currentTemperatureF;
    
    private String currentTemperatureC;
    
    protected String readTemperatureFile() {
        
        
        String temperatureFile = "/<<path-to>>/temperature.txt";
        System.out.println("Temperature File: " + temperatureFile);
        java.nio.file.Path path = Paths.get(temperatureFile);
        String currentTemperature = null;
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {

            String currentLine = null;
            while ((currentLine = reader.readLine()) != null) {//while there is content on the current line
                currentTemperature = currentLine;
            }
        } catch (IOException ex) {
            ex.printStackTrace(); //handle an exception here
        }
        return currentTemperature;
    }

    /**
     * @return the currentTemperatureF
     */
    public String getCurrentTemperatureF() {
        String temp = readTemperatureFile();
        currentTemperatureF = temp.substring(temp.indexOf(",") + 1, temp.lastIndexOf(")"));
        return currentTemperatureF;
    }

    /**
     * @param currentTemperatureF the currentTemperatureF to set
     */
    public void setCurrentTemperatureF(String currentTemperatureF) {
        this.currentTemperatureF = currentTemperatureF;
    }

    /**
     * @return the currentTemperatureC
     */
    public String getCurrentTemperatureC() {
        String temp = readTemperatureFile();
        currentTemperatureC = temp.substring(temp.indexOf("(") + 1, temp.lastIndexOf(","));
        return currentTemperatureC;
    }

    /**
     * @param currentTemperatureC the currentTemperatureC to set
     */
    public void setCurrentTemperatureC(String currentTemperatureC) {
        this.currentTemperatureC = currentTemperatureC;
    }
    
}
