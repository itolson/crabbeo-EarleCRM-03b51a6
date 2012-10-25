/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.panel;

import com.enterprise.crm.common.CrudService;
import com.enterprise.crm.practice.Practice;
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
public class PanelService {

    private static final long serialVersionUID = 1L;
    @Inject
    CrudService crudService;

    public List<PanelDetails> getAllPanels() {
        return crudService.findWithNamedQuery("PanelDetails.findAll");
    }

    public void save(PanelDetails panel) {
        crudService.update(panel);
    }

    public void delete(PanelDetails panel) {
        PanelDetails panelToDelete = crudService.find(PanelDetails.class, panel.getId());
        crudService.delete(panelToDelete);
    }

    public void add(Long id, String name, String address1, String address2, String address3, String address4, String postcode, String contacts) {
        PanelDetails panel = new PanelDetails();
        panel.setId(id);
        panel.setName(name);
        panel.setAddress1(address1);
        panel.setAddress2(address2);
        panel.setAddress3(address3);
        panel.setAddress4(address4);
        panel.setPostcode(postcode);
        panel.setContacts(contacts);

        crudService.create(panel);
    }
}