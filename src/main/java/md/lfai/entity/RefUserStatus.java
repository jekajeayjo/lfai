package md.lfai.entity;

import javax.persistence.*;

@Entity
@Table
public class RefUserStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "CODE")
    private UserRoleEnum code;


}
