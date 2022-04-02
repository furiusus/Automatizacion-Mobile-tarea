package runner;

public class Registro {
    private String name;
    private String lastname;
    private String phone;
    private String address;
    private String language;
    private String email;

    public Registro(){}

    public String getName() {
        return name;
    }

    public Registro setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Registro setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Registro setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Registro setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public Registro setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Registro setEmail(String email) {
        this.email = email;
        return this;
    }
}
