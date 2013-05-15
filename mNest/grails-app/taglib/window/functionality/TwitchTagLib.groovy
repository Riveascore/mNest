package window.functionality

class TwitchTagLib {
	def twitchStream = {attrs->
		def videoKey = attrs['videoKey']
		def vd = {
			object(
				type:"application/x-shockwave-flash", 
				class:"twitchVideoObject",
				data:"http://www.twitch.tv/widgets/live_embed_player.swf?channel=${videoKey}&auto_play=true"
				){
				param(name:"allowFullScreen", value:"true")
				param(name:"allowNetworking", value:"all")
				param(name:"movie", value:"http://www.twitch.tv/widgets/live_embed_player.swf")
			}
		}
		
		//"${divOpening}${xml}</div><script type='text/javascript'>${draggable}${resizeablePerserveAspect}</script>"
		
		def xml = new groovy.xml.StreamingMarkupBuilder().bind(vd)
		def divOpening = "<div class = 'twitchVideo' id='twitch_stream_${videoKey}'>"
		def draggable = "\$('#twitch_stream_${videoKey}').draggable();"
		def resizable = "\$('#twitch_stream_${videoKey}').resizable();"
		def resizeablePerserveAspect = "\$('#twitch_stream_${videoKey}').resizable({aspectRatio: 622 / 380});"
		out << "${divOpening}${xml}</div>"
	}
}