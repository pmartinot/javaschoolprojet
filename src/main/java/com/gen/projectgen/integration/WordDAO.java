/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.projectgen.integration;

import com.gen.projectgen.persistance.Word;
import javax.ejb.Stateless;
import javax.persistence.*;


/**
 *
 * @author cesi
 */
@Stateless
public class WordDAO {
    
    @PersistenceContext(unitName = "genPr")
    private EntityManager em;

    
    public void insert(Word word){
        em.persist(word);
    } 
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
