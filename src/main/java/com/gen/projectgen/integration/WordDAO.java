/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.projectgen.integration;

import com.gen.projectgen.persistance.Word;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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
    
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS) //méthode pouvant joindre le contexte transactionnel de l'appelant
    public List<Word> findByCriteria(String pattern) {
        pattern="%"+pattern+"%";//pour retrouver les livres qui contiennent le motif dans leur titre
        String q= "SELECT w FROM Word w WHERE w.word LIKE :pattern";
        TypedQuery<Word> query = em.createQuery(q,Word.class);
        query.setParameter("pattern", pattern);
        List<Word> mots = query.getResultList();
        return mots;
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
