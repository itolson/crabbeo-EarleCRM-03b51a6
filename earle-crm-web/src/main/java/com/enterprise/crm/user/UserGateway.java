package com.enterprise.crm.user;

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
public class UserGateway {

    @Inject
    transient UserDetailsService userService;
    
    private UserDetails selectedUser;
    private List<UserDetails> users;
    private String userName;
    private String forename;
    private String surname; 
    private boolean partner;
    private Integer hourlyrate;
    
    //TODO: These need changing to use the new user entity layout
    private String userTelephone;
    private String userEmailaddress;

    @PostConstruct
    public void initializeUser() {
        users = userService.getAllUsers();
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public Integer getHourlyrate() {
        return hourlyrate;
    }

    public void setHourlyrate(Integer hourlyrate) {
        this.hourlyrate = hourlyrate;
    }

    public boolean isPartner() {
        return partner;
    }

    public void setPartner(boolean partner) {
        this.partner = partner;
    }

    public UserDetails getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(UserDetails selectedUser) {
        this.selectedUser = selectedUser;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserEmailaddress() {
        return userEmailaddress;
    }

    public void setUserEmailaddress(String userEmailaddress) {
        this.userEmailaddress = userEmailaddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserDetailsService getUserService() {
        return userService;
    }

    public void setUserService(UserDetailsService userService) {
        this.userService = userService;
    }

    public String getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
        this.userTelephone = userTelephone;
    }

    public List<UserDetails> getUsers() {
        return users;
    }

    public void setUsers(List<UserDetails> users) {
        this.users = users;
    }

     public void save() {
        userService.save(selectedUser);
    }

    public void delete() {
        userService.delete(selectedUser);
        //Refresh the User list
        initializeUser();

    }

    public void add() {
        userService.add(userName, forename, surname, partner);

        //Reset the values
        userName = null;
        forename = null;
        surname = null;
        hourlyrate = null;
        userTelephone = null;
        userEmailaddress = null;
        //Refresh the User list
        initializeUser();
    }
}
