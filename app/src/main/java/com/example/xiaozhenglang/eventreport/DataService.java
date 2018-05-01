package com.example.xiaozhenglang.eventreport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaozhenglang on 4/25/18.
 */

public class DataService {

    public static List<Event> getEventData() {
        List<Event> eventData = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            eventData.add(new Event("Event", "1184 W valley Blvd, CA 90101",
                    "This is a huge event"
            ));
        }
        return eventData;
    }

}
