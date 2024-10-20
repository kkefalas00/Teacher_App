package teachersWebApplication.gr.aueb.model;


import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@EqualsAndHashCode
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45, name = "email",unique = true)
    private String email;

    @Column(length = 15, nullable = false, name = "password",unique = true)
    private String password;

    @Column(length = 45, nullable = false, name = "first_name")
    private String firstName;

    @Column(length = 45, nullable = false, name = "last_name")
    private String lastName;

    @Column(length = 45, nullable = false, name = "enabled")
    private Boolean enabled;



}
