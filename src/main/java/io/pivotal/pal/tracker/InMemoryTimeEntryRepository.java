package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import io.pivotal.pal.tracker.TimeEntry;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{

    private HashMap<Long,TimeEntry> timeEntries = new HashMap<Long,TimeEntry>();
    private Long currentId = 1L;
    @Override
    public TimeEntry create(TimeEntry timeEntry){
        Long id = currentId++;
        TimeEntry newTimeEntry = new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        timeEntries.put(id,newTimeEntry);
        return newTimeEntry;
    }
    @Override
    public TimeEntry find(Long id){
        return timeEntries.get(id);
    }
    @Override
    public List<TimeEntry> list(){
        return new ArrayList<>(timeEntries.values());
    }
    @Override
    public TimeEntry update(Long id,TimeEntry timeEntry){
        //    TimeEntry updateEntry = new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        if(timeEntries.get(id) != null){
            timeEntry.setId(id);
            timeEntries.replace(id,timeEntry);
            return timeEntry;
        }else{
            return null;
        }
    }
    @Override
    public void delete(Long id){
        timeEntries.remove(id);
    }
}