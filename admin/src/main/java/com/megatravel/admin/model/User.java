package com.megatravel.admin.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ime", unique = false, nullable = true)
    private String ime;

    @Column(name = "prezime", unique = false, nullable = true)
    private String prezime;


    @Column(name = "username", unique = false, nullable = true)
    private String username;


    @Column(name = "password", unique = false, nullable = true)
    private String password;


    @Column(name = "email", unique = false, nullable = true)
    private String email;

    @Column(name = "role", unique = false, nullable = true)
    @Enumerated(EnumType.STRING)
    private UserType role;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToMany(mappedBy = "korisnik")
    private List<Komentar> comments;

    @Column(name = "posMatBroj", unique = false)
    private String posMatBroj;

    @Column(name = "adresa", unique = false)
    private String adresa;

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getRole() {
        return role;
    }

    public void setRole(UserType role) {
        this.role = role;
    }


    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }


    public List<Komentar> getComments() {
        return comments;
    }

    public void setComments(List<Komentar> comments) {
        this.comments = comments;
    }


    public String getPosMatBroj() {
        return posMatBroj;
    }

    public void setPosMatBroj(String posMatBroj) {
        this.posMatBroj = posMatBroj;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
