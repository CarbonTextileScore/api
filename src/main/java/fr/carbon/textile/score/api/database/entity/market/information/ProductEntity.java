package fr.carbon.textile.score.api.database.entity.market.information;

import fr.carbon.textile.score.api.database.entity.user.information.CountryEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity(name = "Product")
@Table(name = "`Product`", schema = "`MarketInformation`", catalog = "postgres")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "`id`")
    private Integer _id;
    @Basic
    @Column(name = "`Name`", nullable = false)
    private String _name;
    @Basic
    @Column(name = "`Area`", nullable = false, precision = 4)
    private double _area;
    @Basic
    @Column(name = "`IsSecondHand`", nullable = false)
    private boolean _isSecondHand = false;
    @Basic
    @Column(name = "`IsSold`", nullable = false)
    private boolean _isSold = false;
    @Basic
    @Column(name = "`Price`", nullable = false, precision = 4)
    private double _price;
    @Basic
    @Column(name = "`Mass`", nullable = false, precision = 4)
    private double _mass;
    @Basic
    @Column(name = "`Description`", nullable = false)
    private String _description;
    @Basic
    @Column(name = "`ProfilePicture`", nullable = false)
    private byte[] _profilePicture;
    @ManyToOne
    @JoinColumn(name = "`ProductTypeId`", nullable = false)
    ProductTypeEntity _productType;
    @ManyToOne
    @JoinColumn(name = "`CountryId`", nullable = false)
    CountryEntity _country;
    @OneToMany(mappedBy = "_product")
    private List<FabricsToProductEntity> _fabrics;

    public ProductEntity() {
    }

    public ProductEntity(
            String name,
            Double area,
            boolean isSecondHand,
            List<FabricsToProductEntity> fabrics,
            ProductTypeEntity productType,
            Double price,
            Double mass,
            String description,
            CountryEntity country,
            byte[] profilePicture
    ) {
        _name = name;
        _area = area;
        _isSecondHand = isSecondHand;
        _fabrics = fabrics;
        _productType = productType;
        _price = price;
        _mass = mass;
        _description = description;
        _profilePicture = profilePicture;
        _country = country;
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

    public List<FabricsToProductEntity> getFabrics() {
        return _fabrics;
    }

    public void setFabrics(List<FabricsToProductEntity> fabric) {
        _fabrics = fabric;
    }

    public double getArea() {
        return _area;
    }

    public void setArea(double area) {
        _area = area;
    }

    public boolean isSecondHand() {
        return _isSecondHand;
    }

    public void setSecondHand(boolean secondHand) {
        _isSecondHand = secondHand;
    }

    public boolean isSold() {
        return _isSold;
    }

    public void setSold(boolean sold) {
        _isSold = sold;
    }

    public ProductTypeEntity getProductType() {
        return _productType;
    }

    public void setProductType(ProductTypeEntity productType) {
        _productType = productType;
    }

    public double getPrice() {
        return _price;
    }

    public void setPrice(double price) {
        _price = price;
    }

    public double getMass() {
        return _mass;
    }

    public void setMass(double mass) {
        this._mass = mass;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        this._description = description;
    }

    public byte[] getProfilePicture() {
        return _profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this._profilePicture = profilePicture;
    }

    public CountryEntity getCountry() {
        return _country;
    }

    public void setCountry(CountryEntity country) {
        this._country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Double.compare(_area, that._area) == 0 &&
                _isSecondHand == that._isSecondHand &&
                _isSold == that._isSold &&
                Double.compare(_price, that._price) == 0 &&
                Double.compare(_mass, that._mass) == 0 &&
                Objects.equals(_id, that._id) &&
                Objects.equals(_name, that._name) &&
                Objects.equals(_description, that._description) &&
                Objects.equals(_productType, that._productType) &&
                Objects.equals(_country, that._country) &&
                Objects.equals(_fabrics, that._fabrics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                _id, _name, _area, _isSecondHand, _isSold, _price, _mass, _description, _productType, _country, _fabrics
        );
    }
}
