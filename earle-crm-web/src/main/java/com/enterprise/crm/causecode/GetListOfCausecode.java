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
public class GetListOfCausecode {

    @Inject
    transient CausecodeService causecodeService;
    private Causecode selectedCausecode;
    private List<Causecode> causecodes;
    private String causecodeId;
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

    public String getCausecodeId() {
        return causecodeId;
    }

    public void setCausecodeId(String causecodeId) {
        this.causecodeId = causecodeId;
    }

    public String getCausecodeDescription() {
        return causecodeDescription;
    }

    public void setCausecodeDescription(String causecodeDescription) {
        this.causecodeDescription = causecodeDescription;
    }
}
