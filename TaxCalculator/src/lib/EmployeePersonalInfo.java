package lib;

//menyimpan data general dari employee
public class EmployeePersonalInfo {
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private boolean isForeigner;
    private boolean gender; // true = Laki-laki, false = Perempuan

    public EmployeePersonalInfo(String firstName, String lastName, String idNumber, String address, boolean isForeigner, boolean gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.isForeigner = isForeigner;
        this.gender = gender;
    }

    public boolean isForeigner() {
        return isForeigner;
    }

    public String getIdNumber() {
        return idNumber;
    }
}
