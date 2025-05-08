package com.gapsi.ecom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "providers")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProviderEntity extends AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "name", nullable = false, length = 100, unique = true)
    private String name;
    @Column(name = "address", length = 150)
    private String address;
    @Column(name = "company_name", nullable = false, length = 100)
    private String companyName;

}
