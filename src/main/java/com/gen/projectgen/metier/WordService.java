/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.projectgen.metier;

import com.gen.projectgen.integration.WordDAO;
import com.gen.projectgen.persistance.Word;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.inject.Inject;

/**
 *
 * @author cesi
 */
@Stateful
public class WordService implements WordServiceLocal {
    
    private Word wordORM = new Word();
    
    @Inject
    WordDAO wordDAO;

    @Override
    public void addWord(String word) {
        System.out.println(word);
        wordORM.setWord(word);
        save();
    }

    @Override
    public void findWords(String pattern) {
        System.out.println("pattern" + pattern);
    }

    @Override
    @Remove
    public void save() {
        wordDAO.insert(wordORM);
    }



}
