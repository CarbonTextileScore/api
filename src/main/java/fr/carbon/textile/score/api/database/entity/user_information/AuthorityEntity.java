package fr.carbon.textile.score.api.database.entity.user_information;

import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

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
    @Basic
    @Column(name = "`Role`", nullable = false)
    @Enumerated(EnumType.STRING)
    @Type(PostgreSQLEnumType.class)
    private Role _role;
    @Basic
    @Column(name = "`Password`", nullable = false)
    private String _password;

    public AuthorityEntity() {
    }

    public AuthorityEntity(String username, Role role, String password) {
        this._username = username;
        this._role = role;
        this._password = password;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        this._id = id;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String username) {
        this._username = username;
    }

    public Object getRole() {
        return _role;
    }

    public void setRole(Role role) {
        this._role = role;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        this._password = password;
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
