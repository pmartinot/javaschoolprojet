/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.projectgen.metier;

import com.gen.projectgen.persistance.Word;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cesi
 */
@Local
public interface WordServiceLocal {
    
    public void addWord(String word);
    
    public List<Word> findWords(String pattern);
    
    public void save(); 
    
}
