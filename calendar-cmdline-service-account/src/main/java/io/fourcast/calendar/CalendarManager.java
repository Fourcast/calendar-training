package io.fourcast.calendar;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.CalendarListEntry;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by nielsbuekers
 */
public class CalendarManager {


  public List<Event> getEventsForUser(String user) throws IOException {
    Calendar service = GoogleCalendarService.getCalendarService(getInputStreamForKey(),user);
    Events events = service.events().list("primary").setMaxResults(10)
      .setTimeMin(new DateTime(System.currentTimeMillis()))
      .setOrderBy("startTime")
      .setSingleEvents(true)
      .execute();
    return events.getItems();
  }

  private InputStream getInputStreamForKey() {
    return this.getClass().getResourceAsStream("/service-account.json");
  }
}
