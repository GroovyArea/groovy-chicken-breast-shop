package com.groovyarea.product.domain.mapper

import com.groovyarea.product.application.dto.response.ItemDetailResponseDTO
import com.groovyarea.product.domain.entity.document.Item
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants
import org.mapstruct.NullValuePropertyMappingStrategy
import org.mapstruct.ReportingPolicy
import org.mapstruct.factory.Mappers

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
)
interface ItemMapper {

    companion object {
        val INSTANCE: ItemMapper = Mappers.getMapper(
            ItemMapper::class.java
        )
    }

    fun convertToItemDetailResponseDTO(
        item: Item
    ): ItemDetailResponseDTO
}
