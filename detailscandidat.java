/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.gui;

import com.codename1.charts.util.ColorUtil;
import com.codename1.components.ImageViewer;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Candidat;
import com.mycompany.myapp.services.ServiceCandidat;

/**
 *
 * @author ferie
 */
public class detailscandidat extends Form {
        Form current;
    private  Resources theme;

    public detailscandidat(Candidat c){
        Form p = null;
         
        theme = UIManager.initFirstTheme("/theme");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = theme.getImage("unnamed.png");
          
            ImageViewer img2 = new ImageViewer(im2);
                         Label prenom = new Label();
                         Label nom = new Label();
                         Label cin = new Label();
                         Label experience = new Label();
                         Label age = new Label();
     TextField tfnom= new TextField("","nom");
          tfnom.getAllStyles().setBgColor(ColorUtil.CYAN);

     TextField tfprenom= new TextField("","prenom");
          tfprenom.getAllStyles().setBgColor(ColorUtil.CYAN);

     TextField tfage= new TextField("","age");
          tfage.getAllStyles().setBgColor(ColorUtil.CYAN);

     TextField tfexp= new TextField("","experienceCondidat");
          tfexp.getAllStyles().setBgColor(ColorUtil.CYAN);

     TextField tfcin= new TextField("","cin");
     tfcin.getAllStyles().setBgColor(ColorUtil.CYAN);
                prenom.setText(c.getPrenom_Candidat());
                         nom.setText(c.getNom_Candidat());
                         age.setText(String.valueOf(c.getAge_Candidat()));
                         cin.setText(String.valueOf(c.getCin_Candidat()));
                         experience.setText(c.getExperience_Candidat());

                           Button btsup = new Button("supprimer",getInlineUnselectedStyles());
                           Button btmod = new Button("modifier",getInlinePressedStyles());
           btsup.addActionListener((evt) -> {
                                try {
                                    
                             if( ServiceCandidat.getInstance().supprimerTask(c.getCin_Candidat()))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                            else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                             } catch (NumberFormatException ex) {
                                 Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                            }
                                                               new ListCandidatForm(current).show();

                           });
                         Button btnValider = new Button("valider");

     btmod.addActionListener((evt) -> {
tfprenom.setText(c.getPrenom_Candidat());
                         tfnom.setText(c.getNom_Candidat());
                         tfage.setText(String.valueOf(c.getAge_Candidat()));
                         tfexp.setText(c.getExperience_Candidat());
                         tfcin.setText(String.valueOf(c.getCin_Candidat()));
                         
                                 addAll(tfcin,tfage,tfnom,tfprenom,tfexp,btnValider);
                                refreshTheme();
                            });
                            
                           btnValider.addActionListener(new ActionListener() {
                                @Override
                                 public void actionPerformed(ActionEvent evt) {
                if ((tfnom.getText().length()==0)||(tfprenom.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                      try {
                                                  Candidat t = new Candidat(Integer.parseInt(tfcin.getText()), tfprenom.getText(),tfnom.getText(),Integer.parseInt(tfage.getText()),tfexp.getText());

                        if( ServiceCandidat.getInstance().ModifierTask(t))
                            Dialog.show("Succès","Votre candidature a été modifiée",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                    
                }
                
                 new ListCandidatForm(current).show();
            }
                   
                           });
                         this.addAll(img2,nom,prenom,age,cin,experience,btsup,btmod);



  }
    
    
    }
    

