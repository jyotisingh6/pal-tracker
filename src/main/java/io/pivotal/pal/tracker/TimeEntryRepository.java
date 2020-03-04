package io.pivotal.pal.tracker;

import java.util.List;
import io.pivotal.pal.tracker.*;

public interface TimeEntryRepository{
    TimeEntry create(TimeEntry timeEntry);
    TimeEntry find(Long id);
    List<TimeEntry> list();
    TimeEntry update(Long id,TimeEntry timeEntry);
    void delete(Long id);
}