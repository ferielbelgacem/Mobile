/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Candidat;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author bhk
 */
public class ServiceCandidat {

    public ArrayList<Candidat> cnt;
    
    public static ServiceCandidat instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceCandidat() {
         req = new ConnectionRequest();
    }

    public static ServiceCandidat getInstance() {
        if (instance == null) {
            instance = new ServiceCandidat();
        }
        return instance;
    }

     public boolean ModifierTask(Candidat t ) {
                 String url = Statics.BASE_URL + "rhh/tasks/edit?cin=" + t.getCin_Candidat() + "&age="+t.getAge_Candidat()+ "&nom=" + t.getNom_Candidat()+"&prenom=" +t.getPrenom_Candidat()+"&experienceCondidat=" +t.getExperience_Candidat() ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
     public boolean RechercherTask() {
         Candidat t=new Candidat();
                 String url = Statics.BASE_URL + "find/cin=" +t.getCin_Candidat();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
    
     public boolean supprimerTask(int cin ) {
         
        String url = Statics.BASE_URL + "rhh/tasks/delete?cin=" + cin  ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    public boolean addTask(Candidat t) {
        String url = Statics.BASE_URL + "rhh/tasks/neww?cin=" + t.getCin_Candidat() + "&age="+t.getAge_Candidat()+ "&nom=" + t.getNom_Candidat()+"&prenom=" +t.getPrenom_Candidat()+"&experienceCondidat=" +t.getExperience_Candidat() ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Candidat> parseTasks(String jsonText){
        try {
            cnt=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Candidat t = new Candidat();
                float cin = Float.parseFloat(obj.get("cin").toString());
                t.setCin_Candidat((int)cin);
                t.setAge(((int)Float.parseFloat(obj.get("age").toString())));
                t.setNom_Candidat(obj.get("nom").toString());
                t.setPrenom_Candidat(obj.get("prenom").toString());
                t.setExperience_Candidat(obj.get("experienceCondidat").toString());
                

                cnt.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return cnt;
    }
    
    public ArrayList<Candidat> getAllTasks(){
        String url = Statics.BASE_URL+"rhh/tasks/alll";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cnt = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return cnt;
    }
    
     public ArrayList<Candidat> getAllTask(int cin){
           Candidat t=new Candidat();
                 String url = Statics.BASE_URL + "rhh/tasks/find/cin=" +cin;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cnt = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return cnt;
    }
    
}
