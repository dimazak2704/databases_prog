import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import javax.swing.*;


public class MyJDBC {


    public static void filecreate (){
        File file = new File("file.txt");
        boolean result;
        try {
            result = file.createNewFile();
            if(result){
                System.out.println("file created "+file.getCanonicalPath());
            }
            else{
                System.out.println("File already exist at location: "+file.getCanonicalPath());
            }
        } catch (IOException e) {throw new RuntimeException(e);}
    }

    static boolean coon = false;
    public static void setCoon(boolean con){coon=con;}
    public static boolean getcon(){return coon;}


    public static void main(String[] args) {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;


        JFrame frame = new JFrame("Database management");

        JLabel acc = new JLabel("ENTER YOUR ACCOUNT NAME");
        acc.setHorizontalAlignment(JLabel.CENTER);
        acc.setBounds(300, 20, 400, 100);
        Font font = new Font("Verdana", Font.PLAIN, 20);
        acc.setFont(font);

        JTextField accText = new JTextField();
        accText.setHorizontalAlignment(JLabel.CENTER);
        accText.setBounds(350, 100, 300, 50);
        accText.setFont(font);


        JLabel pass = new JLabel("ENTER YOUR PASSWORD");
        pass.setHorizontalAlignment(JLabel.CENTER);
        pass.setBounds(300, 150, 400, 100);
        pass.setFont(font);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setHorizontalAlignment(JLabel.CENTER);
        passwordField.setBounds(350, 230, 300, 50);
        passwordField.setFont(font);


        JLabel db = new JLabel("ENTER YOUR DATABASE");
        db.setHorizontalAlignment(JLabel.CENTER);
        db.setBounds(300, 280, 400, 100);
        db.setFont(font);

        JTextField database = new JTextField();
        database.setHorizontalAlignment(JLabel.CENTER);
        database.setBounds(350, 360, 300, 50);
        database.setFont(font);


        JButton confirm = new JButton("CONFIRM");
        confirm.setBounds(300,500,400,150);
        confirm.setFont(font);

        JCheckBox remember = new JCheckBox("Remember me on this pc");
        remember.setHorizontalAlignment(JCheckBox.CENTER);
        remember.setBounds(400, 650, 200,50);


        frame.add(acc);frame.add(accText);frame.add(pass);frame.add(passwordField);frame.add(db);frame.add(database);frame.add(confirm);frame.add(remember);
        frame.setBounds(width/2-500, height/2-375, 1000,750);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (remember.isSelected()==true){
                    filecreate();
                }
                System.out.println(accText.getText());
                System.out.println(database.getText());
                System.out.println(passwordField.getPassword());

                try {
                    jdbc jdbc = new jdbc(database.getText(), accText.getText(), String.valueOf(passwordField.getPassword()));
                    setCoon(true);

                    acc.setVisible(false);
                    accText.setVisible(false);
                    pass.setVisible(false);
                    passwordField.setVisible(false);
                    database.setVisible(false);
                    db.setVisible(false);
                    remember.setVisible(false);
                    confirm.setVisible(false);

                    System.out.println(getcon());

                }
                catch (SQLException exception){
                    System.out.println("connection error");
                    JDialog err = new JDialog(frame, "error");
                    JLabel erText = new JLabel("connection error, try again!");
                    err.add(erText);
                    err.setBounds(width/2-100, height/2-50, 200,100);
                    err.setVisible(true);
                }

                    try {
                        FileWriter fileWriter = new FileWriter("file.txt");
                        fileWriter.write("database:"+ database.getText());
                        fileWriter.write("\naccount:"+ accText.getText());
                        fileWriter.write("\npassword:"+ String.valueOf(passwordField.getPassword()));
                        fileWriter.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }



            }
        });

        while(getcon()!=true){

        }
        if(getcon()==true){
            swing.next(frame);
        }





    }

}
