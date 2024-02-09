package com.groovyarea.global.pagination.dto.response

import com.groovyarea.global.dto.response.BaseResponseDTO
import com.groovyarea.global.dto.response.Meta
import com.groovyarea.global.model.MetaCode
import org.springframework.data.domain.Page

data class PageResponseDTO<T>(
    val pagination: Pagination,
    override val data: Collection<T>,
    override val meta: Meta,
) : com.groovyarea.global.dto.response.BaseResponseDTO<Collection<T>>(meta, data) {

    companion object {

        fun <E, T : Any> pageSuccess(
            page: Page<E>,
            data: Collection<T> = emptyList()
        ): PageResponseDTO<T> =
            PageResponseDTO(
                pagination = Pagination(
                    pageNumber = page.number + 1,
                    pageSize = page.size,
                    totalPage = page.totalPages,
                    totalCount = page.totalElements
                ),
                data = data,
                meta = Meta(type = MetaCode.SUCCESS),
            )
    }

    data class Pagination(
        val pageNumber: Int,
        val pageSize: Int,
        val totalPage: Int,
        val totalCount: Long,
    )
}
