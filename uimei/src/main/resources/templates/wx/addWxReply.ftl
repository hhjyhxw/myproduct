<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>自定义回复关键字</title>
	
	<script src="${basePath}/wx/js/jquery-1.9.1.min.js" type="text/javascript"></script>
	<link href="${basePath}/wx/css/sub_style.css" rel="stylesheet" type="text/css" />
	<link href="${basePath}/wx/css/jquery-ui.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="${basePath}/wx/css/demo.css?i=013" type="text/css"/>
	<link rel="stylesheet" href="${basePath}/wx/css/zTreeStyle/zTreeStyle.css" type="text/css"/>
	<script src="${basePath}/wx/js/jquery-ui.js" type="text/javascript"></script>
	<script src="${basePath}/wx/js/emotion.js" type="text/javascript"></script>
	<script type="text/javascript" src="${basePath}/wx/js/jquery.ztree.core-3.5.js"></script>
<script>
function jump(url){
		var e = document.createElement("a");
		e.href = url;
		document.body.appendChild(e);
		e.click();
	}
	function backto_(){
	 	jump("${basePath}/${backPath}/wxReply/list?wxAppId=${wxAppId}");
	 }

</script>
</head>
<body>
	${(message)!}
	<form
		action="${basePath}/${backPath}/wxReply/save"
		method="post" name="form1">
		<input type="hidden" value="${(wxAppId)!}" id="wxAppId"  name="wxAppId"/>
		<input name="msgEvent" value="2" type="hidden"/>
		<div id="submain"
			style="height: 493px; width: 909px;margin-top: 20px;">
			<div class="hig border">
				<h1 class="tit2 co1 left">关键字自动应答</h1>
			</div>

			<div class="clear"></div>
			<div class="reply top size">
				<div class="hig">
					<dl>
						<dt class="left co1 ddwid">关键字：</dt>
						<dd class="left mL20">
							<input name="msgKey" type="text" maxlength="20" id="cph_txtKey"
								class="input200" /> <span class="co4">*必填</span> <span
								class="co2">不可重复，不允许纯数字。</span>
						</dd>
					</dl>
					<div class="clearh"></div>
					<dl>
						<dt class="left co1 ddwid">回复类型：</dt>
						<dd class="left mL20">
							<select name="msgType" id="cph_ddlreply_form">
								<option selected="selected" value="1">文本</option>
								<option value="2">图文</option>
							</select>
						</dd>
					</dl>
					<div class="clearh"></div>
					<div id="textreply" class="display_none" style="display: block;">
						<dl>
							<dt class="left co1 ddwid">自动回复内容：</dt>
							<dd class="left mL20 ddsty">
								<div class="ddtit">
									<!-- <a class="html_txet" title="源代码">HTML</a> --><a class="phiz co5"
										href="javascript:void(0);"> <img
										src="${basePath}/wx/images/img1.jpg" />表情</a><!-- <a
										onclick="linkText();" class="link co5"
										href="javascript:void(0);"> <img
										src="${basePath}/wx/images/img3.jpg" />超链接</a> -->
								</div>
								
								
								<div style="display: none;" class="emotions">
									<table cellpadding="0" cellspacing="0">
										<tbody>
											<tr>
												<td>
													<div class="eItem" style="background-position: 0px 0;"
														data-title="微笑"
														data-gifurl="${basePath}/wx/images/emotion/0.gif">
														<img src="${basePath}/wx/images/emotion/0.gif" />
													</div>
												</td>
												<td>
													<div class="eItem" style="background-position: -24px 0;"
														data-title="撇嘴"
														data-gifurl="${basePath}/wx/images/emotion/1.gif">
														<img src="${basePath}/wx/images/emotion/1.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -48px 0;"
														data-title="色"
														data-gifurl="${basePath}/wx/images/emotion/2.gif">
														<img src="${basePath}/wx/images/emotion/2.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -72px 0;"
														data-title="发呆"
														data-gifurl="${basePath}/wx/images/emotion/3.gif">
														<img src="${basePath}/wx/images/emotion/3.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -96px 0;"
														data-title="得意"
														data-gifurl="${basePath}/wx/images/emotion/4.gif">
													<img src="${basePath}/wx/images/emotion/4.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -120px 0;"
														data-title="流泪"
														data-gifurl="${basePath}/wx/images/emotion/5.gif">
													<img src="${basePath}/wx/images/emotion/5.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -144px 0;"
														data-title="害羞"
														data-gifurl="${basePath}/wx/images/emotion/6.gif">
													<img src="${basePath}/wx/images/emotion/6.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -168px 0;"
														data-title="闭嘴"
														data-gifurl="${basePath}/wx/images/emotion/7.gif">
													<img src="${basePath}/wx/images/emotion/7.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -192px 0;"
														data-title="睡"
														data-gifurl="${basePath}/wx/images/emotion/8.gif">
													<img src="${basePath}/wx/images/emotion/8.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -216px 0;"
														data-title="大哭"
														data-gifurl="${basePath}/wx/images/emotion/9.gif">
													<img src="${basePath}/wx/images/emotion/9.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -240px 0;"
														data-title="尴尬"
														data-gifurl="${basePath}/wx/images/emotion/10.gif">
													<img src="${basePath}/wx/images/emotion/10.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -264px 0;"
														data-title="发怒"
														data-gifurl="${basePath}/wx/images/emotion/11.gif">
													<img src="${basePath}/wx/images/emotion/11.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -288px 0;"
														data-title="调皮"
														data-gifurl="${basePath}/wx/images/emotion/12.gif">
													<img src="${basePath}/wx/images/emotion/12.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -312px 0;"
														data-title="呲牙"
														data-gifurl="${basePath}/wx/images/emotion/13.gif">
													<img src="${basePath}/wx/images/emotion/13.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -336px 0;"
														data-title="惊讶"
														data-gifurl="${basePath}/wx/images/emotion/14.gif">
													<img src="${basePath}/wx/images/emotion/14.gif" />
													</div></td>
											</tr>
											<tr>
												<td>
													<div class="eItem" style="background-position: -360px 0;"
														data-title="难过"
														data-gifurl="${basePath}/wx/images/emotion/15.gif">
													<img src="${basePath}/wx/images/emotion/15.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -384px 0;"
														data-title="酷"
														data-gifurl="${basePath}/wx/images/emotion/16.gif">
													<img src="${basePath}/wx/images/emotion/16.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -408px 0;"
														data-title="冷汗"
														data-gifurl="${basePath}/wx/images/emotion/17.gif">
													<img src="${basePath}/wx/images/emotion/17.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -432px 0;"
														data-title="抓狂"
														data-gifurl="${basePath}/wx/images/emotion/18.gif">
													<img src="${basePath}/wx/images/emotion/18.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -456px 0;"
														data-title="吐"
														data-gifurl="${basePath}/wx/images/emotion/19.gif">
													<img src="${basePath}/wx/images/emotion/19.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -480px 0;"
														data-title="偷笑"
														data-gifurl="${basePath}/wx/images/emotion/20.gif">
													<img src="${basePath}/wx/images/emotion/20.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -504px 0;"
														data-title="可爱"
														data-gifurl="${basePath}/wx/images/emotion/21.gif">
													<img src="${basePath}/wx/images/emotion/21.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -528px 0;"
														data-title="白眼"
														data-gifurl="${basePath}/wx/images/emotion/22.gif">
													<img src="${basePath}/wx/images/emotion/22.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -552px 0;"
														data-title="傲慢"
														data-gifurl="${basePath}/wx/images/emotion/23.gif">
													<img src="${basePath}/wx/images/emotion/23.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -576px 0;"
														data-title="饥饿"
														data-gifurl="${basePath}/wx/images/emotion/24.gif">
													<img src="${basePath}/wx/images/emotion/24.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -600px 0;"
														data-title="困"
														data-gifurl="${basePath}/wx/images/emotion/25.gif">
													<img src="${basePath}/wx/images/emotion/25.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -624px 0;"
														data-title="惊恐"
														data-gifurl="${basePath}/wx/images/emotion/26.gif">
													<img src="${basePath}/wx/images/emotion/26.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -648px 0;"
														data-title="流汗"
														data-gifurl="${basePath}/wx/images/emotion/27.gif">
													<img src="${basePath}/wx/images/emotion/27.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -672px 0;"
														data-title="憨笑"
														data-gifurl="${basePath}/wx/images/emotion/28.gif">
													<img src="${basePath}/wx/images/emotion/28.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -696px 0;"
														data-title="大兵"
														data-gifurl="${basePath}/wx/images/emotion/29.gif">
													<img src="${basePath}/wx/images/emotion/29.gif" />
													</div></td>
											</tr>
											<tr>
												<td>
													<div class="eItem" style="background-position: -720px 0;"
														data-title="奋斗"
														data-gifurl="${basePath}/wx/images/emotion/30.gif">
													<img src="${basePath}/wx/images/emotion/30.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -744px 0;"
														data-title="咒骂"
														data-gifurl="${basePath}/wx/images/emotion/31.gif">
													<img src="${basePath}/wx/images/emotion/31.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -768px 0;"
														data-title="疑问"
														data-gifurl="${basePath}/wx/images/emotion/32.gif">
													<img src="${basePath}/wx/images/emotion/32.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -792px 0;"
														data-title="嘘"
														data-gifurl="${basePath}/wx/images/emotion/33.gif">
													<img src="${basePath}/wx/images/emotion/33.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -816px 0;"
														data-title="晕"
														data-gifurl="${basePath}/wx/images/emotion/34.gif">
													<img src="${basePath}/wx/images/emotion/34.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -840px 0;"
														data-title="折磨"
														data-gifurl="${basePath}/wx/images/emotion/35.gif">
													<img src="${basePath}/wx/images/emotion/35.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -864px 0;"
														data-title="衰"
														data-gifurl="${basePath}/wx/images/emotion/36.gif">
													<img src="${basePath}/wx/images/emotion/36.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -888px 0;"
														data-title="骷髅"
														data-gifurl="${basePath}/wx/images/emotion/37.gif">
													<img src="${basePath}/wx/images/emotion/37.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -912px 0;"
														data-title="敲打"
														data-gifurl="${basePath}/wx/images/emotion/38.gif">
													<img src="${basePath}/wx/images/emotion/38.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -936px 0;"
														data-title="再见"
														data-gifurl="${basePath}/wx/images/emotion/39.gif">
													<img src="${basePath}/wx/images/emotion/39.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -960px 0;"
														data-title="擦汗"
														data-gifurl="${basePath}/wx/images/emotion/40.gif">
													<img src="${basePath}/wx/images/emotion/40.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -984px 0;"
														data-title="抠鼻"
														data-gifurl="${basePath}/wx/images/emotion/41.gif">
													<img src="${basePath}/wx/images/emotion/41.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1008px 0;"
														data-title="鼓掌"
														data-gifurl="${basePath}/wx/images/emotion/42.gif">
													<img src="${basePath}/wx/images/emotion/42.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1032px 0;"
														data-title="糗大了"
														data-gifurl="${basePath}/wx/images/emotion/43.gif">
													<img src="${basePath}/wx/images/emotion/43.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1056px 0;"
														data-title="坏笑"
														data-gifurl="${basePath}/wx/images/emotion/44.gif">
													<img src="${basePath}/wx/images/emotion/44.gif" />
													</div></td>
											</tr>
											<tr>
												<td>
													<div class="eItem" style="background-position: -1080px 0;"
														data-title="左哼哼"
														data-gifurl="${basePath}/wx/images/emotion/45.gif">
													<img src="${basePath}/wx/images/emotion/45.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1104px 0;"
														data-title="右哼哼"
														data-gifurl="${basePath}/wx/images/emotion/46.gif">
													<img src="${basePath}/wx/images/emotion/46.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1128px 0;"
														data-title="哈欠"
														data-gifurl="${basePath}/wx/images/emotion/47.gif">
													<img src="${basePath}/wx/images/emotion/47.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1152px 0;"
														data-title="鄙视"
														data-gifurl="${basePath}/wx/images/emotion/48.gif">
													<img src="${basePath}/wx/images/emotion/48.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1176px 0;"
														data-title="委屈"
														data-gifurl="${basePath}/wx/images/emotion/49.gif">
													<img src="${basePath}/wx/images/emotion/49.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1200px 0;"
														data-title="快哭了"
														data-gifurl="${basePath}/wx/images/emotion/50.gif">
													<img src="${basePath}/wx/images/emotion/50.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1224px 0;"
														data-title="阴险"
														data-gifurl="${basePath}/wx/images/emotion/51.gif">
													<img src="${basePath}/wx/images/emotion/51.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1248px 0;"
														data-title="亲亲"
														data-gifurl="${basePath}/wx/images/emotion/52.gif">
													<img src="${basePath}/wx/images/emotion/52.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1272px 0;"
														data-title="吓"
														data-gifurl="${basePath}/wx/images/emotion/53.gif">
													<img src="${basePath}/wx/images/emotion/53.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1296px 0;"
														data-title="可怜"
														data-gifurl="${basePath}/wx/images/emotion/54.gif">
													<img src="${basePath}/wx/images/emotion/54.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1320px 0;"
														data-title="菜刀"
														data-gifurl="${basePath}/wx/images/emotion/55.gif">
													<img src="${basePath}/wx/images/emotion/55.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1344px 0;"
														data-title="西瓜"
														data-gifurl="${basePath}/wx/images/emotion/56.gif">
													<img src="${basePath}/wx/images/emotion/56.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1368px 0;"
														data-title="啤酒"
														data-gifurl="${basePath}/wx/images/emotion/57.gif">
													<img src="${basePath}/wx/images/emotion/57.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1392px 0;"
														data-title="篮球"
														data-gifurl="${basePath}/wx/images/emotion/58.gif">
													<img src="${basePath}/wx/images/emotion/58.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1416px 0;"
														data-title="乒乓"
														data-gifurl="${basePath}/wx/images/emotion/59.gif">
													<img src="${basePath}/wx/images/emotion/59.gif" />
													</div></td>
											</tr>
											<tr>
												<td>
													<div class="eItem" style="background-position: -1440px 0;"
														data-title="咖啡"
														data-gifurl="${basePath}/wx/images/emotion/60.gif">
													<img src="${basePath}/wx/images/emotion/60.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1464px 0;"
														data-title="饭"
														data-gifurl="${basePath}/wx/images/emotion/61.gif">
													<img src="${basePath}/wx/images/emotion/61.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1488px 0;"
														data-title="猪头"
														data-gifurl="${basePath}/wx/images/emotion/62.gif">
													<img src="${basePath}/wx/images/emotion/62.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1512px 0;"
														data-title="玫瑰"
														data-gifurl="${basePath}/wx/images/emotion/63.gif">
													<img src="${basePath}/wx/images/emotion/63.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1536px 0;"
														data-title="凋谢"
														data-gifurl="${basePath}/wx/images/emotion/64.gif">
													<img src="${basePath}/wx/images/emotion/64.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1560px 0;"
														data-title="示爱"
														data-gifurl="${basePath}/wx/images/emotion/65.gif">
													<img src="${basePath}/wx/images/emotion/65.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1584px 0;"
														data-title="爱心"
														data-gifurl="${basePath}/wx/images/emotion/66.gif">
													<img src="${basePath}/wx/images/emotion/66.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1608px 0;"
														data-title="心碎"
														data-gifurl="${basePath}/wx/images/emotion/67.gif">
													<img src="${basePath}/wx/images/emotion/67.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1632px 0;"
														data-title="蛋糕"
														data-gifurl="${basePath}/wx/images/emotion/68.gif">
													<img src="${basePath}/wx/images/emotion/68.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1656px 0;"
														data-title="闪电"
														data-gifurl="${basePath}/wx/images/emotion/69.gif">
													<img src="${basePath}/wx/images/emotion/69.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1680px 0;"
														data-title="炸弹"
														data-gifurl="${basePath}/wx/images/emotion/70.gif">
													<img src="${basePath}/wx/images/emotion/70.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1704px 0;"
														data-title="刀"
														data-gifurl="${basePath}/wx/images/emotion/71.gif">
													<img src="${basePath}/wx/images/emotion/71.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1728px 0;"
														data-title="足球"
														data-gifurl="${basePath}/wx/images/emotion/72.gif">
													<img src="${basePath}/wx/images/emotion/72.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1752px 0;"
														data-title="瓢虫"
														data-gifurl="${basePath}/wx/images/emotion/73.gif">
													<img src="${basePath}/wx/images/emotion/73.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1776px 0;"
														data-title="便便"
														data-gifurl="${basePath}/wx/images/emotion/74.gif">
													<img src="${basePath}/wx/images/emotion/74.gif" />
													</div></td>
											</tr>
											<tr>
												<td>
													<div class="eItem" style="background-position: -1800px 0;"
														data-title="月亮"
														data-gifurl="${basePath}/wx/images/emotion/75.gif">
													<img src="${basePath}/wx/images/emotion/75.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1824px 0;"
														data-title="太阳"
														data-gifurl="${basePath}/wx/images/emotion/76.gif">
														<img src="${basePath}/wx/images/emotion/76.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1848px 0;"
														data-title="礼物"
														data-gifurl="${basePath}/wx/images/emotion/77.gif">
													<img src="${basePath}/wx/images/emotion/77.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1872px 0;"
														data-title="拥抱"
														data-gifurl="${basePath}/wx/images/emotion/78.gif">
													<img src="${basePath}/wx/images/emotion/78.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1896px 0;"
														data-title="强"
														data-gifurl="${basePath}/wx/images/emotion/79.gif">
													<img src="${basePath}/wx/images/emotion/79.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1920px 0;"
														data-title="弱"
														data-gifurl="${basePath}/wx/images/emotion/80.gif">
													<img src="${basePath}/wx/images/emotion/80.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1944px 0;"
														data-title="握手"
														data-gifurl="${basePath}/wx/images/emotion/81.gif">
													<img src="${basePath}/wx/images/emotion/81.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1968px 0;"
														data-title="胜利"
														data-gifurl="${basePath}/wx/images/emotion/82.gif">
													<img src="${basePath}/wx/images/emotion/82.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -1992px 0;"
														data-title="抱拳"
														data-gifurl="${basePath}/wx/images/emotion/83.gif">
													<img src="${basePath}/wx/images/emotion/83.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2016px 0;"
														data-title="勾引"
														data-gifurl="${basePath}/wx/images/emotion/84.gif">
													<img src="${basePath}/wx/images/emotion/84.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2040px 0;"
														data-title="拳头"
														data-gifurl="${basePath}/wx/images/emotion/85.gif">
													<img src="${basePath}/wx/images/emotion/85.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2064px 0;"
														data-title="差劲"
														data-gifurl="${basePath}/wx/images/emotion/86.gif">
													<img src="${basePath}/wx/images/emotion/86.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2088px 0;"
														data-title="爱你"
														data-gifurl="${basePath}/wx/images/emotion/87.gif">
													<img src="${basePath}/wx/images/emotion/87.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2112px 0;"
														data-title="NO"
														data-gifurl="${basePath}/wx/images/emotion/88.gif">
													<img src="${basePath}/wx/images/emotion/88.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2136px 0;"
														data-title="OK"
														data-gifurl="${basePath}/wx/images/emotion/89.gif">
													<img src="${basePath}/wx/images/emotion/89.gif" />
													</div></td>
											</tr>
											<tr>
												<td>
													<div class="eItem" style="background-position: -2160px 0;"
														data-title="爱情"
														data-gifurl="${basePath}/wx/images/emotion/90.gif">
													<img src="${basePath}/wx/images/emotion/90.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2184px 0;"
														data-title="飞吻"
														data-gifurl="${basePath}/wx/images/emotion/91.gif">
													<img src="${basePath}/wx/images/emotion/91.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2208px 0;"
														data-title="跳跳"
														data-gifurl="${basePath}/wx/images/emotion/92.gif">
													<img src="${basePath}/wx/images/emotion/92.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2232px 0;"
														data-title="发抖"
														data-gifurl="${basePath}/wx/images/emotion/93.gif">
													<img src="${basePath}/wx/images/emotion/93.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2256px 0;"
														data-title="怄火"
														data-gifurl="${basePath}/wx/images/emotion/94.gif">
													<img src="${basePath}/wx/images/emotion/94.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2280px 0;"
														data-title="转圈"
														data-gifurl="${basePath}/wx/images/emotion/95.gif">
													<img src="${basePath}/wx/images/emotion/95.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2304px 0;"
														data-title="磕头"
														data-gifurl="${basePath}/wx/images/emotion/96.gif">
													<img src="${basePath}/wx/images/emotion/96.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2328px 0;"
														data-title="回头"
														data-gifurl="${basePath}/wx/images/emotion/97.gif">
													<img src="${basePath}/wx/images/emotion/97.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2352px 0;"
														data-title="跳绳"
														data-gifurl="${basePath}/wx/images/emotion/98.gif">
													<img src="${basePath}/wx/images/emotion/98.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2376px 0;"
														data-title="挥手"
														data-gifurl="${basePath}/wx/images/emotion/99.gif">
													<img src="${basePath}/wx/images/emotion/99.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2400px 0;"
														data-title="激动"
														data-gifurl="${basePath}/wx/images/emotion/100.gif">
													<img src="${basePath}/wx/images/emotion/100.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2424px 0;"
														data-title="街舞"
														data-gifurl="${basePath}/wx/images/emotion/101.gif">
													<img src="${basePath}/wx/images/emotion/101.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2448px 0;"
														data-title="献吻"
														data-gifurl="${basePath}/wx/images/emotion/102.gif">
													<img src="${basePath}/wx/images/emotion/102.gif" />
													</div></td>
												<td>
													<div class="eItem" style="background-position: -2472px 0;"
														data-title="左太极"
														data-gifurl="${basePath}/wx/images/emotion/103.gif">
														<img src="${basePath}/wx/images/emotion/103.gif" />
														</div>
												</td>
												<td>
													<div class="eItem" style="background-position: -2496px 0;"
														data-title="右太极"
														data-gifurl="${basePath}/wx/images/emotion/104.gif">
														<img src="${basePath}/wx/images/emotion/104.gif" />
														</div>
												</td>
											</tr>
										</tbody>
									</table>
									<div class="emotionsGif">
										<img src="${basePath}/wx/images/34.gif" />
									</div>
								</div>
								

								<div class="ddcont editArea">
									<textarea name="content" rows="2" cols="20" id="cph_txtwelcome"
										class="display_none"
										style="border-radius: 2px; width: 498px; height: 80px"></textarea>
									<div class="textarea" contenteditable="true">
										<%-- <img src="${basePath}/wx/images/56.gif" alt="mo-西瓜"> --%>
									</div>
								</div>
							</dd>
						</dl>
						<div class="clearh"></div>
						<dl>
							<dt class="left co1 ddwid">&nbsp;</dt>
							<dd class="left mL20">
								<font class="co6"><em class="co4 ml20 pdr10 pdl100">*</em>必填</font>
							</dd>
						</dl>
					</div>
					
					<div id="multiArticle" class="display_none " style="display: none;">
						<dl>
							<dt class="left co1 ddwid">自动回复图文：</dt>
							<dd class="left mL20 ddsty co1">
								<div class="ddtit">
									<input value="选择图文" id="ArticleShow" class="inputbgr3"
										type="button" onclick="return ArticleShow_onclick()" />
								</div>
								<div class="ddcont">
									<div class="msg-item"></div>
									<input id="cph_hfNewsId" value="" name="mid" type="hidden" />
								</div>
							</dd>
						</dl>
					</div>

					<div id="duokefu" class="display_none co2" style="display: none;">使用多客服系统，需要微信公众开通高级接口，并下载多客服客户端程序</div>
				</div>
				<div class="clearh"></div>
			</div>
			<div class="dlsty bgco6">
				<input type="submit" name="ctl00$cph$btnUpd" value="保存"
					onclick="return GetBtn();" id="cph_btnUpd" class="greenbtn100"  style="background:#0088cc;border: 1px solid #0088cc;"/>
					<input type="button" name="ctl00$cph$btnUpd" value="返回"
					onclick="backto_();" class="greenbtn100"  style="background:#0088cc;border: 1px solid #0088cc;"/>
			</div>
		</div>

		<script type="text/javascript">
        var $textarea = $(".editArea textarea");
        var $contentDiv = $(".editArea div");
        var $answertype = $("#cph_ddlreply_form");
        var $NewsId = $("#cph_hfNewsId");

        //回复类型切换界面
        function GetType(n) {
            $("#textreply").hide();
            $("#multiArticle").hide();
            $("#duokefu").hide();
            $("#_business").hide();
            if (n == "mainMenu") {
                //$("#mpmenu").show();
            } else if (n == "1") {
                $("#textreply").show();
            } else if (n == "2") {
                $("#multiArticle").show();
            } else if (n == "service") {
                $("#duokefu").show();
            }else if(n=="business"){
            $("#_business").show();
            }
        }

//提交数据时
        function GetBtn() {
            if ($("#cph_txtKey").val() == "") {
                alert("关键字不能为空！");
                $("#cph_txtKey").focus();
                return false;
            }
            else if (parseInt($("#cph_txtKey").val()) == $("#cph_txtKey").val()) {
                alert("关键字不能为纯数字！");
                $("#cph_txtKey").focus();
                return false;
            }
            return true;
        }

        $(function () {

            $textarea.change(function () {
                $contentDiv.html(Emotion.replaceEmoji($(this).val()));
                $(this).height($contentDiv.height());
            })

            $(".html_txet").click(function () {
                $(this).toggleClass("html_txet_co");
                $textarea.toggle();
                $contentDiv.toggle();
                $textarea.height($contentDiv.height());
                $('.phiz').toggle();
                $('.link').toggle();
            })

            if ($NewsId.val() != "0" && $answertype.val() == "news") {
                GetBindDataShow($NewsId.val());
            }

            $contentDiv.html(Emotion.replaceEmoji($textarea.val()));
            GetType($answertype.val());

            $("#cph_ddlreply_form").change(function () {
                GetType($(this).val());
            });

            //===========表情============
            $(".ddtit .phiz").click(function () {
                $(".emotions").show();
            });
            $(".emotions").hover(function () {

            }, function () {
                $(".emotions").fadeOut();
            });
            $(".emotions .eItem").mouseenter(function () {
                $(".emotionsGif").html('<img src="' + $(this).attr("data-gifurl") + '">');
            }).click(function () {
                Emotion.insertHTML('<img src="' + $(this).attr("data-gifurl") + '"' + 'alt="mo-' + $(this).attr("data-title") + '"' + "/>");
                $(".emotions").fadeOut();
                $textarea.trigger("contentValueChange");

            });
            $contentDiv.bind("keyup", function () {
                $textarea.trigger("contentValueChange");
                Emotion.saveRange();
            }).bind("keydown", function (e) {
                switch (e.keyCode) {
                    case 8:
                        var t = Emotion.getSelection();
                        t.type && t.type.toLowerCase() === "control" && (e.preventDefault(), t.clear());
                        break;
                    case 13:
                        e.preventDefault(),
                Emotion.insertHTML("<br/>");
                        Emotion.saveRange();
                }
            }).bind("mouseup", function (e) {
                Emotion.saveRange();
                if ($.browser.msie && />$/.test($contentDiv.html())) {
                    var n = Emotion.getSelection();
                    n.extend && (n.extend(cursorNode, cursorNode.length), n.collapseToEnd()),
                Emotion.saveRange();
                    Emotion.insertHTML(" ");
                }
            });
            $textarea.bind("contentValueChange", function () {
                $(this).val(Emotion.replaceInput($contentDiv.html()));
            });
            $contentDiv.html(Emotion.replaceEmoji($contentDiv.html()));
            //===========end表情============


            //=============超链接============
            
           
             $(".ddtit .link").click(function () { 

               var _con = Emotion.getSelectionContents(); 
               var _url = "http://";
               var pattern = /<a.*?href=["]{0,1}([^"\s]*).*?>/ig;
               var mts = pattern.exec(_con);
                if (mts != null) {
                    _url = mts[1];
                }  

                $("#txtUrl").val(_url);
              
                $("#txtCon").html(_con.replace(/<br.*?>/ig, " ").replace(/<a.*?>/ig, "").replace(/<\/a>/ig, "")); 
                $("#hyperlink").dialog("open");

            });
            $("#hyperlink").dialog({
                autoOpen: false,
                resizable: false,
                modal: false,
                width: 470,
                height: 300,
                buttons: {
                    "确定": function () {
                        var strCon = $("#txtCon").html();
                        var strUrl = $("#txtUrl").val();
                        var strHtml = strCon;
                        if (strUrl != "" && strUrl != "http://") {
                            if (strCon == "") {
                                strCon = strUrl;
                            }
                            strHtml = '<a href="' + strUrl + '">' + strCon + '</a>';
                        }
                        Emotion.insertHTML(strHtml);
                        $textarea.trigger("contentValueChange");
                        $(this).dialog("close");
                    },
                    "取消": function () { $(this).dialog("close"); }
                }
            });
           
            //===========超链接============


            //===========图文列表============  


            $("#ArticleShow").click(function () {
                $("#ArticleListShow").dialog("open");
                $(".allArticles").html("<li>数据加载中。。。</li>");
                GetBindData(1);
            });

            $("#ArticleListShow").dialog({
                autoOpen: false,
                resizable: false,
                resizable: true,
                modal: true,
                minWidth: 480,
                minHeight: 380,
                width: 550,
                height: 400,
                buttons: {
                    "确定": function () {
                   
                        if ($(':radio[name="id"]:checked').length > 0) {
                            var id = ($(':radio[name="id"]:checked').val());
                           
                            GetBindDataShow(id);
                        }
                        $(this).dialog("close");
                    },
                    "取消": function () { $(this).dialog("close"); }
                }
            });
            //===========end图文列表============
        });


        //===========读取图文列表============
        function GetBindData(PageIndex) {
            $.ajax({
                type: "POST",
                url: "${basePath}/${backPath}/wxImageText/getwxImageTextListForMenu",
                data: { "model": "list", "PageSize": "30", "PageIndex": PageIndex,"wxAppId":"${wxAppId}" },
                timeout: "10000",
                dataType: "text",
                error: function () {
                    $(".allArticles").html("<li>服务器繁忙，请稍后重试</li>");
                },
                success: function (dt) {
                
                var d = eval('(' + dt + ')');
               
                    $(".allArticles").html("");
                    $("#PageInfo").html("(当前第" + d.p.pageNo + "/" + d.p.last + "页 共" + d.p.count + "条记录)");
                    $(d.data).each(function () {
                        var ss_imagetext = "only-imagetext";
                        if (this.img_num > 1) {
                            ss_imagetext = "more-imagetext";
                        }
                        $(".allArticles").append("<li class='" + ss_imagetext + "' title='" + decodeURIComponent(this.title) + "'><img src='" +"${basePath}" + this.picUrl + "' /><div class='testradio'><input id='" + this.id + "' name='id' value='" + this.id + "' type='radio'><label for='" + this.id + "'>" + decodeURIComponent(this.title).substring(0, 10) + "</label></div></li>");
                    });

                   //分页
                    $(".page").html("");
                    if (d.p.pageNo - 1 > 0) {
                        $(".page").append("<a href='javascript:GetBindData(" + (d.p.pageNo - 1) + ");'>上一页</a>");
                    }
                    else {
                        $(".page").append("<a>上一页</a>");
                    }
                    for (i = 1; i <= d.p.totalPage; i++) {

                        if (i == d.p.currPage) {
                            $(".page").append("<a class='hover'>" + i + "</a>");
                        } else {
                            $(".page").append("<a href='javascript:GetBindData(" + i + ");'>" + i + "</a>");
                        }
                    }
                    if (d.p.pageNo < d.p.last) {
                        $(".page").append("<a href='javascript:GetBindData(" + (d.p.pageNo + 1) + ");'>下一页</a>");
                    }
                    else {
                        $(".page").append("<a >下一页</a>");

                    }

                }
            });
        }
        //===========end读取图文列表============



        //===========读取图文详情============
       function GetBindDataShow(id) {
       
            $.ajax({
                type: "POST",
                url: "${basePath}/${backPath}/wxImageText/getwxImageTextListForMenu",
                data: { "model": "show", "id": id,"wxAppId":"${wxAppId}"},
                timeout: "10000",
                dataType: "text",
                error: function () {
                    alert("服务器繁忙，请稍后重试");
                },
                success: function (data) {
                 var data = eval('(' + data + ')');
                    var strHtml = "";
                    strHtml += "<div id='appmsgItem1' class='appmsgItem'>";
                    strHtml += "    <p class='multi-msg'>";
                    strHtml += "        <span class='msg-date'>" + "</span>";
                    strHtml += "    </p>";
                    strHtml += "    <div class='cover'>";
                    strHtml += "        <h4 class='msg-t'>";
                    strHtml += "            <a href='" + data.vistedUrl + "' class='i-title' target='_blank'>" + decodeURIComponent(data.title) + "</a>";
                    strHtml += "        </h4>";
                    strHtml += "        <img src='" +"${basePath}" + data.picUrl + "' class='i-img'>";
                    strHtml += "    </div>";
                    strHtml += "</div>";

                   strHtml += "<div class='msg-text' >" + decodeURIComponent(data.description) + "</div>";
                   /*  if (data.img_num == 1) {
                        strHtml += "<div class='msg-text' >" + decodeURIComponent(data.description) + "</div>";
                    }
                    else {
                        strHtml += GetItemHtml(2, data.img_2, data.url_2, data.title_2);
                        strHtml += GetItemHtml(3, data.img_3, data.url_3, data.title_3);
                        strHtml += GetItemHtml(4, data.img_4, data.url_4, data.title_4);
                        strHtml += GetItemHtml(5, data.img_5, data.url_5, data.title_5);
                        strHtml += GetItemHtml(6, data.img_6, data.url_6, data.title_6);
                        strHtml += GetItemHtml(7, data.img_7, data.url_7, data.title_7);
                        strHtml += GetItemHtml(8, data.img_8, data.url_8, data.title_8);
                    } */
                    $("#multiArticle .msg-item").html(strHtml);
                    $("#cph_hfNewsId").val(id);
                }
            });
        }

        function GetItemHtml(n, img, url, title) {
            var strHtml = "";
            if (title != "") {
                strHtml += "<div class='rel sub-msg-item appmsgItem'>";
                strHtml += "    <div class='thumb'>";
                strHtml += "        <img src='" + img + "' class='i-img'>";
                strHtml += "    </div>";
                strHtml += "    <h4 class='msg-t'>";
                strHtml += "        <a href='" + url + "' target='_blank' class='i-title'>" + decodeURIComponent(title) + "</a>";
                strHtml += "    </h4>";
                strHtml += "</div>";
            }
            return strHtml;
        }
        //===========end图文详情============
        function ArticleShow_onclick() {

        }


    </script>



		<div id="message-reshow" style="display: none;">信息</div>
		<script type="text/javascript">
        function Message_show() { $(".message-tip").slideDown("slow"); $("#message-reshow").hide(); }
        function Message_hide() { $(".message-tip").slideUp("slow"); $("#message-reshow").show(); }
        $(function () {
            //            Message_hide();
            //            $("#close").click(function () {
            //                Message_hide();
            //            })
            //            $("#message-reshow").click(function () {
            //                Message_show();
            //            })
        }) 
    </script>
	</form>
	<script type="text/javascript">
        /* $(window).ready(function () {
            GetSubmain_H()
        });
        window.onresize = function () {
            GetSubmain_H()
        }
        function GetSubmain_H() {

            //            $("#bodyBg").css("height", "100%");
            //            var h = $(document).height();
            //            if (document.documentElement.clientHeight > $(document).height()) {
            //                h = document.documentElement.clientHeight;
            //            }
            //            $("#bodyBg").css("height", h);

            var box_H = (document.getElementById("box_main").offsetHeight);
            $("#submain").css("height", document.documentElement.clientHeight - box_H - 70);
            $("#submain").css("width", document.documentElement.clientWidth - 80);

        } */
    </script>
	<div
		class="ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-dialog-buttons ui-draggable"
		tabindex="-1" role="dialog" aria-describedby="hyperlink"
		aria-labelledby="ui-id-1" style="display: none;">
		<div
			class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix">
			<span id="ui-id-1" class="ui-dialog-title">插入超链接</span>
			<button
				class="ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close"
				role="button" aria-disabled="false" title="close">
				<span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span><span
					class="ui-button-text">close</span>
			</button>
		</div>
		<div id="hyperlink"
			class="display_none ui-dialog-content ui-widget-content"
			style="display: block;">
			<div class="top">
				<p>文本内容：</p>
				<div contenteditable="true" id="txtCon" class="Link_Con"></div>
			</div>
			<div class="top">
				<p>链接地址：</p>
				<input id="txtUrl" type="text" class="input400" value="" />
			</div>
		</div>
		<div class="ui-dialog-buttonpane ui-widget-content ui-helper-clearfix">
			<div class="ui-dialog-buttonset">
				<button type="button"
					class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"
					role="button" aria-disabled="false">
					<span class="ui-button-text">确定</span>
				</button>
				<button type="button"
					class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"
					role="button" aria-disabled="false">
					<span class="ui-button-text">取消</span>
				</button>
			</div>
		</div>
	</div>
	<div
		class="ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-dialog-buttons ui-draggable ui-resizable"
		tabindex="-1" role="dialog" aria-describedby="ArticleListShow"
		aria-labelledby="ui-id-2" style="display: none; position: absolute;">
		<div
			class="ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix">
			<span id="ui-id-2" class="ui-dialog-title">选择图文消息</span>
			<button
				class="ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close"
				role="button" aria-disabled="false" title="close">
				<span class="ui-button-icon-primary ui-icon ui-icon-closethick"></span><span
					class="ui-button-text">close</span>
			</button>
		</div>
		<div id="ArticleListShow"
			class="display_none ui-dialog-content ui-widget-content"
			style="display: block;">
			<h3 class="page-sub-hd">
				图文列表<span id="PageInfo"></span>
			</h3>
			<div class="page top"></div>
			<ul class="allArticles">
			</ul>
		</div>
		<div class="ui-dialog-buttonpane ui-widget-content ui-helper-clearfix">
			<div class="ui-dialog-buttonset">
				<button type="button"
					class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"
					role="button" aria-disabled="false">
					<span class="ui-button-text">确定</span>
				</button>
				<button type="button"
					class="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only"
					role="button" aria-disabled="false">
					<span class="ui-button-text">取消</span>
				</button>
			</div>
		</div>
		<div class="ui-resizable-handle ui-resizable-n" style="z-index: 90;"></div>
		<div class="ui-resizable-handle ui-resizable-e" style="z-index: 90;"></div>
		<div class="ui-resizable-handle ui-resizable-s" style="z-index: 90;"></div>
		<div class="ui-resizable-handle ui-resizable-w" style="z-index: 90;"></div>
		<div
			class="ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se"
			style="z-index: 90;"></div>
		<div class="ui-resizable-handle ui-resizable-sw" style="z-index: 90;"></div>
		<div class="ui-resizable-handle ui-resizable-ne" style="z-index: 90;"></div>
		<div class="ui-resizable-handle ui-resizable-nw" style="z-index: 90;"></div>
	</div>
</body>
</html>

