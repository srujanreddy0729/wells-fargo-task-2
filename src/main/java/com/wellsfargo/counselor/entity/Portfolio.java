package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue
    private long portfolioId;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    /** ---------- Relationships ---------- */

    // Many portfolios belong to ONE client
    @ManyToOne(optional = false)
    @JoinColumn(name = "clientId")
    private Client client;

    // ONE portfolio can include MANY securities
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Security> securities;

    /** ---------- Constructors ---------- */

    protected Portfolio() { }

    public Portfolio(Client client) {
        this.client        = client;
        this.creationDate  = LocalDateTime.now();
    }

    /** ---------- Getters / Setters ---------- */

    public long getPortfolioId() { return portfolioId; }

    public LocalDateTime getCreationDate() { return creationDate; }
    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }

    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }

    public List<Security> getSecurities() { return securities; }
    public void setSecurities(List<Security> securities) { this.securities = securities; }
}
