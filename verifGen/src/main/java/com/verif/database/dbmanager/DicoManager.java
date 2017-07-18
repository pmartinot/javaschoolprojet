/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verif.database.dbmanager;

import com.verif.database.persistence.Mot;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.*;
/**
 *
 * @author pierre
 */

@Named(value="DicoManager")
@Stateless(name="BookManager")
public class DicoManager {
    
    @PersistenceContext(unitName="abCD")
    EntityManager em;
    
    
    public Mot createMot(Mot mot){      
       em.persist(mot);
       return mot; 
    }
    
    public List<Mot> findAll(){
        String q= "SELECT mot From dico";
        TypedQuery<Mot> query = em.createQuery(q,Mot.class);
        List<Mot> mots = query.getResultList();
        return mots;
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS) //méthode pouvant joindre le contexte transactionnel de l'appelant
    public List<Mot> findByCriteria(String pattern) {
        pattern="%"+pattern+"%";//pour retrouver les livres qui contiennent le motif dans leur titre
        String q= "SELECT mot From dico where mot LIKE :pattern";
        TypedQuery<Mot> query = em.createQuery(q,Mot.class);
        query.setParameter("pattern", pattern);
        List<Mot> mots = query.getResultList();
        return mots;
    }
    
}
