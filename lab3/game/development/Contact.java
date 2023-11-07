package game.development;

public class Contact {
    private String address;
    private String email;
    private String phoneNumber;
    public void setAddress(String address) {
        this.address = address;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String printInfo() {
        String info = "";
        info += "Address: " + this.address + "\n";
        info += "Email: " + this.email + "\n";
        info += "PhoneNumber: " + this.phoneNumber + "\n";
        System.out.println(info);
        return info;
    }
}
