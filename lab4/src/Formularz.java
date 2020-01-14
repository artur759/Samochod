import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formularz extends JDialog{
    private JPanel panel1;
    private JButton OK;
    private JButton Anuluj;
    private JTextField nazwa;
    private JTextField kolor;
    private JTextField nrrejestracji;
    private JTextField predkoscFormularz;
    private GUI frame;




    public Formularz(GUI e) {
        frame = e;
        setContentPane(panel1);
        pack();

        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
             e.dodajFormularz(nrrejestracji.getText(),nazwa.getText());
            }
        });
        Anuluj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);

            }
        });
    }

}
