/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Candidat;
import com.mycompany.myapp.entities.Employe;
import com.mycompany.myapp.services.ServiceEmploye;

import java.util.ArrayList;

/**
 *
 * @author ferie
 */
public class ListEmploye extends Form {
    Form current;
    private  Resources theme;

    public ListEmploye(Form p ) {
        
            Button btnc = new Button("Recherche");
                SpanLabel sp = new SpanLabel();
 theme = UIManager.initFirstTheme("/theme");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = theme.getImage("employe.png");
          
            ImageViewer img2 = new ImageViewer(im2);
           TextField tfin=new TextField("","id");
              Button btr = new Button("",im2);
               add(btr);

           btr.addActionListener(e->{
           new EspaceEmploye(p).show();
           });
           
        setTitle("La liste des Employés");
   ArrayList<Employe> s;
        s=ServiceEmploye.getInstance().getAllTasks();
        for (int i=0; i < s.size();i++){
        Label l = new Label(getName());                        
            String  ch = "nom :  "+s.get(i).getNom_condidat()+" "+
                                 " prenom :  "+s.get(i).getPrenom_condidat()+" "+
                                        " age:  "+s.get(i).getAge();

                             //    " role"+s.get(i).getRole()
                                 // " nbrHeure"+s.get(i).getNbr_heure()+
                                 // "salaire"+s.get(i).getSalaire()+
                                //  " prime"+s.get(i).getPrime()+
                     // " nbrConge"+s.get(i).getNbr_conge()+
                    // "nbrHeure"+s.get(i).getNbr_heure() ;
                            l.setText(ch);
                            this.add(l);
                            Employe e =   new Employe(s.get(i).getId(),s.get(i).getPrenom_condidat(),s.get(i).getNom_condidat(),s.get(i).getAge(),s.get(i).getRole(),s.get(i).getNbr_heure(),s.get(i).getNbr_conge(),s.get(i).getSalaire(),s.get(i).getPrime());
                              l.addPointerReleasedListener(ke -> {
                     new detailemploye(e).show();

                  });

        }
      

               
    }
    
    
    
    
    }
    
