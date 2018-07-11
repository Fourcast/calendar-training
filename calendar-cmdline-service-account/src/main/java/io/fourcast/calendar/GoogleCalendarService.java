package io.fourcast.calendar;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nielsbuekers
 */
public class GoogleCalendarService  extends AbstractGoogleService{
  private static Calendar service;

  public static Calendar getCalendarService(InputStream in, String user) {
    if (service == null) {
      List<String> scope = new ArrayList<>();
      scope.add(CalendarScopes.CALENDAR_READONLY);

      GoogleCredential credentials;
      try {
        credentials = getCredentialsForScope(in,scope,user);
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }

      service = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credentials)
        .setApplicationName("pega88-sandbox")
        .build();
    }

    return service;
  }
}
