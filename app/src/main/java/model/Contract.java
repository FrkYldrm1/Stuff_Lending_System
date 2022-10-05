package model;

public class Contract {
    private int startDate;
    private int endDate;


    
    public Contract(int startDate, int endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getStartDate() {
        return startDate;
    }
    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }
    public int getEndDate() {
        return endDate;
    }
    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public void ItemContract(Member x, Member y, int contractPeriod) {
        
        

    }

    
}
