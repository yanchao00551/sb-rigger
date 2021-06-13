<header class="site-header">
    <div class="container">
        <h1>
            <a href="${config.siteUrl}" title="码趣"><span class="octicon octicon-mark-github"></span> 码趣</a>
        </h1>

        <button class="collapsed mobile-visible" type="button" onclick="toggleMenu();">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <nav class="site-header-nav" role="navigation">
            <a href="${config.siteUrl}" class="<#if url == "index">selected </#if> site-header-nav-item" target="" title="首页">首页</a>
            <a href="${config.siteUrl}/categories/" class="<#if url == "Categories">selected </#if>site-header-nav-item" target="" title="分类">分类</a>
            <a href="${config.siteUrl}/links/" class="<#if url == "Links">selected </#if> site-header-nav-item" target="" title="链接">链接</a>
            <a href="${config.siteUrl}/about/" class="<#if url == "About">selected </#if>  site-header-nav-item" target="" title="关于">关于</a>
        </nav>

</div>
</header>