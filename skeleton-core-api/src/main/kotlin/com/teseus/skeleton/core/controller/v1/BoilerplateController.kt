package com.teseus.skeleton.core.controller.v1

import com.teseus.skeleton.core.controller.v1.request.BoilerplateRequest
import com.teseus.skeleton.core.controller.v1.response.BoilerplateResponse
import com.teseus.skeleton.core.domain.BoilerplateService
import com.teseus.skeleton.core.support.response.ApiResponse
import com.teseus.skeleton.db.core.BoilerplateRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class BoilerplateController(
    val skeletonService: BoilerplateService,
    val skeletonRepository: BoilerplateRepository
) {
    @PostMapping(
        value = ["/skeleton"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun examPost(
        @RequestBody request: BoilerplateRequest
    ): ApiResponse<BoilerplateResponse> {
        val skeleton = skeletonService.skeleton(request.toBoilerplateInfo())
        return ApiResponse.success(BoilerplateResponse(skeleton.message))
    }

    @GetMapping(value = ["/skeleton/{skeletonId}"])
    fun examGet(
        @PathVariable skeletonId: String
    ): ApiResponse<BoilerplateResponse> {
        skeletonRepository.findAll()
//        val skeleton = skeletonService.skeleton(BoilerplateBusinessInfo(skeletonId))
        return ApiResponse.success(BoilerplateResponse("dd"))
    }
}
