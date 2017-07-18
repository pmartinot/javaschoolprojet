/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verif.projectgen.service;

import javax.ejb.Stateful;
import com.verif.database.dbmanager.DicoManager;
import com.verif.database.persistence.Mot;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author cesi
 */
@Named
@Stateful
public class WordService implements WordServiceLocal {
    
    private Mot mot = new Mot();
    @Inject DicoManager dicoManager;

    @Override
    public void addWord(String mot) {
        this.mot.setMot(mot);
        dicoManager.createMot(this.mot);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void findWords(String pattern) {
        dicoManager.findByCriteria(pattern);
    }
}
