<section class="container content">
    <div class="columns">
        <div class="column two-thirds">
            <article class="article-content markdown-body">
                <section class="container posts-content">

                    <#list types as item>
                        <h3 id="${item.name}">${item.name}</h3>
                        <ol class="posts-list">
                        <#list item.bizArticles as article>
                            <li class="posts-list-item"> <span class="posts-list-meta">${article.createTime?string('yyyy-MM-dd')}</span> <a class="posts-list-name" href="${config.siteUrl}/article/${article.id}">${article.title}</a></li>
                        </#list>
                        </ol>
                    </#list>
                </section>
            </article>
            <div class="share"></div>
            <div class="comment"></div>
        </div>

        <#include "/layout/sidebarCategory.ftl"/>

    </div>
</section>

