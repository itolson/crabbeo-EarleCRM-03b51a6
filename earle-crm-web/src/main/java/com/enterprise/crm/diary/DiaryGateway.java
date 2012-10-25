package com.enterprise.crm.diary;

import com.enterprise.crm.login.UserContent;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Ian Tolson
 */
@Named
@Stateful
@SessionScoped
public class DiaryGateway {
    
    @Inject
    transient DiaryService diaryService;

    @Inject
    transient UserContent userContent;

    
    private Diary selectedDiary;
    private Diary onRowSelect;
    private List<Diary> diarys;
    private Long Id;
    private String event;
    private Date startDate;
    private Date endDate;
    private Time startTime;
    private Time endTime;
    private String userName;

    @PostConstruct
    public void initializeDiary() {
        String username = userContent.getLoggedInUser().getUserName();
        diarys = diaryService.getDiaryByUserName(username);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public DiaryService getDiaryService() {
        return diaryService;
    }

    public void setDiaryService(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    public List<Diary> getDiarys() {
        return diarys;
    }

    public void setDiarys(List<Diary> diarys) {
        this.diarys = diarys;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Diary getOnRowSelect() {
        return onRowSelect;
    }

    public void setOnRowSelect(Diary onRowSelect) {
        this.onRowSelect = onRowSelect;
    }

    public Diary getSelectedDiary() {
        return selectedDiary;
    }

    public void setSelectedDiary(Diary selectedDiary) {
        this.selectedDiary = selectedDiary;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void save() {
        diaryService.save(selectedDiary);
    }

    public void delete() {
        diaryService.delete(selectedDiary);
        //Refresh the diarys list
        initializeDiary();

    }

    public void add() {
        diaryService.add(Id, event, startDate, endDate, startTime, endTime, userName);
        //Reset the values
        Id = null;
        startDate = null;
        endDate = null;
        startTime = null;
        endTime = null;
        userName = null;

        //Refresh the diarys list
        initializeDiary();
    }
}
