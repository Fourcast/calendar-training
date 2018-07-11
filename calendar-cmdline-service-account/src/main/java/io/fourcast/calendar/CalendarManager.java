package io.fourcast.calendar;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by nielsbuekers
 */
public class CalendarManager {


  public List<?> getEventsForUser(String user) throws IOException {
    return null;
  }

  private InputStream getInputStreamForKey() {
    return this.getClass().getResourceAsStream("/service-account.json");
  }
}
