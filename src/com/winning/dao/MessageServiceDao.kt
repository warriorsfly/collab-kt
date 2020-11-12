package com.winning.repository.dao

import com.winning.com.winning.schema.MessageServices
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

//协同基础服务配置
class MessageService(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, MessageService>(MessageServices)

    /** 应用名称 */
    var name by MessageServices.name


    /** 打开方式 */
    var mode by MessageServices.mode


    /** 服务类型 */
    var type by MessageServices.type

    /** URL */
    var url by MessageServices.url

    /** 执行方式 */
    var execution by MessageServices.execution
}