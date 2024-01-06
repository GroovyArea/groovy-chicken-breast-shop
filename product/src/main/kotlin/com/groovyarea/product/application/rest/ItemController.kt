package com.groovyarea.product.application.rest

import com.groovyarea.global.dto.response.ResponseDTO
import com.groovyarea.product.application.ItemAppService
import com.groovyarea.product.application.dto.response.ItemDetailResponseDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

/**
 * 상품 관련 api controller
 */
@RestController
class ItemController(
    private val itemAppService: ItemAppService,
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
        val data = itemAppService.getItem(iid = iid)
        return ResponseDTO.success(data = data)
    }
}
