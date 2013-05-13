package com.company.project

class TwitchStreamTagLib {

	def twitchOld={ attrs->
		def videoKey = attrs['videoKey']
		def vd = {
			object(
			height:"378", width:"620",
			data:"http://www.twitch.tv/widgets/live_embed_player.swf?channel=${videoKey}")
			{
				param(name:"movie", value:"http://www.twitch.tv/widgets/live_embed_player.swf")
				param(name:"allowFullScreen", value:"true")
				param(name:"allowScriptAccess", value:"always")
				param(name:"allowNetworking", value:"all")
//				param(name:"flashvars", value:"hostname=www.twitch.tv&channel=${videoKey}&auto_play=true&start_volume=25")
				embed(
					src:"hostname=www.twitch.tv&channel=${videoKey}&auto_play=true&start_volume=25", 
					type:"application/x-shockwave-flash",
					allowscriptaccess:"always",
					allowfullscreen:"true",
					width:"${attrs['width']?:'620'}", height:"${attrs['height']?:'378'}")
			}

			def xml = new groovy.xml.StreamingMarkupBuilder().bind(vd)
			out << xml
		}
	}
}