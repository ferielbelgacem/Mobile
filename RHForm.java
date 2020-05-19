/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author ferie
 */
public class RHForm extends Form{
        private Form current;

    public RHForm(Form previous){
      
            current = this;
            setTitle("Acceuil");
            setLayout(BoxLayout.y());

        add(new Label("Bienvenue"));
        Button btnc = new Button("Candidat");
        Button btne = new Button("Employés");
        btnc.addActionListener(e -> new Gotocandidat(current).show());
        addAll(btnc, btne);
       }
}
    
    

