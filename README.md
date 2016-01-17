# Butler2
<h2>What is it?</h2>
<p>It's a recognize speech assistant that executes pre-programmed commands and outstanding audio response. It's a project for learning java, by my self.</p>
<h2>What technologies are used?</h2>
<ul>
<li><a href="http://mary.dfki.de/">MarryTTS</a> - text to speech library.</li>
<li><a href="http://cmusphinx.sourceforge.net/">CMUSphinx</a> - speech recognize library.</a></li>
<li><a href="https://www.ivona.com/">Ivona</a> - coolest for now, text to speech service.</li>
</ul>
<h2>What command's pre-programmed?</h2>
<ul>
<li>Calculate - you say two digits and operator between them, assistent say a answer.</li>
<li>Currency - you say currency name (euro, yuan or dollar), assistent say currency RUB/EUR, RUB/USD or RUB/CNY.</li>
<li>Hello - assistent greatings you.</li>
</ul>
<h2>How to extend command's list?</h2>
<p>Only you need, it's create class whos extends AbstractFactory  class, and add dependency to main.</p>
