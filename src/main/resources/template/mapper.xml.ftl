<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

    <select id="pageList" resultType="com.example.${package.ModuleName}.vo.${entity}VO">
        select
        <#list table.commonFields as field>
            ${field.columnName},
        </#list>
        ${table.fieldNames}
        from ${table.name}
    </select>
</mapper>

