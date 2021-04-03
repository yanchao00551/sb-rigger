<#-- 公共顶部 -->
<#macro header title="E度云空间" keywords="" description="" canonical="" hasEditor=false>
<#include "/common/annotation.ftl">
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>${title}</title>
    <meta name="author" content="${config.authorName}(${config.authorEmail})">
    <meta name="keywords" content="${keywords}"/>
    <meta name="description" content="${description}" id="meta_description">
    <link rel="canonical" href="${config.siteUrl}"/>
    <#include "/layout/quote.ftl">
    <#nested>
</head>
<body class="home" data-mz="home">

<#include "/layout/header.ftl"/>
</#macro>

<#-- 分页组件 -->
<#macro pageBar>
    <#if page?? && (page.pages > 1)>
    <div class="pagination text-align">
        <div class="btn-group">
            <#if page.isFirstPage==false>
                <button href="javascript:;" class="btn btn-outline">&laquo;</button>
            <#else>
                <button disabled="disabled" href="javascript:;" class="btn btn-outline">&laquo;</button>
            </#if>
            <#list page.navigatepageNums as element>
                <#if element==page.pageNum >
                    <a href="javascript:;" class="active btn btn-outline">${element}</a>
                </#if>
                <#if element!=page.pageNum>
                    <a href="javascript:;" class="btn btn-outline">${element}</a>
                </#if>
            </#list>
            <#if page.isLastPage == false>
                <a href="#url" class="btn btn-outline">&raquo;</a>
            <#else>
                <a href="#url" disabled="disabled" class="btn btn-outline">&raquo;</a>
            </#if>
        </div>
    </div>

    </#if>
    <#nested>
</#macro>

<#-- 内容区域 -->
<#macro  content>
    <#include "/layout/content.ftl"/>
    <#nested>
</#macro>

<#-- 公共底部 -->
<#macro footer>
<#include "/layout/footer.ftl"/>
<#nested>
</body>
</html>
</#macro>

