
package gui.panels;

import filehandler.DataManager;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.*;
import models.facility.Library;
import repository.CampusRepository;

public class FacilityPanel extends JFrame implements ActionListener, Serializable
{

    JTextField idField;
    JTextField nameField;
    JTextField locationField;
    JTextField maintenanceField;
    JTextField usageField;
    JTextField booksField;
    JTextField membersField;

    JButton addBtn;
    JButton deleteBtn;
    JButton saveBtn;
    JButton loadBtn;
    JButton searchBtn;
    JButton totalBtn;

    JTextArea displayArea;

    CampusRepository<Library> repo =
            new CampusRepository<>();



    public FacilityPanel()
    {

        setTitle("Facility Management - Library");

        setSize(600, 700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());


        loadData();



        JPanel formPanel =
                new JPanel(
                        new GridLayout(7, 2, 5, 5)
                );

        formPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Library Details"
                )
        );


        formPanel.add(
                new JLabel("Library ID:")
        );

        idField = new JTextField();

        formPanel.add(idField);


        formPanel.add(
                new JLabel("Library Name:")
        );

        nameField = new JTextField();

        formPanel.add(nameField);



        
        formPanel.add(
                new JLabel("Location:")
        );

        locationField = new JTextField();

        formPanel.add(locationField);


        formPanel.add(
                new JLabel("Maintenance Cost:")
        );

        maintenanceField = new JTextField();

        formPanel.add(maintenanceField);

        formPanel.add(
                new JLabel("Usage Frequency:")
        );

        usageField = new JTextField();

        formPanel.add(usageField);



        formPanel.add(
                new JLabel("Total Books:")
        );

        booksField = new JTextField();

        formPanel.add(booksField);



        formPanel.add(
                new JLabel("Total Members:")
        );

        membersField = new JTextField();

        formPanel.add(membersField);


        add(formPanel, BorderLayout.NORTH);



        displayArea = new JTextArea();

        displayArea.setEditable(false);

        displayArea.setFont(
                new Font("Monospaced", Font.PLAIN, 13)
        );

        JScrollPane scroll =
                new JScrollPane(displayArea);

        scroll.setBorder(
                BorderFactory.createTitledBorder(
                        "Facilities List"
                )
        );

        add(scroll, BorderLayout.CENTER);



        JPanel btnPanel =
                new JPanel(
                        new FlowLayout()
                );

        addBtn = new JButton("Add");

        deleteBtn = new JButton("Delete");

        saveBtn = new JButton("Save");

        loadBtn = new JButton("Load");

        searchBtn = new JButton("Search");

        totalBtn = new JButton("Total Facilities");


        addBtn.addActionListener(this);

        deleteBtn.addActionListener(this);

        saveBtn.addActionListener(this);

        loadBtn.addActionListener(this);

        searchBtn.addActionListener(this);

        totalBtn.addActionListener(this);


        btnPanel.add(addBtn);

        btnPanel.add(deleteBtn);

        btnPanel.add(saveBtn);

        btnPanel.add(loadBtn);

        btnPanel.add(searchBtn);

        btnPanel.add(totalBtn);


        add(btnPanel, BorderLayout.SOUTH);



        refreshDisplay();

        setVisible(true);
    }


    private void addFacility()
    {

        if(idField.getText().isEmpty()
                ||
           nameField.getText().isEmpty()
                ||
           locationField.getText().isEmpty())
        {

            JOptionPane.showMessageDialog(
                    this,
                    "ID, Name and Location are required!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }


        try
        {

            String id =
                    idField.getText().trim();

            String name =
                    nameField.getText().trim();

            String location =
                    locationField.getText().trim();

            double maintenance =
                    Double.parseDouble(
                            maintenanceField.getText().trim()
                    );

            int usage =
                    Integer.parseInt(
                            usageField.getText().trim()
                    );

            int books =
                    Integer.parseInt(
                            booksField.getText().trim()
                    );

            int members =
                    Integer.parseInt(
                            membersField.getText().trim()
                    );


            for(int i = 0; i < repo.getSize(); i++)
            {

                if(repo.get(i)
                        .getEntityID()
                        .equalsIgnoreCase(id))
                {

                    JOptionPane.showMessageDialog(
                            this,
                            "Library ID already exists!",
                            "Duplicate Error",
                            JOptionPane.ERROR_MESSAGE
                    );

                    return;
                }
            }



            Library library =
                    new Library(
                            id,
                            name,
                            location,
                            maintenance,
                            usage,
                            books,
                            members
                    );


            repo.add(library);


            saveData();


            refreshDisplay();

            clearFields();


            JOptionPane.showMessageDialog(
                    this,
                    "Library Added Successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

        }

        catch(NumberFormatException e)
        {

            JOptionPane.showMessageDialog(
                    this,
                    "Maintenance, Usage, Books and Members must be numbers!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    private void deleteFacility()
    {

        if(repo.getSize() == 0)
        {

            JOptionPane.showMessageDialog(
                    this,
                    "No facilities available!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }


        String id =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Library ID to delete:"
                );


        if(id != null)
        {

            for(int i = 0; i < repo.getSize(); i++)
            {

                if(repo.get(i)
                        .getEntityID()
                        .equalsIgnoreCase(id))
                {

                    repo.remove(repo.get(i));

                    saveData();

                    refreshDisplay();


                    JOptionPane.showMessageDialog(
                            this,
                            "Library Deleted Successfully!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    return;
                }
            }


            JOptionPane.showMessageDialog(
                    this,
                    "Library ID not found!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }



    private void searchFacility()
    {

        if(repo.getSize() == 0)
        {

            JOptionPane.showMessageDialog(
                    this,
                    "No facilities available!"
            );

            return;
        }


        String id =
                JOptionPane.showInputDialog(
                        this,
                        "Enter Library ID:"
                );


        if(id != null)
        {

            for(int i = 0; i < repo.getSize(); i++)
            {

                if(repo.get(i)
                        .getEntityID()
                        .equalsIgnoreCase(id))
                {

                    JOptionPane.showMessageDialog(
                            this,
                            repo.get(i).toString()
                    );

                    return;
                }
            }


            JOptionPane.showMessageDialog(
                    this,
                    "Library not found!"
            );
        }
    }



    private void totalFacilities()
    {

        JOptionPane.showMessageDialog(
                this,
                "Total Facilities: " + repo.getSize()
        );
    }


    private void refreshDisplay()
    {

        displayArea.setText("");


        if(repo.getSize() == 0)
        {

            displayArea.setText(
                    "No Facilities Available!"
            );

            return;
        }


        for(int i = 0; i < repo.getSize(); i++)
        {

            displayArea.append(
                    repo.get(i).toString()
                            + "\n\n"
            );
        }
    }



    private void saveData()
    {

        DataManager.saveData(
                "facilities.dat",
                repo
        );
    }


    @SuppressWarnings("unchecked")

    private void loadData()
    {

        Object obj =
                DataManager.loadData(
                        "facilities.dat"
                );


        if(obj != null)
        {

            repo =
                    (CampusRepository<Library>) obj;
        }

        else
        {

            repo =
                    new CampusRepository<>();
        }
    }


    private void clearFields()
    {

        idField.setText("");

        nameField.setText("");

        locationField.setText("");

        maintenanceField.setText("");

        usageField.setText("");

        booksField.setText("");

        membersField.setText("");
    }


    @Override

    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == addBtn)
        {

            addFacility();
        }

        else if(e.getSource() == deleteBtn)
        {

            deleteFacility();
        }

        else if(e.getSource() == saveBtn)
        {

            saveData();

            JOptionPane.showMessageDialog(
                    this,
                    "Data Saved Successfully!"
            );
        }

        else if(e.getSource() == loadBtn)
        {

            loadData();

            refreshDisplay();

            JOptionPane.showMessageDialog(
                    this,
                    "Data Loaded Successfully!"
            );
        }

        else if(e.getSource() == searchBtn)
        {

            searchFacility();
        }

        else if(e.getSource() == totalBtn)
        {

            totalFacilities();
        }
    }
}

