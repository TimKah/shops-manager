package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.dto.ShopDTO;
import com.study.shopsmanager.entities.ShopEntity;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-03T15:47:52+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ShopMapperImpl implements ShopMapper {

    @Override
    public ShopDTO toShopDTO(ShopEntity shop) {
        if ( shop == null ) {
            return null;
        }

        ShopDTO shopDTO = new ShopDTO();

        shopDTO.setName( shop.getName() );

        return shopDTO;
    }

    @Override
    public Collection<ShopDTO> toShopDTOs(Collection<ShopEntity> shops) {
        if ( shops == null ) {
            return null;
        }

        Collection<ShopDTO> collection = new ArrayList<ShopDTO>( shops.size() );
        for ( ShopEntity shopEntity : shops ) {
            collection.add( toShopDTO( shopEntity ) );
        }

        return collection;
    }

    @Override
    public ShopEntity toShopEntity(ShopDTO shop) {
        if ( shop == null ) {
            return null;
        }

        ShopEntity shopEntity = new ShopEntity();

        shopEntity.setName( shop.getName() );

        return shopEntity;
    }
}
