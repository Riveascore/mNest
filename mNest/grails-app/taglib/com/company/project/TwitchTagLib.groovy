package com.company.project

class TwitchTagLib {
	def twitchStream = {attrs->
		def videoKey = attrs['videoKey']
		def vd = {
			object(
				type:"application/x-shockwave-flash", 
				height:"378", width:"620", 
				data:"http://www.twitch.tv/widgets/live_embed_player.swf?channel=${videoKey}&auto_play=true"){
s				param(name:"allowFullScreen", value:"true")
				param(name:"allowScriptAccess", value:"always")
				param(name:"allowNetworking", value:"all")
			}
		}
		def xml = new groovy.xml.StreamingMarkupBuilder().bind(vd)
		out << xml
	}
}