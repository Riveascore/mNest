package com.company.project

class TwitchTagLib {
	def twitchStream = {attrs->
		def videoKey = attrs['videoKey']
		def height = "378", width = "620"
		def vd = {
			object(
				type:"application/x-shockwave-flash", 
				height:"378", width:"620", 
				data:"http://www.twitch.tv/widgets/live_embed_player.swf?channel=${videoKey}&auto_play=true"){
				param(name:"allowFullScreen", value:"true")
				param(name:"allowNetworking", value:"all")
				param(name:"movie", value:"http://www.twitch.tv/widgets/live_embed_player.swf")
			}
		}
		def xml = new groovy.xml.StreamingMarkupBuilder().bind(vd)
		def divOpening = "<div class = 'furniture' id='twitch_stream_${videoKey}' height='${height}' width='${width}'>"
		def moveable = "<script type='text/javascript'> \$('#twitch_stream_${videoKey}').show(); \$('#twitch_stream_${videoKey}').draggable() </script>"
		out << "${divOpening}${xml}</div>${moveable}"
	}
}