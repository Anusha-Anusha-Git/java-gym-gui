//abstract class Gym member
public abstract class GymMember
{
    //protected attributes used by child class
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints = 0; //initial loyality point set to 0
    protected boolean activeStatus = false;//membership  inactice by default
    
    //constructor to initialize GymMember details
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate){
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
    }
    
   public void markAttendance() {
        if (activeStatus) {
            attendance++;
            loyaltyPoints += 10; 
            System.out.println("Attendance marked.");
        } else {
            System.out.println("Cannot mark attendance. Membership not active.");
        }
    }

    //method to activate membership
    public void activateMembership(){
        activeStatus = true;
    }
    
    //method to deactivate membership
    public void deactivateMembership(){
        if(activeStatus){
            activeStatus = false;
        }
        else{
            System.out.println("Membership is inactive");
        }
    }

    //method to reset member details
    public void resetMember(){
        activeStatus = false;
        attendance = 0;
        loyaltyPoints = 0;
    } 
    
    //getter methods for accessing private attributes
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    public String getPhone(){
        return phone;
    }
    public String getEmail(){
        return email;
    }
    public String getGender(){
        return gender;
    }
    public String getDOB(){
        return DOB;
    }
    public String getMembershipStartDate(){
        return membershipStartDate;
    }
    public int getAttendance(){
        return attendance;
    }
    public double getLoyaltyPoints(){
        return loyaltyPoints;
    }
    public boolean getActiveStatus(){
        return activeStatus;
    }
    public String getAttendanceStatus() {
        return attendance > 0 ? "Present (" + attendance + " days)" : "Absent";
    }
    //method to display member details
    public String display() {
        return "ID: " + getId() + 
                "\nName: " + getName() + 
                "\nLocation: " + getLocation() +
                "\nPhone: " + getPhone() +
                "\nEmail: " + getEmail() +
                "\nGender: " + getGender() +
                "\nDOB: " + getDOB() +
                "\nAttendance: " + attendance + 
                "\nLoyalty Points: " + loyaltyPoints +
                "\nActive: " + activeStatus+
                "\nMembership Start Date: "  + getMembershipStartDate();
    }
}