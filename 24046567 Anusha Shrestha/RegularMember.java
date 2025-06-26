public class RegularMember extends GymMember
{
        private final int attendanceLimit;
        private boolean isEligibleforUpgrade;
        private String removalReason;
        private String referralSource;
        private String plan;
        private double price;
        private boolean attendanceMarked = false;
        
        //constructor to initialize a RegularMember
        public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate)
        {
            super(id,name,location,phone ,email,gender,DOB,membershipStartDate);
            this.attendanceLimit = 30;
            this.isEligibleforUpgrade = false; //initial isEligibleforUpgrade set to false
            this.removalReason = removalReason;
            this.plan = "basic"; //inital plan set to basic
            this.price = 6500; //inital price set to 6500
        }
        
        //getter methods for accessing private attributes
        public String getReferralSource(){
            return referralSource;
        }
        public boolean getisEligibleforUpgrade(){
            return isEligibleforUpgrade;
        }
        public String getRemovalReason(){
            return removalReason;
        }
        public String getPlan(){
            return plan;
        }
        public double getPrice(){
            return price;
        }
        public String getAttendanceStatus() {
            return attendanceMarked ? "Present" : "Absent";
        }

        public void markAttendance() {
            attendanceMarked = true;
        }

        public void LoyalityPoints()
        {
            attendance++;
            loyaltyPoints += 5;
            if(attendance >= attendanceLimit){
                isEligibleforUpgrade = true;
            }
        }
        
        //method to get Plan Price using switch case
        public double getPlanPrice(String plan){
            switch (plan.toLowerCase()){
                case "basic":
                    return 6500;
                case "standard":
                    return 12500;
                case "deluxe":
                    return 18500;
                    default:
                return -1;
            }
        }
        
        //method to upgrade Plan
        public String upgradePlan(String newPlan)
        {
            double newPrice =getPlanPrice(newPlan);
            if(newPrice == -1){
                return "invalid plan";
            }
            if(isEligibleforUpgrade == false){
                return "You cannot have an upgrade.";
            }
            if(this.plan.equalsIgnoreCase(newPlan)){
                return "You have been subscribed to the plan.";
            }
            this.plan = newPlan;
            this.price = newPrice;
            return "Plan has been upgraded."+newPlan;
        }
        
        //method to revert Regularmember
        public void revertRegularmember(String removalReason){
            resetMember();
            this.isEligibleforUpgrade = false;
            this.plan = "Basic";
            this.price = 6500;
            this.removalReason = removalReason;
        }
        
        /**
         * Overide the display() method to include additional details
         */
        @Override
        public String display() {
        return "ID: " + getId() +
               "\nName: " + getName() +
               "\nLocation: " + location +
               "\nPhone: " + phone +
               "\nEmail: " + email +
               "\nGender: " + gender +
               "\nDOB: " + DOB +
               "\nReferral: " + referralSource +
               "\nMembership: Regular" +
               "\nActive: " + (getActiveStatus() ? "Yes" : "No") +
               "\nAttendance: " + getAttendanceStatus();
    }
}

