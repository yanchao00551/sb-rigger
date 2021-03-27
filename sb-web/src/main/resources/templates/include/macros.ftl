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
    <link rel="canonical" href="${config.siteUrl}${canonical}" />
    <#include "/layout/quote.ftl">
    <#nested>
</head>
<body class="home" data-mz="home">

<#include "/layout/header.ftl"/>
</#macro>

<#-- 分页组件 -->
<#macro pageBar>
<div class="pagination text-align">
    <div class="btn-group"> <button disabled="disabled" href="javascript:;"
                                    class="btn btn-outline">&laquo;</button> <a href="javascript:;"
                                                                                class="active btn btn-outline">1</a> <a href="https://ebay-cloud.com/page2"
                                                                                                                        class="btn btn-outline">2</a> <a href="#url/page3" class="btn btn-outline">3</a>
        <a href="https://ebay-cloud.com/page4" class="btn btn-outline">4</a> <a
                href="https://ebay-cloud.com/page5" class="btn btn-outline">5</a> <a
                href="https://ebay-cloud.com/page6" class="btn btn-outline">6</a> <a
                href="https://ebay-cloud.com/page7" class="btn btn-outline">7</a> <a
                href="https://ebay-cloud.com/page8" class="btn btn-outline">8</a> <a
                href="https://ebay-cloud.com/page9" class="btn btn-outline">9</a> <a
                href="https://ebay-cloud.com/page10" class="btn btn-outline">10</a> <a
                href="https://ebay-cloud.com/page11" class="btn btn-outline">11</a> <a
                href="https://ebay-cloud.com/page12" class="btn btn-outline">12</a> <a
                href="https://ebay-cloud.com/page2" class="btn btn-outline">&raquo;</a></div>
</div>
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

