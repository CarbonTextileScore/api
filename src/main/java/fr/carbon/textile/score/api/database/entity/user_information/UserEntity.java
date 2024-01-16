package fr.carbon.textile.score.api.database.entity.user_information;

import fr.carbon.textile.score.api.database.entity.quota_information.QuotaEntity;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity(name = "User")
@Table(name = "`User`", schema = "`UserInformation`", catalog = "postgres")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Name`", nullable = false)
    private String _name;
    @Basic
    @Column(name = "`Lastname`", nullable = false)
    private String _lastname;
    @OneToOne
    @JoinColumn(name = "`CityId`", nullable = false)
    private CityEntity _city;
    @Basic
    @Column(name = "`Birthdate`", nullable = false)
    private Timestamp _birthdate;
    @OneToOne
    @JoinColumn(name = "`QuotaId`", nullable = false)
    private QuotaEntity _quota;
    @Basic
    @Column(name = "`ProfilePicture`", nullable = false)
    private byte[] _profilePicture;
    @OneToOne(mappedBy = "_user")
    private UserToFamilyEntity _userToFamily;

    public UserEntity() {
    }

    public UserEntity(
            String name,
            String lastname,
            CityEntity city,
            Timestamp birthdate,
            QuotaEntity quota,
            byte[] profilePicture,
            UserToFamilyEntity userToFamily
    ) {
        _name = name;
        _lastname = lastname;
        _city = city;
        _birthdate = birthdate;
        _quota = quota;
        _profilePicture = profilePicture;
        _userToFamily = userToFamily;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getLastname() {
        return _lastname;
    }

    public void setLastname(String lastname) {
        _lastname = lastname;
    }

    public CityEntity getCity() {
        return _city;
    }

    public void setCity(CityEntity city) {
        _city = city;
    }

    public Timestamp getBirthdate() {
        return _birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
        _birthdate = birthdate;
    }

    public QuotaEntity getQuota() {
        return _quota;
    }

    public void setQuota(QuotaEntity quotaId) {
        _quota = quotaId;
    }

    public byte[] getProfilePicture() {
        return _profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        _profilePicture = profilePicture;
    }

    public UserToFamilyEntity getUserToFamily() {
        return _userToFamily;
    }

    public void setUserToFamily(UserToFamilyEntity userToFamily) {
        _userToFamily = userToFamily;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(_quota, that._quota) &&
                Objects.equals(_name, that._name) &&
                Objects.equals(_lastname, that._lastname) &&
                Objects.equals(_city, that._city) &&
                Objects.equals(_birthdate, that._birthdate) &&
                Objects.equals(_userToFamily, that._userToFamily);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _name, _lastname, _city, _birthdate, _quota, _userToFamily);
    }
}
