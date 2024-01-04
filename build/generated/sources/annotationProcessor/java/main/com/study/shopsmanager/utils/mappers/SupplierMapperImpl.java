package com.study.shopsmanager.utils.mappers;

import com.study.shopsmanager.dto.SupplierDTO;
import com.study.shopsmanager.entities.SupplierEntity;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-03T15:19:27+0200",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class SupplierMapperImpl implements SupplierMapper {

    @Override
    public SupplierDTO toSupplierDTO(SupplierEntity supplier) {
        if ( supplier == null ) {
            return null;
        }

        SupplierDTO supplierDTO = new SupplierDTO();

        supplierDTO.setName( supplier.getName() );

        return supplierDTO;
    }

    @Override
    public Collection<SupplierDTO> toSupplierDTOs(Collection<SupplierEntity> suppliers) {
        if ( suppliers == null ) {
            return null;
        }

        Collection<SupplierDTO> collection = new ArrayList<SupplierDTO>( suppliers.size() );
        for ( SupplierEntity supplierEntity : suppliers ) {
            collection.add( toSupplierDTO( supplierEntity ) );
        }

        return collection;
    }

    @Override
    public SupplierEntity toShopEntity(SupplierDTO supplier) {
        if ( supplier == null ) {
            return null;
        }

        SupplierEntity supplierEntity = new SupplierEntity();

        supplierEntity.setName( supplier.getName() );

        return supplierEntity;
    }
}
