package com.enterprise.crm.profession;

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
public class ProfessionGateway {

    @Inject
    transient ProfessionService professionService;
    private Profession selectedProfession = new Profession();
    private Profession onRowSelect;
    private List<Profession> professions;
    private Long professionId;
    private String professionDescription="";

    @PostConstruct
    public void initializeProfession() {
        professions = professionService.getAllProfessions();
    }

    public Profession getOnRowSelect() {
        return onRowSelect;
    }

    public void setOnRowSelect(Profession onRowSelect) {
        this.onRowSelect = onRowSelect;
    }

    public String getProfessionDescription() {
        return professionDescription;
    }

    public void setProfessionDescription(String professionDescription) {
        this.professionDescription = professionDescription;
    }

    public Long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Long professionId) {
        this.professionId = professionId;
    }

    public ProfessionService getProfessionService() {
        return professionService;
    }

    public void setProfessionService(ProfessionService professionService) {
        this.professionService = professionService;
    }

    public List<Profession> getProfessions() {
        return professions;
    }

    public void setProfessions(List<Profession> professions) {
        this.professions = professions;
    }

    public Profession getSelectedProfession() {
        return selectedProfession;
    }

    public void setSelectedProfession(Profession selectedProfession) {
        this.selectedProfession = selectedProfession;
    }

    public void save() {
        professionService.save(selectedProfession);
        initializeProfession();
    }

    public void delete() {
        professionService.delete(selectedProfession);
        professionId = null;
        professionDescription = "";
        initializeProfession();
    }

    public void add() {
        if (professionDescription == null) {
        } else {
            professionService.add(professionId, professionDescription);
        }
        //Reset the values
        professionId = null;
        professionDescription = "";
        initializeProfession();
    }
}
