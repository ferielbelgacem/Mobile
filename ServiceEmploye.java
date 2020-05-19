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
import com.mycompany.myapp.entities.Employe;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ferie
 */
public class ServiceEmploye {
     public ArrayList<Employe> cnt;
    
    public static ServiceEmploye instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceEmploye() {
         req = new ConnectionRequest();
    }

    public static ServiceEmploye getInstance() {
        if (instance == null) {
            instance = new ServiceEmploye();
        }
        return instance;
    }

     public boolean ModifierTask(Employe t ) {
                         String url = Statics.BASE_URL + "rhh/employe/edit?id=" +t.getId()+"&nom=" + t.getNom_condidat() + "&prenom="+t.getPrenom_condidat()+ "&age=" + t.getAge()+"&role=" +t.getRole()+"&nbrHeure=" +t.getNbr_heure()+"&nbrConge=" +t.getNbr_conge()+"&prime=" +t.getPrime()+"&salaire=" +t.getSalaire() ;

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
  
    
    
     public boolean supprimerTask(int id ) {
         
        String url = Statics.BASE_URL + "rhh/employe/delete?id=" + id  ;
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
    public boolean addTask(Employe t) {
        String url = Statics.BASE_URL + "rhh/employe/new?id=" +t.getId()+"&nom=" + t.getNom_condidat() + "&prenom="+t.getPrenom_condidat()+ "&age=" + t.getAge()+"&role=" +t.getRole()+"&nbrHeure=" +t.getNbr_heure()+"&nbrConge=" +t.getNbr_conge()+"&prime=" +t.getPrime()+"&salaire=" +t.getSalaire() ;
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

    public ArrayList<Employe> parseTasks(String jsonText){
        try {
            cnt=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Employe t = new Employe();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setAge(((int)Float.parseFloat(obj.get("age").toString())));
                                 t.setRole(obj.get("role").toString());

              t.setNbr_heure(((int)Float.parseFloat(obj.get("nbrHeure").toString())));
                    t.setPrime(((int)Float.parseFloat(obj.get("prime").toString())));
 t.setSalaire(((int)Float.parseFloat(obj.get("salaire").toString())));
   t.setNom_condidat(obj.get("nom").toString());
                t.setPrenom_condidat(obj.get("prenom").toString());
               
                  // t.setUser(((int)Float.parseFloat(obj.get("user").toString())));
                         
               
                t.setNbr_conge(((int)Float.parseFloat(obj.get("nbrConge").toString())));

           

                cnt.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return cnt;
    }
    
    public ArrayList<Employe> getAllTasks(){
        String url = Statics.BASE_URL+"rhh/employe/all";
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
