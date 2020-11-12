package com.winning.com.winning.schema

import org.jetbrains.exposed.sql.Table

object Applicas: Table("YWXT_JCPZ"){


    /** 应用编码 */
    val id =  varchar("YYBM",64).uniqueIndex()

    /** 应用名称 */
    val name = varchar("YYMC",200)
    /** 服务类型 */
    val type =varchar("FWLX",1)

    /** 打开方式 */
    val mode = varchar("JHFS",1)

    /** URL */
    val url = varchar("URL",200)

    /** SQL */
    val sql = varchar("SQL",500)

    /** 参数格式 */
    val dyrc = varchar("DYRC",2000)

    /** 响应时间 */
    val timeout = integer("XYSJ")

    val sjfhmb = varchar("SJFHMB",1)

    /** 执行方式 */
    val execution = varchar("ZXFS",1)

    val djbb = varchar("DJBB",1)

    val jlzt = varchar("JLZT",1)

    val urlfun=text("URLFUN")
    val dyrcfun = text("DYRCFUN")
    val xxsx =varchar("XXSX",200)
    override val primaryKey by lazy {
        super.primaryKey?:PrimaryKey(id,name="PK_YWXT_JCPZ")
    }
}

data class Applica(val code:String,
                   var name:String,
                   var type:String?,
                   var mode:String,
                   var url:String?,
                   var sql:String?,
                   var dyrc:String?,
                   var timeout:Int?,
                   var sjfhmb:String?,
                   var excution:String?,
                   var djbb:String?,
                   var jlzt:String?,
                   var urlfun:String?,
                   var dyrcfun:String?,
                   var xxsx:String?)



