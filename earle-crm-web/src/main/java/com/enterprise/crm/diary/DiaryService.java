/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.diary;

import com.enterprise.crm.common.CrudService;
import com.enterprise.crm.common.QueryParameters;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author user
 */
@Named
@Default
public class DiaryService {
    private static final long serialVersionUID = 1L;
    @Inject
    CrudService crudService;

    public List<Diary> getDiaryByUserName(String username) {
        return crudService.findWithNamedQuery("Diary.findByUserName", QueryParameters.withParameters("userName", username));
    }
    
    public void save(Diary diary) {
        crudService.update(diary);     
    }
    
    public void delete(Diary diary) {
        Diary diaryToDelete = crudService.find(Diary.class, diary.getId());                
        crudService.delete(diaryToDelete);
    }
    
    public void add(Long ID, String event, Date startDate, Date endDate, Time startTime, Time endTime, String userName) {
        Diary diary = new Diary();
        diary.setId(ID);
        diary.setEvent(event);
        diary.setStartDate(startDate);
        diary.setEndDate(endDate);
        diary.setStartTime(startTime);
        diary.setEndTime(endTime);
        
        crudService.create(diary);
    }
    
}