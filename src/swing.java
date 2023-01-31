import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class swing {
    static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static int width = screenSize.width;
    static int height = screenSize.height;
    static Font font = new Font("Verdana", Font.PLAIN, 40);

    //public static String db="test", acc="root",pass="passWord2704";
    public static String db, test, acc;
    static jdbc jdbc;

    /*static {
        try {
            jdbc = new jdbc(db,acc,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/


    public static void next(JFrame frame){

        JButton create = new JButton("CREATE");
        create.setBounds(0,0,250,750);
        create.setHorizontalAlignment(JButton.CENTER);
        create.setHorizontalAlignment(JButton.CENTER);
        create.setFont(font);


        JButton read = new JButton("READ");
        read.setBounds(250,0,250,750);
        read.setHorizontalAlignment(JButton.CENTER);
        read.setHorizontalAlignment(JButton.CENTER);
        read.setFont(font);

        JButton update = new JButton("UPDATE");
        update.setBounds(500,0,250,750);
        update.setHorizontalAlignment(JButton.CENTER);
        update.setHorizontalAlignment(JButton.CENTER);
        update.setFont(font);

        JButton delete = new JButton("DELETE");
        delete.setBounds(750,0,250,750);
        delete.setHorizontalAlignment(JButton.CENTER);
        delete.setHorizontalAlignment(JButton.CENTER);
        delete.setFont(font);


        frame.add(create); frame.add(read);frame.add(update);frame.add(delete);
        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    jdbc.create("prog");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                create.setVisible(false);
                read.setVisible(false);
                update.setVisible(false);
                delete.setVisible(false);
                JComboBox comboBox = new JComboBox();
                comboBox.addItem("table");
                comboBox.addItem("coloumn");
                comboBox.setBounds(200,200,100,100);
                frame.add(comboBox);
                try {
                    jdbc.delete("table", "prog");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }






    public static void main(String[] args) {
        JFrame frame = new JFrame("Database management");
        frame.setBounds(width/2-500, height/2-375, 1000,750);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        next(frame);

    }
}
