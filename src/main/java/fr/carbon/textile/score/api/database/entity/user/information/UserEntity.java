package fr.carbon.textile.score.api.database.entity.user.information;

import fr.carbon.textile.score.api.database.entity.quota.information.QuotaEntity;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    @ManyToOne
    @JoinColumn(name = "`CityId`", nullable = false)
    private CityEntity _city;
    @Basic
    @Column(name = "`Birthdate`", nullable = false)
    private Timestamp _birthdate;
    @Basic
    @Column(name = "`Gender`", nullable = false)
    private String _gender;
    @OneToOne
    @JoinColumn(name = "`QuotaId`", nullable = false)
    private QuotaEntity _quota;
    @Basic
    @Column(name = "`ProfilePicture`", nullable = false)
    private byte[] _profilePicture;
    @ManyToOne
    @JoinColumn( name="`FamilyId`" )
    private FamilyEntity _family;
    @OneToOne
    @JoinColumn(name = "`AuthorityId`", nullable = false)
    private AuthorityEntity _authority;
    @OneToMany(targetEntity = InvoiceEntity.class, mappedBy = "_user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InvoiceEntity> _invoices;

    public UserEntity() {
    }

    public UserEntity(
            String name,
            String lastname,
            CityEntity city,
            Timestamp birthdate,
            String gender,
            QuotaEntity quota,
            byte[] profilePicture,
            FamilyEntity family,
            AuthorityEntity authority,
            List<InvoiceEntity> invoices
    ) {
        _name = name;
        _lastname = lastname;
        _city = city;
        _birthdate = birthdate;
        _gender = gender;
        _quota = quota;
        _profilePicture = profilePicture;
        _family = family;
        _authority = authority;
        _invoices = invoices;
    }

    public int getId() {
        return _id;
    }

    public void setId(Integer id) {
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

    public FamilyEntity getFamily() {
        return _family;
    }

    public void setUserToFamily(FamilyEntity family) {
        _family = family;
    }

    public String getGender() {
        return _gender;
    }

    public void setGender(String gender) {
        _gender = gender;
    }

    public AuthorityEntity getAuthority() {
        return _authority;
    }

    public void setAuthority(AuthorityEntity authority) {
        _authority = authority;
    }

    public List<InvoiceEntity> getInvoices() {
        return _invoices;
    }

    public void setInvoices(List<InvoiceEntity> invoices) {
        _invoices = invoices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(_id, that._id) &&
                Objects.equals(_name, that._name) &&
                Objects.equals(_lastname, that._lastname) &&
                Objects.equals(_city, that._city) &&
                Objects.equals(_birthdate, that._birthdate) &&
                Objects.equals(_gender, that._gender) &&
                Objects.equals(_quota, that._quota) &&
                Arrays.equals(_profilePicture, that._profilePicture) &&
                Objects.equals(_family, that._family) &&
                Objects.equals(_authority, that._authority) &&
                Objects.equals(_invoices, that._invoices);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(
                _id, _name, _lastname, _city, _birthdate, _gender, _quota, _family, _authority, _invoices
        );
        result = 31 * result + Arrays.hashCode(_profilePicture);
        return result;
    }
}
