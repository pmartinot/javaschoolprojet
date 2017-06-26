/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.projectgen.model;

import com.gen.projectgen.metier.WordServiceLocal;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cesi
 */
@Named(value = "wordBean")
@SessionScoped
public class wordBean implements Serializable{
    
    private String word;
    
    @Inject
    private WordServiceLocal wordService;


    /**
     * Creates a new instance of wordBean
     */
    public wordBean() {
    }
    
    public String createMot(){
        wordService.addWord(word);
        HttpSession session = (HttpSession)
        FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "index"; 
    }
    
    public String findMots(){
        wordService.findWords(word);
        HttpSession session = (HttpSession)
        FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "index"; 
    }

    
    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
    
}
