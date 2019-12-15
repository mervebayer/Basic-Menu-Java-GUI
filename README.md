# Basic-Menu-Java-GUI

When the program executes, a menu will appear (the menu must be displayed
as JFrame). Then the user selects the following:
 //Select the size of the beverage from a JComboBox (Small, Medium or
Large).
 //Select the type of beverage from a JRadioButton group (Juice, Water,
Tea or Cofee).
 -If Juice is selected, a JOptionPane must appear and from a dropdown
menu, the user must choose one of Apple, Orange or Pineapple.
 -If Water is selected, a JOptionPane must appear and asks if the user
wants ice.
 -If Tea is selected, a JOptionPane must appear and asks if the user
wants sugar.
 -If Coffee is selected, a JOptionPane must appear and asks if the user
wants milk.
 Enter the number of glasses in a JTextField.

If the beverage type or amount is not entered, a message that warns the user
must pop up.
After selection, the user must click on Add button, which adds the selected
beverage to an ArrayList and displays a report (i.e. "Two glass(es) of water
with ice added."). Use beverages' toString() methods to show this report. After
adding one or more beverages, the user must click on Order button, which first
displays ordered beverages and their prices, then total price using JOptionPane.
Every beverage has a different price. If the beverage has an extra (such as
sugar, milk or ice), then the price must be higher. Different juices must have
different prices. Also prices must change according to the beverage's size.
