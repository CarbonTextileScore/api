package fr.carbon.textile.score.api.service.market.information;

import fr.carbon.textile.score.api.dto.market.information.ProductDTO;
import fr.carbon.textile.score.api.exception.CustomException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.lang.NonNull;

import java.util.List;

public interface ProductService {
    int calculateQuotaFromProductId(@Valid @NonNull @PositiveOrZero Integer id) throws CustomException;

    List<Integer> calculateQuotaFromProductsId(@Valid @NotEmpty List<Integer> ids) throws CustomException;

    List<ProductDTO> getAllProducts() throws CustomException;
}
