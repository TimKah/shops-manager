package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.dto.ItemDTO;
import com.study.shopsmanager.dto.ShopDTO;
import com.study.shopsmanager.dto.ShopStockDTO;
import com.study.shopsmanager.entities.ItemEntity;
import com.study.shopsmanager.entities.ShopEntity;
import com.study.shopsmanager.entities.ShopStockEntity;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-05T11:49:56+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ShopStockMapperImpl implements ShopStockMapper {

    @Override
    public ShopStockDTO toShopStockDTO(ShopStockEntity shopStocks) {
        if ( shopStocks == null ) {
            return null;
        }

        ShopStockDTO shopStockDTO = new ShopStockDTO();

        shopStockDTO.setShop( shopEntityToShopDTO( shopStocks.getShop() ) );
        shopStockDTO.setItem( itemEntityToItemDTO( shopStocks.getItem() ) );
        shopStockDTO.setAmount( shopStocks.getAmount() );

        return shopStockDTO;
    }

    @Override
    public Collection<ShopStockDTO> toShopStockDTOs(Collection<ShopStockEntity> shopStocks) {
        if ( shopStocks == null ) {
            return null;
        }

        Collection<ShopStockDTO> collection = new ArrayList<ShopStockDTO>( shopStocks.size() );
        for ( ShopStockEntity shopStockEntity : shopStocks ) {
            collection.add( toShopStockDTO( shopStockEntity ) );
        }

        return collection;
    }

    @Override
    public ShopStockEntity toShopStockEntity(ShopStockDTO shopStock) {
        if ( shopStock == null ) {
            return null;
        }

        ShopStockEntity shopStockEntity = new ShopStockEntity();

        shopStockEntity.setShop( shopDTOToShopEntity( shopStock.getShop() ) );
        shopStockEntity.setItem( itemDTOToItemEntity( shopStock.getItem() ) );
        shopStockEntity.setAmount( shopStock.getAmount() );

        return shopStockEntity;
    }

    protected ShopDTO shopEntityToShopDTO(ShopEntity shopEntity) {
        if ( shopEntity == null ) {
            return null;
        }

        ShopDTO shopDTO = new ShopDTO();

        shopDTO.setName( shopEntity.getName() );

        return shopDTO;
    }

    protected ItemDTO itemEntityToItemDTO(ItemEntity itemEntity) {
        if ( itemEntity == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setName( itemEntity.getName() );
        itemDTO.setMeasure( itemEntity.getMeasure() );

        return itemDTO;
    }

    protected ShopEntity shopDTOToShopEntity(ShopDTO shopDTO) {
        if ( shopDTO == null ) {
            return null;
        }

        ShopEntity shopEntity = new ShopEntity();

        shopEntity.setName( shopDTO.getName() );

        return shopEntity;
    }

    protected ItemEntity itemDTOToItemEntity(ItemDTO itemDTO) {
        if ( itemDTO == null ) {
            return null;
        }

        ItemEntity itemEntity = new ItemEntity();

        itemEntity.setName( itemDTO.getName() );
        itemEntity.setMeasure( itemDTO.getMeasure() );

        return itemEntity;
    }
}
