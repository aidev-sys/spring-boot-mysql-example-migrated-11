package guru.springframework.converters;

import guru.springframework.commands.ProductForm;
import guru.springframework.domain.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class ProductFormToProduct implements Converter<ProductForm, Product> {

    @Override
    public Product convert(ProductForm productForm) {
        return convert(productForm, new Product());
    }

    /**
     * Converts a {@link ProductForm} into a {@link Product} and populates the provided target instance.
     * This overload is useful when callers need to update an existing {@link Product} rather than create a new one.
     *
     * @param productForm source form, never {@code null}
     * @param target      target product to populate, never {@code null}
     * @return the populated {@link Product} instance (the same as {@code target})
     */
    public Product convert(ProductForm productForm, Product target) {
        if (productForm == null) {
            return null;
        }

        if (productForm.getId() != null && !StringUtils.isEmpty(productForm.getId())) {
            target.setId(productForm.getId());
        }

        target.setDescription(productForm.getDescription());
        target.setPrice(productForm.getPrice());
        target.setImageUrl(productForm.getImageUrl());

        return target;
    }
}