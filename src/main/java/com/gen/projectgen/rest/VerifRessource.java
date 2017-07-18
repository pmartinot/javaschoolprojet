/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen.projectgen.rest;


import com.gen.projectgen.metier.VerifService;
import com.gen.projectgen.model.Verif;
import java.io.StringReader;
import java.io.StringWriter;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
/**
 * REST Web Service
 *
 * @author cesi
 */
@Path("verif")
@RequestScoped
public class VerifRessource {

    @Context 
    private UriInfo contextUriInfo;
    
    @Inject
    private JMSContext context; //paquetage javax.jms

    
    @Resource(lookup = "jms/verifQueue") //paquetage javax.annotation
    private Queue verifQueue; //paquetage javax.jms

    /**
     * Creates a new instance of VerifRessource
     */
    public VerifRessource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        
        String restMsg="{\"content\":\"Bonjour depuis mon superwebservice REST\"}";
        return restMsg; 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String recupDecrypted(String message) {
        
        String restMsg="";
        Verif verif = new Verif();
        StringReader reader = new StringReader(message);
        restMsg="{\"content\":\"JMS prend bien le relais\"}";
        

        //on essaye de transformer le string du corps du message en JsonObject
        try (JsonReader jreader = Json.createReader(reader)) {
            System.out.println("Je recois un message dans REST");
            JsonObject jo = jreader.readObject();
            //on set l'objet verif à envoyer
            verif.setDecryptedData(jo.getString("text"));
            verif.setFileName(jo.getString("file"));
            verif.setKey(jo.getString("key"));
            sendVerif(verif);

        }catch(Exception e){
           System.out.println(e);
            restMsg="{\"content\":\"Erreur lors du traitement du message\"}";
        }       
      return restMsg;
    }

    
    private void sendVerif(Verif verif){
        
        //on utilise JAXB pour transformer les objets en XML
        JAXBContext jaxbContext;
        try {
        //obtention d'une instance JAXBContext associée au type Verif
        jaxbContext = JAXBContext.newInstance(Verif.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        StringWriter writer = new StringWriter();
        //transformation de l'objet en flux XML stocké dans un Writer
        jaxbMarshaller.marshal(verif, writer);
        String xmlMessage = writer.toString();
        //creation du context car on inject pas le JMSContext
        //context = cf.createContext();
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
