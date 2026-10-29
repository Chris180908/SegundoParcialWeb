package org.gerdoc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "USUARIO")
public class Usuario
{
    @Column(name = "USERNAME")
    private Long username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROL_ID")
    private Integer rol_id;

    @Column(name = "PROFESOR_ID")
    private Double profesor_id;

    @Column(name = "ACTIVO")
    private Double activo;
}