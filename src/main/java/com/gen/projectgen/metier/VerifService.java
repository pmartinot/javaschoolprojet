/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.projectgen.metier;

import com.gen.projectgen.model.Verif;
import java.io.StringWriter;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
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
public class VerifService implements VerifServiceLocal {

    @Override
    public void verifDecrypted(Verif verif) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
    @Inject //paquetage javax.inject
    private JMSContext jmscontext; //paquetage javax.jms

    @Resource(lookup = "jms/paymentQueue") //paquetage javax.annotation
    private Queue paymentQueue; //paquetage javax.jms

    @Override
    public void verifDecrypted(Verif verif) {

        System.out.println("allllleeeez");
        System.out.println(verif.getKey());
    }
    
    
    private void sendVerif(Verif verif){
    //utilisation de l'API JAX-B de gestion de flux pour marshaller (transformer) l'objet
   //Payment en chaine XML
        JAXBContext jaxbContext;
        try {
        //obtention d'une instance JAXBContext associée au type Payment annoté avec JAX-B
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
         TextMessage msg = jmscontext.createTextMessage(xmlMessage);

         //envoi du message dans la queue paymentQueue
         jmscontext.createProducer().send(paymentQueue, msg);

        } catch (JAXBException ex) {
            System.out.println("a");
        }
    }

*/

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
