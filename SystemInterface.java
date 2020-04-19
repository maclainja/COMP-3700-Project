import java.awt.event.*;  
import javax.swing.*;    
public class SystemInterface { 

   static int employeeID =33;
   static int supervisorID =44; 


   public static void main(String[] args) {
   
      JFrame window =new JFrame("Leave System"); 
      window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
      window.setVisible(true);
      window.setSize(400,400);  
      window.setLayout(null);  
      final JTextField tf=new JTextField();  
      tf.setBounds(50,50, 150,20); 
      window.add(tf);
      //logInScreen(window);
      //makeRequestForm( window,  tf);
      employeeMenu( window,  tf);
   }
  
   public static void logInScreen(JFrame window)
   {
      window.getContentPane().removeAll();
      window.repaint();
     
      final JLabel usernameLabel = new JLabel("Username:");
      usernameLabel.setBounds(20,50,70,20);
      window.add(usernameLabel);
   
      final JTextField usernameBox=new JTextField();  
      usernameBox.setBounds(110,50, 150,20); 
      window.add(usernameBox);
      
      final JLabel passwordLabel = new JLabel("Password:");
      passwordLabel.setBounds(20,100,70,20);
      window.add(passwordLabel);
   
      
      final JTextField passwordBox=new JTextField();  
      passwordBox.setBounds(110,100, 150,20); 
      window.add(passwordBox);
      
      
      
      JButton logInButton=new JButton("Login");  
      logInButton.setBounds(110,150,95,30);  
      logInButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){
               String password = passwordBox.getText();
               String username = usernameBox.getText();
            
               if(username.equals("Michael") && password.equals("password"))
               {
                  //employeeID = ;
                  //supervisorID =;
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
               logInScreen(window);         
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
               makeRequestForm( window,  tf);
            }  
         }
         ); 
      window.add(makeRequestForm);
      
      JButton viewRequestMenu=new JButton("View Current Requests");  
      viewRequestMenu.setBounds(50,200,200,30);  
      viewRequestMenu.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               employeeCurrentRequests( window, tf);
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



   public static void makeRequestForm(JFrame window, JTextField tf)
   {
      int startYear =2020;
      int startMonth;
      int startDay;
      int endYear =2020;
      int endMonth;
      int endDay;
      Leave leaveType;
   
   
   
   
      window.getContentPane().removeAll();
      window.repaint();
     //window.add(tf);
      
      Integer[] monthDate = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12};
      Integer[] dayFebDate = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28};
      Integer[] dayLeapDate = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29};
      Integer[] dayShortDate = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
      Integer[] dayLongDate = new Integer[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
      Integer[] hourTime = new Integer[] {8,9,10,11,12,13,14,15,16,17};
      Integer[] minuteTime= new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59};
      Integer[] yearDate = new Integer[] {2020};
      
      
            
      
      JButton backButton=new JButton("Back");  
      backButton.setBounds(280,1,80,30);  
      backButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               employeeMenu(window, tf);         
            }  
         }
         ); 
      window.add(backButton);
   
      
      
               
      final JLabel startYearLabel = new JLabel("Start Year:");
      startYearLabel.setBounds(20,50,70,20);
     
      window.add(startYearLabel);
   
      JComboBox<Integer> startYearBox= new JComboBox<>(yearDate);  
      startYearBox.setBounds(110,50, 80,20);
      startYearBox.setVisible(false);
      startYearBox.setVisible(true);
      window.add(startYearBox);
      JButton submitYearButton=new JButton("Submit Year");  
      submitYearButton.setBounds(200,50,150,30);  
      submitYearButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               Integer startYear = (Integer) startYearBox.getSelectedItem();
               final JLabel startYearEntry = new JLabel(Integer.toString(startYear));
               startYearEntry.setBounds(110,50,80,20);
               window.add(startYearEntry);
               window.remove(startYearBox);  
               submitYearButton.setVisible(false);
              
              
               final JLabel startMonthLabel = new JLabel("Start Month:");
               startMonthLabel.setBounds(20,75,70,20);
               startMonthLabel.setVisible(false);
               window.add(startMonthLabel);
            
               JComboBox<Integer> startMonthBox= new JComboBox<>(monthDate);  
               startMonthBox.setBounds(110,75, 50,20); 
               startMonthBox.setVisible(false);
               window.add(startMonthBox);
            
               JButton submitMonthButton=new JButton("Submit Month");  
               submitMonthButton.setBounds(200,75,150,30);  
               submitMonthButton.setVisible(true);
               startMonthBox.setVisible(true);
               startMonthLabel.setVisible(true);
               
               submitMonthButton.addActionListener(
                  new ActionListener(){  
                     public void actionPerformed(ActionEvent e){  
                        Integer startMonth = (Integer) startMonthBox.getSelectedItem();
                        final JLabel startMonthEntry = new JLabel(Integer.toString(startMonth));
                        startMonthEntry.setBounds(110,75,70,20);
                        window.add(startMonthEntry);
                        window.remove(startMonthBox);  
                        submitMonthButton.setVisible(false);
                     
                        if (startMonth == 1 ||startMonth == 3 ||startMonth == 5 ||startMonth == 7 ||startMonth == 8 ||startMonth == 10 ||startMonth == 12 )
                        {
                           JComboBox<Integer> startDayBox = new JComboBox<>(dayLongDate);  
                           startDayBox.setBounds(110,100, 50,20); 
                           startDayBox.setVisible(true);
                           window.add(startDayBox);
                            
                           final JLabel startDayLabel = new JLabel("Start Day:");
                           startDayLabel.setBounds(20,100,70,20);
                           startDayLabel.setVisible(true);
                           window.add(startDayLabel);
                        
                        
                        
                           JButton submitDayButton=new JButton("Submit Day");  
                           submitDayButton.setBounds(200,100,150,30);  
                           submitDayButton.addActionListener(
                              new ActionListener(){  
                                 public void actionPerformed(ActionEvent e){  
                                    Integer startDay = (Integer) startDayBox.getSelectedItem();
                                    final JLabel startDayEntry = new JLabel(Integer.toString(startDay));
                                    startDayEntry.setBounds(110,100,70,20);
                                    window.add(startDayEntry);
                                    window.remove(startDayBox);  
                                    submitDayButton.setVisible(false);
                                 
                                 
                                    JComboBox<Integer>  startHourBox = new JComboBox<>(hourTime);
                                    startHourBox.setBounds(110,125, 50,20); 
                                    startHourBox.setVisible(true);
                                    window.add(startHourBox);
                                 
                                    final JLabel startHourLabel = new JLabel("Start Hour:");
                                    startHourLabel.setBounds(20,125,70,20);
                                    startHourLabel.setVisible(true);
                                    window.add(startHourLabel);
                                 
                                 
                                 
                                 
                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                    submitHourButton.setBounds(200,125,150,30);  
                                    submitHourButton.addActionListener(
                                       new ActionListener(){  
                                          public void actionPerformed(ActionEvent e){  
                                             Integer startHour = (Integer) startHourBox.getSelectedItem();
                                             final JLabel startHourEntry = new JLabel(Integer.toString(startHour));
                                             startHourEntry.setBounds(110,125,70,20);
                                             window.add(startHourEntry);
                                             window.remove(startHourBox);  
                                             submitHourButton.setVisible(false);
                                                                                
                                                                                
                                             JComboBox<Integer>  startMinBox = new JComboBox<>(minuteTime);
                                             startMinBox.setBounds(110,150, 50,20); 
                                             startMinBox.setVisible(true);
                                             window.add(startMinBox);
                                          
                                             final JLabel startMinuteLabel = new JLabel("Start Minute:");
                                             startMinuteLabel.setBounds(20,150,80,20);
                                             startMinuteLabel.setVisible(true);
                                             window.add(startMinuteLabel);
                                          
                                          
                                          
                                          
                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                             submitMinButton.setBounds(200,150,150,30);  
                                             submitMinButton.addActionListener(
                                                new ActionListener(){  
                                                   public void actionPerformed(ActionEvent e){  
                                                      Integer startMinute = (Integer) startMinBox.getSelectedItem();
                                                      final JLabel startMinEntry = new JLabel(Integer.toString(startMinute));
                                                      startMinEntry.setBounds(110,150,70,20);
                                                      window.add(startMinEntry);
                                                      window.remove(startMinBox);  
                                                      submitMinButton.setVisible(false);
                                                   
                                                   
                                                   
                                                      final JLabel endYearLabel = new JLabel("End Year:");
                                                      endYearLabel.setBounds(20,175,70,20);
                                                   
                                                   
                                                      window.add(endYearLabel);
                                                   
                                                      JComboBox<Integer> endYearBox= new JComboBox<>(yearDate);  
                                                      endYearBox.setBounds(110,175, 80,20);
                                                   
                                                   
                                                   
                                                      window.add(endYearBox);
                                                      JButton submitEYearButton=new JButton("Submit Year");  
                                                      submitEYearButton.setBounds(200,175,150,30);  
                                                      submitEYearButton.addActionListener(
                                                         new ActionListener(){  
                                                            public void actionPerformed(ActionEvent e){  
                                                               Integer endYear = (Integer) endYearBox.getSelectedItem();
                                                            
                                                            
                                                               final JLabel endYearEntry = new JLabel(Integer.toString(endYear));
                                                               endYearEntry.setBounds(110,175,80,20);
                                                               window.add(endYearEntry);
                                                               window.remove(endYearBox);  
                                                               submitEYearButton.setVisible(false);
                                                            
                                                            
                                                            
                                                            
                                                            
                                                               final JLabel endMonthLabel = new JLabel("End Month:");
                                                               endMonthLabel.setBounds(20,200,70,20);
                                                               endMonthLabel.setVisible(true);
                                                               window.add(endMonthLabel);
                                                            
                                                               JComboBox<Integer> endMonthBox= new JComboBox<>(monthDate);  
                                                               endMonthBox.setBounds(110,200, 50,20); 
                                                               endMonthBox.setVisible(true);
                                                               window.add(endMonthBox);
                                                            
                                                               JButton submitEMonthButton=new JButton("Submit Month");  
                                                               submitEMonthButton.setBounds(200,200,150,30);  
                                                               submitEMonthButton.addActionListener(
                                                                  new ActionListener(){  
                                                                     public void actionPerformed(ActionEvent e){  
                                                                        Integer endMonth = (Integer) endMonthBox.getSelectedItem();
                                                                     
                                                                        final JLabel endMonthEntry = new JLabel(Integer.toString(endMonth));
                                                                        endMonthEntry.setBounds(110,200,70,20);
                                                                        window.add(endMonthEntry);
                                                                        window.remove(endMonthBox);  
                                                                        submitEMonthButton.setVisible(false);
                                                                     
                                                                        if (endMonth == 1 ||endMonth == 3 ||endMonth == 5 ||endMonth == 7 ||endMonth == 8 ||endMonth == 10 ||endMonth == 12 )
                                                                        {
                                                                           JComboBox<Integer> endDayBox = new JComboBox<>(dayLongDate);  
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint(); 
                                                                                                               
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        }
                                                                        else if (endMonth == 4 ||endMonth == 6 ||endMonth == 9 ||endMonth == 11)
                                                                        {
                                                                           JComboBox<Integer> endDayBox = new JComboBox<>(dayShortDate);
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                        }
                                                                        else if (endMonth == 2 && endYear == 2020)
                                                                        {
                                                                           JComboBox<Integer> endDayBox = new JComboBox<>(dayLeapDate);
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                           //Please  
                                                                        
                                                                        }
                                                                        else 
                                                                        {
                                                                           JComboBox<Integer>  endDayBox = new JComboBox<>(dayFebDate);
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                        }
                                                                     
                                                                     
                                                                     }  
                                                                  }
                                                                  ); 
                                                               window.add(submitEMonthButton);
                                                               submitEMonthButton.setVisible(true);
                                                               window.repaint(); 
                                                            
                                                            
                                                            }  
                                                         }
                                                         ); 
                                                      window.add(submitEYearButton);
                                                      submitEYearButton.setVisible(true);
                                                      window.repaint();  
                                                   
                                                   }  
                                                }
                                                ); 
                                          
                                          
                                             window.add(submitMinButton);
                                             submitMinButton.setVisible(false);
                                             submitMinButton.setVisible(true);
                                             startMinBox.setVisible(true);
                                             window.repaint();  
                                          
                                          
                                          }  
                                       }
                                       ); 
                                       
                                      
                                    window.add(submitHourButton);
                                    submitHourButton.setVisible(false);
                                    submitHourButton.setVisible(true);
                                    startHourBox.setVisible(true);
                                    window.repaint();  
                                 
                                 
                                 
                                 }  
                              }
                              ); 
                           window.add(submitDayButton);
                           submitDayButton.setVisible(false);
                        
                        
                        
                           submitDayButton.setVisible(true);
                        
                        
                           startDayBox.setVisible(true);
                           window.repaint();  
                        
                        
                        
                        
                        
                        
                        
                        }
                        else if (startMonth == 4 ||startMonth == 6 ||startMonth == 9 ||startMonth == 11)
                        {
                           JComboBox<Integer> startDayBox = new JComboBox<>(dayShortDate);
                           startDayBox.setBounds(110,100, 50,20); 
                           startDayBox.setVisible(true);
                           window.add(startDayBox);
                            
                           final JLabel startDayLabel = new JLabel("Start Day:");
                           startDayLabel.setBounds(20,100,70,20);
                           startDayLabel.setVisible(true);
                           window.add(startDayLabel);
                        
                        
                        
                           JButton submitDayButton=new JButton("Submit Day");  
                           submitDayButton.setBounds(200,100,150,30);  
                           submitDayButton.addActionListener(
                              new ActionListener(){  
                                 public void actionPerformed(ActionEvent e){  
                                    Integer startDay = (Integer) startDayBox.getSelectedItem();
                                    final JLabel startDayEntry = new JLabel(Integer.toString(startDay));
                                    startDayEntry.setBounds(110,100,70,20);
                                    window.add(startDayEntry);
                                    window.remove(startDayBox);  
                                    submitDayButton.setVisible(false);
                                 
                                 
                                    window.repaint();  
                                 
                                 
                                 
                                 
                                 
                                 
                                    JComboBox<Integer>  startHourBox = new JComboBox<>(hourTime);
                                    startHourBox.setBounds(110,125, 50,20); 
                                    startHourBox.setVisible(true);
                                    window.add(startHourBox);
                                 
                                    final JLabel startHourLabel = new JLabel("Start Hour:");
                                    startHourLabel.setBounds(20,125,70,20);
                                    startHourLabel.setVisible(true);
                                    window.add(startHourLabel);
                                 
                                 
                                 
                                 
                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                    submitHourButton.setBounds(200,125,150,30);  
                                    submitHourButton.addActionListener(
                                       new ActionListener(){  
                                          public void actionPerformed(ActionEvent e){  
                                             Integer startHour = (Integer) startHourBox.getSelectedItem();
                                             final JLabel startHourEntry = new JLabel(Integer.toString(startHour));
                                             startHourEntry.setBounds(110,125,70,20);
                                             window.add(startHourEntry);
                                             window.remove(startHourBox);  
                                             submitHourButton.setVisible(false);
                                                                                
                                                                                
                                             JComboBox<Integer>  startMinBox = new JComboBox<>(minuteTime);
                                             startMinBox.setBounds(110,150, 50,20); 
                                             startMinBox.setVisible(true);
                                             window.add(startMinBox);
                                          
                                             final JLabel startMinuteLabel = new JLabel("Start Minute:");
                                             startMinuteLabel.setBounds(20,150,70,20);
                                             startMinuteLabel.setVisible(true);
                                             window.add(startMinuteLabel);
                                          
                                          
                                          
                                          
                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                             submitMinButton.setBounds(200,150,150,30);  
                                             submitMinButton.addActionListener(
                                                new ActionListener(){  
                                                   public void actionPerformed(ActionEvent e){  
                                                      Integer startMinute = (Integer) startMinBox.getSelectedItem();
                                                      final JLabel startMinEntry = new JLabel(Integer.toString(startMinute));
                                                      startMinEntry.setBounds(110,150,70,20);
                                                      window.add(startMinEntry);
                                                      window.remove(startMinBox);  
                                                      submitMinButton.setVisible(false);
                                                   
                                                   
                                                   
                                                      final JLabel endYearLabel = new JLabel("End Year:");
                                                      endYearLabel.setBounds(20,175,70,20);
                                                   
                                                   
                                                      window.add(endYearLabel);
                                                   
                                                      JComboBox<Integer> endYearBox= new JComboBox<>(yearDate);  
                                                      endYearBox.setBounds(110,175, 80,20);
                                                   
                                                   
                                                   
                                                      window.add(endYearBox);
                                                      JButton submitEYearButton=new JButton("Submit Year");  
                                                      submitEYearButton.setBounds(200,175,150,30);  
                                                      submitEYearButton.addActionListener(
                                                         new ActionListener(){  
                                                            public void actionPerformed(ActionEvent e){  
                                                               Integer endYear = (Integer) endYearBox.getSelectedItem();
                                                            
                                                            
                                                               final JLabel endYearEntry = new JLabel(Integer.toString(endYear));
                                                               endYearEntry.setBounds(110,175,80,20);
                                                               window.add(endYearEntry);
                                                               window.remove(endYearBox);  
                                                               submitEYearButton.setVisible(false);
                                                            
                                                            
                                                            
                                                            
                                                               final JLabel endMonthLabel = new JLabel("End Month:");
                                                               endMonthLabel.setBounds(20,200,70,20);
                                                               endMonthLabel.setVisible(true);
                                                               window.add(endMonthLabel);
                                                            
                                                               JComboBox<Integer> endMonthBox= new JComboBox<>(monthDate);  
                                                               endMonthBox.setBounds(110,200, 50,20); 
                                                               endMonthBox.setVisible(true);
                                                               window.add(endMonthBox);
                                                            
                                                               JButton submitEMonthButton=new JButton("Submit Month");  
                                                               submitEMonthButton.setBounds(200,200,150,30);  
                                                               submitEMonthButton.addActionListener(
                                                                  new ActionListener(){  
                                                                     public void actionPerformed(ActionEvent e){  
                                                                        Integer endMonth = (Integer) endMonthBox.getSelectedItem();
                                                                     
                                                                        final JLabel endMonthEntry = new JLabel(Integer.toString(endMonth));
                                                                        endMonthEntry.setBounds(110,200,70,20);
                                                                        window.add(endMonthEntry);
                                                                        window.remove(endMonthBox);  
                                                                        submitEMonthButton.setVisible(false);
                                                                     
                                                                        if (endMonth == 1 ||endMonth == 3 ||endMonth == 5 ||endMonth == 7 ||endMonth == 8 ||endMonth == 10 ||endMonth == 12 )
                                                                        {
                                                                           JComboBox<Integer> endDayBox = new JComboBox<>(dayLongDate);  
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        }
                                                                        else if (endMonth == 4 ||endMonth == 6 ||endMonth == 9 ||endMonth == 11)
                                                                        {
                                                                           JComboBox<Integer> endDayBox = new JComboBox<>(dayShortDate);
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                        }
                                                                        else if (endMonth == 2 && endYear == 2020)
                                                                        {
                                                                           JComboBox<Integer> endDayBox = new JComboBox<>(dayLeapDate);
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                         
                                                                        
                                                                        }
                                                                        else 
                                                                        {
                                                                           JComboBox<Integer>  endDayBox = new JComboBox<>(dayFebDate);
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                        }
                                                                     
                                                                     
                                                                     }  
                                                                  }
                                                                  ); 
                                                               window.add(submitEMonthButton);
                                                               submitEMonthButton.setVisible(true);
                                                               window.repaint(); 
                                                            
                                                            
                                                            }  
                                                         }
                                                         ); 
                                                      window.add(submitEYearButton);
                                                      submitEYearButton.setVisible(true);
                                                      window.repaint();  
                                                   
                                                   }  
                                                }
                                                ); 
                                          
                                          
                                             window.add(submitMinButton);
                                             submitMinButton.setVisible(false);
                                             submitMinButton.setVisible(true);
                                             startMinBox.setVisible(true);
                                             window.repaint();  
                                          
                                          
                                          }  
                                       }
                                       ); 
                                       
                                      
                                    window.add(submitHourButton);
                                    submitHourButton.setVisible(false);
                                    submitHourButton.setVisible(true);
                                    startHourBox.setVisible(true);
                                    window.repaint();  
                                 
                                 
                                 
                                 }  
                              }
                              ); 
                           window.add(submitDayButton);
                           submitDayButton.setVisible(false);
                        
                        
                        
                           submitDayButton.setVisible(true);
                        
                        
                           startDayBox.setVisible(true);
                           window.repaint();  
                        
                        
                        
                        
                        
                        
                        
                        }
                        else if (startMonth == 2 && startYear == 2020)
                        {
                           JComboBox<Integer> startDayBox = new JComboBox<>(dayLeapDate);
                           startDayBox.setBounds(110,100, 50,20); 
                           startDayBox.setVisible(true);
                           window.add(startDayBox);
                            
                           final JLabel startDayLabel = new JLabel("Start Day:");
                           startDayLabel.setBounds(20,100,70,20);
                           startDayLabel.setVisible(true);
                           window.add(startDayLabel);
                        
                        
                        
                           JButton submitDayButton=new JButton("Submit Day");  
                           submitDayButton.setBounds(200,100,150,30);  
                           submitDayButton.addActionListener(
                              new ActionListener(){  
                                 public void actionPerformed(ActionEvent e){  
                                    Integer startDay = (Integer) startDayBox.getSelectedItem();
                                    final JLabel startDayEntry = new JLabel(Integer.toString(startDay));
                                    startDayEntry.setBounds(110,100,70,20);
                                    window.add(startDayEntry);
                                    window.remove(startDayBox);  
                                    submitDayButton.setVisible(false);
                                 
                                 
                                    
                                    window.repaint();  
                                 
                                 
                                 
                                 
                                 
                                 
                                    JComboBox<Integer>  startHourBox = new JComboBox<>(hourTime);
                                    startHourBox.setBounds(110,125, 50,20); 
                                    startHourBox.setVisible(true);
                                    window.add(startHourBox);
                                 
                                    final JLabel startHourLabel = new JLabel("Start Hour:");
                                    startHourLabel.setBounds(20,125,70,20);
                                    startHourLabel.setVisible(true);
                                    window.add(startHourLabel);
                                 
                                 
                                 
                                 
                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                    submitHourButton.setBounds(200,125,150,30);  
                                    submitHourButton.addActionListener(
                                       new ActionListener(){  
                                          public void actionPerformed(ActionEvent e){  
                                             Integer startHour = (Integer) startHourBox.getSelectedItem();
                                             final JLabel startHourEntry = new JLabel(Integer.toString(startHour));
                                             startHourEntry.setBounds(110,125,70,20);
                                             window.add(startHourEntry);
                                             window.remove(startHourBox);  
                                             submitHourButton.setVisible(false);
                                                                                
                                                                                
                                             JComboBox<Integer>  startMinBox = new JComboBox<>(minuteTime);
                                             startMinBox.setBounds(110,150, 50,20); 
                                             startMinBox.setVisible(true);
                                             window.add(startMinBox);
                                          
                                             final JLabel startMinuteLabel = new JLabel("Start Minute:");
                                             startMinuteLabel.setBounds(20,150,70,20);
                                             startMinuteLabel.setVisible(true);
                                             window.add(startMinuteLabel);
                                          
                                          
                                          
                                          
                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                             submitMinButton.setBounds(200,150,150,30);  
                                             submitMinButton.addActionListener(
                                                new ActionListener(){  
                                                   public void actionPerformed(ActionEvent e){  
                                                      Integer startMinute = (Integer) startMinBox.getSelectedItem();
                                                      final JLabel startMinEntry = new JLabel(Integer.toString(startMinute));
                                                      startMinEntry.setBounds(110,150,70,20);
                                                      window.add(startMinEntry);
                                                      window.remove(startMinBox);  
                                                      submitMinButton.setVisible(false);
                                                   
                                                   //BREAKPOINT END START TIME
                                                      final JLabel endYearLabel = new JLabel("End Year:");
                                                      endYearLabel.setBounds(20,175,70,20);
                                                   
                                                   
                                                      window.add(endYearLabel);
                                                   
                                                      JComboBox<Integer> endYearBox= new JComboBox<>(yearDate);  
                                                      endYearBox.setBounds(110,175, 80,20);
                                                   
                                                   
                                                   
                                                      window.add(endYearBox);
                                                      JButton submitEYearButton=new JButton("Submit Year");  
                                                      submitEYearButton.setBounds(200,175,150,30);  
                                                      submitEYearButton.addActionListener(
                                                         new ActionListener(){  
                                                            public void actionPerformed(ActionEvent e){  
                                                               Integer endYear = (Integer) endYearBox.getSelectedItem();
                                                            
                                                            
                                                               final JLabel endYearEntry = new JLabel(Integer.toString(endYear));
                                                               endYearEntry.setBounds(110,175,80,20);
                                                               window.add(endYearEntry);
                                                               window.remove(endYearBox);  
                                                               submitEYearButton.setVisible(false);
                                                            
                                                            
                                                            
                                                            
                                                            
                                                               final JLabel endMonthLabel = new JLabel("End Month:");
                                                               endMonthLabel.setBounds(20,200,70,20);
                                                               endMonthLabel.setVisible(true);
                                                               window.add(endMonthLabel);
                                                            
                                                               JComboBox<Integer> endMonthBox= new JComboBox<>(monthDate);  
                                                               endMonthBox.setBounds(110,200, 50,20); 
                                                               endMonthBox.setVisible(true);
                                                               window.add(endMonthBox);
                                                            
                                                               JButton submitEMonthButton=new JButton("Submit Month");  
                                                               submitEMonthButton.setBounds(200,200,150,30);  
                                                               submitEMonthButton.addActionListener(
                                                                  new ActionListener(){  
                                                                     public void actionPerformed(ActionEvent e){  
                                                                        Integer endMonth = (Integer) endMonthBox.getSelectedItem();
                                                                     
                                                                        final JLabel endMonthEntry = new JLabel(Integer.toString(endMonth));
                                                                        endMonthEntry.setBounds(110,200,70,20);
                                                                        window.add(endMonthEntry);
                                                                        window.remove(endMonthBox);  
                                                                        submitEMonthButton.setVisible(false);
                                                                     
                                                                        if (endMonth == 1 ||endMonth == 3 ||endMonth == 5 ||endMonth == 7 ||endMonth == 8 ||endMonth == 10 ||endMonth == 12 )
                                                                        {
                                                                           JComboBox<Integer> endDayBox = new JComboBox<>(dayLongDate);  
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        }
                                                                        else if (endMonth == 4 ||endMonth == 6 ||endMonth == 9 ||endMonth == 11)
                                                                        {
                                                                           JComboBox<Integer> endDayBox = new JComboBox<>(dayShortDate);
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                        }
                                                                        else if (endMonth == 2 && endYear == 2020)
                                                                        {
                                                                           JComboBox<Integer> endDayBox = new JComboBox<>(dayLeapDate);
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                          
                                                                           
                                                                        
                                                                        }
                                                                        else 
                                                                        {
                                                                           JComboBox<Integer>  endDayBox = new JComboBox<>(dayFebDate);
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                        }
                                                                     
                                                                     
                                                                     }  
                                                                  }
                                                                  ); 
                                                               window.add(submitEMonthButton);
                                                               submitEMonthButton.setVisible(true);
                                                               window.repaint(); 
                                                            
                                                            
                                                            }  
                                                         }
                                                         ); 
                                                      window.add(submitEYearButton);
                                                      submitEYearButton.setVisible(true);
                                                      window.repaint();  
                                                   
                                                   }  
                                                }
                                                ); 
                                          
                                          
                                             window.add(submitMinButton);
                                             submitMinButton.setVisible(false);
                                             submitMinButton.setVisible(true);
                                             startMinBox.setVisible(true);
                                             window.repaint();  
                                          
                                          
                                          }  
                                       }
                                       ); 
                                       
                                      
                                    window.add(submitHourButton);
                                    submitHourButton.setVisible(false);
                                    submitHourButton.setVisible(true);
                                    startHourBox.setVisible(true);
                                    window.repaint();  
                                 
                                 
                                 
                                 
                                 }  
                              }
                              ); 
                           window.add(submitDayButton);
                           submitDayButton.setVisible(false);
                        
                        
                        
                           submitDayButton.setVisible(true);
                        
                        
                           startDayBox.setVisible(true);
                           window.repaint();  
                        
                        
                        
                        
                        
                        
                        
                        }
                        else 
                        {
                           JComboBox<Integer>  startDayBox = new JComboBox<>(dayFebDate);
                           startDayBox.setBounds(110,100, 50,20); 
                           startDayBox.setVisible(true);
                           window.add(startDayBox);
                           
                           final JLabel startDayLabel = new JLabel("Start Day:");
                           startDayLabel.setBounds(20,100,70,20);
                           startDayLabel.setVisible(true);
                           window.add(startDayLabel);
                        
                        
                        
                        
                           JButton submitDayButton=new JButton("Submit Day");  
                           submitDayButton.setBounds(200,100,150,30);  
                           submitDayButton.addActionListener(
                              new ActionListener(){  
                                 public void actionPerformed(ActionEvent e){  
                                    Integer startDay = (Integer) startDayBox.getSelectedItem();
                                    final JLabel startDayEntry = new JLabel(Integer.toString(startDay));
                                    startDayEntry.setBounds(110,100,70,20);
                                    window.add(startDayEntry);
                                    window.remove(startDayBox);  
                                    submitDayButton.setVisible(false);
                                 
                                 
                                    
                                    window.repaint();  
                                 
                                 
                                 
                                 
                                    JComboBox<Integer>  startHourBox = new JComboBox<>(hourTime);
                                    startHourBox.setBounds(110,125, 50,20); 
                                    startHourBox.setVisible(true);
                                    window.add(startHourBox);
                                 
                                    final JLabel startHourLabel = new JLabel("Start Hour:");
                                    startHourLabel.setBounds(20,125,70,20);
                                    startHourLabel.setVisible(true);
                                    window.add(startHourLabel);
                                 
                                 
                                 
                                 
                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                    submitHourButton.setBounds(200,125,150,30);  
                                    submitHourButton.addActionListener(
                                       new ActionListener(){  
                                          public void actionPerformed(ActionEvent e){  
                                             Integer startHour = (Integer) startHourBox.getSelectedItem();
                                             final JLabel startHourEntry = new JLabel(Integer.toString(startHour));
                                             startHourEntry.setBounds(110,125,70,20);
                                             window.add(startHourEntry);
                                             window.remove(startHourBox);  
                                             submitHourButton.setVisible(false);
                                                                                
                                                                                
                                             JComboBox<Integer>  startMinBox = new JComboBox<>(minuteTime);
                                             startMinBox.setBounds(110,150, 50,20); 
                                             startMinBox.setVisible(true);
                                             window.add(startMinBox);
                                          
                                             final JLabel startMinuteLabel = new JLabel("Start Minute:");
                                             startMinuteLabel.setBounds(20,150,70,20);
                                             startMinuteLabel.setVisible(true);
                                             window.add(startMinuteLabel);
                                          
                                          
                                          
                                          
                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                             submitMinButton.setBounds(200,150,150,30);  
                                             submitMinButton.addActionListener(
                                                new ActionListener(){  
                                                   public void actionPerformed(ActionEvent e){  
                                                      Integer startMinute = (Integer) startMinBox.getSelectedItem();
                                                      final JLabel startMinEntry = new JLabel(Integer.toString(startMinute));
                                                      startMinEntry.setBounds(110,150,70,20);
                                                      window.add(startMinEntry);
                                                      window.remove(startMinBox);  
                                                      submitMinButton.setVisible(false);
                                                   
                                                   
                                                   
                                                      final JLabel endYearLabel = new JLabel("End Year:");
                                                      endYearLabel.setBounds(20,175,70,20);
                                                   
                                                   
                                                      window.add(endYearLabel);
                                                   
                                                      JComboBox<Integer> endYearBox= new JComboBox<>(yearDate);  
                                                      endYearBox.setBounds(110,175, 80,20);
                                                   
                                                   
                                                   
                                                      window.add(endYearBox);
                                                      JButton submitEYearButton=new JButton("Submit Year");  
                                                      submitEYearButton.setBounds(200,175,150,30);  
                                                      submitEYearButton.addActionListener(
                                                         new ActionListener(){  
                                                            public void actionPerformed(ActionEvent e){  
                                                               Integer endYear = (Integer) endYearBox.getSelectedItem();
                                                            
                                                            
                                                               final JLabel endYearEntry = new JLabel(Integer.toString(endYear));
                                                               endYearEntry.setBounds(110,175,80,20);
                                                               window.add(endYearEntry);
                                                               window.remove(endYearBox);  
                                                               submitEYearButton.setVisible(false);
                                                            
                                                            
                                                            
                                                            
                                                            
                                                               final JLabel endMonthLabel = new JLabel("End Month:");
                                                               endMonthLabel.setBounds(20,200,70,20);
                                                               endMonthLabel.setVisible(true);
                                                               window.add(endMonthLabel);
                                                            
                                                               JComboBox<Integer> endMonthBox= new JComboBox<>(monthDate);  
                                                               endMonthBox.setBounds(110,200, 50,20); 
                                                               endMonthBox.setVisible(true);
                                                               window.add(endMonthBox);
                                                            
                                                               JButton submitEMonthButton=new JButton("Submit Month");  
                                                               submitEMonthButton.setBounds(200,200,150,30);  
                                                               submitEMonthButton.addActionListener(
                                                                  new ActionListener(){  
                                                                     public void actionPerformed(ActionEvent e){  
                                                                        Integer endMonth = (Integer) endMonthBox.getSelectedItem();
                                                                     
                                                                        final JLabel endMonthEntry = new JLabel(Integer.toString(endMonth));
                                                                        endMonthEntry.setBounds(110,200,70,20);
                                                                        window.add(endMonthEntry);
                                                                        window.remove(endMonthBox);  
                                                                        submitEMonthButton.setVisible(false);
                                                                     
                                                                        if (endMonth == 1 ||endMonth == 3 ||endMonth == 5 ||endMonth == 7 ||endMonth == 8 ||endMonth == 10 ||endMonth == 12 )
                                                                        {
                                                                           JComboBox<Integer> endDayBox = new JComboBox<>(dayLongDate);  
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        
                                                                        }
                                                                        else if (endMonth == 4 ||endMonth == 6 ||endMonth == 9 ||endMonth == 11)
                                                                        {
                                                                           JComboBox<Integer> endDayBox = new JComboBox<>(dayShortDate);
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                        }
                                                                        else if (endMonth == 2 && endYear == 2020)
                                                                        {
                                                                           JComboBox<Integer> endDayBox = new JComboBox<>(dayLeapDate);
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                           
                                                                             
                                                                        
                                                                        }
                                                                        else 
                                                                        {
                                                                           JComboBox<Integer>  endDayBox = new JComboBox<>(dayFebDate);
                                                                           endDayBox.setBounds(110,225, 50,20); 
                                                                           endDayBox.setVisible(true);
                                                                           window.add(endDayBox);
                                                                        
                                                                           final JLabel endDayLabel = new JLabel("End Day:");
                                                                           endDayLabel.setBounds(20,225,70,20);
                                                                           endDayLabel.setVisible(true);
                                                                           window.add(endDayLabel);
                                                                        
                                                                        
                                                                        
                                                                        
                                                                           JButton submitEDayButton=new JButton("Submit Day");  
                                                                           submitEDayButton.setBounds(200,225,150,30);  
                                                                           submitEDayButton.addActionListener(
                                                                              new ActionListener(){  
                                                                                 public void actionPerformed(ActionEvent e){  
                                                                                    Integer endDay = (Integer) endDayBox.getSelectedItem();
                                                                                    final JLabel endDayEntry = new JLabel(Integer.toString(endDay));
                                                                                    endDayEntry.setBounds(110,225,70,20);
                                                                                    window.add(endDayEntry);
                                                                                    window.remove(endDayBox);  
                                                                                    submitEDayButton.setVisible(false);
                                                                                 
                                                                                 
                                                                                    window.repaint();  
                                                                                 
                                                                                 
                                                                                    JComboBox<Integer>  endHourBox = new JComboBox<>(hourTime);
                                                                                    endHourBox.setBounds(110,250, 50,20); 
                                                                                    endHourBox.setVisible(true);
                                                                                    window.add(endHourBox);
                                                                                 
                                                                                    final JLabel endHourLabel = new JLabel("End Hour:");
                                                                                    endHourLabel.setBounds(20,250,70,20);
                                                                                    endHourLabel.setVisible(true);
                                                                                    window.add(endHourLabel);
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                    JButton submitHourButton=new JButton("Submit Hour:");  
                                                                                    submitHourButton.setBounds(200,250,150,30);  
                                                                                    submitHourButton.addActionListener(
                                                                                       new ActionListener(){  
                                                                                          public void actionPerformed(ActionEvent e){  
                                                                                             Integer endHour = (Integer) endHourBox.getSelectedItem();
                                                                                             final JLabel endHourEntry = new JLabel(Integer.toString(endHour));
                                                                                             endHourEntry.setBounds(110,250,70,20);
                                                                                             window.add(endHourEntry);
                                                                                             window.remove(endHourBox);  
                                                                                             submitHourButton.setVisible(false);
                                                                                          
                                                                                          
                                                                                             JComboBox<Integer>  endMinBox = new JComboBox<>(minuteTime);
                                                                                             endMinBox.setBounds(110,275, 50,20); 
                                                                                             endMinBox.setVisible(true);
                                                                                             window.add(endMinBox);
                                                                                          
                                                                                             final JLabel endMinuteLabel = new JLabel("End Minute:");
                                                                                             endMinuteLabel.setBounds(20,275,70,20);
                                                                                             endMinuteLabel.setVisible(true);
                                                                                             window.add(endMinuteLabel);
                                                                                          
                                                                                          
                                                                                          
                                                                                          
                                                                                             JButton submitMinButton=new JButton("Submit Minute:");  
                                                                                             submitMinButton.setBounds(200,275,150,30);  
                                                                                             submitMinButton.addActionListener(
                                                                                                new ActionListener(){  
                                                                                                   public void actionPerformed(ActionEvent e){  
                                                                                                      Integer endMinute = (Integer) endMinBox.getSelectedItem();
                                                                                                      final JLabel endMinEntry = new JLabel(Integer.toString(endMinute));
                                                                                                      endMinEntry.setBounds(110,275,70,20);
                                                                                                      window.add(endMinEntry);
                                                                                                      window.remove(endMinBox);  
                                                                                                      submitMinButton.setVisible(false);
                                                                                                   
                                                                                                   
                                                                                                      Leave[] leaveType = {Leave.maternity, Leave.paternity, Leave.pto, Leave.sick_leave };
                                                                                                   
                                                                                                      JComboBox<Leave> leaveTypeBox = new JComboBox<>(leaveType);
                                                                                                      leaveTypeBox.setBounds(110,300, 90,20); 
                                                                                                      leaveTypeBox.setVisible(true);
                                                                                                      window.add(leaveTypeBox);
                                                                                                   
                                                                                                      final JLabel leaveTypeLabel = new JLabel("Leave Type:");
                                                                                                      leaveTypeLabel.setBounds(20,300,70,20);
                                                                                                      leaveTypeLabel.setVisible(true);
                                                                                                      window.add(leaveTypeLabel);
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                      JButton leaveTypeButton=new JButton("Submit Request");  
                                                                                                      leaveTypeButton.setBounds(210,300,150,30);  
                                                                                                      leaveTypeButton.addActionListener(
                                                                                                         new ActionListener(){  
                                                                                                            public void actionPerformed(ActionEvent e){  
                                                                                                               Leave leaveTypeEntry =  (Leave) leaveTypeBox.getSelectedItem();
                                                                                                               window.add(endDayEntry);
                                                                                                            
                                                                                                               leaveTypeButton.setVisible(true);
                                                                                                               window.repaint();  
                                                                                                            }  
                                                                                                         }
                                                                                                         ); 
                                                                                                      window.add(leaveTypeButton);
                                                                                                      window.repaint(); 
                                                                                                   
                                                                                                   }  
                                                                                                }
                                                                                                ); 
                                                                                             window.add(submitMinButton);
                                                                                             submitMinButton.setVisible(true);
                                                                                             endMinBox.setVisible(true);
                                                                                             window.repaint();  
                                                                                          
                                                                                          }  
                                                                                       }
                                                                                       ); 
                                                                                    window.add(submitHourButton);
                                                                                    submitHourButton.setVisible(true);
                                                                                    endHourBox.setVisible(true);
                                                                                    window.repaint();   
                                                                                 
                                                                                 
                                                                                 }  
                                                                              }
                                                                              ); 
                                                                           window.add(submitEDayButton);
                                                                           submitEDayButton.setVisible(false);
                                                                        
                                                                        
                                                                        
                                                                           submitEDayButton.setVisible(true);
                                                                        
                                                                        
                                                                           endDayBox.setVisible(true);
                                                                           window.repaint();  
                                                                        
                                                                        
                                                                        }
                                                                     
                                                                     
                                                                     }  
                                                                  }
                                                                  ); 
                                                               window.add(submitEMonthButton);
                                                               submitEMonthButton.setVisible(true);
                                                               window.repaint(); 
                                                            
                                                            
                                                            }  
                                                         }
                                                         ); 
                                                      window.add(submitEYearButton);
                                                      submitEYearButton.setVisible(true);
                                                      window.repaint();  
                                                   
                                                   }  
                                                }
                                                ); 
                                          
                                          
                                             window.add(submitMinButton);
                                             submitMinButton.setVisible(false);
                                             submitMinButton.setVisible(true);
                                             startMinBox.setVisible(true);
                                             window.repaint();  
                                          
                                          
                                          }  
                                       }
                                       ); 
                                       
                                      
                                    window.add(submitHourButton);
                                    submitHourButton.setVisible(false);
                                    submitHourButton.setVisible(true);
                                    startHourBox.setVisible(true);
                                    window.repaint();  
                                 
                                 }  
                              }
                              ); 
                           window.add(submitDayButton);
                           submitDayButton.setVisible(false);
                        
                        
                        
                           submitDayButton.setVisible(true);
                        
                        
                           startDayBox.setVisible(true);
                           window.repaint();  
                        
                        
                        
                        }
                     
                                               
                     }  
                  }
                  ); 
                  
               window.add(submitMonthButton);
               submitMonthButton.setVisible(true);
               window.repaint(); 
            
              
              
                              
            }  
         }
         ); 
      window.add(submitYearButton);
      window.repaint();   
   }

   public static void employeeCurrentRequests(JFrame window, JTextField tf)
   {
      window.getContentPane().removeAll();
      window.repaint();
      
      JButton backButton=new JButton("Back");  
      backButton.setBounds(280,1,80,30);  
      backButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               employeeMenu(window, tf);         
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
               hireEmployee(window, tf);
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
     
   public static void hireEmployee(JFrame window, JTextField tf)
   {
   window.getContentPane().removeAll();
      window.repaint();
     
      JButton backButton=new JButton("Back");  
      backButton.setBounds(280,1,80,30);  
      backButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               hrMenu(window, tf);         
            }  
         }
         ); 
      window.add(backButton);

         final JLabel usernameLabel = new JLabel("Username:");
      usernameLabel.setBounds(20,50,70,20);
      window.add(usernameLabel);
   
      final JTextField usernameBox=new JTextField();  
      usernameBox.setBounds(110,50, 150,20); 
      window.add(usernameBox);
      
      final JLabel passwordLabel = new JLabel("Password:");
      passwordLabel.setBounds(20,100,70,20);
      window.add(passwordLabel);
   
      
      final JTextField passwordBox=new JTextField();  
      passwordBox.setBounds(110,100, 150,20); 
      window.add(passwordBox);

     
     window.repaint();   
   }   
}

