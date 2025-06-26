public class PremiumMember extends GymMember
{
    private final double premiumCharge = 50000;//premiumCharge set to 50000
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    
    //constructor to initialize PremiumMember
    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String personalTrainer)
    {
        super(id,name,location,phone,email,gender,DOB,membershipStartDate);
        this.personalTrainer = personalTrainer;
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }
    
    //getter method
    public double getPremiumCharge(){
        return premiumCharge;
    }
    public String getPersonalTrainer(){
        return personalTrainer;
    }
    public boolean getIsFullPayment(){
        return isFullPayment;
    }
    public double getPaidAmount(){
        return paidAmount;
    }
    public double getDiscountAmount(){
        return discountAmount;
    }
    
    /**
     * Override markAttendance to increase attendance and loyalty points
     */
    @Override
    public void markAttendance(){
        this.attendance++;
        this.loyaltyPoints +=10;
    }
    
    //method to payDueAmount usinf if loop
    public String payDueAmount(double paidAmount){
        if(isFullPayment){
            return "Payment done.";
        }
        
        double totalPaid = this.paidAmount + paidAmount;
        if(totalPaid > premiumCharge){
            return "Error : Total paid amount exceeds the required charge.";
        }
        
        this.paidAmount  = totalPaid;
        if(this.paidAmount == premiumCharge){
            this.isFullPayment = true;
        }
        
        double remainingAmount = premiumCharge - this.paidAmount;
        return "Payment done.Remaining payment:"+remainingAmount;
    }
    
    //method to calculate discount if full payment is done
    public void calculatediscount(){
        if(isFullPayment){
            this.discountAmount = 0.1*premiumCharge;
            System.out.println("Discount:" + discountAmount);
        }
        else{
            System.out.println("No discount.Full Payment is to done.");
        }
    }
    
    //method to reset the PremiumMember details
    public void revertPremiumMember(){
        super.resetMember();
        this.personalTrainer = "";
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
    }
    
    /**
     * Overide display() method to show the details
     */
    @Override
    public String display() {
    return "ID: " + getId() +
           "\nName: " + getName() +
           "\nLocation: " + getLocation() +
           "\nPhone: " + getPhone() +
           "\nEmail: " + getEmail() +
           "\nGender: " + getGender() +
           "\nDOB: " + getDOB() +
           "\nMembership Start Date: " + getMembershipStartDate() +
           "\nTrainer: " + getPersonalTrainer() +
           "\nPlan: Premium" +
           "\nActive: " + (getActiveStatus() ? "Yes" : "No") +
           "\nAttendance: " + getAttendanceStatus() +
           "\nPaid Amount: " + paidAmount +
           "\nFull Payment: " + (isFullPayment ? "Yes" : "No") +
           "\nDiscount Amount: " + discountAmount;
    }
}

