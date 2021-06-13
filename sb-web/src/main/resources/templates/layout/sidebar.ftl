<div class="column one-third">
    <h3>Search</h3>
    <div id="site_search">
        <input style="width:66%" type="text" id="search_box" placeholder="Search">
        <button class="btn" type="button">搜索</button>

    </div>
    <ul id="search_results"
        style="font-size:14px;list-style-type:none;padding-top:10px;padding-left:10px;"></ul>

    <h3>标签云</h3>

    <div class="Box">
        <@cloudTag method="tagsList" pageSize="10">
            <#if tagsList?? && (tagsList?size > 0)>
                <#list tagsList as item>
                    <a style="font-size: <@cloudTag method="random" max="15" min="10">${random}</@cloudTag>pt;color:<@cloudTag method="color">${color}</@cloudTag>" href="${config.siteUrl}/tag/${item.id?c}" title="${item.name!}">
                        ${item.name!}
                    </a>
                </#list>
            </#if>
        </@cloudTag>
    </div>

    <h3>文章推荐</h3>

    <div class="tabnav">

        <div class="Box Box--condensed detail">
            <ul>
                <@articleTag method="recentArticles" pageSize="10">
                    <#if recentArticles?? && (recentArticles?size > 0)>
                        <#list recentArticles as item>
                            <li class="Box-row">
                                <a href="${config.siteUrl}/article/${item.id?c}" title="${item.title}">
                                     ${item.title}
                                </a>
                            </li>
                        </#list>
                    <#else>
                        <li class="Box-row">
                            暂无相关文章
                        </li>
                    </#if>
                </@articleTag>
            </ul>
        </div>

    </div>



    <div class="Box Box--blue Box--condensed">
        <ul>
            <@cloudTag method="siteInfo">
                <li class="Box-row">文章总数：${siteInfo.articleCount!(0)} 篇</li>
                <li class="Box-row">标签总数：${siteInfo.tagCount!(0)} 个</li>
                <li class="Box-row">分类总数：${siteInfo.typeCount!(0)} 个</li>
                <li class="Box-row">留言数量：${siteInfo.commentCount!(0)} 条</li>
                <li class="Box-row">在线人数：<span class="online">1</span>人</li>
                <li class="Box-row">运行天数：${siteInfo.installdate!(1)}天</li>
                <li class="Box-row">最后更新：${siteInfo.lastUpdateTime!("暂无更新记录")}</li>
            </@cloudTag>
        </ul>
    </div>


</div>