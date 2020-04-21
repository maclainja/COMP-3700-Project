import java.util.ArrayList;
import java.awt.event.*;  
import javax.swing.*;    
public class SystemInterface { 

   static int employeeID = 0;
   static int supervisorID = 0; 
   static Company c;
   static EmployeeRequestController erc;
   static ManagerRequestController mrc;
   static PersonController pc;
   static PTOController ptoc;
   static CalendarController cc;
   static RequestDatabase rd;

   public static void main(String[] args) {
   
      c = new Company();
      erc = c.erc;
      mrc = c.mrc;
      pc = c.pc;
      ptoc = c.ptoc;
      cc = c.cc;
      rd = c.rdc.rd;
      JFrame window =new JFrame("Leave System"); 
      window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
      window.setVisible(true);
      window.setSize(800,800);  
      window.setLayout(null);  
      final JTextField tf=new JTextField();  
      tf.setBounds(50,50, 250,20); 
      window.add(tf);
     // logInScreen(window);
      makeRequestForm( window,  tf);
      //hrMenu( window,  tf);
      //addHolidayForm( window,  tf);
   
   }
  
   public static void logInScreen(JFrame window)
   {
      window.getContentPane().removeAll();
      window.repaint();
     
      final JLabel usernameLabel = new JLabel("Employee ID:");
      usernameLabel.setBounds(20,50,80,20);
      window.add(usernameLabel);
   
      final JTextField usernameBox=new JTextField();  
      usernameBox.setBounds(110,50, 150,20); 
      window.add(usernameBox);
      
      final JLabel passwordLabel = new JLabel("Password:");
      passwordLabel.setBounds(20,100,70,20);
      window.add(passwordLabel);
   
      
      final JTextField passwordBox = new JTextField();  
      passwordBox.setBounds(110,100, 150,20); 
      window.add(passwordBox);
      
      
      
      JButton logInButton= new JButton("Login");  
      logInButton.setBounds(110,150,95,30);  
      logInButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){
               String password = passwordBox.getText();
               String userString = usernameBox.getText();
               if (userString.compareTo("") != 0 )
               {
                  employeeID = Integer.parseInt(userString);
               }
               else
               {
                  employeeID = -1;
               }
               
               if (pc.employeeIndex.get(employeeID) != null)
               {
                  if( password.equals(pc.employeeIndex.get(employeeID).password))
                  {
                  
                     supervisorID = pc.employeeIndex.get(employeeID).supervisor.employeeID;
                     final JTextField tf=new JTextField();  
                     tf.setBounds(50,50, 150,20); 
                     window.add(tf);
                  
                     mainMenu(window, tf); 
                  } 
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
             
               if (pc.employeeIndex.get(employeeID).supervisees.length == 0 )
               {
                  mainMenu(window, tf);
               }
               else
               {
                  managerMenu(window, tf);
               }
             
            }  
         }
         ); 
         
      window.add(managerButton);
         
      JButton executiveButton=new JButton("Executive");  
      executiveButton.setBounds(50,200,95,30);  
      executiveButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               
               if (pc.employeeIndex.get(employeeID).title == Title.hr_executive || pc.employeeIndex.get(employeeID).title == Title.executive )
               {
                  executiveMenu(window, tf);
               }
            }  
         }
         ); 
         
      window.add(executiveButton);
         
      JButton hrButton=new JButton("HR");  
      hrButton.setBounds(50,250,95,30);  
      hrButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               if (pc.employeeIndex.get(employeeID).title == Title.hr_executive || pc.employeeIndex.get(employeeID).title == Title.hr )
               { 
               
                  hrMenu(window, tf);          
               }
            }     
         }
         ); 
         
      window.add(hrButton); 
      
      JButton dateButton=new JButton("Set Date");  
      dateButton.setBounds(50,300,95,30);  
      dateButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                                 
               setCurrentDay(window, tf);          
               
            }     
         }
         ); 
         
      window.add(dateButton); 
      
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
   
   public static void setCurrentDay(JFrame window, JTextField tf)
   {
      window.getContentPane().removeAll();
      window.repaint();
      window.add(tf);
   
   
      final JLabel startMonthLabel = new JLabel("Current Month (number):");
      startMonthLabel.setBounds(20,100,150,20);
      window.add(startMonthLabel);
   
      
      final JTextField startMonthBox=new JTextField();  
      startMonthBox.setBounds(170,100, 40,20); 
      window.add(startMonthBox);
   
      final JLabel startDayLabel = new JLabel("Current Day (number):");
      startDayLabel.setBounds(20,125, 150,20);
      window.add(startDayLabel);
   
      final JTextField startDayBox=new JTextField();  
      startDayBox.setBounds(170,125, 40,20); 
      window.add(startDayBox);
   
   
      final JLabel startYearLabel = new JLabel("Current Year (number):");
      startYearLabel.setBounds(20,150, 150,20);
      window.add(startYearLabel);
   
      final JTextField startYearBox=new JTextField();  
      startYearBox.setBounds(170,150, 40,20); 
      window.add(startYearBox);
       
      final JLabel hourLabel = new JLabel("Current Hour (number):");
      hourLabel.setBounds(20,175,150,20);
      window.add(hourLabel);
   
      
      final JTextField hourBox=new JTextField();  
      hourBox.setBounds(170,175, 40,20); 
      window.add(hourBox);
   
      final JLabel minuteLabel = new JLabel("Current minute (number):");
      minuteLabel.setBounds(20,200, 150,20);
      window.add(minuteLabel);
        
      final JTextField minuteBox =new JTextField();  
      minuteBox.setBounds(170,200, 40,20); 
      window.add(minuteBox);
      
      JButton submitButton=new JButton("Submit");  
      submitButton.setBounds(110,225,95,30);  
      submitButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){
               
               int startDay = Integer.parseInt(startDayBox.getText());
               int startMonth = Integer.parseInt(startMonthBox.getText());
               int startYear = Integer.parseInt(startYearBox.getText());
               int hour = Integer.parseInt(hourBox.getText());
               int minute = Integer.parseInt(minuteBox.getText());
               c.getDate();
               c.setDate( startMonth,  startDay,  startYear,  hour, minute) ;
            
               
               String temp = "Current Date Set";
               tf.setText(temp);
               executiveMenu(window, tf); 
               
            }  
         });
         
         
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
      window.add(submitButton);
      window.revalidate();
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
      Integer[] hourTime = new Integer[] {9,10,11,12,13,14,15,16,17};
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
   
      if (pc.employeeIndex.get(employeeID).title != Title.contractor && pc.employeeIndex.get(employeeID).title != Title.part_time)
      {
         String ptoHours = "Current PTO Hours Available: ";
         ptoHours = ptoHours + Double.toString(ptoc.getPTO(employeeID)); 
         final JLabel ptoLabel = new JLabel(ptoHours);
         ptoLabel.setBounds(100,340,400,20);
      
         window.add(ptoLabel);
      
      }           
      final JLabel startYearLabel = new JLabel("Start Year:");
      startYearLabel.setBounds(20,50,70,20);
     
      window.add(startYearLabel);
   
      JComboBox<Integer> startYearBox= new JComboBox<>(yearDate);  
      startYearBox.setBounds(110,50, 80,20);
      startYearBox.setVisible(false);
      startYearBox.setVisible(true);
      window.add(startYearBox);
      window.revalidate();
      window.repaint();
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
                                                                                                               erc.makeRequest(startDay, startMonth, startYear, startHour, startMinute, endDay, endMonth, endYear, endHour, endMinute, leaveTypeEntry, employeeID, supervisorID);
                                                                                                               employeeCurrentRequests( window, tf);
                                                                                                            
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
      tf.setText("");
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
      String temp = "<html><pre>Request   Start       Start       End        End        Total      Leave         Status<br>  ID       Date       Time        Date       Time       Time       Type   </pre><html>";
     
      final JLabel headerLabel = new JLabel(temp);
      headerLabel.setBounds(20,30,650,50);
      window.add(headerLabel);
                             
      ArrayList<Request> currentRequestArray =  erc.getEmployeeRequests(employeeID);
      String stringToPrint = "<html><pre>";
     
      if (currentRequestArray.size() > 0)
      {
      
         for( Request currentRequest: currentRequestArray)
         {
            stringToPrint = stringToPrint + "  ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.requestID) + "      ";
            //stringToPrint = stringToPrint + Integer.toString(currentRequest.employeeID) + "      ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.startMonth) + "/";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.startDay) + "/";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.startYear) + "   H: ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.startHour) + "  M: ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.startMinute) + "  ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.endMonth) + "/";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.endDay) + "/";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.endYear) + "    H: ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.endHour) + "  M: ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.endMinute) + "    ";
            stringToPrint = stringToPrint + Double.toString(currentRequest.totalTime) + "     ";
            stringToPrint = stringToPrint + currentRequest.leaveType.toString() + "     ";
            stringToPrint = stringToPrint + currentRequest.currentStatus.toString()  + "  ";
            stringToPrint = stringToPrint + "<br/>";
         }
         
      }
      else
      {
         stringToPrint = stringToPrint + "No current requests.";
      }
      stringToPrint = stringToPrint + "</pre><html>";
      final JLabel requestLabel = new JLabel(stringToPrint);
      requestLabel.setBounds(20,50,650,280);
      window.add(requestLabel);
      
      
      final JLabel idLabel = new JLabel("Request ID:");
      idLabel.setBounds(20,300,70,20);
      window.add(idLabel);
   
      
      final JTextField idBox=new JTextField();  
      idBox.setBounds(110,300, 150,20); 
      window.add(idBox);
   
      JButton withdrawButton=new JButton("Withdraw Request");  
      withdrawButton.setBounds(280,300,150,30);  
      withdrawButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               if (rd.getRequest(Integer.parseInt(idBox.getText())).getEmployeeID() == employeeID )
               {
               erc.withdrawRequest(Integer.parseInt(idBox.getText()));
               employeeCurrentRequests( window,  tf);
               }
            }  
         }
         ); 
      window.add(withdrawButton);
      
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
               managerCurrentRequests(window, tf);
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

   public static void managerCurrentRequests(JFrame window, JTextField tf)
   {
      window.getContentPane().removeAll();
      window.repaint();
      tf.setText("");
      JButton backButton=new JButton("Back");  
      backButton.setBounds(280,1,80,30);  
      backButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               managerMenu(window, tf);         
            }  
         }
         ); 
      window.add(backButton);
      
     
      
      String temp = "<html><pre>Request   Employee   Start       Start       End        End        Total      Leave         Status<br>  ID       ID         Date       Time        Date       Time       Time       Type   </pre><html>";
     
      final JLabel headerLabel = new JLabel(temp);
      headerLabel.setBounds(20,30,750,50);
      window.add(headerLabel);
                             
      ArrayList<Request> currentRequestArray =  mrc.getCurrentRequests(employeeID);
      String stringToPrint = "<html><pre>";
     
      if (currentRequestArray.size() > 0)
      {
      
         for( Request currentRequest: currentRequestArray)
         {
            stringToPrint = stringToPrint + "  ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.requestID) + "      ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.employeeID) + "      ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.startMonth) + "/";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.startDay) + "/";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.startYear) + "   H: ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.startHour) + "  M: ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.startMinute) + "  ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.endMonth) + "/";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.endDay) + "/";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.endYear) + "    H: ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.endHour) + "  M: ";
            stringToPrint = stringToPrint + Integer.toString(currentRequest.endMinute) + "    ";
            stringToPrint = stringToPrint + Double.toString(currentRequest.totalTime) + "     ";
            stringToPrint = stringToPrint + currentRequest.leaveType.toString() + "         ";
            stringToPrint = stringToPrint + currentRequest.currentStatus.toString()  + "  ";
            stringToPrint = stringToPrint + "<br/>";
         }
         
      }
      else
      {
         stringToPrint = stringToPrint + "No current requests.";
      }
      stringToPrint = stringToPrint + "</pre><html>";
      final JLabel requestLabel = new JLabel(stringToPrint);
      requestLabel.setBounds(20,50,750,280);
      window.add(requestLabel);
      
      
      
      final JLabel idLabel = new JLabel("Request ID:");
      idLabel.setBounds(20,300,70,20);
      window.add(idLabel);
   
      
      final JTextField idBox=new JTextField();  
      idBox.setBounds(110,300, 150,20); 
      window.add(idBox);
   
      JButton approveButton=new JButton("Approve Request");  
      approveButton.setBounds(280,300,150,30);  
      approveButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               if (rd.getRequest(Integer.parseInt(idBox.getText())).supervisorID == employeeID )
               {
               mrc.approveRequest(Integer.parseInt(idBox.getText()));
               managerCurrentRequests( window,  tf);
               }
            }  
         }
         ); 
      window.add(approveButton);
      
      JButton rejectButton=new JButton("Reject Request");  
      rejectButton.setBounds(280,340,150,30);  
      rejectButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               if (rd.getRequest(Integer.parseInt(idBox.getText())).supervisorID == employeeID )
               {
               mrc.rejectRequest(Integer.parseInt(idBox.getText()));
               managerCurrentRequests( window,  tf);
               }
            }  
         }
         ); 
      window.add(rejectButton);
      
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
               addTempHolidayForm( window,  tf);
            }  
         }
         ); 
      window.add(tempHolidayForm);
         
      JButton nationalHolidayForm=new JButton("Add/Remove National Holiday");  
      nationalHolidayForm.setBounds(50,150,200,30);  
      nationalHolidayForm.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               addHolidayForm( window,  tf);
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
   
   
   public static void addTempHolidayForm(JFrame window, JTextField tf)
   {
      window.getContentPane().removeAll();
      window.repaint();
      tf.setText("");
      JButton backButton=new JButton("Back");  
      backButton.setBounds(280,1,80,30);  
      backButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               executiveMenu(window, tf);         
            }  
         }
         ); 
      window.add(backButton);
   
      final JLabel titleLabel = new JLabel("New Holiday Information");
      titleLabel.setBounds(60,25,200,20);
      window.add(titleLabel);
   
    
   
      final JLabel nameLabel = new JLabel("Holiday Name:");
      nameLabel.setBounds(20,75,200,20);
      window.add(nameLabel);
   
      
      final JTextField nameBox=new JTextField();  
      nameBox.setBounds(150,75, 150,20); 
      window.add(nameBox);
   
      
      
      final JLabel startMonthLabel = new JLabel("Start Month (number):");
      startMonthLabel.setBounds(20,100,150,20);
      window.add(startMonthLabel);
   
      
      final JTextField startMonthBox=new JTextField();  
      startMonthBox.setBounds(150,100, 40,20); 
      window.add(startMonthBox);
   
      final JLabel startDayLabel = new JLabel("Start Day (number):");
      startDayLabel.setBounds(20,125, 150,20);
      window.add(startDayLabel);
   
      final JTextField startDayBox=new JTextField();  
      startDayBox.setBounds(150,125, 40,20); 
      window.add(startDayBox);
   
   
      final JLabel startYearLabel = new JLabel("Start Year (number):");
      startYearLabel.setBounds(20,150, 150,20);
      window.add(startYearLabel);
   
      final JTextField startYearBox=new JTextField();  
      startYearBox.setBounds(150,150, 40,20); 
      window.add(startYearBox);
       
      final JLabel endMonthLabel = new JLabel("End Month (number):");
      endMonthLabel.setBounds(20,175,150,20);
      window.add(endMonthLabel);
   
      
      final JTextField endMonthBox=new JTextField();  
      endMonthBox.setBounds(150,175, 40,20); 
      window.add(endMonthBox);
   
      final JLabel endDayLabel = new JLabel("End Day (number):");
      endDayLabel.setBounds(20,200, 150,20);
      window.add(endDayLabel);
   
      final JTextField endDayBox=new JTextField();  
      endDayBox.setBounds(150,200, 40,20); 
      window.add(endDayBox);
   
   
      final JLabel endYearLabel = new JLabel("End Year (number):");
      endYearLabel.setBounds(20,225, 150,20);
      window.add(endYearLabel);
   
      final JTextField endYearBox=new JTextField();  
      endYearBox.setBounds(150,225, 40,20); 
      window.add(endYearBox);
       
       
            
      JButton submitButton=new JButton("Submit");  
      submitButton.setBounds(110,250,95,30);  
      submitButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){
               
               int startDay = Integer.parseInt(startDayBox.getText());
               int startMonth = Integer.parseInt(startMonthBox.getText());
               int startYear = Integer.parseInt(startYearBox.getText());
               int endDay = Integer.parseInt(endDayBox.getText());
               int endMonth = Integer.parseInt(endMonthBox.getText());
               int endYear = Integer.parseInt(endYearBox.getText());
               String name = nameBox.getText();
               cc.addTempHoliday( name,  startMonth,  startDay,  startYear,  endMonth,  endDay,  endYear);
               tf.setText("Temp Holiday Added");
               executiveMenu(window, tf); 
               
            }  
         });
      window.add(submitButton);
      window.revalidate();
      window.repaint();
     
      
   
   }

   public static void addHolidayForm(JFrame window, JTextField tf)
   {
      window.getContentPane().removeAll();
      window.repaint();
      tf.setText("");
      JButton backButton=new JButton("Back");  
      backButton.setBounds(280,1,80,30);  
      backButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               executiveMenu(window, tf);         
            }  
         }
         ); 
      window.add(backButton);
   
      final JLabel titleLabel = new JLabel("New Holiday Information");
      titleLabel.setBounds(60,25,200,20);
      window.add(titleLabel);
   
    
   
      final JLabel nameLabel = new JLabel("Holiday Name:");
      nameLabel.setBounds(20,75,200,20);
      window.add(nameLabel);
   
      
      final JTextField nameBox=new JTextField();  
      nameBox.setBounds(150,75, 150,20); 
      window.add(nameBox);
   
      
      
      final JLabel startMonthLabel = new JLabel("Start Month (number):");
      startMonthLabel.setBounds(20,100,150,20);
      window.add(startMonthLabel);
   
      
      final JTextField startMonthBox=new JTextField();  
      startMonthBox.setBounds(150,100, 40,20); 
      window.add(startMonthBox);
   
      final JLabel startDayLabel = new JLabel("Start Day (number):");
      startDayLabel.setBounds(20,125, 150,20);
      window.add(startDayLabel);
   
      final JTextField startDayBox=new JTextField();  
      startDayBox.setBounds(150,125, 40,20); 
      window.add(startDayBox);
   
   
      final JLabel startYearLabel = new JLabel("Start Year (number):");
      startYearLabel.setBounds(20,150, 150,20);
      window.add(startYearLabel);
   
      final JTextField startYearBox=new JTextField();  
      startYearBox.setBounds(150,150, 40,20); 
      window.add(startYearBox);
       
      final JLabel endMonthLabel = new JLabel("End Month (number):");
      endMonthLabel.setBounds(20,175,150,20);
      window.add(endMonthLabel);
   
      
      final JTextField endMonthBox=new JTextField();  
      endMonthBox.setBounds(150,175, 40,20); 
      window.add(endMonthBox);
   
      final JLabel endDayLabel = new JLabel("End Day (number):");
      endDayLabel.setBounds(20,200, 150,20);
      window.add(endDayLabel);
   
      final JTextField endDayBox=new JTextField();  
      endDayBox.setBounds(150,200, 40,20); 
      window.add(endDayBox);
   
   
      final JLabel endYearLabel = new JLabel("End Year (number):");
      endYearLabel.setBounds(20,225, 150,20);
      window.add(endYearLabel);
   
      final JTextField endYearBox=new JTextField();  
      endYearBox.setBounds(150,225, 40,20); 
      window.add(endYearBox);
       
      final JLabel typeLabel = new JLabel("Add/Remove:");
      typeLabel.setBounds(20,250, 150,20);
      window.add(typeLabel);
   
      String[] type = {"Add","Remove"};
     
      JComboBox<String> typeBox = new JComboBox<>(type);
      typeBox.setBounds(150,250, 90,20); 
      typeBox.setVisible(true);
      window.add(typeBox);
   
        
            
      JButton submitButton=new JButton("Submit");  
      submitButton.setBounds(110,275,95,30);  
      submitButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){
               
               int startDay = Integer.parseInt(startDayBox.getText());
               int startMonth = Integer.parseInt(startMonthBox.getText());
               int startYear = Integer.parseInt(startYearBox.getText());
               int endDay = Integer.parseInt(endDayBox.getText());
               int endMonth = Integer.parseInt(endMonthBox.getText());
               int endYear = Integer.parseInt(endYearBox.getText());
               String name = nameBox.getText();
               String type = (String) typeBox.getSelectedItem();
               cc.addRemoveNationalHoliday( name,  startMonth,  startDay,  startYear,  endMonth,  endDay,  endYear,  type) ;
               String temp;
               if (type.compareTo("Add") == 0)
               {
                  temp = "National Holiday Added";
               }
               else
               {
                  temp = "National Holiday Removed";
               }
               
               
               tf.setText(temp);
               executiveMenu(window, tf); 
               
            }  
         });
      window.add(submitButton);
      window.revalidate();
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
               fireEmployee( window,  tf);
            
            }  
         }
         ); 
      window.add(fireEmployeeForm);
      
      JButton promoteDemoteEmployeeForm=new JButton("Promote/Demote Employee");  
      promoteDemoteEmployeeForm.setBounds(50,200,200,30);  
      promoteDemoteEmployeeForm.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
               promoteDemoteEmployee( window,  tf);
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
      tf.setText("");
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
   
      final JLabel titleLabel = new JLabel("New Employee Information");
      titleLabel.setBounds(60,25,200,20);
      window.add(titleLabel);
   
      final JLabel employeeTypeLabel = new JLabel("Employee Type:");
      employeeTypeLabel.setBounds(20,50, 150,20);
      window.add(employeeTypeLabel);
   
      Title[] leaveType = { Title.part_time, Title.contractor, Title.full_time, Title.hr, Title.hr_executive, Title.executive};
   
                                                                                                   
      JComboBox<Title> employeeTypeBox = new JComboBox<>(leaveType);
      employeeTypeBox.setBounds(120,50, 90,20); 
      employeeTypeBox.setVisible(true);
      window.add(employeeTypeBox);
   
      final JLabel nameLabel = new JLabel("Name:");
      nameLabel.setBounds(20,75,70,20);
      window.add(nameLabel);
   
      
      final JTextField nameBox=new JTextField();  
      nameBox.setBounds(110,75, 150,20); 
      window.add(nameBox);
   
      
      
      final JLabel passwordLabel = new JLabel("Password:");
      passwordLabel.setBounds(20,100,70,20);
      window.add(passwordLabel);
   
      
      final JTextField passwordBox=new JTextField();  
      passwordBox.setBounds(110,100, 150,20); 
      window.add(passwordBox);
   
      final JLabel genderTypeLabel = new JLabel("Employee Gender:");
      genderTypeLabel.setBounds(20,125, 150,20);
      window.add(genderTypeLabel);
   
      Gender[] genderType = {Gender.male, Gender.female};
   
                                                                                                   
      JComboBox<Gender> genderTypeBox = new JComboBox<>(genderType);
      genderTypeBox.setBounds(130,125, 80, 20); 
      genderTypeBox.setVisible(true);
      window.add(genderTypeBox);
      
      final JLabel supervisorLabel = new JLabel("Supervisor ID:");
      supervisorLabel.setBounds(20,150,100,20);
      window.add(supervisorLabel);
   
      
      final JTextField supervisorBox=new JTextField();  
      supervisorBox.setBounds(130,150, 150,20); 
      window.add(supervisorBox);
      
      final JLabel superviseeLabel = new JLabel("Supervisee IDs:");
      superviseeLabel.setBounds(20,175,100,20);
      final JLabel supervisee1Label = new JLabel("(comma seperated)");
      supervisee1Label.setBounds(10,185,120,20);
      window.add(supervisee1Label);
      window.add(superviseeLabel);
   
      
      final JTextField superviseeBox=new JTextField();  
      superviseeBox.setBounds(130,175, 150,20); 
      window.add(superviseeBox);
   
   
      JButton submitButton=new JButton("Submit");  
      submitButton.setBounds(110,200,95,30);  
      submitButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){
               String password = passwordBox.getText();
               String name = nameBox.getText();
               Gender fm = (Gender) genderTypeBox.getSelectedItem();
               Title title = (Title) employeeTypeBox.getSelectedItem();
               int supervisorID = Integer.parseInt(supervisorBox.getText());
              
               String[] superviseeString = superviseeBox.getText().split(",");
               int[] superviseeIDs;
               if (superviseeString.length > 0 && superviseeString[0].compareTo("") != 0 )
               {
                  superviseeIDs = new int[superviseeString.length];
                  for (int i = 0; i < superviseeString.length; i++)
                  {
                     superviseeIDs[i] = Integer.parseInt(superviseeString[i]);
                  }
               }
               else 
               {
                  superviseeIDs = new int[0];
               }
               pc.hireEmployee(title,  fm,  name, supervisorID, superviseeIDs, password);
               
               tf.setText("New employee added");
               hrMenu(window, tf); 
               
            }  
         });
      window.add(submitButton);
      window.revalidate();
      window.repaint();
     
      
   }   
     
   public static void promoteDemoteEmployee(JFrame window, JTextField tf)
   {
      window.getContentPane().removeAll();
      window.repaint();
      tf.setText("");
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
   
      final JLabel titleLabel = new JLabel("New Employee Information");
      titleLabel.setBounds(60,25,200,20);
      window.add(titleLabel);
      
      final JLabel usernameLabel = new JLabel("Employee ID:");
      usernameLabel.setBounds(20,50,70,20);
      window.add(usernameLabel);
   
      final JTextField usernameBox=new JTextField();  
      usernameBox.setBounds(110,50, 150,20); 
      window.add(usernameBox);
   
   
      final JLabel employeeTypeLabel = new JLabel("Employee Type:");
      employeeTypeLabel.setBounds(20,75, 150,20);
      window.add(employeeTypeLabel);
   
      Title[] leaveType = { Title.part_time, Title.contractor, Title.full_time, Title.hr, Title.hr_executive, Title.executive};
   
                                                                                                   
      JComboBox<Title> employeeTypeBox = new JComboBox<>(leaveType);
      employeeTypeBox.setBounds(120,75, 90,20); 
      employeeTypeBox.setVisible(true);
      window.add(employeeTypeBox);
   
                   
      final JLabel supervisorLabel = new JLabel("Supervisor ID:");
      supervisorLabel.setBounds(20,100,100,20);
      window.add(supervisorLabel);
   
      
      final JTextField supervisorBox=new JTextField();  
      supervisorBox.setBounds(130,100, 150,20); 
      window.add(supervisorBox);
      
      final JLabel superviseeLabel = new JLabel("Supervisee IDs:");
      superviseeLabel.setBounds(20,125,100,20);
      final JLabel supervisee1Label = new JLabel("(comma seperated)");
      supervisee1Label.setBounds(10,135,120,20);
      window.add(supervisee1Label);
      window.add(superviseeLabel);
   
      
      final JTextField superviseeBox=new JTextField();  
      superviseeBox.setBounds(130,125, 150,20); 
      window.add(superviseeBox);
   
   
      JButton submitButton=new JButton("Submit");  
      submitButton.setBounds(110,150,95,30);  
      submitButton.addActionListener(
         new ActionListener(){  
            public void actionPerformed(ActionEvent e){
               Title title = (Title) employeeTypeBox.getSelectedItem();
               int supervisorID = Integer.parseInt(supervisorBox.getText());
              
               String[] superviseeString = superviseeBox.getText().split(",");
               int[] superviseeIDs;
               if (superviseeString.length > 0 && superviseeString[0].compareTo("") != 0 )
               {
                  superviseeIDs = new int[superviseeString.length];
                  for (int i = 0; i < superviseeString.length; i++)
                  {
                     superviseeIDs[i] = Integer.parseInt(superviseeString[i]);
                  }
               }
               else 
               {
                  superviseeIDs = new int[0];
               }
               
               int id = Integer.parseInt(usernameBox.getText());
               pc.promoteDemoteEmployee(id, title,  supervisorID, superviseeIDs);
               
               tf.setText("Employee Promote/Demoted");
               hrMenu(window, tf); 
               
            }  
         });
      window.add(submitButton);
      window.revalidate();
      window.repaint();
     
      
   }   
     
     
     
   public static void fireEmployee(JFrame window, JTextField tf)
   {
      {
         window.getContentPane().removeAll();
         window.repaint();
         tf.setText("");
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
      
         final JLabel titleLabel = new JLabel("Fire Employee");
         titleLabel.setBounds(90,25,200,20);
         window.add(titleLabel);
      
         final JLabel nameLabel = new JLabel("Employee ID:");
         nameLabel.setBounds(20,75,80,20);
         window.add(nameLabel);
      
      
         final JTextField fireIDBox=new JTextField();  
         fireIDBox.setBounds(110,75, 40,20); 
         window.add(fireIDBox);
      
         JButton submitButton=new JButton("Submit");  
         submitButton.setBounds(110,200,95,30);  
         submitButton.addActionListener(
            new ActionListener(){  
               public void actionPerformed(ActionEvent e){
               
                  int fireID = Integer.parseInt(fireIDBox.getText());
               
                  pc.fireEmployee(fireID);
                  tf.setText("Employee Fired");
                  hrMenu(window, tf); 
               
               }  
            });
         window.add(submitButton);
         window.revalidate();
         window.repaint();
      
      
      }   
   
   
   }

}