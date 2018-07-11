package io.fourcast.calendar;


import com.google.api.services.calendar.model.Event;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by nbuekers
 */
public class CalendarSample {


    public static void main(String[] args) throws IOException {

    Logger log = Logger.getLogger(CalendarSample.class.getName());
    CalendarManager mgr = new CalendarManager();
    

    String user = "robin.hellemans@fourcast.io";
    
    List<Event> events = mgr.getEventsForUser(user);
    if(events.size() == 0) {
      log.severe("no events for " + user);
      return;
    }
    for(Event e :events){
        log.info("found event named " + e.getSummary() + " at " + e.getStart().getDateTime());
    }
  }
}
