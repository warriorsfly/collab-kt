package com.winning.com.winning.schema

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column

object MessageServices: IdTable<String>("YWXT_JCPZ"){

    /** 应用编码 */
    override val id: Column<EntityID<String>>
        get() = varchar("YYBM",64).entityId()

    /** 应用名称 */
    val name = varchar("YYMC",200)


    /** 打开方式 */
    val mode = varchar("JCFS",1)


    /** 服务类型 */
    val type =varchar("FWLX",1)

    /** URL */
    val url = varchar("URL",200)

    /** 执行方式 */
    val execution = integer("ZXFS")
}


