package kz.dara.cameralcontrol.model;


import kz.dara.cameralcontrol.util.BooleanToCharacterConverter;
import kz.dara.cameralcontrol.util.PreviousPasswordsToStringConverter;
import kz.dara.cameralcontrol.util.StringToCipherConverter;
import lombok.*;

import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
@Table(name = "user", schema = "public")
@Getter
@Setter
public class User {
    @Id
    @Column(name = "user_id")
    @SequenceGenerator(name = "userGenerator", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "userGenerator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "user_type")
    private Integer userType;
    @Column(name = "is_active")
    private Boolean active = Boolean.FALSE;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.user")
    private Set<UserGroup> userGroups = new HashSet<>(0);

}
