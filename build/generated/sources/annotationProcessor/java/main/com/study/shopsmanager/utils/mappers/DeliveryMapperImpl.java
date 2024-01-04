package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.dto.DeliveryDTO;
import com.study.shopsmanager.dto.ItemDTO;
import com.study.shopsmanager.dto.ShopDTO;
import com.study.shopsmanager.dto.SupplierDTO;
import com.study.shopsmanager.entities.DeliveryEntity;
import com.study.shopsmanager.entities.ItemEntity;
import com.study.shopsmanager.entities.ShopEntity;
import com.study.shopsmanager.entities.SupplierEntity;
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
public class DeliveryMapperImpl implements DeliveryMapper {

    @Override
    public DeliveryDTO toDeliveryDTO(DeliveryEntity delivery) {
        if ( delivery == null ) {
            return null;
        }

        DeliveryDTO deliveryDTO = new DeliveryDTO();

        deliveryDTO.setSupplier( supplierEntityToSupplierDTO( delivery.getSupplier() ) );
        deliveryDTO.setShop( shopEntityToShopDTO( delivery.getShop() ) );
        deliveryDTO.setItem( itemEntityToItemDTO( delivery.getItem() ) );
        deliveryDTO.setAmount( delivery.getAmount() );
        deliveryDTO.setDate( delivery.getDate() );

        return deliveryDTO;
    }

    @Override
    public Collection<DeliveryDTO> toDeliveryDTOs(Collection<DeliveryEntity> deliveries) {
        if ( deliveries == null ) {
            return null;
        }

        Collection<DeliveryDTO> collection = new ArrayList<DeliveryDTO>( deliveries.size() );
        for ( DeliveryEntity deliveryEntity : deliveries ) {
            collection.add( toDeliveryDTO( deliveryEntity ) );
        }

        return collection;
    }

    @Override
    public DeliveryEntity toDeliveryEntity(DeliveryDTO delivery) {
        if ( delivery == null ) {
            return null;
        }

        DeliveryEntity deliveryEntity = new DeliveryEntity();

        deliveryEntity.setSupplier( supplierDTOToSupplierEntity( delivery.getSupplier() ) );
        deliveryEntity.setShop( shopDTOToShopEntity( delivery.getShop() ) );
        deliveryEntity.setItem( itemDTOToItemEntity( delivery.getItem() ) );
        deliveryEntity.setAmount( delivery.getAmount() );
        deliveryEntity.setDate( delivery.getDate() );

        return deliveryEntity;
    }

    protected SupplierDTO supplierEntityToSupplierDTO(SupplierEntity supplierEntity) {
        if ( supplierEntity == null ) {
            return null;
        }

        SupplierDTO supplierDTO = new SupplierDTO();

        supplierDTO.setName( supplierEntity.getName() );

        return supplierDTO;
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

    protected SupplierEntity supplierDTOToSupplierEntity(SupplierDTO supplierDTO) {
        if ( supplierDTO == null ) {
            return null;
        }

        SupplierEntity supplierEntity = new SupplierEntity();

        supplierEntity.setName( supplierDTO.getName() );

        return supplierEntity;
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
