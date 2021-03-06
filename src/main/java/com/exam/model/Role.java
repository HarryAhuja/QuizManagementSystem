package com.exam.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    // since roleIds are less, automatic generation is turned off
    private Long roleId;
    private String roleName;

	//when we fetch role, we dont want all users with it->lazy
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
    private Set<UserRole> userRoles=new HashSet<>();


    public Role() {
    }


    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Role(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
