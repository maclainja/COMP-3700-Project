import java.util.ArrayList;

public class RequestDatabaseController {

   RequestDatabase rd;
   CalendarController cc;
   PTOController ptoc;
   Company c;
   
   public RequestDatabaseController() {
      rd = new RequestDatabase();
   }

   public void addRequest(Request newRequest) {
      int ID = rd.addRequest(newRequest);
      double workingTime = 0;
      workingTime = cc.getWorkingTime(newRequest);
      DayWithTime startDWT = new DayWithTime(newRequest.startMonth, newRequest.startDay, newRequest.startYear, newRequest.startHour, newRequest.startMinute);
      DayWithTime endDWT = new DayWithTime(newRequest.endMonth, newRequest.endDay, newRequest.endYear, newRequest.endHour, newRequest.endMinute);
      if (startDWT.compareTo(endDWT) == 1) {
         rd.rejectRequest(ID);
      }
      if ((newRequest.leaveType == Leave.pto) && (newRequest.currentStatus == Status.pending)) {
         if ((ptoc.verifyPTO(workingTime, newRequest.getEmployeeID()))) {
            ptoc.deductPTO(workingTime, newRequest.getEmployeeID());
         }
         else {
         rd.rejectRequest(ID);
         }
      }
      rd.setTotalTime(ID, workingTime);
   }

   public void approveRequest(int ID) {
      rd.approveRequest(ID);
   }
   
   public void rejectRequest(int ID) {
      Request request = rd.getRequest(ID);
      rd.rejectRequest(ID);
      if (request.leaveType == Leave.pto) {
         ptoc.addPTO(rd.getRequest(ID).getTotalTime(), rd.getRequest(ID).getEmployeeID());
      }
   }
   
   public void withdrawRequest(int ID) {
      Request request = rd.getRequest(ID);
      if ((request.currentStatus != Status.pending) && (request.currentStatus != Status.approved)) {
         return;
      }
      DayWithTime currentDWT = c.getDate();
      DayWithTime startDWT = new DayWithTime(request.startMonth, request.startDay, request.startYear, request.startHour, request.startMinute);
      DayWithTime endDWT = new DayWithTime(request.endMonth, request.endDay, request.endYear, request.endHour, request.endMinute);
      if (currentDWT.compareTo(endDWT) == 1) {
         return;
      }
      if (currentDWT.compareTo(startDWT) == -1) {  
         rd.withdrawRequest(ID);
         if (request.leaveType == Leave.pto) {
            ptoc.addPTO(request.getTotalTime(), request.getEmployeeID());
         }
      }
      else {
         double oldTotalTime = rd.getRequest(ID).getTotalTime();
         request.endDay = currentDWT.day.day;
         request.endMonth = currentDWT.day.month;
         request.endYear = currentDWT.day.year;
         request.endHour = currentDWT.hour;
         request.endMinute = currentDWT.minute;
         double newTotalTime = 0;
         newTotalTime = cc.getWorkingTime(request);
         double removedTime = oldTotalTime - newTotalTime;
         rd.setTotalTime(ID, newTotalTime);
         if (request.leaveType == Leave.pto) {
            ptoc.addPTO(request.getTotalTime(), request.getEmployeeID());
         }
      }
     
   }

   public ArrayList<Request> getEmployeeRequests(int employeeID) {
      ArrayList<Request> employeeRequests = new ArrayList<Request>();
      for (Request r : rd.getRequestDatabase()) {
         if ((r.employeeID == employeeID) && (c.getDate().compareTo(new DayWithTime(r.endMonth, r.endDay, r.endYear, r.endHour, r.endMinute)) < 1)) {
            employeeRequests.add(r);
         }
      }
      return employeeRequests;
   }
   
   public ArrayList<Request> getSuperviseeRequests(int managerID) {
      ArrayList<Request> superviseeRequests = new ArrayList<Request>();
      for (Request r : rd.getRequestDatabase()) {
         if ((r.supervisorID == managerID) && (c.getDate().compareTo(new DayWithTime(r.endMonth, r.endDay, r.endYear, r.endHour, r.endMinute)) <= 0)) {
            superviseeRequests.add(r);
         }
      }
      return superviseeRequests;
   }

}