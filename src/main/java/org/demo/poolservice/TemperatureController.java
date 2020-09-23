/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.demo.poolservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juneau
 */
@RestController
public class TemperatureController {
    
    @Autowired
    private TemperatureReader temperatureReader;
    
    @RequestMapping("/temperature")
	public String index() {
            return temperatureReader.getCurrentTemperatureF();
	}
    
}
