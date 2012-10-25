/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enterprise.crm.form;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.component.row.Row;

@Named
@Stateful
@SessionScoped
public class ClaimsPopulate {

    private List<ClaimsPopulate.Column> rows;
    private Row selectedRow;

    static public class Column {

        private List<String> columns;

        public Column(String string1, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
            this.columns = new ArrayList<String>();
            this.columns.add(string1);
            this.columns.add(string2);
            this.columns.add(string3);
            this.columns.add(string4);
            this.columns.add(string5);
            this.columns.add(string6);
            this.columns.add(string7);
            this.columns.add(string8);
        }

        public List<String> getColumns() {
            return columns;
        }

        public void setColumns(List<String> columns) {
            this.columns = columns;
        }
    }

    public ClaimsPopulate() {
        this.rows = new ArrayList<ClaimsPopulate.Column>();
        this.rows.add(new Column("A852/91", "Kingsbridge Risk Solutions", "KRS/11/5642", "666 Motor Trade (CMT)", "1/7/2011", "18,000.00 / 20,000,00", "The Insured allegedly mis-sold payment", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("A852/265", "Marsh Limited", "KRS/11/5870", "AA1 - Architects", "7/7/2011", "15,000.00 / 22,000,00", "The Insured is a motor-trader. The Claimant alleges that she was mis-sold payment protection insurance by", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("A852/253", "Kingsbridge Risk Solutions", "KRS/11/5642", "666 Motor Trade (CMT)", "1/7/2011", "2,000.00 / 10,000,00", "The Insured submitted five Application for Outline Planning Approval", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("A852/91", "Berkley Insurance Group", "LC/25484/10101586", "666 Motor Trade (CMT)", "5/27/2011", "33,000.00 / 23,000,00", "The Claimant has been defrauded by their former Financial Director. It appears that the misappropriation of funds by the Financial Director ", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("S400/911", "BlueFin", "SPL/36214/10101850", "666 Motor Trade (CMT)", "1/6/2012", "225,000.00 / 310,000,00", "The Insured allegedly mis-sold payment", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("W1223/9", "BlueFin", "KRS/11/5642", "666 Motor Trade (CMT)", "1/10/2011", "1,000.00 / 3,333,00", "The Insured allegedly mis-sold payment", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("A852/922", "Kingsbridge Risk Solutions", "KRS/11/5642", "AA1 - Architects", "8/14/2012", "4,000.00 / 6,000,00", "The Insured allegedly mis-sold payment", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("A822/934", "Kingsbridge Risk Solutions", "KRY/11/5642", "AE3 - Other Accountants", "1/7/2012", "7,000.00 / 10,000,00", "The Insured allegedly mis-sold payment", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("A882/9", "Kingsbridge Risk Solutions", "KRS/11/5622", "AA2 - Engineers", "1/7/2011", "52,000.00 / 60,000,00", "The Insured allegedly mis-sold payment", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("A872/9", "Kingsbridge Risk Solutions", "KRT/11/5611", "AA2 - Engineers", "8/14/2012", "115,000.00 / 60,000,00", "The Insured allegedly mis-sold payment", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("W12232/9", "Kingsbridge Risk Solutions", "KRG/11/5614", "666 Motor Trade (CMT)", "1/5/2011", "56,000.00 / 65,000,00", "The Insured allegedly mis-sold payment", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("A432/9", "Kingsbridge Risk Solutions", "KRJ/11/5611", "AE3 - Other Accountants", "1/7/2012", "1,000.00 / 2,000,00", "The Insured allegedly mis-sold payment", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("W1223/9", "Kingsbridge Risk Solutions", "KRS/11/5642", "AA2 - Engineers", "1/7/2011", "8,000.00 / 2,000,00", "The Insured allegedly mis-sold payment", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("A232/9", "Kingsbridge Risk Solutions", "KRJ/11/5611", "AE3 - Other Accountants", "1/7/2012", "1,000.00 / 2,000,00", "The Insured allegedly mis-sold payment", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("W1223/9", "Kingsbridge Risk Solutions", "KRS/11/5642", "AA2 - Engineers", "1/7/2011", "8,000.00 / 2,000,00", "The Insured allegedly mis-sold payment", "A Letter of Claim has been received and loss is put at £1,240"));        
        this.rows.add(new Column("A542/253", "Kingsbridge Risk Solutions", "KRS/11/5642", "666 Motor Trade (CMT)", "1/7/2011", "2,000.00 / 10,000,00", "The Insured submitted five Application for Outline Planning Approval", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("A672/91", "Berkley Insurance Group", "LC/25484/10101586", "666 Motor Trade (CMT)", "5/27/2011", "33,000.00 / 23,000,00", "The Claimant has been defrauded by their former Financial Director. It appears that the misappropriation of funds by the Financial Director ", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("S400/9", "BlueFin", "SPL/36214/10101850", "666 Motor Trade (CMT)", "1/6/2012", "225,000.00 / 310,000,00", "The Insured allegedly mis-sold payment", "A Letter of Claim has been received and loss is put at £1,240"));
        this.rows.add(new Column("W1223/9", "BlueFin", "KRS/11/5642", "666 Motor Trade (CMT)", "1/10/2011", "1,000.00 / 3,333,00", "The Insured allegedly mis-sold payment", "A Letter of Claim has been received and loss is put at £1,240"));
        
    }

    public List<ClaimsPopulate.Column> getRows() {
        return rows;
    }

    public void setRows(List<ClaimsPopulate.Column> rows) {
        this.rows = rows;
    }

    public Row getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(Row selectedRow) {
        this.selectedRow = selectedRow;
    }
}
