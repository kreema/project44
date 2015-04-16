import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Login1 extends JFrame {

    private JPanel panel = new JPanel();
    private JLabel lblUserName = new JLabel("User Name:", JLabel.RIGHT);
    private JLabel lblPwd = new JLabel("Password:", JLabel.RIGHT);
    private JTextField txtUserName = new JTextField(20);
    private JPasswordField txtPwd = new JPasswordField(20);
    private JButton btnCancel = new JButton("Cancel");
    private JButton btnLogin = new JButton("Login");
    private final int WINDOW_WIDTH = 750;
    private final int WINDOW_HEIGHT = 200;

    public Login1() {
        setup();
        manageLayout();
        setEscToClose();
        setVisible(true);
    }

    private void manageLayout() {

        GridLayout gridLayout = new GridLayout(0,4);
        panel.setLayout(gridLayout);
        panel.add(new JLabel(""));
        panel.add(lblUserName);
        panel.add(txtUserName);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(lblPwd);
        panel.add(txtPwd);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(btnCancel);
        panel.add(btnLogin);
        panel.add(new JLabel(""));
        add(panel);
    }

    private void setup() {
        setTitle("Login");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(true);
        // Center the window on the screen
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Setup listeners for the two buttons
        btnCancel.addActionListener(new btnCancelListener());
        btnLogin.addActionListener(new btnLoginListener());
        // Put the initial focus on the UserName field
        txtUserName.requestFocus();
        // Make the Login button the default if the enter key is pressed
        getRootPane().setDefaultButton(btnLogin);

    }

    private void setEscToClose() {
        KeyStroke escKey = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                Login1.this.dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escKey,"ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
    }

    private class btnCancelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // do something in response to cancel clicked
            JOptionPane.showMessageDialog(Login1.this, "Cancel clicked");
            Login1.this.dispose();
        }

    }

    private class btnLoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // do something in response to login clicked
            JOptionPane.showMessageDialog(null, "UserName=" + txtUserName.getText() + "\n" +
                    "Password=" + new String(txtPwd.getPassword()));
        }
    }

    public static void main(String[] args) {
        new Login1();
    }

}
