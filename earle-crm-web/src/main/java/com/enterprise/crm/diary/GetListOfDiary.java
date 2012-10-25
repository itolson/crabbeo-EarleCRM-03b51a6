package com.enterprise.crm.diary;

import com.enterprise.crm.login.UserContent;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jamescrabbe
 */
@Named
@Stateful
@SessionScoped
public class GetListOfDiary {

    @Inject
    transient DiaryService diaryService;
    @Inject
    transient UserContent userContent;    
    
    private Diary selectedDiary;
    private List<Diary> diarys;
    private String diaryId;
    private String diaryDescription;

    @PostConstruct
    public void initializeDiary() {
        String username = userContent.getLoggedInUser().getUserName();
        diarys = diaryService.getDiaryByUserName(username);        
    }

    public Diary getSelectedDiary() {
        return selectedDiary;
    }

    public void setSelectedDiary(Diary selectedDiary) {
        this.selectedDiary = selectedDiary;
    }

    public List<Diary> getDiarys() {
        return diarys;
    }

    public void setDiarys(List<Diary> diarys) {
        this.diarys = diarys;
    }

    public String getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(String diaryId) {
        this.diaryId = diaryId;
    }

    public String getDiaryDescription() {
        return diaryDescription;
    }

    public void setDiaryDescription(String diaryDescription) {
        this.diaryDescription = diaryDescription;
    }
}
