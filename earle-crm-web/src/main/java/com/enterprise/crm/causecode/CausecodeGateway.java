package com.enterprise.crm.causecode;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author iantolson
 */
@Named
@Stateful
@SessionScoped
public class CausecodeGateway {

    @Inject
    transient CausecodeService causecodeService;
    private Causecode selectedCausecode;
    private Causecode onRowSelect;
    private List<Causecode> causecodes;
    private Long causecodeId;
    private String causecodeDescription;

    @PostConstruct
    public void initializeCausecode() {
        causecodes = causecodeService.getAllCausecodes();
    }

    public Causecode getSelectedCausecode() {
        return selectedCausecode;
    }

    public void setSelectedCausecode(Causecode selectedCausecode) {
        this.selectedCausecode = selectedCausecode;
    }

    public List<Causecode> getCausecodes() {
        return causecodes;
    }

    public void setCausecodes(List<Causecode> causecodes) {
        this.causecodes = causecodes;
    }

    public Long getCausecodeId() {
        return causecodeId;
    }

    public void setCausecodeId(Long causecodeId) {
        this.causecodeId = causecodeId;
    }

    public String getCausecodeDescription() {
        return causecodeDescription;
    }

    public void setCausecodeDescription(String causecodeDescription) {
        this.causecodeDescription = causecodeDescription;
    }

    public void save() {
        causecodeService.save(selectedCausecode);
    }

    public void delete() {
        causecodeService.delete(selectedCausecode);
        //Refresh the causecodes list
        initializeCausecode();

    }

    public void add() {
        causecodeService.add(causecodeId, causecodeDescription);

        //Reset the values
        causecodeId = null;
        causecodeDescription = null;

        //Refresh the causecodes list
        initializeCausecode();
    }
}
