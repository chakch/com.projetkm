/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataRepo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author chaaben mohamed
 */
public class RepoData {
    
     public static String GetType(String type) throws URISyntaxException{
     URI fromUri = new URI( "http://23.97.213.185:7474/db/data/cypher" );
    

    WebResource resource = Client.create()
                .resource( fromUri );
    String cypher= "{\n" +
                    "  \"query\" : \"MATCH (n:"+type+") RETURN n.name \",\n" +
                    "  \"params\" : {\n" +  
                    "  }\n" +
                    "}";
  
    // POST JSON to the relationships URI
    ClientResponse response = resource.accept( MediaType.APPLICATION_JSON )
                                .type( MediaType.APPLICATION_JSON )
                                .entity(cypher)
                                .post( ClientResponse.class );
       String fileContent=response.getEntity(String.class);                    
       System.out.println(fileContent);
     response.close(); 
         return fileContent;
}
}
