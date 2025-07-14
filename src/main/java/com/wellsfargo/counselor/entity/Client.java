package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private long clientId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    /** ---------- Relationships ---------- */

    // Many clients belong to ONE advisor
    @ManyToOne(optional = false)
    @JoinColumn(name = "advisorId")
    private Advisor advisor;

    // ONE client can own MANY portfolios
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Portfolio> portfolios;

    /** ---------- Constructors ---------- */

    protected Client() { }

    public Client(Advisor advisor,
                  String firstName,
                  String lastName,
                  String address,
                  String phone,
                  String email) {
        this.advisor  = advisor;
        this.firstName = firstName;
        this.lastName  = lastName;
        this.address   = address;
        this.phone     = phone;
        this.email     = email;
    }

    /** ---------- Getters / Setters ---------- */

    public long getClientId() { return clientId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Advisor getAdvisor() { return advisor; }
    public void setAdvisor(Advisor advisor) { this.advisor = advisor; }

    public List<Portfolio> getPortfolios() { return portfolios; }
    public void setPortfolios(List<Portfolio> portfolios) { this.portfolios = portfolios; }
}
