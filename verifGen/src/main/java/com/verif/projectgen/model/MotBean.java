/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verif.projectgen.model;

import com.verif.database.persistence.Mot;
import com.verif.database.dbmanager.DicoManager;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Named;
import javax.inject.Inject;

/**
 *
 * @author pierre
 */

@Named(value = "motModel")
@SessionScoped
public class MotBean implements Serializable {
    
    @Inject
    private DicoManager dicoManager;
    
    private Mot mot;
    List<Mot> mots;
    
    private Long bookId;
    private String word;
    
    
    public String createMot(){
        mot = new Mot();
        mot.setMot(word);
        mot = dicoManager.createMot(mot);
        if(mot==null){//si le livre n'a pas pu être associé à un éditeur car les id ne correpondent pas à un livre ou éditeur inséré en base
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Erreur"));
            return null;
        }
        return "display";
    }
    
    
    public void findMatchingPatternMots(){
       mots = null;
       mots= dicoManager.findByCriteria(pattern);   
    }
    
    public void find(){
       mots = null;
       mots= dicoManager.findAll();   
    }
    
    
    public void setWord(String word) {
        this.word = word;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getWord() {
        return word;
    }

    public String getPattern() {
        return pattern;
    }
    private String pattern;
    
    
}
