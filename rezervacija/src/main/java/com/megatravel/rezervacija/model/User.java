package com.megatravel.rezervacija.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class User implements UserDetails {


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

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "email", unique = false, nullable = true)
    private String email;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToMany(mappedBy = "korisnik")
    private List<Komentar> comments;

    @Column(name = "posMatBroj", unique = false)
    private String posMatBroj;

    @Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;

    @Column(name = "adresa", unique = false)
    private String adresa;

    @OneToMany(mappedBy = "korisnik")
    protected Set<Rezervacija> rezervacija;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

    public User() {

    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Rezervacija> getRezervacija() {
        return rezervacija;
    }

    public void setRezervacija(Set<Rezervacija> rezervacija) {
        this.rezervacija = rezervacija;
    }

    public void setPassword(String password) {
        Timestamp now = new Timestamp(new java.util.Date().getTime());
        this.setLastPasswordResetDate( now );
        this.password = password;
    }

    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


    @Override
    public boolean isEnabled() {
        return enabled;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }


    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
