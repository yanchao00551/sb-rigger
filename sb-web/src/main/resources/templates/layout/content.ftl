<section class="container content" xmlns="http://www.w3.org/1999/html">
    <div class="columns">
        <div class="column two-thirds">
            <ol class="repo-list">
                <#if page.list?? && (page.list?size >0)>
                    <#list page.list as item>
                        <li class="repo-list-item">
                            <h3 class="repo-list-name">
                                <a href="/article/${item.id}">${item.title}</a>
                            </h3>
                            <p class="repo-list-description">${item.description}</p>
                            <p class="repo-list-meta">

                                <span class="meta-info">
                                    <span class="octicon octicon-calendar"></span>
                                    ${item.createTime?string('yyyy-MM-dd')}
                                </span>

                                <#if item.tags?? &&(item.tags?size>0)>
                                    <#list item.tags as tag>
                                        <span class="meta-info">
                                        <span class="octicon octicon-file-directory"></span>
                                        <a href="${config.siteUrl}/tag/${tag.id}" title="${tag.name}">${tag.name}</a>
                                        </span>
                                    </#list>
                                <#else>
                                    <span class="meta-info">
                                    <span class="octicon octicon-file-directory"></span>
                                    <a href="#tags" title="无标签">无标签</a>
                                </span>
                                </#if>

                                <span><a href="#">浏览(${item.lookCount})</a></span>
                                <span<a href="#">评论(${item.commentCount})</a></span>

                            </p>
                        </li>
                    </#list>
                <#else>
                    <li class="repo-list-item">
                        <h3 class="repo-list-name">亲，啥也没找到啊~</h3>
                    </li>
                </#if>


            </ol>
        </div>

        <#include "/layout/sidebar.ftl"/>
    </div>

    <#--分页-->
    <@pageBar></@pageBar>

</section>
