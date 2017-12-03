/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import java.io.Serializable;

/**
 *
 * @author Jorgie Bartelsi P
 */
public class Application implements Module, Serializable {
    private AccountModule       AM=null;
    private ProcurementModule   PM=null;
    private ReportModule        RM=null;
    private StockModule         SM=null;
    private TransactionModule   TM=null;

    public Application() {
        AM=null;
        PM=null;
        RM=null;
        SM=null;
        TM=null;
    }

    public boolean adaSM(){
        if(!SM.equals(null)){
            return false;
        }
        return true;
    }
    public boolean adaAM(){
        if(!this.AM.equals(null)){
            return false;
        }
        return true;
    }

    public boolean adaPM(){
        if(!PM.equals(null)){
            return false;
        }
        return true;
    }

    public AccountModule getAM() {
        return AM;
    }

    public void setAM(AccountModule AM) {
        this.AM = AM;
    }

    public ProcurementModule getPM() {
        return PM;
    }

    public void setPM(ProcurementModule PM) {
        this.PM = PM;
    }

    public ReportModule getRM() {
        return RM;
    }

    public void setRM(ReportModule RM) {
        this.RM = RM;
    }

    public StockModule getSM() {
        return SM;
    }

    public void setSM(StockModule SM) {
        this.SM = SM;
    }

    public TransactionModule getTM() {
        return TM;
    }

    public void setTM(TransactionModule TM) {
        this.TM = TM;
    }
    
    
    
    //Build allowed module
    public boolean Clearance(String username, String password) {
        boolean cek=login.Login(username, password);
        if (!cek){
            return false;
        }
        int level = login.getEmployee().getLevel();
        switch  (level) {            
            case 1: 
                this.setPM( new ProcurementModule() );
                this.setSM( new StockModule() );
                this.setTM( new TransactionModule() );
                return true;
            
            case 2:
                this.setAM( new AccountModule() );
                return true;
                
            case 3:
                this.setPM( new ProcurementModule() );
                this.setRM( new ReportModule());
                this.setSM( new StockModule() );
                this.setTM( new TransactionModule() );
                return true;
                
            case 0:
                this.setAM( new AccountModule() );
                this.setPM( new ProcurementModule() );
                this.setRM( new ReportModule());
                this.setSM( new StockModule() );
                this.setTM( new TransactionModule() );
                return true;
            
            default:
                return false;
        }
    }
}
