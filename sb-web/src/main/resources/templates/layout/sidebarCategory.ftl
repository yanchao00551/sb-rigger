<div class="column one-fourth">
    <h3>Search</h3>
    <div id="site_search">
        <input style="width:66%" type="text" id="search_box" placeholder="Search">
        <button class="btn" type="button">搜索</button>

    </div>
    <ul id="search_results"
        style="font-size:14px;list-style-type:none;padding-top:10px;padding-left:10px;"></ul>


    <h3>Blog Categories</h3>
    <div id="blog-categories">
        <ul class="list-group">
            <#list types as item>
                <li class="list-group-item"> <a href="#${item.name}">${item.name}</a> <span class="badge">${item.bizArticles?size}</span></li>
            </#list>
        </ul>
    </div>

</div>