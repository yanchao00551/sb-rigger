<section class="container content">
    <div class="columns">
        <div class="column two-thirds">
            <article class="article-content markdown-body">
                <p>我是颜超，感受写代码的乐趣。</p>
                <p>仰慕「优雅编码的艺术」。</p>
                <p>静以修身，俭以养德，勤以自强，达以欢愉！</p>
                <h2 id="联系">联系</h2>
                <ul>
                    <li>GitHub：<a href="https://github.com/yanchao00551" target="_blank">@每一行代码应都有生命</a></li>
                    <li>博客：<a href="http://ebay-cloud.com" target="_blank">@码趣</a></li>
                    <li>qq: 7631990</li>
                    <li>email: 10947@163.com</li>
                </ul>
                <h2 id="skill-keywords">Skill Keywords</h2>
                <h3 id="software-engineer-keywords">Software Engineer Keywords</h3>
                <div class="btn-inline"> <button class="btn btn-outline" type="button">Java</button> <button class="btn btn-outline" type="button">C++</button> <button class="btn btn-outline" type="button">Python</button> <button class="btn btn-outline"
                                                                                                                                                                                                                                      type="button">Design Patterns</button></div>
                <h3 id="mobile-developer-keywords">Mobile Developer Keywords</h3>
                <div class="btn-inline"> <button class="btn btn-outline" type="button">Android</button> <button class="btn btn-outline" type="button">Reverse Engineering</button></div>
                <h3 id="windows-developer-keywords">Windows Developer Keywords</h3>
                <div class="btn-inline"> <button class="btn btn-outline" type="button">Win32 SDK</button> <button class="btn btn-outline" type="button">DuiLib</button> <button class="btn btn-outline" type="button">WTL</button> <button
                            class="btn btn-outline" type="button">COM</button> <button class="btn btn-outline" type="button">WinDbg</button></div>
            </article>
            <div class="share"></div>
            <div class="comment">
                <div id="gitalk-container"></div>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/mzlogin/mzlogin.github.io@master/assets/vendor/gitalk/gitalk.css">
                <script src="https://cdn.jsdelivr.net/npm/gitalk@1/dist/gitalk.min.js"></script>
                <script>
                    var gitalk = new Gitalk({
                        id: '/about/',
                        clientID: 'd2e1cbbd298958076462',
                        clientSecret: 'b42a4178e5fd4a7cf63189ef4b1453b05c375709',
                        repo: 'blog-comments',
                        owner: 'mzlogin',
                        admin: ['mzlogin'],
                        labels: ['gitment'],
                        perPage: 50,
                    });
                    gitalk.render('gitalk-container');
                </script>
            </div>
        </div>

        <#include "/layout/sidebar.ftl"/>

    </div>
</section>