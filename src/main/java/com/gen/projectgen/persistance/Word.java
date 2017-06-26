/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.projectgen.persistance;


import javax.persistence.*;
/**
 *
 * @author cesi
 */
@Entity
@Table(name="dico")
public class Word {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long wordId;
    
    @Column(name="mot")
    private String word;


    public void setWord(String word) {
        this.word = word;
    }

    public Long getWordId() {
        return wordId;
    }

    public String getWord() {
        return word;
    }

    
}
