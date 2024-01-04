package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.dto.ItemDTO;
import com.study.shopsmanager.entities.ItemEntity;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-03T15:46:05+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemDTO toItemDTO(ItemEntity item) {
        if ( item == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setName( item.getName() );
        itemDTO.setMeasure( item.getMeasure() );

        return itemDTO;
    }

    @Override
    public Collection<ItemDTO> toItemDTOs(Collection<ItemEntity> items) {
        if ( items == null ) {
            return null;
        }

        Collection<ItemDTO> collection = new ArrayList<ItemDTO>( items.size() );
        for ( ItemEntity itemEntity : items ) {
            collection.add( toItemDTO( itemEntity ) );
        }

        return collection;
    }

    @Override
    public ItemEntity toItemEntity(ItemDTO item) {
        if ( item == null ) {
            return null;
        }

        ItemEntity itemEntity = new ItemEntity();

        itemEntity.setName( item.getName() );
        itemEntity.setMeasure( item.getMeasure() );

        return itemEntity;
    }
}
