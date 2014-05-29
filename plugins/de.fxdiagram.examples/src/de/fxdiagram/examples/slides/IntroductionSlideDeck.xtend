package de.fxdiagram.examples.slides

import de.fxdiagram.core.services.ImageCache
import de.fxdiagram.lib.simple.OpenableDiagramNode
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Group
import javafx.scene.image.ImageView
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.shape.Polyline

import static extension de.fxdiagram.examples.slides.Styles.*

class IntroductionSlideDeck extends OpenableDiagramNode {
	new() {
		super('Introduction')
		innerDiagram = new SlideDiagram => [
			slides += new Slide('Title') => [ 
				stackPane => [
//					children += new Pane => [
//						setPrefSize(1024, 768)
//						children += createJungleText('GEF', 22) => [
//							fill = jungleDarkGreen							
//							rotate = 340
//							layoutX = 110
//							layoutY = 379
//							breathe
//						]
//						children += createJungleText('Draw2D', 22) => [
//							fill = jungleDarkGreen							
//							rotate = 339
//							layoutX = 405
//							layoutY = 147
//							flicker
//						]
//						children += createJungleText('GMF RT', 22) => [
//							fill = jungleDarkGreen							
//							layoutX = 762
//							layoutY = 61
//							dangle
//						]
//						children += createJungleText('Graphiti', 22) => [
//							fill = jungleDarkGreen							
//							rotate = 11
//							layoutX = 850
//							layoutY = 349
//							breathe
//						]
//						children += createJungleText('Sirius', 22) => [
//							fill = jungleDarkGreen							
//							rotate = 67
//							layoutX = 188
//							layoutY = 229
//							flicker
//						]
//						children += createJungleText('GMF Tooling', 22) => [
//							fill = jungleDarkGreen							
//							layoutX = 595
//							layoutY = 121
//							dangle
//						]
//					]
					children += new VBox => [
						alignment = Pos.CENTER
						StackPane.setMargin(it, new Insets(200, 0, 0, 0))
						children += createText('Eclipse Discovery Channel', 36) => [
							fill = jungleDarkGreen
						]
						children += createText('presents', 30) => [
							fill = jungleDarkGreen
						]
						children += createText('Eclipse Diagram Editors', 93) => [
							fill = Color.rgb(238, 191, 171)
						]
						children += createText('An Endangered Species', 48) => []
					]
				]
			]
			slides += new Slide('The Eclipse Jungle', 110)
			slides += new Slide('Jungle images') => [
				stackPane => [
					children += new Pane => [
						setPrefSize(1024, 768)
						children += createJungleText('GEF', 48) => [
							fill = jungleDarkGreen
							rotate = 16
							layoutX = 80
							layoutY = 665
							flicker
						]
						children += createJungleText('Draw2D', 48) => [
							fill = jungleDarkGreen
							rotate = 338
							layoutX = 380
							layoutY = 132
							crawl
						]
						children += createJungleText('GMF RT', 48) => [
							fill = jungleDarkGreen
							rotate = 10
							layoutX = 560
							layoutY = 300
							crawl
						]
						children += createJungleText('GMF Tooling', 48) => [
							fill = jungleDarkGreen
							rotate = 332
							layoutX = 640
							layoutY = 620
							breathe
						]
						children += createJungleText('Graphiti', 48) => [
							fill = jungleDarkGreen
							layoutX = 111
							layoutY = 167
							dangle
						]
//						children += createJungleText('Sirius', 48) => [
//							fill = jungleDarkGreen
//							rotate = 5
//							layoutX = 190
//							layoutY = 480
//							breathe
//						]
					]
				]
			]
			slides += new Slide('Appearance', 144)
			slides += new ClickThroughSlide('Darkness images') => [
				pane.children += new ImageView => [
					image = ImageCache.get.getImage(this, 'images/darkness1.png')
					layoutX = 45
					layoutY = 45
				]
				pane.children += new ImageView => [
					image = ImageCache.get.getImage(this, 'images/darkness2.png')
					layoutX = 420
					layoutY = 374
				]
			]
			slides += new Slide('Behavior', 144)
			slides += new ClickThroughSlide('Behavior images') => [ 
				pane.children += new ImageView => [
					image = ImageCache.get.getImage(this, 'images/graphiti.png')
					layoutX = 50
					layoutY = 44
				]	
				pane.children += new ImageView => [
					image = ImageCache.get.getImage(this, 'images/properties.png')
					layoutX = 295
					layoutY = 332
				]					
			]
			slides += new Slide('Recycling', 144)
			slides += new ClickThroughSlide('Recycling images') => [ 
				pane => [
					children += new ImageView => [
						image = ImageCache.get.getImage(this, 'images/onion.png')
						fitWidth = 570
						preserveRatio = true
						layoutX = 227
						layoutY = 110
					]
					children += new Group => [
						children += createJungleText('OS', 48) => [
							layoutX = 173
							layoutY = 216
						] 
						children += new Polyline => [
							points += #[ 244.0, 226.0, 537.0, 356.0 ]
							stroke = jungleGreen
							strokeWidth = 2
						]
					]
					children += new Group => [
						children += createJungleText('SWT', 48) => [
							layoutX = 62
							layoutY = 458
						]
						children += new Polyline => [
							points += #[ 176.0, 439.0, 501.0, 367.0]
							stroke = jungleGreen
							strokeWidth = 2
						]
					] 
					children += new Group => [
						children += createJungleText('Draw2D', 48) => [
							layoutX = 129
							layoutY = 666
						] 
						children += new Polyline => [
							points += #[ 307.0, 611.0, 489.0, 433.0 ]
							stroke = jungleGreen
							strokeWidth = 2
						]
					]
					children += new Group => [
						children += createJungleText('GEF MVC', 48) => [
							layoutX = 581
							layoutY = 712
						] 
						children += new Polyline => [
							points += #[ 714.0, 662.0, 588.0, 458.0 ]
							stroke = jungleGreen
							strokeWidth = 2
						]
					]
					children += new Group => [
						children += createJungleText('''
							GMF
							Runtime''', 48) => [
							layoutX = 770
							layoutY = 462
						]
						children += new Polyline => [
							points += #[ 803.0, 462.0, 658.0, 416.0 ]
							stroke = jungleGreen
							strokeWidth = 2
						]
					]
					children += new Group => [
						children += createJungleText('''
							GMF
							Tooling''', 48) => [
							layoutX = 770
							layoutY = 184
						] 
						children += new Polyline => [
							points += #[ 766.0, 206.0, 662.0, 281.0 ]
							stroke = jungleGreen
							strokeWidth = 2
						]
					]
					children += new Group => [
						children += createJungleText('...', 48) => [
							layoutX = 405
							layoutY = 88
						]
						children += new Polyline => [
							points += #[ 519.0, 101.0, 525.0, 188.0 ]
							stroke = jungleGreen
							strokeWidth = 2
						]
					] 
				]
			]
			slides += new Slide('Reproduction', 144)
			slides += new ClickThroughSlide('Reproduction images') => [ 
				pane.children += new ImageView => [
					image = ImageCache.get.getImage(this, 'images/graphiti_code.png')
					layoutX = 43
					layoutY = 41
				]
				pane.children += new VBox => [
					layoutX = 313
					layoutY = 81
					padding = new Insets(5, 5, 5, 5)
					alignment = Pos.CENTER
					style = '''
						-fx-border-color: black;
						-fx-border-width: 1;
						-fx-background-color: rgb(252,228,153);
					'''
					children += createText('34 Files', 36) => [
						fill = Color.BLACK
					]
					children += createText('2730 LOC', 36) => [
						fill = Color.BLACK
					]
				]
				pane.children += new ImageView => [
					image = ImageCache.get.getImage(this, 'images/gmf_dashboard.png')
					layoutX = 284
					layoutY = 406
				]
			]
			slides += new Slide('Endangerment', 144)
			slides += new ClickThroughSlide('Tablet') => [ 
				pane.children += new ImageView => [
					image = ImageCache.get.getImage(this, 'images/tablet.png')
					layoutX = 183
					layoutY = 210
					fitWidth = 587
					preserveRatio = true
				]
				pane.children += new ImageView => [ 
					image = ImageCache.get.getImage(this, 'images/hand.png')
					layoutX = 540
					layoutY = 244
				]
			]
			slides += new Slide('Help') => [ 
				stackPane => [
					children += new VBox => [
						alignment = Pos.CENTER
						spacing = 50
						children += createText('Help Us', 144) => []
						children += createText('save the', 72) => []
						children += createText('Eclipse Diagram Editors', 96) => [
							fill = Color.rgb(238, 191, 171)
						]
					]
				]
			]
			slides += new Slide('What Can We Do?', 96)
			slides += new Slide(
				'''
					We have improve visual design,
					haptic behavior,
					usability,
					and customizability
					in order to save them from extinction.
				''', 48)
			slides += new Slide('JavaFX') => [ 
				stackPane => [
					children += new ImageView => [
						image = ImageCache.get.getImage(this, 'images/javafx.png')
						fitWidth = 587
						preserveRatio = true
					]
				]
			]
		]
	}
}
