
import java.awt.*;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ConvertFrame extends JFrame
{
   private JRadioButton FromdollarRadioButton;
   private JRadioButton FrompesoRadioButton;
   private JRadioButton FromeuroRadioButton;
   private JRadioButton TodollarRadioButton;
   private JRadioButton TopesoRadioButton;
   private JRadioButton ToeuroRadioButton;
   private JLabel convertFrom;
   private JLabel enterCurrency;
   private JLabel convertTo;
   private JLabel comparableCurrency;
   private JTextField userJTextField;
   private JTextField convertedJTextField;


   public ConvertFrame()
   {
      super("Currency Conversion");

      // Creates Menu Items
      JMenu fileMenu = new JMenu("File");
      fileMenu.setMnemonic('F');
       JMenuItem aboutItem = new JMenuItem("About");
       aboutItem.setMnemonic('a');
      JMenuItem convertItem = new JMenuItem("Convert");
      convertItem.setMnemonic('C');
      JMenuItem exitItem = new JMenuItem("Exit");
      exitItem.setMnemonic('e');
      JMenuItem clearItem = new JMenuItem("Clear");
      clearItem.setMnemonic('c');

       // Setup exit action
       exitItem.addActionListener(new ExitHandler());
       convertItem.addActionListener(new ConversionHandler());
       aboutItem.addActionListener(new AboutHandler());
       clearItem.addActionListener(new ClearHandler());

      // Adding items to menu
       fileMenu.add(aboutItem);
       fileMenu.add(convertItem);
       fileMenu.add(clearItem);
       fileMenu.add(exitItem);


      // Menu bar initialization
      JMenuBar bar = new JMenuBar();
      bar.add(fileMenu);
      setJMenuBar(bar);

      // Icon group above from

       Icon dollar = new ImageIcon(getClass().getResource("dollar.jpg"));
       Icon peso = new ImageIcon(getClass().getResource("peso.jpg"));
       Icon euro = new ImageIcon(getClass().getResource("euro.jpg"));
       JLabel dollarLabelFrom = new JLabel(dollar, SwingConstants.LEFT);
       JLabel pesoLabelFrom = new JLabel(peso, SwingConstants.LEFT);
       JLabel euroLabelFrom = new JLabel(euro, SwingConstants.LEFT);
       JPanel fromIconJPanel = new JPanel();
       //Grid layout for Icon
       fromIconJPanel.setLayout(new GridLayout(1, 3));
       fromIconJPanel.add(dollarLabelFrom);
       fromIconJPanel.add(pesoLabelFrom);
       fromIconJPanel.add(euroLabelFrom);

      // Button group for from currency selection
      FromdollarRadioButton = new JRadioButton("Dollar", true);
      FrompesoRadioButton = new JRadioButton("Peso", false);
      FromeuroRadioButton = new JRadioButton("Euro", false);
      ButtonGroup fromButtonGroup = new ButtonGroup();
      fromButtonGroup.add(FromdollarRadioButton);
      fromButtonGroup.add(FrompesoRadioButton);
      fromButtonGroup.add(FromeuroRadioButton);

      // Icon group for from currency
       dollar = new ImageIcon(getClass().getResource("dollar.jpg"));
       peso = new ImageIcon(getClass().getResource("peso.jpg"));
       euro = new ImageIcon(getClass().getResource("euro.jpg"));
       JLabel dollarLabelTo = new JLabel(dollar, SwingConstants.LEFT);
       JLabel pesoLabelTo = new JLabel(peso, SwingConstants.LEFT);
       JLabel euroLabelTo = new JLabel(euro, SwingConstants.LEFT);
       JPanel toIconJPanel = new JPanel();
       toIconJPanel.setLayout(new GridLayout(1,3));
       toIconJPanel.add(dollarLabelTo);
       toIconJPanel.add(pesoLabelTo);
       toIconJPanel.add(euroLabelTo);


      //Button group for to currency
      TodollarRadioButton = new JRadioButton("Dollar", true);
      TopesoRadioButton = new JRadioButton("Peso", false);
      ToeuroRadioButton = new JRadioButton("Euro", false);
      ButtonGroup toButtonGroup = new ButtonGroup();
      toButtonGroup.add(TodollarRadioButton);
      toButtonGroup.add(TopesoRadioButton);
      toButtonGroup.add(ToeuroRadioButton);

      // JPanel
      JPanel fromJPanel = new JPanel();
      fromJPanel.setLayout(new GridLayout(1, 3));
      fromJPanel.add(FromdollarRadioButton);
      fromJPanel.add(FrompesoRadioButton);
      fromJPanel.add(FromeuroRadioButton);

      // JPanel
      JPanel toJPanel = new JPanel();
      toJPanel.setLayout(new GridLayout(1, 3));
      toJPanel.add(TodollarRadioButton);
      toJPanel.add(TopesoRadioButton);
      toJPanel.add(ToeuroRadioButton);

      // Create labels for program
      convertFrom = new JLabel("Convert from: ");
      convertTo = new JLabel("Convert to: ");
      enterCurrency = new JLabel("Enter Currency: ");
      comparableCurrency = new JLabel("Comparable Currency is: ");

      // User entered text field
      userJTextField = new JTextField(10);
      userJTextField.setText("");

      // Event Handling
      ConversionHandler handler = new ConversionHandler();
      userJTextField.addActionListener(handler);

      // Post conversion display
      convertedJTextField = new JTextField(10);
      convertedJTextField.setBackground(Color.gray);
      convertedJTextField.setEditable(false);

      // Button of Convert, Clear and Exit
      JButton convertButton = new JButton("Convert");
      JButton clearButton = new JButton("Clear");
      JButton exitButton = new JButton("Exit");

      // Action setup
      convertButton.addActionListener(new ConversionHandler());
      clearButton.addActionListener(new ClearHandler());
      exitButton.addActionListener(new ExitHandler());

      // Bottom buttons layout
      JPanel bottomButtonGroup = new JPanel();
      bottomButtonGroup.setLayout(new GridLayout(1,3));
      bottomButtonGroup.add(convertButton);
      bottomButtonGroup.add(clearButton);
      bottomButtonGroup.add(exitButton);

      // Add components to GUI
      setLayout(new GridLayout(11, 1));
      add(convertFrom);
      add(fromIconJPanel);
      add(fromJPanel);
      add(userJTextField);
      add(toIconJPanel);
      add(toJPanel);
      add(convertedJTextField);
      add(bottomButtonGroup);
   }

   private class ConversionHandler implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent event) {
         double convertCurr = 0.0; int userCurr; String result = "";

         userCurr = Integer.parseInt(userJTextField.getText());

         // Dollar to Dollar
         if(FromdollarRadioButton.isSelected() && TodollarRadioButton.isSelected()){
            convertCurr = userCurr;
            convertCurr = round(convertCurr, 2);
            result = "US Dollar to US Dollar ";
         }

         // Dollar to Peso
         else if (FromdollarRadioButton.isSelected() && TopesoRadioButton.isSelected()){
            convertCurr = userCurr * 20.17;
            convertCurr = round(convertCurr, 2);
            result = "US Dollar to Mexican Peso ";
         }

         // Dollar to Euro
         else if (FromdollarRadioButton.isSelected() && ToeuroRadioButton.isSelected()){
            convertCurr = userCurr * 0.93;
            convertCurr = round(convertCurr, 2);
            result = "US Dollar to Euro ";
         }

         // Peso to dollar
         else if (FrompesoRadioButton.isSelected() && TodollarRadioButton.isSelected()){
            convertCurr = userCurr * 0.050;
            convertCurr = round(convertCurr, 2);
            result = "Mexican Peso to US Dollar ";
         }

         // Peso to peso
         else if (FrompesoRadioButton.isSelected() && TopesoRadioButton.isSelected()){
            convertCurr = userCurr;
            convertCurr = round(convertCurr, 2);
            result = "Mexican Peso to Mexican Peso ";

         }

         // Peso to euro
         else if (FrompesoRadioButton.isSelected() && ToeuroRadioButton.isSelected()){
            convertCurr = userCurr * 0.046;
            convertCurr = round(convertCurr, 2);
            result = "Mexican Peso to Euro ";
         }

         // Euro to Dollar
         else if (FromeuroRadioButton.isSelected() && TodollarRadioButton.isSelected()){
            convertCurr = userCurr * 1.072;
            convertCurr = round(convertCurr, 2);;
            result = "Euro to US Dollar ";
         }

         // Euro to Peso
         else if (FromeuroRadioButton.isSelected() && TopesoRadioButton.isSelected()){
            convertCurr = userCurr * 21.62;
            convertCurr = round(convertCurr, 2);
            result = "Euro to Mexican Peso ";
         }

         // Euro to Euro
         else if (FromeuroRadioButton.isSelected() && ToeuroRadioButton.isSelected()){
            convertCurr = userCurr;
            convertCurr = round(convertCurr, 2);
            result = "Euro to Euro ";
         }

         convertedJTextField.setText(String.valueOf(convertCurr));
         convertedJTextField.setBackground(Color.yellow);
         result += "\n" + userCurr + "  to \t\t  " + convertCurr + " ";
         JOptionPane.showMessageDialog(ConvertFrame.this, result, "Converted Currency", JOptionPane.INFORMATION_MESSAGE);
      }
   }

   private class ClearHandler implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent event){
         userJTextField.setText("");
         convertedJTextField.setText("");
         convertedJTextField.setBackground(Color.gray);
      }
   }

   private static class ExitHandler implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent event){
         // Initialize JFrame
         JFrame messageFrame = new JFrame();
         messageFrame.setTitle("Exit dialog");
         messageFrame.setLayout(new GridLayout(2,2));


         //Are you sure Exit Pop up detail
          Icon question = new ImageIcon(getClass().getResource("Question.jpg"));
          JLabel innerImageLabel = new JLabel(question, SwingConstants.CENTER);
          JLabel innerTextLabel = new JLabel("Are you sure?");

         // Creating buttons for exit
         JButton yesButton = new JButton("Yes");
         JButton noButton = new JButton("No");

         // Button Actions for exit
         yesButton.addActionListener(e -> System.exit(0));
         noButton.addActionListener(e -> messageFrame.setVisible(false));

         // Creating button panels for exit
         JPanel yesPanel = new JPanel();
         yesPanel.add(yesButton);
         JPanel noPanel = new JPanel();
         yesPanel.add(noButton);

         // Adding components for exit
          messageFrame.add(innerImageLabel);
          messageFrame.add(innerTextLabel);
         messageFrame.add(yesPanel);
         messageFrame.add(noPanel);
         messageFrame.setVisible(true);
         messageFrame.setSize(300,200);
      }
   }

   private class AboutHandler implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent event){
         String message = """
                    Seunghyun Kim
                    Project 4
                    Currency Conversion""";
         JOptionPane.showMessageDialog(ConvertFrame.this, message, "About", JOptionPane.INFORMATION_MESSAGE);
      }
   }
    public static double round(double value, int places){
        if(places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.UP);
        return bd.doubleValue();
   }}
