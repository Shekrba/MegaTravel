package com.megatravel.agent.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Poruka {

        @Column(name = "sadrzaj", unique = false, nullable = false)
        private String sadrzaj;

        @ManyToOne(fetch = FetchType.EAGER)
        private User posiljalac;

        @ManyToOne(fetch = FetchType.EAGER)
        private User primalac;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

       public Poruka(){

       }


}
