<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
* {
	box-sizing: border-box;
}

html, body {
	height: 100%;
}

body {
	background: black;
	min-height: 100%;
	font-family: "Arial", sans-serif;
}

.wrap {
  position: relative;
  height: 100%;
  min-height: 500px;
  padding-bottom: 20px;
}

.game {
	transform-style: preserve-3d;
	perspective: 500px;
	min-height: 100%;
  height: 100%;
}

@mixin width($max){
	@media (max-width: $max){
		@content;
	}
}

@keyframes matchAnim {
	0% {
		background: #bcffcc;
	}
	100% {
		background: white;
	}
}

.card {
  float: left;
  width: 16.66666%;
  height: 25%;
  padding: 5px;
  text-align: center;
	display: block;
	perspective: 500px;
	position: relative;
	cursor: pointer;
  z-index: 50; 
	-webkit-tap-highlight-color: rgba(0,0,0,0);  
	@include width(800px){
		width: 25%;
		height: 16.666%;
	}
	.inside {
		width: 100%;
		height: 100%;
		display: block;
		transform-style: preserve-3d;
		transition: .4s ease-in-out;
		background: white;

		&.picked, &.matched {
			transform: rotateY(180deg);
		}
		&.matched {
			animation: 1s matchAnim ease-in-out;
			animation-delay: .4s;
		}
	}

  .front, .back {
  	border: 1px solid black;
  	backface-visibility: hidden;
  	position: absolute;
  	top: 0;
  	left: 0;
  	width: 100%;
  	height: 100%;
  	padding: 20px;

  	img {
  		max-width: 100%;
  		display: block;
  		margin: 0 auto;
  		max-height: 100%;
  	}
  }
  .front {
  	transform: rotateY(-180deg);
  	@include width(800px){
  		padding: 5px;
  	}
  }
  .back{
		transform: rotateX(0); // fix firefox backface-visibility.
		@include width(800px){
  		padding: 10px;
  	}
  }
}

.modal-overlay {
	display: none;
	background: rgba(0,0,0,.8);
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}

.modal {
	display: none;
	position: relative;
	width: 500px;
	height: 400px;
	max-height: 90%;
	max-width: 90%;
	min-height: 380px;
	margin: 0 auto;
	background: white;
	top: 50%;
	transform: translateY(-50%);
	padding: 30px 10px;
	.winner {
		font-size: 80px;
		text-align: center;
		font-family: "Anton", sans-serif;
		color: #4d4d4d;
		text-shadow: 0px 3px 0 black;
		@include width(480px){
			font-size: 60px;
		}
	}
	.restart {
		font-family: "Anton", sans-serif;
		margin: 30px auto;
		padding: 20px 30px;
		display: block;
		font-size: 30px;
		border: none;
		background: #4d4d4d;
		background: linear-gradient(#4d4d4d, #222);
		border: 1px solid #222;
		border-radius: 5px;
		color: white;
		text-shadow: 0px 1px 0 black;
		cursor: pointer;
		&:hover {
			background: linear-gradient(#222, black);
		}
	}
	.message {
		text-align: center;
		a {
			text-decoration: none;
			color: #28afe6;
			font-weight: bold;
			&:hover {
				$c: lighten(#28afe6, 10%);
				color: $c;
				border-bottom: 1px dotted $c;
			}
		}
	}
	.share-text {
		text-align: center;
		margin: 10px auto;
	}
	.social {
		margin: 20px auto;
		text-align: center;
		li {
			display: inline-block;
			height: 50px;
			width: 50px;
			margin-right: 10px;
			&:last-child {
				margin-right: 0;
			}
			a {
				display: block;
				line-height: 50px;
				font-size: 20px;
				color: white;
				text-decoration: none;
				border-radius: 5px;
				&.facebook {
					background: #3b5998;
					&:hover {
						background: lighten(#3b5998, 10%);
					}
				}
				&.google {
					background: #D34836;
					&:hover {
						background: lighten(#D34836, 10%);
					}
				}
				&.twitter {
					background: #4099FF;
					&:hover {
						background: lighten(#4099FF, 10%);
					}
				}
			}
		}
	}
}

footer {
	height: 20px;
	position: absolute;
	bottom: 0;
	width: 100%;
  z-index: 0;
	.disclaimer {
		line-height: 20px;
		font-size: 12px;
		color: #727272;
		text-align: center;
		@include width(767px){
			font-size: 8px;
		}
	}
}
</style>
<body>
<div class="wrap">
<div class="game"></div>
	
	<div class="modal-overlay">
		<div class="modal">
			<h2 class="winner">You Rock!</h2>
			<button class="restart">Play Again?</button>
			<p class="message">Developed on <a href="https://codepen.io">CodePen</a> by <a href="https://codepen.io/natewiley">Nate Wiley</a></p>
			<p class="share-text">Share it?</p>
			<ul class="social">
				<li><a target="_blank" class="twitter" href="https://twitter.com/share?url=https://codepen.io/natewiley/pen/HBrbL"><span class="fa fa-twitter"></span></a></li>
				<li><a target="_blank" class="facebook" href="https://www.facebook.com/sharer.php?u=https://codepen.io/natewiley/pen/HBrbL"><span class="fa fa-facebook"></span></a></li>
				<li><a target="_blank" class="google" href="https://plus.google.com/share?url=https://codepen.io/natewiley/pen/HBrbL"><span class="fa fa-google"></span></a></li>
			</ul>
		</div>
	</div>
  <footer>
		<p class="disclaimer">All logos are property of their respective owners, No Copyright infringement intended.</p>
	</footer>
  </div><!-- End Wrap -->
  
  

</body>

<script>
//Memory Game
//© 2014 Nate Wiley
//License -- MIT
//best in full screen, works on phones/tablets (min height for game is 500px..) enjoy ;)
//Follow me on Codepen

(function(){
	
	var Memory = {

		init: function(cards){
			this.$game = $(".game");
			this.$modal = $(".modal");
			this.$overlay = $(".modal-overlay");
			this.$restartButton = $("button.restart");
			this.cardsArray = $.merge(cards, cards);
			this.shuffleCards(this.cardsArray);
			this.setup();
		},

		shuffleCards: function(cardsArray){
			this.$cards = $(this.shuffle(this.cardsArray));
		},

		setup: function(){
			this.html = this.buildHTML();
			this.$game.html(this.html);
			this.$memoryCards = $(".card");
			this.paused = false;
  	this.guess = null;
			this.binding();
		},

		binding: function(){
			this.$memoryCards.on("click", this.cardClicked);
			this.$restartButton.on("click", $.proxy(this.reset, this));
		},
		// kinda messy but hey
		cardClicked: function(){
			var _ = Memory;
			var $card = $(this);
			if(!_.paused && !$card.find(".inside").hasClass("matched") && !$card.find(".inside").hasClass("picked")){
				$card.find(".inside").addClass("picked");
				if(!_.guess){
					_.guess = $(this).attr("data-id");
				} else if(_.guess == $(this).attr("data-id") && !$(this).hasClass("picked")){
					$(".picked").addClass("matched");
					_.guess = null;
				} else {
					_.guess = null;
					_.paused = true;
					setTimeout(function(){
						$(".picked").removeClass("picked");
						Memory.paused = false;
					}, 600);
				}
				if($(".matched").length == $(".card").length){
					_.win();
				}
			}
		},

		win: function(){
			this.paused = true;
			setTimeout(function(){
				Memory.showModal();
				Memory.$game.fadeOut();
			}, 1000);
		},

		showModal: function(){
			this.$overlay.show();
			this.$modal.fadeIn("slow");
		},

		hideModal: function(){
			this.$overlay.hide();
			this.$modal.hide();
		},

		reset: function(){
			this.hideModal();
			this.shuffleCards(this.cardsArray);
			this.setup();
			this.$game.show("slow");
		},

		// Fisher--Yates Algorithm -- https://bost.ocks.org/mike/shuffle/
		shuffle: function(array){
			var counter = array.length, temp, index;
	   	// While there are elements in the array
	   	while (counter > 0) {
     	// Pick a random index
     	index = Math.floor(Math.random() * counter);
     	// Decrease counter by 1
     	counter--;
     	// And swap the last element with it
     	temp = array[counter];
     	array[counter] = array[index];
     	array[index] = temp;
	    	}
	    	return array;
		},

		buildHTML: function(){
			var frag = '';
			this.$cards.each(function(k, v){
				frag += '<div class="card" data-id="'+ v.id +'"><div class="inside">\
				<div class="front"><img src="'+ v.img +'"\
				alt="'+ v.name +'" /></div>\
				<div class="back"><img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/74196/codepen-logo.png"\
				alt="Codepen" /></div></div>\
				</div>';
			});
			return frag;
		}
	};

	var cards = [
		{
			name: "php",
			img: "https://s3-us-west-2.amazonaws.com/s.cdpn.io/74196/php-logo_1.png",
			id: 1,
		},
		{
			name: "css3",
			img: "https://s3-us-west-2.amazonaws.com/s.cdpn.io/74196/css3-logo.png",
			id: 2
		},
		{
			name: "html5",
			img: "https://s3-us-west-2.amazonaws.com/s.cdpn.io/74196/html5-logo.png",
			id: 3
		},
		{
			name: "jquery",
			img: "https://s3-us-west-2.amazonaws.com/s.cdpn.io/74196/jquery-logo.png",
			id: 4
		}, 
		{
			name: "javascript",
			img: "https://s3-us-west-2.amazonaws.com/s.cdpn.io/74196/js-logo.png",
			id: 5
		},
		{
			name: "node",
			img: "https://s3-us-west-2.amazonaws.com/s.cdpn.io/74196/nodejs-logo.png",
			id: 6
		},
		{
			name: "photoshop",
			img: "https://s3-us-west-2.amazonaws.com/s.cdpn.io/74196/photoshop-logo.png",
			id: 7
		},
		{
			name: "python",
			img: "https://s3-us-west-2.amazonaws.com/s.cdpn.io/74196/python-logo.png",
			id: 8
		},
		{
			name: "rails",
			img: "https://s3-us-west-2.amazonaws.com/s.cdpn.io/74196/rails-logo.png",
			id: 9
		},
		{
			name: "sass",
			img: "https://s3-us-west-2.amazonaws.com/s.cdpn.io/74196/sass-logo.png",
			id: 10
		},
		{
			name: "sublime",
			img: "https://s3-us-west-2.amazonaws.com/s.cdpn.io/74196/sublime-logo.png",
			id: 11
		},
		{
			name: "wordpress",
			img: "https://s3-us-west-2.amazonaws.com/s.cdpn.io/74196/wordpress-logo.png",
			id: 12
		},
	];
 
	Memory.init(cards);


})();
</script>

</html>