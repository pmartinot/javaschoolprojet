/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.projectgen.metier;

import javax.ejb.Local;

/**
 *
 * @author cesi
 */
@Local
public interface WordServiceLocal {
    
    public void addWord(String word);
    
    public void findWords(String pattern);
    
    public void save(); 
    
}
