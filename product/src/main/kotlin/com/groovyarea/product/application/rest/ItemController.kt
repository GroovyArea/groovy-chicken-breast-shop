package com.groovyarea.product.application.rest

import com.groovyarea.global.dto.response.ResponseDTO
import com.groovyarea.global.pagination.dto.PageDTO
import com.groovyarea.product.application.dto.request.ItemSearchRequestDTO
import com.groovyarea.product.application.dto.response.ItemDetailResponseDTO
import com.groovyarea.product.application.dto.response.ItemListResponseDTO
import com.groovyarea.product.application.service.ItemSearchAppService
import com.groovyarea.product.domain.enumerate.ChickenCategories
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * 상품 관련 api controller
 */
@RestController
class ItemController(
    private val itemSearchAppService: ItemSearchAppService,
) {

    /**
     * 단건 상품 조회
     *
     * @param iid : item external key
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/v1/items/{iid}")
    suspend fun getItemDetail(
        @PathVariable iid: String
    ): ResponseDTO<ItemDetailResponseDTO> {
        val data = itemSearchAppService.getItem(iid = iid)
        return ResponseDTO.success(data = data)
    }

    /**
     * 상품 리스트 페이징 조회 (카테고리 별)
     *
     * @param category 카테고리
     */
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/api/v1/items/category/{category}")
    suspend fun getItems(
        @PathVariable category: ChickenCategories,
        @RequestParam pageNumber: Int = 1,
        @RequestParam pageSize: Int = 10
    ): ResponseDTO<List<ItemListResponseDTO>> {
        val pageDTO = PageDTO.of(
            pageNumber = pageNumber,
            pageSize = pageSize
        )
        val data = itemSearchAppService.getItems(
            category = category,
            pageDTO = pageDTO
        )
        return ResponseDTO.success(data = data)
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping("/api/v1/items/search/{category}")
    suspend fun getSearchedItems(
        @PathVariable category: ChickenCategories,
        @RequestParam pageNumber: Int = 1,
        @RequestParam pageSize: Int = 10,
        itemSearchRequestDTO: ItemSearchRequestDTO
    ): ResponseDTO<List<ItemListResponseDTO>> {
        val pageDTO = PageDTO.of(
            pageNumber = pageNumber,
            pageSize = pageSize
        )
        val data = itemSearchAppService.getSearchedItems(
            itemSearchRequestDTO = itemSearchRequestDTO,
            pageDTO = pageDTO,
            category = category
        )
        return ResponseDTO.success(data = data)
    }
}
