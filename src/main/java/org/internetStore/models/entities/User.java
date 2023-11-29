package org.internetStore.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user", schema = "public", catalog = "internet_store_db")
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long userid;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
//    @Column
//    private Boolean is_admin;
}
