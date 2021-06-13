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
    <meta name="keywords" content="${keywords}"/>
    <meta name="description" content="${description}" id="meta_description">
    <link rel="canonical" href="${config.siteUrl}"/>
    <#include "/layout/quote.ftl">
    <#nested>
</head>
<body class="home" data-mz="home">

<#include  "/include/top.ftl"/>
<#include "/layout/headerAbout.ftl"/>
</#macro>


<#-- 内容区域 -->
<#macro  content>
    <#include "/layout/contentAbout.ftl"/>
    <#nested>
</#macro>

<#-- 公共底部 -->
<#macro footer>
<#include "/layout/footer.ftl"/>
<#nested>
</body>
</html>
</#macro>

