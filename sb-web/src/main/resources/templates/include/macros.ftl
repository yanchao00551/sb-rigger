<#-- 公共顶部 -->
<#macro header title="码趣" keywords="" description="" canonical="" hasEditor=false>
<#include "/common/annotation.ftl">
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <title>${title}</title>
    <meta name="author" content="${config.authorName}(${config.authorEmail})">
    <link rel="shortcut icon" href="https://cdn.jsdelivr.net/gh/yanchao00551/BlogAssets@1.0/favicon.ico">
    <meta name="keywords" content="${keywords}"/>
    <meta name="description" content="${description}" id="meta_description">
    <link rel="canonical" href="${config.siteUrl}"/>
    <#include "/layout/quote.ftl">
    <#nested>
</head>
<body class="home" data-mz="home">
<#include  "/include/top.ftl"/>
<#include "/layout/header.ftl"/>
</#macro>

<#-- 分页组件 -->
<#macro pageBar>

    <#if page?? && (page.pages > 1)>
    <div class="pagination text-align">
        <div class="btn-group">
            <#if page.isFirstPage == false>
                <a href="/index/${page.prePage}" class="btn btn-outline">&laquo;</a>
                <a href="/index/${page.navigateFirstPage}">首页</a>
            <#else>
                <a disabled="disabled" href="javascript:;" class="btn btn-outline">&laquo;</a>
            </#if>
            <#list page.navigatepageNums as element>
                <#if element==page.pageNum >
                    <a href="/index/${element}" class="active btn btn-outline">${element}</a>
                </#if>
                <#if element!=page.pageNum>
                    <a href="/index/${element}" class="btn btn-outline">${element}</a>
                </#if>
            </#list>
            <#if page.isLastPage == false>
                <a href="/index/${page.nextPage}" class="btn btn-outline">&raquo;</a>
                <a href="/index/${page.navigateLastPage}">尾页</a>
            <#else>
                <a href="javascript:;" disabled="disabled" class="btn btn-outline">&raquo;</a>
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

