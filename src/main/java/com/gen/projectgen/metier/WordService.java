/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.projectgen.metier;

import com.gen.projectgen.integration.WordDAO;
import com.gen.projectgen.model.Verif;
import com.gen.projectgen.persistance.Word;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**
 *
 * @author cesi
 */
@Stateful
public class WordService implements WordServiceLocal {
    
    private Word wordORM = new Word();
    
    @Inject
    WordDAO wordDAO;
    
    
    @Inject //paquetage javax.inject
    private JMSContext context; //paquetage javax.jms

    @Resource(lookup = "jms/verifQueue") //paquetage javax.annotation
    private Queue verifQueue; //paquetage javax.jms

    @Override
    public void addWord(String word) {
        System.out.println(word);
        wordORM.setWord(word);
        Verif test = new Verif();
        test.setDecryptedData("aaaa");
        //sendVerif(test);
        save();
    }

    @Override
    public List<Word> findWords(String pattern) {
        System.out.println("pattern" + pattern);
        return wordDAO.findByCriteria(pattern);   
    }

    @Override
    @Remove
    public void save() {
        wordDAO.insert(wordORM);
    }
    
    
    
    
    private void sendVerif(Verif verif){
        //utilisation de l'API JAX-B de gestion de flux pour marshaller (transformer) l'objet
       //Payment en chaine XML
        JAXBContext jaxbContext;
        try {
        jaxbContext = JAXBContext.newInstance(Verif.class);
        //création d'un Marshaller pour transfomer l'objet Java en flux XML
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        StringWriter writer = new StringWriter();

        //transformation de l'objet en flux XML stocké dans un Writer
        jaxbMarshaller.marshal(verif, writer);
        String xmlMessage = writer.toString();
        //affichage du XML dans la console de sortie
        System.out.println(xmlMessage);
        
        //encapsulation du paiement au format XML dans un objet javax.jms.TextMessage
        TextMessage msg = context.createTextMessage(xmlMessage);

        //envoi du message dans la queue paymentQueue
        context.createProducer().send(verifQueue, msg);

 
        } catch (JAXBException ex) {
            System.out.println(ex);
            System.out.println("Oulah un erreur");
        }
    }


}
