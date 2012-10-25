package com.enterprise.crm.panel;

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
public class PanelGateway {

    @Inject
    transient PanelService panelService;
    private PanelDetails selectedPanel;
    private List<PanelDetails> panels;
    private Long panelId;
    private String panelName;
    private String panelAddress1;
    private String panelAddress2;
    private String panelAddress3;
    private String panelAddress4;
    private String panelPostcode;
    private String panelContacts;

    @PostConstruct
    public void initializePanel() {
        panels =panelService.getAllPanels();
    }

    public PanelDetails getSelectedPanel() {
        return selectedPanel;
    }
    public void setSelectedPanel(PanelDetails selectedPanel) {
        this.selectedPanel = selectedPanel;
    }

    public String getPanelAddress1() {
        return panelAddress1;
    }

    public void setPanelAddress1(String panelAddress1) {
        this.panelAddress1 = panelAddress1;
    }

    public String getPanelAddress2() {
        return panelAddress2;
    }

    public void setPanelAddress2(String panelAddress2) {
        this.panelAddress2 = panelAddress2;
    }

    public String getPanelAddress3() {
        return panelAddress3;
    }

    public void setPanelAddress3(String panelAddress3) {
        this.panelAddress3 = panelAddress3;
    }

    public String getPanelAddress4() {
        return panelAddress4;
    }

    public void setPanelAddress4(String panelAddress4) {
        this.panelAddress4 = panelAddress4;
    }

    public String getPanelContacts() {
        return panelContacts;
    }

    public void setPanelContacts(String panelContacts) {
        this.panelContacts = panelContacts;
    }

    public Long getPanelId() {
        return panelId;
    }

    public void setPanelId(Long panelId) {
        this.panelId = panelId;
    }

    public String getPanelName() {
        return panelName;
    }

    public void setPanelName(String panelName) {
        this.panelName = panelName;
    }

    public String getPanelPostcode() {
        return panelPostcode;
    }

    public void setPanelPostcode(String panelPostcode) {
        this.panelPostcode = panelPostcode;
    }


    public PanelService getPanelService() {
        return panelService;
    }

    public void setPanelService(PanelService panelService) {
        this.panelService = panelService;
    }

    public List<PanelDetails> getPanels() {
        return panels;
    }

    public void setPanels(List<PanelDetails> panels) {
        this.panels = panels;
    }

    public void save() {
        panelService.save(selectedPanel);
    }

    public void delete() {
        panelService.delete(selectedPanel);
        //Refresh the User list
        initializePanel();

    }

    public void add() {
        panelService.add(panelId, panelName, panelAddress1, panelAddress2, panelAddress3, panelAddress4, panelPostcode, panelContacts);

        //Reset the values
        panelId = null;
        panelName = null;
        panelAddress1 = null;
        panelAddress2 = null;
        panelAddress3 = null;
        panelAddress4 = null;
        panelPostcode = null;
        panelContacts = null;


        //Refresh the Panel list
        initializePanel();
    }
}
