<section class="container content" xmlns="http://www.w3.org/1999/html">
    <div class="columns">


        <div class="column three-fourths">
            <!-- 文章详情 -->
            <article class="article-content markdown-body">
                ${article.content}
                <p>本文原计划写两部分内容，第一是记录最近遇到的与 Base64 有关的 Bug，第二是 Base64 编码的原理详解。结果写了一半发现，诶？不复杂的一个事儿怎么也要讲这么长？不利于阅读和理解啊（其实是今天有点懒想去休闲娱乐会儿），所以 Base64 编码的原理详解的部分将在下一篇带来，敬请关注。</p>
                <h2 id="0x01-遇到的现象">0x01 遇到的现象</h2>
                <p>A 向 B 提供了一个接口，约定接口参数 Base64 编码后传递。</p>
                <p>但 A 对 B 传递的参数进行 Base64 解码时报错了：</p>
                <div class="language-plaintext highlighter-rouge">
                    <div class="highlight">
              <pre class="highlight"><code>Illegal base64 character a
</code></pre>
                    </div>
                </div>
                <h2 id="0x02-原因分析">0x02 原因分析</h2>
                <p>搜索后发现这是一个好多网友们都踩过的坑，简而言之就一句话：Base64 编/解码器有不同实现，有的不相互兼容。</p>
                <p>比如我上面遇到的现象，可以使用下面这段代码完整模拟复现：</p>
                <div class="language-java highlighter-rouge">
                    <div class="highlight">
              <pre class="highlight"><code><span class="kn">package</span> <span class="nn">org.mazhuang.base64test</span><span class="o">;</span>

<span class="kn">import</span> <span class="nn">org.springframework.boot.CommandLineRunner</span><span class="o">;</span>
<span class="kn">import</span> <span class="nn">org.springframework.boot.SpringApplication</span><span class="o">;</span>
<span class="kn">import</span> <span class="nn">org.springframework.boot.autoconfigure.SpringBootApplication</span><span class="o">;</span>
<span class="kn">import</span> <span class="nn">org.springframework.util.Base64Utils</span><span class="o">;</span>
<span class="kn">import</span> <span class="nn">sun.misc.BASE64Encoder</span><span class="o">;</span>

<span class="nd">@SpringBootApplication</span>
<span class="kd">public</span> <span class="kd">class</span> <span class="nc">Base64testApplication</span> <span class="kd">implements</span> <span class="nc">CommandLineRunner</span> <span class="o">{</span>
    <span class="nd">@Override</span>
    <span class="kd">public</span> <span class="kt">void</span> <span class="nf">run</span><span class="o">(</span><span class="nc">String</span><span class="o">...</span> <span class="n">args</span><span class="o">)</span> <span class="kd">throws</span> <span class="nc">Exception</span> <span class="o">{</span>
        <span class="kt">byte</span><span class="o">[]</span> <span class="n">content</span> <span class="o">=</span> <span class="s">"It takes a strong man to save himself, and a great man to save another."</span><span class="o">.</span><span class="na">getBytes</span><span class="o">();</span>
        <span class="nc">String</span> <span class="n">encrypted</span> <span class="o">=</span> <span class="k">new</span> <span class="nc">BASE64Encoder</span><span class="o">().</span><span class="na">encode</span><span class="o">(</span><span class="n">content</span><span class="o">);</span>
        <span class="kt">byte</span><span class="o">[]</span> <span class="n">decrypted</span> <span class="o">=</span> <span class="nc">Base64Utils</span><span class="o">.</span><span class="na">decodeFromString</span><span class="o">(</span><span class="n">encrypted</span><span class="o">);</span>
        <span class="nc">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="k">new</span> <span class="nc">String</span><span class="o">(</span><span class="n">decrypted</span><span class="o">));</span>
    <span class="o">}</span>

    <span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">main</span><span class="o">(</span><span class="nc">String</span><span class="o">[]</span> <span class="n">args</span><span class="o">)</span> <span class="o">{</span>
        <span class="nc">SpringApplication</span><span class="o">.</span><span class="na">run</span><span class="o">(</span><span class="nc">Base64testApplication</span><span class="o">.</span><span class="na">class</span><span class="o">,</span> <span class="n">args</span><span class="o">);</span>
    <span class="o">}</span>

<span class="o">}</span>
</code></pre>
                    </div>
                </div>
                <p>以上代码执行会报异常：</p>
                <div class="language-plaintext highlighter-rouge">
                    <div class="highlight">
              <pre class="highlight"><code>Caused by: java.lang.IllegalArgumentException: Illegal base64 character a
	at java.util.Base64$Decoder.decode0(Base64.java:714) ~[na:1.8.0_202-release]
	at java.util.Base64$Decoder.decode(Base64.java:526) ~[na:1.8.0_202-release]
</code></pre>
                    </div>
                </div>
                <p><em><strong>注：</strong> 测试代码里的那个字符串如果很短，比如「Hello, World」这种，可以正常解码。</em></p>
                <p>也就是说，用 sun.misc.BASE64Encoder 编码，用 org.springframework.util.Base64Utils 进行解码，是有问题的，我们可以用它俩分别对以上符串进行编码，然后输出看看差异。测试代码：</p>
                <div class="language-java highlighter-rouge">
                    <div class="highlight">
              <pre class="highlight"><code><span class="kt">byte</span><span class="o">[]</span> <span class="n">content</span> <span class="o">=</span> <span class="s">"It takes a strong man to save himself, and a great man to save another."</span><span class="o">.</span><span class="na">getBytes</span><span class="o">();</span>

<span class="nc">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="k">new</span> <span class="nc">BASE64Encoder</span><span class="o">().</span><span class="na">encode</span><span class="o">(</span><span class="n">content</span><span class="o">));</span>
<span class="nc">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="s">"--- 华丽的分隔线 ---"</span><span class="o">);</span>
<span class="nc">System</span><span class="o">.</span><span class="na">out</span><span class="o">.</span><span class="na">println</span><span class="o">(</span><span class="nc">Base64Utils</span><span class="o">.</span><span class="na">encodeToString</span><span class="o">(</span><span class="n">content</span><span class="o">));</span>
</code></pre>
                    </div>
                </div>
                <p>输出：</p>
                <div class="language-plaintext highlighter-rouge">
                    <div class="highlight">
              <pre class="highlight"><code>SXQgdGFrZXMgYSBzdHJvbmcgbWFuIHRvIHNhdmUgaGltc2VsZiwgYW5kIGEgZ3JlYXQgbWFuIHRv
IHNhdmUgYW5vdGhlci4=
--- 华丽的分隔线 ---
SXQgdGFrZXMgYSBzdHJvbmcgbWFuIHRvIHNhdmUgaGltc2VsZiwgYW5kIGEgZ3JlYXQgbWFuIHRvIHNhdmUgYW5vdGhlci4=
</code></pre>
                    </div>
                </div>
                <p>可以看到 sun.misc.BASE64Encoder 编码后的内容换行了，而换行符的 ASCII 编码正好是 0x0a，如此貌似解释得通了。让我们进一步跟踪一下，找一下出现这种差异的源头。</p>
                <h2 id="0x03-更进一步">0x03 更进一步</h2>
                <p>在 IDEA 里按住 CTRL 或 COMMAND 键点击方法名，可以跳转到它们的实现。</p>
                <h3 id="31-sunmiscbase64encoderencode">3.1 sun.misc.BASE64Encoder.encode</h3>
                <p>这种写法主要涉及到两个类，sun.misc 包下的 BASE64Encoder 和 CharacterEncoder，其中后者是前者的父类。</p>
                <p>它实际工作的 encode 方法是在 CharacterEncoder 文件里，带注释版如下：</p>
                <div class="language-java highlighter-rouge">
                    <div class="highlight">
              <pre class="highlight"><code>
<span class="kd">public</span> <span class="kt">void</span> <span class="nf">encode</span><span class="o">(</span><span class="nc">InputStream</span> <span class="n">inStream</span><span class="o">,</span> <span class="nc">OutputStream</span> <span class="n">outStream</span><span class="o">)</span>
    <span class="kd">throws</span> <span class="nc">IOException</span> <span class="o">{</span>
    <span class="kt">int</span>     <span class="n">j</span><span class="o">;</span>
    <span class="kt">int</span>     <span class="n">numBytes</span><span class="o">;</span>
    <span class="c1">// bytesPerLine 在 BASE64Encoder 里实现，返回 57</span>
    <span class="kt">byte</span>    <span class="n">tmpbuffer</span><span class="o">[]</span> <span class="o">=</span> <span class="k">new</span> <span class="kt">byte</span><span class="o">[</span><span class="n">bytesPerLine</span><span class="o">()];</span>

    <span class="c1">// 用 outStream 构造一个 PrintStream</span>
    <span class="n">encodeBufferPrefix</span><span class="o">(</span><span class="n">outStream</span><span class="o">);</span>

    <span class="k">while</span> <span class="o">(</span><span class="kc">true</span><span class="o">)</span> <span class="o">{</span>
        <span class="c1">// 读取最多 57 个 bytes</span>
        <span class="n">numBytes</span> <span class="o">=</span> <span class="n">readFully</span><span class="o">(</span><span class="n">inStream</span><span class="o">,</span> <span class="n">tmpbuffer</span><span class="o">);</span>
        <span class="k">if</span> <span class="o">(</span><span class="n">numBytes</span> <span class="o">==</span> <span class="mi">0</span><span class="o">)</span> <span class="o">{</span>
            <span class="k">break</span><span class="o">;</span>
        <span class="o">}</span>
        <span class="c1">// 啥也没干</span>
        <span class="n">encodeLinePrefix</span><span class="o">(</span><span class="n">outStream</span><span class="o">,</span> <span class="n">numBytes</span><span class="o">);</span>
        <span class="c1">// 每次处理 3 bytes，编码成 4 bytes，不足位的补 0 位和 '='</span>
        <span class="k">for</span> <span class="o">(</span><span class="n">j</span> <span class="o">=</span> <span class="mi">0</span><span class="o">;</span> <span class="n">j</span> <span class="o">&lt;</span> <span class="n">numBytes</span><span class="o">;</span> <span class="n">j</span> <span class="o">+=</span> <span class="n">bytesPerAtom</span><span class="o">())</span> <span class="o">{</span>
            <span class="c1">// ...</span>
        <span class="o">}</span>
        <span class="k">if</span> <span class="o">(</span><span class="n">numBytes</span> <span class="o">&lt;</span> <span class="n">bytesPerLine</span><span class="o">())</span> <span class="o">{</span>
            <span class="k">break</span><span class="o">;</span>
        <span class="o">}</span> <span class="k">else</span> <span class="o">{</span>
            <span class="c1">// 换行</span>
            <span class="n">encodeLineSuffix</span><span class="o">(</span><span class="n">outStream</span><span class="o">);</span>
        <span class="o">}</span>
    <span class="o">}</span>
    <span class="c1">// 啥也没干</span>
    <span class="n">encodeBufferSuffix</span><span class="o">(</span><span class="n">outStream</span><span class="o">);</span>
<span class="o">}</span>
</code></pre>
                    </div>
                </div>
                <p>然后在 CharacterEncoder 类的注释里我们可以看到编码后的格式：</p>
                <div class="language-plaintext highlighter-rouge">
                    <div class="highlight">
              <pre class="highlight"><code>[Buffer Prefix]
[Line Prefix][encoded data atoms][Line Suffix]
[Buffer Suffix]
</code></pre>
                    </div>
                </div>
                <p>而结合 BASE64Encoder 这个实现类来看，Buffer Prefix、Buffer Suffix 和 Line Prefix 都为空，Line Suffix 为 <code class="language-plaintext highlighter-rouge">\n</code>。</p>
                <p>至此，我们已经找到实现中换行的部分——这个编码器实现里，读取 57 个 byte 作为一行进行编码（编码完成后是 76 个 byte）。</p>
                <h3 id="32-orgspringframeworkutilbase64utilsencodetostring">3.2 org.springframework.util.Base64Utils.encodeToString</h3>
                <p>这种写法主要涉及到 org.springframework.util.Base64Utils 和 java.util.Base64 两个类，可以看到前者主要是后者的封装。</p>
                <p>Base64Utils.encodeToString 这种写法最终用到的是 Base64.Encoder.RFC4648 这种编码器：</p>
                <div class="language-java highlighter-rouge">
                    <div class="highlight">
              <pre class="highlight"><code><span class="c1">// isURL = false，newline = null，linemax = -1，doPadding = true</span>
<span class="kd">static</span> <span class="kd">final</span> <span class="nc">Encoder</span> <span class="no">RFC4648</span> <span class="o">=</span> <span class="k">new</span> <span class="nc">Encoder</span><span class="o">(</span><span class="kc">false</span><span class="o">,</span> <span class="kc">null</span><span class="o">,</span> <span class="o">-</span><span class="mi">1</span><span class="o">,</span> <span class="kc">true</span><span class="o">);</span>
</code></pre>
                    </div>
                </div>
                <p>留意 newline 和 linemax 的值。</p>
                <p>然后看实际的编码实现所在的 Base64.encode0 方法：</p>
                <div class="language-java highlighter-rouge">
                    <div class="highlight">
              <pre class="highlight"><code><span class="kd">private</span> <span class="kt">int</span> <span class="nf">encode0</span><span class="o">(</span><span class="kt">byte</span><span class="o">[]</span> <span class="n">src</span><span class="o">,</span> <span class="kt">int</span> <span class="n">off</span><span class="o">,</span> <span class="kt">int</span> <span class="n">end</span><span class="o">,</span> <span class="kt">byte</span><span class="o">[]</span> <span class="n">dst</span><span class="o">)</span> <span class="o">{</span>
    <span class="c1">// ...</span>
    <span class="k">while</span> <span class="o">(</span><span class="n">sp</span> <span class="o">&lt;</span> <span class="n">sl</span><span class="o">)</span> <span class="o">{</span>
        <span class="c1">// ...</span>

        <span class="c1">// 这个条件不会满足，不会加换行</span>
        <span class="k">if</span> <span class="o">(</span><span class="n">dlen</span> <span class="o">==</span> <span class="n">linemax</span> <span class="o">&amp;&amp;</span> <span class="n">sp</span> <span class="o">&lt;</span> <span class="n">end</span><span class="o">)</span> <span class="o">{</span>
            <span class="k">for</span> <span class="o">(</span><span class="kt">byte</span> <span class="n">b</span> <span class="o">:</span> <span class="n">newline</span><span class="o">){</span>
                <span class="n">dst</span><span class="o">[</span><span class="n">dp</span><span class="o">++]</span> <span class="o">=</span> <span class="n">b</span><span class="o">;</span>
            <span class="o">}</span>
        <span class="o">}</span>
    <span class="o">}</span>
    <span class="c1">// ...</span>
    <span class="k">return</span> <span class="n">dp</span><span class="o">;</span>
<span class="o">}</span>
</code></pre>
                    </div>
                </div>
                <p>所以……这个实现里没有换行。</p>
                <h2 id="0x04-小结">0x04 小结</h2>
                <p>经过以上的分析，真相已经大白了，就是两个编码器的实现不一样，我们在开发过程中注意使用匹配的编码解码器就 OK 了，就是用哪个 Java 包下面的编码器编码，就用相同包下的对应解码器解码。</p>
                <p>至于为啥会出现不一样的实现，它们之间有过什么来龙去脉、恩怨情仇，Base64 的详细原理等等，就厚着老脸，邀请大家且听下回分解吧！:-P</p>
                <div style="margin-top:2em;padding:0 1.5em;border:1px solid #d3d3d3;background-color:#deebf7">
                    <h3>文档信息</h3>
                    <ul>
                        <li>本文作者：<a href="https://mazhuang.org" target="_blank">Zhuang Ma</a></li>
                        <li>本文链接：<a href="https://mazhuang.org/2020/03/01/base64-bug/" target="_blank">https://mazhuang.org/2020/03/01/base64-bug/</a></li>
                        <li>版权声明：自由转载-非商用-非衍生-保持署名（<a href="http://creativecommons.org/licenses/by-nc-nd/3.0/deed.zh" target="_blank">创意共享3.0许可证</a>）</li>
                    </ul>
                </div>
            </article>

            <div class="share"></div>

            <!-- 评论组件 -->
            <div class="comment">
                <div id="gitalk-container"></div>
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/mzlogin/mzlogin.github.io@master/assets/vendor/gitalk/gitalk.css">
                <script src="https://cdn.jsdelivr.net/npm/gitalk@1/dist/gitalk.min.js"></script>
                <script>
                    var gitalk = new Gitalk({
                        id: '/2020/03/01/base64-bug/',
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

        <#include "/layout/sidebarDetail.ftl"/>
    </div>


</section>
