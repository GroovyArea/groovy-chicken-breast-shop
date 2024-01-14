package com.groovyarea.product.application.rest

import com.groovyarea.global.dto.response.ResponseDTO
import com.groovyarea.product.application.dto.request.ItemRegisterRequestDTO
import com.groovyarea.product.application.dto.request.ItemUpdateRequestDTO
import com.groovyarea.product.application.service.ItemCrudAppService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemAdminController(
    private val itemCrudAppService: ItemCrudAppService,
) {

    /**
     * 상품 등록
     *
     * @param requestDTO 등록 Dto
     *
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/v1/items")
    suspend fun register(
        @RequestBody requestDTO: ItemRegisterRequestDTO,
    ): ResponseDTO<Unit> {
        itemCrudAppService.register(itemRegisterRequestDTO = requestDTO)

        return ResponseDTO.created()
    }

    /**
     * 상품 수정
     *
     * @param requestDTO 수정 Dto
     */
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/api/v1/items")
    suspend fun update(
        @RequestBody requestDTO: ItemUpdateRequestDTO,
    ): ResponseDTO<Unit> {
        itemCrudAppService.update(itemUpdateRequestDTO = requestDTO)

        return ResponseDTO.success()
    }

    /**
     * 상품 삭제
     *
     * @param iid 상품 고유 번호
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/api/v1/items/{iid}")
    suspend fun delete(
        @PathVariable iid: String,
    ): ResponseDTO<Unit> {
        itemCrudAppService.delete(iid = iid)

        return ResponseDTO.success()
    }
}
