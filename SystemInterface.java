import java.awt.event.*;  
import javax.swing.*;    
public class SystemInterface { 
   public static void main(String[] args) {
   
      JFrame window =new JFrame("Leave System"); 
      window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
      window.setVisible(true);
      window.setSize(400,400);  
      window.setLayout(null);  
      final JTextField tf=new JTextField();  
      tf.setBounds(50,50, 150,20); 
      window.add(tf);
      logInScreen(window);
       
   }
  
   public static void logInScreen(JFrame window)
   {
      window.getContentPane().removeAll();
      window.repaint();
     
   
      final JTextField usernameBox=new JTextField();  
      usernameBox.setBounds(50,50, 150,20); 
      window.add(usernameBox);
      final JTextField passwordBox=new JTextField();  
      passwordBox.setBounds(50,100, 150,20); 
      window.add(passwordBox);
      
      
      
      JButton logInButton=new JButton("Login");  
      logInButton.setBounds(50,150,95,30);  
      logInButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){
               String password = passwordBox.getText();
               String username = usernameBox.getText();
            
               if(username.equals("Michael") && password.equals("password"));
               {
                  final JTextField tf=new JTextField();  
                  tf.setBounds(50,50, 150,20); 
                  window.add(tf);
               
                  mainMenu(window, tf); 
               } 
            }  
         });
      window.add(logInButton);
      window.repaint();
   }
   
   public static void mainMenu(JFrame window, JTextField tf)
   {
      window.getContentPane().removeAll();
      window.repaint();
      window.add(tf);
      
      JButton employeeButton=new JButton("Employee");  
      employeeButton.setBounds(50,100,95,30);  
      employeeButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               employeeMenu(window, tf);   
            }  
         }
         );  
         
      window.add(employeeButton);
         
      JButton managerButton=new JButton("Manager");  
      managerButton.setBounds(50,150,95,30);  
      managerButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               managerMenu(window, tf);
            }  
         }
         ); 
         
      window.add(managerButton);
         
      JButton executiveButton=new JButton("Executive");  
      executiveButton.setBounds(50,200,95,30);  
      executiveButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               executiveMenu(window, tf);
            }  
         }
         ); 
         
      window.add(executiveButton);
         
      JButton hrButton=new JButton("HR");  
      hrButton.setBounds(50,250,95,30);  
      hrButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               hrMenu(window, tf);                }  
         }
         ); 
         
      window.add(hrButton); 
      
      JButton backButton=new JButton("Back");  
      backButton.setBounds(280,1,80,30);  
      backButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               mainMenu(window, tf);         
            }  
         }
         ); 
      window.add(backButton);  
         
      window.repaint();    
   }
   
   
   

   public static void employeeMenu(JFrame window, JTextField tf)
   {
      window.getContentPane().removeAll();
      window.repaint();
      window.add(tf);
   
      JButton viewMessagesButton=new JButton("View Messages");  
      viewMessagesButton.setBounds(50,100,200,30);  
      viewMessagesButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               tf.setText("MESSAGES");
            }  
         }
         ); 
      window.add(viewMessagesButton);
         
      JButton makeRequestForm=new JButton("Make Request");  
      makeRequestForm.setBounds(50,150,200,30);  
      makeRequestForm.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               tf.setText("MAKE REQUEST");
            }  
         }
         ); 
      window.add(makeRequestForm);
      
      JButton viewRequestMenu=new JButton("View Current Requests");  
      viewRequestMenu.setBounds(50,200,200,30);  
      viewRequestMenu.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               tf.setText("CURRENT REQUESTS");
            }  
         }
         ); 
      window.add(viewRequestMenu);
   
       
      JButton backButton=new JButton("Back");  
      backButton.setBounds(280,1,80,30);  
      backButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               mainMenu(window, tf);         
            }  
         }
         ); 
      window.add(backButton);
       
         
      window.repaint();   
   }



   public static void managerMenu(JFrame window, JTextField tf)
   {
      window.getContentPane().removeAll();
      window.repaint();
      window.add(tf);
   
      JButton viewMessagesButton=new JButton("View Messages");  
      viewMessagesButton.setBounds(50,100,200,30);  
      viewMessagesButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               tf.setText("MESSAGES");
            }  
         }
         ); 
      window.add(viewMessagesButton);
         
              
      JButton viewRequestMenu=new JButton("View Current Requests");  
      viewRequestMenu.setBounds(50,150,200,30);  
      viewRequestMenu.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               tf.setText("CURRENT REQUESTS");
            }  
         }
         ); 
      window.add(viewRequestMenu);
   
       
      JButton backButton=new JButton("Back");  
      backButton.setBounds(280,1,80,30);  
      backButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               mainMenu(window, tf);         
            }  
         }
         ); 
      window.add(backButton);
       
         
      window.repaint();   
   }

   
   public static void executiveMenu(JFrame window, JTextField tf)
   {
      window.getContentPane().removeAll();
      window.repaint();
      window.add(tf);
   
      JButton tempHolidayForm=new JButton("Add Temporary Holiday");  
      tempHolidayForm.setBounds(50,100,200,30);  
      tempHolidayForm.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               tf.setText("Please fill out the form.");
            }  
         }
         ); 
      window.add(tempHolidayForm);
         
      JButton nationalHolidayForm=new JButton("Add/Remove National Holiday");  
      nationalHolidayForm.setBounds(50,150,200,30);  
      nationalHolidayForm.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               tf.setText("Please fill out the form.");
            }  
         }
         ); 
      window.add(nationalHolidayForm);
       
      JButton backButton=new JButton("Back");  
      backButton.setBounds(280,1,80,30);  
      backButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               mainMenu(window, tf);         
            }  
         }
         ); 
      window.add(backButton);
       
         
      window.repaint();   
   }
   
   
   public static void hrMenu(JFrame window, JTextField tf)
   {
      window.getContentPane().removeAll();
      window.repaint();
      window.add(tf);
   
      JButton hireEmployeeForm=new JButton("Hire Employee");  
      hireEmployeeForm.setBounds(50,100,200,30);  
      hireEmployeeForm.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               tf.setText("Hired");
            }  
         }
         ); 
      window.add(hireEmployeeForm);
         
      JButton fireEmployeeForm=new JButton("Fire Employee");  
      fireEmployeeForm.setBounds(50,150,200,30);  
      fireEmployeeForm.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               tf.setText("Fired");
            }  
         }
         ); 
      window.add(fireEmployeeForm);
      
      JButton promoteDemoteEmployeeForm=new JButton("Promote/Demote Employee");  
      promoteDemoteEmployeeForm.setBounds(50,200,200,30);  
      promoteDemoteEmployeeForm.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               tf.setText("Promoted! or Demoted!");
            }  
         }
         ); 
      window.add(promoteDemoteEmployeeForm);
   
       
      JButton backButton=new JButton("Back");  
      backButton.setBounds(280,1,80,30);  
      backButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               mainMenu(window, tf);         
            }  
         }
         ); 
      window.add(backButton);
       
         
      window.repaint();   
   }
        
}

