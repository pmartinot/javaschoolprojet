/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.projectgen.model;

import com.gen.projectgen.metier.WordServiceLocal;
import com.gen.projectgen.persistance.Word;
import java.io.Serializable;
import java.util.List;
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
    private List<Word> words;

    @Inject
    private WordServiceLocal wordService;


    /**
     * Creates a new instance of wordBean
     */
    public void init() {
    }
    
    public String createMot(){
        wordService.addWord(word);
        HttpSession session = (HttpSession)
        FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "index"; 
    }
    
    public void findMots(){
        words = wordService.findWords(word);
        for (Word w: words) System.out.println(w.getWord()); 
        System.out.println(words.size()); 
        HttpSession session = (HttpSession)
        FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
    }
    
    public String redirectToRslt(){
        System.out.println("On navigue vers les resultats");
        return "rslt";
    }

    
    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }
    
    public void setWords(List<Word> words) {
        this.words = words;
    }

    public List<Word> getWords() {
        return words;
    }
    
}
