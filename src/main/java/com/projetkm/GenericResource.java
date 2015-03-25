/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projetkm;

import dataRepo.RepoData;
import java.net.URISyntaxException;
import java.util.Calendar;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * REST Web Service
 *
 * @author chaaben mohamed
 */
@Path("")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of tweets.GenericResource
     *
     * @return an instance of java.lang.String
     * @throws java.net.URISyntaxException
     *
     */
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")

    public String Getall() throws URISyntaxException {

        return RepoData.Getall();
    }

    @GET
    @Path("allLables")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")

    public String GetallLables() throws URISyntaxException {

        return RepoData.GetallLabels();
    }

    @GET
    @Path("{type}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")

    public String GetByType(@PathParam("type") String type) throws URISyntaxException {

        return RepoData.GetType(type);
    }

    @GET
    @Path("{type}/connections")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")

    public String GetElementConnection(@PathParam("type") String type) throws URISyntaxException {

        return RepoData.GetElementConnection(type);
    }

    @GET
    @Path("{class}/{instance}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String GetByTypeConnection(@PathParam("class") String cla, @PathParam("instance") String ins) throws URISyntaxException {

        return RepoData.GetConIns(cla, ins);
    }

    @GET
    @Path("{instance1}/{class}/{instance2}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public String GetByTypeConnectionTwoInst(@Context UriInfo uriInfo, @PathParam("class") String cla, @PathParam("instance1") String ins1, @PathParam("instance2") String ins2) throws URISyntaxException {
        String mInstance, mClass = "";
        mInstance = uriInfo.getQueryParameters().getFirst("I");
        mClass = uriInfo.getQueryParameters().getFirst("C");
        System.out.println(mInstance);
        if (mInstance == null && mClass == null) {
            return RepoData.GetInConnIn(ins1, cla, ins2);
        } else if (mInstance == null) {
            return RepoData.GetInClaInCla(ins1, cla, ins2, mClass);
        } else if (mClass == null) {
            return RepoData.GetInClaInIn(ins1, cla, ins2, mInstance);
        } else {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @GET
    @Path("chef de/definition")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")

    public String chef(@PathParam("type") String type) throws URISyntaxException {

        return "jfjfjsqfjkjsmfjsdklgjsdlkjglksdgklsjgklsjdm";
    }

    @GET
    @Path("chef de projet/Définition")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")

    public String chef1(@PathParam("type") String type) throws URISyntaxException {

        return "{\"data\":\"Définit, met en oeuvre et conduit un projet SI depuis sa conception jusqu'à la réception dans le but d'obtenir un résultat optimal et conforme aux exigences formulées par le chef de projet MOA ou le client métier en ce qui concerne la qualité, les performances, le coût, le délai et la sécurité. \"}";
    }

    @GET
    @Path("chef de projet/Responsabilités")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")

    public String chef2(@PathParam("type") String type) throws URISyntaxException {

        return "{\"data\":\"Définit la conception technique et rédige les spécifications techniques détaillées, Participe au choix de progiciels, en relation avec le maître d’ouvrage Participe à la réalisation en termes de développements spécifiques ou d intégration Définit les tests et participe aux recettes \"}";

    }

    @GET
    @Path("chef de projet/EDF")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")

    public String chef3(@PathParam("type") String type) throws URISyntaxException {

        return "{\"data\":\"Dans le cadre de votre mission, vous pilotez des projets télécoms ou des lots télécoms sur des projets infrastructures métiers, de type déploiement, coordination et intégration, avec une obligation de performance globale et de respect des contraintes projets (coûts, délais, ressources).\"}";
    }

    @GET
    @Path("chef de projet/Mines Paris Tech")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")

    public String chef4(@PathParam("type") String type) throws URISyntaxException {

        return "{\"data\":\"MINES ParisTech forme depuis sa création en 1783 des ingénieurs de très haut niveau capables de résoudre des problèmes complexes dans des champs très variés\"}";
    }

    @GET
    @Path("Energie/Description")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")

    public String chef5(@PathParam("type") String type) throws URISyntaxException {

        return "{\"data\":\"L'énergie est définie en physique comme la capacité d'un système à produire un travail1, entraînant un mouvement ou produisant par exemple de la lumière, de la chaleur ou de l’électricité. C'est une grandeur physique qui caractérise l'état d'un système et qui est d'une manière globale conservée au cours des transformations. L'énergie s'exprime en joules (dans le système international d'unités) ou souvent en kilowatt-heure (kW•h ou kWh).\"}";
    }

    @GET
    @Path("administrateur outils/Définition")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")

    public String chef6(@PathParam("type") String type) throws URISyntaxException {

        return "{\"data\":\"Il installe, met en production, administre et exploite les moyens informatiques d’un ou plusieurs sites informatiques.Il participe au bon fonctionnement des systèmes d’information en garantissant le maintien à niveau des différents outils et/ou infrastructures des logiciels systèmes et/ou infrastructures de communication (locale, étendue, voix, image, architecture centralisée ou client-serveur), dans un objectif de qualité, de productivité et de sécurité. \"}";
    }
    @GET
    @Path("administrateur outils/Responsabilités")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")

    public String chef7(@PathParam("type") String type) throws URISyntaxException {

       return "{\"data\":\"Est responsable du fonctionnement optimal des outils, systèmes ou réseaux dont il a la charge.Met en oeuvre les outils garantissant la cohérence des données \"}";
    }
    @GET
    @Path("administrateur outils/EDF")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")

    public String chef8(@PathParam("type") String type) throws URISyntaxException {

         return "{\"data\":\"objectif de ce post est d'étudier la solution de gestion de ressource open source SLURM, afin évaluer la pertinence de sa mise en oeuvre sur les clusters de calcul de EDF, notamment pour ses fonctionnalités de gestion multi-clusters.\"}";
    }
    @GET
    @Path("chef de projet/Energie")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")

    public String chef9(@PathParam("type") String type) throws URISyntaxException {

        return "{\"data\":\"Le chef de projet élabore la proposition technique à remettre au client sur un projet d’installation"
                + " (centrale électrique, parc éolien, éclairage…)."
                + " Il en assure la responsabilité technique et commerciale, en conformité avec les exigences du contrat."
                + " Il recherche le meilleur compromis entre la satisfaction du client et le respect des objectifs et de la stratégie de l’entreprise.\"}";
    }

}

/* @GET
 @Path("{first}/{second}/{third}")
 @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
 public String GetElement(@PathParam("first") String first,
 @PathParam("second") String second,
 @PathParam("third") String third,
 @QueryParam("type") String type
 ) throws URISyntaxException {
 System.out.println(first);
        
 return RepoData.GetConnConnIn(first.replace("+", ""),second,third,type);
 }*/
