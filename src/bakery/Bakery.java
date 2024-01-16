/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bakery;

import java.util.Scanner;
import java.sql.*;

/**
 *
 * @author Saksham
 */
class Bakery {

     void addOrder() throws ClassNotFoundException {

          String name = "";
          String item = "";
          int quantity;

          Scanner sc = new Scanner(System.in);

          System.out.println("Enter customer name : ");
          name = sc.nextLine();
          System.out.println("Enter Item Ordered : ");
          item = sc.nextLine();
          System.out.println("Enter Quantity : ");
          quantity = sc.nextInt();
          
          
          Connection con = null;
          ResultSet rs = null;
          PreparedStatement pst = null;
          
          
          
          try {
               
               
               System.out.println("Before Connection");
               Class.forName("com.mysql.cj.jdbc.Driver");
               System.out.println("After Connection");

          
               con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakery", "root", "root");
               con.setAutoCommit(true);

               pst = con.prepareStatement("INSERT INTO bakeryinfo VALUES (?,?,?)");
               
               pst.setString(1, name);
               pst.setString(2, item);
               pst.setInt(3, quantity);
               
               int row = pst.executeUpdate();
               con.commit();

               if(row > 0) System.out.println("Order Added Successfully !!...");
               
          } catch (Exception e) {
          }
          
           finally {
    try {
        if (rs != null) rs.close();
        if (pst != null) pst.close();
        if (con != null) con.close();
    } catch (SQLException e) {
        e.printStackTrace(); // or use a logger to log the exception
    }
}


     }

     public static void main(String args[]) throws ClassNotFoundException{


          char ch;
          int n = 0;
          Bakery b1 = new Bakery();
          System.out.println("Welcome !!...");

          do {

               System.out.println("Press 1 to Add Order\nPress 2 to view your Orders\nPress 3 to Update your Order\nPress 4 to Exit\n");

               Scanner sc = new Scanner(System.in);
               n = sc.nextInt();

               switch (n) {

                    case 1:
                         b1.addOrder();break;
                    case 2:
                         b1.viewOrder();break;
                    case 3:
                         b1.updateOrder();break;
                    case 4:
                         break;
                    default:
                         System.out.println("Wrong Choice");

               }
              

          } while (n != 4);









     }

     private void viewOrder() {
               }

     private void updateOrder() {
            }

}
