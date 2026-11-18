package org.example.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "service")
    private String service;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "total_sum")
    private BigDecimal totalSum;

    @Column(name = "paid_sum")
    private BigDecimal paidSum;

    @Column(name = "date_of_creation")
    private LocalDate dateOfCreation;

    @Column(name = "date_expiration")
    private LocalDate dateExpiration;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

    @ManyToOne
    @JoinColumn(name = "freelancer_id")
    private User freelancer;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Invoice() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getService() {
        return service;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public BigDecimal getPaidSum() {
        return paidSum;
    }

    public void setPaidSum(BigDecimal paidSum) {
        this.paidSum = paidSum;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setFreelancer(User freelancer) {
        this.freelancer = freelancer;
    }

    public User getFreelancer() {
        return freelancer;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getClient() {
        return client;
    }
}
