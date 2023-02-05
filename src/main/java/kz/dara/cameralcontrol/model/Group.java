package kz.dara.cameralcontrol.model;

import kz.dara.cameralcontrol.util.BooleanToCharacterConverter;
import lombok.ToString;

import javax.persistence.*;
import java.io.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "groups")
public class Group implements Serializable {

    @Id
    @Column(name = "group_id")
    @SequenceGenerator(name = "groupGenerator", sequenceName = "group_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "groupGenerator", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "group_name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "is_active")
    private Boolean active;
    @Column(name = "distribution_list")
    private String distributionList;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.group", cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<UserGroup> userGroups = new HashSet<>(0);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            this.name = null;
        } else {
            this.name = name.toUpperCase();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDistributionList() {
        return distributionList;
    }

    public void setDistributionList(String distributionList) {
        this.distributionList = distributionList;
    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Group) {
            Group other = (Group) obj;
            if (this.getId() != null)
                return this.getId().equals(other.getId());
            else if (this.getName() != null)
                return this.getName().equals(other.getName());
            else
                return false;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        if (this.getId() == null) {
            if (this.getName() == null) {
                return super.hashCode();
            } else {
                return this.getName().hashCode();
            }
        } else {
            return this.getId().hashCode();
        }
    }

}
