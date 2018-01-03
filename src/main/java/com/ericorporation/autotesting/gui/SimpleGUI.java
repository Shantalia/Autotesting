package com.ericorporation.autotesting.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SimpleGUI extends JFrame {
    private JButton buttonGoTests = new JButton("GO TESTS");
    //private JTextField input = new JTextField("", 5);
    private JLabel labelSelectSite = new JLabel("Select the site to testing:");
    private JLabel labelSelectForm = new JLabel("Select the form to testing:");
    private JRadioButton radioButtonEn = new JRadioButton("EN ERI Corporation");
    private JRadioButton radioButtonRu = new JRadioButton("RU ERI Corporation");
    private JRadioButton radioButtonIt = new JRadioButton("IT ERI Corporation");
    private JRadioButton radioButtonDe = new JRadioButton("DE ERI Corporation");
    private JCheckBox checkBoxSignIn = new JCheckBox("Sign In form", true);
    private JCheckBox checkBoxChangePass = new JCheckBox("Change password form", false);

    public SimpleGUI() {
        super("ERI TESTS");
        this.setBounds(400,100,500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5,2,1,2));
        container.add(labelSelectSite);
        container.add(labelSelectForm);
        //container.add(input);

//        ButtonGroup group = new ButtonGroup();
//        container.add(radioButtonEn);
//        radioButtonEn.setSelected(true);
//        group.add(radioButtonRu);
//        group.add(radioButtonIt);
//        group.add(radioButtonDe);

        container.add(radioButtonEn);
        container.add(checkBoxSignIn);
        container.add(radioButtonRu);
        container.add(checkBoxChangePass);
        container.add(radioButtonIt);
        //container.add();
        container.add(radioButtonDe);


        buttonGoTests.addActionListener(new ButtonEventListener());
        add(buttonGoTests);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += "Button was pressed\n";
            //message += "Text is " + input.getText() + "\n";
            message += (radioButtonEn.isSelected()?"Radio #1":"Radio #2")
                    + " is selected\n";
            message += "CheckBox is " + ((checkBoxSignIn.isSelected())
                    ?"checked":"unchecked");
            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SimpleGUI app = new SimpleGUI();
        app.setVisible(true);
    }
}
