//importing ArrayList package for storing member objects
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
    
public class GymGUI{
    // Declare all input fields and components used in the GUI
    private JTextField idField, nameField, locationField, phoneField;
    private JTextField emailField, referralField,  trainerField, paidField;
    private JRadioButton maleButton, femaleButton;
    private JComboBox dobyearCombo, dobmonthCombo, dobdayCombo;
    private JComboBox msyearCombo, msmonthCombo, msdayCombo;
    private JComboBox plansCombo;
    // ArrayList to store both RegularMember and PremiumMember objects
    ArrayList<GymMember> members = new ArrayList<>();
    // Entry point of the program
    public static void main(String[]args){
        new GymGUI();// Create an instance of GymGUI to initialize and display the GUI
    }
    
    // Constructor to build the main frame of the Gym Membership GUI
    public  GymGUI(){
        // Create and configure the main application window
        JFrame frame = new JFrame("GUI");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);// Use absolute positioning for layout
        
        // Title label for the window
        JLabel titleLabel = new JLabel("Welcome to the Gym Membership ", JLabel.CENTER);
        titleLabel.setBounds(100,10,500,100);
        titleLabel.setFont(new Font("Arial", Font.BOLD,16));
        frame.add(titleLabel);
        
        // Buttons for navigating to different membership forms and viewing members    
        JButton regularButton = new JButton("Regular Member");
        regularButton.setBounds(125,100,500,100);
        JButton premiumButton = new JButton("Premium Member");
        premiumButton.setBounds(125,250,500,100);
        JButton showButton = new JButton("View Members");
        showButton.setBounds(125,400,500,100);
        
        // Add all buttons to the main frame    
        frame.add(regularButton);
        frame.add(premiumButton);
        frame.add(showButton);
        
        // Action listener to open Regular Member registration frame
        regularButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                openRegularFrame();// Call method to display regular member registration form
               }
        });
            
        premiumButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                openPremiumFrame();
            }
        });
        
        showButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                showMembers();
            }
        });
        
        
        // Display the main frame
        frame.setVisible(true);
        }
        
    private void showMembers() {
    // Create a new JFrame to display both Regular and Premium Members    
    JFrame frame = new JFrame("All Members");
    frame.setSize(800, 600);
    frame.setLayout(new GridLayout(1, 2));// Two columns for regular and premium
    
     // Text areas to display member details
    JTextArea regularTextArea = new JTextArea();
    JTextArea premiumTextArea = new JTextArea();

    regularTextArea.setEditable(false);
    premiumTextArea.setEditable(false);
    
     // Add scroll functionality to the text areas
    JScrollPane scrollRegular = new JScrollPane(regularTextArea);
    JScrollPane scrollPremium = new JScrollPane(premiumTextArea);
    
    // Set titled borders for better visual separation
    scrollRegular.setBorder(BorderFactory.createTitledBorder("Regular Members"));
    scrollPremium.setBorder(BorderFactory.createTitledBorder("Premium Members"));
    
     // Loop through the members list and categorize based on their type
    for (GymMember member : members) {
        if (member instanceof RegularMember) {
            regularTextArea.append(member.display() + "\n\n");
        } else if (member instanceof PremiumMember) {
            premiumTextArea.append(member.display() + "\n\n");
        }
    }
    
    // Add both scroll panes to the main frame and make it visible
    frame.add(scrollRegular);
    frame.add(scrollPremium);
    frame.setVisible(true);
}
    
        public void openRegularFrame(){
            // Create a new frame for Regular Member registration
            JFrame rframe = new JFrame("Regular Member");
            rframe.setSize(800,600);
            rframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            rframe.setLayout(null);// Using absolute layout
            
            // Title label
            JLabel titleLabel = new JLabel("Regular Membership Details ", JLabel.CENTER);
            titleLabel.setBounds(100,10,500,100);
            titleLabel.setFont(new Font("Arial", Font.BOLD,16));
            rframe.add(titleLabel);
            
            // Input fields and labels for personal details
            JLabel idLabel = new JLabel("ID:");
            idLabel.setBounds(30,100,100,30);
            JTextField idField = new JTextField(20);
            idField.setBounds(120,100,150,30);
                
            JLabel nameLabel = new JLabel("NAME:");
            nameLabel.setBounds(380,100,100,30);
            JTextField nameField = new JTextField(20);
            nameField.setBounds(550,100,150,30);
                
            JLabel locationLabel = new JLabel("LOCATION:");
            locationLabel.setBounds(30,140,100,30);
            JTextField locationField = new JTextField(20);
            locationField.setBounds(120,140,150,30);
                
            JLabel phoneLabel = new JLabel("PHONE:");
            phoneLabel.setBounds(380,140,100,30);
            JTextField phoneField = new JTextField(20);
            phoneField.setBounds(550,140,150,30);
                
            JLabel emailLabel = new JLabel("EMAIL:");
            emailLabel.setBounds(30,180,100,30);
            JTextField emailField = new JTextField(20);
            emailField.setBounds(120,180,150,30);
                
            JLabel referralLabel = new JLabel("REFERRAL SOURCE:");
            referralLabel.setBounds(380,180,150,30);
            JTextField referralField = new JTextField(20);
            referralField.setBounds(550,180,150,30);
                
            JLabel genderLabel = new JLabel("GENDER:");
            genderLabel.setBounds(30,220,100,30);
            JRadioButton maleButton= new JRadioButton("MALE");
            maleButton.setBounds(110,220,60,30);
            JRadioButton femaleButton= new JRadioButton("FEMALE");
            femaleButton.setBounds(180,220,160,30);
                
            ButtonGroup genderGroup = new ButtonGroup();
            genderGroup.add(maleButton);
            genderGroup.add(femaleButton);
            
             // Plan selection ComboBox
            JLabel planLabel = new JLabel("PLAN:");
            planLabel.setBounds(380,220,150,30);
            String [] plan = {"BASIC","STANDARD","DELUXE"};
            JComboBox plansCombo = new JComboBox(plan);
            plansCombo.setBounds(550,220,150,30);
            plansCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPlan = (String) plansCombo.getSelectedItem();
                String price = switch (selectedPlan) {
                    case "BASIC" -> "29.99";
                    case "STANDARD" -> "49.99";
                    case "DELUXE" -> "69.99";
                    default -> "0.00";
        };
        paidField.setText(price);
        }
    });

            
            // ComboBoxes for Date of Birth
            JLabel dobLabel = new JLabel("DOB:");
            dobLabel.setBounds(30,260,100,30);
            String [] years = {"1990","1991","1992","1993","1994","1995","1996","1996","1997","1998","1999","2000","2001","2018","2019","2020","2021","2022","2023","2024","2025"};
            String [] months = {"Jan","Feb","Mar","April","May","June","July","Aug","Sept","Oct","Nov","Dec"};
            String [] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32"};
                
            JComboBox<String> dobyearCombo = new JComboBox(years);
            dobyearCombo.setBounds(110,260,60,30);
            JComboBox dobmonthCombo = new JComboBox(months);
            dobmonthCombo.setBounds(190,260,60,30);
            JComboBox dobdayCombo = new JComboBox(days);
            dobdayCombo.setBounds(270,260,60,30);
            
            JLabel paidLabel = new JLabel("AMOUNT:");
            paidLabel.setBounds(380,270,150,30);
            JTextField paidField = new JTextField(20);
            paidField.setBounds(550,270,150,30);
        
            // ComboBoxes for Membership Start Date
            JLabel memberLabel = new JLabel("MEMBERSHIP START DATE:");
            memberLabel.setBounds(30,300,200,30);
            String [] msdyears = {"1990","1991","1992","1993","1994","1995","1996","1996","1997","1998","1999","2000","2001","2018","2019","2020","2021","2022","2023","2024","2025"};
            String [] msdmonths = {"Jan","Feb","Mar","April","May","June","July","Aug","Sept","Oct","Nov","Dec"};
            String [] msddays = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32"};
                
            JComboBox<String> msyearCombo = new JComboBox(msdyears);
            msyearCombo.setBounds(110,330,60,30);
            JComboBox msmonthCombo = new JComboBox(msdmonths);
            msmonthCombo.setBounds(180,330,60,30);
            JComboBox msdayCombo = new JComboBox(msddays);
            msdayCombo.setBounds(260,330,60,30);
            
            //save button
            JButton saveButton = new JButton("SAVE");
            saveButton.setBounds(450,320,150,25);
            saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("MemberDetails.txt",true))) {
                    writer.write(String.format("%-5s %-15s %-15s %-15s %-25s %-10s %-10s %-15s %-10s %-10s %-10s %-10s\n",
                        "ID", "Name", "Location", "Phone", "Email", "Gender", "DOB", "StartDate", "Plan", "Price", "Active", "Points"));
                    writer.write("_".repeat(150));
                    writer.newLine();
                    for (GymMember member : members) {
                        if (member instanceof RegularMember) {
                            RegularMember r = (RegularMember) member;
                            writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-10s %-10s %-15s %-10s %-10.2f %-10s %-10.2f\n",
                                r.getId(), r.getName(), r.getLocation(), r.getPhone(), r.getEmail(), r.getGender(),r.getDOB(), r.getMembershipStartDate(), r.getPlan(), r.getPrice(),
                                r.getActiveStatus() ? "Yes" : "No", r.getLoyaltyPoints()));
                        }
                    }
                    writer.write("_".repeat(150));
                    writer.newLine();
                
                    JOptionPane.showMessageDialog(rframe, "Members data saved to MemberDetails.txt");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rframe, "Error saving to file: " + ex.getMessage());
                }

            }
        });
            
            //read button
            JButton readButton = new JButton("READ");
            readButton.setBounds(450,350,150,25);
            readButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try (BufferedReader reader = new BufferedReader(new FileReader("MemberDetails.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException ex) {
                        System.out.println("Error reading file: " + ex.getMessage());
                    }
                }
            });
            
            // Buttons for membership actions
            JButton activeButton = new JButton("ACTIVATE MEMBERSHIP");
            activeButton.setBounds(50,400,200,30);
                
            JButton deactiveButton = new JButton("DEACTIVATE MEMBERSHIP");
            deactiveButton.setBounds(280,400,200,30);
                
            JButton markButton = new JButton("MARK ATTENDANCE");
            markButton.setBounds(510,400,200,30);
                
            JButton revertButton = new JButton("REVERT MEMBER");
            revertButton.setBounds(50,450,200,30);
            
            revertButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                try {
                    if (idField.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Member ID to revert.");
                        return;
                    }
        
                    int id = Integer.parseInt(idField.getText());
                    GymMember member = findMemberById(id);
        
                    if (member == null) {
                        JOptionPane.showMessageDialog(null, "Member not found.");
                        return;
                    }
        
                    // Ask for removal reason
                    String reason = JOptionPane.showInputDialog(null, "Enter reason for reverting/removing the member:");
        
                    if (reason == null || reason.equals("")) {
                        JOptionPane.showMessageDialog(null, "Removal reason is required.");
                        return;
                    }
        
                    // Log or show the reason
                    JOptionPane.showMessageDialog(null, "Reason noted for removal: " + reason);
        
                    // You can optionally log this to the console or a file
                    System.out.println("Removal reason for Member ID " + id + ": " + reason);
        
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Member ID.");
                }
            }
        });


                
            JButton displayButton = new JButton("DISPLAY");
            displayButton.setBounds(280,450,200,30);
            
        displayButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                        showMembers();
                }
        });
            JButton clearButton = new JButton("CLEAR");
            clearButton.setBounds(510,450,200,30);
                
            JButton upgradeButton = new JButton("UPGRADE PLAN");
            upgradeButton.setBounds(280,500,200,30);
            
        upgradeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    try {
                    if (idField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Enter Member ID");
                        return;
                    }
        
                    int id = Integer.parseInt(idField.getText());
                    GymMember member = findMemberById(id);
        
                    if (member == null) {
                        JOptionPane.showMessageDialog(null, "Member not found.");
                        return;
                    }
        
                    if (member instanceof PremiumMember) {
                        JOptionPane.showMessageDialog(null, "This member is already a Premium member.");
                        return;
                    }
        
                    // Prompt for Trainer Name (Premium-specific detail)
                    String trainerName = JOptionPane.showInputDialog(null, "Enter Trainer Name for Premium Membership:");
        
                    if (trainerName == null || trainerName.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Trainer name is required.");
                        return;
                    }
        
                    // Remove regular member
                    members.remove(member);
        
                    // Create PremiumMember using existing details from input fields
                    String name = nameField.getText();
                    String location = locationField.getText();
                    String phone = phoneField.getText();
                    String email = emailField.getText();
                    String gender = maleButton.isSelected() ? "Male" : (femaleButton.isSelected() ? "Female" : "Others");
                    String dob = dobdayCombo.getSelectedItem() + "/" + dobmonthCombo.getSelectedItem() + "/" + dobyearCombo.getSelectedItem();
        
                    // Create and add PremiumMember
                    PremiumMember upgradedMember = new PremiumMember(id, name, location, phone, email, gender, dob, "Today", trainerName);
                    members.add(upgradedMember);
        
                    JOptionPane.showMessageDialog(null, "Regular member upgraded to Premium!");
        
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Member ID format.");
                }
            }
        });

                
            JButton addrButton = new JButton("ADD REGULAR MEMBER");
            addrButton.setBounds(510,500,200,30);
            
            // Add all components to the frame
            rframe.add(idLabel);
            rframe.add(idField);
            rframe.add(nameLabel);
            rframe.add(nameField);
            rframe.add(locationLabel);
            rframe.add(locationField);
            rframe.add(phoneLabel);
            rframe.add(phoneField);
            rframe.add(emailLabel);
            rframe.add(emailField);
            rframe.add(referralLabel);
            rframe.add(referralField);
            rframe.add(genderLabel);
            rframe.add(maleButton);
            rframe.add(femaleButton);
            rframe.add(dobLabel);
            rframe.add(dobyearCombo);
            rframe.add(dobmonthCombo);
            rframe.add(dobdayCombo);
            rframe.add(paidLabel);
            rframe.add(paidField);
            rframe.add(memberLabel);
            rframe.add(msyearCombo);
            rframe.add(msmonthCombo);
            rframe.add(msdayCombo);
            rframe.add(planLabel);
            rframe.add(plansCombo);
            rframe.add(saveButton);
            rframe.add(readButton);
            rframe.add(activeButton);
            rframe.add(deactiveButton);
            rframe.add(markButton);
            rframe.add(revertButton);
            rframe.add(displayButton);
            rframe.add(clearButton);
            rframe.add(upgradeButton);
            rframe.add(addrButton);
            
            // Action for adding a regular member
            addrButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
            try {
                // Validate ID field
                if (idField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rframe, "ID must be filled");
                    return;
                }
                int id = Integer.parseInt(idField.getText());
                GymMember member = findMemberById(id);
                if(member != null){
                    JOptionPane.showMessageDialog(rframe, "Member already exists.");
                    return;
                }
                 // Validate name field
                if (nameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rframe, "Name must be filled");
                    return;
                }
                if(phoneField.getText().isEmpty()){
                        JOptionPane.showMessageDialog(rframe,"Phone number msut be filled.");
                }
                if (locationField.getText().isEmpty() || emailField.getText().isEmpty() || referralField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rframe, "All fields must be filled");
                    return;
                }

                
                // Collect other inputs
                String name = nameField.getText();
                String location = locationField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Others";
                String dob = dobdayCombo.getSelectedItem() + "/" + dobmonthCombo.getSelectedItem() + "/" + dobyearCombo.getSelectedItem();
                String referral = referralField.getText();
                String planSelected = (String) plansCombo.getSelectedItem();
                
                 // Create new member and add to list
                RegularMember newMember = new RegularMember(id, name, location, phone, email, gender, dob, referral);
                members.add(newMember);
                
                // Confirmation message
                JOptionPane.showMessageDialog(rframe, "Regular Member Added", "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(rframe, "ID must be a number");
                JOptionPane.showMessageDialog(rframe, "Phone Number must be a number");
            }
        }
        });

                
        // Activate Membership
        activeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    try {
                         int id = Integer.parseInt(idField.getText());
                         GymMember member = findMemberById(id);
                             if (member != null) {
                                 member.activateMembership();
                                 JOptionPane.showMessageDialog(rframe, "Membership activated.");
                             } else {
                                JOptionPane.showMessageDialog(rframe,"Member not found.","Error",JOptionPane.ERROR_MESSAGE);
                         }
                     } catch (NumberFormatException ex) {
                             JOptionPane.showMessageDialog(rframe, "Enter valid Member ID.","Error",JOptionPane.ERROR_MESSAGE);
                 }
            }
        });
            
            
        // Deactivate Membership
            deactiveButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(idField.getText());
                        GymMember member = findMemberById(id);
                            if (member != null) {
                                member.deactivateMembership();
                                JOptionPane.showMessageDialog(rframe, "Membership deactivated.");
                            } else {
                                JOptionPane.showMessageDialog(rframe, "Member not found,","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(rframe, "Enter valid Member ID.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Mark Attendance
            markButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(idField.getText());
                        GymMember member = findMemberById(id);
                            if (member != null) {
                                if (member.getActiveStatus()) {
                                    member.markAttendance();
                                    JOptionPane.showMessageDialog(rframe, "Attendance marked.");
                                } else {
                                    JOptionPane.showMessageDialog(rframe, "Membership is not active.","Error",JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(rframe, "Member not found.","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(rframe, "Enter valid Member ID.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Clear Button - Resets all form fields
            clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                idField.setText("");
                nameField.setText("");
                locationField.setText("");
                phoneField.setText("");
                emailField.setText("");
                referralField.setText("");
                paidField.setText("");
                maleButton.setSelected(false);
                femaleButton.setSelected(false);
                dobyearCombo.setSelectedIndex(0);
                dobmonthCombo.setSelectedIndex(0);
                dobdayCombo.setSelectedIndex(0);
                msyearCombo.setSelectedIndex(0);
                msmonthCombo.setSelectedIndex(0);
                msdayCombo.setSelectedIndex(0);
                plansCombo.setSelectedIndex(0);
            }
        });
        
        //plan price change 
            plansCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedPlan = (String) plansCombo.getSelectedItem();
        
                if (selectedPlan.equals("BASIC")) {
                    paidField.setText("6500");
                } else if (selectedPlan.equals("STANDARD")) {
                    paidField.setText("12500");
                } else if (selectedPlan.equals("DELUXE")) {
                    paidField.setText("18500");
                }
            }
        });
    // Make the Regular Member form visible
    rframe.setVisible(true);   

}        
    
    // Utility method to find a member from the ArrayList by their ID          
    private GymMember findMemberById(int id) {
        for (GymMember member : members) {
            if (member.getId() == id) {// Compare IDs
                return member; // Return member if match found
            }
        }
            return null;// Return null if no match is found
    }
    
    
    // Method to open the Premium Member registration frame        
    public void openPremiumFrame(){
        JFrame pframe = new JFrame("Premium Member");
        pframe.setSize(800,600);
        pframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pframe.setLayout(null);// Use absolute layout for manual positioning
        
        // Title label
        JLabel titleLabel = new JLabel("Premium Membership Details ", JLabel.CENTER);
        titleLabel.setBounds(100,10,500,100);
        titleLabel.setFont(new Font("Arial", Font.BOLD,16));
        pframe.add(titleLabel);
        
        // Input fields and labels for premium member details
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(30,100,100,30);
        JTextField idField = new JTextField(20);
        idField.setBounds(120,100,150,30);
        
        JLabel nameLabel = new JLabel("NAME:");
        nameLabel.setBounds(380,100,100,30);
        JTextField nameField = new JTextField(20);
        nameField.setBounds(550,100,150,30);
        
        JLabel locationLabel = new JLabel("LOCATION:");
        locationLabel.setBounds(30,140,100,30);
        JTextField locationField = new JTextField(20);
        locationField.setBounds(120,140,150,30);
        
        JLabel phoneLabel = new JLabel("PHONE:");
        phoneLabel.setBounds(380,140,100,30);
        JTextField phoneField = new JTextField(20);
        phoneField.setBounds(550,140,150,30);
        
        JLabel emailLabel = new JLabel("EMAIL:");
        emailLabel.setBounds(30,180,100,30);
        JTextField emailField = new JTextField(20);
        emailField.setBounds(120,180,150,30);
        
        JLabel trainerLabel = new JLabel("TRAINER'S NAME:");
        trainerLabel.setBounds(380,180,150,30);
        JTextField trainerField = new JTextField(20);
        trainerField.setBounds(550,180,150,30);
        
         // Gender selection using radio buttons
        JLabel genderLabel = new JLabel("GENDER:");
        genderLabel.setBounds(30,220,100,30);
        JRadioButton maleButton= new JRadioButton("MALE");
        maleButton.setBounds(110,220,60,30);
        JRadioButton femaleButton= new JRadioButton("FEMALE");
        femaleButton.setBounds(180,220,160,30);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        
        JLabel amountLabel = new JLabel("TOTAL AMOUNT:");
        amountLabel.setBounds(380,220,150,30);
        JTextField amountField = new JTextField(20);
        amountField.setBounds(550,220,150,30);
        amountField.setText("50000");// Fixed premium plan charge
        
         // ComboBoxes for Date of Birth
        JLabel dobLabel = new JLabel("DOB:");
        dobLabel.setBounds(30,260,100,30);
        String [] years = {"1990","1991","1992","1993","1994","1995","1996","1996","1997","1998","1999","2000","2001","2018","2019","2020","2021","2022","2023","2024","2025"};
        String [] months = {"Jan","Feb","Mar","April","May","June","July","Aug","Sept","Oct","Nov","Dec"};
        String [] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32"};
        
        JComboBox<String> dobyearCombo = new JComboBox(years);
        dobyearCombo.setBounds(110,260,60,30);
        JComboBox dobmonthCombo = new JComboBox(months);
        dobmonthCombo.setBounds(190,260,60,30);
        JComboBox dobdayCombo = new JComboBox(days);
        dobdayCombo.setBounds(270,260,60,30);
        
        JLabel paidLabel = new JLabel("PAID AMOUNT:");
        paidLabel.setBounds(380,260,150,30);
        JTextField paidField = new JTextField(20);
        paidField.setBounds(550,260,150,30);
        
        JButton saveButton = new JButton("SAVE");
        saveButton.setBounds(450,320,150,25);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("MemberDetails.txt",true))) {
                    writer.write(String.format("%-5s %-15s %-15s %-15s %-25s %-10s %-10s %-15s %-10s %-10s %-10s %-10s\n",
                        "ID", "Name", "Location", "Phone", "Email", "Gender", "DOB", "StartDate", "Plan", "Price", "Active", "Points"));
                    writer.write("_".repeat(150));
                    writer.newLine();
                    for (GymMember member : members) {
                        if (member instanceof RegularMember) {
                            RegularMember r = (RegularMember) member;
                            writer.write(String.format("%-5d %-15s %-15s %-15s %-25s %-10s %-10s %-15s %-10s %-10.2f %-10s %-10.2f\n",
                                r.getId(), r.getName(), r.getLocation(), r.getPhone(), r.getEmail(), r.getGender(),r.getDOB(), r.getMembershipStartDate(), r.getPlan(), r.getPrice(),
                                r.getActiveStatus() ? "Yes" : "No", r.getLoyaltyPoints()));
                        }
                    }
                    writer.write("_".repeat(150));
                    writer.newLine();
                
                    JOptionPane.showMessageDialog(pframe, "Members data saved to MemberDetails.txt");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(pframe, "Error saving to file: " + ex.getMessage());
                }

            }
        });
            
            //read button
            JButton readButton = new JButton("READ");
            readButton.setBounds(450,350,150,25);
            readButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try (BufferedReader reader = new BufferedReader(new FileReader("MemberDetails.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException ex) {
                        System.out.println("Error reading file: " + ex.getMessage());
                    }
                }
            });
        
        
        
        // Membership start date ComboBoxes
        JLabel memberLabel = new JLabel("MEMBERSHIP START DATE:");
        memberLabel.setBounds(30,300,200,30);
        String [] msdyears = {"1990","1991","1992","1993","1994","1995","1996","1996","1997","1998","1999","2000","2001","2018","2019","2020","2021","2022","2023","2024","2025"};
        String [] msdmonths = {"Jan","Feb","Mar","April","May","June","July","Aug","Sept","Oct","Nov","Dec"};
        String [] msddays = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32"};
        
        JComboBox<String> msyearCombo = new JComboBox(msdyears);
        msyearCombo.setBounds(110,330,60,30);
        JComboBox msmonthCombo = new JComboBox(msdmonths);
        msmonthCombo.setBounds(180,330,60,30);
        JComboBox msdayCombo = new JComboBox(msddays);
        msdayCombo.setBounds(260,330,60,30);
        
        // Membership-related buttons
        JButton activeButton = new JButton("ACTIVATE MEMBERSHIP");
        activeButton.setBounds(50,400,200,30);
        
        JButton deactiveButton = new JButton("DEACTIVATE MEMBERSHIP");
        deactiveButton.setBounds(280,400,200,30);
        
        JButton markButton = new JButton("MARK ATTENDANCE");
        markButton.setBounds(510,400,200,30);
        
        JButton revertButton = new JButton("REVERT MEMBER");
        revertButton.setBounds(50,450,200,30);
        revertButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                try {
                    if (idField.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Enter Member ID to revert.");
                        return;
                    }
        
                    int id = Integer.parseInt(idField.getText());
                    GymMember member = findMemberById(id);
        
                    if (member == null) {
                        JOptionPane.showMessageDialog(null, "Member not found.");
                        return;
                    }
        
                    // Ask for removal reason
                    String reason = JOptionPane.showInputDialog(null, "Enter reason for reverting/removing the member:");
        
                    if (reason == null || reason.equals("")) {
                        JOptionPane.showMessageDialog(null, "Removal reason is required.");
                        return;
                    }
        
                    // Log or show the reason
                    JOptionPane.showMessageDialog(null, "Reason noted for removal: " + reason);
        
                    // You can optionally log this to the console or a file
                    System.out.println("Removal reason for Member ID " + id + ": " + reason);
        
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Member ID.");
                }
            }
        });

        
        JButton displayButton = new JButton("DISPLAY");
        displayButton.setBounds(280,450,200,30);
        
        displayButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e){
                        showMembers();
                }
        });
        
        JButton clearButton = new JButton("CLEAR");
        clearButton.setBounds(510,450,200,30);
        
        JButton upgradeButton = new JButton("PAY DUE AMOUNT");
        upgradeButton.setBounds(50,500,200,30);
        upgradeButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            if (idField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Enter Member ID.");
                return;
            }

            int id = Integer.parseInt(idField.getText());
            GymMember member = findMemberById(id);

            if (member == null) {
                JOptionPane.showMessageDialog(null, "Member not found.");
                return;
            }

            String amount = paidField.getText();
            if (amount.equals("") || amount.equals("0")) {
                JOptionPane.showMessageDialog(null, "No due amount found.");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(null, "Confirm payment of Rs. " + amount + "?", "Confirm Payment", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                paidField.setText("0");
                JOptionPane.showMessageDialog(null, "Payment successful. Due cleared.");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid ID format.");
        }
    }
});
        
        JButton discountButton = new JButton("DISCOUNT");
        discountButton.setBounds(280,500,200,30);
        
        discountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int originalPrice = 50000;
                    int paidAmount = Integer.parseInt(paidField.getText());
        
                    // Only allow discount if full payment has been made
                    if (paidAmount !=50000) {
                        JOptionPane.showMessageDialog(pframe, "Discount can only be applied after full payment.");
                        return;
                    }
        
                    int discountPercent = 10; // Fixed 10% discount
                    int discountedPrice = originalPrice - (originalPrice * discountPercent / 100);
        
                    paidField.setText(String.valueOf(discountedPrice));
        
                    JOptionPane.showMessageDialog(pframe,
                        "Discount of " + discountPercent + "% applied.\nNew price: Rs. " + discountedPrice);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(pframe, "Enter your paid amount.");
                }
            }
        });


        
        JButton addpButton = new JButton("ADD PREMIUM MEMBER");
        addpButton.setBounds(510,500,200,30);
        
        // Action for adding a premium member
        addpButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                try {
                     // Check if ID is provided
                    if (idField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(pframe, "ID must be filled");
                        return;
                    }
                    int id = Integer.parseInt(idField.getText());
                    
                    // Check if name is provided
                    if (nameField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(pframe, "Name must be filled");
                        return;
                    }
                    
                    if(phoneField.getText().isEmpty()){
                        JOptionPane.showMessageDialog(pframe,"Phone number msut be filled.");
                        return;
                    }
                    
                     // Create new PremiumMember object using form data
                    PremiumMember newMember = new PremiumMember(id, nameField.getText(), locationField.getText(), phoneField.getText(),emailField.getText(), maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Others",dobdayCombo.getSelectedItem() + "/" + dobmonthCombo.getSelectedItem() + "/" + dobyearCombo.getSelectedItem(),msdayCombo.getSelectedItem() + "/" + msmonthCombo.getSelectedItem() + "/" + msyearCombo.getSelectedItem(), trainerField.getText());
                    members.add(newMember);// Add to main list
                    JOptionPane.showMessageDialog(pframe, "Premium Member Added", "Success", JOptionPane.INFORMATION_MESSAGE);
    
    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(pframe, "ID must be a number");
                    JOptionPane.showMessageDialog(pframe, "Phone Number must be a number");
                }
            }
        });
        //adding the fields and labels in the panel
            pframe.add(idLabel);
            pframe.add(idField);
            pframe.add(nameLabel);
            pframe.add(nameField);
            pframe.add(locationLabel);
            pframe.add(locationField);
            pframe.add(phoneLabel);
            pframe.add(phoneField);
            pframe.add(emailLabel);
            pframe.add(emailField);
            pframe.add(trainerLabel);
            pframe.add(trainerField);
            pframe.add(amountField);
            pframe.add(amountLabel);
            pframe.add(genderLabel);
            pframe.add(maleButton);
            pframe.add(femaleButton);
            pframe.add(dobLabel);
            pframe.add(dobyearCombo);
            pframe.add(dobmonthCombo);
            pframe.add(dobdayCombo);
            pframe.add(paidLabel);
            pframe.add(paidField);
            pframe.add(memberLabel);
            pframe.add(msyearCombo);
            pframe.add(msmonthCombo);
            pframe.add(msdayCombo);
            pframe.add(saveButton);
            pframe.add(readButton);
            pframe.add(activeButton);
            pframe.add(deactiveButton);
            pframe.add(markButton);
            pframe.add(revertButton);
            pframe.add(displayButton);
            pframe.add(clearButton);
            pframe.add(upgradeButton);
            pframe.add(discountButton);
            pframe.add(addpButton);
        
    // Activate Membership
        activeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(idField.getText());
                        GymMember member = findMemberById(id);
                            if (member != null) {
                                member.activateMembership();
                                JOptionPane.showMessageDialog(pframe,"Membership activated."); 
                            } else {
                                JOptionPane.showMessageDialog(pframe, "Member not found.","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(pframe, "Enter valid Member ID.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Deactivate Membership
        deactiveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    try {
                            int id = Integer.parseInt(idField.getText());
                            GymMember member = findMemberById(id);
                                if (member != null) {
                                    member.deactivateMembership();
                                    JOptionPane.showMessageDialog(pframe, "Membership deactivated.");
                                } else {
                                    JOptionPane.showMessageDialog(pframe, "Member not found.","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(pframe, "Enter valid Member ID.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        // Mark Attendance
                markButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    try {
                    int id = Integer.parseInt(idField.getText());
                    GymMember member = findMemberById(id);
                    if (member != null) {
                        if (member.getActiveStatus()) {
                            member.markAttendance();
                            JOptionPane.showMessageDialog(pframe, "Attendance marked.");
                        } else {
                            JOptionPane.showMessageDialog(pframe, "Membership is not active.","Error",JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(pframe, "Member not found.","Error",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(pframe, "Enter valid Member ID.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //clear button
        clearButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                idField.setText("");
                nameField.setText("");
                locationField.setText("");
                phoneField.setText("");
                emailField.setText("");
                trainerField.setText("");
                paidField.setText("");
                maleButton.setSelected(false);
                femaleButton.setSelected(false);
                amountField.setText("50000");
            }
        });

        //making the frame visible
        pframe.setVisible(true);
}        
}
