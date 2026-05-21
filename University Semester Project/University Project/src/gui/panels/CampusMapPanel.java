
package gui.panels;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CampusMapPanel extends JFrame
{

    JPanel mainPanel;
    JPanel mapPanel;
    JPanel legendPanel;

    JLabel titleLabel;

    JButton csDeptBtn;
    JButton physicsLabBtn;
    JButton libraryBtn;

    JButton cafeteriaBtn;
    JButton classroomBtn;
    JButton healthCenterBtn;

    JButton transportBtn;
    JButton securityBtn;
    JButton hostelBtn;



    public CampusMapPanel()
    {

        setTitle("Smart Campus Map");

        setSize(800, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        mainPanel =
                new JPanel(
                        new BorderLayout()
                );



        titleLabel =new JLabel("Smart University Campus Map",JLabel.CENTER);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));

        titleLabel.setOpaque(true);

        titleLabel.setBackground(
                new Color(44, 62, 80)
        );

        titleLabel.setForeground(Color.WHITE);

        titleLabel.setPreferredSize(new Dimension(800, 60)
        );

        mainPanel.add(titleLabel,BorderLayout.NORTH);


        mapPanel =
                new JPanel(new GridLayout(3, 3, 15, 15));

        mapPanel.setBorder( BorderFactory.createEmptyBorder(
                        20,
                        20,
                        20,
                        20
                )
        );



      
        csDeptBtn =
                createLocationButton(
                        "Computer Science Dept",
                        "ACTIVE"
                );

        physicsLabBtn =
                createLocationButton(
                        "Physics Lab",
                        "ACTIVE"
                );

        libraryBtn =
                createLocationButton(
                        "Library",
                        "BUSY"
                );

        cafeteriaBtn =
                createLocationButton(
                        "Cafeteria",
                        "BUSY"
                );

        classroomBtn =
                createLocationButton(
                        "Main Classroom",
                        "ACTIVE"
                );

        healthCenterBtn =
                createLocationButton(
                        "Health Center",
                        "ACTIVE"
                );

        transportBtn =
                createLocationButton(
                        "Transport Office",
                        "CLOSED"
                );

        securityBtn =
                createLocationButton(
                        "Security Office",
                        "ACTIVE"
                );

        hostelBtn =
                createLocationButton(
                        "Hostel Block",
                        "BUSY"
                );


        mapPanel.add(csDeptBtn);

        mapPanel.add(physicsLabBtn);

        mapPanel.add(libraryBtn);

        mapPanel.add(cafeteriaBtn);

        mapPanel.add(classroomBtn);

        mapPanel.add(healthCenterBtn);

        mapPanel.add(transportBtn);

        mapPanel.add(securityBtn);

        mapPanel.add(hostelBtn);



        mainPanel.add(
                mapPanel,
                BorderLayout.CENTER
        );

        legendPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                20,
                                10
                        )
                );



        JLabel activeLabel =new JLabel("[ACTIVE]");

        activeLabel.setForeground(new Color(39, 174, 96));

        activeLabel.setFont(new Font("Arial", Font.BOLD, 13));


        JLabel busyLabel =
                new JLabel("[BUSY]");

        busyLabel.setForeground(
                new Color(243, 156, 18)
        );

        busyLabel.setFont(
                new Font("Arial", Font.BOLD, 13)
        );



        JLabel closedLabel =
                new JLabel("[CLOSED]");

        closedLabel.setForeground(
                new Color(192, 57, 43)
        );

        closedLabel.setFont(
                new Font("Arial", Font.BOLD, 13)
        );



        legendPanel.add(activeLabel);

        legendPanel.add(busyLabel);

        legendPanel.add(closedLabel);



        mainPanel.add(
                legendPanel,
                BorderLayout.SOUTH
        );



        add(mainPanel);


        setVisible(true);
    }


    private JButton createLocationButton(String locationName,String status)
    {

        JButton btn =new JButton("<html><center>" + locationName + "<br>" + status + "</center></html>");

        btn.setFont(new Font("Arial", Font.BOLD, 14));

        btn.setFocusPainted(false);

        btn.setForeground(Color.WHITE);


        if(status.equalsIgnoreCase("ACTIVE"))
        {

            btn.setBackground( new Color(39, 174, 96)
            );
        }
        else if(status.equalsIgnoreCase("BUSY"))
        {

            btn.setBackground(new Color(243, 156, 18) );
        }

        else
        {

            btn.setBackground( new Color(192, 57, 43));
        }


        btn.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {

                        JOptionPane.showMessageDialog(
                                null,
                                locationName
                                        + "\nStatus: "
                                        + status,
                                "Campus Location",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
        );

        return btn;
    }
    
}


