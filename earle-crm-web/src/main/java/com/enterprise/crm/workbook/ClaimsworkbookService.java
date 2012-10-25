/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.workbook;

import com.enterprise.crm.common.CrudService;
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
public class ClaimsworkbookService {
    private static final long serialVersionUID = 1L;
    @Inject
    CrudService crudService;

    public List<Claimsworkbook> getAllClaimsworkbooks() {
        return crudService.findWithNamedQuery("Claimsworkbook.findAll");
    }
    
    public void save(Claimsworkbook claimsworkbook) {
        crudService.update(claimsworkbook);     
    }
    
    public void delete(Claimsworkbook claimsworkbook) {
        crudService.delete(claimsworkbook);
    }
    
    public void add(Long id, String claimNo, Date claimdate, String claimupdate) {
        Claimsworkbook claimsworkbook = new Claimsworkbook();
        claimsworkbook.setId(id);
        claimsworkbook.setClaimDate(claimdate);
        claimsworkbook.setClaimUpdate(claimupdate);        
        crudService.create(claimsworkbook);
    }
    
}