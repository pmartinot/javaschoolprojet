/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesi.presentation.model;


import com.verif.projectgen.service.WordService;
import com.verif.projectgen.service.WordServiceLocal;
import java.io.File;
import java.io.FileWriter;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.inject.Inject;

/**
 *
 * @author pierre
 */

@Named
@SessionScoped
public class WordBean implements Serializable {
    
    @Inject
    private WordServiceLocal wordService;
    
    private String word;
    private String pattern;

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
    
    
    public void createMot(){
        final String chemin = "/home/cesi/test.txt";
        final File fichier =new File(chemin); 
        try {
            // Creation du fichier
            fichier .createNewFile();
            // creation d'un writer (un écrivain)
            final FileWriter writer = new FileWriter(fichier);
            try {
                writer.write(getWord());
            } finally {
                // quoiqu'il arrive, on ferme le fichier
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("Impossible de creer le fichier");
        }
        wordService.addWord(getWord());
    }
    
    public void findMots(){
        wordService.findWords(pattern);
    }

    /**
     * Creates a new instance of WordBean
     */
    public WordBean() {
    }
    
}
