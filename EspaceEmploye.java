/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Session;
import com.mycompany.myapp.entities.user;

/**
 *
 * @author ferie
 */
public class EspaceEmploye extends Form {
                   user User=Session.getCurrentSession();
                      private Form current;
           private Resources theme;

    public EspaceEmploye(Form previous){
          current = this; //Récupération de l'interface(Form) en cours
        setTitle("Espace Employés");
        setLayout(BoxLayout.y());
 Button btr = new Button("Se déconnecter");
              

           btr.addActionListener(e->{
           new Login(previous).show();
           });
 theme = UIManager.initFirstTheme("/theme");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = theme.getImage("logo.png");
            ImageViewer img2 = new ImageViewer(im2);
        add(new Label("Veuillez choisir une option"));
      final  Button btnAddTask = new Button("Ajouter un Employé");
        final Button btnListTasks = new Button("Afficher la liste des Employés");
        final Button btnsup = new Button("Supprimer un Employé ");
              final  Button btnmod = new Button("Consulter la liste des candidats");

   
       
btnListTasks.getAllStyles().setBorder(Border.createEmpty());
btnListTasks.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);
btnsup.getAllStyles().setBorder(Border.createEmpty());
btnsup.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);
btnmod.getAllStyles().setBorder(Border.createEmpty());
btnmod.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);
btnAddTask.getAllStyles().setBorder(Border.createEmpty());
btnAddTask.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);
        btnAddTask.addActionListener(e -> new AddEmployeForm(current).show());
        btnListTasks.addActionListener(e -> new ListEmploye(current).show());
                btnsup.addActionListener(e -> new SupprimerEmploye(current).show());
                                btnmod.addActionListener(e -> new ListCandidatForm(current).show());

btr.getAllStyles().setTextDecoration(Style.TEXT_DECORATION_3D_SHADOW_NORTH);
btr.getAllStyles().setBorder(Border.createEmpty());
        
        addAll(img2,btnAddTask, btnListTasks,btnmod,btr);
  try {
      
                Session.close();
            } catch (Exception ex) {
                ex.getMessage();
            }
    
}}
    
    
    
    
    
    

