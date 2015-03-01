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
    public static String CreateNode(String type, String node)throws URISyntaxException{
     URI fromUri = new URI( "http://23.97.213.185:7474/db/data/transaction/commit" );
     
     WebResource resource = Client.create()
                .resource( fromUri );
     
   
     
        String cypher = "{\n"
                + "  \"statements\" : [ {\n"
                + "    \"statement\" : \"CREATE (n {props}) RETURN n\",\n"
                + "    \"parameters\" : {\n"
                + "      \"props\" : {\n"
                + "        \"name\" : \""+node+"\"\n"
                + "      }\n"
                + "    }\n"
                + "  } ]\n"
                + "}";
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
     public static String GetType(String type) throws URISyntaxException{
     URI fromUri = new URI( "http://23.97.213.185:7474/db/data/cypher" );
  
        WebResource resource = Client.create()
                .resource(fromUri);
        String cypher = "{\n"
                + "  \"query\" : \"MATCH (n:" + type + ") RETURN n.name \",\n"
                + "  \"params\" : {\n"
                + "  }\n"
                + "}";

        // POST JSON to the relationships URI
        ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json;charset=UTF-8")
                .type(MediaType.APPLICATION_JSON)
                .entity(cypher)
                .post(ClientResponse.class);
        String fileContent = response.getEntity(String.class);
        System.out.println(fileContent);
        response.close();
        return fileContent;
    }

    public static String GetTypeConnection(String first, String second) throws URISyntaxException {
        URI fromUri = new URI("http://23.97.213.185:7474/db/data/cypher");

        WebResource resource = Client.create()
                .resource(fromUri);
        String cypher = "{\n"
                + "  \"query\" : \" MATCH ({ name:'" + first + "' })-->(" + second + ") RETURN " + second + ".name  \",\n"
                + "  \"params\" : {\n"
                + "  }\n"
                + "}";

        System.out.println(cypher);
        // POST JSON to the relationships URI
        ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
                 .header("Content-Type", "application/json;charset=UTF-8")
                .type(MediaType.APPLICATION_JSON)
                .entity(cypher)
                .post(ClientResponse.class);
        System.out.println(response.toString());
        String fileContent = response.getEntity(String.class);
        System.out.println(fileContent);

        response.close();
        return fileContent;
    }
   public static String Getall() throws URISyntaxException
   {
       URI fromUri = new URI( "http://23.97.213.185:7474/db/data/cypher" );
  
        WebResource resource = Client.create()
                .resource(fromUri);
        String cypher = "{\n"
                + "  \"query\" : \"Match a return a.name \",\n"
                + "  \"params\" : {\n"
                + "  }\n"
                + "}";

        // POST JSON to the relationships URI
        ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json;charset=UTF-8")
                .type(MediaType.APPLICATION_JSON)
                .entity(cypher)
                .post(ClientResponse.class);
        String fileContent = response.getEntity(String.class);
        System.out.println(fileContent);
        response.close();
        return fileContent;
       
   }
   public static  String GetallLabels() throws URISyntaxException
           {
              URI fromUri = new URI( "http://23.97.213.185:7474/db/data/cypher" );
  
        WebResource resource = Client.create()
                .resource(fromUri);
        String cypher = "{\n"
                + "  \"query\" : \"Match a return distinct labels(a) \",\n"
                + "  \"params\" : {\n"
                + "  }\n"
                + "}";

        // POST JSON to the relationships URI
        ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json;charset=UTF-8")
                .type(MediaType.APPLICATION_JSON)
                .entity(cypher)
                .post(ClientResponse.class);
        String fileContent = response.getEntity(String.class);
        System.out.println(fileContent);
        response.close();
        return fileContent;  
           }
   public static String GetConIns(String cla,String ins) throws URISyntaxException
          
   {
        URI fromUri = new URI("http://23.97.213.185:7474/db/data/cypher");

        WebResource resource = Client.create()
                .resource(fromUri);
        String cypher = "{\n"
                + "  \"query\" : \" MATCH (n:"+cla+")-->(m{name:'"+ins+"'}) RETURN n.name  \",\n"
                + "  \"params\" : {\n"
                + "  }\n"
                + "}";

        System.out.println(cypher);
        // POST JSON to the relationships URI
        ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
                 .header("Content-Type", "application/json;charset=UTF-8")
                .type(MediaType.APPLICATION_JSON)
                .entity(cypher)
                .post(ClientResponse.class);
        System.out.println(response.toString());
        String fileContent = response.getEntity(String.class);
        System.out.println(fileContent);

        response.close();
        return fileContent;
   }
   
   
    public static String GetInConnIn(String ins1, String cla,String ins2) throws URISyntaxException {
       URI fromUri = new URI("http://23.97.213.185:7474/db/data/cypher");

        WebResource resource = Client.create()
                .resource(fromUri);
        String cypher = "{\n"
                + "  \"query\" : \" MATCH ({name:'"+ins2+"'})--(n:"+cla+")--({name:'"+ins1+"'}) RETURN distinct n.name  \",\n"
                + "  \"params\" : {\n"
                + "  }\n"
                + "}";

        System.out.println(cypher);
        // POST JSON to the relationships URI
        ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
                 .header("Content-Type", "application/json;charset=UTF-8")
                .type(MediaType.APPLICATION_JSON)
                .entity(cypher)
                .post(ClientResponse.class);
        System.out.println(response.toString());
        String fileContent = response.getEntity(String.class);
        System.out.println(fileContent);

        response.close();
        return fileContent;
    }

    public static String GetInClaInCla(String ins1, String cla, String ins2, String mClass) throws URISyntaxException {
       URI fromUri = new URI("http://23.97.213.185:7474/db/data/cypher");

        WebResource resource = Client.create()
                .resource(fromUri);
        String cypher = "{\n"
                + "  \"query\" : \" MATCH ({name:'"+ins2+"'})--(n:"+cla+")--({name:'"+ins1+"'}) OPTIONAL Match (n)--(m:"+mClass+") RETURN distinct n.name,m.name  \",\n"
                + "  \"params\" : {\n"
                + "  }\n"
                + "}";

        System.out.println(cypher);
        // POST JSON to the relationships URI
        ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
                 .header("Content-Type", "application/json;charset=UTF-8")
                .type(MediaType.APPLICATION_JSON)
                .entity(cypher)
                .post(ClientResponse.class);
        System.out.println(response.toString());
        String fileContent = response.getEntity(String.class);
        System.out.println(fileContent);

        response.close();
        return fileContent;
    }

    public static String GetInClaInIn(String ins1, String cla, String ins2, String mInstance) throws URISyntaxException {
         URI fromUri = new URI("http://23.97.213.185:7474/db/data/cypher");

        WebResource resource = Client.create()
                .resource(fromUri);
        String cypher = "{\n"
                + "  \"query\" : \" MATCH ({name:'"+ins2+"'})--(n:"+cla+")--({name:'"+ins1+"'}) OPTIONAL Match (n)--(m{name:'"+mInstance+"'}) RETURN distinct n.name,m.name  \",\n"
                + "  \"params\" : {\n"
                + "  }\n"
                + "}";

        System.out.println(cypher);
        // POST JSON to the relationships URI
        ClientResponse response = resource.accept(MediaType.APPLICATION_JSON)
                 .header("Content-Type", "application/json;charset=UTF-8")
                .type(MediaType.APPLICATION_JSON)
                .entity(cypher)
                .post(ClientResponse.class);
        System.out.println(response.toString());
        String fileContent = response.getEntity(String.class);
        System.out.println(fileContent);

        response.close();
        return fileContent;
    }
}
