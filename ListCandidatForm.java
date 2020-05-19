/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.TableModel;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Candidat;
import com.mycompany.myapp.services.ServiceCandidat;
import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public  class ListCandidatForm extends Form{
Form current;
    private  Resources theme;
    public ListCandidatForm(Form previous) {
   theme = UIManager.initFirstTheme("/theme");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = theme.getImage("unnamed.png");
              Button btr = new Button("",im2);
               add(btr);
                 btr.addActionListener(e->{
           new EspaceEmploye(previous).show();
           });
                   ImageViewer img2 = new ImageViewer(im2);

            Button btnc = new Button("Recherche");
                SpanLabel sp = new SpanLabel();
    TextField tfin=new TextField("cin","cin");
 
        setTitle("La liste des Candidats");
   ArrayList<Candidat> s;
        s=ServiceCandidat.getInstance().getAllTasks();
        for (int i=0; i < s.size();i++){
        Label l = new Label();    
      //  Candidat cc=new Candidat(s.get(i).getCin_Candidat());
        //  AutoCompleteTextField ac = new AutoCompleteTextField(String.valueOf(cc.getAge_Candidat()));
//ac.setMinimumElementsShownInPopup(1);
//add(ac);
                
           String  ch =   "cin:   "+s.get(i).getCin_Candidat()+" "+
                   "nom:  "+s.get(i).getNom_Candidat()+" "+
                                 "prenom:  "+s.get(i).getPrenom_Candidat()+" "+
                                        "age:   "+s.get(i).getAge_Candidat();
                               
                                //  "experienceCondidat:"+s.get(i).getExperience_Candidat();
                               
                            l.setText(ch);
                            
                            this.add(l);
                          
                            Candidat c =   new Candidat(s.get(i).getCin_Candidat(),s.get(i).getPrenom_Candidat(),s.get(i).getNom_Candidat(),s.get(i).getAge_Candidat(),s.get(i).getExperience_Candidat());
                        
                              l.addPointerReleasedListener(ke -> {
                     new detailscandidat(c).show();
                    
                              });
                              
        }
        
   

    }
    
    
}
