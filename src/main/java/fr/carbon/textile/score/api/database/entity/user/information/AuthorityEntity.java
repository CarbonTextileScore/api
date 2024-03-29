package fr.carbon.textile.score.api.database.entity.user.information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "Authority")
@Table(name = "`Authority`", schema = "`UserInformation`", catalog = "postgres")
public class AuthorityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Username`", nullable = false)
    private String _username;
    @OneToOne
    @JoinColumn(name = "`RoleId`", nullable = false)
    private RoleEntity _role;
    @Basic
    @Column(name = "`Password`", nullable = false)
    private String _password;

    public AuthorityEntity() {
    }

    public AuthorityEntity(String username, RoleEntity role, String password) {
        _username = username;
        _role = role;
        _password = password;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        _id = id;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        _username = username;
    }

    public RoleEntity getRole() {
        return _role;
    }

    public void setRole(RoleEntity role) {
        _role = role;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        _password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorityEntity that = (AuthorityEntity) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(_username, that._username) &&
                Objects.equals(_role, that._role) &&
                Objects.equals(_password, that._password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _username, _role, _password);
    }
}
