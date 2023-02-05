package kz.dara.cameralcontrol.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "organization")
@Data
public class Organization {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "organizationGenerator", sequenceName = "organisation_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "organizationGenerator", strategy = GenerationType.SEQUENCE)
    public Long Id;

    @Column(name = "status")
    public String status;

    @Column(name = "official_name")
    public String officialName;

    @Column(name = "type")
    public String type;

    @Column(name = "description")
    public String description;

    @Column(name = "address")
    public String address;

    @Column(name = "number_of_students")
    public Integer numberOfStudents;

    @Column(name = "website")
    public String website;
    @Column(name = "email")
    public String email;
    @Column(name = "organisation_number")
    public String organisationNumber;
}
