/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.projectgen.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cesi
 */

@XmlRootElement
public class Verif {
    
    private String decryptedData;
    private String fileName;
    private String key;

    public String getDecryptedData() {
        return decryptedData;
    }

    public String getFileName() {
        return fileName;
    }

    public String getKey() {
        return key;
    }

    public void setDecryptedData(String decryptedData) {
        this.decryptedData = decryptedData;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setKey(String key) {
        this.key = key;
    }
       
}
