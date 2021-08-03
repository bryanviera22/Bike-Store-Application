/*This GUI is a program designed to offer an online bike
 * store- it offers different bikes from several brands and
 * takes online payment and shipping
 */

  import javax.swing.JFrame;
  import java.awt.BorderLayout;
  import javax.swing.JLabel;
  import javax.swing.JComboBox;
  import javax.swing.JPanel;
  import javax.swing.ImageIcon;
  import java.awt.GridLayout;
  import javax.swing.JRadioButton;
  import javax.swing.ButtonGroup;
  import javax.swing.JCheckBox;
  import javax.swing.JTextField;
  import javax.swing.JButton;
  import java.awt.Color;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  import javax.swing.JOptionPane;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.Statement;
  import java.sql.SQLException;
  import java.io.File;
  import java.io.FileWriter;
  import java.io.IOException;
  
  public class BikeStoreApp extends JFrame implements ActionListener {//class
    
    private JLabel bikeBrandLabel, bikeTypeLabel, frameSizeLabel, wheelSizeLabel, specializedLabel, trekLabel, scottLabel,
       bikeModelLabel, specificationsLabel, suspensionLabel, mountainLabel, roadLabel, driveTrainLabel, brakeLabel, sOptionLabel, 
      keepLabel, noFeeLabel, locationLabel, zipLabel, shippingAddressLabel, streetLabel, cityLabel, stateLabel, zipLabel2, phoneLabel,
      billingInfoLabel, creditDebitLabel, cardsLabel, holderLabel, cardNumberLabel, expirationLabel, cvvLabel,
      eLabel, eLabel2, eLabel3, eLabel4, eLabel5, eLabel6, eLabel7, eLabel8, eLabel9, eLabel10, eLabel11, eLabel12,
      eLabel13, eLabel14, eLabel15, eLabel16, eLabel17, eLabel18, eLabel19, eLabel20, eLabel21, eLabel22, eLabel23, eLabel24,
      eLabel25, eLabel26, eLabel27, eLabel28, eLabel29, eLabel30, eLabel31, eLabel32, eLabel33, eLabel34, eLabel35, eLabel36,
      eLabel37, eLabel38, eLabel39, eLabel40;
    private JComboBox brandBox, typeBox, frameBox, wheelBox, modelBox, mSuspensionBox, rForkBox, sramDriveBox, shimanoDriveBox,
      sramBrakeBox, shimanoBrakeBox, stateBox;
    private JPanel northPanelImages, northPanel, northPanel2, mainNPanel, westPanel, mainWestPanel, westPanel2, westPanel3, eastPanel, 
      eastPanel2, mainEastPanel, southPanel;
    private ImageIcon specializedIcon, trekIcon, scottIcon, cardsIcon;
    private JRadioButton sramDriveButton, shimanoDriveButton, sramBrakeButton, shimanoBrakeButton, pickUpButton, deliveryButton;
    private ButtonGroup driveTrainGroup, brakeGroup, shippingMethodGroup;
    private JCheckBox tryBox;
    private JTextField zipCodeField, streetField, cityField, myZipField, phoneField, holderField, cardNumberField, expirationField;
    private JButton reviewButton, placeOrderButton, clearButton;
    
    public BikeStoreApp () {// constructor
      
      super("Bryan's Online Bike Store");
      
      //northPanel
      bikeBrandLabel = new JLabel ("Bike Brand");
      String brandList [] = {"--Brand--", "Specialized", "Trek", "Scott"};
      brandBox = new JComboBox(brandList);
         bikeTypeLabel = new JLabel ("Bike Type");
         String typeList [] = {"--Category--", "Mountain" , "Road"};
         typeBox = new JComboBox(typeList);
              bikeModelLabel = new JLabel("Bike Model");
              String bikeModel [] = {"--Model--frame only", "MOUNTAIN*", "--Specialized--", "Fuze $600", "Stumpjumper $1,274", " ", "--Trek--", "Roscoe 8 $599", 
              "Fuel EX 9.7 $2,675", " ", "Scott", "Scale RC 900 $1,800", "Spark RC $3,456", " ", "ROAD*", "--Specialized--", "Base E5 $775", 
                "Comp Carbon $2,080","More Coming Soon..."};
              modelBox = new JComboBox(bikeModel);
                  frameSizeLabel = new JLabel ("Frame Size(Height = H & Size = SZ)");
                  String frameList [] = {"--Size--", "MOUNTAIN*", "H- 5`2/5`6 SZ = Small", "H- 5`6/5`10 SZ = Medium", "H- 5`10/6`1 SZ = Large",
                                                  "    ", "ROAD*", "H- 5`3/5`6 SZ = Small", "H- 5`6/5`9 SZ = Medium", "H- 5`9/6`0 SZ = Lage"};
               frameBox = new JComboBox(frameList);
                         wheelSizeLabel = new JLabel ("Wheel Size");
                         String wheelSizeList [] = {"--Size--", "MOUNTAIN*", " 26 ", " 27,5 ", " 29 ",
                              "    ", "ROAD*", " 26 = 559mm ", " 650c = 571mm "," 27.5/650b = 584mm ", " 29/700c = 622mm ", " 27 = 630mm"};
                         wheelBox = new JComboBox(wheelSizeList);
       
                         
      northPanelImages = new JPanel();
      specializedIcon = new ImageIcon("specialized.jpg");
      specializedLabel = new JLabel(specializedIcon);
           trekIcon = new ImageIcon("trek.png");
           trekLabel = new JLabel(trekIcon);
                 scottIcon = new ImageIcon("scott.jpg");
                 scottLabel = new JLabel(scottIcon);
      northPanelImages.add(specializedLabel);
      northPanelImages.add(trekLabel);
      northPanelImages.add(scottLabel);
                         
      northPanel = new JPanel();
        northPanel.add(bikeBrandLabel);
        northPanel.add(brandBox);
            northPanel.add(bikeTypeLabel);
            northPanel.add(typeBox);
               northPanel.add(bikeModelLabel);
               northPanel.add(modelBox);
       
       mainNPanel = new JPanel();
       mainNPanel.setLayout(new BorderLayout());
       mainNPanel.add(northPanelImages,  BorderLayout.NORTH);
       mainNPanel.add(northPanel, BorderLayout.CENTER);
       
       northPanel2 = new JPanel();
                northPanel2.add(frameSizeLabel);
                northPanel2.add(frameBox);
                     northPanel2.add(wheelSizeLabel);
                     northPanel2.add(wheelBox);
      mainNPanel.add(northPanel2, BorderLayout.SOUTH);
      add(mainNPanel, BorderLayout.NORTH);
      
      
      //westPanel
      eLabel = new JLabel(" ");
      specificationsLabel = new JLabel("Specifications");
      specificationsLabel.setForeground(Color.BLUE);
      eLabel2 = new JLabel(" ");
      
      eLabel3 = new JLabel(" ");
      suspensionLabel = new JLabel("  Suspension");
      suspensionLabel.setForeground(Color.RED);
      eLabel4 = new JLabel(" ");
      
      mountainLabel =new JLabel("  Mountain");
      eLabel5 = new JLabel(" ");
      roadLabel = new JLabel("  Road");
      
      String mSuspensionList [] = {"--Select Type--", "Fox", "RockShok"};
      mSuspensionBox = new JComboBox(mSuspensionList);
      eLabel6 = new JLabel(" ");
      String rForkList [] = {"--Select Type--", "Alloy", "Carbon"};
      rForkBox = new JComboBox(rForkList);
      
      eLabel7 = new JLabel(" ");
      driveTrainLabel = new JLabel("   Drivetrain");
      driveTrainLabel.setForeground(Color.RED);
      eLabel8 = new JLabel(" ");
      sramDriveButton = new JRadioButton("SRAM");
      eLabel9 = new JLabel(" ");
      shimanoDriveButton = new JRadioButton("Shimano");
      driveTrainGroup = new ButtonGroup();
      driveTrainGroup.add(sramDriveButton);
      driveTrainGroup.add(shimanoDriveButton);
      String sramDriveList [] = {"--Select Model--", "MOUNTAIN*", "X7 $180.50", "X9 $215.69",  "NX Eagle $375.00", " ",
      "ROAD*", "Rival 22 $760.26", "Force 1 $980.64", "Force 22 $1050.33"};
      sramDriveBox = new JComboBox(sramDriveList);
      eLabel10 = new JLabel(" ");
      String shimanoDriveList [] = {"--Select Model--", "MOUNTAIN*", "SLX $203", "Deore XT $364", "XTR $425", " ",
        "ROAD*", "Shimano 105 $349", "Ultegra $360", "Dura-Ace $1250"};
      shimanoDriveBox = new JComboBox(shimanoDriveList);
      
      eLabel11 = new JLabel(" ");
      brakeLabel = new JLabel("    Brakes");
      brakeLabel.setForeground(Color.RED);
      eLabel12 = new JLabel(" ");
      sramBrakeButton = new JRadioButton("SRAM");
      eLabel13 = new JLabel(" ");
      shimanoBrakeButton = new JRadioButton("Shimano");
      brakeGroup = new ButtonGroup();
      brakeGroup.add(sramBrakeButton);
      brakeGroup.add(shimanoBrakeButton);
      String sramBrakeList [] = {"--Select Type--", "Mechanical Rim $115", "Hydraulic Rim $158", "Mechanical Disk $127", 
        "Hydraulic Disk $205"};
      sramBrakeBox = new JComboBox(sramBrakeList);
      eLabel14 = new JLabel(" ");
      String shimanoBrakeList [] = {"--Select Type--", "Mechanical Rim $110", "Hydraulic Rim $155", "Mechanical Disk $135", 
        "Hydraulic Disk $175"};
      shimanoBrakeBox = new JComboBox(shimanoBrakeList);
                                            
      westPanel = new JPanel();
      westPanel.setLayout(new GridLayout(10, 3));
      
      westPanel.add(eLabel);
      westPanel.add(specificationsLabel);
      westPanel.add(eLabel2);
      
      westPanel.add(eLabel3);
      westPanel.add(suspensionLabel);
      westPanel.add(eLabel4);
      
      westPanel.add(mountainLabel);
      westPanel.add(eLabel5);
      westPanel.add(roadLabel);
      
      westPanel.add(mSuspensionBox);
      westPanel.add(eLabel6);
      westPanel.add(rForkBox);
      
      westPanel.add(eLabel7);
      westPanel.add(driveTrainLabel);
      westPanel.add(eLabel8);
      
      westPanel.add(sramDriveButton);
      westPanel.add(eLabel9);
      westPanel.add(shimanoDriveButton);
      westPanel.add(sramDriveBox);
      westPanel.add(eLabel10);
      westPanel.add(shimanoDriveBox);
      
      westPanel.add(eLabel11);
      westPanel.add(brakeLabel);
      westPanel.add(eLabel12);
      
      westPanel.add(sramBrakeButton);
      westPanel.add(eLabel13);
      westPanel.add(shimanoBrakeButton);
      westPanel.add(sramBrakeBox);
      westPanel.add(eLabel14);
      westPanel.add(shimanoBrakeBox);
      
      mainWestPanel = new JPanel();
      mainWestPanel.add(westPanel, BorderLayout.NORTH);
      add(mainWestPanel, BorderLayout.WEST);
      
      //eastPanel
      eLabel15 = new JLabel(" ");
      sOptionLabel = new JLabel("Shipping Method");
      sOptionLabel.setForeground(Color.BLUE);
      eLabel16 = new JLabel(" ");
      /*
      tryBox = new JCheckBox("**Try Before You Buy**");
      keepLabel = new JLabel("     *Keep It For a Week");
      noFeeLabel = new JLabel("No Extra Fees!!!*    ");
      */
      pickUpButton = new JRadioButton("PICK UP");
      eLabel17 = new JLabel(" ");
      eLabel18 = new JLabel(" ");
      deliveryButton = new JRadioButton("DELIVERY");
      shippingMethodGroup = new ButtonGroup();
      locationLabel = new JLabel("Choose Location ");
      zipLabel = new JLabel("Use Zip Code");
      zipCodeField = new JTextField(7);
      shippingMethodGroup.add(pickUpButton);
      shippingMethodGroup.add(deliveryButton);
      eLabel19= new JLabel(" ");
      eLabel20= new JLabel(" ");
      eLabel21= new JLabel(" ");
      shippingAddressLabel = new JLabel("Shipping Address");
      eLabel22= new JLabel(" ");
      streetLabel = new JLabel("Street: ");
      streetField = new JTextField(10);
      eLabel23 = new JLabel(" ");
      cityLabel = new JLabel("City: ");
      cityField = new JTextField(10);
      eLabel24 = new JLabel(" ");
      stateLabel = new JLabel("State: ");
      String stateList [] = {"Select State", "VA", "DC", "MD", "NC", "..."};
      stateBox = new JComboBox(stateList);
      eLabel25 = new JLabel(" ");
      zipLabel2 = new JLabel("Zip Code: ");
      myZipField = new JTextField(10);
      eLabel26 = new JLabel(" ");
      phoneLabel = new JLabel("Phone: ");
      phoneField = new JTextField(10);
      eLabel27 = new JLabel(" ");
      eLabel28 = new JLabel(" ");
      eLabel29 = new JLabel(" ");
      eLabel30 = new JLabel(" ");
      eLabel31 = new JLabel(" ");
      billingInfoLabel = new JLabel("Your Billing Information");
      eLabel37 = new JLabel(" ");
      eLabel38 = new JLabel(" ");
      eLabel39 = new JLabel(" ");
      billingInfoLabel.setForeground(Color.BLUE);
      eLabel32 = new JLabel(" ");
      creditDebitLabel = new JLabel("Credit & Debit Cards:");
      cardsIcon = new ImageIcon("cards.png");
      cardsLabel = new JLabel(cardsIcon);
      eLabel33 = new JLabel(" ");
      holderLabel = new JLabel("Cardholder Name:");
      holderField = new JTextField(10);
      eLabel34 = new JLabel(" ");
      cardNumberLabel = new JLabel("Card Number:");
      cardNumberField = new JTextField(10);
      eLabel35 = new JLabel(" ");
      expirationLabel = new JLabel("End Date: (mm/yyyy)");
      expirationField = new JTextField(10);
      eLabel36 = new JLabel(" ");
      
      eastPanel = new JPanel();
      eastPanel.setLayout(new GridLayout(17, 3));
      
      eastPanel.add(eLabel15);
      eastPanel.add(sOptionLabel);
      eastPanel.add(eLabel16);
      
      /*
      eastPanel.add(tryBox);
      eastPanel.add(keepLabel);
      eastPanel.add(noFeeLabel);
      */
      
      eastPanel.add(pickUpButton);
      eastPanel.add(locationLabel);
      eastPanel.add(eLabel17);
           
      eastPanel.add(zipLabel);
      eastPanel.add(zipCodeField);
      eastPanel.add(eLabel18);
      
      eastPanel.add(eLabel19);
      eastPanel.add(eLabel20);
      eastPanel.add(eLabel21);
      
      eastPanel.add(deliveryButton);
      eastPanel.add(shippingAddressLabel);
      eastPanel.add(eLabel22);
      
      eastPanel.add(streetLabel);
      eastPanel.add(streetField);
      eastPanel.add(eLabel23);
      
      eastPanel.add(cityLabel);
      eastPanel.add(cityField);
      eastPanel.add(eLabel24);
      
      eastPanel.add(stateLabel);
      eastPanel.add(stateBox);
      eastPanel.add(eLabel25);
      
      eastPanel.add(zipLabel2);
      eastPanel.add(myZipField);
      eastPanel.add(eLabel26);
      
      eastPanel.add(phoneLabel);
      eastPanel.add(phoneField);
      eastPanel.add(eLabel27);
      
      eastPanel.add(eLabel28);
      eastPanel.add(eLabel29);
      eastPanel.add(eLabel30);
       
      eastPanel.add(eLabel31);
      eastPanel.add(billingInfoLabel);
      eastPanel.add(eLabel32);
      
      eastPanel.add(eLabel37);
      eastPanel.add(eLabel38);
      eastPanel.add(eLabel39);
     
      eastPanel.add(creditDebitLabel);
      eastPanel.add(cardsLabel);
      eastPanel.add(eLabel33);
      
     eastPanel.add(holderLabel);
     eastPanel.add(holderField);
     eastPanel.add(eLabel34);
     
     eastPanel.add(cardNumberLabel);
     eastPanel.add(cardNumberField);
     eastPanel.add(eLabel35);
     
     eastPanel.add(expirationLabel);
     eastPanel.add(expirationField);
     eastPanel.add(eLabel36);
     
     mainEastPanel = new JPanel();
     mainEastPanel.add(eastPanel, BorderLayout.NORTH);
     add(mainEastPanel, BorderLayout.EAST);
     
        //southPanel
     reviewButton = new JButton("Review Order");
     reviewButton.addActionListener(this);
     placeOrderButton = new JButton("Place Order");
     placeOrderButton.addActionListener(this);
     clearButton = new JButton("Clear");
     southPanel = new JPanel();
        southPanel.add(reviewButton);
        southPanel.add(placeOrderButton);
        southPanel.add(clearButton);
     add(southPanel, BorderLayout.SOUTH);
                                
                                
      setVisible(true);
      setSize(1100, 750);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } //end of constuctor
    
    //Event Handler
    public void actionPerformed(ActionEvent event) {
      
      if(event.getSource() == reviewButton) { //if review bottom is clicked
        
        String cardNumber = cardNumberField.getText(); //retrive input from JTextField
        String expiration = expirationField.getText(); //retrieve input from JTextField
        
        try {//try block begins
          if(cardNumber.equals("")){
           throw new cardException(); 
          }//end of if statement
        
        String bikeBrand = brandBox.getSelectedItem().toString(); //retrieve info from JComboBox
        String bikeType = typeBox.getSelectedItem().toString();  //retrieve info from JComboBox
        String model = modelBox.getSelectedItem().toString(); 
        String frame = frameBox.getSelectedItem().toString();
        String wheels = wheelBox.getSelectedItem().toString();
        
        
        String shippingMethod = ""; //retrive info from radioButtons
        if(pickUpButton.isSelected()){
          shippingMethod = "Pick Up";
        }
        else if(deliveryButton.isSelected()){
          shippingMethod = "Delivery";
        }
               
        //Create output
        String output = "ONLINE BIKE STORE \n" +
                                "\n**Order Review**" +
                                "\nBike Brand: " + bikeBrand +
                                "\nBike Type: " + bikeType +
                                "\nFrame Model: " + model +
                                "\nFrame Size: " + frame +
                                "\nWheels Size: " + wheels +
                                "\n\n**Shipping Method**" +
                                "\nType: " + shippingMethod +
                                "\n\n**Payment Information**" +
                                "\nCard Number: " + cardNumber +
                                "\nExpiration Date: " + expiration;  
        
        //Show output in a pop-up box
        JOptionPane.showMessageDialog(null, output);
        }//end of try block for card exception
        
        catch(cardException e){
         JOptionPane.showMessageDialog(null, e.getMessage()); 
        }//end of catch block for exception e
        
      }// end of review Button     
      
         if(event.getSource() == placeOrderButton) {// place order button
           
        String bikeBrand = brandBox.getSelectedItem().toString(); //retrieve info from JComboBox
        String bikeType = typeBox.getSelectedItem().toString();  //retrieve info from JComboBox
        String model = modelBox.getSelectedItem().toString(); 
        String frame = frameBox.getSelectedItem().toString();
        String wheels = wheelBox.getSelectedItem().toString();
        
        String shippingMethod = ""; //retrive info from radioButtons
        if(pickUpButton.isSelected()){
          shippingMethod = "Pick Up";
        }
        else if(deliveryButton.isSelected()){
          shippingMethod = "Delivery";
        }
          
         File bikeStoreFile = new File("OrderInformation.txt");
         
         String URL = "jdbc:mysql://localhost/bikestore?user=root&password=";
           
         try{
         
         FileWriter writer = new FileWriter(bikeStoreFile);
                  
         Class.forName("com.mysql.jdbc.Driver");
         //System.out.println("Yes");
         Connection conn = DriverManager.getConnection(URL);
         //System.out.println("Yes");
         
         String sql_statement = "insert into bike(brand, type, model_by_brand, frame_size, wheel_size)" +
                                               "values ('" + bikeBrand + "', '" + bikeType + "', '" + model + "', '" + frame + "', '" + wheels + "');";
         //System.out.println(sql_statement);
         
         Statement stmt = conn.createStatement();
         
         stmt.execute(sql_statement);
         
         writer.write("**Receipt**");
         writer.write("\nBike Brand: " + bikeBrand);
         writer.write("\nBike Type: " + bikeType);
         writer.write("\nFrame Model: " + model);
         writer.write("\nFrame Size: " + frame);
         writer.write("\nWheels Size: " + wheels);
         writer.write("\nShipping: " + shippingMethod);
         
         writer.close(); //close the OrderInformation.txt file
         
         }//end of try block
         
         catch(ClassNotFoundException e) {
        e.printStackTrace(); 
        }
         catch(SQLException sqlE) {
          sqlE.printStackTrace(); 
         }
         catch(IOException ieo) {
          ieo.printStackTrace(); 
         }
               
        //Create output
        String output = "ONLINE BIKE STORE" +
                                "\n\n**Receipt**" +
                                "\nBike Brand: " + bikeBrand +
                                "\nBike Type: " + bikeType +
                                "\nFrame Model: " + model +
                                "\nFrame Size: " + frame +
                                "\nWheels Size: " + wheels +
                                "\n\n**Shipping Method**" +
                                "\nType: " + shippingMethod;
        
        //Show output in a pop-up box
        JOptionPane.showMessageDialog(null, output);          
           
         }// end of place order button

      
      
    }//end of actionPerformed Method
        
    
    
    
    public static void main(String [] args) { //main method
      BikeStoreApp app = new BikeStoreApp(); 
    }//end of main method
    
    
  }// end of class