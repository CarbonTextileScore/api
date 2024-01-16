package fr.carbon.textile.score.api.database.entity.user_information;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "UserToFamily")
@Table(name = "`UserToFamily`", schema = "UserInformation", catalog = "postgres")
public class UserToFamilyEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`", nullable = false)
    private int _id;
    @OneToOne
    @JoinColumn(name = "`UserId`", nullable = false)
    private UserEntity _user;
    @ManyToOne
    @JoinColumn(name = "`FamilyId`", nullable = false)
    private FamilyEntity _family;

    public UserToFamilyEntity() {
    }

    public UserToFamilyEntity(UserEntity user, FamilyEntity family) {
        _user = user;
        _family = family;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public UserEntity getUser() {
        return _user;
    }

    public void setUser(UserEntity userId) {
        _user = userId;
    }

    public FamilyEntity getFamily() {
        return _family;
    }

    public void setFamily(FamilyEntity familyId) {
        _family = familyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserToFamilyEntity that = (UserToFamilyEntity) o;
        return _id == that._id && Objects.equals(_user, that._user) && Objects.equals(_family, that._family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _user, _family);
    }
}
