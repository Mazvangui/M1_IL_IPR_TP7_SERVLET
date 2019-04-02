package fr.istic.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;
import javax.xml.bind.JAXBElement;

import fr.istic.chat.message.Message;
import fr.istic.chat.message.MessageList;

@Path("/messages")
public class MessageResource
{

  //En partant du principe que l'annotation Path sur la classe contient "messages"
    @Path("/after/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Message> getMessagesAfter(@PathParam("id") Long id){
      System.out.println("message after" + id);
      return MessageList.getInstance().getMessagesAfter(id);
    }
    
  //En partant du principe que l'annotation Path sur la classe contient "messages"
    @Path("")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Message> getMessages(){
      System.out.println("All messages");
      return MessageList.getInstance().getMessages();
    }
    
  //En partant du principe que l'annotation Path sur la classe contient "messages"
    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Message getMessage(@PathParam("id") Long id){
      System.out.println("All messages");
      return MessageList.getInstance().getMessage(id);
    }
    
    //En partant du principe que l'annotation Path sur la classe contient "messages"
    /* @POST
   @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Message createMessage(QName name){
    	Class<Message> declaredType = null;
		Message value = null;
		JAXBElement<Message> JAXBmessage = new JAXBElement<Message>(name, declaredType, value);
    	return MessageList.getInstance().createMessage(JAXBmessage.getValue());
      
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
    */
}