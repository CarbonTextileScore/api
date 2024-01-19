package fr.carbon.textile.score.api.service.market.information;

import fr.carbon.textile.score.api.database.entity.market.information.FabricsToProductEntity;
import fr.carbon.textile.score.api.database.entity.market.information.ProductEntity;
import fr.carbon.textile.score.api.database.entity.user.information.CountryEntity;
import fr.carbon.textile.score.api.dto.market.information.ProductDTO;
import fr.carbon.textile.score.api.exception.CustomException;
import fr.carbon.textile.score.api.repository.market.information.ProductRepository;
import fr.carbon.textile.score.api.repository.user.information.CountryRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.*;

@Service
@Validated
public class ProductServiceImpl implements ProductService {
    private final ProductRepository _productRepository;
    private final CountryRepository _countryRepository;
    private final static double C_1 = 0.1d;
    private final static double C_2 = 0.3d;
    private final static double C_3 = 0.2d;
    private final static double C_5 = 0.4d;
    private final Map<String, Double> _map;

    public ProductServiceImpl(ProductRepository productRepository, CountryRepository countryRepository) {
        super();
        _productRepository = productRepository;
        _countryRepository = countryRepository;
        _map = new HashMap<>();
        _map.put("ANIMAL", 2d);
        _map.put("ORGANIC_VEGETATION", 1d);
        _map.put("OTHER", 1.5d);
    }

    public static double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371.0;

        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        double dlat = lat2 - lat1;
        double dlon = lon2 - lon1;

        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }

    @Override
    public int calculateQuotaFromProductId(@Valid @NonNull @PositiveOrZero Integer id) throws CustomException {
        Optional<ProductEntity> optionalProduct = _productRepository.queryByIdWithFabrics(id);
        CountryEntity france = _countryRepository.queryFrance();
        if (optionalProduct.isEmpty()) {
            throw new CustomException("Error, this product id does not exists, id = " + id);
        }
        double total = 0;
        ProductEntity product = optionalProduct.get();
        for (FabricsToProductEntity data : product.getFabrics()) {
            double sum = calculateQuotaWithAGivenFabric(data, product, france, _map);
            if (product.isSecondHand()) {
                sum = C_5 * calculateHaversineDistance(
                        product.getCountry().getLat(), product.getCountry().getLon(),
                        france.getLat(), france.getLon()
                );
            }
            total += sum;
        }

        return (int) Math.round(total / 100);
    }

    private static double calculateQuotaWithAGivenFabric(FabricsToProductEntity data, ProductEntity product, CountryEntity france, Map<String, Double> originCoefficient) {
        double quotaArea = C_1 * product.getArea();
        double quotaWaterMass = C_2 *
                data.getFabric().getWaterConsumptionCubicCentimeterPerGram() *
                product.getMass();
        double quotaCarbon = C_3 *
                data.getFabric().getKilogramCO2EquivalentPerSquareMetre();
        double totalDistance = calculateHaversineDistance(
                product.getCountry().getLat(), product.getCountry().getLon(),
                france.getLat(), france.getLon()
        );
        totalDistance += calculateHaversineDistance(
                data.getFabric().getCountry().getLat(), data.getFabric().getCountry().getLon(),
                france.getLat(), france.getLon()
        );
        double quotaLength = C_5 * totalDistance;
        double sum = (quotaArea + quotaLength + quotaCarbon + quotaWaterMass) *
                originCoefficient.get(data.getFabric().getFabricAnimalOrigin().getName()) *
                ((double) data.getPercentage() / 100);
        return sum;
    }

    @Override
    public List<Integer> calculateQuotaFromProductsId(List<Integer> ids) throws CustomException {
        List<Integer> quotas = new ArrayList<>();
        for (Integer id : ids) {
            quotas.add(calculateQuotaFromProductId(id));
        }
        return quotas;
    }

    @Override
    public List<ProductDTO> getAllProducts() throws CustomException {
        List<ProductDTO> DTOs = new ArrayList<>();
        for (ProductEntity entity : _productRepository.findAll()) {
            if (entity.isSold()) {
                continue;
            }
            DTOs.add(ProductDTO.builder()
                    .productTypeId(entity.getProductType().getId())
                    .name(entity.getName())
                    .price(entity.getPrice())
                    .countryName(entity.getCountry().getName())
                    .description(entity.getDescription())
                    .quota(calculateQuotaFromProductId(entity.getId()))
                    .isSecondHand(entity.isSecondHand())
                    .build());
        }
        return DTOs;
    }
}
