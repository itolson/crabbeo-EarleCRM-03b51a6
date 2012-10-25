/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.login;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "UserSecurity.findAll", query = "SELECT u FROM UserSecurity u"),
    @NamedQuery(name = "UserSecurity.findByUserName", query = "SELECT u FROM UserSecurity u WHERE u.userName = :userName")
})
public class UserSecurity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Size(max = 10)
    @NotNull
    @Column(name = "username")
    private String userName;
    
    @Column(name = "failedLoginAttempts")
    private Integer failedLoginAttempts;
    
    @Column(name = "lastSuccessfulLogin")
    @Temporal(TemporalType.DATE)
    private Date lastSuccessfulLogin;
    
    @Size(max = 32)
    @Column(name = "password")
    private String password;

    public UserSecurity() {
    }

    public UserSecurity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(Integer failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public Date getLastSuccessfulLogin() {
        return lastSuccessfulLogin;
    }

    public void setLastSuccessfulLogin(Date lastSuccessfulLogin) {
        this.lastSuccessfulLogin = lastSuccessfulLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserSecurity other = (UserSecurity) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.userName == null) ? (other.userName != null) : !this.userName.equals(other.userName)) {
            return false;
        }
        if (this.failedLoginAttempts != other.failedLoginAttempts && (this.failedLoginAttempts == null || !this.failedLoginAttempts.equals(other.failedLoginAttempts))) {
            return false;
        }
        if (this.lastSuccessfulLogin != other.lastSuccessfulLogin && (this.lastSuccessfulLogin == null || !this.lastSuccessfulLogin.equals(other.lastSuccessfulLogin))) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserSecurity{" + "id=" + id + ", userName=" + userName + ", failedLoginAttempts=" + failedLoginAttempts + ", lastSuccessfulLogin=" + lastSuccessfulLogin + ", password=" + password + '}';
    }
}
