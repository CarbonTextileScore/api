package fr.carbon.textile.score.api.database.initialisation;

import fr.carbon.textile.score.api.database.entity.market.information.ProductTypeEntity;
import fr.carbon.textile.score.api.database.entity.user.information.RoleEntity;
import fr.carbon.textile.score.api.database.entity.user.information.UserEntity;
import fr.carbon.textile.score.api.dto.user.information.InvoiceDTO;
import fr.carbon.textile.score.api.mapper.market.information.ProductTypeMapper;
import fr.carbon.textile.score.api.mapper.user.information.InvoiceMapper;
import fr.carbon.textile.score.api.mapper.user.information.UserMapper;
import fr.carbon.textile.score.api.repository.market.information.ProductTypeRepository;
import fr.carbon.textile.score.api.repository.user.information.InvoiceRepository;
import fr.carbon.textile.score.api.repository.user.information.RoleRepository;
import fr.carbon.textile.score.api.repository.user.information.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Configuration
public class InvoiceInitialisation {
    @Value("${carbon.textile.score.db.initialization}")
    Boolean _isDbInitializationUp;
    @Value("${carbon.textile.score.db.initialization.number.min.invoice.generated.per.user}")
    Integer _minInvoiceToGenerate;
    @Value("${carbon.textile.score.db.initialization.number.max.invoice.generated.per.user}")
    Integer _maxInvoiceToGenerate;
    @Value("${carbon.textile.score.db.initialization.number.min.invoice.quota.generated.per.user}")
    Integer _minInvoiceQuotaToGenerate;
    @Value("${carbon.textile.score.db.initialization.number.max.invoice.quota.generated.per.user}")
    Integer _maxInvoiceQuotaToGenerate;
    @Value("${carbon.textile.score.db.initialization.number.min.invoice.price.generated.per.user}")
    Double _minInvoicePriceToGenerate;
    @Value("${carbon.textile.score.db.initialization.number.max.invoice.price.generated.per.user}")
    Double _maxInvoicePriceToGenerate;
    private final InvoiceRepository _invoiceRepository;
    private final UserRepository _userRepository;
    private final RoleRepository _roleRepository;
    private final ProductTypeRepository _productTypeRepository;
    private final ProductTypeMapper _productTypeMapper;
    private final UserMapper _userMapper;
    private final InvoiceMapper _invoiceMapper;

    public InvoiceInitialisation(
            InvoiceRepository invoiceRepository,
            UserRepository userRepository,
            RoleRepository roleRepository,
            ProductTypeRepository productTypeRepository,
            ProductTypeMapper productTypeMapper,
            UserMapper userMapper,
            InvoiceMapper invoiceMapper
    ) {
        _invoiceRepository = invoiceRepository;
        _userRepository = userRepository;
        _roleRepository = roleRepository;
        _productTypeRepository = productTypeRepository;
        _productTypeMapper = productTypeMapper;
        _userMapper = userMapper;
        _invoiceMapper = invoiceMapper;
    }

    @PostConstruct
    public void initiate() {
        if (!_isDbInitializationUp) {
            return;
        }
        initiateInvoice();
    }

    private void initiateInvoice() {
        Random random = new Random();
        RoleEntity role = _roleRepository.queryUserRoleName();
        List<ProductTypeEntity> poolOfProductTypes = _productTypeRepository.findAll();
        for (UserEntity user : _userRepository.queryAllWithInvoicesByAuthorityRole(role.getName())) {
            if (!user.getInvoices().isEmpty()) {
                continue;
            }
            int numberToGenerate = random.nextInt(_minInvoiceToGenerate, _maxInvoiceToGenerate);
            generateInvoicesFromUserData(user, numberToGenerate, random, poolOfProductTypes);
        }
    }

    private void generateInvoicesFromUserData(
            UserEntity user, int numberToGenerate, Random random, List<ProductTypeEntity> poolOfProductTypes
    ) {
        for (int i = 0; i < numberToGenerate; i++) {
            Date date = new Date(LocalDate.now().withYear(30).toEpochDay());
            int quota = random.nextInt(_minInvoiceQuotaToGenerate, _maxInvoiceQuotaToGenerate);
            ProductTypeEntity productType = poolOfProductTypes.get(
                    random.nextInt(0, poolOfProductTypes.size())
            );
            double price = random.nextDouble(_minInvoicePriceToGenerate, _maxInvoicePriceToGenerate);
            if (random.nextDouble(0d, 1d) < 0.15) {
                price = - price;
                quota = - (quota / 2);
            }
            InvoiceDTO built = InvoiceDTO.builder()
                    .date(date)
                    .quota(quota)
                    .productType(_productTypeMapper.toDTO(productType))
                    .user(_userMapper.toDTO(user))
                    .productPrice(price)
                    .build();
            _invoiceRepository.save(_invoiceMapper.toEntity(built));
        }
    }
}
