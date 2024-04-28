package com.groovyarea.cart.application.rest

import com.groovyarea.cart.application.dto.response.CartItemListResponseDTO
import com.groovyarea.cart.application.service.CartAppService
import com.groovyarea.global.dto.response.ResponseDTO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class CartController(
    private val cartAppService: CartAppService,
) {

    /**
     * 장바구니 상품 조회
     *
     * @param uid: user external key
     * @param cid : cart external key
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/v1/users/{uid}/carts/{cid}")
    suspend fun getCartList(
        @PathVariable uid: String,
        @PathVariable cid: String,
    ): ResponseDTO<CartItemListResponseDTO> {
        val data = cartAppService.getCartDetail(
            uid = uid,
            cid = cid
        )

        return ResponseDTO.success(data = data)
    }
}
