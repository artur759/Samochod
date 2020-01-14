import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formularz2 extends JDialog {
    private JPanel panel1;
    private JTextField nazwaFormularz2;
    private JButton usuńFormularz2;
    private GUI frame;

    public Formularz2(GUI f) {
        frame = f;
        setContentPane(panel1);
        pack();
        usuńFormularz2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                f.usunFormularz(nazwaFormularz2.getText());
            }
        });
    }
}
