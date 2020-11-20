//Tyler Lindley 200382154
public class Customer {
    private int id;
    private String firstName, lastName, creditCardType, bloodType, phoneNumber;
    private double weightInKg, heightInCM;

    public Customer(int id, String firstName, String lastName, String creditCardType, String bloodType, String phoneNumber, double weightInKg, double heightInCM) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setCreditCardType(creditCardType);
        setBloodType(bloodType);
        setPhoneNumber(phoneNumber);
        setWeightInKg(weightInKg);
        setHeightInCM(heightInCM);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id >0) {
            this.id = id;
        }
        else {
            throw new IllegalArgumentException("ID must be greater than 0.");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName.length() >=1 && firstName.length() <=30) {
            this.firstName = firstName;
        }
        else {
            throw new IllegalArgumentException("First name must be 1 - 30 characters in length.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() >=1 && lastName.length() <=30) {
            this.lastName = lastName;
        }
        else {
            throw new IllegalArgumentException("Last name must be 1 - 30 characters in length.");
        }
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        if(creditCardType.equalsIgnoreCase("visa") || creditCardType.equalsIgnoreCase("Mastercard")) {
            this.creditCardType = creditCardType;
        }
        else {
            throw new IllegalArgumentException("We only accept Visa and Mastercard");
        }
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        //It's a long validation, but it works haha.
        if(bloodType.equalsIgnoreCase("B+") || bloodType.equalsIgnoreCase("O+") || bloodType.equalsIgnoreCase("AB+") || bloodType.equalsIgnoreCase("O-") || bloodType.equalsIgnoreCase("A+") || bloodType.equalsIgnoreCase("B-") || bloodType.equalsIgnoreCase("A-") || bloodType.equalsIgnoreCase("AB-")) {
            this.bloodType = bloodType;
        }
        else {
            throw new IllegalArgumentException("Not a valid blood type. Please type it again.");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(double weightInKg) {
        if(weightInKg >=3 && weightInKg <=500) {
            this.weightInKg = weightInKg;
        }
        else {
            throw new IllegalArgumentException("Weight cannot be less than 3 kgs, or more than 500.");
        }
    }

    public double getHeightInCM() {
        return heightInCM;
    }

    public void setHeightInCM(double heightInCM) {
        if(heightInCM >=30 && heightInCM <=300) {
            this.heightInCM = heightInCM;
        }
        else {
            throw new IllegalArgumentException("Height must be 30 - 300 cms.");
        }
    }

    public double getBMI() {
        return weightInKg / heightInCM / heightInCM * 10000;
    }

    public String getBMIResult() {
        if(getBMI() <19) {
            return "underweight";
        }
        if(getBMI() >19 && getBMI()<25) {
            return "healthy";
        }
        if(getBMI() >25 && getBMI()<30) {
            return "overweight";
        }
        if(getBMI() >30 && getBMI() <40) {
            return "obese";
        }
        if(getBMI() >=40) {
            return "extremely obese";
        }
        return "No BMI.";
    }

    //public boolean contains(String firstName, String lastName, String creditCardType, String bloodType) {
      //  if
    //}


    @Override
    public String toString() {
        return String.format("id: %d" ,id + "%s", firstName, lastName +  getCombinedTime());
                id + " " + firstName + " " + lastName + " "
                        + "height: " + heightInCM + " " + "weight: " + weightInKg + " "  + "BMI: " + getBMI();
    }
}
