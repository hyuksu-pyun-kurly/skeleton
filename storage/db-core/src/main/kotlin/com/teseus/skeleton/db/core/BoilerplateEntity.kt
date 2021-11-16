package com.teseus.skeleton.db.core

import javax.persistence.Entity

@Entity
class BoilerplateEntity(
    val skeletonColumn: String
) : BaseEntity()
