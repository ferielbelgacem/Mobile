/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Candidat;
import com.mycompany.myapp.services.ServiceCandidat;

/**
 *
 * @author bhk
 */
public class HomeCandidatForm extends Form{
Form current;
           private Resources theme;

    public HomeCandidatForm() {
    
        
        

        current=this;
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAddTask = new Button("S'incsrire");
        Button btnListTasks = new Button("Afficher les candidatures");
        Button btnSupprimer= new Button("Supprimer une candidature");
                Button btnmodifier= new Button("modifier");
               Button btnchart= new Button("graph");



   theme = UIManager.initFirstTheme("/theme");
            //Image im = theme.getImage("im age.jpg");
            //ImageViewer img = new ImageViewer(im);
            Image im2 = theme.getImage("logo.png");
            ImageViewer img2 = new ImageViewer(im2);

        btnAddTask.addActionListener(e-> new AddCandidatForm(current).show());
        btnListTasks.addActionListener(e-> new ListCandidatForm(current).show());
       btnSupprimer.addActionListener(e-> new SupprimerCandidat(current).show());
      btnmodifier.addActionListener(e-> new ModifierForm(current).show());


        addAll(img2,btnAddTask,btnListTasks,btnSupprimer,btnmodifier,btnchart);
        
        
    }
   
}
